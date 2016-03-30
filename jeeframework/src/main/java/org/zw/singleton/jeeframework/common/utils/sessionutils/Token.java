package org.zw.singleton.jeeframework.common.utils.sessionutils;

import java.util.Random;

import javax.servlet.http.HttpSession;

/**
 * 
  * @ClassName:Token
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年3月30日-上午11:50:48
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class Token {

	private static final Random random = new Random(System.currentTimeMillis());
	public static final String TOKENPARAM = "session-token";
	 
	/** 生成一个token */
	public static synchronized String generateToken(HttpSession session) {
	    String s = String.valueOf(random.nextLong());
	    session.setAttribute(TOKENPARAM, s);
	    return s;
	}
	
}
