/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-16 23:04:56
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.gen.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @className:GenCode
  * @description:代码生成
  * @author: singleton_zw
  * @createDate: 2016-02-16 23:04:56
  * @updateAuthor:
  * @updateDate:
  * @updateDesc:
  * @version:
  * @Copyright
*/
public class GenCode extends BaseEntity<GenCode> {

	private String templateName;	//模块名 
	private String author;	//生产者 
	private String desc;	//模块描述 
	private String tableName;	//表明 
	private String alias;	//别名（两套代码 
	private Date createdate;	//生成时间 

	public String getTemplateName() {
		 return templateName;
	}
	public void setTemplateName(String templateName) {
		 this.templateName = templateName;
	}
	public String getAuthor() {
		 return author;
	}
	public void setAuthor(String author) {
		 this.author = author;
	}
	public String getDesc() {
		 return desc;
	}
	public void setDesc(String desc) {
		 this.desc = desc;
	}
	public String getTableName() {
		 return tableName;
	}
	public void setTableName(String tableName) {
		 this.tableName = tableName;
	}
	public String getAlias() {
		 return alias;
	}
	public void setAlias(String alias) {
		 this.alias = alias;
	}
	public Date getCreatedate() {
		 return createdate;
	}
	public void setCreatedate(Date createdate) {
		 this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "GenCode [templateName=" + templateName + ", author=" + author + ", desc=" + desc + ", tableName="
				+ tableName + ", alias=" + alias + ", createdate=" + createdate + "]";
	}
	
	
}