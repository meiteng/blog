package com.qx.ar.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminFindService;
import com.qx.ar.admin.service.IAdminFindTypeService;
import com.qx.ar.modle.Find;
import com.qx.ar.modle.FindType;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminFind")
@RequestMapping("/admin/find")
public class AdminFindController {

	@Resource
	private IAdminFindService adminFindService;
	@Resource
	private IAdminFindTypeService iAdminFindTypeService;

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
		Find find = new Find();

		Map<String, Object> listMap = adminFindService.pageList(find, Integer.parseInt(page));
		
		model.addAttribute("findList", listMap.get("list"));
      
		return "admin/find/list";
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
		
		FindType findType = new FindType();
		List<Object> findTypeList = iAdminFindTypeService.findList(findType);
		model.addAttribute("findTypeList", findTypeList);
		return "admin/find/add";
	}

	/**
	 * 发现添加提交
	 * 
	 * @return
	 */
	@RequestMapping(value = "doAdd", produces = "text/html;")
	public String doAdd(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String tags = request.getParameter("tags");
		String content = request.getParameter("content");
		String androidUrl = request.getParameter("androidUrl");
		String iosUrl = request.getParameter("iosUrl");
		String imgUrl = request.getParameter("imgUrl");
		String typeId = request.getParameter("findType");
		String identificationName = request.getParameter("identificationName");
		//TODO 验证规则 没有写
		Find find = new Find(title, desc, content, tags, androidUrl, iosUrl, Integer.parseInt(typeId), imgUrl);
		find.setAddtime(DateUtils.getCurrentTimestamp());
		find.setIdentificationName(identificationName);
		adminFindService.add(find);
		return "redirect:/admin/find/list";
	}

	/*
	 * 删除
	 */
	@RequestMapping(value = "/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		
		String id=request.getParameter("id");
		//TODO 验证规则 没有写
		
		adminFindService.delete(Integer.parseInt(id));
		return "redirect:" + request.getHeader("Referer");

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
		Find find=new Find();
		find.setId(Integer.parseInt(id));
		find=adminFindService.findOne(find);
		FindType findType = new FindType();
		List<Object> findTypeList = iAdminFindTypeService.findList(findType);
		model.addAttribute("findTypeList", findTypeList);
		model.addAttribute("detail", find);
		return "admin/find/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String id =request.getParameter("id");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String tags = request.getParameter("tags");
		String content = request.getParameter("content");
		String androidUrl = request.getParameter("androidUrl");
		String iosUrl = request.getParameter("iosUrl");
		String imgUrl = request.getParameter("imgUrl");
		String typeId = request.getParameter("findType");
		String identificationName = request.getParameter("identificationName");
		//TODO 验证规则 没有写
		Find find = new Find(title, desc, content, tags, androidUrl, iosUrl, Integer.parseInt(typeId), imgUrl);
		find.setId(Integer.parseInt(id));
		find.setIdentificationName(identificationName);
		System.out.println(find);
		adminFindService.update(find);
		
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
}
