package org.zw.singleton.jeeframework.common.utils.reflect;

import java.lang.reflect.ParameterizedType;

/**
 * 
  * @类名:GenericClass
  * @类描述: 泛型得到当前实体类的工具栏
  * @作者:张威
  * @创建时间:2015年8月24日-上午10:14:19
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class GenericClass {

	/**
	 * 得到传过来的实体
	 * @param clzss
	 * @return
	 */
	public static Class getGenericClass(Class clzss) {
		ParameterizedType type = (ParameterizedType) clzss.getGenericSuperclass();
		
		Class entityClass = (Class) type.getActualTypeArguments()[0]; 
		/**
		 * type.getActualTypeArguments()[0]
		 * 0 代表的是转入泛型的第一个数
		 */
		
		return entityClass;
	}
	
	// 获得当前类名
	public String getClazzCurrent(){
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}
	
	// 获得当前方法名
	public String getMethodCurrent(){
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
	
	public void getMether(final Class class1){
		 String clazzName3 = new Object() {  
		        public String getClassName() {  
		            String clazzName = class1.getClass().getName();  
		            System.out.println(clazzName);
		            System.out.println(clazzName.substring(0, clazzName.lastIndexOf('$')));
		            return clazzName.substring(0, clazzName.lastIndexOf('$'));  
		        }  
		    }.getClassName(); 
	}

}
