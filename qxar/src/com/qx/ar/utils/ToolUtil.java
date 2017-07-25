package com.qx.ar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ToolUtil {
	/**
	 * 正则表达式，判断手机号是否正确
	 * 
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	public boolean isChinaPhoneLegal(String str) {

		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.matches();
	}
}
