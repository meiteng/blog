package com.qx.ar.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qx.ar.modle.Admin;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
	public static final String LAST_PAGE = "lastPage";

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	//进入handle方法前进行拦截     一般是进行用户校验，权限拦截      此方法是按照拦截器定义的顺序执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if ("/admin/admin/login".equals(url)) {
			return true;
		} else {
			return true;
			//TODO 这个地方最好再优化一下
//			Admin admin=(Admin)request.getSession().getAttribute("admin");
//			if(admin==null){
////				request.getRequestDispatcher("/admin/admin/login").forward(
////                        request, response);
//				response.sendRedirect("/qxar/admin/admin/login");
//				return false;
//			}else{
//				return true;
//			}
		}

	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
	 */
	//进入handle方法之后，返回modelAndView视图前进行拦截     使用场景： 向 modelAndView视图添加通用数据，统一view    此方法没有返回值
	//此方法是按照定义的逆序执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	//执行完handle方法，返回modelAndView视图之后，执行此方法
	//执行场景：记录系统日志，统一异常处理，action方法执行监控（比如计算action方法执行时间，在prehandle方法添加开始时间，在此方法添加结束时间）
	//此方法是按照定义的逆序执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
