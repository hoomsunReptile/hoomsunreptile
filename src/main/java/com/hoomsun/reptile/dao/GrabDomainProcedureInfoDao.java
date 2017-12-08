package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

@Mapper
public interface GrabDomainProcedureInfoDao {


    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainBasicId", column = "grab_domain_basic_id"),
            @Result(property = "grabDomainProcedureItem", column = "grab_domain_procedure_item"),
            @Result(property = "grabDomainMethodName", column = "grab_domain_method_name"),
            @Result(property = "grabDomainMethodDescribe", column = "grab_domain_method_describe"),
            @Result(property = "grabDomainMethodInParam", column = "grab_domain_method_in_param"),
            @Result(property = "grabDomainMethodOutParamName", column = "grab_domain_method_out_param_name"),
            @Result(property = "grabDomainMethodOutParamType", column = "grab_domain_method_out_param_type"),
            @Result(property = "grabDomainMethodPackage", column = "grab_domain_method_package"),
            @Result(property = "grabDomainMethodClazz", column = "grab_domain_method_clazz"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1")
    })


    @Select("SELECT * FROM grab_domain_procedure_info WHERE grab_domain_basic_id = #{grabDomainBasicId} order by grab_domain_procedure_item asc")
    List<GrabDomainProcedureInfo> get(int grabDomainBasicId);

    @Insert("INSERT INTO grab_domain_procedure_info" +
            "(id, grab_domain_basic_id, grab_domain_procedure_item, grab_domain_method_name, grab_domain_method_describe," +
            " grab_domain_method_in_param, grab_domain_method_out_param_name, grab_domain_method_out_param_type, " +
            " grab_domain_method_package, grab_domain_method_clazz, remark, backup_txt1, backup_txt2, backup_txt3) VALUES " +
            " (#{grabDomainBasicId}, #{grabDomainProcedureItem}, #{grabDomainMethodName}, #{grabDomainMethodDescribe}, " +
            " #{grabDomainMethodInParam}, #{grabDomainMethodInParam}, #{grabDomainMethodOutParamName},#{grabDomainMethodOutParamType}," +
            " #{grabDomainMethodPackage},#{grabDomainMethodClazz}, #{remark}, #{backupTxt1}, #{backupTxt2},#{backupTxt3})")
    void postNewProcedure(GrabDomainProcedureInfo procedureInfo);
}
