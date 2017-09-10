package com.training.jspservlet.services;

import java.util.ArrayList;
import java.util.List;

public class ToDoService {
	
	private static List<ToDo> todos = new ArrayList<ToDo>();
	
	static{
		todos.add(new ToDo("Learn Webservices, SOAP and REST Service","Study"));
		todos.add(new ToDo("Learn Java WEB Application","Study"));
		todos.add(new ToDo("Learn Spring MVC Framework","Study"));
		todos.add(new ToDo("Learn Spring and ORM Hibernet","Study"));
		todos.add(new ToDo("Learn Spring and Boot","Study"));
		todos.add(new ToDo("Learn AWS","Study"));
		todos.add(new ToDo("Learn Java Algoritham and DataStructure","Study"));
		todos.add(new ToDo("Learn Java Multithreading","Study"));
		todos.add(new ToDo("Learn Mongos or Cassandra","Study"));
		todos.add(new ToDo("Learn Radis Caching","Study"));
		todos.add(new ToDo("Learn API Gateway and MicroServices","Study"));
	}

	
	public List<ToDo> retriveToDos()
	{
		return todos;
	}
	
	public void addToDo(ToDo toDO)
	{
		todos.add(toDO);
	}
	
	public void deleteToDo(ToDo toDO)
	{
		todos.remove(toDO);
	}
}
