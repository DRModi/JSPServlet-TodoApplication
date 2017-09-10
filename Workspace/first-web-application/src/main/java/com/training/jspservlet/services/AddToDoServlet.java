package com.training.jspservlet.services;

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

@WebServlet(urlPatterns = "/add-todo.do")
public class AddToDoServlet extends HttpServlet {

	// Initialize ToDo service
	ToDoService toDoService = new ToDoService();
	

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// Forwarding request to JSP and generating response
		request.getRequestDispatcher("/WEB-INF/views/AddTodo.jsp").forward(
				request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// Retrive ToDo from the todo.jsp
		String newToDoName = request.getParameter("toDoName");
		String newCategory = request.getParameter("toDoCategoryName");
		toDoService.addToDo(new ToDo(newToDoName,newCategory));
		response.sendRedirect("/list-todo.do");
		
		/*
		 * To Avoid Duplication in case of refresh of page/resend page
		request.setAttribute("toDos", toDoService.retriveToDos());
		request.getRequestDispatcher("/WEB-INF/views/Todo.jsp").forward(
				request, response);
		*/
	}

}