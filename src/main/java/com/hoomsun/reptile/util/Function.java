package com.hoomsun.reptile.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 通用功能操作类
 * @author hongzheng
 *
 */
public class Function {
	/**
	 * 
	 * @param type ie 或 chrome
	 * 各位同胞大家好 需要添加其他谷歌驱动的话 自行添加
	 * @return 
	 */
	public static WebDriver getDriverInstance(String type){
		WebDriver driver = null;
		if(type.equals("ie")){
			System.setProperty(SystemConfig.getProperty("ieDriverKey"), SystemConfig.getProperty("ieDriverValue"));
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT,15000);
			driver = new InternetExplorerDriver(ieCapabilities);
		}else{
			System.setProperty(SystemConfig.getProperty("chromeDriverKey"), SystemConfig.getProperty("chromeDriverValue"));
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT,15000);
			driver = new ChromeDriver(ieCapabilities);
		
		
		}
		return driver;
	}
	/**
	 * 打开指定网址
	 * @param url 目标网址
	 * @param DriverType 驱动类型
	 * @return
	 */
	public WebDriver GetUrl(String url,String DriverType){
		WebDriver driver=null;
		driver=Function.getDriverInstance(DriverType);
		driver.get(url);
		return driver;
	}
	

}
