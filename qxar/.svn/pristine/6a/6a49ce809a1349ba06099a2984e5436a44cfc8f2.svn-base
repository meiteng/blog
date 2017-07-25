package com.qx.ar.admin.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qx.ar.admin.service.IAdminArticleService;
import com.qx.ar.modle.Article;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.ValidateUtil;
import com.qx.ar.utils.WebUtils;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("adminArticle")
@RequestMapping("/admin/article")
public class AdminArticleController {

	@Resource
	private IAdminArticleService adminArticleService;
	
	/*@Resource
	private IAdminArticleTypeService adminArticleTypeService;*/
	/*
	 * 文章列表
	 */
	@RequestMapping(value = "/list", produces = "text/html;")
	public String list(HttpServletRequest request, Model model) {
		String page=request.getParameter("page");
		if(ValidateUtil.isEmpty(page)){
			page="0";
		}
		//TODO 查询条件在此写
		//其他查询条件在此写
		Article article = new Article();
		
		Map<String, Object> listMap = adminArticleService.pageList(article, Integer.parseInt(page));

		model.addAttribute("articleList", listMap.get("list"));
		return "admin/article/list";
	}
	/*
	 * 查询文章详情
	 */
	@RequestMapping(value = "/detail", produces = "text/html;")
	public String detailList(HttpServletRequest request, Model model,HttpServletResponse response){
		WebUtils.addCookie(request, response, "listUrl", request.getHeader("Referer"), -1);	
		String id = request.getParameter("id");
		Article article = new Article();
			article.setId(Integer.parseInt(id));
			article = adminArticleService.findOne(article);
			model.addAttribute("detail",article);
			System.out.println(article.getImg_url());
			return "admin/article/detail";
	}
	/*
	 * 跳转到添加文章页面
	 */
	@RequestMapping(value="/add",produces="text/html;")
	public String add(HttpServletRequest request, Model model) {
		return "admin/article/add";
	}
	
	/**
	 * 添加文章
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="doAdd",produces="text/html;")
	public String doAdd(HttpServletRequest request,Model model){
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String img_url=request.getParameter("imgUrl");
		
		Article article  = new Article(img_url, title, content);
		//article.setAddtime(DateUtils.getCurrentTimestamp());
		System.out.println(article);
		adminArticleService.add(article);
		return "redirect:/admin/article/list";
	}
	
	/*
	 * 删除
	 */
	@RequestMapping(value="/delete", produces = "text/html;")
	public String delete(HttpServletRequest request, Model model) {
		String id=request.getParameter("id");
		//TODO 验证规则 没有写
		adminArticleService.delete(Integer.parseInt(id));
		return "redirect:" + request.getHeader("Referer");
	}
	
	/*
	 * 修改
	 */
	@RequestMapping(value="/update", produces="text/html;charset=UTF-8")
	public String update(HttpServletRequest request, Model model,HttpServletResponse response) {
		WebUtils.addCookie(request, response, "listUrl", request.getHeader("Referer"), -1);
		String id=request.getParameter("id");
		//TODO 验证没写
		Article article = new Article();
		article.setId(Integer.parseInt(id));
		article=adminArticleService.findOne(article);
		model.addAttribute("detail", article);
		return "admin/article/update";
	}
	
	@RequestMapping(value="/doUpdate",produces="text/html;charset=UTF-8")
	public String doUpdate(HttpServletRequest request, Model model){
		String id =request.getParameter("id");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String img_url=request.getParameter("imgUrl");
		//TODO 验证规则 没有写
		Article article = new Article(img_url, title, content);
		article.setId(Integer.parseInt(id));
		System.out.println(article);
		adminArticleService.update(article);
		return "redirect:" + WebUtils.findCookieValue(request, "listUrl");
	}
	
	
}
	

