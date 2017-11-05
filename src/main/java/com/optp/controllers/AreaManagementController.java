package com.optp.controllers;

import com.optp.controllers.beans.AreaBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.Area;
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
@RequestMapping("/area")
public class AreaManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddAreaForm() {
        ModelAndView modelAndView = new ModelAndView("AddArea");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List areaList = areaList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("areaList", areaList);
        modelAndView.addObject("areaInfo", new AreaBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddArea(@ModelAttribute("submittedAreaBean") AreaBean submittedAreaBean) {
        ModelAndView modelAndView = new ModelAndView("AddArea");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from Area where upper(areaName) = upper(:areaName)");
        query.setParameter("areaName", submittedAreaBean.getAreaName());

        boolean duplicateChk = ((Long) query.iterate().next()) != 0;
        boolean success = false;

        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            Area area = new Area();
            area.setAreaName(submittedAreaBean.getAreaName());
            area.setAreaStatus(true);

            session.persist(area);
            tr.commit();
            success = true;
            modelAndView.addObject("areaInfo", new AreaBean());
        } else {
            modelAndView.addObject("areaInfo", submittedAreaBean);
        }

        List areaList = areaList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("areaList", areaList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    private List areaList(Session session) {
        return session.createQuery("FROM Area").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("areaManagement");
        return supportBean;
    }
}
