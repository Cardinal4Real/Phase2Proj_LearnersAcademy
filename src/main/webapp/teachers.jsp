<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Teachers" %>
<%@ page import="com.entities.Subjects" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
<h3>Teachers Registration</h3>
<%	Teachers teacher2edit=(Teachers)request.getAttribute("editTeacher");%>
<%	Teachers teacher2delete=(Teachers)request.getAttribute("deleteTeacher");%>

<form method="POST">
	<% if (teacher2edit!=null) { %>
		<input type="hidden" name="editID" value=<%=teacher2edit.getId()%>>
		<label>Teacher Name</label>
		<input type="text" name="tname" value="<%=teacher2edit.getTname()%>" required="required"><br/>
		<input type="submit" value="Save">
	<% } else if (teacher2delete!=null) { %>
		<input type="hidden" name="deleteID" value=<%=teacher2delete.getId()%>>
		<label>Teacher Name</label>
		<input type="text" name="tname" value="<%=teacher2delete.getTname()%>" required="required"><br/>
		<input type="submit" value="Confirm Delete">
		<% } else {%>
		<label>Teacher Name</label>
		<input type="text" name="tname" value="" required="required"><br/>
		<input type="submit" value="Save">
	<% } %>
</form>
<br/>
<br/>

<h4><u>Teacher List</u></h4>
<%	List<Teachers> listTeachers=(List<Teachers>)request.getAttribute("listOfTeachers");
	if(listTeachers!=null && !(listTeachers.isEmpty())){%>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Action - Edit</th>
	    <th>Action - Delete</th>
	  </tr>	
<%for(Teachers tch:listTeachers){%> 
	    <tr>
		   <td><%=tch==null?"":tch.getId()%></td>
		   <td><%=tch==null?"":tch.getTname() %></td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="editID" value=<%=tch==null?"":tch.getId() %>>
					<input type="hidden" name="action" value="edit">
					<input type="submit" value="Edit">
				</form>
		   </td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="deleteID" value=<%=tch==null?"":tch.getId() %>>
					<input type="hidden" name="action" value="delete">
					<input type="submit" value="Delete">
				</form>		   
		   </td>
	   </tr>
		
	<%}%>
		</table>	
	<%}else{%>
		<div>
		<span>No teachers registered</span>
		</div>
		<%}%>
</body>
</html>