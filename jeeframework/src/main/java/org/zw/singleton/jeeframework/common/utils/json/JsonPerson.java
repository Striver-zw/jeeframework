package org.zw.singleton.jeeframework.common.utils.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

/**
 * json的使用
  * @类名:JsonPerson
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月19日-下午3:31:21
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class JsonPerson {
	
	/**
	 * BufferedReader reader = request.getReader();
	 * @方法说明:
	 * @方法名称:getPostReader
	 * @param reader
	 * @return
	 * @throws IOException
	 * @作者:
	 * @返回值:	JSONObject
	 */
	public JSONObject getPostReader(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append('\n');
//			System.out.println(sb.length());
		}
		return JSONObject.fromObject(sb.toString());
	}
	/**
	 * 
	 * @方法说明:
	 * @方法名称:toJson
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @作者:
	 * @返回值:	String
	 */
	public static String toJson(HttpServletRequest request) throws UnsupportedEncodingException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(ServletInputStream) request.getInputStream(), "utf-8"));
		String temp;
		StringBuffer buffer = new StringBuffer() ;
		while ((temp = br.readLine()) != null) {
			buffer.append(temp);
		}
		br.close();
		return buffer.toString();
	}
	  /**
	   * 将java对象转换成json字符串  
	   * @方法说明:
	   * @方法名称:beanToJson
	   * @param bean
	   * @return
	   * @作者:
	   * @返回值:	String
	   */
    public static String beanToJson(Object bean) {
        JSONObject json = JSONObject.fromObject(bean);
        return json.toString();
 
    }

}
