<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.services.ClassesService" %> 
<%@ page import="com.entities.Classes" %>
<%@ page import="java.util.List" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	List<Classes> listClasses=(List<Classes>)request.getAttribute("listOfClasses");
	for(Classes c:listClasses){%>

		<div>
		<span>ID : <%=c.getId()%> Name :<%=c.getCname() %></span>
		</div>
		
	<% } %>
</body>
</html>