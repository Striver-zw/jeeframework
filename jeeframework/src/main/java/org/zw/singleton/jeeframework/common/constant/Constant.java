package org.zw.singleton.jeeframework.common.constant;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
/**
 * 
  * @类名:Constant
  * @类描述:获取项目中需要的路径
  * @作者:zw
  * @创建时间:2015年9月15日-上午11:18:31
  * @修改人:
  * @修改时间:2015年11月27日 14:24:18
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class Constant {
	public static String PORT = ":8080";
	
	/**
	 * 全路径
	 * http://192.168.1.118:8080/xxx/
	 * @方法说明:
	 * @方法名称:getPathDatatupian
	 * @param request
	 * @return
	 * @作者:zw
	 * @返回值:	String
	 */
	public static String getPathTupian(HttpServletRequest request){
		String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
//		+request.getContextPath()
		return path;
	}
	/**
	 * 图片保存地址
	 * @方法说明:
	 * @方法名称:getTupianSave
	 * @param request
	 * @return
	 * @作者:zw
	 * @返回值:	String
	 */
	public static String getTupianSave1(HttpServletRequest request){
//		request.getSession().getServletContext().getRealPath("/");
		String path = request.getRealPath("/");
		File file =new File(path);    
		if(!file .exists()  && !file .isDirectory()){       
		    file .mkdir();    
		}
		return path;
	}
	
	public static String getTupianSave2(HttpServletRequest request){
//		request.getContextPath()
		String path = request.getRealPath("/");
		File file =new File(path);    
		//如果文件夹不存在则创建    
		if(!file .exists()  && !file .isDirectory()){       
		    file .mkdir();    
		}
		return path;
	}
	
	/**
	 * @方法说明: 获取图片 http://localhost:8080/ 拿图片的时候去拼接图片地址
	 * @方法名称:getPathData
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String getPathData(HttpServletRequest request){
		String path = request.getScheme()+"://"+request.getServerName()+":"+PORT;
		return path;
	}
	
	/**
	 * 本项目地址
	 * @方法说明:
	 * @方法名称:getLocalhostPathData
	 * @param request
	 * @return
	 * @作者:zw
	 * @返回值:	String
	 */
	public static String getLocalhostPathData(HttpServletRequest request){
		String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		return path;
	}
	
	/**
	 * 
	 * @MethodsDescription:拼接全url
	 * @MethodName:getLHUrl
	 * @param request
	 * @param data
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	public static String getLHUrl(HttpServletRequest request,String data){
		String pathData = getLocalhostPathData(request);
		if(!"".equals(data)|| data!=null){
			return pathData+data;
		}
		return null;
	}

}
