<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Students" %>
<%@ page import="com.entities.Classes" %>
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
		<input type="text" name="sname" value=""><br/>
		<label>Student's Class
		<select name="selectedClass">
		<% List<Classes> classList=(List<Classes>)request.getAttribute("listOfClasses"); 
		if(!(classList==null)){%>
		 <%for (Classes cls:classList){ %>   
		 <option value="<%=cls.getId()%>"> <%=cls.getCname()%> </option>
		 <% }} %>
		</select>
	</label><br/>
		<input type="submit" value="Save Student">
</form>
<br/>
<br/>

<h4><u>Student List</u></h4>
<%	List<Students> listStudents=(List<Students>)request.getAttribute("listOfStudents");
	for(Students std:listStudents){%>

		<div>
		<span>ID : <%=std.getId()%> Name :<%=std.getSname() %> Class :<%=std.getClasses() %></span>
		</div>
		
	<%}%>
</body>
</html>