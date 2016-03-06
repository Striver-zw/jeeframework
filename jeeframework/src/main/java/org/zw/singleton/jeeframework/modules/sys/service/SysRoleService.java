/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:22:54
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.service;

import org.zw.singleton.jeeframework.modules.sys.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.sys.dao.SysRoleDao;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;


/**  
  * @ClassName:SysRoleService
  * @Description:角色管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:22:54
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	public int saveSysRole(SysRole sysRole) {
		return this.sysRoleDao.saveMode(sysRole);
	}

	public Page<SysRole> pageSelect(Page<SysRole> page) {
		page.setDataList(this.sysRoleDao.findSelectPage(page));
		return page;
	}

	public List<SysRole> pageSelect(SysRole entity) {
		return this.sysRoleDao.findSelect(entity);
	}

	public SysRole get(SysRole sysRole) {
		return this.sysRoleDao.getMode(sysRole);
	}

	public int updateSysRole(SysRole sysRole) {
		return this.sysRoleDao.updateMode(sysRole);
	}

	public int deleteSysRole(SysRole sysRole) {
		return this.sysRoleDao.deleteMode(sysRole);
	}

	

}