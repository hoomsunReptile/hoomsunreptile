package com.hoomsun.reptile.dd;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DDTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "D:/ie/IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		ieCapabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT,15000);
		WebDriver driver = new InternetExplorerDriver(ieCapabilities);
		driver.get("https://nper.cmbc.com.cn/pweb/static/login.html");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("中国民生银行个人网上银行"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;

		List list = new ArrayList();
		/* 获得输入元素 */
		WebElement elements = driver.findElement(By.id("writeUserId"));
		elements.sendKeys("6226011038013902");
		/* 按下Tab */
		DDUtil.DD_tab();
		DDUtil.DD_str("wangmeng000");
//
		driver.findElement(By.id("loginButton")).click();
	}
	
}
