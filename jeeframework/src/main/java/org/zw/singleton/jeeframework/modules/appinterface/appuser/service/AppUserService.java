/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:20:30
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.dao.AppUserDao;
import org.zw.singleton.jeeframework.modules.appinterface.appuser.entity.AppUser;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @类名:AppUserService
  * @类描述:app用户
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:20:30
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Service
public class AppUserService {

	@Autowired
	private AppUserDao appUserDao;

	public int saveAppUser(AppUser appUser) {
		return this.appUserDao.saveMode(appUser);
	}

	public Page<AppUser> pageSelect(Page<AppUser> page) {
		page.setDataList(this.appUserDao.findSelectPage(page));
		return page;
	}

	public List<AppUser> pageSelect(AppUser entity) {
		return this.appUserDao.findSelect(entity);
	}

	public AppUser get(AppUser appUser) {
		return this.appUserDao.getMode(appUser);
	}

	public int updateAppUser(AppUser appUser) {
		return this.appUserDao.updateMode(appUser);
	}

	public int deleteAppUser(AppUser appUser) {
		return this.appUserDao.deleteMode(appUser);
	}

	public AppUser loginAppUser(AppUser appuser) {
		return this.appUserDao.loginAppUser(appuser);
	}

}