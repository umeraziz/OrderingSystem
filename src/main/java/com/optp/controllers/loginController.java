package com.optp.controllers;

import com.optp.controllers.beans.LoginBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login (@ModelAttribute LoginBean loginBean) {
        boolean userAuth;
        ModelAndView modelAndView = null;

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from User where upper(email) = upper(:email) AND upper(password) = upper(:password)");
        query.setParameter("email", loginBean.getUserName());
        query.setParameter("password", loginBean.getLogPassword());
        userAuth = ((Long) query.iterate().next()) != 0;

        if(userAuth) {
            modelAndView = new ModelAndView("redirect:/adminDashboard");
        } else {
            modelAndView = new ModelAndView("login");
        }
        return modelAndView;
    }
}
