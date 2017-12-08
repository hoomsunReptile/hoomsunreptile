/**  
* @Package com.test.junit  
* @Description: TODO(用一句话描述该文件做什么)  
* @author hongzheng  
* @date 2017年12月8日  
* @version V1.0  
*/  
package com.test.junit;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hoomsun.reptile.dao.GrabDomainMethodInfoDao;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.main.StartApp;
import com.hoomsun.reptile.service.GrabDomainMethodService;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**  
* @ClassName: AddMethodTest  
* @Description: TODO(生成方法并存入数据库)  
* @Created by: biyyoung 
* @date 2017年12月8日  
*    
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp.class)
@WebAppConfiguration
public class AddMethodTest {
    @Autowired
    GrabDomainMethodService methodInfoService;

	@Test
	public void test2() throws CannotCompileException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NotFoundException{
		GrabDomainMethodInfo basicInfo = new GrabDomainMethodInfo();
		basicInfo.setMethodClazz("TestTwo");
		basicInfo.setMethodBody("{System.out.println(1);}");
		basicInfo.setMethodName("test");
		basicInfo.setMethodImportPackage("com.test,com.test.util");
		ClassPool pool = ClassPool.getDefault(); 
		pool.insertClassPath("/Users/hongzheng/git/hoomsunreptile/target/test-classes/");
		CtClass cc1 = pool.get("com.test.junit.InsertTest"); 
        try {
        	methodInfoService.postNewMethod(basicInfo);
    	    System.out.println("成功");
		} catch (Exception e) {
	 	    System.out.println("失败");
		}


}
}
