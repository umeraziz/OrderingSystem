package com.optp.controllers;

import com.optp.controllers.beans.ProductBean;
import com.optp.controllers.beans.ProductSkuBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.Product;
import com.optp.db.entities.ProductSku;
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
@RequestMapping("/productsku")
public class ProductSkuManagementController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddProductSkuForm() {
        ModelAndView modelAndView = new ModelAndView("AddProductSku");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List productSkuList = productSkuList(session);
        List productList = productList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("productSkuList", productSkuList);
        modelAndView.addObject("productSkuInfo", new ProductSkuBean());
        modelAndView.addObject("productList", productList);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddCity(@ModelAttribute("submittedProductSkuBean") ProductSkuBean submittedProductSkuBean) {
        boolean duplicateChk;
        boolean success = false;
        ModelAndView modelAndView = new ModelAndView("AddProductSku");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from ProductSku where upper(productSkuCode) = upper(:productSkuCode)");
        query.setParameter("productSkuCode", submittedProductSkuBean.getProductSkuCode());
        duplicateChk = ((Long) query.iterate().next()) != 0;

        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            ProductSku productSku = new ProductSku();
            productSku.setProductSkuCode(submittedProductSkuBean.getProductSkuCode());
            productSku.setProductSkuPrice(submittedProductSkuBean.getProductSkuPrice());
            productSku.setProductSkuStatus(true);

            session.persist(productSku);
            tr.commit();
            success = true;
            modelAndView.addObject("productSkuInfo", new ProductSkuBean());
        } else {
            modelAndView.addObject("productSkuInfo", submittedProductSkuBean);
        }

        List productSkuList = productSkuList(session);
        List productList = productList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("productSkuList", productSkuList);
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    private List productSkuList(Session session) {
        return session.createQuery("FROM ProductSku ").list();
    }
    private List productList(Session session) {
        return session.createQuery("FROM Product").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("productSkuManagement");
        return supportBean;
    }
}
