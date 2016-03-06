/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 11:28:31
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookintem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.entity.AppBookintem;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.service.AppBookintemService;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @ClassName:AppBookintemController
  * @Description:健康图书页面详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 11:28:31
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "AppBookintem")
public class AppBookintemController {

	@Autowired
	private AppBookintemService appBookintemService;

	@ResponseBody
	@RequestMapping(value = { "/appBookintemList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody AppBookintem appBookintem,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


}