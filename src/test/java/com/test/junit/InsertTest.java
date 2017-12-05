package com.test.junit;

import com.hoomsun.reptile.main.StartApp;
import com.hoomsun.reptile.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

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

    @Test
    public void test() {
        System.out.println("asdas");
        userServices.insert("2132", 18);
        System.out.println("成功");
    }

}
