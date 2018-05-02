package com.qx.ar.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.ar.api.service.IResourcesService;
import com.qx.ar.modle.Resources;
import com.qx.ar.modle.ResourcesInner;
import com.qx.ar.utils.PageUtil;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

@Controller
@RequestMapping("/api/resources")
public class ResourcesController {
	
	@Resource
	private IResourcesService resourceService;
	private Resources resources=null;
	
	@ResponseBody
	@RequestMapping(value="/detail")
	public Result detail(HttpServletRequest request, Model model){
		String id=request.getParameter("id");
		if("".equals(id)||id==null){
			return Response.failed("id参数不能为空");
		}
		resources=new Resources();
		resources.setId(Integer.parseInt(id));
		return resourceService.detail(resources);
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public Result list(HttpServletRequest request, Model model){
		String apptoken=request.getParameter("apptoken");
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		String addtime=request.getParameter("addtime");
		if("".equals(apptoken)||apptoken==null){
			return Response.failed("apptoken参数不能为空");
		}
		if("".equals(title)||title==null){
			title="";
		}
		if("".equals(desc)||desc==null){
			desc="";
		}
		if("".equals(addtime)||addtime==null){
			addtime=String.valueOf(System.currentTimeMillis()/1000);
		}
		resources=new Resources();
		resources.setApptoken(apptoken);
		resources.setTitle(title);
		resources.setDesc(desc);
		PageUtil pageUtil =new PageUtil();
		
		return resourceService.list(apptoken, title, desc, pageUtil.getSize(),Integer.parseInt(addtime));
	}
	/**
	 * unity接口 通过apptoken获取封面资源
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getResourceImg")
	public Result getResourceImg(HttpServletRequest request, Model model){
		String apptoken=request.getParameter("apptoken");
		if("".equals(apptoken)||apptoken==null){
			return Response.failed("apptoken参数不能为空");
		}
		resources=new Resources();
		resources.setApptoken(apptoken);
		return resourceService.getResourceImg(resources);
	}
	
	/**
	 * unity接口 通过resources  ID获取封面内部识别图及对应资源
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getInnerImg")
	public Result getInnerImg(HttpServletRequest request, Model model){
		String id=request.getParameter("id");
		if("".equals(id)||id==null){
			return Response.failed("id参数不能为空");
		}
		ResourcesInner resourcesInner=new ResourcesInner();
		resourcesInner.setResourcesid(Integer.parseInt(id));
		return resourceService.getRsourceInner(resourcesInner);
	}
	
}
