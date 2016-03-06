/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 11:28:31
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookintem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.dao.AppBookintemDao;
import org.zw.singleton.jeeframework.modules.appinterface.bookintem.entity.AppBookintem;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppBookintemService
  * @Description:健康图书页面详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 11:28:31
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppBookintemService {

	@Autowired
	private AppBookintemDao appBookintemDao;

	public int saveAppBookintem(AppBookintem appBookintem) {
		return this.appBookintemDao.saveMode(appBookintem);
	}

	public Page<AppBookintem> pageSelect(Page<AppBookintem> page) {
		page.setDataList(this.appBookintemDao.findSelectPage( page));
		return page;
	}

	public List<AppBookintem> pageSelect(AppBookintem entity) {
		return this.appBookintemDao.findSelect(entity);
	}

	public AppBookintem get(AppBookintem appBookintem) {
		return this.appBookintemDao.getMode(appBookintem);
	}

	public int updateAppBookintem(AppBookintem appBookintem) {
		return this.appBookintemDao.updateMode(appBookintem);
	}

	public int deleteAppBookintem(AppBookintem appBookintem) {
		return this.appBookintemDao.deleteMode(appBookintem);
	}

	

}