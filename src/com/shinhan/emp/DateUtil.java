package com.shinhan.emp;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static String converToString(Date d1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String str = sdf.format(d1); // 날짜 -> 문자
		return str;
	}

	public static Date convertToDate(String str2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		Date d2 = null;
		try {
			java.util.Date utilDate = sdf.parse(str2);
			d2 = new Date(utilDate.getTime());  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d2;
	}
	public static java.sql.Date convertToSQLDate(Date d){
		return new java.sql.Date(d.getTime());
	}

}
