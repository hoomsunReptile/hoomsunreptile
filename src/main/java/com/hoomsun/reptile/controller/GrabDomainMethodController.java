package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.service.GrabDomainMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public void postNewMethod(HttpServletRequest request, GrabDomainMethodInfo methodDao) {
        service.postNewMethod(methodDao);
    }

    /**
     * 根据id删除某个方法
     *
     * @param request
     * @param id
     */
    @RequestMapping(value = "deleteMethodById", method = RequestMethod.POST)
    public void deleteMethodById(HttpServletRequest request, String id) {
        service.deleteMethodById(id);
    }

    /**
     * 根据id对方法进行修改
     * id和修改后的信息皆封装到bean中
     *
     * @param info
     */
    @RequestMapping(value = "putMethodById", method = RequestMethod.POST)
    public void putMethodById(HttpServletRequest request, GrabDomainMethodInfo info) {
        service.putMethodById(info);
    }

    /**
     * 根据步骤id查询对应的所有方法
     * @param request
     * @param grabDomainProcedureId
     * @return
     */
    @RequestMapping(value = "getMethodById", method = RequestMethod.POST)
    public List<GrabDomainMethodInfo> getMethodById(HttpServletRequest request,int grabDomainProcedureId) {
        return service.getMethodById(grabDomainProcedureId);
    }
}
