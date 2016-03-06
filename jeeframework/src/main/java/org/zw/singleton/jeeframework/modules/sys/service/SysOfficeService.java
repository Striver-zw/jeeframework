/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:21:50
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.service;

import org.zw.singleton.jeeframework.modules.sys.entity.SysOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.sys.dao.SysOfficeDao;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;


/**  
  * @ClassName:SysOfficeService
  * @Description:公司管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:21:50
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class SysOfficeService {

	@Autowired
	private SysOfficeDao sysOfficeDao;

	public int saveSysOffice(SysOffice sysOffice) {
		return this.sysOfficeDao.saveMode(sysOffice);
	}

	public Page<SysOffice> pageSelect(Page<SysOffice> page) {
		page.setDataList(this.sysOfficeDao.findSelectPage(page));
		return page;
	}

	public List<SysOffice> pageSelect(SysOffice entity) {
		return this.sysOfficeDao.findSelect(entity);
	}

	public SysOffice get(SysOffice sysOffice) {
		return this.sysOfficeDao.getMode(sysOffice);
	}

	public int updateSysOffice(SysOffice sysOffice) {
		return this.sysOfficeDao.updateMode(sysOffice);
	}

	public int deleteSysOffice(SysOffice sysOffice) {
		return this.sysOfficeDao.deleteMode(sysOffice);
	}

	

}