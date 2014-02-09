package com.myspace.intercepters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class MyIntercepter implements HandlerInterceptor {

	private NamedThreadLocal<Long> timeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();
		timeThreadLocal.set(beginTime);
		if(request.getSession().getAttribute("user")!=null)
			return true;
		response.sendRedirect(request.getContextPath()+"/entry/tologin");
		return false;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long timeTotal = System.currentTimeMillis()-timeThreadLocal.get();
		System.out.println("请求消耗时间: "+timeTotal+" ms");
	}

}
