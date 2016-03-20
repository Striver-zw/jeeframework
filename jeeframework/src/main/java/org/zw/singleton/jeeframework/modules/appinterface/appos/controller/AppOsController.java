/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-18 22:18:18
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appos.controller;

import java.util.Date;
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
import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.common.utils.random.IdGen;
import org.zw.singleton.jeeframework.modules.appinterface.appos.entity.AppOs;
import org.zw.singleton.jeeframework.modules.appinterface.appos.service.AppOsService;
import org.zw.singleton.jeeframework.modules.basis.base.RequestStatus;


/**  
  * @类名:AppOsController
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-18 22:18:18
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Controller
@RequestMapping(value = "${interfacePath}/AppOs")
public class AppOsController {

	@Autowired
	private AppOsService appOsService;

	@ResponseBody
	@RequestMapping(value = { "/appOsList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(AppOs appOs,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		System.out.println(appOs.getFrom());
		
		return map;
	}
	
	/**
	 * 保存app信息
	 * @方法说明:
	 * @方法名称:saveAppOs
	 * @param requestStatus
	 * @param request
	 * @param response
	 * @return
	 * @作者:张威
	 * @返回值:	Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = { "/saveAppOs.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String, Object> saveAppOs(@RequestBody RequestStatus<AppOs> requestStatus, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (requestStatus.getData().getModel() != null) {
				AppOs data = requestStatus.getData();
				data.setFrom(data.getFrom().toUpperCase());
//				System.out.println(appOsService.getAppOsCheck(data));
				if (appOsService.getAppOsCheck(data) == null) {
					data.setId(IdGen.getUUID());
					data.setInstallTime(new Date());
//					System.out.println(requestStatus.getData().toString());
					int saveAppOs = appOsService.saveAppOs(data);
//					System.out.println(saveAppOs);
					if (saveAppOs == 1) {
						map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "1", "数据保存成功", null);
					} else {
						map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "0", "数据保存失败", null);
					}
				} else {
					map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "0", "数据保存重复操作", null);
				}
			} else {
				map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "0", "参数为空", null);
			}
		} catch (Exception e) {
			map = FinalData.puttingMap("0", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}