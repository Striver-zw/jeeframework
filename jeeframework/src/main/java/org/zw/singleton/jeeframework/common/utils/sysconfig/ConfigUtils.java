package org.zw.singleton.jeeframework.common.utils.sysconfig;

import java.util.Map;

import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.common.utils.properties.PropertiesLoader;

import com.google.common.collect.Maps;

/**
 * 系统配置
  * @类名:ConfigUtils
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月14日-下午1:00:44
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class ConfigUtils {

	private static PropertiesLoader loader = new PropertiesLoader("jeeframework.properties");

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();

	/**
	 * 获取配置
	 * 
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = loader.getProperty(key);
			map.put(key, value != null ? value : "");
		}
		return value;
	}

	/**
	 * 获取分页参数
	 * @方法说明:
	 * @方法名称:getPageParameter
	 * @return
	 * @作者:zw
	 * @返回值:int[]
	 */
	public static int[] getPageParameter(){
		int[] pp  = new int[2];
		getConfig(FinalData.P_PAGE);
		getConfig(FinalData.P_PAGESIZE);
		if(map.get(FinalData.P_PAGESIZE) != null && map.get(FinalData.P_PAGE) != null){
			pp[0] =  Integer.parseInt(map.get(FinalData.P_PAGE));
			pp[1] = Integer.parseInt(map.get(FinalData.P_PAGESIZE));
		}else{
			pp[0] = 1;
			pp[1] = 10;
		}
		return pp;
	}
	
	/**
	 * 获取链接数据库的信息
	 * @方法说明:
	 * @方法名称:getDBParameter
	 * @return
	 * @作者:张威
	 * @返回值:String[]
	 */
	public static String[] getDBParameter(){
		String[] pp  = new String[5];
		getConfig(FinalData.DB_SYSDB);
		getConfig(FinalData.DB_USERNAME);
		getConfig(FinalData.DB_PASSWORD);
		getConfig(FinalData.DB_DRIVERCLASSNAME);
		getConfig(FinalData.DB_URL);
		if(map.get(FinalData.DB_SYSDB) != null && map.get(FinalData.DB_USERNAME) != null && map.get(FinalData.DB_PASSWORD)!=null && map.get(FinalData.DB_DRIVERCLASSNAME)!=null && map.get(FinalData.DB_URL)!=null){
			pp[0] =map.get(FinalData.DB_SYSDB);
			pp[1] =map.get(FinalData.DB_USERNAME);
			pp[2] =map.get(FinalData.DB_PASSWORD);
			pp[3] =map.get(FinalData.DB_DRIVERCLASSNAME);
			pp[4] =map.get(FinalData.DB_URL);
		}
		return pp;
		
	}
//	public static void main(String[] args) {
//		String[] dbParameter = getDBParameter();
//		for (int i = 0; i < dbParameter.length; i++) {
//			System.out.println(dbParameter[i]);
//		}
//	}
}
