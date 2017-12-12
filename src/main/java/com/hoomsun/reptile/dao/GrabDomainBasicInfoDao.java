package com.hoomsun.reptile.dao;

import org.apache.ibatis.annotations.*;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

/**
 * GrabDomainBasicInfoDao
 *
 * @author mrlu
 * @date 2017/12/9
 */
@Mapper
public interface GrabDomainBasicInfoDao {

    /**
     * 根据给定的英文名称获取对应的模块基本信息
     * @param grabDomainEnDescribe
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainEnDescribe", column = "grab_domain_en_describe"),
            @Result(property = "grabDomainCnDescribe", column = "grab_domain_cn_describe"),
            @Result(property = "grabDomainProcedureTotal", column = "grab_domain_procedure_total"),
            @Result(property = "grabDomainLoginAddress", column = "grab_domain_login_address"),
            @Result(property = "loginInParam", column = "login_in_param"),
            @Result(property = "controlFlag", column = "control_flag"),
            @Result(property = "keyboardFlag", column = "keyboard_flag"),
            @Result(property = "status", column = "status"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3")
    })

    @Select("SELECT * FROM grab_domain_basic_info WHERE grab_domain_en_describe = #{grabDomainEnDescribe} order by id desc limit 1")
    GrabDomainBasicInfo get(String grabDomainEnDescribe);

    /**
     *新增模块
     * @param basicInfo
     */
    @Insert("insert into  grab_domain_basic_info(grab_domain_en_describe,grab_domain_cn_describe,grab_domain_procedure_total," +
            "grab_domain_login_address,login_in_param,control_flag,keyboard_flag,status,remark,backup_txt1,backup_txt2,backup_txt3) values(" +
            "#{grabDomainEnDescribe},#{grabDomainCnDescribe},#{grabDomainProcedureTotal},#{grabDomainLoginAddress},#{loginInParam},#{controlFlag}," +
            "#{keyboardFlag},#{status},#{remark},#{backupTxt1},#{backupTxt2},#{backupTxt3})")
    void postNewBasic(GrabDomainBasicInfo basicInfo);

    /**
     * 删除对应的基本信息
     * @param id
     */
    @Delete("delete from grab_domain_basic_info where id=#{id} ")
    void deleteBasicById(String id);

    /**
     * 根据给定的id修改对应的模块基本信息
     * @param basicInfo
     */
    @Update("update grab_domain_basic_info set grab_domain_en_describe=#{grabDomainEnDescribe},grab_domain_cn_describe=#{grabDomainCnDescribe}," +
            "grab_domain_procedure_total=#{grabDomainProcedureTotal},grab_domain_login_address=#{grabDomainLoginAddress}," +
            "login_in_param=#{loginInParam},control_flag=#{controlFlag},keyboard_flag=#{keyboardFlag},status=#{status},remark=#{remark}," +
            "backup_txt1=#{backupTxt1},backup_txt2=#{backupTxt2},backup_txt3=#{backupTxt3} where id=#{id}")
    void putBasicById(GrabDomainBasicInfo basicInfo);

    /**
     * 根据id获取对应的模块基本信息
     * @param id
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainEnDescribe", column = "grab_domain_en_describe"),
            @Result(property = "grabDomainCnDescribe", column = "grab_domain_cn_describe"),
            @Result(property = "grabDomainProcedureTotal", column = "grab_domain_procedure_total"),
            @Result(property = "grabDomainLoginAddress", column = "grab_domain_login_address"),
            @Result(property = "loginInParam", column = "login_in_param"),
            @Result(property = "controlFlag", column = "control_flag"),
            @Result(property = "keyboardFlag", column = "keyboard_flag"),
            @Result(property = "status", column = "status"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3")
    })
    @Select("select * from grab_domain_basic_info where id=#{id}")
    GrabDomainBasicInfo  getBasicById(String id);

    /**
     * 获得所有的模块基本信息
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "grabDomainEnDescribe", column = "grab_domain_en_describe"),
            @Result(property = "grabDomainCnDescribe", column = "grab_domain_cn_describe"),
            @Result(property = "grabDomainProcedureTotal", column = "grab_domain_procedure_total"),
            @Result(property = "grabDomainLoginAddress", column = "grab_domain_login_address"),
            @Result(property = "loginInParam", column = "login_in_param"),
            @Result(property = "controlFlag", column = "control_flag"),
            @Result(property = "keyboardFlag", column = "keyboard_flag"),
            @Result(property = "status", column = "status"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "backupTxt1", column = "backup_txt1"),
            @Result(property = "backupTxt2", column = "backup_txt2"),
            @Result(property = "backupTxt3", column = "backup_txt3")
    })
    @Select("SELECT ID, GRAB_DOMAIN_EN_DESCRIBE,GRAB_DOMAIN_CN_DESCRIBE,GRAB_DOMAIN_PROCEDURE_TOTAL,GRAB_DOMAIN_LOGIN_ADDRESS,"
            + "LOGIN_IN_PARAM,CONTROL_FLAG,KEYBOARD_FLAG,STATUS,REMARK,BACKUP_TXT1,BACKUP_TXT2,BACKUP_TXT3 "
            + "FROM GRAB_DOMAIN_BASIC_INFO ")
    List<GrabDomainBasicInfo> getAllBasic();
}

