package com.qx.ar.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.ar.api.service.ISearchService;
import com.qx.ar.utils.HttpUtils;
import com.qx.ar.utils.PageUtil;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

/**
 * 搜索模块
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/search")
public class SearchController {

	@Resource
	private ISearchService searchService;

	/**
	 * 搜索所有发现
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/find", produces = "application/json;")
	public Result find(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String time = request.getParameter("time");
		PageUtil pageUtil=new PageUtil();//分页类
		if ("".equals(title) && title == null && "".equals(desc) && desc == null) {
			return Response.failed("搜索内容不能为空");
		}
		
		if ("".equals(time) || time == null) {
			return Response.failed("下一页分页时间不能为空");
		}
		
		return searchService.find(title, desc, Integer.parseInt(time),pageUtil.getSize());
	}

}
