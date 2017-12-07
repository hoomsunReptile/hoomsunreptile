package com.hoomsun.reptile.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * 常用方法集合
 */
public class CommonMethodUtil {

    /**
     * 用指定的浏览器打开url
     *
     * @param browserType
     * @param url
     * @return
     */
    public static Map<String, Object> openGoalUrl(String browserType, String url) {
        Map<String, Object> map = new HashMap<>();
        InternetExplorerDriver ieDriver = null;
        ChromeDriver chromeDriver = null;
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
        map.put("webDriver", ieDriver == null ? chromeDriver : ieDriver);
        return map;
    }

    /**
     * 不使用winio根据传入参数输入账号密码
     *
     * @param driver
     * @param userName
     * @param password
     * @param byType
     * @param htmlSignlName
     * @param htmlSignlPwd
     * @return
     */
    public static Map<String, Object> inputNamePwd(RemoteWebDriver driver, String userName, String password, String byType, String htmlSignlName, String htmlSignlPwd) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (byType.equals("id")) {
                driver.findElementById(htmlSignlName).sendKeys(userName);
                Thread.sleep(1000);
                driver.findElementById(htmlSignlPwd).sendKeys(password);
            } else if (byType.equals("className")) {
                driver.findElementByClassName(htmlSignlName).sendKeys(userName);
                Thread.sleep(1000);
                driver.findElementByClassName(htmlSignlPwd).sendKeys(password);
            } else if (byType.equals("xPath")) {
                driver.findElementByXPath(htmlSignlName).sendKeys(userName);
                Thread.sleep(1000);
                driver.findElementByXPath(htmlSignlPwd).sendKeys(password);
            } else {
                map.put("errorCode", "0001");
                map.put("errorInfo", "暂无对应获取方式");
                return map;
            }
            map.put("errorCode", "0000");
            map.put("errorInfo", "成功");
            map.put("webDriver", driver);
        } catch (NoSuchElementException e) {
            map.put("errorCode", "0001");
            map.put("errorInfo", "未发现指定元素！");
            driver.quit();
        } catch (Exception e) {
            map.put("errorCode", "0001");
            map.put("errorInfo", "未知异常！");
            driver.quit();
        }
        return map;
    }

    public static void main(String[] args) {



    }
}
