package org.zw.singleton.jeeframework.common.constant;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class FinalData {
	
//	public static String PROJECTPATH = System.getProperty("user.dir");
	public static String PROJECTPATH = "D:/Asoftware/jeeframeworks/jeeframework";
	
	/**
	 * 获取工程目录
	 * @MethodsDescription:
	 * @MethodName:getProjectpath
	 * @param request
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@SuppressWarnings("deprecation")
	public static String getProjectpath(HttpServletRequest request){
		if(request!=null){
			PROJECTPATH = request.getRealPath("/");
		}
		return PROJECTPATH;
	}

	//db.properties
	public static final String DBPROPERTIES = PROJECTPATH+"/src/main/resources/jeeframework.properties";
	
	public static final String APPLICATIONMVC = PROJECTPATH+"/src/main/resources/application-mvc.xml";
	
	public static final String SMSPROPERTIES = PROJECTPATH+"/src/main/resources/sms.properties";
	
	public static final String CONFIGPROPERTIES = PROJECTPATH+"/src/main/resources/config.properties";
	
	public static final String CODEMODEL = PROJECTPATH+"/src/main/java/org/zw/singleton/jeeframework/modules/";
	
	public static final String CODEMODELPACK = "org.zw.singleton.jeeframework.modules.";
	
	
	
	
	
	
	
//	=====================================================================================================================
	/**
	 * 页数
	 */
	public static final String P_PAGE = "p.page";
	/**
	 * 页数大小
	 */
	public static final String P_PAGESIZE = "p.pageSize";
	
	/**
	 * 获取数据库信息
	 */
	public static final String DB_SYSDB = "db.sysdb";
	public static final String DB_USERNAME = "db.username";
	public static final String DB_PASSWORD = "db.password";
	public static final String DB_DRIVERCLASSNAME = "db.driverClassName";
	public static final String DB_URL = "db.url";
	
	
	
	
	
//	public static void main(String[] args) {
//		String config = getConfig("db.sysdb1");
//		String config1 = getConfig("db.username");
//		String string = map.get("db.sysdb");
//		String string1 = map.get("db.username");
//		System.out.println(string+string1);
//		System.out.println(config+config1);
//	}
	
	
//	==============================================================
	public static final String MESG_ERROR = "SystemError";
	public static final String MESG_SUCCESS = "Success";
	
	public static final String SUBMESG_ERROR = "DataError";
	public static final String SUBMESG_SUCCESS = "DataSuccess";
	
	
	/**
	 * 接口返回的结果
	 * @方法说明:
	 * @方法名称:puttingMap
	 * @param status 请求状态
	 * @param mesg 请求状态信息
	 * @param substate
	 * @param submesg
	 * @param data
	 * @return
	 * @作者:张威
	 * @返回值:Map<String,Object>
	 */
	public static Map<String,Object> puttingMap(String status,String mesg,String substate,String submesg,Object data){
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("status", status);
		map.put("mesg", mesg);
		Map<String,Object> map1 = new HashMap<String,Object>();	
		map1.put("substate", substate);
		map1.put("submesg", submesg);
		if(data!=null){
			map1.put("subdata", data);
		}else{
			map1.put("subdata", new HashMap<String,Object>());
		}
		map.put("data", map1);
		return map;
	}
	
	/**
	 * 请求错误返回的状态
	 * @方法说明:
	 * @方法名称:puttingMap
	 * @param status
	 * @param mesg
	 * @return
	 * @作者:张威
	 * @返回值:Map<String,Object>
	 */
	public static Map<String,Object> puttingMap(String status,String mesg){
		Map<String,Object> map = new HashMap<String,Object>();	
		map.put("status", status);
		map.put("mesg", mesg);
		map.put("data",new HashMap<String,Object>());
		return map;
	}
	
}
