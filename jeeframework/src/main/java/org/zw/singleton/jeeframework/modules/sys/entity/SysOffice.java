/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:21:50
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:SysOffice
  * @Description:公司管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:21:50
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class SysOffice extends BaseEntity<SysOffice> {

	private String parentId;	//父级编号 
	private String parentIds;	//所有父级编号 
	private String name;	//名称 
	private String sort;	//排序 
	private String areaId;	//归属区域 
	private String address;	//联系地址 
	private String master;	//负责人 
	private String phone;	//电话 
	private String fax;	//传真 
	private String email;	//邮箱 
	private String uSEABLE;	//是否启用 
	private String createBy;	//创建者 
	private Date createDate;	//创建时间 
	private Date updateDate;	//更新时间 
	private String remarks;	//备注信息 
	private String delFlag;	//删除标记 

	public String getParentId() {
		 return parentId;
	}
	public void setParentId(String parentId) {
		 this.parentId = parentId;
	}
	public String getParentIds() {
		 return parentIds;
	}
	public void setParentIds(String parentIds) {
		 this.parentIds = parentIds;
	}
	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public String getSort() {
		 return sort;
	}
	public void setSort(String sort) {
		 this.sort = sort;
	}
	public String getAreaId() {
		 return areaId;
	}
	public void setAreaId(String areaId) {
		 this.areaId = areaId;
	}
	public String getAddress() {
		 return address;
	}
	public void setAddress(String address) {
		 this.address = address;
	}
	public String getMaster() {
		 return master;
	}
	public void setMaster(String master) {
		 this.master = master;
	}
	public String getPhone() {
		 return phone;
	}
	public void setPhone(String phone) {
		 this.phone = phone;
	}
	public String getFax() {
		 return fax;
	}
	public void setFax(String fax) {
		 this.fax = fax;
	}
	public String getEmail() {
		 return email;
	}
	public void setEmail(String email) {
		 this.email = email;
	}
	public String getUSEABLE() {
		 return uSEABLE;
	}
	public void setUSEABLE(String uSEABLE) {
		 this.uSEABLE = uSEABLE;
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