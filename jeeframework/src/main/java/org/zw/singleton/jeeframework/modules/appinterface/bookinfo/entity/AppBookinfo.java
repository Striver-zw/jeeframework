/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-26 10:09:06
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookinfo.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppBookinfo
  * @Description:健康图书详情
  * @Author: singleton_zw
  * @CreateDate: 2016-01-26 10:09:06
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppBookinfo extends BaseEntity<AppBookinfo> {

	private String title;	// 
	private Integer bookclass;	// 
	private Integer bookid;	// 

	public String getTitle() {
		 return title;
	}
	public void setTitle(String title) {
		 this.title = title;
	}
	public Integer getBookclass() {
		 return bookclass;
	}
	public void setBookclass(Integer bookclass) {
		 this.bookclass = bookclass;
	}
	public AppBookinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public AppBookinfo(String id, String title, Integer bookclass, Integer bookid) {
		super(id);
		this.title = title;
		this.bookclass = bookclass;
		this.bookid = bookid;
	}
	@Override
	public String toString() {
		return "AppBookinfo [title=" + title + ", bookclass=" + bookclass + ", bookid=" + bookid + "]";
	}
	
	
	
}