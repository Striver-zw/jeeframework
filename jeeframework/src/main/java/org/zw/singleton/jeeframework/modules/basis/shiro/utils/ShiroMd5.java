package org.zw.singleton.jeeframework.modules.basis.shiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 
  * @className: ShiroMd5
  * @description:shiro加密  使用盐值
  * @author: singleton-zw
  * @createDate: 2016年2月5日-下午10:31:36
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class ShiroMd5 {
	//默认迭代 1
	public static final int HASH_INTERATIONS = 1;
	public static final String HASH_NAME = "md5";

	/**
	 * @methodsDescription: 使用shiro来加密 盐值使用用户名
	 * @methodName: md5
	 * @param password 原始密码
	 * @param salt 盐值
	 * @return 加密后的数据
	 * @author: singleton-zw
	 * @return: String
	 */
	public static String md5(String password,String salt) {
		String p = null;
//		p = new Md5Hash(password, salt).toBase64();
		Md5Hash md = new Md5Hash(password, salt);
		//迭代次数
		md.setIterations(ShiroMd5.HASH_INTERATIONS);
		p = md.toHex();
		return p;
	}
	
	public static void main(String[] args) {
		String md5 = md5("123", "zw");
		System.out.println(md5);
	}
	
	/**
	 * @methodsDescription: 判断是否为空
	 * @methodName: isEmpty
	 * @param obj
	 * @return
	 * @author: singleton-zw
	 * @return: boolean
	 */
	public static boolean isEmpty(Object obj) {
		
		if(obj instanceof String) {
			return "".equals(obj);
		}
		
		if(obj instanceof Integer) {
			return (Integer)obj==0;
		}
		if(obj==null) return true;
		else return false;
	}
	
}
