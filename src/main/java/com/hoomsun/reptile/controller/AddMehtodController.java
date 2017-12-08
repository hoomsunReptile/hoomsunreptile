package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.ModelBean;
import com.hoomsun.reptile.service.AddMehtodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 新增模块
 */
@Controller
@RequestMapping("AddMehtodController")
public class AddMehtodController {
    @Autowired
    private AddMehtodService service;

    /**
     * 查询已有模块
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "accessputmenu", method = RequestMethod.GET)
    public String accessPutMenu(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Map<String, String>> maps = service.accessPutMenu(request, response);
        model.addAttribute("Method_Data", maps);
        return "putmenu";
    }

    /**
     * 新增模块
     *
     * @param request
     * @param response
     * @param bean
     * @return
     */
    @RequestMapping(value = "putmenu", method = RequestMethod.POST)
    public String putMenu(HttpServletRequest request, HttpServletResponse response, ModelBean bean) {
        System.out.println("新增模块中。。。");
        String s = service.putMenu(request, response, bean);
        System.out.println("新增模块完成");
        return "putmenu";
    }

    /**
     *  根据id访问某个模块进行编辑
     */
    @RequestMapping(value = "editMenuById", method = RequestMethod.GET)
    public String editMenuById(HttpServletRequest request,String menuId,Model model){
        Map<String, String> stringStringMap = service.editMenuById(request,menuId);
        System.out.println(stringStringMap);
        model.addAttribute("editMenuById",stringStringMap);
        return "addMethodImp";
    }



}
