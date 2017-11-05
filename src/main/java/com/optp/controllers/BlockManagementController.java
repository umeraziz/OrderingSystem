package com.optp.controllers;

import com.optp.controllers.beans.AreaBean;
import com.optp.controllers.beans.BlockBean;
import com.optp.controllers.beans.SupportBean;
import com.optp.db.entities.Area;
import com.optp.db.entities.Block;
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
@RequestMapping("/block")
public class BlockManagementController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddBlockForm() {
        ModelAndView modelAndView = new ModelAndView("AddBlock");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List blockList = blockList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("blockList", blockList);
        modelAndView.addObject("blockInfo", new BlockBean());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processAddArea(@ModelAttribute("submittedBlockBean") BlockBean submittedBlockBean) {
        ModelAndView modelAndView = new ModelAndView("AddBlock");

        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("SELECT count(*) from Block where upper(blockName) = upper(:blockName)");
        query.setParameter("blockName", submittedBlockBean.getBlockName());

        boolean duplicateChk = ((Long) query.iterate().next()) != 0;
        boolean success = false;

        if (!duplicateChk) {
            Transaction tr = session.beginTransaction();

            Block block = new Block();
            block.setBlockName(submittedBlockBean.getBlockName());
            block.setBlockStatus(true);

            session.persist(block);
            tr.commit();
            success = true;
            modelAndView.addObject("blockInfo", new BlockBean());
        } else {
            modelAndView.addObject("blockInfo", submittedBlockBean);
        }

        List blockList = blockList(session);
        session.close();

        modelAndView.addObject("supportBean", initSupportBean());
        modelAndView.addObject("blockList", blockList);
        modelAndView.addObject("success", success);
        return modelAndView;
    }

    private List blockList(Session session) {
        return session.createQuery("FROM Block").list();
    }

    private SupportBean initSupportBean() {
        SupportBean supportBean = new SupportBean();
        supportBean.setPrimaryActive("definitionManagement");
        supportBean.setSecondaryActive("blockManagement");
        return supportBean;
    }
}
