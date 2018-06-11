package com.haibo.future.util;


public class CommonUtil {


	/**
	 * 获取bizLine、action
	 * @param url
	 * @return
	 */
	public static String[] parseUrl(String url) {
		String[] strs = url.trim().split("/");
		Integer length = strs.length;
		if (length > 2) {
			return new String[] { strs[length - 2], strs[length - 1] };
		}
		return strs;
	}


}
