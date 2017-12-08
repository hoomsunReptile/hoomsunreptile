package com.hoomsun.reptile.entity;

/**
 * 抓取域步骤表
 * @author Administrator
 *
 */
public class GrabDomainProcedureInfo {
	
	private int id;//id
	private int grabDomainBasicId;//抓取域基本信息id
	private int grabDomainProcedureItem;//抓取域步骤
	private String grabDomainProcedureName;//抓取域方法名称
	private String grabDomainProcedureDescribe;//抓取域方法描述
	private String grabDomainProcedureInParam;//抓取域方法入参
	private String grabDomainProcedureOutParamName;//抓取域方法出参名
	private String grabDomainProcedureOutParamType;//抓取域方法出参类型
	private String grabDomainProcedurePackage;//抓取域方法所在包名
	private String grabDomainProcedureClazz;//抓取域方法所在类名
	private String remark;//备注
	private String backupTxt1;//备用字段1
	private String backupTxt2;//备用字段1
	private String backupTxt3;//备用字段1

	public String getBackupTxt2() {
		return backupTxt2;
	}

	public void setBackupTxt2(String backupTxt2) {
		this.backupTxt2 = backupTxt2;
	}

	public String getBackupTxt3() {
		return backupTxt3;
	}

	public void setBackupTxt3(String backupTxt3) {
		this.backupTxt3 = backupTxt3;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrabDomainBasicId() {
		return grabDomainBasicId;
	}
	public void setGrabDomainBasicId(int grabDomainBasicId) {
		this.grabDomainBasicId = grabDomainBasicId;
	}
	public int getGrabDomainProcedureItem() {
		return grabDomainProcedureItem;
	}
	public void setGrabDomainProcedureItem(int grabDomainProcedureItem) {
		this.grabDomainProcedureItem = grabDomainProcedureItem;
	}
	public String getGrabDomainProcedureName() {
		return grabDomainProcedureName;
	}
	public void setGrabDomainProcedureName(String grabDomainProcedureName) {
		this.grabDomainProcedureName = grabDomainProcedureName;
	}
	public String getGrabDomainProcedureDescribe() {
		return grabDomainProcedureDescribe;
	}
	public void setGrabDomainProcedureDescribe(String grabDomainProcedureDescribe) {
		this.grabDomainProcedureDescribe = grabDomainProcedureDescribe;
	}
	public String getGrabDomainProcedureInParam() {
		return grabDomainProcedureInParam;
	}
	public void setGrabDomainProcedureInParam(String grabDomainProcedureInParam) {
		this.grabDomainProcedureInParam = grabDomainProcedureInParam;
	}
	public String getGrabDomainProcedureOutParamName() {
		return grabDomainProcedureOutParamName;
	}
	public void setGrabDomainProcedureOutParamName(String grabDomainProcedureOutParamName) {
		this.grabDomainProcedureOutParamName = grabDomainProcedureOutParamName;
	}
	public String getGrabDomainProcedureOutParamType() {
		return grabDomainProcedureOutParamType;
	}
	public void setGrabDomainProcedureOutParamType(String grabDomainProcedureOutParamType) {
		this.grabDomainProcedureOutParamType = grabDomainProcedureOutParamType;
	}
	public String getGrabDomainProcedurePackage() {
		return grabDomainProcedurePackage;
	}
	public void setGrabDomainProcedurePackage(String grabDomainProcedurePackage) {
		this.grabDomainProcedurePackage = grabDomainProcedurePackage;
	}
	public String getGrabDomainProcedureClazz() {
		return grabDomainProcedureClazz;
	}
	public void setGrabDomainProcedureClazz(String grabDomainProcedureClazz) {
		this.grabDomainProcedureClazz = grabDomainProcedureClazz;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBackupTxt1() {
		return backupTxt1;
	}
	public void setBackupTxt1(String backupTxt1) {
		this.backupTxt1 = backupTxt1;
	}

	@Override
	public String toString() {
		return "GrabDomainProcedureInfo{" +
				"id=" + id +
				", grabDomainBasicId=" + grabDomainBasicId +
				", grabDomainProcedureItem=" + grabDomainProcedureItem +
				", grabDomainProcedureName='" + grabDomainProcedureName + '\'' +
				", grabDomainProcedureDescribe='" + grabDomainProcedureDescribe + '\'' +
				", grabDomainProcedureInParam='" + grabDomainProcedureInParam + '\'' +
				", grabDomainProcedureOutParamName='" + grabDomainProcedureOutParamName + '\'' +
				", grabDomainProcedureOutParamType='" + grabDomainProcedureOutParamType + '\'' +
				", grabDomainProcedurePackage='" + grabDomainProcedurePackage + '\'' +
				", grabDomainProcedureClazz='" + grabDomainProcedureClazz + '\'' +
				", remark='" + remark + '\'' +
				", backupTxt1='" + backupTxt1 + '\'' +
				", backupTxt2='" + backupTxt2 + '\'' +
				", backupTxt3='" + backupTxt3 + '\'' +
				'}';
	}
}
