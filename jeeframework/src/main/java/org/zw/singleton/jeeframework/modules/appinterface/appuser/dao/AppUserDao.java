/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-11 13:20:30
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.appinterface.appuser.dao;

import org.zw.singleton.jeeframework.modules.appinterface.appuser.entity.AppUser;
import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;

/**  
  * @类名:AppUserDao
  * @类描述:app用户
  * @作者: singleton_zw
  * @创建时间: 2016-01-11 13:20:30
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@MybatisDao
public interface AppUserDao extends CrudDao<AppUser> {


	/**
	 * @方法说明:
	 * @方法名称:loginAppuser
	 * @param appuser
	 * @return
	 * @作者:张威
	 * @返回值:Appuser
	 */
	public AppUser loginAppUser(AppUser appuser);
	/**
	 * 
	 * @MethodsDescription: 检查手机号是否存在
	 * @MethodName:checkAppUser
	 * @param appuser
	 * @return
	 * @Author:singleton-zw
	 * @Return:AppUser
	 */
	public AppUser checkAppUser(AppUser appuser);
}