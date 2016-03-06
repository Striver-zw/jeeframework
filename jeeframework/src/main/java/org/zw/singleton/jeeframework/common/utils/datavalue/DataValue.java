package org.zw.singleton.jeeframework.common.utils.datavalue;

import java.math.BigDecimal;

public class DataValue {


	/**
	 * 四舍五入1位小数
	 * @方法说明:
	 * @方法名称:doubleValueOne
	 * @param d
	 * @return
	 * @作者:zw
	 * @返回值:Double
	 */
	public static Double doubleValueOne(Double d) {
		BigDecimal bd = new BigDecimal(d);
		//参数1为保留几位
		bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
		//BigDecimal.ROUND_HALF_UP 是4舍5入，BigDecimal.ROUND_DOWN是舍去，BigDecimal.ROUND_FLOOR是向上取整
		return bd.doubleValue();
	}
}
