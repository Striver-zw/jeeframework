/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:20:30
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appuser.entity;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @类名:AppUser
  * @类描述:app用户
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:20:30
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
public class AppUser extends BaseEntity<AppUser> {

	private String nickname;	//昵称 
	private String userpassword;	//密码 
	private String username;	//名字 
	private Integer age;	//年龄 
	private Integer phone;	//电话 
	private String portrait;	//头像 
	private String address;	//地址 
	private String citys;	//城市（城市加区域） 
	private String gender;	//性别 
	private Integer isvip;	//是否vip用户 默认否 
	private Integer status;	//是否删除，冻结 0正常 1冻结 2删除 

	public String getNickname() {
		 return nickname;
	}
	public void setNickname(String nickname) {
		 this.nickname = nickname;
	}
	public String getUserpassword() {
		 return userpassword;
	}
	public void setUserpassword(String userpassword) {
		 this.userpassword = userpassword;
	}
	public String getUsername() {
		 return username;
	}
	public void setUsername(String username) {
		 this.username = username;
	}
	public Integer getAge() {
		 return age;
	}
	public void setAge(Integer age) {
		 this.age = age;
	}
	public Integer getPhone() {
		 return phone;
	}
	public void setPhone(Integer phone) {
		 this.phone = phone;
	}
	public String getPortrait() {
		 return portrait;
	}
	public void setPortrait(String portrait) {
		 this.portrait = portrait;
	}
	public String getAddress() {
		 return address;
	}
	public void setAddress(String address) {
		 this.address = address;
	}
	public String getCitys() {
		 return citys;
	}
	public void setCitys(String citys) {
		 this.citys = citys;
	}
	public String getGender() {
		 return gender;
	}
	public void setGender(String gender) {
		 this.gender = gender;
	}
	public Integer getIsvip() {
		 return isvip;
	}
	public void setIsvip(Integer isvip) {
		 this.isvip = isvip;
	}
	public Integer getStatus() {
		 return status;
	}
	public void setStatus(Integer status) {
		 this.status = status;
	}
}