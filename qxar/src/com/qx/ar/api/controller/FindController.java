package com.qx.ar.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.ar.api.service.IFindService;
import com.qx.ar.utils.HttpUtils;
import com.qx.ar.utils.PageUtil;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

/**
 * 发现模块
 * 
 * @author hanyu
 *
 */
@Controller
@RequestMapping("/api/find")
public class FindController {

	@Resource
	private IFindService iFindService;

	@ResponseBody
	@RequestMapping(value = "/detail")
	public Result detail(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String id = request.getParameter("id");
		
		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(id) || id == null) {
			return Response.failed("id不能为空");
		}

		
		return iFindService.findOne(Integer.parseInt(id));

	}

	@ResponseBody
	@RequestMapping(value="/list", produces = "application/json;charset=UTF-8;")
	public Result list(HttpServletRequest request, Model model) {
		
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String addtime = request.getParameter("addtime");
		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(addtime) || addtime == null) {
			addtime = String.valueOf(System.currentTimeMillis() / 1000);
		}
		PageUtil pageUtil = new PageUtil();
		return iFindService.findAll(Integer.parseInt(addtime), pageUtil.getSize());
	}

	@ResponseBody
	@RequestMapping(value="/findType", produces = "application/json;")
	public Result findType(HttpServletRequest request, Model model) {
		System.out.println(222);
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		System.out.println(111);
		String apptoken = request.getParameter("apptoken");
		System.out.println(apptoken);
		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		return iFindService.allType();
	}

}
