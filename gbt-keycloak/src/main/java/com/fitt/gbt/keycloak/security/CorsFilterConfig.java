//package com.fitt.gbt.keycloak.security;
//
//import org.keycloak.authorization.client.util.Http;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * <p>@description: SpringMVC跨域filter</p>
// * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
// * <p>@author: Chuck[ZhengCongChun]</p>
// * <p>@created: 2017-11-16</p>
// * <p>@version: 1.0</p>
// */
//@Configuration
//public class CorsFilterConfig implements Filter {
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//
//	}
//
//	@Override
//	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		HttpServletResponse response = (HttpServletResponse ) servletResponse;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//		response.setHeader("Access-Control-Max-Age", "1728000");
//		response.setHeader("Access-Control-Allow-Headers",
//				"Authorization, Content-Type, Accept, x-requested-with, Cache-Control");
//		filterChain.doFilter(servletRequest, response);
//	}
//
//	@Override
//	public void destroy() {
//
//	}
//}
