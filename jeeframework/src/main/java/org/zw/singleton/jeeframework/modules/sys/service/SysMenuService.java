/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:19:14
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.service;

import org.zw.singleton.jeeframework.modules.sys.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.sys.dao.SysMenuDao;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;


/**  
  * @ClassName:SysMenuService
  * @Description:菜单管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:19:14
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;

	public int saveSysMenu(SysMenu sysMenu) {
		return this.sysMenuDao.saveMode(sysMenu);
	}

	public Page<SysMenu> pageSelect(Page<SysMenu> page) {
		page.setDataList(this.sysMenuDao.findSelectPage(page));
		return page;
	}

	public List<SysMenu> pageSelect(SysMenu entity) {
		return this.sysMenuDao.findSelect(entity);
	}

	public SysMenu get(SysMenu sysMenu) {
		return this.sysMenuDao.getMode(sysMenu);
	}

	public int updateSysMenu(SysMenu sysMenu) {
		return this.sysMenuDao.updateMode(sysMenu);
	}

	public int deleteSysMenu(SysMenu sysMenu) {
		return this.sysMenuDao.deleteMode(sysMenu);
	}

	

}