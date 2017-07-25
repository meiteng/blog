package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qx.ar.admin.service.IAdminSuggestionService;
import com.qx.ar.modle.Suggestion;
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
@Controller("adminSuggestion")
@RequestMapping("/admin/suggestion")
public class AdminSuggestionController {

	@Resource
	private IAdminSuggestionService adminSuggestionService;

	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		String page = request.getParameter("page");
		if (ValidateUtil.isEmpty(page)) {
			page = "0";
		}
		// 其他查询条件在此写
		Suggestion suggestion = new Suggestion();
		Map<String, Object> listMap = adminSuggestionService.pageList(suggestion, Integer.parseInt(page));
		model.addAttribute("list", listMap.get("list"));
		
		return "admin/suggestion/list";
	}

	/*
	 * 删除 TODO验证规则
	 */
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		// 字符串转换成integer
		String id = request.getParameter("id");
		// TODO 验证规则 没有写
		adminSuggestionService.delete(Integer.parseInt(id));
		return "redirect:" + request.getHeader("Referer");
	}

	/**
	 * 添加发现
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "text/html;")
	public String add(HttpServletRequest request, Model model) {
		/*
		 * FindType findType=new FindType(); List<Object>
		 * findTypeList=iAdminFindTypeService.findList(findType);
		 * System.out.println(findTypeList.toString());
		 * model.addAttribute("findTypeList",findTypeList);
		 */
		return "admin/suggestion/add";
	}

	/**
	 * 发现添加提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "doAdd", produces = "text/html;")
	public String doAdd(HttpServletRequest request, Model model) {
		String content = request.getParameter("content");
		String contact = request.getParameter("contact");
		// String userid=request.getParameter("userid");
		// String phone=request.getParameter("phone");
		System.out.println("----content=" + content + "-----contact=" + contact);

		Suggestion suggestion = new Suggestion(content, contact);
		suggestion.setAddtime(DateUtils.getCurrentTimestamp());
		adminSuggestionService.add(suggestion);
		return "redirect:/admin/suggestion/list";
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
		Suggestion suggestion=new Suggestion();
		System.out.println(id);
		suggestion.setId(Integer.parseInt(id));
		System.out.println(suggestion);
		suggestion=adminSuggestionService.findOne(suggestion);
		model.addAttribute("detail",suggestion);
		System.out.println(suggestion);
		return "admin/suggestion/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String id =request.getParameter("id");
		
		String content = request.getParameter("content");
		String contact = request.getParameter("contact");
		//TODO 验证规则 没有写
		Suggestion suggestion = new Suggestion(content, contact);
		suggestion.setId(Integer.parseInt(id));
		System.out.println(suggestion);
		adminSuggestionService.update(suggestion);
		
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}

}
