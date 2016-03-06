package org.zw.singleton.jeeframework.common.utils.Interception;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  字符串截取
  * @类名:StringInterceptionUtil
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月4日-上午10:53:57
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 1.0
  * @Copyright (c)-2015
 */
public class DataInterceptionUtil {

	/**
	 * 截取逗号分隔的字符
	 * @方法说明:
	 * @方法名称:interceptionComma
	 * @param data 需要截取的原始数据
	 * @return
	 * @作者:zw
	 * @返回值:String[]
	 */
	public static String[] interceptionComma(String data) {
		String[] split;
		if (data.equals("") || data == null) {
			return null;
		} else {
			try {
				String eng;
				//如果第一个是需要截取的字符
				if(",".equals(data.substring(0,1))){
					eng = data.substring(1, data.length());
					
				}else{
					eng = data.substring(0, data.length());
				}
				split = eng.split(",");
			} catch (Exception e) {
				split = null;
				e.printStackTrace();
			}
			return split;
		}
	}
		
	/**
	 * :截取字符串 存入到list
	 * @方法说明:
	 * @方法名称:addStringlist
	 * @param string 截取结果数组
	 * @return
	 * @作者:zw
	 * @返回值:List<String>
	 */
	public static List<String> addStringlist(String[] string) {
		List<String> list =  new ArrayList<String>();
		if (string != null && !"".equals(string)) {
			for (int i = 0; i < string.length; i++) {
				list.add(string[i]);
			}
		}
		return list;
	}
		
	/**
	 * 截取特殊字符串  需要转义的
	 * @方法说明:
	 * @方法名称:interceptionString2
	 * @param image
	 * @return
	 * @作者:zw
	 * @返回值:String[]
	 */
	public static String[] interceptionEscape(String data,String escape,boolean flag) {
		if (data.equals("") || data == null) {
			return null;
		}
		String[] split;
		try {
			String eng;
			// 如果第一个是特殊字符
			if (escape.equals(data.substring(0, 1))) {
				eng = data.substring(1, data.length());
			} else {
				eng = data.substring(0, data.length());
			}
			// 判断是不是转义字符
			if(flag){
				split = eng.split(escape);
			}else{
				split = eng.split("\\"+escape);
			}
		} catch (Exception e) {
			split = null;
			e.printStackTrace();
		}
		return split;
	}
		
	/**
	 * 	截取中文特殊字符
	 * getIntArray("1000元-2000元",true,1);
	 * @方法说明:
	 * @方法名称:getIntArray
	 * @param data 需要截取的数据
	 * @param flag 是否截取特殊字符
	 * @param i 截取的个数
	 * @return
	 * @作者:zw
	 * @返回值:int[]
	 */
	public static int[] getIntArray(String data, boolean flag, int i) {
		int[] d = new int[i];
		String[] split;
		String a = "";
		if (flag) {
			try {
				split = data.split("-");
				Pattern p = Pattern.compile("[0-9]");
				for (int j = 0; j < i; j++) {
					Matcher m = p.matcher(split[j]);
					while (m.find()) {
						a = a + m.group();
					}
					d[j] = Integer.parseInt(a);
					a = "";
				}
			} catch (Exception e) {
				d = null;
				e.printStackTrace();
			}
			return d;
		} else {
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(data);
			while (m.find()) {
				a = a + m.group();
			}
			d[0] = Integer.parseInt(a);
			return d; 
		}
	}
}
