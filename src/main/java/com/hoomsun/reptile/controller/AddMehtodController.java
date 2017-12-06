package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.ModelBean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("AddMehtodController")
public class AddMehtodController {

    @RequestMapping(value = "accessputmenu",method = RequestMethod.GET)
    public String accessPutMenu(HttpServletRequest request, HttpServletResponse response){
            return  "putmenu";
    }

    @RequestMapping(value = "putmenu",method = RequestMethod.POST)
    public String putMenu(HttpServletRequest request, HttpServletResponse response, ModelBean bean){
        System.out.println("新增方法成功");
        System.out.println(bean.toString());
        return  "putmenu";
    }
}
