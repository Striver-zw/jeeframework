package org.zw.singleton.jeeframework.common.utils.convers;

import org.apache.commons.lang.StringUtils;

/**
 * 类型转换
 * @author zw
 * Date: 2014年8月18日
 */
public class DataType {

	/**
	 * 
	 * @方法说明: 吧字符数组转出成整数数组
	 * @方法名称:StringArrayIntegerArray
	 * @param sids
	 * @return int
	 * @作者:张威
	 * @返回值:	Integer[]
	 */
	public static Integer[] StringArrayIntegerArray(String[] sids) {
		if(sids!=null&&sids.length>0){
			Integer[] ids = new Integer[sids.length] ;
			for(int i=0;i<sids.length;i++){
				if(sids[i]!=null){
					if(StringUtils.isNotBlank(sids[i])){
					ids[i]=Integer.parseInt(sids[i]);
					}
				}
			}
			return ids;
		}
		return null;
	}

}
