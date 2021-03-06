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
import org.zw.singleton.jeeframework.common.constant.Constant;
import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.entity.AppUser;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.service.AppUserService;
import org.zw.singleton.jeeframework.modules.basis.base.RequestStatus;


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
@RequestMapping(value = "${interfacePath}/AppUser")
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
	public Map<String,Object> loginAppuser(@RequestBody RequestStatus<AppUser> appuser,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		try {
			AppUser appuser2 = appUserService.checkAppUser(appuser.getData());
			if(appuser2!=null){
				if(appuser2.getUserpassword().equals(appuser.getData().getUserpassword())){
					appuser2.setPortrait(Constant.getLHUrl(request,appuser2.getPortrait()));
					map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "1", "登录成功！", appuser2);
				}else{
					map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS,"0","密码错误！", null);
				}
			}else{
				map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "0", "该用户不存在！", null);
			}
		} catch (Exception e) {
			map = FinalData.puttingMap("0", FinalData.MESG_ERROR);
			e.printStackTrace();
		}
		return map;
	}
}