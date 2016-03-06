/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 15:43:07
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.riddleitem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.dao.AppRiddleitemDao;
import org.zw.singleton.jeeframework.modules.appinterface.riddleitem.entity.AppRiddleitem;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppRiddleitemService
  * @Description:谜语详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 15:43:07
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppRiddleitemService {

	@Autowired
	private AppRiddleitemDao appRiddleitemDao;

	public int saveAppRiddleitem(AppRiddleitem appRiddleitem) {
		return this.appRiddleitemDao.saveMode(appRiddleitem);
	}

	public Page<AppRiddleitem> pageSelect(Page<AppRiddleitem> page) {
		page.setDataList(this.appRiddleitemDao.findSelectPage( page));
		return page;
	}

	public List<AppRiddleitem> pageSelect(AppRiddleitem entity) {
		return this.appRiddleitemDao.findSelect(entity);
	}

	public AppRiddleitem get(AppRiddleitem appRiddleitem) {
		return this.appRiddleitemDao.getMode(appRiddleitem);
	}

	public int updateAppRiddleitem(AppRiddleitem appRiddleitem) {
		return this.appRiddleitemDao.updateMode(appRiddleitem);
	}

	public int deleteAppRiddleitem(AppRiddleitem appRiddleitem) {
		return this.appRiddleitemDao.deleteMode(appRiddleitem);
	}

	

}