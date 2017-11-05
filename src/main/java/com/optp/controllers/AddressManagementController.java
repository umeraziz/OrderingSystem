package com.optp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/address")
public class AddressManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddAddressForm() {
        ModelAndView modelAndView = new ModelAndView("workInProgress");
        return modelAndView;
    }
}
