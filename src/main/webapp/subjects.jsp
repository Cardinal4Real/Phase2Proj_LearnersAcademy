<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Subjects" %>
<%@ page import="com.entities.Teachers" %>
<%@ page import="com.entities.Classes" %>
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
<%-- <%	Teachers teacher2edit=(Teachers)request.getAttribute("editTeacher");%>
<%	Classes class2edit=(Classes)request.getAttribute("editClass");%>
 --%>

<form method="POST">
	<% if (subject2edit!=null) { %>
	<input type="hidden" name="editSubID" value=<%=subject2edit.getId()%>>
	<label>Subject Name</label>
	<input type="text" name="subname" value="<%=subject2edit.getSubname()%>" required="required"><br/>
	
	<input type="hidden" name="editTID" value=<%=subject2edit.getTeachers().getId()%>>
<%-- 	<label>Subject Teacher</label>
	<input type="text" name="tname" value="<%=subject2edit.getTeachers().getTname()%>" required="required"><br/>
	
	<input type="hidden" name="editCID" value=<%=class2edit.getId()%>>
	<label>Subject's Class</label>
	<input type="text" name="cname" value="<%=class2edit.getCname()%>"><br/> --%>
		<label>Subject Teacher
		<select name="selectedTeacher">
		<%	List<Teachers> listTeachers=(List<Teachers>)request.getAttribute("listOfTeachers");	 	
		if(!(listTeachers.isEmpty())){%>
		 <%for (Teachers tch:listTeachers){ %>   
		 <option value="<%=tch.getId()%>" <% String autoselect= ((tch.getId())==(subject2edit.getTeachers().getId())? "selected" : "");%> <%=autoselect %>> <%=tch.getTname()%> </option>
		 <% }} %>
		</select>
	</label><br/>
	<label>Subject's Class
		<select name="selectedClass">
		<%	List<Classes> listClasses=(List<Classes>)request.getAttribute("listOfClasses");	 	
		if(!(listClasses.isEmpty())){%>
		 <% for(Classes c:listClasses){%>
		 <option value="<%=c.getId()%>" <% String autoselect= ((c.getId())==(subject2edit.getClasses().getId())? "selected" : "");%> <%=autoselect %>> <%=c.getCname()%> </option>  
		 <option value="<%=c.getId()%>"> <%=c.getCname() %> </option>
		 <% }} %>
		</select>
	</label><br/>
	<input type="submit" value="Save">
	<% } else if (subject2delete!=null) { %>
		<input type="hidden" name="deleteSubID" value=<%=subject2delete.getId()%>>
		<label>Subject Name</label>
		<input type="text" name="subname" value="<%=subject2delete.getSubname()%>" required="required"><br/>
		
		<%-- <input type="hidden" name="deleteTID" value=<%=teacher2delete.getId()%>> --%>
		<label>Subject Teacher</label>
		<input type="text" name="tname" value="<%=subject2delete.getTeachers().getTname()%>" required="required"><br/>
				
		<label>Subject's Class</label>
		<input type="text" name="cname" value="<%=subject2delete.getClasses().getCname()%>"><br/>
		<input type="submit" value="Confirm Delete">

	<% } else {%>
		<label>Subject Name</label>
	<input type="text" name="subname" required="required"><br/>
	<label>Subject Teacher
		<select name="selectedTeacher">
		<%	List<Teachers> listTeachers=(List<Teachers>)request.getAttribute("listOfTeachers");	 	
		if(!(listTeachers.isEmpty())){%>
		<option value="">--Choose a teacher-- </option>
		 <%for (Teachers tch:listTeachers){ %>   
		 <option value="<%=tch.getId()%>"> <%=tch.getTname()%> </option>
		 <% }} %>
		</select>
	</label><br/>
	<label>Subject's Class
		<select name="selectedClass">
		<%	List<Classes> listClasses=(List<Classes>)request.getAttribute("listOfClasses");	 	
		if(!(listClasses.isEmpty())){%>
		<option value="">--Choose a class-- </option>
		 <% for(Classes c:listClasses){%>  
		 <option value="<%=c.getId()%>"> <%=c.getCname() %> </option>
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
		    <th>Subject's Class</th>
		    <th>Action - Edit</th>
	    	<th>Action - Delete</th>
		  </tr>
	<% for(Subjects sub:listSubjects){%>
		  <tr>
		   <td><%=sub.getId()%></td>
		   <td><%=sub.getSubname() %></td>
		   <td><%=sub.getTeachers().getTname() %></td>
		   <td><%=sub.getClasses().getCname() %></td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="editSubID" value=<%=sub.getId() %>>
					<input type="hidden" name="editTID" value=<%=sub.getTeachers().getId()%>>
					<input type="hidden" name="editCID" value=<%=sub.getClasses().getId()%>>
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