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
	private String grabDomainMethodName;//方法名称
	private String grabDomainMethodDescribe;//方法描述
	private String grabDomainMethodInParam;//方法入参
	private String grabDomainMethodOutParamName;//方法出参名
	private String grabDomainMethodOutParamType;//方法出参类型
	private String grabDomainMethodPackage;//方法所在包名
	private String grabDomainMethodClazz;//方法所在类名
	private String remark;//备注
	private String backupTxt1;//备用字段1
	
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
	public String getGrabDomainMethodName() {
		return grabDomainMethodName;
	}
	public void setGrabDomainMethodName(String grabDomainMethodName) {
		this.grabDomainMethodName = grabDomainMethodName;
	}
	public String getGrabDomainMethodDescribe() {
		return grabDomainMethodDescribe;
	}
	public void setGrabDomainMethodDescribe(String grabDomainMethodDescribe) {
		this.grabDomainMethodDescribe = grabDomainMethodDescribe;
	}
	public String getGrabDomainMethodInParam() {
		return grabDomainMethodInParam;
	}
	public void setGrabDomainMethodInParam(String grabDomainMethodInParam) {
		this.grabDomainMethodInParam = grabDomainMethodInParam;
	}
	public String getGrabDomainMethodOutParamName() {
		return grabDomainMethodOutParamName;
	}
	public void setGrabDomainMethodOutParamName(String grabDomainMethodOutParamName) {
		this.grabDomainMethodOutParamName = grabDomainMethodOutParamName;
	}
	public String getGrabDomainMethodOutParamType() {
		return grabDomainMethodOutParamType;
	}
	public void setGrabDomainMethodOutParamType(String grabDomainMethodOutParamType) {
		this.grabDomainMethodOutParamType = grabDomainMethodOutParamType;
	}
	public String getGrabDomainMethodPackage() {
		return grabDomainMethodPackage;
	}
	public void setGrabDomainMethodPackage(String grabDomainMethodPackage) {
		this.grabDomainMethodPackage = grabDomainMethodPackage;
	}
	public String getGrabDomainMethodClazz() {
		return grabDomainMethodClazz;
	}
	public void setGrabDomainMethodClazz(String grabDomainMethodClazz) {
		this.grabDomainMethodClazz = grabDomainMethodClazz;
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

	
	
}
