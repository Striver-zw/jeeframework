/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 11:28:31
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookintem.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppBookintem
  * @Description:健康图书页面详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 11:28:31
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppBookintem extends BaseEntity<AppBookintem> {

	private String message;	// 
	private String title;	// 
	private Integer book;	// 

	public String getMessage() {
		 return message;
	}
	public void setMessage(String message) {
		 this.message = message;
	}
	public String getTitle() {
		 return title;
	}
	public void setTitle(String title) {
		 this.title = title;
	}
	public Integer getBook() {
		 return book;
	}
	public void setBook(Integer book) {
		 this.book = book;
	}
}