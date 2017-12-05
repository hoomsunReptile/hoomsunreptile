package com.hoomsun.reptile.util;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 
 * @author hongzheng
 * Class生产
 */
public class ClassLoaders {
    private static Logger logger= LoggerFactory.getLogger(ClassLoaders.class);
	public static  void  production(String str,String url) throws Exception{
		//logger
	       try {
			
		
        //ClassPool：CtClass对象的容器    
        ClassPool pool = ClassPool.getDefault();      	
        //通过ClassPool生成一个public新类Emp.java    
        CtClass ctClass = pool.makeClass("com.reptile.util");  
//        pool.makeClass("com.reptile.util.test;"); 
        
        pool.importPackage("org.openqa.selenium.WebDriver");
        pool.importPackage("org.openqa.selenium.chrome.ChromeDriver");
        pool.importPackage("org.openqa.selenium.By");
        pool.importPackage("org.openqa.selenium.WebElement");
        pool.importPackage("com.reptile.util.util");

        //添加自定义方法    
        CtMethod ctMethod = new CtMethod(CtClass.voidType,"printInfo",new CtClass[]{},ctClass);    
        //为自定义方法设置修饰符    
        ctMethod.setModifiers(Modifier.PUBLIC);    
        //为自定义方法设置函数体    
        StringBuffer buffer2 = new StringBuffer();    
      buffer2.append("{\nSystem.out.println(\"123in!\");\n");
//        buffer2.append("winino();System.setProperty(\"webdriver.chrome.driver\",\"/Users/hongzheng/Downloads/chromedriver\");\n");
//       buffer2.append(" WebDriver localChromeDriver = new ChromeDriver();\n");
//       buffer2.append("localChromeDriver.get(\""+url+"\");\n");
//       String id="kw";
//       String key="124";
//       buffer2.append("localChromeDriver.findElement(By.id(\""+id+"\")).sendKeys(\""+key+"\");");
//       buffer2.append(str);
       buffer2.append("util.printInfo();}");    
       ctMethod.setBody(buffer2.toString());
        ctClass.addMethod(ctMethod);    
            
        //为了验证效果，下面使用反射执行方法printInfo    
        Class<?> clazz = ctClass.toClass();    
       Object obj = clazz.newInstance();    
      obj.getClass().getMethod("printInfo", new Class[]{}).invoke(obj, new Object[]{}); 
      //把生成的class文件写入文件  
      byte[] byteArr = ctClass.toBytecode();  
      FileOutputStream fos = new FileOutputStream(new File("/Users/hongzheng/Downloads/ReptileBank-master/src/main/java/com/reptile/util/productionclass.class"));  
      fos.write(byteArr);  
      fos.close();  
	       } catch (Exception e) {
	    	  e.printStackTrace();
			}
  
	}
	
	


}
