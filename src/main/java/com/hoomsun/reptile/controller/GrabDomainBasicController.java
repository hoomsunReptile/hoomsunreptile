package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.service.GrabDomainBasicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("GrabDomainBasicController")
public class GrabDomainBasicController {
    @Resource
    GrabDomainBasicService service;

    /**
     * 新增basicinfo
     * @param request
     * @param basicInfo
     */
    @RequestMapping(value = "postNewBasic",method = RequestMethod.POST)
    public void postNewBasic(HttpServletRequest request,GrabDomainBasicInfo basicInfo) {
        service.postNewBasic(basicInfo);
    }

    /**
     * 根据id删除basic
     * @param request
     * @param id
     */
    @RequestMapping(value = "deleteBasicById",method =RequestMethod.POST)
    public void deleteBasicById(HttpServletRequest request,String id){
        service.deleteBasicById(id);
    }

    /**
     * 根据id修改对应的basic
     * @param request
     * @param basicInfo
     */
    @RequestMapping(value = "putBasicById",method = RequestMethod.POST)
    public void putBasicById(HttpServletRequest request,GrabDomainBasicInfo basicInfo){
        service.putBasicById(basicInfo);
    }

    /**
     * 根据id获得basic信息
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "getBasicById",method = RequestMethod.POST)
    public GrabDomainBasicInfo getBasicById(HttpServletRequest request,String id){
        return service.getBasicById(id);
    }

    /**
     * 获得所有的basic信息
     * @param request
     * @return
     */
    @RequestMapping(value = "getAllBasic",method = RequestMethod.POST)
    public List<GrabDomainBasicInfo> getAllBasic(HttpServletRequest request){
        return service.getAllBasic();
    }
}
