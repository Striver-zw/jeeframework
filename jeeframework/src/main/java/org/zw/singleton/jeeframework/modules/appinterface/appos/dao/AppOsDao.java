/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-18 22:18:18
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appos.dao;

import org.zw.singleton.jeeframework.modules.appinterface.appos.entity.AppOs;
import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;

/**  
  * @类名:AppOsDao
  * @类描述:超级管理员
  * @作者: singleton_zw
  * @创建时间: 2016-01-18 22:18:18
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@MybatisDao
public interface AppOsDao extends CrudDao<AppOs> {

	public AppOs getAppOsCheck(AppOs appOs);
}