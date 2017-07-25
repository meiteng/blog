package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminResourcesService;

import com.qx.ar.modle.Resources;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminResources")
@RequestMapping("/admin/resources")
public class AdminResourcesController {

	@Resource
	private IAdminResourcesService adminResourceService;

	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		String page = request.getParameter("page");
		if (ValidateUtil.isEmpty(page)) {
			page = "0";
		}

		Resources resources = new Resources();

		Map<String, Object> listMap = adminResourceService.pageList(resources, Integer.parseInt(page));
		model.addAttribute("list", listMap.get("list"));
		return "admin/resources/list";
	}

	/*
	 * 删除
	 */
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		// 字符串转换成integer
		String id=request.getParameter("id");
		//TODO 验证规则 没有写

		adminResourceService.delete(Integer.parseInt(id));
		return "redirect:" + request.getHeader("Referer");

	}

	/**
	 * 添加资源
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "text/html;")
	public String add(HttpServletRequest request, Model model) {


		return "admin/resources/add";
	}

	/**
	 * 发现添加提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "doAdd", produces = "text/html;")
	public String doAdd(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String imgUrl = request.getParameter("imgUrl");
		String content = request.getParameter("content");
		String desc = request.getParameter("desc");
		String identificationUrl = request.getParameter("identificationUrl");
		String identificationName = request.getParameter("identificationName");
		System.out.println("----title=" + title + "-----imgUrl=" + imgUrl + "-----content=" + content + "-----content="
				+ content + "---desc=" + desc);

		Resources resources = new Resources(title, imgUrl, content, desc,identificationUrl,identificationName);
		resources.setAddtime(DateUtils.getCurrentTimestamp());
		adminResourceService.add(resources);
		return "redirect:/admin/resources/list";
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
		Resources resources=new Resources();
		resources.setId(Integer.parseInt(id));
		
		resources=adminResourceService.findOne(resources);
		
		model.addAttribute("detail", resources);
		return "admin/resources/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String id =request.getParameter("id");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String content = request.getParameter("content");
		String imgUrl = request.getParameter("imgUrl");
		String identificationUrl = request.getParameter("identificationUrl");
		String identificationName = request.getParameter("identificationName");
		//TODO 验证规则 没有写
		Resources resources = new Resources(title, imgUrl, content, desc,identificationUrl,identificationName);
		resources.setId(Integer.parseInt(id));
		System.out.println(resources);
		adminResourceService.update(resources);
		
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
}
