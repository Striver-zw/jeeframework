/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-17 20:02:20
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.region.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import org.zw.singleton.jeeframework.modules.region.dao.RegionDao;
import org.zw.singleton.jeeframework.modules.region.entity.Region;

import java.util.List;


/**  
  * @类名:RegionService
  * @类描述:区域
  * @作者: singleton_zw
  * @创建时间: 2016-01-17 20:02:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Service
public class RegionService {

	@Autowired
	private RegionDao regionDao;

	public int saveRegion(Region region) {
		return this.regionDao.saveMode(region);
	}

	public Page<Region> pageSelect(Page<Region> page) {
		page.setDataList(this.regionDao.findSelectPage( page));
		return page;
	}

	public List<Region> pageSelect(Region entity) {
		return this.regionDao.findSelect(entity);
	}

	public Region get(Region region) {
		return this.regionDao.getMode(region);
	}

	public int updateRegion(Region region) {
		return this.regionDao.updateMode(region);
	}

	public int deleteRegion(Region region) {
		return this.regionDao.deleteMode(region);
	}

	public List<Region> findSelectRegionAll(Region region){
		return regionDao.findSelectRegionAll(region);
	}

}