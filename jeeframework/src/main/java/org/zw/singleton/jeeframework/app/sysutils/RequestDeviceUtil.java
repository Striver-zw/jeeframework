package org.zw.singleton.jeeframework.app.sysutils;

import javax.servlet.http.HttpServletRequest;

/**
 * 判断请求的移动设备
  * @类名:RequestDeviceUtil
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月19日-下午3:27:37
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class RequestDeviceUtil {
	/**
	 * 旧版本
	 * @方法说明:
	 * @方法名称:isMobileDevice
	 * @param requestHeader
	 * @return
	 * @作者:张威
	 * @返回值:	boolean
	 */
	public static boolean isMobileDevice(HttpServletRequest request) {
		/**
		 * String requestHeader = request.getHeader("user-agent");
		 *  android :所有android设备 mac os : iphone ipad windows phone:Nokia等windows系统的手机
		 */
		String requestHeader = request.getHeader("user-agent");
		String[] deviceArray = new String[] { "android", "mac os", "windows phone" };
		if (requestHeader == null)
			return false;
		requestHeader = requestHeader.toLowerCase();
		for (int i = 0; i < deviceArray.length; i++) {
			if (requestHeader.indexOf(deviceArray[i]) > 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * String userAgent = request.getHeader("user-agent");
	 * @方法说明:
	 * @方法名称:isMobileDeviceNews
	 * @param userAgent
	 * @return
	 * @作者:张威
	 * @返回值:	boolean false 为移动端
	 */
	public static boolean isMobileDeviceNews(HttpServletRequest request){
		String userAgent = request.getHeader("user-agent");
		if(userAgent.indexOf("iPhone")!=-1 || userAgent.indexOf("iPad")!=-1 || userAgent.indexOf("Android")!=-1 || userAgent.indexOf("android")!=-1){
			return true;
		}else{
			return false;
		}
	}
}
