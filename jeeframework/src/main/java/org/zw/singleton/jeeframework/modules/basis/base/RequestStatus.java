package org.zw.singleton.jeeframework.modules.basis.base;

import java.io.Serializable;

/**
 * 获取移动端的数据
  * @类名:RequestStatus
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月17日-下午9:23:39
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2016
 */
public class RequestStatus<T> implements Serializable {
	/**
	 * @说明: 
	 * @名称:serialVersionUID
	 * @类型:long
	 */
	private static final long serialVersionUID = -8977327485898292857L;
	private String uid;
	private String udid;
	private String appname;
	private String version;
	private String usertoken;
	private T data;//数据

	public String getUid() {
		return uid;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUsertoken() {
		return usertoken;
	}

	public void setUsertoken(String usertoken) {
		this.usertoken = usertoken;
	}

	@Override
	public String toString() {
		return "RequestStatus [uid=" + uid + ", udid=" + udid + ", appname=" + appname + ", version=" + version
				+ ", usertoken=" + usertoken + ", data=" + data + "]";
	}
	
}
