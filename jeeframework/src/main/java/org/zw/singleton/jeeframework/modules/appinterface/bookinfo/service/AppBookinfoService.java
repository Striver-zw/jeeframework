/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 10:09:06
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.bookinfo.dao.AppBookinfoDao;
import org.zw.singleton.jeeframework.modules.appinterface.bookinfo.entity.AppBookinfo;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppBookinfoService
  * @Description:健康图书详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 10:09:06
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppBookinfoService {

	@Autowired
	private AppBookinfoDao appBookinfoDao;

	public int saveAppBookinfo(AppBookinfo appBookinfo) {
		return this.appBookinfoDao.saveMode(appBookinfo);
	}

	public Page<AppBookinfo> pageSelect(Page<AppBookinfo> page) {
		page.setDataList(this.appBookinfoDao.findSelectPage( page));
		return page;
	}

	public List<AppBookinfo> pageSelect(AppBookinfo entity) {
		return this.appBookinfoDao.findSelect(entity);
	}

	public AppBookinfo get(AppBookinfo appBookinfo) {
		return this.appBookinfoDao.getMode(appBookinfo);
	}

	public int updateAppBookinfo(AppBookinfo appBookinfo) {
		return this.appBookinfoDao.updateMode(appBookinfo);
	}

	public int deleteAppBookinfo(AppBookinfo appBookinfo) {
		return this.appBookinfoDao.deleteMode(appBookinfo);
	}

	

}