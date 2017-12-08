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
import javassist.Modifier;

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
			// 通过ClassPool生成一个public新类Emp.java
			/* 类头部到引用 */
			String className = ReptileConstant.getProductPath(grabDomainMethodInfo.getMethodProcedureClazz());
			CtClass ctClass = pool.makeClass(className);
			/* 引入包名 多个 */
			String packageName = grabDomainMethodInfo.getMethodImportPackage();
			/* 解析 */
			String arrayPackage[] = packageName.split(",");

			/* 批量引入 */
			for (int i = 0; i < arrayPackage.length; i++) {
				pool.importPackage(arrayPackage[i]);
			}

			// //添加自定义方法 此处传入方法名
			CtMethod ctMethod = new CtMethod(CtClass.voidType, grabDomainMethodInfo.getMethodProcedureName(),
					new CtClass[] {}, ctClass);
			// //为自定义方法设置修饰符
			ctMethod.setModifiers(Modifier.PUBLIC);
			// //为自定义方法设置函数体
			StringBuffer buffer2 = new StringBuffer();

			// 为自定义方法设置函数体 (动态参数设置方法体)
			buffer2.append(grabDomainMethodInfo.getMethodProcedureBody());
			ctMethod.setBody(buffer2.toString());
			ctClass.addMethod(ctMethod);

			// 把生成的类文件写入文件
			FileOutputStream fos;
			byte[] byteArr = ctClass.toBytecode();

			fos = new FileOutputStream(new File(ReptileConstant.getProductAbsolutePath()
					+ grabDomainMethodInfo.getMethodProcedureClazz() + ".class"));

			fos.write(byteArr);
			fos.close();
		} catch (Exception e) {
			logger.error("failed!", e.fillInStackTrace());
			return false;
			// TODO: handle exception
		}
		return true;

	}

	public static void main(String[] args) throws Exception {
		GrabDomainMethodInfo basicInfo = new GrabDomainMethodInfo();

		basicInfo.setMethodProcedureClazz("TestTwo");
		basicInfo.setMethodProcedureBody("{System.out.println(1);}");
		basicInfo.setMethodProcedureName("test");
		basicInfo.setMethodImportPackage("com.test,com.test.util");
		System.out.println(Addmehod(basicInfo));
	}

}
