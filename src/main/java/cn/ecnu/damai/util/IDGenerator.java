package cn.ecnu.damai.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDGenerator {
	/**
	 * ID生成器
	 */
	static String dLastString = null;
	static SimpleDateFormat sdf = new SimpleDateFormat ("yyMMddHHmmss");
	static int count = 0;
	public static long createID() {
        String dNowString = sdf.format(new Date());      
        if(!dNowString.equals(dLastString)) {
        	dLastString = dNowString;
        	count = 0;
        }
        return Long.parseLong(dNowString + String.format("%06d", count++));
	}
}
