<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	
<title>Jay Mataji</title>


</head>
<body>
<p> <font color="Blue" size="6">  You are welcome <font color="Green" size="7"> ${name} </font> !! </font></p>

<p> <font size="5"> Your ToDo's are: </font></p>
<ol>
	<c:forEach items="${toDos}" var="todo">
		<li>${todo.name} &nbsp; &nbsp; <a href="/delete-todo.do?deleteToDoName=${todo.name}">Delete</a></li>
	</c:forEach>
</ol>

<form action="/todo.do" method="post">
 	<input type="text" name="toDoName"/> <input type="submit" value="Add ToDo"/>
</form>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>