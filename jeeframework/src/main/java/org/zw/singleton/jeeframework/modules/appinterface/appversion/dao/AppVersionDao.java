/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:30:53
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appversion.dao;

import org.zw.singleton.jeeframework.modules.appinterface.appversion.entity.AppVersion;
import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;

/**  
  * @类名:AppVersionDao
  * @类描述:app版本号
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:30:53
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@MybatisDao
public interface AppVersionDao extends CrudDao<AppVersion> {

	/**
	 * 获取最新的版本号
	 * @方法说明:
	 * @方法名称:getAppVersionCode
	 * @param appVersion
	 * @return
	 * @作者:张威
	 * @返回值:AppVersion
	 */
	public AppVersion getAppVersionCode(AppVersion appVersion);
}