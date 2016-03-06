
package org.zw.singleton.jeeframework.common.utils.times;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 
  * @类名:Ctime
  * @类描述:
  * @作者:zw
  * @创建时间:2015年11月20日-上午10:15:24
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 1.0
  * @Copyright (c)-2015
 */
public class CtimeDateFormat {

    /**
     * @方法说明:将时间戳转为代表"距现在多久之前"的字符串
     * @方法名称:getStandardDate
     * @param timeStr 时间戳
     * @方法说明:
     * @方法名称:getStandardDate
     * @param timeStr
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getStandardDate(String timeStr) {

        StringBuffer sb = new StringBuffer();

        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long mill = (long) Math.ceil(time / 1000);// 秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    /**
     * @方法说明:将时间戳转为代表"距现在多久之前"的字符串
     * @方法名称:getStandardDate
     * @param timeStr 时间戳
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getDate(String timeStr) {
        StringBuffer sb = new StringBuffer();
        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 == 0) {
            sb.append("今天");
        } else if (day - 2 == 0) {
            sb.append("昨天");
        } else if (day - 3 == 0) {
            sb.append("前天");
        } else {
            sb.append(day + "天");
        }

        if (!sb.toString().equals("今天") && !sb.toString().equals("昨天")
                && !sb.toString().equals("前天")) {
            sb.append("前");
        }
        return sb.toString();
    }

    /**
     * 
     * @方法说明:转换格式"yyyy-MM-dd"
     * @方法名称:getStrTimeNYR
     * @param cc_time 时间戳
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getStrTimeNYR(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }
    
    /**
     * 时间戳转string
     * @方法说明:
     * @方法名称:getDatTimeNYR
     * @param cc_time
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getDatTimeNYR(long cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(cc_time));
        return re_StrTime;
    }

    /**
     * 
     * @方法说明:转换格式"HH-mm"
     * @方法名称:getStrTimeHM
     * @param cc_time 时间戳
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getStrTimeHMS(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 
     * @方法说明: 将字符串转为时间戳
     * @方法名称:getTime
     * @param user_time
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {

            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }

    /**
     * 
     * @方法说明:将时间戳转为字符串
     * @方法名称:getStrTime
     * @param cc_time
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
//        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * 转成时间格式
     * @方法说明:
     * @方法名称:cal
     * @param second
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String cal(int second) {
        int h = 0;
        int d = 0;
        int s = 0;
        int temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        return h + ":" + d + ":" + s + ":";
    }

    /**
     * 毫秒转化
     * @方法说明:
     * @方法名称:formatTime
     * @param ms
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String formatTime(long ms) {

        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second
                * ss;

        String strDay = day < 10 ? "0" + day : "" + day; // 天
        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        String strSecond = second < 10 ? "0" + second : "" + second;// 秒
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : ""
                + milliSecond;// 毫秒
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : ""
                + strMilliSecond;

        return strDay + ":" + strHour + ":" + strMinute + ":" + strSecond;
    }
    
	/**
	 * 返回倒计时
	 * @方法说明:
	 * @方法名称:StringToLong
	 * @param times
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String StringToLong(String times){
		String timeslong;
		long a = 0;
		long ab = 0;
		long b = System.currentTimeMillis()/1000;//当前时间
		if(times!=null && !"".equals(times)){
			timeslong = CtimeDateFormat.getTime(times);
			a = Long.parseLong(timeslong);
		}
		if(a > b){
			ab = a-b;
		}
		timeslong = String.valueOf(ab);
		return timeslong;
	}
	
	
	/**
	 * 返回时间戳
	 * @方法说明:
	 * @方法名称:DataToLong
	 * @param times
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String DataToLong(Date times) {
		String timeslong;
		long a = 0;
		long ab = 0;
		long b = System.currentTimeMillis() / 1000;// 当前时间
		if (times != null && !"".equals(times)) {
			long l = times.getTime();
			String str = String.valueOf(l);
			String re_time = str.substring(0, 10);
			a = Long.parseLong(re_time);
		}
		if (a > b) {
			ab = a - b;
		}
		timeslong = String.valueOf(ab);
		return timeslong;
	}
	
	/**
	 * 格式化时间
	 * @方法说明:
	 * @方法名称:DataToString
	 * @param times
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String DataToString(Date times) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        re_StrTime = sdf.format(times);
		return re_StrTime;
	}
	
	/**
	 * 格式化时间  
	 * @方法说明:根据传入的时间格式
	 * @方法名称:DataToString
	 * @param times
	 * @param format
	 * @return
	 * @作者:zw
	 * @返回值:String
	 */
	public static String DataToString(Date times,String format) {
		String re_StrTime = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
        re_StrTime = sdf.format(times);
		return re_StrTime;
	}
	
}
