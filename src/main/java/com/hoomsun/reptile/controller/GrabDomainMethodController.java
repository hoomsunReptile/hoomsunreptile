package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.service.GrabDomainMethodService;
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
 * GrabDomainMethodController
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Controller
@RequestMapping("GrabDomainMethodController")
public class GrabDomainMethodController {

    @Autowired
    GrabDomainMethodService service;

    /**
     * 新增方法
     *
     * @param request
     * @param methodDao
     */
    @RequestMapping(value = "postNewMethod", method = RequestMethod.POST)
    public String postNewMethod(HttpServletRequest request, GrabDomainMethodInfo methodDao) {
        service.postNewMethod(methodDao);
        return "redirect:getMethodById?grabDomainProcedureId="+methodDao.getGrabDomainProcedureId();
    }

    /**
     * 根据id删除某个方法
     *
     * @param request
     * @param id
     */
    @RequestMapping(value = "deleteMethodById", method = RequestMethod.GET)
    public String deleteMethodById(HttpServletRequest request, String id,String grabDomainProcedureId) {
        service.deleteMethodById(id);
        return "redirect:getMethodById?grabDomainProcedureId="+grabDomainProcedureId;
    }

    /**
     * 根据procedureId删除方法
     *
     * @param request
     * @param grabDomainProcedureId
     */
    @RequestMapping(value = "deleteMethodByProcedureId", method = RequestMethod.POST)
    public void deleteMethodByProcedureId(HttpServletRequest request, String grabDomainProcedureId) {
        service.deleteMethodByProcedureId(grabDomainProcedureId);
    }

    /**
     * 根据id对方法进行修改
     * id和修改后的信息皆封装到bean中
     *
     * @param info
     */
    @RequestMapping(value = "putMethodById", method = RequestMethod.POST)
    public String putMethodById(HttpServletRequest request, GrabDomainMethodInfo info) {

        service.putMethodById(info);
        return "redirect:getMethodById?grabDomainProcedureId="+info.getGrabDomainProcedureId();
    }

    /**
     * 根据步骤id查询对应的所有方法
     *
     * @param request
     * @param grabDomainProcedureId
     * @return
     */
    @RequestMapping(value = "getMethodById", method = RequestMethod.GET)
    public String getMethodById(HttpServletRequest request, int grabDomainProcedureId, Model model) {
        List<GrabDomainMethodInfo> methodById = service.getMethodById(grabDomainProcedureId);
        model.addAttribute("grabDomainProcedureId",grabDomainProcedureId);
        model.addAttribute("methodInfoList",methodById);
        return "methodbyprocedure";
    }

    /**
     * 根据方法id获取对应的方法信息
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value="getMehodByMehodId",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getMehodByMehodId(HttpServletRequest request,String id){
        GrabDomainMethodInfo mehodByMehodId = service.getMehodByMehodId(id);
        JSONObject jsonObject = JSONObject.fromObject(mehodByMehodId);
        return jsonObject;
    }
}
