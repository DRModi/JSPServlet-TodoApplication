<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Todos</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

	<nav class="navbar navbar-default">

		<a href="/" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/list-todo.do">Todos</a></li>
			<li><a href="http://www.in28minutes.com">In28Minutes</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">LogOut</a></li>
		</ul>

	</nav>

	<div class="container">
			<p> <font color="Blue" size="6">  You are welcome <font color="Green" size="7"> ${name} </font> !! </font></p>
			
			<p> <font size="5"> Your ToDo's are: </font></p>
			<ol>
				<c:forEach items="${toDos}" var="todo">
					<li>${todo.name} &nbsp; &nbsp;${todo.category} &nbsp; &nbsp; <a href="/delete-todo.do?deleteToDoName=${todo.name}&deleteToDoCatogary=${todo.category}">Delete</a></li>
				</c:forEach>
			</ol>
			
			<form action="/add-todo.do" method="post">
			 	<a href="/add-todo.do">New ToDo</a>
			</form>

	</div>

	<footer class="footer">
		<p>footer content</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>