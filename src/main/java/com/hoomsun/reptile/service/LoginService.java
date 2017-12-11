package com.hoomsun.reptile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoomsun.reptile.dao.GrabDomainBasicInfoDao;
import com.hoomsun.reptile.dao.GrabDomainMethodInfoDao;
import com.hoomsun.reptile.dao.GrabDomainProcedureInfoDao;
import com.hoomsun.reptile.entity.GrabDomainBasicInfo;
import com.hoomsun.reptile.entity.GrabDomainMethodInfo;
import com.hoomsun.reptile.entity.GrabDomainProcedureInfo;
import com.hoomsun.reptile.util.ReptileConstant;

@Service
public class LoginService {
	
	private static Logger logger= LoggerFactory.getLogger(LoginService.class);
	
	  
	@Autowired
	private GrabDomainBasicInfoDao basicInfoDao;
	@Autowired
	private GrabDomainMethodInfoDao methodInfoDao;
	@Autowired
	private GrabDomainProcedureInfoDao procedureInfoDao;

	public Map<String,Object> doLogin(String type, Map<String,Object> params){
    	logger.warn("------------爬虫开始-----------模板id:"+type+";请求参数:"+params);
		Map<String,Object> data = new HashMap<String, Object>();
		try {
			//根据type查询basic表，basic表备用字段1为浏览器类型
			GrabDomainBasicInfo basic = basicInfoDao.get(type);
			if(basic != null){
				params.put(ReptileConstant.BROWSER_TYPE, basic.getBackupTxt1());
				//查询type对应的步骤表
				List<GrabDomainProcedureInfo> procedures = procedureInfoDao.getProcedureById(basic.getId());
				
				if(procedures != null && procedures.size() > 0){
					
					//list的第一条数据为登录方法
					GrabDomainProcedureInfo procedureInfo = procedures.get(0);
					//查询登录方法需要调用的具体方法
					List<GrabDomainMethodInfo> methods = methodInfoDao.getMethodById(procedureInfo.getId());
					//入参类型
					for (GrabDomainMethodInfo item:methods) {
							params.put("backupTxt1", item.getBackupTxt1());//方法中需要的一些常量可以放在该字段中。
							Class<?> clazz = null;
							//MethodExistFlag为1时，该方法在项目中存在；MethodExistFlag为2时，该方法为动态加载类，动态加载类放在com.hoomsun.reptile.classLoader包下
							if((ReptileConstant.NO).equals(item.getMethodExistFlag())){
								item.setMethodPackage(ReptileConstant.CLASS_PACKAGE_INFO);
							}
							System.err.println(item.getMethodPackage());
							
							try {
								//加载类
								clazz = Class.forName(item.getMethodPackage()+ReptileConstant.POINT+item.getMethodClazz());
							} catch (ClassNotFoundException e) {
								logger.error("-------------该类找不到！"+item.getMethodPackage()+ReptileConstant.POINT+item.getMethodClazz()+"------------",e);
								throw new Exception(e);
							}
							//创建实例
							Object obj = clazz.newInstance();
							//当方法返回值不为void时，将方法的返回值加到params中已供后面调用的方法使用，注意：若params中key不要设重复，以免覆盖之前的值
							if(!"void".equals(item.getMethodOutParamType())){
								Object result = clazz.getMethod(item.getMethodName(), new Class[]{Map.class}).invoke(obj, new Object[]{params}); //执行
								params.put(item.getMethodOutParamName(), result);
							}else {
								clazz.getMethod(item.getMethodName(), new Class[]{Map.class}).invoke(obj, new Object[]{params});
							}
							
					}
					
				}
			}else{
				data.put("errorCode", "0001");
				data.put("errorMsg", "该模板服务暂未开通！");
			}
		} catch (Exception e) {
			logger.error("--------------爬虫系统错误，模板id：" + type + "入参："+ params + "---------------",e);
			data.put("errorCode", "0002");
			data.put("errorMsg", "爬虫系统错误！");
		}
		
		logger.warn("------------爬虫结束-----------返回信息为:" + data + "---------------");
		return data;
		
	}
	
	
	

}
