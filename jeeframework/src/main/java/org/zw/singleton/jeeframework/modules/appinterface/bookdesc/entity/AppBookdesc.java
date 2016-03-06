/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-25 15:48:08
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.bookdesc.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppBookdesc
  * @Description:健康图书列表
  * @Author: singleton_zw
  * @CreateDate: 2016-01-25 15:48:08
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppBookdesc extends BaseEntity<AppBookdesc> {

	private Integer bookclass;	// 
	private String count;	// 
	private Integer fcount;	// 
	private String from;	// 
	private String img;	// 
	private String name;	// 
	private Integer rcount;	// 
	private String summary;	// 
	private Integer typeId;	//分类id 

	public Integer getBookclass() {
		 return bookclass;
	}
	public void setBookclass(Integer bookclass) {
		 this.bookclass = bookclass;
	}
	public String getCount() {
		 return count;
	}
	public void setCount(String count) {
		 this.count = count;
	}
	public Integer getFcount() {
		 return fcount;
	}
	public void setFcount(Integer fcount) {
		 this.fcount = fcount;
	}
	public String getFrom() {
		 return from;
	}
	public void setFrom(String from) {
		 this.from = from;
	}
	public String getImg() {
		 return img;
	}
	public void setImg(String img) {
		 this.img = img;
	}
	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public Integer getRcount() {
		 return rcount;
	}
	public void setRcount(Integer rcount) {
		 this.rcount = rcount;
	}
	public String getSummary() {
		 return summary;
	}
	public void setSummary(String summary) {
		 this.summary = summary;
	}
	public Integer getTypeId() {
		 return typeId;
	}
	public void setTypeId(Integer typeId) {
		 this.typeId = typeId;
	}
}