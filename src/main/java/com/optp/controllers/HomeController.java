package com.optp.controllers;

import com.optp.controllers.beans.SupportBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping("/adminDashboard")
    public ModelAndView showDashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("dashboard");
        supportBean.setSecondaryActive("adminDashboard");
        modelAndView.addObject("supportBean", supportBean);
        return modelAndView;
    }
}
