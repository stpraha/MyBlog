package cxd.blog.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getFormatDate(Date date) {
		DateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		
		return format.format(date);
	}
	
	public static Date getDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		return format.parse(date);
	}
}
