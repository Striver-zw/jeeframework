/**  
  * Code Generator Author :singleton_zw
  * Code Generator version: 2.0
  * QQ群: 123456789
  * author：singleton_zw
  * CreateDate: 2016-02-09 12:19:14
  * Copyright &copy; 2015-2016
*/
package org.zw.singleton.jeeframework.modules.sys.controller;

import org.zw.singleton.jeeframework.modules.sys.entity.SysMenu;
import org.zw.singleton.jeeframework.modules.sys.entity.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zw.singleton.jeeframework.modules.sys.service.SysMenuService;

import com.mysql.fabric.xmlrpc.base.Array;

import org.zw.singleton.jeeframework.modules.basis.page.Page;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**  
  * @ClassName:SysMenuController
  * @Description:菜单管理
  * @Author: singleton_zw
  * @CreateDate: 2016-02-09 12:19:14
  * @UpdateAuthor:
  * @UpdateDate:
  * @@UpdateDesc:
  * @version:
  * @Copyright
*/
@Controller
@RequestMapping(value = "/sysMenu")
public class SysMenuController {

	@Autowired
	private SysMenuService sysMenuService;

	@ResponseBody
	@RequestMapping(value = { "/sysMenuList.do" }, method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,Object> list(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();	
//		Map<String,Object> map1 = new HashMap<String,Object>();	
//		Map<String,Object> map2 = new HashMap<String,Object>();	
		List<SysMenu> list = new ArrayList<SysMenu>();
//		List<SysMenu> list2 = new ArrayList<SysMenu>();
//		List<SysMenu> list3 = new ArrayList<SysMenu>();
//		List<SysMenu> list1 = new ArrayList<SysMenu>();
//		List<Map<String, Object>> listmap = new ArrayList<Map<String,Object>>();
//		List<List<SysMenu>> listm = new ArrayList<List<SysMenu>>();
//		List<List<SysMenu>> listmp = new ArrayList<List<SysMenu>>();
		list = sysMenuService.pageSelect(new SysMenu());
		if(list.size()>0){
			map.put("sysList", list);
//			for (int i = 0; i < list.size(); i++) {
//				if("0".contains(list.get(i).getParentId())){
//					System.err.println("　"+list.get(i).getName());
//					SysMenu menu = list.get(i);
//					SysMenuVo vo = new SysMenuVo();
//					//一级菜单
//					list1.add(menu);
//					vo.setList(list1);
//					list.remove(list.get(i));
//					for (int j = 0; j < list.size(); j++) {
//						if(menu.getId().contains(list.get(j).getParentId())){
//							System.err.println("　　"+list.get(j).getName());
//							SysMenu menu2 = list.get(j);
//							list2.add(menu2);
//							list.remove(list.get(j));
//							for (int k = 0; k < list.size(); k++) {
//								if(menu2.getId().contains(list.get(k).getParentId())){
//									System.err.println("　　　"+list.get(k).getName());
//									//三级菜单
//									list3.add(list.get(k));
//	//								parameters2.remove(parameters2.get(k));
//								}
//							}
//							listm.add(list3);
//						}
//						
//					}
//				}
//			}
		}
		return map;
	}

	
}