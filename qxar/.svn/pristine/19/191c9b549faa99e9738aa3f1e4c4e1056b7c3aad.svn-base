package com.qx.ar.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	/**
	 * 获取session
	 * 
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession();
	}

	public static void add(HttpServletRequest request, String arg0, Object arg1) {
		request.getSession().setAttribute(arg0, arg1);
	}

	public static void delete(HttpServletRequest request, String arg0) {
		request.getSession().removeAttribute(arg0);
	}

}
