/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:30:53
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appversion.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @类名:AppVersion
  * @类描述:app版本号
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:30:53
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
public class AppVersion extends BaseEntity<AppVersion> {

	private String versionName;	//版本名称 
	private String versionCode;	//版本号 
	private String versionValue;	//版本更新的内容 
	private Date versionTime;	//版本时间 
	private Integer status;	//状态 1为使用 2为废弃 
    private String downloadUrl;//下载地址
	 
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getVersionName() {
		 return versionName;
	}
	public void setVersionName(String versionName) {
		 this.versionName = versionName;
	}
	public String getVersionCode() {
		 return versionCode;
	}
	public void setVersionCode(String versionCode) {
		 this.versionCode = versionCode;
	}
	public String getVersionValue() {
		 return versionValue;
	}
	public void setVersionValue(String versionValue) {
		 this.versionValue = versionValue;
	}
	public Date getVersionTime() {
		 return versionTime;
	}
	public void setVersionTime(Date versionTime) {
		 this.versionTime = versionTime;
	}
	public Integer getStatus() {
		 return status;
	}
	public void setStatus(Integer status) {
		 this.status = status;
	}
}