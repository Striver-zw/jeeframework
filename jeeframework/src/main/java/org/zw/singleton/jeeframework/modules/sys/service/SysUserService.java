/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 14:02:02
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.service;

import java.util.List;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import org.zw.singleton.jeeframework.modules.basis.shiro.utils.ShiroMd5;
import org.zw.singleton.jeeframework.modules.sys.dao.SysUserDao;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;


/**  
  * @ClassName:SysUserService
  * @Description:系统用户
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 14:02:02
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Service
public class SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	public int saveSysUser(SysUser sysUser) {
		return this.sysUserDao.saveMode(sysUser);
	}

	public Page<SysUser> pageSelect(Page<SysUser> page) {
		page.setDataList(this.sysUserDao.findSelectPage(page));
		return page;
	}

	public List<SysUser> pageSelect(SysUser entity) {
		return this.sysUserDao.findSelect(entity);
	}

	public SysUser get(SysUser sysUser) {
		return this.sysUserDao.getMode(sysUser);
	}

	public int updateSysUser(SysUser sysUser) {
		return this.sysUserDao.updateMode(sysUser);
	}

	public int deleteSysUser(SysUser sysUser) {
		return this.sysUserDao.deleteMode(sysUser);
	}

	/**
	 * 根据登录名查询
	 * @MethodsDescription:
	 * @MethodName:getByLoginName
	 * @param loginName
	 * @return
	 * @Author:singleton-zw
	 * @Return:SysUser
	 */
//	@Cacheable("menuitem")使用缓存
//	@CacheEvict("menuitem")该注解应该添加在增加或者修改的方法上
	public SysUser getByLoginName(String loginName,String password){
		SysUser u = this.sysUserDao.getByLoginName(loginName);
		if(u==null) throw new UnknownAccountException("用户名或者密码出错");
		if(!u.getPassword().equals(ShiroMd5.md5(password, loginName)))
			throw new IncorrectCredentialsException("用户名或者密码出错");
		if("0".equals(u.getLoginFlag())) throw new LockedAccountException("用户已经被锁定");
		return u;
	}

}