package com.training.jspservlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login1.do")
public class TestLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// Getting request parameter and passing and printing. 
		String name = request.getParameter("name");
		System.out.println("Parameter Got : " + name);
		
		//When browser sends the value for any query parameter, we have to map it as attribute on server side and
		//we tie that attribute to request and forward it to JSP.
		
		request.setAttribute("name", name);
		
		
		// Forwarding request to JSP and generating response
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(
				request, response);

	}

}