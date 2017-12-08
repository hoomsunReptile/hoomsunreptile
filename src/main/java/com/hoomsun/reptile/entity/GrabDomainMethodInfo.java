package com.hoomsun.reptile.entity;

/**
 * 抓取域方法表
 * @author Administrator
 *
 */
public class GrabDomainMethodInfo {
	
	private int id;//id
	private int grabDomainBasicId;//抓取域基本信息id
	private int grabDomainProcedureId;//抓取域步骤id
	private int methodCountTotal;//调用方法总数
	private int methodItem;//调用的方法为第几步
	private String methodItemDescribe;//执行方法具体描述
	private String methodName;//执行方法名称
	private String methodDescribe;//执行方法描述
	private String methodInParam;//执行方法入参
	private String methodOutParamName;//执行方法出参名
	private String methodOutParamType;//执行方法出参类型
	private String methodBody;//执行方法体
	private String methodPackage;//执行方法所在包名
	private String methodClazz;//执行方法所在类名
	private String methodExistFlag;//是否可调用已有的方法
	private String status;//状态
	private String remark;//备注
	private String methodImportPackage;//需要导入的包，逗号分隔
	private String backupTxt1;//备用字段1
	private String backupTxt2;//备用字段2
	private String backupTxt3;//备用字段3
	

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





	public int getGrabDomainProcedureId() {
		return grabDomainProcedureId;
	}





	public void setGrabDomainProcedureId(int grabDomainProcedureId) {
		this.grabDomainProcedureId = grabDomainProcedureId;
	}





	public int getMethodCountTotal() {
		return methodCountTotal;
	}





	public void setMethodCountTotal(int methodCountTotal) {
		this.methodCountTotal = methodCountTotal;
	}





	public int getMethodItem() {
		return methodItem;
	}





	public void setMethodItem(int methodItem) {
		this.methodItem = methodItem;
	}





	public String getMethodItemDescribe() {
		return methodItemDescribe;
	}





	public void setMethodItemDescribe(String methodItemDescribe) {
		this.methodItemDescribe = methodItemDescribe;
	}





	public String getMethodName() {
		return methodName;
	}





	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}





	public String getMethodDescribe() {
		return methodDescribe;
	}





	public void setMethodDescribe(String methodDescribe) {
		this.methodDescribe = methodDescribe;
	}





	public String getMethodInParam() {
		return methodInParam;
	}





	public void setMethodInParam(String methodInParam) {
		this.methodInParam = methodInParam;
	}





	public String getMethodOutParamName() {
		return methodOutParamName;
	}





	public void setMethodOutParamName(String methodOutParamName) {
		this.methodOutParamName = methodOutParamName;
	}





	public String getMethodOutParamType() {
		return methodOutParamType;
	}





	public void setMethodOutParamType(String methodOutParamType) {
		this.methodOutParamType = methodOutParamType;
	}





	public String getMethodBody() {
		return methodBody;
	}





	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}





	public String getMethodPackage() {
		return methodPackage;
	}





	public void setMethodPackage(String methodPackage) {
		this.methodPackage = methodPackage;
	}





	public String getMethodClazz() {
		return methodClazz;
	}





	public void setMethodClazz(String methodClazz) {
		this.methodClazz = methodClazz;
	}





	public String getMethodExistFlag() {
		return methodExistFlag;
	}





	public void setMethodExistFlag(String methodExistFlag) {
		this.methodExistFlag = methodExistFlag;
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





	public String getMethodImportPackage() {
		return methodImportPackage;
	}





	public void setMethodImportPackage(String methodImportPackage) {
		this.methodImportPackage = methodImportPackage;
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





	@Override
	public String toString() {
		return "GrabDomainMethodInfo{" +
				"id=" + id +
				", grabDomainBasicId=" + grabDomainBasicId +
				", grabDomainProcedureId=" + grabDomainProcedureId +
				", methodCountTotal=" + methodCountTotal +
				", methodItem=" + methodItem +
				", methodItemDescribe='" + methodItemDescribe + '\'' +
				", methodName='" + methodName + '\'' +
				", methodDescribe='" + methodDescribe + '\'' +
				", methodInParam='" + methodInParam + '\'' +
				", methodOutParamName='" + methodOutParamName + '\'' +
				", methodOutParamType='" + methodOutParamType + '\'' +
				", methodBody='" + methodBody + '\'' +
				", methodPackage='" + methodPackage + '\'' +
				", methodClazz='" + methodClazz + '\'' +
				", methodExistFlag='" + methodExistFlag + '\'' +
				", status='" + status + '\'' +
				", remark='" + remark + '\'' +
				", methodImportPackage='" + methodImportPackage + '\'' +
				", backupTxt1='" + backupTxt1 + '\'' +
				", backupTxt2='" + backupTxt2 + '\'' +
				", backupTxt3='" + backupTxt3 + '\'' +
				'}';
	}
}
