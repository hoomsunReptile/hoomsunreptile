package com.hoomsun.reptile.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.Map;

/**
 * 常用方法集合
 */
public class CommonMethodUtil {

    /**
     * 打开url所指的浏览器
     * @param browserType
     * @param url
     * @return
     */
    public static Map<String, Object> openGoalUrl(String browserType, String url) {
        Map<String, Object> map = new HashMap<>();
        InternetExplorerDriver ieDriver=null;
        ChromeDriver chromeDriver=null;
        if (browserType.equals("ie")) {
            System.setProperty(SystemConfig.getProperty("ieDriverKey"), SystemConfig.getProperty("ieDriverValue"));
            ieDriver = new InternetExplorerDriver();
            ieDriver.manage().window().maximize();
        } else if (browserType.equals("chrome")) {
            System.setProperty(SystemConfig.getProperty("chromeDriverKey"), SystemConfig.getProperty("chromeDriverValue"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            chromeDriver = new ChromeDriver(options);
        } else {
            map.put("errorCode", "0001");
            map.put("errorInfo", "暂无对应浏览器版本");
            return map;
        }

        if (ieDriver == null) {
            chromeDriver.get(url);
        } else {
            ieDriver.get(url);
        }
        map.put("errorCode", "0000");
        map.put("errorInfo", "成功");
        map.put("webDriver", ieDriver==null?chromeDriver:ieDriver);
        return map;
    }
}
