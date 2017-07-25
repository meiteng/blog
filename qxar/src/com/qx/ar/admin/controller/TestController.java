package com.qx.ar.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qx.ar.admin.service.IAdminService;


/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminTest")
@RequestMapping("/admin/test")
public class TestController {

	@Resource
	private IAdminService adminService;
	

	@RequestMapping(value = "/test", produces = "text/html;")
	public String login(HttpServletRequest request, Model model) {
		return "admin/test";
	}
	
}
