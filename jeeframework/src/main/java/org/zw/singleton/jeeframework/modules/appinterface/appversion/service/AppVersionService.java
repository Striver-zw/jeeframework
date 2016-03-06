/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:30:53
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appversion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.appversion.dao.AppVersionDao;
import org.zw.singleton.jeeframework.modules.appinterface.appversion.entity.AppVersion;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @类名:AppVersionService
  * @类描述:app版本号
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:30:53
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Service
public class AppVersionService {

	@Autowired
	private AppVersionDao appVersionDao;

	public int saveAppVersion(AppVersion appVersion) {
		return this.appVersionDao.saveMode(appVersion);
	}

	public Page<AppVersion> pageSelect(Page<AppVersion> page) {
		page.setDataList(this.appVersionDao.findSelectPage(page));
		return page;
	}

	public List<AppVersion> pageSelect(AppVersion entity) {
		return this.appVersionDao.findSelect(entity);
	}

	public AppVersion get(AppVersion appVersion) {
		return this.appVersionDao.getMode(appVersion);
	}

	public int updateAppVersion(AppVersion appVersion) {
		return this.appVersionDao.updateMode(appVersion);
	}

	public int deleteAppVersion(AppVersion appVersion) {
		return this.appVersionDao.deleteMode(appVersion);
	}

	/**
	 * 获取最新的版本号
	 * @方法说明:
	 * @方法名称:getAppVersionCode
	 * @param appVersion
	 * @return
	 * @作者:张威
	 * @返回值:AppVersion
	 */
	public AppVersion getAppVersionCode() {
		AppVersion appVersion =new AppVersion();
		appVersion.setStatus(1);
		return this.appVersionDao.getAppVersionCode(appVersion);
	}
	

}