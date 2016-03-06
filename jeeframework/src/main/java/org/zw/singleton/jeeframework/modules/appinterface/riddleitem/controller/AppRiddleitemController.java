/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 15:43:07
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.riddleitem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.entity.AppRiddleitem;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.service.AppRiddleitemService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @ClassName:AppRiddleitemController
  * @Description:谜语详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 15:43:07
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "AppRiddleitem")
public class AppRiddleitemController {

	@Autowired
	private AppRiddleitemService appRiddleitemService;

	@ResponseBody
	@RequestMapping(value = { "/appRiddleitemList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody AppRiddleitem appRiddleitem,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


}