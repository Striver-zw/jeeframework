/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-19 15:45:33
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.codetest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import org.zw.singleton.jeeframework.modules.codetest.dao.CodeTestDao;
import org.zw.singleton.jeeframework.modules.codetest.entity.CodeTest;

import java.util.List;


/**  
  * @类名:CodeTestService
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-19 15:45:33
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Service
public class CodeTestService {

	@Autowired
	private CodeTestDao codeTestDao;

	public int saveCodeTest(CodeTest codeTest) {
		return this.codeTestDao.saveMode(codeTest);
	}

	public Page<CodeTest> pageSelect(Page<CodeTest> page) {
		page.setDataList(this.codeTestDao.findSelectPage( page));
		return page;
	}

	public List<CodeTest> pageSelect(CodeTest entity) {
		return this.codeTestDao.findSelect(entity);
	}

	public CodeTest get(CodeTest codeTest) {
		return this.codeTestDao.getMode(codeTest);
	}

	public int updateCodeTest(CodeTest codeTest) {
		return this.codeTestDao.updateMode(codeTest);
	}

	public int deleteCodeTest(CodeTest codeTest) {
		return this.codeTestDao.deleteMode(codeTest);
	}

	

}