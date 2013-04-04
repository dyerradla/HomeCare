package com.homecare.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.bo.IUserBO;
import com.homecare.domain.User;

public class AuthorizationFilter implements Filter {

	@Autowired
	private IUserBO userBO;
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
		FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		String requestURI = httpServletRequest.getRequestURI();
		requestURI = requestURI.substring(requestURI.lastIndexOf("/")+1);
		if(null == user && !"validateUser.do".equalsIgnoreCase(requestURI)){
			httpServletRequest.getRequestDispatcher("login.do").forward(httpServletRequest, httpServletResponse);
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	}
}
