package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hoomsun.reptile.entity.GrabDomainMethodInfo;

/**
 * GrabDomainMethodInfoDao
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Mapper
public interface GrabDomainMethodInfoDao {

    /**
     *查询对应步骤所拥有的方法
     * @param grabDomainProcedureId
     * @return  List<GrabDomainMethodInfo>
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainBasicId", column = "grab_domain_basic_id"),
            @Result(property = "grabDomainProcedureId", column = "grab_domain_procedure_id"),
            @Result(property = "methodCountTotal", column = "method_count_total"),
            @Result(property = "methodItem", column = "method_item"),
            @Result(property = "methodItemDescribe", column = "method_item_describe"),
            @Result(property = "methodName", column = "method_name"),
            @Result(property = "methodDescribe", column = "method_describe"),
            @Result(property = "methodInParam", column = "method_in_param"),
            @Result(property = "methodOutParamName", column = "method_out_param_name"),
            @Result(property = "methodOutParamType", column = "method_out_param_type"),
            @Result(property = "methodBody", column = "method_body"),
            @Result(property = "methodPackage", column = "method_package"),
            @Result(property = "methodClazz", column = "method_clazz"),
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

    /**
     * 新增方法
     * @param info
     * @return
     */
    @Insert("INSERT INTO grab_domain_method_info ( grab_domain_basic_id, grab_domain_procedure_id, method_count_total," +
            "            method_item, method_item_describe, method_name, method_describe, method_in_param," +
            "            method_out_param_name, method_out_param_type, method_body, method_package, method_clazz," +
            "            method_exist_flag, status, remark, backup_txt1, backup_txt2, backup_txt3, method_import_package)" +
            "            VALUES ( #{grabDomainBasicId}, #{grabDomainProcedureId}, #{methodCountTotal}, #{methodItem}, #{methodItemDescribe}," +
            "            #{methodName}, #{methodDescribe},#{methodInParam}, #{methodOutParamName}, #{methodOutParamType}," +
            "            #{methodBody},#{methodPackage}, #{methodClazz}, #{methodExistFlag},#{status}, #{remark}, #{backupTxt1},#{backupTxt2}," +
            "            #{backupTxt3}, #{methodImportPackage})")
    int postNewMethod(GrabDomainMethodInfo info);

    /**
     * 根据id删除方法
     * @param id
     */
    @Delete("DELETE FROM grab_domain_method_info WHERE id=#{id}")
    void deleteMethodById(String id);

    /**
     * 修改对应的方法信息
     * @param info
     */
    @Update("update grab_domain_method_info set " +
            "grab_domain_basic_id=#{grabDomainBasicId},grab_domain_procedure_id= #{grabDomainProcedureId}," +
            "method_count_total=#{methodCountTotal},method_item=#{methodItem}," +
            "method_item_describe=#{methodItemDescribe},method_name=#{methodName}," +
            "method_describe= #{methodDescribe},method_in_param=#{methodInParam}," +
            "method_out_param_name=#{methodOutParamName},method_out_param_type= #{methodOutParamType}," +
            "method_body= #{methodBody},method_package=#{methodPackage}," +
            "method_clazz=#{methodClazz},method_exist_flag=#{methodExistFlag},status=#{status}," +
            "remark=#{remark},backup_txt1=#{backupTxt1},backup_txt2=#{backupTxt2},backup_txt3=#{backupTxt3}," +
            "method_import_package=#{methodImportPackage}" +
            " where id=#{id}")
    void putMethodById(GrabDomainMethodInfo info);

}
