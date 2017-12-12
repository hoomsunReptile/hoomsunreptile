/**
 * @Title: ProductionFunction.java
 * @Package com.hoomsun.reptile.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author hongzheng
 * @date 2017年12月7日
 * @version V1.0
 */
package com.hoomsun.reptile.util;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.log4j.Logger;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @ClassName: ProductionFunction
 * @Description: TODO(根据提供的参数生成方法)
 * @Created by: biyyoung
 * @date 2017年12月7日
 *
 */
public class ProductionFunction {
	private static Logger logger = Logger.getLogger(ProductionFunction.class);

	public static boolean Addmehod(GrabDomainMethodInfo grabDomainMethodInfo) {
		try {

			ClassPool pool = ClassPool.getDefault();
			// 新类Emp.java
			/* 类头部到引用 */
			String className = ReptileConstant.getProductPath(grabDomainMethodInfo.getMethodClazz());
			CtClass ctClass = pool.makeClass(className);
			/* 引入包名 多个 */
			String packageName = grabDomainMethodInfo.getMethodImportPackage();
			/* 解析 */
			String[] arrayPackage = packageName.split(",");

			/* 批量引入 */
			pool.importPackage("java.util.Map");
			for (int i = 0; i < arrayPackage.length; i++) {
				pool.importPackage(arrayPackage[i]);
			}
			StringBuffer buffer = new StringBuffer();

			/* 判断方法修饰符 */
			if ("public".equals(grabDomainMethodInfo.getBackupTxt2())) {
				// //为自定义方法设置修饰符
				buffer.append("public ");
			} else if ("private".equals(grabDomainMethodInfo.getBackupTxt2())) {
				buffer.append("private ");
			} else {
				logger.error("failed! 未配置当前修饰符");
				return false;
			}

			/* 判断是否静态 */
			if ((ReptileConstant.YES).equals(grabDomainMethodInfo.getBackupTxt3())) {
				buffer.append("static ");
			}

			/* 设置方法的出参 返回值 以及 是否静态 */

			if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_VOID)) {
				buffer.append("void ");
			} else if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_INT)) {
				buffer.append("int ");
			} else if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_BOOLEAN)) {
				buffer.append("boolen ");
			} else if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_STRING)) {
				buffer.append("String ");
			} else if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_MAP)) {
				buffer.append("Map<String,Object> ");
			} else if (grabDomainMethodInfo.getMethodOutParamType().equals("list")) {
				buffer.append("List<?> ");
			} else {
				logger.warn("--------------failed!出参类型配置错误，请重新配置！---------------类名：" + grabDomainMethodInfo.getMethodClazz()+"；方法名："+grabDomainMethodInfo.getMethodName());
				return false;
			}
			String oo = " (Map map)";
			/* 设置方法名 */
			buffer.append(grabDomainMethodInfo.getMethodName() + oo);
			/* 设置方法体 */
			buffer.append("{");
			buffer.append(grabDomainMethodInfo.getMethodBody());
			/**
			 * 是否有返回值
			 */
			if (grabDomainMethodInfo.getMethodOutParamType().equals(ReptileConstant.METHOD_TYPE_VOID)) {
				buffer.append("}");
			} else {
				buffer.append("return " + grabDomainMethodInfo.getMethodOutParamName() + ";}");
			}

			CtMethod m1 = CtMethod.make(buffer.toString(), ctClass);
			ctClass.addMethod(m1);
			// 把生成的类文件写入文件
			FileOutputStream fos;
			byte[] byteArr = ctClass.toBytecode();

			fos = new FileOutputStream(new File(
					ReptileConstant.getProductAbsolutePath() + grabDomainMethodInfo.getMethodClazz() + ".class"));

			fos.write(byteArr);
			fos.close();
		} catch (Exception e) {
			logger.error("-------------类及方法加载失败，类名："+grabDomainMethodInfo.getMethodClazz()+"；方法名："+grabDomainMethodInfo.getMethodName(), e);
			return false;
		}
		return true;

	}

}
