/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 15:31:57
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.riddletype.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppRiddletype
  * @Description:谜语类型
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 15:31:57
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppRiddletype extends BaseEntity<AppRiddletype> {

	private String name;	// 
	private Integer typeId;	// 

	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public Integer getTypeId() {
		 return typeId;
	}
	public void setTypeId(Integer typeId) {
		 this.typeId = typeId;
	}
}