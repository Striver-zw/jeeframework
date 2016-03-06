/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-18 22:18:18
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.appos.dao.AppOsDao;
import org.zw.singleton.jeeframework.modules.appinterface.appos.entity.AppOs;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @类名:AppOsService
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-18 22:18:18
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Service
public class AppOsService {

	@Autowired
	private AppOsDao appOsDao;

	public int saveAppOs(AppOs appOs) {
		return this.appOsDao.saveMode(appOs);
	}

	public Page<AppOs> pageSelect(Page<AppOs> page) {
		page.setDataList(this.appOsDao.findSelectPage( page));
		return page;
	}

	public List<AppOs> pageSelect(AppOs entity) {
		return this.appOsDao.findSelect(entity);
	}

	public AppOs get(AppOs appOs) {
		return this.appOsDao.getMode(appOs);
	}

	public int updateAppOs(AppOs appOs) {
		return this.appOsDao.updateMode(appOs);
	}

	public int deleteAppOs(AppOs appOs) {
		return this.appOsDao.deleteMode(appOs);
	}

	/**
	 * 检查
	 * @方法说明:
	 * @方法名称:getAppOsCheck
	 * @param appOs
	 * @return
	 * @作者:张威
	 * @返回值:AppOs
	 */
	public AppOs getAppOsCheck(AppOs appOs){
		return appOsDao.getAppOsCheck(appOs);
	}

}