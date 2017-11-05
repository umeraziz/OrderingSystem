package com.optp.controllers;

import com.optp.controllers.beans.ProductBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.Product;
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
@RequestMapping("/product")
public class ProductManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddProductForm() {
        ModelAndView modelAndView = new ModelAndView("AddProduct");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List productList = productList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("productInfo", new ProductBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddCity(@ModelAttribute("submittedProductBean") ProductBean submittedProductBean) {
        boolean duplicateChk;
        boolean success = false;
        ModelAndView modelAndView = new ModelAndView("AddProduct");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from Product where upper(productName) = upper(:productName)");
        query.setParameter("productName", submittedProductBean.getProductName());
        duplicateChk = ((Long) query.iterate().next()) != 0;


        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            Product product = new Product();
            product.setProductName(submittedProductBean.getProductName());
            product.setProductStatus(true);

            session.persist(product);
            tr.commit();
            success = true;
            modelAndView.addObject("productInfo", new ProductBean());
        } else {
            modelAndView.addObject("productInfo", submittedProductBean);
        }

        List productList = productList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    private List productList(Session session) {
        return session.createQuery("FROM Product").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("productManagement");
        return supportBean;
    }
}
