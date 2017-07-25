package com.qx.ar.api.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;
import com.qx.ar.utils.Result;

/**
 * 测试模块
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@ResponseBody
	@RequestMapping(value = "/test", produces = "application/json;")
	public Result register(HttpServletRequest request, Model model) {
		request.getSession().setAttribute("vercode", "8888");
		return null;
	}

	@RequestMapping(value = "/test1", produces = "application/json;")
	public String test1(HttpServletRequest request, Model model) {
		return "upload2";
	}

//	@ResponseBody
//	@RequestMapping(value = "/uploadOSS", produces = "application/json;")
//	public String uploadOSS(@RequestParam(value = "file", required = false) MultipartFile file) {
//		OSSUtil oss = new OSSUtil();
//		Date date = new Date();
//		String filepath = DateUtil.getYear(date) + "/" + DateUtil.getMonth(date) + "/test.txt";
//		return oss.uploadFile(filepath, file);
//	}
	
	@RequestMapping(value = "/testEditor", produces = "application/json;")
	public String  testEditor(HttpServletRequest request,HttpServletResponse response){
//		String rootPath =System.getProperty("webRealPath");
//		System.out.println(rootPath);
//		try {
//			response.getWriter().write(new ActionEnter( request, rootPath ).exec());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		return "test";
	}
	@ResponseBody
	@RequestMapping(value = "/config", produces = "application/json;")
	public void config(HttpServletRequest request,HttpServletResponse response){
		String rootPath = request.getSession().getServletContext().getRealPath("/");

        try {
                String exec = new ActionEnter(request, rootPath).exec();
                PrintWriter writer = response.getWriter();
                writer.write(exec);
                writer.flush();
                writer.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
	}

}
