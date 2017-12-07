package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
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
	 List<GrabDomainMethodInfo> get(int grabDomainProcedureId);
}
