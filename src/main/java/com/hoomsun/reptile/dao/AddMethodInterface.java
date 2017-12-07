package com.hoomsun.reptile.dao;

import com.hoomsun.reptile.entity.ModelBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddMethodInterface {

    @Select("select * from grab_domain_basic_info")
    public List<Map<String,String>> accessAllMehod();

    /**
     * 新增模块
     * @param bean
     */
    @Insert("Insert into grab_domain_basic_info(grab_domain_cn_describe,grab_domain_en_describe,grab_domain_login_address," +
            "login_in_param,control_flag,keyboard_flag,remark) values(#{bean.categoryNameCN},#{bean.categoryNameEN}," +
            "#{bean.categoryCollectionUrl},#{bean.processParameters},#{bean.positioningControl},#{bean.keyBoard},#{bean.modelDescribe})")
    public void insertMenu(@Param("bean") ModelBean bean);

    @Select("select * from grab_domain_basic_info where id=#{0}")
    public Map<String,String> selectMenuById(String menuId);

}
