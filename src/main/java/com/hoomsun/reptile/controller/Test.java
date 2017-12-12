package com.hoomsun.reptile.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoomsun.reptile.controller.ReptileControl;

@RestController
@RequestMapping(value = "/test")
public class Test {
	
	@Autowired
    private ReptileControl reptileControl;
	
	
	  @RequestMapping(value = "/test")
	public Map<String,Object> test(HttpServletRequest request,String type,int step){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userName", request.getAttribute("userName"));
		params.put("passWord", request.getAttribute("passWord"));
		params.put("uuid", request.getAttribute("uuid"));
		return reptileControl.doRequest(request, type, step, params);
	}
}
