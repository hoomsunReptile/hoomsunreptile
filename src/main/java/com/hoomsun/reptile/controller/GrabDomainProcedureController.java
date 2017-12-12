package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

import com.hoomsun.reptile.service.GrabDomainProcedureService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "deleteProcedureById", method = RequestMethod.GET)
    public String deleteProcedureById(HttpServletRequest request, String id,String grabDomainBasicId){
        procedureService.deleteProcedureById(id);
        return "redirect:getProcedureById?grabDomainBasicId="+grabDomainBasicId;
    }

    /**
     * 根据步骤id查询对应的步骤信息
     * @param id
     * @return
     */
    @RequestMapping("getProcedureInfoById")
    @ResponseBody
    public JSONObject getProcedureInfoById(String id){
        GrabDomainProcedureInfo procedureInfoById = procedureService.getProcedureInfoById(id);
        JSONObject jsonObject = JSONObject.fromObject(procedureInfoById);
        return jsonObject;
    }

    /**
     * 根据id修改步骤
     *
     * @param procedureInfo
     */
    @RequestMapping(value = "putProcedureById", method = RequestMethod.POST)
    public String putProcedureById(GrabDomainProcedureInfo procedureInfo) {
        procedureService.putProcedureById(procedureInfo);
        return "redirect:getProcedureById?grabDomainBasicId="+procedureInfo.getGrabDomainBasicId();
    }

    /**
     * 根据模块id查询出所拥有的所有步骤
     *
     * @param grabDomainBasicId
     * @return
     */
    @RequestMapping(value = "getProcedureById", method = RequestMethod.GET)
    public String getProcedureById(HttpServletRequest request, String grabDomainBasicId, Model model) {
        List<GrabDomainProcedureInfo> procedureById = procedureService.getProcedureById(grabDomainBasicId);
        model.addAttribute("grabDomainBasicId",grabDomainBasicId);
        model.addAttribute("procedureById",procedureById);
        return "procedurebybasic";
    }
}
