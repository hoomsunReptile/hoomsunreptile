package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

import com.hoomsun.reptile.service.GrabDomainProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("GrabDomainProcedureController")
public class GrabDomainProcedureController {

    @Autowired
    GrabDomainProcedureService procedureService;

    @RequestMapping(value = "postNewProcedure",method = RequestMethod.POST)
    public void postNewProcedure(GrabDomainProcedureInfo procedureInfo){
        procedureService.postNewProcedure(procedureInfo);
    }
}
