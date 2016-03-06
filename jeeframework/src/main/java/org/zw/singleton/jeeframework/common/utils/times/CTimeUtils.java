package org.zw.singleton.jeeframework.common.utils.times;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zw.singleton.jeeframework.common.utils.Interception.DataInterceptionUtil;

public class CTimeUtils {

	
	/**
	 * 获取时间段
	 * @方法说明:
	 * @方法名称:coudatelist
	 * @param businesstime1  开始营业时间
	 * @param businesstime2  结束营业时间
	 * @param d
	 * @param add 时间段间隔
	 * @return
	 * @作者:zw
	 * @返回值:List<String> 时间段
	 */
	public static List<String> coudatelist(String businesstime1, String businesstime2, Date d, int add) {
		// 字符串转换日期格式
		Date date = null;
		DateFormat fmtDateTime = new SimpleDateFormat("HH:mm");
		List<String> l = new ArrayList<String>();
		// 得到日期格式对象
		try {
			date = fmtDateTime.parse("10:00");
			if (businesstime1 != null && businesstime2 != null) {
				String[] businesstime1i = DataInterceptionUtil.interceptionEscape(businesstime1, ":", true);
				String[] businesstime2i = DataInterceptionUtil.interceptionEscape(businesstime2, ":", true);

				int datatodata1 = CTimeCompareTo.datatodata(Integer.parseInt(businesstime1i[0]),
						Integer.parseInt(businesstime1i[1]), date);
				int gg = add;
				int[] minute;
				int datatodata2;

				if (datatodata1 < 0) {
					System.out.println("营业时间--小于-->10：30 -------在10：30之前营业");
					while (true) {
						minute = CTimeCompareTo.getAddDate(date, gg, 5);
						datatodata2 = CTimeCompareTo.datatodata(Integer.parseInt(businesstime2i[0]),
								Integer.parseInt(businesstime2i[1]), minute[3], minute[4]);
						gg += add;
						if (datatodata2 < 0) {
							return getDateOfer(l);
						} else {
							l.add(minute[3] + ":" + minute[4]);
						}
					}
				} else {
					System.out.println("营业时间<-大于--10：00 --在10：30以后才营业");
					String string = businesstime1i[1];
					int parseInt = Integer.parseInt(string);
					if (parseInt > 30) {
						int parseIntv = Integer.parseInt(businesstime1i[0]);
						parseIntv = parseIntv - 1;
						date = fmtDateTime.parse(parseIntv + ":30");
					} else {
						date = fmtDateTime.parse(businesstime1i[0] + ":00");
					}
					while (true) {
						minute = CTimeCompareTo.getAddDate(date, gg, 5);
						datatodata2 = CTimeCompareTo.datatodata(Integer.parseInt(businesstime2i[0]),
								Integer.parseInt(businesstime2i[1]), minute[3], minute[4]);
						gg += add;
						if (datatodata2 < 0) {
							return getDateOfer(l);
						} else {
							l.add(minute[3] + ":" + minute[4]);
						}
					}
				}
			} else {
				return l;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return getDateOfer(l);
	}
	
	/**
	 * 格式時間 返回
	 * @方法说明:
	 * @方法名称:getDateOfer
	 * @param businesstime1
	 * @param businesstime2
	 * @param d
	 * @return
	 * @作者:zw
	 * @返回值:List<String>
	 */
	public static List<String> getDateOfer(List<String> list) {
		List<String> l = new ArrayList<String>();
		l.add("尽快送达");
		for (int i = 1; i < list.size() - 1; i++) {
			String string;
			String string1;
			if (list.get(i).length() < 5) {
				string = list.get(i);
				int of = string.indexOf(":");
				String h = string.substring(0, of);
				if (h.length() < 2) {
					string = "0" + string;
				} else {
					string = string + "0";
				}
			} else {
				string = list.get(i);
			}
			if (list.get(i + 1).length() < 5) {
				string1 = list.get(i + 1);
				int of = string1.indexOf(":");
				String h = string1.substring(0, of);
				if (h.length() < 2) {
					string1 = "0" + string1;
				} else {
					string1 = string1 + "0";
				}
			} else {
				string1 = list.get(i + 1);
			}
			String strings = string + "-" + string1;
//			System.out.println(strings);
			l.add(strings);
		}
		return l;
	}
		
	/**
	 * 从当前时间望后加半小时
	 * @方法说明:
	 * @方法名称:coudatelists
	 * @param businesstime1
	 * @param businesstime2
	 * @param d
	 * @return
	 * @作者:zw
	 * @返回值:List<String>
	 */
	public static List<String> coudatelists(String businesstime1, String businesstime2, Date d,int add) {
		// 字符串转换日期格式
		Date date = null;
		Date date1 = null;
		DateFormat fmtDateTime = new SimpleDateFormat("HH:mm");
		List<String> l = new ArrayList<String>();
		// 得到日期格式对象
		try {
			if (businesstime1 != null && businesstime2 != null) {

				//
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(d);
				int MINUTE = calendar.get(Calendar.MINUTE);
				int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY);
				

				int coudata = CTimeCompareTo.datatodata(businesstime1,businesstime2);
				
				date1 = fmtDateTime.parse(businesstime2);
				if (coudata == 1) {
					int gg = add;
					if (MINUTE > 30) {
						date = fmtDateTime.parse(MINUTE2 + ":30");
					} else {
						date = fmtDateTime.parse(MINUTE2 + ":00");
					}
					while (true) {
						int[] minute = CTimeCompareTo.getAddDate(date, gg,5);
						int[] minute2 =CTimeCompareTo.getAddDate(date1 ,-30,5);
						int datatodata2 = CTimeCompareTo.datatodata(minute2[3], minute2[4], minute[3], minute[4]);
						gg += add;
						if (datatodata2 < 0) {
							return getDateOfer(l);
						} else {
							l.add(minute[3] + ":" + minute[4]);
						}

					}
				}
			} else {
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDateOfer(l);
	}

}
