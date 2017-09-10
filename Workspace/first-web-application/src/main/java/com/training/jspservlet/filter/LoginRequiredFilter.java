package com.training.jspservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		if(request.getSession().getAttribute("name") != null){

			System.out.println(request.getRequestURI());
			chain.doFilter(servletRequest, servletResponse);
		}
		else{
			System.out.println("Redirect to Login Page From : " + request.getRequestURI());
			request.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);
			
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
