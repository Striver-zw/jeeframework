/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 14:02:02
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @ClassName:SysUser
  * @Description:系统用户
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 14:02:02
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
public class SysUser extends BaseEntity<SysUser> {

	private String companyId;	//归属公司 
	private String officeId;	//归属部门 
	private String loginName;	//登录名 
	private String password;	//密码 
	private String name;	//姓名 
	private String email;	//邮箱 
	private String phone;	//电话 
	private String mobile;	//手机 
	private String photo;	//用户头像 
	private String loginIp;	//最后登陆IP 
	private Date loginDate;	//最后登陆时间 
	private String loginFlag;	//是否可登录 
	private String createBy;	//创建者 
	private Date createDate;	//创建时间 
	private Date updateDate;	//更新时间 
	private String remarks;	//备注信息 
	private String delFlag;	//删除标记 

	public String getCompanyId() {
		 return companyId;
	}
	public void setCompanyId(String companyId) {
		 this.companyId = companyId;
	}
	public String getOfficeId() {
		 return officeId;
	}
	public void setOfficeId(String officeId) {
		 this.officeId = officeId;
	}
	public String getLoginName() {
		 return loginName;
	}
	public void setLoginName(String loginName) {
		 this.loginName = loginName;
	}
	public String getPassword() {
		 return password;
	}
	public void setPassword(String password) {
		 this.password = password;
	}
	public String getName() {
		 return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	public String getEmail() {
		 return email;
	}
	public void setEmail(String email) {
		 this.email = email;
	}
	public String getPhone() {
		 return phone;
	}
	public void setPhone(String phone) {
		 this.phone = phone;
	}
	public String getMobile() {
		 return mobile;
	}
	public void setMobile(String mobile) {
		 this.mobile = mobile;
	}
	public String getPhoto() {
		 return photo;
	}
	public void setPhoto(String photo) {
		 this.photo = photo;
	}
	public String getLoginIp() {
		 return loginIp;
	}
	public void setLoginIp(String loginIp) {
		 this.loginIp = loginIp;
	}
	public Date getLoginDate() {
		 return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		 this.loginDate = loginDate;
	}
	public String getLoginFlag() {
		 return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		 this.loginFlag = loginFlag;
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
		return "SysUser [companyId=" + companyId + ", officeId=" + officeId + ", loginName=" + loginName + ", password="
				+ password + ", name=" + name + ", email=" + email + ", phone=" + phone + ", mobile=" + mobile
				+ ", photo=" + photo + ", loginIp=" + loginIp + ", loginDate=" + loginDate + ", loginFlag=" + loginFlag
				+ ", createBy=" + createBy + ", createDate=" + createDate + ", updateDate=" + updateDate + ", remarks="
				+ remarks + ", delFlag=" + delFlag + "]";
	}
	
}