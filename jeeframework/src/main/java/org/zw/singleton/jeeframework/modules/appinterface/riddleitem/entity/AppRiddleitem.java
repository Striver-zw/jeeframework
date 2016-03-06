/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 15:43:07
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.riddleitem.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppRiddleitem
  * @Description:谜语详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 15:43:07
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppRiddleitem extends BaseEntity<AppRiddleitem> {

	private String answer;	// 
	private String title;	// 
	private String typeId;	// 
	private String typeName;	// 

	public String getAnswer() {
		 return answer;
	}
	public void setAnswer(String answer) {
		 this.answer = answer;
	}
	public String getTitle() {
		 return title;
	}
	public void setTitle(String title) {
		 this.title = title;
	}
	public String getTypeId() {
		 return typeId;
	}
	public void setTypeId(String typeId) {
		 this.typeId = typeId;
	}
	public String getTypeName() {
		 return typeName;
	}
	public void setTypeName(String typeName) {
		 this.typeName = typeName;
	}
}