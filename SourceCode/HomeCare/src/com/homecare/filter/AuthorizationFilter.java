package com.homecare.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthorizationFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
		FilterChain filterChain) throws IOException, ServletException {
		System.out.println("Inside Filter**********");
		// TODO : Logic for Authentication
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
	}
}
