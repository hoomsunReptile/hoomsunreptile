package com.hoomsun.reptile.util;

import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常用方法工具类
 *
 * @author mrlu
 * @date 2017/12/9
 */
public class CommonMethodUtil {
	
	private static Logger logger= LoggerFactory.getLogger(CommonMethodUtil.class);

    /**
     * 用指定的浏览器打开url，调用该方法时backupTxt1字段不能为空，需在数据库中配置要打开的URL地址，格式为{url:value}
     *
     * @param params
     * @return
     */
    public static WebDriver openGoalUrl(Map<String,Object> params) {
    	WebDriver driver = null;
    	
    	if(CommonMethodUtil.isEmpty(params.get(ReptileConstant.BROWSER_TYPE)) || CommonMethodUtil.isEmpty(ReptileConstant.BACKUPTXT1)){
    		
    		logger.warn("-------------openGoalUrl方法未传入浏览器类型或URL地址---------------");
    		
    	}else{
    		
    		String browserType = (String)params.get(ReptileConstant.BROWSER_TYPE);
    		String backupTxt1 = (String)params.get(ReptileConstant.BACKUPTXT1);
    		
    		JSONObject json = JSONObject.fromObject(backupTxt1);
    		driver = Function.getDriverInstance(browserType);//获取浏览器
    		
    		if (driver != null) {
    			driver.get(json.getString("url"));
    		}
    	}
        return driver;
    }

    /**
     * 通过id使用SendKeys的方式输入文本框，调用该方法时backupTxt1字段不能为空，key为属性名称，value为文本框的id名称。
     * 比如要将userName赋值到ID为username文本框的文本框中，则格式为{userName:username};
     * 比如要将passWord赋值到ID为password文本框的文本框中，则格式为{passWord:password};
     * 若userName及passWord都需要输入，则格式为{userName:username,passWord:password}
     * @param params中driver不能为空
     */
    public void inputSendKeysById(Map<String,Object> params){
    	WebDriver driver = (WebDriver) params.get("driver");
    	if(driver != null){
    		
    		if(!CommonMethodUtil.isEmpty(params.get(ReptileConstant.BACKUPTXT1))){
    			JSONObject json = JSONObject.fromObject(params.get(ReptileConstant.BACKUPTXT1));
    			   Iterator iterator = json.keys();
    			   while(iterator.hasNext()){
    			           String key = (String) iterator.next(); //key用来从params中获取相应的值
    			           String value = params.get(key).toString();
    			           
    			           String id = json.getString(key);  //文本框的id值
    			           
    			           driver.findElement(By.id(id)).sendKeys(value);
    			   }
    			
    		}else{
    			logger.warn("------------------调用inputSendKeysById方法backupTxt1值为NULL------------------");
    		}
    		
    	}else{
    		logger.warn("------------------调用inputSendKeysById方法driver值为NULL------------------");
    	}
    	
    }
    
    
    /**
     * 通过className使用SendKeys的方式输入文本框，调用该方法时backupTxt1字段不能为空，key为属性名称，value为文本框的className名称。
     * 比如要将userName赋值到className为username文本框的文本框中，则格式为{userName:username};
     * 比如要将passWord赋值到className为password文本框的文本框中，则格式为{passWord:password};
     * 若userName及passWord都需要输入，则格式为{userName:username,passWord:password}
     * @param params中driver不能为空
     */
    public void inputSendKeysByClassName(Map<String,Object> params){
    	WebDriver driver = (WebDriver) params.get("driver");
    	if(driver != null){
    		
    		if(!CommonMethodUtil.isEmpty(params.get(ReptileConstant.BACKUPTXT1))){
    			JSONObject json = JSONObject.fromObject(params.get(ReptileConstant.BACKUPTXT1));
    			Iterator iterator = json.keys();
    			while(iterator.hasNext()){
    				String key = (String) iterator.next(); //key用来从params中获取相应的值
    				String value = params.get(key).toString();
    				
    				String className = json.getString(key);  //文本框的id值
    				
    				driver.findElement(By.className(className)).sendKeys(value);
    			}
    			
    		}else{
    			logger.warn("------------------调用inputSendKeysByClassName方法backupTxt1值为NULL------------------");
    		}
    		
    	}else{
    		logger.warn("------------------调用inputSendKeysByClassName方法driver值为NULL------------------");
    	}
    	
    }
    
    
    /**
     * 通过xPath使用SendKeys的方式输入文本框，调用该方法时backupTxt1字段不能为空，key为属性名称，value为文本框的xPath名称。
     * 比如要将userName赋值到xPath为username文本框的文本框中，则格式为{userName:username};
     * 比如要将passWord赋值到xPath为password文本框的文本框中，则格式为{passWord:password};
     * 若userName及passWord都需要输入，则格式为{userName:username,passWord:password}
     * @param params中driver不能为空
     */
    public void inputSendKeysByXPath(Map<String,Object> params){
    	WebDriver driver = (WebDriver) params.get("driver");
    	if(driver != null){
    		
    		if(!CommonMethodUtil.isEmpty(params.get(ReptileConstant.BACKUPTXT1))){
    			JSONObject json = JSONObject.fromObject(params.get(ReptileConstant.BACKUPTXT1));
    			Iterator iterator = json.keys();
    			while(iterator.hasNext()){
    				String key = (String) iterator.next(); //key用来从params中获取相应的值
    				String value = params.get(key).toString();
    				
    				String xpathExpression = json.getString(key);  //文本框的id值
    				
    				driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
    			}
    			
    		}else{
    			logger.warn("------------------调用inputSendKeysByXPath方法backupTxt1值为NULL------------------");
    		}
    		
    	}else{
    		logger.warn("------------------调用inputSendKeysByXPath方法driver值为NULL------------------");
    	}
    	
    }
    
    /**
     * 点击事件，调用该方法时backupTxt1字段不能为空，key为id/className/xPath/linkText，value为id名称/className名称/xPath名称/a标签的text值。
     * 比如点击事件的id为button，则格式为{id:button};
     * @param params中driver不能为空
     */
    public void click(Map<String,Object> params){
    	WebDriver driver = (WebDriver) params.get("driver");
    	if(driver != null){
    		
    		if(!CommonMethodUtil.isEmpty(params.get(ReptileConstant.BACKUPTXT1))){
    			JSONObject json = JSONObject.fromObject(params.get(ReptileConstant.BACKUPTXT1));
    			Iterator iterator = json.keys();
    			while(iterator.hasNext()){
    				String key = (String) iterator.next(); //key
    				String value = json.getString(key);
    				
    				if(key.equals("id")){
    					driver.findElement(By.id(value)).click();
    				}else if(key.equals("className")){
    					driver.findElement(By.className(value)).click();
    				}else if(key.equals("xPath")){
    					driver.findElement(By.xpath(value)).click();
    				}else if(key.equals("a")){
    					driver.findElement(By.linkText(value)).click();
    				}
    			}
    			
    		}else{
    			logger.warn("------------------调用click方法backupTxt1值为NULL------------------");
    		}
    		
    	}else{
    		logger.warn("------------------调用click方法driver值为NULL------------------");
    	}
    	
    }
    
    
    
    
    
    /**
     * 判断obj是否为空
     * @param obj
     * @return
     */
    public static Boolean isEmpty(Object obj){
    	
    	if(obj == null){
    		return true;
    	}else{
    		if("".equals(obj+"")){
    			return true;
    		}
    	}
    	
    	return false;
    }
    
}
