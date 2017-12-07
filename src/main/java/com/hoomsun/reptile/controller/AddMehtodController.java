package com.hoomsun.reptile.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hoomsun.reptile.entity.ModelBean;
import com.hoomsun.reptile.service.AddMehtodService;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * 新增模块
 */
@Controller
@RequestMapping("AddMehtodController")
public class AddMehtodController {
    static {
        System.out.println("类已经被实例化");
    }
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
}
