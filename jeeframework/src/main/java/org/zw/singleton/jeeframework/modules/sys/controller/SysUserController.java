/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 14:02:02
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.controller;

import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.sys.service.SysUserService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @ClassName:SysUserController
  * @Description:系统用户
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 14:02:02
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "SysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@ResponseBody
	@RequestMapping(value = { "/sysUserList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody SysUser sysUser,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


}