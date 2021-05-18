package cn.ecnu.damai.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDiff {
	static private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static int calcDayOffset(Date date1, Date date2) throws ParseException {
	    String date1Str = sdf.format(date1);
	    String date2Str = sdf.format(date2);
		Date d1 = sdf.parse(date1Str);
	    Date d2 = sdf.parse(date2Str);
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);
		
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) {
		    int timeDistance = 0;
		    for (int i = year1; i < year2; i++) {
		        if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //����
		            timeDistance += 366;
		        }
		        else {
		            timeDistance += 365;
		        }
		    }
		    return timeDistance + (day2 - day1);
		} 
		else {
	        return day2 - day1;
		}
	}
//	public static int caculateSeason(String month) {
//		return (Integer.valueOf(month) - 1) / 3 + 1;
//	}
//
//	public static int seasonIndex(int firstYear, int firstSeason, int currentYear, int currentSeason) {
//		int result = (currentYear - firstYear - 1) * 4 + (4 - firstSeason) + currentSeason;
//		if(result >= 0)
//			return result;
//		return -1;
//	}
}
