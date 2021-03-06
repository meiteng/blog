package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminFindTypeService;
import com.qx.ar.admin.service.IAdminResourcesInnerService;
import com.qx.ar.admin.service.IAdminResourcesService;
import com.qx.ar.modle.Find;
import com.qx.ar.modle.FindType;
import com.qx.ar.modle.Resources;
import com.qx.ar.modle.ResourcesInner;
import com.qx.ar.utils.BackPageUtil;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminResourcesInner")
@RequestMapping("/admin/resourcesinner")
public class AdminResourcesInnerController {

	@Resource
	private IAdminResourcesInnerService adminResourcesInnerService;

	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		String page = request.getParameter("page");
		String resourcesId=request.getParameter("id");
		if (ValidateUtil.isEmpty(page)) {
			page = "0";
		}
		//TODO resourcesid需要去验证
		ResourcesInner resources = new ResourcesInner();
		resources.setResourcesid(Integer.parseInt(resourcesId));
		Map<String, Object> listMap = adminResourcesInnerService.pageList(resources, Integer.parseInt(page));
		model.addAttribute("list", listMap.get("list"));
		model.addAttribute("resourcesId",resourcesId);
		return "admin/resourcesinner/list";
	}

	/*
	 * 删除
	 */
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		// 字符串转换成integer
		String id = request.getParameter("id");
		// TODO 验证规则 没有写

		adminResourcesInnerService.delete(Integer.parseInt(id));
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
	public String add(HttpServletRequest request, Model model,HttpServletResponse response) {
		WebUtils.addCookie(request, response, "backUrl", request.getHeader("Referer"), -1);
		String resourcesId=request.getParameter("id");
		// TODO 验证规则 没有写
		// TODO 验证规则 需要检验id 
		model.addAttribute("resourcesId",resourcesId);
		
		return "admin/resourcesinner/add";
	}

	/**
	 * 发现添加提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "doAdd", produces = "text/html;")
	public String doAdd(HttpServletRequest request, Model model) {
		String resourcesid = request.getParameter("resourcesid");
		String identificationUrl = request.getParameter("identificationUrl");
		String identificationName = request.getParameter("identificationName");
		String androidUrl = request.getParameter("androidUrl");
		String iosUrl = request.getParameter("iosUrl");

		ResourcesInner resources = new ResourcesInner(Integer.parseInt(resourcesid), identificationUrl,
				identificationName, androidUrl, iosUrl);
		adminResourcesInnerService.add(resources);
		return "redirect:" + WebUtils.findCookieValue(request, "backUrl");
	}

	/**
	 * 修改发现
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
	public String update(HttpServletRequest request, Model model, HttpServletResponse response) {
		WebUtils.addCookie(request, response, "listUrl", request.getHeader("Referer"), -1);
		String id = request.getParameter("id");
		// TODO 验证没写
		ResourcesInner resources = new ResourcesInner();
		resources.setId(Integer.parseInt(id));

		resources = adminResourcesInnerService.findOne(resources);

		model.addAttribute("detail", resources);
		return "admin/resourcesinner/update";
	}

	@RequestMapping(value = "/doUpdate", produces = "text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String imgUrl = request.getParameter("imgUrl");
		String identificationUrl = request.getParameter("identificationUrl");
		String identificationName = request.getParameter("identificationName");
		String allResources = request.getParameter("allResources");
		String resourcesName = request.getParameter("resourcesName");
		// TODO 验证规则 没有写
		ResourcesInner resources = new ResourcesInner();
		resources.setId(Integer.parseInt(id));
		System.out.println(resources);
		adminResourcesInnerService.update(resources);

		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
}
