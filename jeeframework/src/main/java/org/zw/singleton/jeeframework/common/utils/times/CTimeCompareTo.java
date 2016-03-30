/**
 * 参考 网站 http://www.apihome.cn/api/java/Calendar.html
 */
package org.zw.singleton.jeeframework.common.utils.times;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.zw.singleton.jeeframework.common.utils.Interception.DataInterceptionUtil;

/**
 * 比较时间 封装方法
  * @类名:CTimeCompareTo
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月4日-下午1:48:28
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class CTimeCompareTo {

	
	/**
	 * 
	 * @方法说明:计算年龄
	 * @方法名称:getAges
	 * @param date2 传人的时间
	 * @return 年龄
	 * @作者:
	 * @返回值:	int
	 */
	public static int getAges(Date date2) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		String yearStr = date2.toString();
	    String[] birthyear = yearStr.split("-");
	    String string = birthyear[0];
	    int birth = Integer.parseInt(string);
		int age =year-birth;
		return age;
	}
	
	
	/**
	 * 比较时间
	 * @方法说明:
	 * @方法名称:datatodata
	 * @param huor 时
	 * @param minute 分
	 * @param d 时间
	 * @return 大于0 huor>d
	 * @作者:zw
	 * @返回值:int
	 */
	public static int datatodata(int huor,int minute,Date d){
		// 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(d);  
	    int MINUTE = calendar.get(Calendar.MINUTE); 
	    int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY); 
		 java.sql.Time d1 = new java.sql.Time(huor, minute, 0);
		 java.sql.Time d2 = new java.sql.Time(MINUTE2, MINUTE, 0);
		 int i = d1.compareTo(d2);
		 return i;
	}
	
	/**
	 * 比较时间
	 * @方法说明: 大于 0 时 > 时1
	 * @方法名称:datatodata
	 * @param huor 时
	 * @param minute 分
	 * @param huor1 	时1
	 * @param minute1	分1
	 * @return
	 * @作者:zw
	 * @返回值:int
	 */
	public static int datatodata(int huor,int minute,int huor1,int minute1){
		 java.sql.Time d1 = new java.sql.Time(huor, minute, 0);
		 java.sql.Time d2 = new java.sql.Time(huor1, minute1, 0);
		 int i = d1.compareTo(d2);
		 return i;
	}
	
	/**
	 * 根据传入的时间段 判断是否在中间 
	 * @方法说明:
	 * @方法名称:datatodata
	 * @param businesstime1
	 * @param businesstime2
	 * @return
	 * @作者:zw
	 * @返回值:int
	 */
	public static int datatodata(String businesstime1,String businesstime2){
		if(businesstime1!=null&&businesstime2!=null){
			String[] businesstime1i = DataInterceptionUtil.interceptionEscape(businesstime1, ":", true);
			String[] businesstime2i = DataInterceptionUtil.interceptionEscape(businesstime2, ":", true);
			int datatodata1 =  CTimeCompareTo.datatodata(Integer.parseInt(businesstime1i[0]), Integer.parseInt(businesstime1i[1]), new Date());
			int[] minute = CTimeCompareTo.getAddDate(new Date(), 30,5);
			int datatodata2 = CTimeCompareTo.datatodata(Integer.parseInt(businesstime2i[0]), Integer.parseInt(businesstime2i[1]), minute[3],minute[4]);
			if(datatodata1<=0 && datatodata2>0){
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * 比较时间
	 * @方法说明: >0 d1>d2
	 * @方法名称:datatodata
	 * @param d1 
	 * @param d2
	 * @return
	 * @作者:zw
	 * @返回值:int
	 */
	public static int datatodata(Date d1,Date d2){
		 int i = d1.compareTo(d2);
		 return i;
	}
	

	/**
	 * 传如时间 根据时间 前进 或者后退 -1为往后
	 * @方法说明:
	 * @方法名称:getAddDateToDate
	 * @param d
	 * @param minute 需要加或者减多少 int 
	 * @param flag 1 年 2 月 3 日 4 时 5 分 6 秒 
	 * @return
	 * @作者:zw
	 * @返回值:Date
	 */
	public static Date getAddDateToDate(Date d,int minute,int flag){
		// 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(d);  
		// 
	    if(flag==1){
	    	calendar.add(Calendar.YEAR, minute);
	    }else if(flag==2){
	    	calendar.add(Calendar.MONTH, minute);
	    } 
	    else if(flag==3){
	    	calendar.add(Calendar.DATE, minute);
	    } 
	    else if(flag==4){
	    	calendar.add(Calendar.HOUR_OF_DAY, minute);
	    } 
	    else if(flag==5){
	    	calendar.add(Calendar.MINUTE, minute);
	    } 
	    else if(flag==6){
	    	calendar.add(Calendar.SECOND, minute);
	    } 
//	    Calendar转化为Date
	    Date date=calendar.getTime();
	    return date;
	}
	
	/**
	 * 
	 * @方法说明:
	 * @方法名称:getAddDate
	 * @param d
	 * @param minute
	 * @param flag
	 * @return
	 * @作者:zw
	 * @返回值:int[]
	 */
	public static int[] getAddDate(Date d,int minute,int flag){
		// 创建 Calendar 对象  
		Calendar calendar = Calendar.getInstance();  
		// 初始化 Calendar 对象，但并不必要，除非需要重置时间  
		calendar.setTime(d);  
		// 
		if(flag==1){
	    	calendar.add(Calendar.YEAR, minute);
	    }else if(flag==2){
	    	calendar.add(Calendar.MONTH, minute);
	    } 
	    else if(flag==3){
	    	calendar.add(Calendar.DATE, minute);
	    } 
	    else if(flag==4){
	    	calendar.add(Calendar.HOUR_OF_DAY, minute);
	    } 
	    else if(flag==5){
	    	calendar.add(Calendar.MINUTE, minute);
	    } 
	    else if(flag==6){
	    	calendar.add(Calendar.SECOND, minute);
	    } 
		int MINUTE1 = calendar.get(Calendar.YEAR); 
		int MINUTE2 = calendar.get(Calendar.MONTH); 
		int MINUTE3 = calendar.get(Calendar.DATE); 
		int MINUTE4 = calendar.get(Calendar.HOUR_OF_DAY); 
		int MINUTE5 = calendar.get(Calendar.MINUTE); 
		int MINUTE6 = calendar.get(Calendar.SECOND); 
		int[] a = new int[6];
		a[0] = MINUTE1;
		a[1] = MINUTE2;
		a[2] = MINUTE3;
		a[3] = MINUTE4;
		a[4] = MINUTE5;
		a[5] = MINUTE6;
		return a;
	}
		
	public void getcou(){
		// 字符串转换日期格式  
	    // DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    // 得到日期格式对象  
	    // Date date = fmtDateTime.parse(strDateMake);  
	  
	    // 完整显示日期时间  
	    String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date());  
	    System.out.println(str);  
	  
	    // 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(new Date());  
	  
	    // setTime 类似上面一行  
	    // Date date = new Date();  
	    // calendar.setTime(date);  
	  
	    // 显示年份  
	    int year = calendar.get(Calendar.YEAR);  
	    System.out.println("YEAR is = " + String.valueOf(year));  
	  
	    // 显示月份 (从0开始, 实际显示要加一)  
	    int MONTH = calendar.get(Calendar.MONTH);  
	    System.out.println("MONTH is = " + (MONTH + 1));  
	  
	    // 今年的第 N 天  
	    int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);  
	    System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);  
	  
	    // 本月第 N 天  
	    int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);  
	    System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));  
	  
	    // 3小时以后  
	    calendar.add(Calendar.HOUR_OF_DAY, 3);  
	    int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);  
	    System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);  
	  
	    // 当前分钟数  
	    int MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE = " + MINUTE);  
	  
	    // 15 分钟以后  
	    calendar.add(Calendar.MINUTE, 15);  
	    MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE + 15 = " + MINUTE);  
	  
	    // 30分钟前  
	    calendar.add(Calendar.MINUTE, -30);  
	    MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE - 30 = " + MINUTE);  
	  
	    // 格式化显示  
	    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());  
	    System.out.println(str);  
	  
	    // 重置 Calendar 显示当前时间  
	    calendar.setTime(new Date());  
	    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());  
	    System.out.println(str);  
	  
	    // 创建一个 Calendar 用于比较时间  
	    Calendar calendarNew = Calendar.getInstance();  
	  
	    // 设定为 5 小时以前，后者大，显示 -1  
	    calendarNew.add(Calendar.HOUR, -5);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar));  
	  
	    // 设定7小时以后，前者大，显示 1  
	    calendarNew.add(Calendar.HOUR, +7);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar));  
	  
	    // 退回 2 小时，时间相同，显示 0  
	    calendarNew.add(Calendar.HOUR, -2);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar)); 
	}
}
