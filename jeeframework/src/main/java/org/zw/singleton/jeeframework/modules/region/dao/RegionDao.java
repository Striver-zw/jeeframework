/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-17 20:02:20
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.region.dao;

import java.util.List;

import org.zw.singleton.jeeframework.modules.basis.base.CrudDao;
import org.zw.singleton.jeeframework.modules.basis.base.MybatisDao;
import org.zw.singleton.jeeframework.modules.region.entity.Region;

/**  
  * @类名:RegionDao
  * @类描述:区域
  * @作者: singleton_zw
  * @创建时间: 2016-01-17 20:02:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@MybatisDao
public interface RegionDao extends CrudDao<Region> {

	
	public List<Region> findSelectRegionAll(Region region);
}