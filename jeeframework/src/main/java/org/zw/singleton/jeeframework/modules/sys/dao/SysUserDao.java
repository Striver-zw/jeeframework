/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 14:02:02
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.dao;

import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;

/**  
  * @ClassName:SysUserDao
  * @Description:系统用户
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 14:02:02
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@MybatisDao
public interface SysUserDao extends CrudDao<SysUser> {

	public SysUser getByLoginName(String loginName);
}