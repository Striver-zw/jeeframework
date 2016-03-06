/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-18 22:18:18
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appos.entity;

import java.util.Date;

import org.zw.singleton.jeeframework.modules.basis.base.BaseEntity;

/**  
  * @类名:AppOs
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-18 22:18:18
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
public class AppOs extends BaseEntity<AppOs> {

	private String model;	//手机名称 
	private String sdk;	//手机版本 
	private String release;	//手机版本号 
	private String from;	//移动端类型 
	private String uuid;	// 
	private String cpu1;	//cpu型号 
	private String cpu2;	//cpu频率 
	private String macAddress;	//获取手机MAC地址 
	private String appName;	//应用名称 
	private Date installTime;	//安装的时间 

	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getModel() {
		 return model;
	}
	public void setModel(String model) {
		 this.model = model;
	}
	public String getSdk() {
		 return sdk;
	}
	public void setSdk(String sdk) {
		 this.sdk = sdk;
	}
	public String getRelease() {
		 return release;
	}
	public void setRelease(String release) {
		 this.release = release;
	}
	public String getFrom() {
		 return from;
	}
	public void setFrom(String from) {
		 this.from = from;
	}
	public String getUuid() {
		 return uuid;
	}
	public void setUuid(String uuid) {
		 this.uuid = uuid;
	}
	public String getCpu1() {
		 return cpu1;
	}
	public void setCpu1(String cpu1) {
		 this.cpu1 = cpu1;
	}
	public String getCpu2() {
		 return cpu2;
	}
	public void setCpu2(String cpu2) {
		 this.cpu2 = cpu2;
	}
	public String getMacAddress() {
		 return macAddress;
	}
	public void setMacAddress(String macAddress) {
		 this.macAddress = macAddress;
	}
	public Date getInstallTime() {
		 return installTime;
	}
	public void setInstallTime(Date installTime) {
		 this.installTime = installTime;
	}
	@Override
	public String toString() {
		return "AppOs [model=" + model + ", sdk=" + sdk + ", release=" + release + ", from=" + from + ", uuid=" + uuid
				+ ", cpu1=" + cpu1 + ", cpu2=" + cpu2 + ", macAddress=" + macAddress + ", installTime=" + installTime
				+ "]";
	}
	
}