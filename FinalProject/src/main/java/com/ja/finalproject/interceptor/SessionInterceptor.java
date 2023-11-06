package com.ja.finalproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

public class SessionInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws ModelAndViewDefiningException {
		
		if(request.getSession().getAttribute("sessionUserInfo") == null) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("user/loginRequired");
			throw new ModelAndViewDefiningException(mav);
		}
		
		System.out.println("인터셉터 실행됨!!!");
		
		return true;
	}
}
