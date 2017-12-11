package com.hoomsun.reptile.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoomsun.reptile.service.LoginService;

@RestController
@RequestMapping(value = "/loginAuthentication")
public class LoginControl {
	
    @Autowired
    private LoginService loginService;
    @ResponseBody
    @RequestMapping(value = "/tests")
    public String  tests() throws Exception{
    

    	return "1231";
    }
    
    @RequestMapping(value = "/doLogin")
    public Map<String,Object> doLogin(String type,String userName,String password,String uuid) throws Exception{
    	Map<String,Object> params = new HashMap<String, Object>();
    	params.put("userName", userName);
    	params.put("password", password);
    	params.put("uuid", uuid);

    	return loginService.doLogin(type,params);
    }
    
    
    
    
    

	
}
