package com.jsict.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/** 默认的格式化方式 */
    public static final String defaultFormat = "yyyy-MM-dd HH:mm:ss";
    public static final String timeFormat = "HH:mm:ss";
    
    public static String getDate(String formatStr) {
       SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
       Date currentDate = new Date();
       String formatCurrentDate = dateFormat.format(currentDate).toString();

       return formatCurrentDate;
   }

   public static String getDateStr(Date date,String format){
       SimpleDateFormat sdf = new SimpleDateFormat(format);
       return sdf.format(date);
   }

    public static Date getDate(String dataStr,String formatStr){
    	SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
    	Date parse;
		try {
			parse = sdf.parse(dataStr);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
    }
    public static boolean isSameDay(Date date1, Date date2) {  
        Calendar calDateA = Calendar.getInstance();  
        calDateA.setTime(date1);  
        Calendar calDateB = Calendar.getInstance();  
        calDateB.setTime(date2);  
        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)  
                && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)  
                && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB  
                        .get(Calendar.DAY_OF_MONTH);  
    }  
    
    public static Date changeTZTime(String str){
    	str=str.substring(0, str.length()-1);
		str=str.replace("T", " ");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HHmmss");  
        Date date =null;  
        try {  
            date = sdf.parse(str); 
            return date;
        } catch (ParseException e) {  
            e.printStackTrace();  
            return null;
        } 
    }
    public static Date UTCToCST(String UTCStr, String format){
        try {
			Date date = null;
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(UTCStr);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
			//calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
			Date time = calendar.getTime();
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static void main(String[] args) {
		System.out.println(DateUtil.getDate(timeFormat));
		System.out.println(DateUtil.getDate("20180101 000000", "yyyyMMdd HHmmss"));
		Date date1 = DateUtil.getDate("20180101 000000", "yyyyMMdd HHmmss");
		Date date2 = DateUtil.getDate("20180201 000000", "yyyyMMdd HHmmss");
		long l=(date2.getTime()-date1.getTime())/1000;
		System.out.println(l);
		int i=20000000;
		System.out.println(l>i);
		System.out.println(new Date().getTime());
	}
}
