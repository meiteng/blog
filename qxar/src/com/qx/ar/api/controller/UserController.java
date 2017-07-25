package com.qx.ar.api.controller;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qx.ar.api.service.IUserService;
import com.qx.ar.modle.User;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.HttpRequestUtil;
import com.qx.ar.utils.HttpUtils;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;
import com.qx.ar.utils.ValidateUtil;

import net.sf.json.JSONObject;


/**
 * 用户模块
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

	@Resource
	private IUserService userService;

	/**
	 * 登陆
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8;")
	public Result login(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String phone = request.getParameter("phone");
		String pswd = request.getParameter("pswd");

		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(phone) || phone == null) {
			return Response.failed("用户手机号不能为空");
		}
		if ("".equals(pswd) || pswd == null) {
			return Response.failed("用户密码不能为空");
		}
		return userService.login(apptoken, phone, pswd);
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/register", produces = "application/json;charset=UTF-8;")
	public Result register(HttpServletRequest request, Model model) {
		//http://localhost:8080/qxar/user/register?phone=15207105266&apptoken=8888&pswd=123456&vercode=1307
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		
		String phone = request.getParameter("phone");
		String apptoken = request.getParameter("apptoken");
		String pswd = request.getParameter("pswd");
		String vercode = request.getParameter("vercode");
		String nickName = request.getParameter("nickname");
		String device=request.getParameter("device");
		String mapX=request.getParameter("mapx");
		String mapY=request.getParameter("mapy");
		
		
		if (ValidateUtil.isEmpty(vercode)) {
			return Response.failed("验证码不能为空");
		}
		String sessionVerco = (String) request.getSession().getAttribute("vercode");
//		if (!vercode.equals(sessionVerco) || sessionVerco == null) {
//			return Response.failed("验证码错误sessionVerco="+sessionVerco+"----------vercode="+vercode);
//		}
		if (ValidateUtil.isEmpty(apptoken)) {
			return Response.failed("公司标志不能为空");
		}
		if (ValidateUtil.isEmpty(phone)) {
			return Response.failed("手机号不能为空");
		}
		if (ValidateUtil.isEmpty(pswd)) {
			return Response.failed("密码不能为空");
		}
		if(ValidateUtil.isEmpty(nickName)){
			return Response.failed("用户昵称不能为空");
		}
		if(ValidateUtil.isEmpty(device)){
			device="";
		}
		if(ValidateUtil.isEmpty(mapX)){
			mapX="";
		}
		if(ValidateUtil.isEmpty(mapY)){
			mapY="";
		}
		int addtime=DateUtils.getCurrentTimestamp();
		User user=new User(nickName, phone, pswd, mapX, mapY, device, addtime, apptoken);
		System.out.println(user.toString());
		return userService.register(user);
	}

	/**
	 * 修改手机号
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/rephone", produces = "application/json;")
	public Result rephone(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String userid = request.getParameter("userid");
		String newphone = request.getParameter("newphone");
		String vercode = request.getParameter("vercode");
		String sessionVerco = (String) request.getSession().getAttribute("vercode");
		
		if (ValidateUtil.isEmpty(vercode)) {
			return Response.failed("验证码不能为空");
		}
		if (!vercode.equals(sessionVerco) || sessionVerco == null) {
			return Response.failed("验证码错误");
		}
		if (ValidateUtil.isEmpty(apptoken)) {
			return Response.failed("公司标志不能为空");
		}
		if (ValidateUtil.isEmpty(newphone)) {
			return Response.failed("手机号不能为空");
		}
		if (ValidateUtil.isEmpty(userid)) {
			return Response.failed("userid不能为空");
		}
		return userService.rephone(Integer.parseInt(userid), newphone);
	}

	/**
	 * 用户反馈
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/feedback", produces = "application/json;")
	public Result feedback(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String content = request.getParameter("content");
		String contactway = request.getParameter("contactway");
		String userid = request.getParameter("userid");

		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(content) || content == null) {
			return Response.failed("内容不能为空");
		}
		if ("".equals(contactway) || contactway == null) {
			return Response.failed("联系方式不能为空");
		}
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		return userService.feedback(apptoken, content, contactway, Integer.parseInt(userid));
	}

	/**
	 * 修改头像
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/rehead")
	public Result rehead(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String userid = request.getParameter("userid");
		if (file.isEmpty()) {
			return Response.failed("图片不能为空");
		}
		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		try {
			String path = request.getSession().getServletContext().getRealPath("upload");
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);
			String dir = "/" + year + "/" + month;
			path += dir;
			// System.out.println(path);
			// String fileName = file.getOriginalFilename();
			String fileName = new Date().getTime() + ".jpg";
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			file.transferTo(targetFile);// 保存
			String headurl = request.getContextPath() + "/upload" + dir + "/" + fileName;
			return userService.rehead(Integer.parseInt(userid), headurl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/reheadtest", produces = "application/json;charset=UTF-8;")
	public String reheadtest(HttpServletRequest request, Model model) {
		return "upload";
	}

	/**
	 * 修改密码
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/repswd", produces = "application/json;charset=UTF-8;")
	public Result repswd(HttpServletRequest request, Model model) {
		if (!HttpUtils.ispost(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String pswd = request.getParameter("pswd");
		String vercode = request.getParameter("vercode");
		String userid = request.getParameter("userid");
		String sessionVerco = (String) request.getSession().getAttribute("vercode");

		if ("".equals(vercode) || vercode == null) {
			return Response.failed("验证码不能为空");
		}
		if (!vercode.equals(sessionVerco) || sessionVerco == null) {
			return Response.failed("验证码错误");
		}
		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(pswd) || pswd == null) {
			return Response.failed("密码不能为空");
		}
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		return userService.repswd(Integer.parseInt(userid), pswd);
	}

	/**
	 * 帮助(用户中心)
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/help", produces = "application/json;")
	public Result help(HttpServletRequest request, Model model) {
		if (!HttpUtils.isget(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");

		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		return userService.help(apptoken);
	}

	/**
	 * 我的相册
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/albumlist", produces = "application/json;")
	public Result albumlist(HttpServletRequest request, Model model) {
		if (!HttpUtils.isget(request)) {
			// return Response.failed("非法的请求方式");
		}
		String userid = request.getParameter("userid");
		
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		return userService.albumlist(Integer.parseInt(userid));
	}

	/**
	 * 关于我们
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/about", produces = "application/json;")
	public Result about(HttpServletRequest request, Model model) {
		if (!HttpUtils.isget(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");

		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		return userService.about(apptoken);
	}

	/**
	 * 修改用户昵称
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/renickname", produces = "application/json;")
	public Result renickname(HttpServletRequest request, Model model) {
		if (!HttpUtils.isget(request)) {
			// return Response.failed("非法的请求方式");
		}
		String apptoken = request.getParameter("apptoken");
		String userid = request.getParameter("userid");
		String nickname = request.getParameter("nickname");

		if ("".equals(apptoken) || apptoken == null) {
			return Response.failed("公司标志不能为空");
		}
		if ("".equals(userid) || userid == null) {
			return Response.failed("userid不能为空");
		}
		if ("".equals(nickname) || nickname == null) {
			return Response.failed("昵称不能为空");
		}
		return userService.renickname(Integer.parseInt(userid), nickname);
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sendPhone")
	public Result sendPhone(HttpServletRequest request, Model model){
		//http://localhost:8080/qxar/user/sendPhone?phone=15207105266&apptoken=8888
		if (!HttpUtils.isget(request)) {
			// return Response.failed("非法的请求方式");
		}
		String phone=request.getParameter("phone");
		if("".equals(phone)||phone==null){
			return Response.failed("手机号不能为空");
		}
		
		if(ValidateUtil.isChinaPhoneLegal(phone)==false){
			return Response.failed("手机号不正确");
		}
		
		String sendNum=(String)request.getSession().getAttribute("sendNum");
		
		if(sendNum==null||"".equals(sendNum)){
			sendNum="0";
		}
		if(Integer.parseInt(sendNum)>10){
			return Response.failed("您发送的验证码次数太多");
		}else{
			request.getSession().setAttribute("sendNum", (Integer.parseInt(sendNum)+1)+"");;
		}
		try {
			Random random=new Random();
			int code=1000+random.nextInt(8999);
			String content="您的验证码："+code+"，3分钟内有效【企秀AR】";
			String appkey="810b1ecbf57724f2";
			String s=HttpRequestUtil.sendGet("http://api.jisuapi.com/sms/send", "mobile="+phone+"&content="+content+"&appkey="+appkey);
			JSONObject jsonObject=JSONObject.fromObject(s);
			
			if(jsonObject.getInt("status")==0){
				request.getSession().setAttribute("vercode", code+"");
				return Response.success("验证码发送成功",null);
				
			}else{
				return Response.failed(jsonObject.getString("msg"));
			}
		} catch (Exception e) {
			return Response.failed("验证码发送失败");
		}
	}
	
}
