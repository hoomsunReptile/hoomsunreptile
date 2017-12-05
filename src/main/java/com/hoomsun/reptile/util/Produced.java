package com.hoomsun.reptile.util;

import javassist.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author bigyoung
 *  功能生产
 */
public class Produced {
   private static Logger logger= LoggerFactory.getLogger(Produced.class);
   

   public static void createclass() throws CannotCompileException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
	   
	   //ClassPool：CtClass对象的容器    
	   ClassPool pool = ClassPool.getDefault();      	
	   //通过ClassPool生成一个public新类Emp.java    
	   CtClass ctClass = pool.makeClass("com.reptile.util");  
	   /*引入包*/
	   pool.importPackage("com.hoomsun.reptile.main.test;");
	   pool.importPackage("com.hoomsun.reptile.main.test1;");
	     //添加自定义方法    
       CtMethod ctMethod = new CtMethod(CtClass.voidType,"printInfo",new CtClass[]{},ctClass);    
       //为自定义方法设置修饰符    
       ctMethod.setModifiers(Modifier.PUBLIC);    
       //为自定义方法设置函数体    
       StringBuffer buffer2 = new StringBuffer();    
       buffer2.append("{ test test=new test(); test.getdate();test1 test1=new test1(); test1.getdate();");
       
       buffer2.append("}");    
       ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);    
            
        //为了验证效果，下面使用反射执行方法printInfo    
        Class<?> clazz = ctClass.toClass();    
       Object obj = clazz.newInstance();    
       obj.getClass().getMethod("printInfo", new Class[]{}).invoke(obj, new Object[]{}); 
   }
  
   public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, CannotCompileException {
	   createclass();

}
   
}
