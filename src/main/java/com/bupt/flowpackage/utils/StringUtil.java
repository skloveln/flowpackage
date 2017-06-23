package com.bupt.flowpackage.utils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

public class StringUtil {

	public static String removeLast(String str) {
		str = str.trim();
		return str.substring(0, str.length() - 1);
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static int getRandom6() {
		Random ran = new Random();
		int r = 0;
		m1: while (true) {
			int n = ran.nextInt(1000000);
			r = n;
			int[] bs = new int[6];
			for (int i = 0; i < bs.length; i++) {
				bs[i] = n % 10;
				n /= 10;
			}
			Arrays.sort(bs);
			for (int i = 1; i < bs.length; i++) {
				if (bs[i - 1] == bs[i]) {
					continue m1;
				}
			}
			break;
		}
		return r;
	}

	public static String md5(String str) {
		try {
			byte[] btInput = str.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString().toUpperCase();
		} catch (Exception e) {
			return str;
		}
	}

	public static int getCurrentTimeHashCode() {
		return Math.abs(String.valueOf(System.currentTimeMillis()).hashCode());
	}

	public static String randomNumString(int len) {
		final int maxNum = 10;
		char[] str = { '0', '1', '2', '3', '5', '6', '7', '8', '9' };
		StringBuffer randStr = new StringBuffer("");
		Random r = new Random();
		for (int i = 0, count = 0; count < len; i++) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				randStr.append(str[i]);
				count++;
			}
		}
		return randStr.toString();
	}

	public static String format(String format, Object... objects) {
		return String.format(format, objects);
	}
}
