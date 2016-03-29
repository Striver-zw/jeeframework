package org.zw.singleton.jeeframework.modules.basis.base;

import java.io.Serializable;

/**
 * 
  * @类名:BaseEntity
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月7日-下午4:11:12
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class BaseEntity<T> implements Serializable {

	public static final long serialVersionUID = 1L;
	public String id;

	public BaseEntity() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseEntity(String id) {
		super();
		this.id = id;
	}
	
}
