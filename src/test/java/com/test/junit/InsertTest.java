package com.test.junit;

import com.hoomsun.reptile.main.StartApp;
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
 *  测试类
 * @author hongzheng
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp.class)
@WebAppConfiguration
public class InsertTest {
@Resource
    private  UserService userServices;


	@Test
	public void test(){
		Map<String, Object> chrome = CommonMethodUtil.openGoalUrl("chrome", "https://ebsnew.boc.cn/boc15/login.html");
	}

}
