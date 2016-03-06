package org.zw.singleton.jeeframework.common.utils.datau;

import org.zw.singleton.jeeframework.common.utils.datavalue.DataValue;

/**
 * 根据经纬度计算距离
  * @类名:CaculateDistance
  * @类描述:
  * @作者:zw
  * @创建时间:2015年11月7日-下午3:10:32
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class CaculateDistance {
	private static final double EARTH_RADIUS = 6378137.0;  
	/**
	 * 
	 * @方法说明:
	 * @方法名称:distance
	 * @param lat_a 我的纬度	28.200082
	 * @param lng_a 我的经度	113.019501
	 * @param lat_b 传人纬度	28.213478
	 * @param lng_b 传人经度	112.979353
	 * @return
	 * @作者:zw
	 * @返回值:double Km
	 */
	public static double distance(double lat_a, double lng_a, double lat_b, double lng_b) {  
	       double radLat1 = (lat_a * Math.PI / 180.0);  
	       double radLat2 = (lat_b * Math.PI / 180.0);  
	       double a = radLat1 - radLat2;  
	       double b = (lng_a - lng_b) * Math.PI / 180.0;  
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)  
	              + Math.cos(radLat1) * Math.cos(radLat2)  
	              * Math.pow(Math.sin(b / 2), 2)));  
	       s = s * EARTH_RADIUS;  
//	       s = Math.round((s * 10000) / 10000)/1000; 
//	       s = Math.round(s * 10000) / 10000; 
	       s = DataValue.doubleValueOne(((s * 10000) / 10000)/1000);
	       return s;  
	    } 

	/**
	 *  113.019501,28.200082：湖南省长沙市芙蓉区车站中路426号
	 *  湖南长沙立交桥西:112.979353,28.213478
	 * @方法说明:
	 * @方法名称:main
	 * @param args
	 * @作者:zw
	 * @返回值:void
	 */
	public static void main(String[] args) {
		System.out.println(distance(28.200082, 113.019501, 28.213478, 112.979353));
	}
}
