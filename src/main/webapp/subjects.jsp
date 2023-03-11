<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Subjects" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
<h3>Subjects Registration</h3>
<form method="POST">
	<label>Subject Name</label>
	<input type="text" name="subname"><br/>
	<input type="submit" value="Save">
</form>
<br/>
<br/>

<h4><u>Subject List</u></h4>
<%	List<Subjects> listSubjects=(List<Subjects>)request.getAttribute("listOfSubjects");
	if(!(listSubjects==null)){
	for(Subjects sub:listSubjects){%>

		<div>
		<span>ID : <%=sub.getId()%> Name :<%=sub.getSubname() %></span>
		</div>
		
	<% }
	}else{%>
		<div>
		<span>No subjects registered</span>
		</div>
		<%}%>
</body>
</html>