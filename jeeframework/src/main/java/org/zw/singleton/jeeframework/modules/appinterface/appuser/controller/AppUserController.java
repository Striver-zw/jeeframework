/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:20:30
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appuser.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.entity.AppUser;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.service.AppUserService;


/**  
  * @类名:AppUserController
  * @类描述:app用户
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:20:30
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Controller
@RequestMapping(value = "${adminPath}/AppUser")
public class AppUserController {

	@Autowired
	private AppUserService appUserService;

	@ResponseBody
	@RequestMapping(value = { "/appUserList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody AppUser appUser,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


	/**
	 * 登录
	 * @方法说明:
	 * @方法名称:loginAppuser
	 * @param appuser
	 * @param request
	 * @param response
	 * @return
	 * @作者:张威
	 * @返回值:Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = { "/loginAppuser.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> loginAppuser(@RequestBody AppUser appuser,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		AppUser appuser2 = appUserService.loginAppUser(appuser);
		if(appuser2!=null){
			map.put("status", "1");
			map.put("mes", "success");
			map.put("data", appuser2);
		}else{
			map.put("status", "1");
			map.put("mes", "success");
			map.put("data", new HashMap<String,Object>());
		}
		
//		MailUtils n = new MailUtils();
//		n.sendmail();
		return map;
	}
}