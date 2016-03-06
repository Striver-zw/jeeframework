/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:22:54
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:SysRole
  * @Description:角色管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:22:54
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class SysRole extends BaseEntity<SysRole> {

	private String officeId;	//归属机构 
	private String name;	//角色名称 
	private String enname;	//英文名称 
	private String useable;	//是否可用 
	private String createBy;	//创建者 
	private Date createDate;	//创建时间 
	private Date updateDate;	//更新时间 
	private String remarks;	//备注信息 
	private String delFlag;	//删除标记 

	public String getOfficeId() {
		 return officeId;
	}
	public void setOfficeId(String officeId) {
		 this.officeId = officeId;
	}
	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public String getEnname() {
		 return enname;
	}
	public void setEnname(String enname) {
		 this.enname = enname;
	}
	public String getUseable() {
		 return useable;
	}
	public void setUseable(String useable) {
		 this.useable = useable;
	}
	public String getCreateBy() {
		 return createBy;
	}
	public void setCreateBy(String createBy) {
		 this.createBy = createBy;
	}
	public Date getCreateDate() {
		 return createDate;
	}
	public void setCreateDate(Date createDate) {
		 this.createDate = createDate;
	}
	public Date getUpdateDate() {
		 return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		 this.updateDate = updateDate;
	}
	public String getRemarks() {
		 return remarks;
	}
	public void setRemarks(String remarks) {
		 this.remarks = remarks;
	}
	public String getDelFlag() {
		 return delFlag;
	}
	public void setDelFlag(String delFlag) {
		 this.delFlag = delFlag;
	}
}