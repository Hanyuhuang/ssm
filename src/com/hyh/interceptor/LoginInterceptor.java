package com.hyh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hyh.entity.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
		// 如果用户需要登录 放行
		String url = request.getRequestURI();
		if(url.indexOf("login.action")>0) {
			return true;
		}
		// 获取Session中的用户信息
		User user = (User) request.getSession().getAttribute("user");
		// 用户已经登录 放行
		if(user!=null) {
			return true;
	    // 用户未登录 跳转到登录页面
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		return false;
	}

}
