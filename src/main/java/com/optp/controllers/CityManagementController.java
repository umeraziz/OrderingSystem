package com.optp.controllers;

import com.optp.controllers.beans.CityBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.City;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/city")
public class CityManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddCityForm() {
        ModelAndView modelAndView = new ModelAndView("AddCity");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List cityList = cityList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("cityInfo", new CityBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddCity(@ModelAttribute("submittedCityBean") CityBean submittedCityBean) {
        ModelAndView modelAndView = new ModelAndView("AddCity");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from City where upper(cityName) = upper(:cityName)");
        query.setParameter("cityName", submittedCityBean.getCityName());

        boolean duplicateChk = ((Long) query.iterate().next()) != 0;
        boolean success = false;

        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            City city = new City();
            city.setCityName(submittedCityBean.getCityName());
            city.setCityStatus(true);

            session.persist(city);
            tr.commit();
            success = true;
            modelAndView.addObject("cityInfo", new CityBean());
        } else {
            modelAndView.addObject("cityInfo", submittedCityBean);
        }

        List cityList = cityList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("cityList", cityList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    @RequestMapping(value = "/{cityId}", method = RequestMethod.GET)
    public ModelAndView editCityInfo(@Valid @ModelAttribute("cityBean") CityBean cityBean) {
        ModelAndView modelAndView = new ModelAndView("AddCity");
//        Session session = new Configuration().configure().buildSessionFactory().openSession();
//        Query<City> query = session.createQuery("FROM City WHERE cityId = :cityId", City.class);
//        City city = (query.list()).get(0);
        return modelAndView;
    }

    private List cityList(Session session) {
        return session.createQuery("FROM City").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("cityManagement");
        return supportBean;
    }
}