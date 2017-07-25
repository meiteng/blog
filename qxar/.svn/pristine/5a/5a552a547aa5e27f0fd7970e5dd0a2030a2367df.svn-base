package com.qx.ar.admin.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminUnity")
@RequestMapping("/admin/unity")
public class AdminUnityController {

	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		
		return "admin/unity/list";
	}
}
