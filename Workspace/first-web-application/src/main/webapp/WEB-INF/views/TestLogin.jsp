<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jay Mataji</title>
</head>
<body>
 <em>My TestLogin JSP Page !!</em>
 <h1>First Level Heading Typed!</h1>
 <h2>Second Level Heading Typed!!</h2>
 <h3>Third Level Heading Typed!!!   :   : ${name}</h3>
 

<% System.out.println("Printing from JSP Page Request Query Param : "+request.getParameter("name")); 
	Date currentDate = new Date();
%>
<div>Current Date : <%=currentDate%></div>
 
 
Received the Name in Query Parameter (from Servlet) is : ${name}
</body>
</html>