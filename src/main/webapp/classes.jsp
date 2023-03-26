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
<%	Classes class2edit=(Classes)request.getAttribute("editClass");%>
<%	Classes class2delete=(Classes)request.getAttribute("deleteClass");%>
<form method="POST">
	<% if (class2edit!=null) { %>
		<input type="hidden" name="editID" value=<%=class2edit.getId()%>>
	<label>Class Name</label>
	<input type="text" name="cname" value="<%=class2edit.getCname()%>"><br/>
	<input type="submit" value="Save">
		<% } else if (class2delete!=null) { %>
		<input type="hidden" name="deleteID" value=<%=class2delete.getId()%>>
		<label>Class Name</label>
		<input type="text" name="cname" value="<%=class2delete.getCname()%>"><br/>
		<input type="submit" value="Confirm Delete">
		<% } else {%>
		<label>Class Name</label>
		<input type="text" name="cname" value=""><br/>
		<input type="submit" value="Save">
	<% } %>

</form>
<br/>
<br/>

<h4><u>Class List</u></h4>
<%	List<Classes> listClasses=(List<Classes>)request.getAttribute("listOfClasses");
	if(!(listClasses.isEmpty())){%>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Action - Edit</th>
	    <th>Action - Delete</th>
	  </tr>	
	<% for(Classes c:listClasses){%>
		    <tr>
		   <td><%=c.getId()%></td>
		   <td><%=c.getCname() %></td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="editID" value=<%=c.getId() %>>
					<input type="hidden" name="action" value="edit">
					<input type="submit" value="Edit">
				</form>
		   </td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="deleteID" value=<%=c.getId() %>>
					<input type="hidden" name="action" value="delete">
					<input type="submit" value="Delete">
				</form>		   
		   </td>
	   </tr>
		
	<%}%>
		</table>	
	<%}else{%>
		<div>
		<span>No classes registered</span>
		</div>
		<%}%>
		
</body>
</html>