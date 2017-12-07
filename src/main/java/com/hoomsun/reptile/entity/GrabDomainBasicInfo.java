package com.hoomsun.reptile.entity;

/**
 * 抓取域基本信息表
 * @author Administrator
 *
 */
public class GrabDomainBasicInfo {
	private int id;//id
	private String grabDomainEnDescribe;//抓取域英文描述
	private String grabDomainCnDescribe;//抓取域中文描述
	private int grabDomainProcedureTotal;//抓取域步骤总数
	private String grabDomainLoginAddress;//抓取域登录地址
	private String loginInParam;//登录入参
	private String controlFlag;//是否需要控件定位 1.是；2：否
	private String keyboardFlag;//是否需要键盘模拟 1.是；2：否。是的话需要进行同步加锁
	private String status;//状态 1.可用；2：禁用
	private String remark;//备注
	private String backupTxt1;//备用字段1
	private String backupTxt2;//备用字段2
	private String backupTxt3;//备用字段3
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrabDomainEnDescribe() {
		return grabDomainEnDescribe;
	}
	public void setGrabDomainEnDescribe(String grabDomainEnDescribe) {
		this.grabDomainEnDescribe = grabDomainEnDescribe;
	}
	public String getGrabDomainCnDescribe() {
		return grabDomainCnDescribe;
	}
	public void setGrabDomainCnDescribe(String grabDomainCnDescribe) {
		this.grabDomainCnDescribe = grabDomainCnDescribe;
	}
	public int getGrabDomainProcedureTotal() {
		return grabDomainProcedureTotal;
	}
	public void setGrabDomainProcedureTotal(int grabDomainProcedureTotal) {
		this.grabDomainProcedureTotal = grabDomainProcedureTotal;
	}
	public String getGrabDomainLoginAddress() {
		return grabDomainLoginAddress;
	}
	public void setGrabDomainLoginAddress(String grabDomainLoginAddress) {
		this.grabDomainLoginAddress = grabDomainLoginAddress;
	}
	public String getLoginInParam() {
		return loginInParam;
	}
	public void setLoginInParam(String loginInParam) {
		this.loginInParam = loginInParam;
	}
	public String getControlFlag() {
		return controlFlag;
	}
	public void setControlFlag(String controlFlag) {
		this.controlFlag = controlFlag;
	}
	public String getKeyboardFlag() {
		return keyboardFlag;
	}
	public void setKeyboardFlag(String keyboardFlag) {
		this.keyboardFlag = keyboardFlag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	
	
	
	
}
