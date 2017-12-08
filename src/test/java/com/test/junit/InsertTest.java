package com.test.junit;

import com.hoomsun.reptile.controller.GrabDomainMethodController;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.main.StartApp;
import com.hoomsun.reptile.service.GrabDomainMethodService;
import com.hoomsun.reptile.service.UserService;
import com.hoomsun.reptile.util.CommonMethodUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 测试类
 *
 * @author hongzheng
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp.class)
@WebAppConfiguration
public class InsertTest {
    @Resource
    private UserService userServices;
    @Resource
    GrabDomainMethodService methodController;

    @Test
    public void test() {
        		System.out.println("asdas");
		userServices.insert("2132",18);
		System.out.println("成功");
    }

    @Test
    public void test1() {
        GrabDomainMethodInfo methodInfo = new GrabDomainMethodInfo();
        methodInfo.setBackupTxt1("123456");
        methodInfo.setBackupTxt2("7899");
        methodInfo.setBackupTxt3("101010101");
        methodInfo.setMethodProcedureName("你在哪里");
        methodController.postNewMethod(methodInfo);
    }

    @Test
    public  void deleteMethod(){
        methodController.deleteMethodById("10");
    }

    @Test
    public  void putMethod(){
        GrabDomainMethodInfo methodInfo = new GrabDomainMethodInfo();
        methodInfo.setBackupTxt1("你");
        methodInfo.setBackupTxt2("还");
        methodInfo.setBackupTxt3("好");
        methodInfo.setMethodProcedureName("吗");
        methodInfo.setId(11);
        methodController.putMethodById(methodInfo);
    }

}
