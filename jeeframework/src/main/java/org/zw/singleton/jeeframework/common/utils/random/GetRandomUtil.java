package org.zw.singleton.jeeframework.common.utils.random;

import java.util.Random;
import java.util.UUID;

/**
 * 
  * @类名:GetIdUtil
  * @类描述:生成随机数
  * @作者:
  * @创建时间:2015年8月21日-下午4:27:22
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class GetRandomUtil {

	/**
	 * 
	 * @方法说明:生成UUID 32位的  掉 "-", ""
	 * @方法名称:getUUID
	 * @return 返回32位的字符串
	 * @作者:
	 * @返回值:	String	32位的id
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	/**
	 * 
	 * @方法说明:输入参数 生成随机数
	 * @方法名称:getUUIDByRules
	 * @param rules 输入
	 * @return 返回32位的字符串
	 * @作者:
	 * @返回值:	String
	 */
	public static String getUUIDByRules(String rules) {
		int rpoint = 0;
		StringBuffer generateRandStr = new StringBuffer();
		Random rand = new Random();
		int length = 32;
		for (int i = 0; i < length; i++) {
			if (rules != null) {
				rpoint = rules.length();
				int randNum = rand.nextInt(rpoint);
				generateRandStr.append(generateRandStr.substring(randNum, randNum + 1));
			}
		}
		return generateRandStr + "";
	}
}
