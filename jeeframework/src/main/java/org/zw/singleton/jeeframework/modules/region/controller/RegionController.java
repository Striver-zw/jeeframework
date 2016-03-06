/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * 生成人：singleton_zw
  * 生成时间: 2016-01-17 20:02:20
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.region.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.basis.page.Page;
import org.zw.singleton.jeeframework.modules.region.entity.Region;
import org.zw.singleton.jeeframework.modules.region.service.RegionService;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @类名:RegionController
  * @类描述:区域
  * @作者: singleton_zw
  * @创建时间: 2016-01-17 20:02:20
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright
*/
@Controller
@RequestMapping(value = "Region")
public class RegionController {

	@Autowired
	private RegionService regionService;

	@ResponseBody
	@RequestMapping(value = { "/regionList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(@RequestBody Region region,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		return map;
	}


//	@ResponseBody
	@RequestMapping(value = { "/regionListAll.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> listAll(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
		 Region region = new Region();
		 region.setParentId(1.0);
		List<Region> findSelectRegionAll = regionService.findSelectRegionAll(region);
		
		for (int i = 0; i < findSelectRegionAll.size(); i++) {
			
		}
		return map;
	}

	
//	XxbProductParameters x = new XxbProductParameters();
//	x.setGoodsid(id);
//	x.setTypes("1");
//	List<XxbProductParameters> parameters2 = xxbShopStoreService.getXxbProductParameters(x);
//	List<XxbProductParameters> parameters3 = new ArrayList<XxbProductParameters>();
//	System.err.println("所有值："+parameters2.size());
//	//去除重复的
//	for (int i = 0; i < parameters2.size()-1; i++) {
//		if(!parameters2.get(i).getColor().contains(parameters2.get(i+1).getColor())){
//			parameters3.add(parameters2.get(i));
//		}
//		
//	}  
//	System.err.println("去重后的值："+parameters3.size());
//	
//	for (int i = 0; i < parameters3.size(); i++) {
//		System.err.println("key:"+parameters3.get(i).getColor());
//		for (int j = 0; j < parameters2.size(); j++) {
//			if(parameters3.get(i).getColor().contains(parameters2.get(j).getColor())){
//				System.err.println("value:"+parameters2.get(j).toString());
//			}
//		}
//	}
}