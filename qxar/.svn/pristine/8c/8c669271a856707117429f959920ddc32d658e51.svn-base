package com.qx.ar.admin.controller;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qx.ar.admin.service.IAdminService;
import com.qx.ar.modle.Admin;
import com.qx.ar.utils.MD5Util;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;
import com.qx.ar.utils.SessionUtils;
import com.qx.ar.utils.ValidateUtil;
import com.sun.istack.internal.logging.Logger;

/**
 * 管理员模块
 * 
 * @author Administrator
 *
 */
@Controller("admin")
@RequestMapping("/admin/admin")
public class AdminController {

	@Resource
	private IAdminService adminService;

	private Logger log = Logger.getLogger(AdminController.class);
	
	@RequestMapping(value = "/login", produces = "text/html;")
	public String login(HttpServletRequest request, Model model) {
		return "admin/login";
	}

	@RequestMapping(value = "/index", produces = "text/html;")
	public String index(HttpServletRequest request, Model model) {
		// Admin admin=(Admin)request.getSession().getAttribute("admin");

		model.addAttribute("username", "admin");
		return "admin/index";
	}

	@RequestMapping(value = "/doLogin", produces = "text/html;")
	public String doLogin(HttpServletRequest request, Model model) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if (ValidateUtil.isEmpty(userName)) {
			model.addAttribute("error", "用户名不能为空");
			return "admin/login";
		}

		if (ValidateUtil.isEmpty(password)) {
			model.addAttribute("error", "用户密码不能为空");
			return "admin/login";
		}

		// 判断用户名和密码是否正确
		Admin admin = adminService.login(userName);
		password = MD5Util.MD5(password);

		if (admin == null || !password.equals(admin.getPassword())) {
			model.addAttribute("error", "用户名或密码错误");
			return "admin/login";
		}
		SessionUtils.add(request, "admin", admin);
		return "redirect:/admin/admin/index";
	}

	/**
	 * 添加测试页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", produces = "text/html;")
	public String addTest(HttpServletRequest request, Model model) {

		return "addTest";
	}

	/**
	 * 所有的后台上传总方法，可以上传任何类型的文件
	 * @param file
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", produces = "application/json;")
	public Result upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Model model) {
		try {
			//
			String localDirName = request.getParameter("dirName");
			String path = request.getSession().getServletContext().getRealPath("upload");
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			if (ValidateUtil.isEmpty(localDirName)) {
				localDirName = "/";
			} else {
				localDirName = "/" + localDirName + "/";
			}

			String dir = localDirName + year + "/" + month;
			path += dir;
			System.out.println(path);

			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			System.out.println(suffix);
			String fileName = new Date().getTime() + "."+suffix;
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			file.transferTo(targetFile);// 保存
			String fileUrl = "/upload" + dir + "/" + fileName;
			System.out.println(fileUrl);
			return Response.success("上传成功",fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.failed("上传失败");
		}
		
	}
	@ResponseBody
	@RequestMapping(value = "/uploadFixPathAndroid", produces = "application/json;")
	public Result uploadFixPathAndroid(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Model model) {
		try {
			String fileName="android_unity";
		
			String path = request.getSession().getServletContext().getRealPath("upload")+"/fixed/";

			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			
			fileName = fileName + "."+suffix;
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			file.transferTo(targetFile);// 保存
			String fileUrl = "/upload/fixed/"  + fileName;
			
			return Response.success("上传成功",fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.failed("上传失败");
		}
		
	}
	@ResponseBody
	@RequestMapping(value = "/uploadFixPathIos", produces = "application/json;")
	public Result uploadFixPathIos(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Model model) {
		try {
			String fileName="ios_unity";
		
			String path = request.getSession().getServletContext().getRealPath("upload")+"/fixed/";

			String originalFilename = file.getOriginalFilename();
			String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			
			fileName = fileName + "."+suffix;
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			
			file.transferTo(targetFile);// 保存
			String fileUrl = "/upload/fixed/"  + fileName;
			
			return Response.success("上传成功",fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.failed("上传失败");
		}
		
	}
	@ResponseBody
	@RequestMapping(value = "/logtest", produces = "application/json;")
	public void logtest(){
		this.log.info("aaaa");
	}
}
