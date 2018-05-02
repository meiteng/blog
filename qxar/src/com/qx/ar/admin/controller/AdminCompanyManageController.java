package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminCompanyService;
import com.qx.ar.modle.Company;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminCompanyManage")        
@RequestMapping("/admin/companymanage")
public class AdminCompanyManageController {
                       
	@Resource    
	private IAdminCompanyService adminCompanyService;

	/**
	 * 发现列表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		
		String page = request.getParameter("page");
		if (ValidateUtil.isEmpty(page)) {
			page = "0";
		}
		// 其他查询条件在此写
		Company find = new Company();
		Map<String, Object> listMap = adminCompanyService.pageList(find, Integer.parseInt(page));

		model.addAttribute("findList", listMap.get("list"));

		return "admin/companyManage/list";
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "text/html;")
	public String add(HttpServletRequest request, Model model) {	
		
		return "admin/companyManage/add";
	}

	/**
	 * 添加提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "doAdd", produces = "text/html;")
	public String doAdd(HttpServletRequest request, Model model) {
		String companyName = request.getParameter("companyName");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String registerNum = request.getParameter("registerNum");
		String apptoken = request.getParameter("apptoken");	
		//TODO 验证规则 没有写
		Company find = new Company(companyName,address,contact,registerNum,apptoken);
		adminCompanyService.add(find);
		return "redirect:/admin/companymanage/list";
	}

	/*
	 * 删除
	 */
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		
		String apptoken=request.getParameter("apptoken");
		//TODO 验证规则 没有写
		
		adminCompanyService.delete(Integer.parseInt(apptoken));
		return "redirect:" + request.getHeader("Referer");

	}
	
	
	/**
	 * 修改
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
	public String update(HttpServletRequest request, Model model,HttpServletResponse response) {
		WebUtils.addCookie(request, response, "listUrl", request.getHeader("Referer"), -1);
		String apptoken=request.getParameter("apptoken");
		//TODO 验证没写
		Company find=new Company(apptoken);
	
		find=adminCompanyService.findOne(find);				
		model.addAttribute("detail", find);
		return "admin/companyManage/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String companyName = request.getParameter("companyName");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String registerNum = request.getParameter("registerNum");
		String apptoken = request.getParameter("apptoken");	
		//TODO 验证规则 没有写
		Company find = new Company(companyName,address,contact,registerNum,apptoken);
		
		System.out.println(find);
		adminCompanyService.update(find);
		
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
		
		/**
		 * 列表
		 * 
		 * @param request
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/information", produces = "text/html;")
		public String information(HttpServletRequest request, Model model) {
			String apptoken="888888";
			//TODO 从页面获取apptoken
			Company company = new Company(apptoken);
			
			company=adminCompanyService.findOne(company);
		    model.addAttribute("company",company);
			return "admin/company/information";
		}

		
	

}
