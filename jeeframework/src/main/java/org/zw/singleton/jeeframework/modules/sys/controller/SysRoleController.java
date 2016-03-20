/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:22:54
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.controller;

import org.zw.singleton.jeeframework.modules.sys.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.sys.service.SysRoleService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @ClassName:SysRoleController
  * @Description:角色管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:22:54
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "/a/SysRole")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@ResponseBody
	@RequestMapping(value = { "/sysRoleList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody SysRole sysRole,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


}