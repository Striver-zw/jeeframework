/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-01-27 17:03:17
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.joke.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:AppJoke
  * @Description:笑话大全
  * @Author: singleton_zw
  * @CreateDate: 2016-01-27 17:03:17
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class AppJoke extends BaseEntity<AppJoke> {

	private String ct;	// 
	private String img;	// 
	private String title;	// 
	private Integer type;	// 
	private String text;	// 

	public String getCt() {
		 return ct;
	}
	public void setCt(String ct) {
		 this.ct = ct;
	}
	public String getImg() {
		 return img;
	}
	public void setImg(String img) {
		 this.img = img;
	}
	public String getTitle() {
		 return title;
	}
	public void setTitle(String title) {
		 this.title = title;
	}
	public Integer getType() {
		 return type;
	}
	public void setType(Integer type) {
		 this.type = type;
	}
	public String getText() {
		 return text;
	}
	public void setText(String text) {
		 this.text = text;
	}
	public AppJoke() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppJoke(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	public AppJoke(Integer type) {
		super();
		this.type = type;
	}
	
}