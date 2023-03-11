<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Teachers" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
<h3>Teachers Registration</h3>
<form method="POST">
	<label>Subject Name</label>
	<input type="text" name="tname"><br/>
	<input type="submit" value="Save">
</form>
<br/>
<br/>

<h4><u>Teacher List</u></h4>
<%	List<Teachers> listTeachers=(List<Teachers>)request.getAttribute("listOfTeachers");
	for(Teachers tch:listTeachers){%>

		<div>
		<span>ID : <%=tch.getId()%> Name :<%=tch.getTname() %></span>
		</div>
		
	<% } %>
</body>
</html>