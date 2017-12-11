package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

import com.hoomsun.reptile.service.GrabDomainProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * GrabDomainProcedureController
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Controller
@RequestMapping("GrabDomainProcedureController")
public class GrabDomainProcedureController {

    @Autowired
    GrabDomainProcedureService procedureService;

    /**
     * 新增步骤
     *
     * @param procedureInfo
     */
    @RequestMapping(value = "postNewProcedure", method = RequestMethod.POST)
    public String postNewProcedure(GrabDomainProcedureInfo procedureInfo) {
        procedureService.postNewProcedure(procedureInfo);
        return "redirect:getProcedureById?grabDomainBasicId="+procedureInfo.getGrabDomainBasicId();
    }

    /**
     * 根据给定id删除步骤
     *
     * @param id
     */
    @RequestMapping(value = "deleteProcedureById", method = RequestMethod.POST)
    public void deleteProcedureById(HttpServletRequest request, String id) {
        procedureService.deleteProcedureById(id);
    }

    /**
     * 根据id修改步骤
     *
     * @param procedureInfo
     */
    @RequestMapping(value = "putProcedureById", method = RequestMethod.POST)
    public void putProcedureById(GrabDomainProcedureInfo procedureInfo) {
        procedureService.putProcedureById(procedureInfo);
    }

    /**
     * 根据模块id查询出所拥有的所有步骤
     *
     * @param grabDomainBasicId
     * @return
     */
    @RequestMapping(value = "getProcedureById", method = RequestMethod.GET)
    public String getProcedureById(HttpServletRequest request, int grabDomainBasicId, Model model) {
        List<GrabDomainProcedureInfo> procedureById = procedureService.getProcedureById(grabDomainBasicId);
        model.addAttribute("grabDomainBasicId",grabDomainBasicId);
        model.addAttribute("procedureById",procedureById);
        return "procedurebybasic";
    }
}
