package com.hoomsun.reptile.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;

@Mapper
public interface GrabDomainProcedureInfoDao {
	
	
@Results({
		@Result(property = "id",column = "id"),
		@Result(property = "grabDomainBasicId",column = "grab_domain_basic_id"),
		@Result(property = "grabDomainProcedureItem",column = "grab_domain_procedure_item"),
		@Result(property = "grabDomainProcedureName",column = "grab_domain_procedure_name"),
		@Result(property = "grabDomainProcedureDescribe",column = "grab_domain_procedure_describe"),
		@Result(property = "grabDomainProcedureInParam",column = "grab_domain_procedure_in_param"),
		@Result(property = "grabDomainProcedureOutParamName",column = "grab_domain_procedure_out_param_name"),
		@Result(property = "grabDomainProcedureOutParamType",column = "grab_domain_procedure_out_param_type"),
		@Result(property = "grabDomainProcedurePackage",column = "grab_domain_procedure_package"),
		@Result(property = "grabDomainProcedureClazz",column = "grab_domain_procedure_clazz"),
		@Result(property = "remark",column = "remark"),
		@Result(property = "backupTxt1",column = "backup_txt1")
})


@Select("SELECT * FROM grab_domain_procedure_info WHERE grab_domain_basic_id = #{grabDomainBasicId} order by grab_domain_procedure_item asc")
List<GrabDomainProcedureInfo> get(int grabDomainBasicId);

}
