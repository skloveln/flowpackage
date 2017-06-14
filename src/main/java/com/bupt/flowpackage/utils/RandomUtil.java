package com.bupt.flowpackage.utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomUtil {

	/** 年月日时分秒(无下划线) yyyyMMddHHmmss */
	public static final String dtLong = "yyyyMMddHHmmssSSS";

	/** 完整时间 yyyy-MM-dd HH:mm:ss */
	public static final String simple = "yyyy-MM-dd HH:mm:ss";

	/** 年月日(无下划线) yyyyMMdd */
	public static final String dtShort = "yyyyMMdd";

	
	/**
	 * 返回系统当前时间(精确到毫秒)
	 * @return 以yyyyMMddHHmmss为格式的当前系统时间
	 */
	public static String produceRequestNo(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dtLong);
		String requestNo = df.format(date);
		return requestNo;
	}

	/**
	 * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateFormatter() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(simple);
		return df.format(date);
	}

	/**
	 * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dtShort);
		return df.format(date);
	}

	/**
	 * 产生随机的N位数
	 * @return
	 */
	public static String getRandomStr(int n) {
		Random rad = new Random();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++) {
			str.append(rad.nextInt(10) + "");
		}
		return str.toString();
	}

	/**
	 * 获取一定长度的随机字符串
	 * @param length 指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStringByLength(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
