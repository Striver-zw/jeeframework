/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 15:31:57
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.riddletype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.dao.AppRiddletypeDao;
import org.zw.singleton.jeeframework.modules.appinterface.riddletype.entity.AppRiddletype;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppRiddletypeService
  * @Description:谜语类型
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 15:31:57
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppRiddletypeService {

	@Autowired
	private AppRiddletypeDao appRiddletypeDao;

	public int saveAppRiddletype(AppRiddletype appRiddletype) {
		return this.appRiddletypeDao.saveMode(appRiddletype);
	}

	public Page<AppRiddletype> pageSelect(Page<AppRiddletype> page) {
		page.setDataList( this.appRiddletypeDao.findSelectPage( page));
		return page;
	}

	public List<AppRiddletype> pageSelect(AppRiddletype entity) {
		return this.appRiddletypeDao.findSelect(entity);
	}

	public AppRiddletype get(AppRiddletype appRiddletype) {
		return this.appRiddletypeDao.getMode(appRiddletype);
	}

	public int updateAppRiddletype(AppRiddletype appRiddletype) {
		return this.appRiddletypeDao.updateMode(appRiddletype);
	}

	public int deleteAppRiddletype(AppRiddletype appRiddletype) {
		return this.appRiddletypeDao.deleteMode(appRiddletype);
	}

	

}