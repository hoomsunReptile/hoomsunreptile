package com.hoomsun.reptile.controller;

import com.hoomsun.reptile.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by bigyoung on 2017/12/1
 */
@RestController
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public String show() {
    	 try {
			String aa=null;
			aa.equals("");
		} catch (Exception e) {
		  logger.error( "failed!", e.fillInStackTrace() );
		}
        return userService.show();
    }

    @RequestMapping(value = "/showDao")
    @ResponseBody
    public Object showDao(int age) {
        return userService.showDao(age);
    }

    @RequestMapping(value="/insert")
    public String insert(String name, int age) {
        return userService.insert(name, age);
    }
    @ResponseBody
    @RequestMapping(value="/xmltest")
    public Map<String,String> xmltest() {
    	Map<String,String>map=new HashMap();
    	map.put("UserName","张三");
    	map.put("Age","22");
    	
    	
        return map;
    }
}
