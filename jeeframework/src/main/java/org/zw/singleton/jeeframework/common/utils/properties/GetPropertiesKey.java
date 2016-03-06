package org.zw.singleton.jeeframework.common.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 读取 Properties 文件的工具类
  * @类名:GetPropertiesKey
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月4日-下午5:20:09
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class GetPropertiesKey {

	private static InputStream in;
	
	/**
	 * 读取properties 里面的数据
	 * @方法说明:
	 * @方法名称:getValue
	 * @param data key集合
	 * @param soure 文件名称
	 * @return
	 * @作者:zw
	 * @返回值:Map<String,Object>
	 */
	public static Map<String, Object> getValue(List<String> data,String soure){
		Map<String, Object> map = new HashMap<String, Object>();
		if(data!= null && data.size()>0){
			Properties prop = new Properties();
			in = Object.class.getResourceAsStream("/"+soure);
			try {
				prop.load(in);
				for (int i = 0; i < data.size(); i++) {
					map.put(data.get(i), prop.getProperty(data.get(i)).trim());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * 私有构造方法，不需要创建对象
	 */
	private GetPropertiesKey() {
	}
}
