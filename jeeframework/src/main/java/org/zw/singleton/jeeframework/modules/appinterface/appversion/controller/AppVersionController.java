/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:30:53
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appversion.controller;

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
import org.zw.singleton.jeeframework.app.version.VersionUtils;
import org.zw.singleton.jeeframework.common.constant.FinalData;
import org.zw.singleton.jeeframework.common.utils.datavalue.DataUnescape;
import org.zw.singleton.jeeframework.modules.appinterface.appversion.entity.AppVersion;
import org.zw.singleton.jeeframework.modules.appinterface.appversion.service.AppVersionService;
import org.zw.singleton.jeeframework.modules.basis.base.RequestStatus;


/**  
  * @类名:AppVersionController
  * @类描述:app版本号
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:30:53
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Controller
@RequestMapping(value = "${interfacePath}/AppVersion")
public class AppVersionController {

	@Autowired
	private AppVersionService appVersionService;

	@ResponseBody
	@RequestMapping(value = { "/appVersionList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody AppVersion appVersion,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


	/**
	 * 获取版本号
	 * @方法说明:
	 * @方法名称:loginAppuser
	 * @param appVersion
	 * @param request
	 * @param response
	 * @return
	 * @作者:张威
	 * @返回值:Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAppVersionCode.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> loginAppuser(@RequestBody RequestStatus<AppVersion> requestStatus,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		try {
			AppVersion version = appVersionService.getAppVersionCode();
			if(version!=null){
//				需要更新
				if(VersionUtils.compareVersion(version.getVersionName(), requestStatus.getData().getVersionName())>0){
					version.setVersionValue(DataUnescape.unescapeJava(version.getVersionValue()));
					map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS, "1", "需要更新", version);
				}else{
					map = FinalData.puttingMap("1", FinalData.MESG_SUCCESS,"0","不需要更新", null);
				}
			}else{
				map = FinalData.puttingMap("1",FinalData.MESG_SUCCESS,"0","不需要更新", null);
			}
		} catch (Exception e) {
			map = FinalData.puttingMap("0", FinalData.MESG_ERROR);
			e.printStackTrace();
		}
		return map;
	}

}