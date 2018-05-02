package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminUserService;
import com.qx.ar.modle.User;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminUser")
@RequestMapping("/admin/user")
public class AdminUserController {

	@Resource
	private IAdminUserService adminUserService;
	/*@Resource
	private IAdminFindTypeService iAdminFindTypeService;*/
	
	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		String page=request.getParameter("page");
		if(ValidateUtil.isEmpty(page)){
			page="0";
		}
		//TODO 查询条件在此写
		//其他查询条件在此写
		User user =new User();
		
		Map<String, Object> listMap = adminUserService.pageList(user, Integer.parseInt(page));
		model.addAttribute("list", listMap.get("list"));
		return "admin/user/list";
	}
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		//字符串转换成integer
		String id=request.getParameter("id");
		//TODO 验证规则 没有写
		adminUserService.delete(Integer.parseInt(id));
		return "redirect:"+request.getHeader("Referer");
		
	}
	/**
	 * 添加发现
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "text/html;")
	public String add(HttpServletRequest request, Model model){
		
		return "admin/user/add";
	}
	
	/**
	 * 发现添加提交
	 * @return
	 */
	@RequestMapping(value="doAdd",produces="text/html;")
	public String doAdd(HttpServletRequest request,Model model){
		String headUrl=request.getParameter("headUrl");
		String nickName=request.getParameter("nickName");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		System.out.println("----headUrl="+headUrl+"-----nickName="+nickName+"-----phone="+phone+"-----password="+password);
		
		User user=new User(nickName, phone, headUrl,password);
		user.setAddtime(DateUtils.getCurrentTimestamp());
		adminUserService.add(user);
		return "redirect:/admin/user/list";
	}
	/**
	 * 修改发现
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
	public String update(HttpServletRequest request, Model model,HttpServletResponse response) {
		WebUtils.addCookie(request, response, "listUrl", request.getHeader("Referer"), -1);
		String id=request.getParameter("id");
		//TODO 验证没写
		User user=new User();
		user.setId(Integer.parseInt(id));	
		user=adminUserService.findOne(user);
		System.out.println(user);
		model.addAttribute("detail", user);
		return "admin/user/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String id =request.getParameter("id");
		String headUrl=request.getParameter("headUrl");
		String nickName=request.getParameter("nickName");
		String phone=request.getParameter("phone");
		//TODO 验证规则 没有写
		User user = new User(nickName,phone,headUrl);
		user.setId(Integer.parseInt(id));
		System.out.println(user);
		adminUserService.update(user);
		
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
	}
	

