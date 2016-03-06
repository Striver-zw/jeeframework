/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-27 17:03:17
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.joke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.appinterface.joke.dao.AppJokeDao;
import org.zw.singleton.jeeframework.modules.appinterface.joke.entity.AppJoke;
import org.zw.singleton.jeeframework.modules.basis.page.Page;

import java.util.List;


/**  
  * @ClassName:AppJokeService
  * @Description:笑话大全
  * @Author: singleton_zw
  * @CreateDate: 2016-01-27 17:03:17
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class AppJokeService {

	@Autowired
	private AppJokeDao appJokeDao;

	public int saveAppJoke(AppJoke appJoke) {
		return this.appJokeDao.saveMode(appJoke);
	}

	public Page<AppJoke> pageSelect(Page<AppJoke> page) {
		page.setDataList(this.appJokeDao.findSelectPage(page));
		return page;
	}

	public List<AppJoke> pageSelect(AppJoke entity) {
		return this.appJokeDao.findSelect(entity);
	}

	public AppJoke get(AppJoke appJoke) {
		return this.appJokeDao.getMode(appJoke);
	}

	public int updateAppJoke(AppJoke appJoke) {
		return this.appJokeDao.updateMode(appJoke);
	}

	public int deleteAppJoke(AppJoke appJoke) {
		return this.appJokeDao.deleteMode(appJoke);
	}

	

}