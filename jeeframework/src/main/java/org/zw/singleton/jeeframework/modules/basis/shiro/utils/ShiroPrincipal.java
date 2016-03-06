package org.zw.singleton.jeeframework.modules.basis.shiro.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;

/**
 * 获取登录信息
  * @ClassName:ShiroPrincipal
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月18日-下午1:57:56
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class ShiroPrincipal {

	/**
	 * @MethodsDescription: 得到登录者信息
	 * @MethodName:getPrincipal
	 * @return
	 * @Author:singleton-zw
	 * @Return:Object
	 */
	public static Object getPrincipal(){
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null){
			return subject.getPrincipal();
//			System.err.println("get 请求"+principal);
		}
		return null;
	}
	
	/**
	 * @MethodsDescription:
	 * @MethodName:getPrincipalSys
	 * @return
	 * @Author:singleton-zw
	 * @Return:SysUser
	 */
	public static SysUser getPrincipalSys(){
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null){
			return (SysUser)subject.getPrincipal();
//			System.err.println("get 请求"+principal);
		}
		return null;
	}
}
