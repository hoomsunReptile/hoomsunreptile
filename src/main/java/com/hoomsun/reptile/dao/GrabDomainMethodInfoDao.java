package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hoomsun.reptile.entity.GrabDomainMethodInfo;

import javax.servlet.http.HttpServletRequest;

@Mapper
public interface GrabDomainMethodInfoDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainBasicId", column = "grab_domain_basic_id"),
            @Result(property = "grabDomainProcedureId", column = "grab_domain_procedure_id"),
            @Result(property = "methodProcedureTotal", column = "method_procedure_total"),
            @Result(property = "methodProcedureItem", column = "method_procedure_item"),
            @Result(property = "methodProcedureItemDescribe", column = "method_procedure_item_describe"),
            @Result(property = "methodProcedureName", column = "method_procedure_name"),
            @Result(property = "methodProcedureDescribe", column = "method_procedure_describe"),
            @Result(property = "methodProcedureInParam", column = "method_procedure_in_param"),
            @Result(property = "methodProcedureOutParamName", column = "method_procedure_out_param_name"),
            @Result(property = "methodProcedureOutParamType", column = "method_procedure_out_param_type"),
            @Result(property = "methodProcedureBody", column = "method_procedure_body"),
            @Result(property = "methodProcedurePackage", column = "method_procedure_package"),
            @Result(property = "methodProcedureClazz", column = "method_procedure_clazz"),
            @Result(property = "methodExistFlag", column = "method_exist_flag"),
            @Result(property = "status", column = "status"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "methodImportPackage", column = "method_import_package"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3"),
    })


    @Select("SELECT * FROM grab_domain_method_info WHERE grab_domain_procedure_id = #{grabDomainProcedureId}")
    List<GrabDomainMethodInfo> getMethodById(int grabDomainProcedureId);

    @Insert( "INSERT INTO grab_domain_method_info ( grab_domain_basic_id, grab_domain_procedure_id, method_count_total," +
            "            method_item, method_item_describe, method_name, method_describe, method_in_param," +
            "            method_out_param_name, method_out_param_type, method_body, method_package, method_clazz," +
            "            method_exist_flag, status, remark, backup_txt1, backup_txt2, backup_txt3, method_import_package)" +
            "            VALUES ( #{grabDomainBasicId}, #{grabDomainProcedureId}, #{methodProcedureTotal}, #{methodProcedureItem}, #{methodProcedureItemDescribe}," +
            "            #{methodProcedureName}, #{methodProcedureDescribe},#{methodProcedureInParam}, #{methodProcedureOutParamName}, #{methodProcedureOutParamType}," +
            "            #{methodProcedureBody},#{methodProcedurePackage}, #{methodProcedureClazz}, #{methodExistFlag},#{status}, #{remark}, #{backupTxt1},#{backupTxt2}," +
            "            #{backupTxt3}, #{methodImportPackage})")
    int postNewMethod(GrabDomainMethodInfo info);

    @Delete("DELETE FROM grab_domain_method_info WHERE id=#{id}")
    void deleteMethodById(String id);

    @Update("update grab_domain_method_info set " +
            "grab_domain_basic_id=#{grabDomainBasicId},grab_domain_procedure_id= #{grabDomainProcedureId}," +
            "method_count_total=#{methodProcedureTotal},method_item=#{methodProcedureItem}," +
            "method_item_describe=#{methodProcedureItemDescribe},method_name=#{methodProcedureName}," +
            "method_describe= #{methodProcedureDescribe},method_in_param=#{methodProcedureInParam}," +
            "method_out_param_name=#{methodProcedureOutParamName},method_out_param_type= #{methodProcedureOutParamType}," +
            "method_body= #{methodProcedureBody},method_package=#{methodProcedurePackage}," +
            "method_clazz=#{methodProcedureClazz},method_exist_flag=#{methodExistFlag},status=#{status}," +
            "remark=#{remark},backup_txt1=#{backupTxt1},backup_txt2=#{backupTxt2},backup_txt3=#{backupTxt3}," +
            "method_import_package=#{methodImportPackage}" +
            " where id=#{id}")
    void putMethodById(GrabDomainMethodInfo info);

}
