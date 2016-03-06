package org.zw.singleton.jeeframework.app.version;
/**
 * 比较版本号、
 * 参考资料 http://blog.csdn.net/sowhat_ah/article/details/43955337
  * @类名:VersionUtils
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月14日-上午10:13:36
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class VersionUtils {

	/** 
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0 
	 * 如果大于0  则更新了几个版本
	 * 通常版本号如：1.3.20.8，6.82.20160101，8.5a/8.5c等；
	 * 通用规则就是，先将版本字符串按照点号分割，然后主版本与主版本比较、此版本与此版本比较，如此按序一级一级往后比较，直到有分出大小；
	 * 值得注意的是，很多比较版本号的方法都先将字符串转换成int或者double类型，这样做未必通用，因为可能含有字母，如8.5c这样的版本号；
	 * 通用的方式依然是将分割后的字符串当做字符串来比较，不过，比较字符串之前，先比较位数； 
	 * 
	 * * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0 
	 * @方法说明:
	 * @方法名称:compareVersion
	 * @param version1
	 * @param version2
	 * @return
	 * @throws Exception
	 * @作者:zw
	 * @返回值:int
	 */
	public static int compareVersion(String version1, String version2) throws Exception {  
	    if (version1 == null || version2 == null) {  
	        throw new Exception("compareVersion error:illegal params.");  
	    }  
	    String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；  
	    String[] versionArray2 = version2.split("\\.");  
	    int idx = 0;  
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
	    int diff = 0;  
	    while (idx < minLength  
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
	        ++idx;  
	    }  
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
	    return diff;  
	}
	
	public static void main(String[] args) {
		try {
			int version = compareVersion("9.1.1","8.1.1");
			System.out.println(version);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
