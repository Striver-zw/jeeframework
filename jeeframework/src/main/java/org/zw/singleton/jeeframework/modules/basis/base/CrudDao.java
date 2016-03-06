package org.zw.singleton.jeeframework.modules.basis.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.zw.singleton.jeeframework.modules.basis.page.Page;

/**
 * 基本的curd操作
  * @类名:CrudDao
  * @类描述:
  * @作者:张威
  * @创建时间:2016年1月11日-下午1:28:07
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 3.0
  * @Copyright (c)-2016
 */
public interface CrudDao<T> extends SysDao {

	/**
	 * 保存
	 * @方法说明:
	 * @方法名称:saveMode
	 * @param path
	 * @param t
	 * @return
	 * @作者:zw
	 * @返回值:int
	 */
	public int saveMode(T t);

	/**
	 * 修改
	 * @方法说明:
	 * @方法名称:updateMode
	 * @param t
	 * @param path
	 * @作者:zw
	 * @返回值:	void
	 */
	public int updateMode(T t);

	/**
	 * 删除 根据id删
	 * @方法说明:
	 * @方法名称:deleteMode
	 * @param id
	 * @param path
	 * @作者:zw
	 * @返回值:	void
	 */
	public int deleteModeId(Serializable id);

	/**
	 * 删除 根据实体
	 * @方法说明:
	 * @方法名称:deleteMode
	 * @param id
	 * @param path
	 * @作者:zw
	 * @返回值:	void
	 */
	public int deleteMode(T t);

	/**
	 * 根据id查询实体
	 * @方法说明:
	 * @方法名称:getModeById
	 * @param id
	 * @param path
	 * @return
	 * @作者:zw
	 * @返回值:	T
	 */
	public T getModeById(Serializable id);

	/**
	 * 根据条件查询
	 * @方法说明:
	 * @方法名称:getModeByConditions
	 * @param name 名字
	 * @param path
	 * @return
	 * @作者:zw
	 * @返回值:	T
	 */
	public T getModeByConditions(String name);

	/**
	 * 查询所有 不带条件
	 * @方法说明:
	 * @方法名称:getAllMode
	 * @return
	 * @作者:zw
	 * @返回值:	List<T>
	 */
	@Deprecated
	public List<T> getAllMode();

	/**
	 * 根据条件查询
	 * @方法说明:
	 * @方法名称:
	 * @param t
	 * @return
	 * @作者:zw
	 * @返回值:	T
	 */
	public T getMode(T t) ;
	
	/**
	 * 分页查询
	 * @方法说明:
	 * @方法名称:pageSelect
	 * @param path
	 * @param page
	 * @return
	 * @throws SQLException
	 * @作者:zw
	 * @返回值:List<T>
	 */
	@Deprecated
	public List<T> findSelectPageList(Page<T> page);
	
	/**
	 * 普通查询
	 * @方法说明:
	 * @方法名称:findSelect
	 * @param path
	 * @param t
	 * @return
	 * @throws SQLException
	 * @作者:zw
	 * @返回值:List<T>
	 */

	public List<T> findSelect(T t);
	
	
	/**
	 * 分页查询
	 * @方法说明:
	 * @方法名称:findSelectPage
	 * @param path
	 * @param page
	 * @return
	 * @作者:zw
	 * @返回值:Page<T>
	 */
	public List<T> findSelectPage(Page<T> page);


}
