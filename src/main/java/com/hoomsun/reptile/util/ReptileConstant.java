package com.hoomsun.reptile.util;

/**
 * 爬虫项目常量类
 * @author Administrator
 *
 */
public class ReptileConstant {
	
	public static final String METHOD_TYPE_VOID = "void";
	public static final String METHOD_TYPE_STRING = "string";
	public static final String METHOD_TYPE_INT = "int";
	public static final String METHOD_TYPE_BOOLEAN = "boolean";
	public static final String METHOD_TYPE_MAP = "map";
	public static final String METHOD_TYPE_DOUBLE = "double";
	public static final String METHOD_TYPE_JSONOBJECT = "jsonObject";
	public static final String METHOD_TYPE_JSONARRAY = "jsonArray";
	
	public static final String YES = "1";
	public static final String NO = "0";
	
	public static final String POINT = ".";
	public static final String CLASS_PACKAGE_INFO = "com.hoomsun.reptile.classLoader";
	public static final String CLASS_PACKAGE_INFO_A = "com/hoomsun/reptile/classLoader/";
	
	public static final String BACKUPTXT1 = "backupTxt1";//备用字段1
	public static final String BACKUPTXT2 = "backupTxt2";//备用字段2
	public static final String BACKUPTXT3 = "backupTxt3";//备用字段3
	
	public static final String BROWSER_TYPE = "browserType";//浏览器类型
	
	/**
	 * 获取包名+类名
	 * @param classPackage
	 * @param className
	 * @return
	 */
	public static String getProductPath(String className){
		return ReptileConstant.CLASS_PACKAGE_INFO + ReptileConstant.POINT + className;
	}
	
	/**
	 * 获取项目classes绝对路径
	 * @return
	 */
	public static String getProductAbsolutePath(){
		String a = ReptileConstant.class.getResource("").getPath();
		int end = a.indexOf("/classes")+9;
		return a.substring(0,end)+ReptileConstant.CLASS_PACKAGE_INFO_A;
	}
	
}
