/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:19:14
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.entity;

import java.util.Date;
import java.util.List;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:SysMenu
  * @Description:菜单管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:19:14
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class SysMenu extends BaseEntity<SysMenu> {

	private String parentId;	//父级编号 
	private String parentIds;	//所有父级编号 
	private String name;	//名称 
	private String sort;	//排序 
	private String href;	//链接 
	private String target;	//目标 
	private String icon;	//图标 
	private String isShow;	//是否在菜单中显示 
	private String permission;	//权限标识 
	private String createBy;	//创建者 
	private Date createDate;	//创建时间 
	private Date updateDate;	//更新时间 
	private String remarks;	//备注信息 
	private String delFlag;	//删除标记 

	private List<SysMenu> list;

	public List<SysMenu> getList() {
		return list;
	}

	public void setList(List<SysMenu> list) {
		this.list = list;
	}
	
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
	public String getHref() {
		 return href;
	}
	public void setHref(String href) {
		 this.href = href;
	}
	public String getTarget() {
		 return target;
	}
	public void setTarget(String target) {
		 this.target = target;
	}
	public String getIcon() {
		 return icon;
	}
	public void setIcon(String icon) {
		 this.icon = icon;
	}
	public String getIsShow() {
		 return isShow;
	}
	public void setIsShow(String isShow) {
		 this.isShow = isShow;
	}
	public String getPermission() {
		 return permission;
	}
	public void setPermission(String permission) {
		 this.permission = permission;
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
	@Override
	public String toString() {
		return "SysMenu [parentId=" + parentId + ", parentIds=" + parentIds + ", name=" + name + ", isShow=" + isShow
				+ ", permission=" + permission + "]";
	}
	
	
}