/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-19 15:45:33
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.codetest.controller;

import java.io.PrintWriter;
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
import org.zw.singleton.jeeframework.common.utils.json.BaseDataController;
import org.zw.singleton.jeeframework.modules.codetest.entity.CodeTest;
import org.zw.singleton.jeeframework.modules.codetest.service.CodeTestService;

import net.sf.json.JSONObject;


/**
 * 
  * @ClassName:CodeTestController
  * @Description: 测试所有技术点
  * @Author:singleton-zw
  * @CreateDate:2016年1月21日-下午5:17:56
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
@Controller
@RequestMapping(value = "CodeTest")
public class CodeTestController {

	@Autowired
	private CodeTestService codeTestService;

	@ResponseBody
	@RequestMapping(value = { "/codeTestList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody CodeTest codeTest,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


	/**
	 * 跨域请求
	 * jsoncallback ajax传过来的参数名
	 * @方法说明:
	 * @方法名称:crossdomain
	 * @param request
	 * @param response
	 * @return
	 * @作者:张威
	 * @返回值:String
	 */
	@RequestMapping(value = { "/crossdomain.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String crossdomain(HttpServletRequest request,HttpServletResponse response){
		JSONObject jsonObject;
		try {
			BaseDataController base = new BaseDataController();
			jsonObject = base.getPostPayloadbrooss(request);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("jsoncallback(" + jsonObject + ")");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}