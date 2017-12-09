package com.test.junit;

import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import com.hoomsun.reptile.main.StartApp;
import com.hoomsun.reptile.service.GrabDomainBasicService;
import com.hoomsun.reptile.service.GrabDomainMethodService;
import com.hoomsun.reptile.service.GrabDomainProcedureService;
import com.hoomsun.reptile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    GrabDomainProcedureService service;

    @Resource
    GrabDomainBasicService basicService;
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
        methodInfo.setMethodName("你在哪里");
        methodController.postNewMethod(methodInfo);
    }

    @Test
    public  void deleteMethod(){
        methodController.deleteMethodById("11");
    }

    @Test
    public  void putMethod(){
        GrabDomainMethodInfo methodInfo = new GrabDomainMethodInfo();
        methodInfo.setBackupTxt1("你");
        methodInfo.setBackupTxt2("还");
        methodInfo.setBackupTxt3("好");
        methodInfo.setMethodName("吗");
        methodInfo.setId(12);
        methodController.putMethodById(methodInfo);
    }

    @Test
    public void postProcedure(){
        GrabDomainProcedureInfo procedureInfo=new GrabDomainProcedureInfo();
        procedureInfo.setBackupTxt1("123456");
        procedureInfo.setGrabDomainProcedureName("雪松崔");
        procedureInfo.setGrabDomainProcedureInParam("不认真");
        procedureInfo.setGrabDomainProcedurePackage("必须差评");
        service.postNewProcedure(procedureInfo);
    }

    @Test
    public void deleteProcedureByid(){
        service.deleteProcedureById("4");
    }

    @Test
    public void putProcedure(){
        GrabDomainProcedureInfo info=new GrabDomainProcedureInfo();
        info.setId(2);
        info.setGrabDomainBasicId(112);
        info.setGrabDomainProcedureName("呵呵哒");
        service.putProcedureById(info);
    }

    @Test
    public  void  getProcedure(){
        List<GrabDomainProcedureInfo> procedureById = service.getProcedureById(1);
        System.out.println(procedureById);
    }
    @Test
    public void postBasic(){
        GrabDomainBasicInfo basicInfo=new GrabDomainBasicInfo();
        basicInfo.setGrabDomainCnDescribe("路党伟");
        basicInfo.setGrabDomainEnDescribe("ludnagwei");
        basicInfo.setRemark("周六过来加班了");
        basicService.postNewBasic(basicInfo);
    }
    @Test
    public void deleteBasic(){
        basicService.deleteBasicById("1");
    }

    @Test
    public void putBasic(){
        GrabDomainBasicInfo basicInfo=new GrabDomainBasicInfo();
        basicInfo.setId(4);
        basicInfo.setRemark("今天天气不错");
        basicInfo.setGrabDomainEnDescribe("today is a good");
        basicInfo.setGrabDomainCnDescribe("星期六");
        basicInfo.setBackupTxt1("hehedadadadadad");
        basicService.putBasicById(basicInfo);
    }

    @Test
    public void getBasicById(){
        GrabDomainBasicInfo basicById = basicService.getBasicById("2");
    }

    @Test
    public void getAllBasic(){
        List<GrabDomainBasicInfo> allBasic = basicService.getAllBasic();

    }

}
