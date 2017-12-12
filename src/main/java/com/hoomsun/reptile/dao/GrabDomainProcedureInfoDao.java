package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

/**
 * GrabDomainProcedureInfoDao
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Mapper
public interface GrabDomainProcedureInfoDao {


    /**
     *根据基本信息id获取对应的步骤信息
     * @param grabDomainBasicId
     * @return  List<GrabDomainProcedureInfo>
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainBasicId", column = "grab_domain_basic_id"),
            @Result(property = "grabDomainProcedureItem", column = "grab_domain_procedure_item"),
            @Result(property = "grabDomainProcedureName", column = "grab_domain_procedure_name"),
            @Result(property = "grabDomainProcedureDescribe", column = "grab_domain_procedure_describe"),
            @Result(property = "grabDomainProcedureInParam", column = "grab_domain_procedure_in_param"),
            @Result(property = "grabDomainProcedureOutParamName", column = "grab_domain_procedure_out_param_name"),
            @Result(property = "grabDomainProcedureOutParamType", column = "grab_domain_procedure_out_param_type"),
            @Result(property = "grabDomainProcedurePackage", column = "grab_domain_procedure_package"),
            @Result(property = "grabDomainProcedureClazz", column = "grab_domain_procedure_clazz"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3")
    })

    @Select("SELECT * FROM grab_domain_procedure_info WHERE grab_domain_basic_id = #{grabDomainBasicId} order by grab_domain_procedure_item asc")
    List<GrabDomainProcedureInfo> getProcedureById(int grabDomainBasicId);

    /**
     * 新增步骤信息
     * @param procedureInfo
     */
    @Insert("INSERT INTO grab_domain_procedure_info" +
            "(grab_domain_basic_id, grab_domain_procedure_item, grab_domain_procedure_name, grab_domain_procedure_describe," +
            " grab_domain_procedure_in_param, grab_domain_procedure_out_param_name, grab_domain_procedure_out_param_type, " +
            " grab_domain_procedure_package, grab_domain_procedure_clazz, remark, backup_txt1, backup_txt2, backup_txt3) VALUES " +
            " (#{grabDomainBasicId}, #{grabDomainProcedureItem}, #{grabDomainProcedureName}, #{grabDomainProcedureDescribe}, " +
            " #{grabDomainProcedureInParam}, #{grabDomainProcedureOutParamName}, #{grabDomainProcedureOutParamType},#{grabDomainProcedurePackage}," +
            " #{grabDomainProcedureClazz},#{remark}, #{backupTxt1}, #{backupTxt2},#{backupTxt3})")
    void postNewProcedure(GrabDomainProcedureInfo procedureInfo);

    /**
     * 根据id删除对应步骤
     * @param id
     */
    @Delete("delete from grab_domain_procedure_info where id=#{id}")
    void deleteProcedureById(String id);

    /**
     * 根据id修改步骤信息
     * @param procedureInfo
     */
    @Update("update grab_domain_procedure_info set " +
            "grab_domain_basic_id=#{grabDomainBasicId},grab_domain_procedure_item=#{grabDomainProcedureItem},grab_domain_procedure_name=#{grabDomainProcedureName}," +
            "grab_domain_procedure_describe=#{grabDomainProcedureDescribe},grab_domain_procedure_in_param=#{grabDomainProcedureInParam}," +
            "grab_domain_procedure_out_param_name=#{grabDomainProcedureOutParamName},grab_domain_procedure_out_param_type=#{grabDomainProcedureOutParamType}," +
            "grab_domain_procedure_package=#{grabDomainProcedurePackage},grab_domain_procedure_clazz=#{grabDomainProcedureClazz},remark=#{remark}," +
            "backup_txt1=#{backupTxt1},backup_txt2=#{backupTxt2},backup_txt3=#{backupTxt3} " +
            "where id=#{id} ")
    void putProcedureById(GrabDomainProcedureInfo procedureInfo);

    /**
     * 查询对应id的信息
     * @param id
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainBasicId", column = "grab_domain_basic_id"),
            @Result(property = "grabDomainProcedureItem", column = "grab_domain_procedure_item"),
            @Result(property = "grabDomainProcedureName", column = "grab_domain_procedure_name"),
            @Result(property = "grabDomainProcedureDescribe", column = "grab_domain_procedure_describe"),
            @Result(property = "grabDomainProcedureInParam", column = "grab_domain_procedure_in_param"),
            @Result(property = "grabDomainProcedureOutParamName", column = "grab_domain_procedure_out_param_name"),
            @Result(property = "grabDomainProcedureOutParamType", column = "grab_domain_procedure_out_param_type"),
            @Result(property = "grabDomainProcedurePackage", column = "grab_domain_procedure_package"),
            @Result(property = "grabDomainProcedureClazz", column = "grab_domain_procedure_clazz"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3")
    })
    @Select("select * from grab_domain_procedure_info where id=#{id}")
    public GrabDomainProcedureInfo getProcedureInfoById(String id);
}
