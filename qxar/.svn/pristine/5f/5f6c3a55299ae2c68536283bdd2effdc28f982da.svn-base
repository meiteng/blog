package com.qx.ar.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.ar.api.service.ICommentService;
import com.qx.ar.utils.HttpUtils;
import com.qx.ar.utils.PageUtil;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

/**
 * 评论模块
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/comment")
public class CommentController {

	@Resource
	private ICommentService commentService;

	/**
	 * 评论
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add", produces = "application/json;")
	public Result add(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");
		String objid = request.getParameter("objid");
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		if ("".equals(objid) || objid == null) {
			return Response.failed("objid不能为空");
		}
		if ("".equals(content) || content == null) {
			return Response.failed("评论内容不能为空");
		}
		return commentService.add(Integer.parseInt(userid), Integer.parseInt(objid), content);
	}
	
	
	/**
	 * 评论列表
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list")
	public Result list(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String objId = request.getParameter("objId");
		String addtime = request.getParameter("addtime");
		if ("".equals(objId) || objId == null) {
			return Response.failed("objId为空");
		}
		if ("".equals(addtime) || addtime == null) {
			addtime = String.valueOf(System.currentTimeMillis() / 1000);
		}
		
		PageUtil pageUtil=new PageUtil();
		return commentService.list(Integer.parseInt(objId),Integer.parseInt(addtime), pageUtil.getSize());
	}

}
