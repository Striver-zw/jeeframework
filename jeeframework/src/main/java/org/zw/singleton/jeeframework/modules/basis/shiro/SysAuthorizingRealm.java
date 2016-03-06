package org.zw.singleton.jeeframework.modules.basis.shiro;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.basis.shiro.utils.ShiroMd5;
import org.zw.singleton.jeeframework.modules.sys.entity.SysUser;
import org.zw.singleton.jeeframework.modules.sys.service.SysUserService;

/**
 * 
  * @ClassName:SysAuthorizingRealm
  * @Description:
  * @Author:singleton-zw
  * @CreateDate:2016年2月9日-下午1:07:54
  * @UpdateAuthor:
  * @UpdateDate:
  * @UpdateDesc:
  * @version: v1.0
  * @Copyright (c)-2016
 */
@Service
public class SysAuthorizingRealm extends AuthorizingRealm{
	
	@Autowired
	private SysUserService sysUserService;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 授权查询回调函数,
	  * @EnclosingMethod:doGetAuthorizationInfo
	  * @Overridden:@see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	  * @MethodsDescription:
	  * @param principals
	  * @return
	  * @Author:singleton-zw
	  * @Return:AuthorizationInfo
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		logger.error("授权----");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("r1");
		info.addStringPermission("test:*");
		info.addStringPermission("/admin/role/datautils");
		SysUser user = (SysUser) principals.getPrimaryPrincipal();
		// 添加用户权限
		info.addStringPermission("user");
//		logger.error("--oo---ll--"+info.toString());
		return info;
	}

	/**
	 * 认证回调函数, 登录时调用
	  * @EnclosingMethod:doGetAuthenticationInfo
	  * @Overridden:@see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	  * @MethodsDescription:
	  * @param token
	  * @return
	  * @throws AuthenticationException
	  * @Author:singleton-zw
	  * @Return:AuthenticationInfo
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		SysUser user = this.sysUserService.getByLoginName(username,password);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(user.getLoginName()));
		return info;
	}

	/**
	 * 设定密码校验的Hash算法与迭代次数
	 * 注解方式
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		//方式
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(ShiroMd5.HASH_NAME);
		//迭代次数
		matcher.setHashIterations(ShiroMd5.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
	
	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
//		logger.error("checkPermission----"+permission);
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}
	
	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
//            	logger.error("isPermitteds----"+permission);
        		authorizationValidate(permission);
            }
        }
		return super.isPermitted(permissions, info);
	}
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
//		logger.error("isPermitted----"+permission);
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}
	
	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
//            	logger.error("isPermittedAll----"+permission);
            	authorizationValidate(permission);
            }
        }
		return super.isPermittedAll(permissions, info);
	}
	
	/**
	 * 授权验证方法
	 * @param permission
	 */
	private void authorizationValidate(Permission permission){
		// 模块授权预留接口
//		logger.error("authorizationValidate----"+permission);
	}
	
}
