package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.AddMethodInterface;
import com.hoomsun.reptile.entity.ModelBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class AddMehtodService {

    @Autowired
    AddMethodInterface method;

    public List<Map<String, String>> accessPutMenu(HttpServletRequest request, HttpServletResponse response) {
        List<Map<String, String>> maps = method.accessAllMehod();
        System.out.println(maps.toString());
        return maps;
    }

    public String putMenu(HttpServletRequest request, HttpServletResponse response, ModelBean bean) {
        method.insertMenu(bean);
        return "hehe";
    }

    public  Map<String, String> editMenuById(HttpServletRequest request,String menuId){
        Map<String, String> stringStringMap = method.selectMenuById(menuId);
        return stringStringMap;
    }
}
