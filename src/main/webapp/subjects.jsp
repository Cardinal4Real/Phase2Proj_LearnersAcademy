<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Subjects" %>
<%@ page import="com.entities.Teachers" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
</head>
<body>
<h3>Subjects Registration</h3>
<%	Subjects subject2edit=(Subjects)request.getAttribute("editSubject");%>
<%	Subjects subject2delete=(Subjects)request.getAttribute("deleteSubject");%>
<%	Teachers teacher2edit=(Teachers)request.getAttribute("editTeacher");%>
<%	Teachers teacher2delete=(Teachers)request.getAttribute("deleteTeacher");%>

<form method="POST">
	<% if (subject2edit!=null) { %>
	<input type="hidden" name="editSubID" value=<%=subject2edit.getId()%>>
	<label>Subject Name</label>
	<input type="text" name="subname" value="<%=subject2edit.getSubname()%>" required="required"><br/>
	
	<input type="hidden" name="editTID" value=<%=subject2edit.getTeachers().getId()%>>
	<label>Subject Teacher</label>
	<input type="text" name="tname" value="<%=subject2edit.getTeachers().getTname()%>" required="required"><br/>

	<input type="submit" value="Save">
	<% } else if (subject2delete!=null) { %>
		<input type="hidden" name="deleteSubID" value=<%=subject2delete.getId()%>>
		<label>Subject Name</label>
		<input type="text" name="subname" value="<%=subject2delete.getSubname()%>" required="required"><br/>
		
		<%-- <input type="hidden" name="deleteTID" value=<%=teacher2delete.getId()%>> --%>
		<label>Subject Teacher</label>
		<input type="text" name="tname" value="<%=subject2delete.getTeachers().getTname()%>" required="required"><br/>
	
		<input type="submit" value="Confirm Delete">
	<% } else {%>
		<label>Subject Name</label>
	<input type="text" name="subname" required="required"><br/>
		<label>Subject Teacher
		<select name="selectedTeacher">
		<%	List<Teachers> listTeachers=(List<Teachers>)request.getAttribute("listOfTeachers");	 	
		if(!(listTeachers.isEmpty())){%>
		 <%for (Teachers tch:listTeachers){ %>   
		 <option value="<%=tch.getId()%>"> <%=tch.getTname()%> </option>
		 <% }} %>
		</select>
	</label><br/>
	<input type="submit" value="Save">
<%}%>
</form>
<br/>
<br/>

<h4><u>Subject List</u></h4>

<%	List<Subjects> listSubjects=(List<Subjects>)request.getAttribute("listOfSubjects");
	if(!(listSubjects.isEmpty())){%>
		<table border="1px">
		  <tr>
		    <th>ID</th>
		    <th>Name</th>
		    <th>Subject Teacher</th>
		    <th>Action - Edit</th>
	    	<th>Action - Delete</th>
		  </tr>
	<% for(Subjects sub:listSubjects){
	Teachers teacher=sub.getTeachers(); %> <!-- very important to assign here for sub.getTeachers().getId() to work -->
		  <tr>
		   <td><%=sub.getId()%></td>
		   <td><%=sub.getSubname() %></td>
		   <td><%=sub.getTeachers() %></td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="editSubID" value=<%=sub.getId() %>>
					<input type="hidden" name="editTID" value=<%=sub.getTeachers().getId()%>>
					<!--  input type="hidden" name="editTID2" value=<%=teacher.getId()%>> -->
					<input type="hidden" name="action" value="edit">	
					<input type="submit" value="Edit">
				</form>
		   </td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="deleteSubID" value=<%=sub.getId() %>>
					<input type="hidden" name="action" value="delete">
					<input type="submit" value="Delete">
				</form>		   
		   </td>
		  </tr>		
	<% }%>
		</table>	
	<%}else{%>
		<div>
		<span>No subjects registered</span>
		</div>
		<%}%>
</body>
</html>