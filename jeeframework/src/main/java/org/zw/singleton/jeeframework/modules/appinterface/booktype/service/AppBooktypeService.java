/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-25 15:11:59
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.booktype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.booktype.dao.AppBooktypeDao;
import org.zw.singleton.jeeframework.modules.appinterface.booktype.entity.AppBooktype;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppBooktypeService
  * @Description:健康图书分类
  * @Author: singleton_zw
  * @CreateDate: 2016-01-25 15:11:59
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppBooktypeService {

	@Autowired
	private AppBooktypeDao appBooktypeDao;

	public int saveAppBooktype(AppBooktype appBooktype) {
		return this.appBooktypeDao.saveMode(appBooktype);
	}

	public Page<AppBooktype> pageSelect(Page<AppBooktype> page) {
		page.setDataList(this.appBooktypeDao.findSelectPage( page));
		return page;
	}

	public List<AppBooktype> pageSelect(AppBooktype entity) {
		return this.appBooktypeDao.findSelect(entity);
	}

	public AppBooktype get(AppBooktype appBooktype) {
		return this.appBooktypeDao.getMode(appBooktype);
	}

	public int updateAppBooktype(AppBooktype appBooktype) {
		return this.appBooktypeDao.updateMode(appBooktype);
	}

	public int deleteAppBooktype(AppBooktype appBooktype) {
		return this.appBooktypeDao.deleteMode(appBooktype);
	}

	

}