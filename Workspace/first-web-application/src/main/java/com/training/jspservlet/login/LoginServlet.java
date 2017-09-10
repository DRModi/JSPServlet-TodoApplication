package com.training.jspservlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.jspservlet.login.LoginService;
import com.training.jspservlet.services.ToDoService;

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

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	//Initialize User Validation Service to do authentication.
	LoginService userValidationService = new LoginService();
	
	//Initialize ToDo service
	//ToDoService toDoService = new ToDoService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// Forwarding request to JSP and generating response
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(
				request, response);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//Retrive UserName and Password
		System.out.println("Printing the UserName/Password  :  " + request.getParameter("UserName") +"/"+ request.getParameter("Password"));
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		//Validate User
		if(userValidationService.isUserValid(userName, password))
		{
			//setting user name in session
			request.getSession().setAttribute("name", userName);
			
			//now we are redirecting to the todo servlet.
			response.sendRedirect("/list-todo.do");
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid Credetial!! Please try again :) !!");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(
					request, response);
		}
		

	/*
	 * Commented, this being used when testing with Welcome page
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//Retrive UserName and Password
		System.out.println("Printing the UserName/Password  :  " + request.getParameter("UserName") +"/"+ request.getParameter("password"));
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		//Validate User
		if(userValidationService.isUserValid(userName, password))
		{
			request.setAttribute("name", userName);
			request.setAttribute("password", password);
			
			request.setAttribute("toDos", toDoService.retriveToDos());
			request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(
					request, response);
		}
		else
		{
			request.setAttribute("errorMessage", "Invalid Credetial!! Please try again :) !!");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(
					request, response);
		}
		// Forwarding request to JSP and generating response
	*/	

	}

}