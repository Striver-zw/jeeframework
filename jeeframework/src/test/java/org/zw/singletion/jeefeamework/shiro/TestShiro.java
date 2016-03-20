package org.zw.singletion.jeefeamework.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.zw.singletion.jeeframework.test.BaseTest;

/**
 * SHIRO测试
  * @ClassName:TestShiro
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月7日-下午1:44:06
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
public class TestShiro extends BaseTest{

//	@Test
//	public void test() {
//		//
//		SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
//		//
//		SecurityUtils.setSecurityManager(manager);
//		//
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken upt = new UsernamePasswordToken("zw", "123");
//		try {
//			subject.login(upt);
//			System.out.println(subject.getPrincipal());
//		} catch (UnknownAccountException e) {
//			System.err.println("用户不存在");
//		} catch (IncorrectCredentialsException e) {
//			System.err.println("密码不正确");
//		}
//	}

}
