package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.service.GrabDomainBasicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("GrabDomainBasicController")
public class GrabDomainBasicController {
    @Resource
    GrabDomainBasicService service;

    @RequestMapping(value = "postNewBasic",method = RequestMethod.POST)
    public void postNewBasic(HttpServletRequest request,GrabDomainBasicInfo basicInfo) {
        service.postNewBasic(basicInfo);
    }
}
