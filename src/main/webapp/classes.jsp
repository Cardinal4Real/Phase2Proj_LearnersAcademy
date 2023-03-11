<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Classes" %>
<%@ page import="com.entities.Subjects" %>
<%@ page import="com.entities.Teachers" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
</head>
<body>
<h3>Class Registration</h3>
<form method="POST">
	<label>Class Name</label>
	<input type="text" name="cname"><br/>
	<input type="submit" value="Save">
</form>
<br/>
<br/>

<h4><u>Class List</u></h4>
<%	List<Classes> listClasses=(List<Classes>)request.getAttribute("listOfClasses");
	for(Classes c:listClasses){%>

		<div>
		<span>ID : <%=c.getId()%> Name :<%=c.getCname() %></span>
		</div>
		
	<% } %>
</body>
</html>