/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-19 15:45:33
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.codetest.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @类名:CodeTest
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-19 15:45:33
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
public class CodeTest extends BaseEntity<CodeTest> {

	private String name;	// 
	private String orter;	// 

	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public String getOrter() {
		 return orter;
	}
	public void setOrter(String orter) {
		 this.orter = orter;
	}
}