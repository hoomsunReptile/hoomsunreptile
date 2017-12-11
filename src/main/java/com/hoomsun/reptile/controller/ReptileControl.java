package com.hoomsun.reptile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoomsun.reptile.service.ReptileService;


/**
 * 爬虫入口
 * @ClassName: ReptileControl  
 * @Description: 爬虫请求类  
 * @author: xuesongcui
 * @date 2017年12月11日  
 *
 */
@RestController
@RequestMapping(value = "/hoomsun")
public class ReptileControl {
	
    @Autowired
    private ReptileService reptileService;
    
    /**
     * 爬虫请求入口
     * @param type 模板ID，即为抓取域基本信息中的英文描述
     * @param step 第几步，该字段存储在抓取域步骤中的grabDomainProcedureItem字段中
     * @param map 请求入参
     * @return
     */
    @RequestMapping(value = "/reptile")
    public Map<String,Object> doRequest(String type,String step,Map<String,Object> map){

    	return reptileService.doRequest(type,step,map);
    }
    
	
}
