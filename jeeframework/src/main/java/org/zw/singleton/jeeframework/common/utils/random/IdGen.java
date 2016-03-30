
package org.zw.singleton.jeeframework.common.utils.random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类
  * @类名:IdGen
  * @类描述:
  * @作者:
  * @创建时间:2015年9月23日-下午1:17:31
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */

public class IdGen {

	private static SecureRandom random = new SecureRandom();
	
	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}
	
	/**
	 * 
	 * @方法说明:生成UUID 32位的  掉 "-", ""
	 * @方法名称:getUUID
	 * @return
	 * @作者:
	 * @返回值:	String	32位的id
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	/**
	 * 
	 * @方法说明:
	 * @方法名称:getUUIDByRules
	 * @param rules 输入
	 * @return
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

	/**
	 * 基于Base62编码的SecureRandom随机生成bytes.
	 */
//	public static String randomBase62(int length) {
//		byte[] randomBytes = new byte[length];
//		random.nextBytes(randomBytes);
//		return Encodes.encodeBase62(randomBytes);
//	}
	
	/**
	 * Activiti ID 生成
	 */
//	@Override
//	public String getNextId() {
//		return IdGen.uuid();
//	}

//	@Override
//	public Serializable generateId(Session session) {
//		return IdGen.uuid();
//	}
//	
	public static void main(String[] args) {
		System.out.println(IdGen.uuid());
		System.out.println(IdGen.uuid().length());
//		System.out.println(new IdGen().getNextId());
		for (int i=0; i<1000; i++){
//			System.out.println(IdGen.randomLong() + "  " + IdGen.randomBase62(5));
		}
	}

}
