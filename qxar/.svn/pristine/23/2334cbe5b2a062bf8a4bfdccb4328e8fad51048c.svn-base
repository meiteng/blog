package com.qx.ar.controller.other;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 发送短信接口
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/sms")
public class SmsController {

	private final String userName = "";
	private final String pwd = "";
	private final String url = "";

	@ResponseBody
	@RequestMapping("/send")
	public void send(String content, String tel, HttpServletRequest request, HttpServletResponse response) {
		HttpClient client = new HttpClient();
		PostMethod post = new UTF8PostMethod(this.url);
		post.addRequestHeader("Content", "text/html,charset=gb2312");
		NameValuePair userNamePair = new NameValuePair("zh", this.userName);
		NameValuePair pwdPair = new NameValuePair("mm", this.pwd);
		NameValuePair telPair = new NameValuePair("hm", tel);
		NameValuePair contentPair = new NameValuePair("nr", content);
		NameValuePair dxlbidPair = new NameValuePair("dxlbid", "49");
		post.setRequestBody(new NameValuePair[] { userNamePair, pwdPair, telPair, contentPair, dxlbidPair });
		try {
			// int status =
			client.executeMethod(post);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String message = "500";
		try {
			message = post.getResponseBodyAsString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 根据html指定的jsonp回调函数的参数名，获取回调函数的名称
		// callbackName的值其实就是：success_jsonpCallback
		String callbackName = "success";
		// 简单模拟一个json字符串，实际可使用google的gson进行转换，次数通过字符串拼接
		// {"name":"张三","age":28}
		// \是对"号进行转义
		String jsonStr = "{\"state\":\"" + message + "\"}";
		// 最终返回的数据为：success_jsonpCallback({"name":"张三","age":28})
		String renderStr = callbackName + "(" + jsonStr + ")";
		response.setContentType("text/plain;charset=UTF-8");
		try {
			response.getWriter().write(renderStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class UTF8PostMethod extends PostMethod {
		public UTF8PostMethod(String url) {
			super(url);
		}

		@Override
		public String getRequestCharSet() {
			return "gb2312";
		}
	}

}
