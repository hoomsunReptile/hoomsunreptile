package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.service.GrabDomainBasicService;
import com.hoomsun.reptile.service.GrabDomainMethodService;
import com.hoomsun.reptile.service.GrabDomainProcedureService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * GrabDomainBasicController
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Controller
@RequestMapping("GrabDomainBasicController")
public class GrabDomainBasicController {
    @Resource
    private GrabDomainBasicService service;

    /**
     * 新增basicinfo
     *
     * @param request
     * @param basicInfo
     */
    @RequestMapping(value = "postNewBasic", method = RequestMethod.POST)
    public String postNewBasic(HttpServletRequest request, GrabDomainBasicInfo basicInfo) {
        service.postNewBasic(basicInfo);
        return "redirect:getAllBasic";
    }

    /**
     * 根据id删除basic
     *
     * @param request
     * @param id
     */
    @RequestMapping(value = "deleteBasicById", method = RequestMethod.GET)
    public String deleteBasicById(HttpServletRequest request, String id){

        service.deleteBasicById(id);
        return "redirect:getAllBasic";
    }

    /**
     * 根据id修改对应的basic
     *
     * @param request
     * @param basicInfo
     */
    @RequestMapping(value = "putBasicById", method = RequestMethod.POST)
    public String putBasicById(HttpServletRequest request, GrabDomainBasicInfo basicInfo) {
        service.putBasicById(basicInfo);
        return "redirect:getAllBasic";
    }

    /**
     * 根据id获得basic信息
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "getBasicById", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBasicById(HttpServletRequest request, String id, Model model) {
        GrabDomainBasicInfo basicById = service.getBasicById(id);
        JSONObject jsonObject = JSONObject.fromObject(basicById);
        System.out.println(jsonObject);

        return jsonObject;
    }

    /**
     * 获得所有的basic信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "getAllBasic", method = RequestMethod.GET)
    public String getAllBasic(HttpServletRequest request, Model model) {
        List<GrabDomainBasicInfo> allBasic = service.getAllBasic();
        model.addAttribute("allBasicInfo", allBasic);
        return "putmenu";
    }
}
