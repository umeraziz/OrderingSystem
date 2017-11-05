package com.optp.controllers;

import com.optp.controllers.beans.SupportBean;
import com.optp.controllers.beans.UserBean;
import com.optp.db.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getNewUserForm() {
        ModelAndView modelAndView = new ModelAndView("AddUser");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List userList = userList(session);
        List cityList = cityList(session);
        List areaList = areaList(session);
        List blockList = blockList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("areaList", areaList);
        modelAndView.addObject("blockList", blockList);
        modelAndView.addObject("userInfo", new UserBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processUserInfo(@ModelAttribute("submittedUserBean") UserBean submittedUserBean) {
        boolean duplicateChk = false;
        boolean success = false;
        ModelAndView modelAndView = new ModelAndView("AddUser");
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        Query query = session.createQuery("SELECT count(*) from User where upper(email) = upper(:email)");
        query.setParameter("email", submittedUserBean.getEmail());
        duplicateChk = ((Long) query.iterate().next()) != 0;

        if(!duplicateChk) {
            Transaction tr = session.beginTransaction();
            submittedUserBean.setUserStatus(true);
            User user = new User();
            user.setUserName(submittedUserBean.getUserName());
            user.setEmail(submittedUserBean.getEmail());
            user.setPassword(submittedUserBean.getPassword());
            user.setUserStatus(true);
            session.persist(user);
            tr.commit();
            success = true;
            modelAndView.addObject("userInfo", new UserBean());
        } else {
            modelAndView.addObject("userInfo", submittedUserBean);
        }

        List userList = userList(session);
        List cityList = cityList(session);
        List areaList = areaList(session);
        List blockList = blockList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("areaList", areaList);
        modelAndView.addObject("blockList", blockList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView getEditUserInfo(@PathVariable int userId) {
        ModelAndView modelAndView = new ModelAndView("AddUser");

        return modelAndView;
    }

    private List userList(Session session) {
        return session.createQuery("FROM User").list();
    }

    private List cityList(Session session) {
        return session.createQuery("FROM City").list();
    }

    private List areaList(Session session) {
        return session.createQuery("FROM Area").list();
    }

    private List blockList(Session session) {
        return session.createQuery("FROM Block").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("userManagement");
        return supportBean;
    }
}

