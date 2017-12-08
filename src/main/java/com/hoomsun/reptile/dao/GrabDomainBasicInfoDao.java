package com.hoomsun.reptile.dao;

import org.apache.ibatis.annotations.*;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;

@Mapper
public interface GrabDomainBasicInfoDao {
	
 @Results({
	 @Result(property ="id", column ="id"),
	 @Result(property ="grabDomainEnDescribe", column ="grab_domain_en_describe"),
	 @Result(property ="grabDomainCnDescribe", column ="grab_domain_cn_describe"),
	 @Result(property ="grabDomainProcedureTotal", column ="grab_domain_procedure_total"),
	 @Result(property ="grabDomainLoginAddress", column ="grab_domain_login_address"),
	 @Result(property ="loginInParam", column ="login_in_param"),
	 @Result(property ="controlFlag", column ="control_flag"),
	 @Result(property ="keyboardFlag", column ="keyboard_flag"),
	 @Result(property ="status", column ="status"),
	 @Result(property ="remark", column ="remark"),
	 @Result(property ="backupTxt1", column ="backup_txt1"),
	 @Result(property ="backupTxt2", column ="backup_txt2"),
	 @Result(property ="backupTxt3", column ="backup_txt3")
 })
 
 
 @Select("SELECT * FROM grab_domain_basic_info WHERE grab_domain_en_describe = #{grabDomainEnDescribe} order by id desc limit 1")
 GrabDomainBasicInfo get(String grabDomainEnDescribe);

 @Insert("insert into  grab_domain_basic_info(grab_domain_en_describe,grab_domain_cn_describe,grab_domain_procedure_total," +
		 "grab_domain_login_address,login_in_param,control_flag,keyboard_flag,status,remark,backup_txt1,backup_txt2,backup_txt3}) values(" +
		 "#{grabDomainEnDescribe},#{grabDomainCnDescribe},#{grabDomainProcedureTotal},#{grabDomainLoginAddress},#{loginInParam},#{controlFlag}," +
		 "#{keyboardFlag},#{status},#{remark},#{backupTxt1},#{backupTxt2},#{backupTxt3})")
 void postNewBasic(GrabDomainBasicInfo basicInfo);
}
