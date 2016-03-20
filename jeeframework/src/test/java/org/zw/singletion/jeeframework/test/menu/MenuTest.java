//package org.zw.singletion.jeeframework.test.menu;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.zw.singletion.jeeframework.test.BaseTest;
//import org.zw.singleton.jeeframework.modules.sys.entity.SysMenu;
//import org.zw.singleton.jeeframework.modules.sys.service.SysMenuService;
//
//public class MenuTest extends BaseTest {
//
//	@Autowired
//	private SysMenuService sysMenu;
//	
//	@Test
//	public void menu(){
//		
//		SysMenu x = new SysMenu();
//
//		List<SysMenu> parameters2 = sysMenu.pageSelect(new SysMenu());
//		List<SysMenu> parameters3 = new ArrayList<SysMenu>();
//		System.err.println("所有值："+parameters2.size());
////		//去除重复的
//		for (int i = 0; i < parameters2.size(); i++) {
//			if(!parameters2.get(i).getId().contains(parameters2.get(i).getParentId())){
//				parameters3.add(parameters2.get(i));
//			}
//			
//		}  
//		System.err.println("去重后的值："+parameters3.size());
////		System.err.println("去重后的值："+parameters3.get(0).getName());
//	//	
//		for (int i = 0; i < parameters3.size(); i++) {
//			System.err.println("key:"+parameters3.get(i).getName());
//			for (int j = 0; j < parameters2.size(); j++) {
//				if(parameters3.get(i).getId().contains(parameters2.get(j).getParentId())){
//					System.err.println("value:"+parameters2.get(j).getName());
//				}
//			}
//		}
//	}
//	
//	/**
//	 * 菜单查询
//	 * @MethodsDescription:
//	 * @MethodName:menu2
//	 * @Author:singleton-zw
//	 * @Return:void
//	 */
//	@Test
//	public void menu2(){
//		
//		SysMenu x = new SysMenu();
//		
//		List<SysMenu> parameters2 = sysMenu.pageSelect(new SysMenu());
////		List<SysMenu> parameters3 = new ArrayList<SysMenu>();
////		List<SysMenu> parameters4 = new ArrayList<SysMenu>();
////		List<SysMenu> parameters5 = new ArrayList<SysMenu>();
////		System.err.println("所有值："+parameters2.size());
//////		//去除重复的
////		for (int i = 0; i < parameters2.size(); i++) {
////			if("0".equals(parameters2.get(i).getParentId())) parameters3.add(parameters2.get(i)) ;
////		}
////		System.err.println("一级:"+parameters3.toString());
//
////		for (int i = 0; i < parameters3.size(); i++) {
////			System.err.println("一级:"+parameters3.get(i).getName());
////			for (int j = 0; j < parameters2.size(); j++) {
////				if(parameters3.get(i).getId().contains(parameters2.get(j).getParentId())){
//////					System.err.println("value:"+parameters2.get(j).getName());
////					parameters4.add(parameters2.get(j));
////				}
////			}
////		}
////		for (int i = 0; i < parameters4.size(); i++) {
////			System.err.println("二级:"+parameters4.get(i).getName());
////			for (int j = 0; j < parameters2.size(); j++) {
////				if(parameters4.get(i).getId().contains(parameters2.get(j).getParentId())){
//////					System.err.println("三级:"+parameters2.get(j).getName());
////					parameters5.add(parameters2.get(j));
////				}
////			}
////		}
////		for (int i = 0; i < parameters5.size(); i++) {
////			System.err.println("三级:"+parameters5.get(i).getName());
////			
////		}
//		
//		/**
//		 * 封装 耗时相对慢
//		 */
//		System.out.println(System.currentTimeMillis());
//		for (int i = 0; i < parameters2.size(); i++) {
//			if("0".contains(parameters2.get(i).getParentId())){
//				System.err.println(i+":"+parameters2.get(i).getName());
//				SysMenu menu = parameters2.get(i);
//				for (int j = 0; j < parameters2.size(); j++) {
//					if(menu.getId().contains(parameters2.get(j).getParentId())){
//						System.err.println(" "+j+":"+parameters2.get(j).getName());
//						SysMenu menu2 = parameters2.get(j);
//						for (int k = 0; k < parameters2.size(); k++) {
//							if(menu2.getId().contains(parameters2.get(k).getParentId())){
//								System.err.println("  "+k+":"+parameters2.get(k).getName());
//							}
//						}
//					}
//				}
//			}
//		}
//		/**
//		 * 封装 但耗时短
//		 */
//		System.out.println(System.currentTimeMillis());
//		for (int i = 0; i < parameters2.size(); i++) {
//			if("0".contains(parameters2.get(i).getParentId())){
//				System.err.println("　"+parameters2.get(i).getName());
//				SysMenu menu = parameters2.get(i);
//				parameters2.remove(parameters2.get(i));
//				for (int j = 0; j < parameters2.size(); j++) {
//					if(menu.getId().contains(parameters2.get(j).getParentId())){
//						System.err.println("　　"+parameters2.get(j).getName());
//						SysMenu menu2 = parameters2.get(j);
//						parameters2.remove(parameters2.get(j));
//						for (int k = 0; k < parameters2.size(); k++) {
//							if(menu2.getId().contains(parameters2.get(k).getParentId())){
//								
//								System.err.println("　　　"+parameters2.get(k).getName());
////								parameters2.remove(parameters2.get(k));
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		System.out.println(System.currentTimeMillis());
////		getc("0", parameters2);
////		System.out.println(System.currentTimeMillis());
//	}
//	
//	/**
//	 * 递归查询 不好分级
//	 * @MethodsDescription:
//	 * @MethodName:getc
//	 * @param id
//	 * @param list
//	 * @Author:singleton-zw
//	 * @Return:void
//	 */
//	public void getc(String id,List<SysMenu> list){
////		System.out.println("--------------");
//		if(list.size()>1){
//			for (int i = 0; i < list.size(); i++) {
//				if(id.contains(list.get(i).getParentId())){
//					System.err.println("　　　"+list.get(i).getName());
//					SysMenu menu = list.get(i);
//					list.remove(i);
//					getc(menu.getId(),list);
//				}
//			}
//		}else if(list.size()==1){
////			if(id.contains(list.get(0).getParentId())){
//				System.err.println("　　　"+list.get(0).getName());
////			}
//		}
//	}
//}
