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
 * 常用方法工具类
 *
 * @author mrlu
 * @date 2017/12/9
 */
public class CommonMethodUtil {
    private static final String IE_BROWSER="ie";
    private static final String CHROME_BROWSER="chrome";
    private static final String BY_ID="id";
    private static final String BY_CLASSNAME="className";
    private static final String BY_XPATH="xpath";

    /**
     * 用指定的浏览器打开url
     *
     * @param browserType
     * @param url
     * @return
     */
    public static Map<String, Object> openGoalUrl(String browserType, String url) {
        Map<String, Object> map = new HashMap<>(16);
        InternetExplorerDriver ieDriver = null;
        ChromeDriver chromeDriver = null;
        if (browserType.equals(IE_BROWSER)) {
            System.setProperty(SystemConfig.getProperty("ieDriverKey"), SystemConfig.getProperty("ieDriverValue"));
            ieDriver = new InternetExplorerDriver();
            ieDriver.manage().window().maximize();
        } else if (browserType.equals(CHROME_BROWSER)) {
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
        Map<String, Object> map = new HashMap<>(16);
        try {
            if (byType.equals(BY_ID)) {
                driver.findElementById(htmlSignlName).sendKeys(userName);
                Thread.sleep(1000);
                driver.findElementById(htmlSignlPwd).sendKeys(password);
            } else if (byType.equals(BY_CLASSNAME)) {
                driver.findElementByClassName(htmlSignlName).sendKeys(userName);
                Thread.sleep(1000);
                driver.findElementByClassName(htmlSignlPwd).sendKeys(password);
            } else if (byType.equals(BY_XPATH)) {
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


