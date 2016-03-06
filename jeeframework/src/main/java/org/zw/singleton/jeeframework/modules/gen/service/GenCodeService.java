/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-16 23:04:56
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.gen.service;

import org.zw.singleton.jeeframework.modules.gen.entity.GenCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.gen.dao.GenCodeDao;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;


/**  
  * @className:GenCodeService
  * @description:代码生成
  * @author: singleton_zw
  * @createDate: 2016-02-16 23:04:56
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version:
  * @Copyright
*/
@Service
public class GenCodeService {

	@Autowired
	private GenCodeDao genCodeDao;

	public int saveGenCode(GenCode genCode) {
		return this.genCodeDao.saveMode(genCode);
	}

	public Page<GenCode> pageSelect(Page<GenCode> page) {
		page.setDataList(this.genCodeDao.findSelectPage(page));
		return page;
	}

	public List<GenCode> pageSelect(GenCode entity) {
		return this.genCodeDao.findSelect(entity);
	}

	public GenCode get(GenCode genCode) {
		return this.genCodeDao.getMode(genCode);
	}

	public int updateGenCode(GenCode genCode) {
		return this.genCodeDao.updateMode(genCode);
	}

	public int deleteGenCode(GenCode genCode) {
		return this.genCodeDao.deleteMode(genCode);
	}

	

}