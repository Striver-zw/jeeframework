package org.zw.singleton.jeeframework.modules.basis.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.zw.singleton.jeeframework.common.utils.sysconfig.ConfigUtils;
import org.zw.singleton.jeeframework.modules.basis.page.Page;



/**
 * mybatis 分页拦截器
  * @类名:PageInterceptor
  * @类描述:
  * @作者:张威
  * @创建时间:2015年12月13日-下午12:20:29
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor {
	
	private String sysdb;
	
	
	public String getSysdb() {
		return sysdb;
	}

	public void setSysdb(String sysdb) {
		this.sysdb = sysdb;
	}

	public Object intercept(Invocation invocation) throws Throwable {
		//拿到资源
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
//		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
//		// 配置文件中SQL语句的ID
//		String id = mappedStatement.getId();
		BoundSql boundSql = statementHandler.getBoundSql();
		// 拿到当前绑定Sql的参数对象，就是我们在调用对应的Mapper映射语句时所传入的参数对象
		Object obj = boundSql.getParameterObject();
		/**
		 * 根据参数来判断
		 */
		if (obj instanceof Page) {
			//如果是mysql就执行以下
			if ("mysql".equals(sysdb) || "Mysql".equals(sysdb)|| "MYSQL".equals(sysdb)) {
				Page<?> page = (Page<?>) obj;
				if(page.getCurrentPage()==0){
//					int[] pageParameter = ConfigUtils.getPageParameter();
//					page.setCurrentPage(pageParameter[0]);
//					page.setPageNumber(pageParameter[1]);
				}
				if(page.getPageNumber()==0){
//					int[] pageParameter = ConfigUtils.getPageParameter();
//					page.setCurrentPage(pageParameter[0]);
//					page.setPageNumber(pageParameter[1]);
				}
				// // 原始的SQL语句
				String sql = boundSql.getSql();
				// 查询总条数的SQL语句
				String countSql = "select count(*) from (" + sql + ") jf";
				// 获取链接对象
				Connection connection = (Connection) invocation.getArgs()[0];
				//
				PreparedStatement countStatement = connection.prepareStatement(countSql);
				ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
				parameterHandler.setParameters(countStatement);
				ResultSet rs = countStatement.executeQuery();
				if (rs.next()) {
					page.setTotalNumber(rs.getInt(1));
				}
				// 改造后带分页查询的SQL语句
				String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
//				StringBuffer sqlBuffer = new StringBuffer();
//				sqlBuffer.append(sql).append(" limit ").append(page.getDbIndex()).append(",").append(page.getDbIndex());
				metaObject.setValue("delegate.boundSql.sql", pageSql);
			}
		}
		/**
		 * 根据id来判断拦截
		 */
//		if(id.matches(".*page.*")) {
//			BoundSql boundSql = statementHandler.getBoundSql();
////			// 原始的SQL语句
//			String sql = boundSql.getSql();
//			System.out.println("拦截sql"+sql);
//			// 查询总条数的SQL语句
//			String countSql = "select count(*) from (" + sql + ") cs";
//			//获取链接对象
//			Connection connection = (Connection)invocation.getArgs()[0];
//			//
//			PreparedStatement countStatement = connection.prepareStatement(countSql);
//			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
//			parameterHandler.setParameters(countStatement);
//			ResultSet rs = countStatement.executeQuery();
//			
//			Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
//			Page<?> page = (Page<?>)parameter.get("page");
//			if(rs.next()) {
//				page.setTotalNumber(rs.getInt(1));
//			}
//			// 改造后带分页查询的SQL语句
//			String pageSql = sql + " limit " + page.getDbIndex() + "," + page.getDbNumber();
//			metaObject.setValue("delegate.boundSql.sql", pageSql);
//		}
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		//拦截的谁
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		this.sysdb = properties.getProperty("test");
	}

}
