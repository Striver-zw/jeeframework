/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-25 15:48:08
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookdesc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.bookdesc.dao.AppBookdescDao;
import org.zw.singleton.jeeframework.modules.appinterface.bookdesc.entity.AppBookdesc;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppBookdescService
  * @Description:健康图书列表
  * @Author: singleton_zw
  * @CreateDate: 2016-01-25 15:48:08
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppBookdescService {

	@Autowired
	private AppBookdescDao appBookdescDao;

	public int saveAppBookdesc(AppBookdesc appBookdesc) {
		return this.appBookdescDao.saveMode(appBookdesc);
	}

	public Page<AppBookdesc> pageSelect(Page<AppBookdesc> page) {
		page.setDataList(this.appBookdescDao.findSelectPage( page));
		return page;
	}

	public List<AppBookdesc> pageSelect(AppBookdesc entity) {
		return this.appBookdescDao.findSelect(entity);
	}

	public AppBookdesc get(AppBookdesc appBookdesc) {
		return this.appBookdescDao.getMode(appBookdesc);
	}

	public int updateAppBookdesc(AppBookdesc appBookdesc) {
		return this.appBookdescDao.updateMode(appBookdesc);
	}

	public int deleteAppBookdesc(AppBookdesc appBookdesc) {
		return this.appBookdescDao.deleteMode(appBookdesc);
	}

	

}