package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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


}
