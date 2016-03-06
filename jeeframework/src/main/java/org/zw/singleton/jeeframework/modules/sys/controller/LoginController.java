package org.zw.singleton.jeeframework.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zw.singleton.jeeframework.modules.basis.shiro.utils.ShiroMd5;

/**
 * 登录Controller
  * @ClassName:LoginController
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月9日-下午2:29:16
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
@Controller
//@RequestMapping(value = "/login"
public class LoginController{
	
	/**
	 * 
	 * @MethodsDescription: 管理登录
	 * @MethodName:login
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		System.err.println("get 请求"+principal);
		if(principal!=null){
			return "redirect:/index";
		}
		return "/sys/login";
	}
	
	/**
	 * 
	 * @MethodsDescription: 管理登录 post请求
	 * @MethodName:login
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		System.err.println("-----");
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if(principal!=null){
			System.err.println("get 请求"+principal);
			return "redirect:/index";
		}
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String emsg = null;
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			emsg = e.getMessage();
		}
		if(ShiroMd5.isEmpty(emsg)) {
			//
			System.err.println("post 请求认证");
			return "redirect:/index";
		} else {
			model.addAttribute("emsg", emsg);
			return "sys/login";
		}
	}
	
	@RequiresPermissions("user")
	@RequestMapping(value="/index",method = { RequestMethod.POST, RequestMethod.GET })
	public String index(Model model) {
		System.err.println("-------index----");
	return "sys/index";
	}
	
	
	/**
	 * datautils
	 * @MethodsDescription:
	 * @MethodName:datautils
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 * @Author:singleton-zw
	 * @Return:String
	 */
	@RequiresPermissions("test:*")
	@RequestMapping(value="/admin/role/datautils",method = { RequestMethod.POST, RequestMethod.GET })
	public String datautils() {
		int i = 5/0;
			return "datautils";
	}
	
	@RequiresPermissions("test:*")
	@RequestMapping(value="/admin/role/datautils2",method = { RequestMethod.POST, RequestMethod.GET })
	public String datautils2() {
		
			return "error/403";
	}
	
	@RequiresPermissions("test1g")
	@RequestMapping(value="/test1",method = { RequestMethod.POST, RequestMethod.GET })
	public String test1() throws Exception{
		
		return "datautils";
	}
	
	
}
