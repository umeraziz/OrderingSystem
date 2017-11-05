package com.optp.controllers;

import com.optp.controllers.beans.MenuBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddMenuForm() {
        ModelAndView modelAndView = new ModelAndView("AddMenu");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List menuList = menuList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("menuList", menuList);
        modelAndView.addObject("menuInfo", new MenuBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddCity(@ModelAttribute("submittedMenuBean") MenuBean submittedMenuBean) {
        boolean duplicateChk;
        boolean success = false;

        ModelAndView modelAndView = new ModelAndView("AddMenu");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from Menu where upper(menuTitle) = upper(:menuTitle)");
        query.setParameter("menuTitle", submittedMenuBean.getMenuTitle());
        duplicateChk = ((Long) query.iterate().next()) != 0;

        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            Menu menu = new Menu();
            menu.setMenuTitle(submittedMenuBean.getMenuTitle());
            menu.setMenuSequenceNo(submittedMenuBean.getMenuSequenceNo());
            menu.setMenuStatus(true);

            session.persist(menu);
            tr.commit();
            success = true;
            modelAndView.addObject("menuInfo", new MenuBean());
        } else {
            modelAndView.addObject("menuInfo", submittedMenuBean);
        }

        List menuList = menuList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("menuList", menuList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    private List menuList(Session session) {
        return session.createQuery("FROM Menu").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("menuManagement");
        return supportBean;
    }
}
