<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Students" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
<h3>Student Registration</h3>
<form method="POST">
	<label>Student Name</label>
	<input type="text" name="sname"><br/>
	<input type="submit" value="Save">
</form>
<br/>
<br/>

<h4><u>Student List</u></h4>
<%	List<Students> listStudents=(List<Students>)request.getAttribute("listOfStudents");
	for(Students std:listStudents){%>

		<div>
		<span>ID : <%=std.getId()%> Name :<%=std.getSname() %></span>
		</div>
		
	<% } %>
</body>
</html>