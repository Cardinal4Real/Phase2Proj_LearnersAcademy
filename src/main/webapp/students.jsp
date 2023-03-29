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
<%	Students student2edit=(Students)request.getAttribute("editStudent");%>
<%	Students student2delete=(Students)request.getAttribute("deleteStudent");%>
<%--<%	Classes class2edit=(Classes)request.getAttribute("editClass");%>
  <%	Classes class2delete=(Classes)request.getAttribute("deleteClass");%> --%>
<form method="POST">
	<% if (student2edit!=null) { %>
	<input type="hidden" name="editStudID" value=<%=student2edit.getId()%>>
	<label>Student Name</label>
	<input type="text" name="sname" value="<%=student2edit.getSname()%>" required="required"><br/>
<%-- 	<input type="hidden" name="editCID" value=<%=student2edit.getClasses().getId()%>>
	<label>Student's Class</label>
	<input type="text" name="cname" value="<%=student2edit.getClasses().getCname()%>" required="required"><br/>
 --%>
 		<label>Student's Class
		<select name="selectedClass">
		<% List<Classes> classList=(List<Classes>)request.getAttribute("listOfClasses"); 
		if(classList!=null && !classList.isEmpty()){%>
		<option value="">--Choose a class-- </option>
		 <%for (Classes cls:classList){ %>   
		 <option value="<%=cls==null?"":cls.getId()%>" <%= (cls.getId()==(student2edit.getClasses()==null?"":student2edit.getClasses().getId()))? "selected" : ""%> > <%=cls==null?"":cls.getCname()%> </option>
		 <%-- <option value="<%=cls.getId()%>"> <%=cls.getCname()%> </option> --%>
		 <% }} %>
		</select>
	</label><br/>
	<input type="submit" value="Save">
	<% } else if (student2delete!=null) { %>
		<input type="hidden" name="deleteStudID" value=<%=student2delete.getId()%>>
		<label>Student Name</label>
		<input type="text" name="sname" value="<%=student2delete.getSname()%>" required="required"><br/>
 		<label>Student's Class</label>
		<input type="text" name="cname" value="<%=student2delete.getClasses()==null?"":student2delete.getClasses().getCname()%>" required="required"><br/> 		
<%--		<label>Student's Class
				
		<select name="selectedClass">
		<% List<Classes> classList=(List<Classes>)request.getAttribute("listOfClasses"); 
		if(!(classList==null)){%>
		 <%for (Classes cls:classList){ %>   
		 <option value="<%=cls.getId()%>"> <%=cls.getCname()%> </option>
		 <% }} %>
		</select>--%>
	</label><br/>
		<input type="submit" value="Confirm Delete">
	<% } else {%>
		<label>Student Name</label>
		<input type="text" name="sname" value="" required="required"><br/>
		<label>Student's Class
		<select name="selectedClass">
		<% List<Classes> classList=(List<Classes>)request.getAttribute("listOfClasses"); 
		if(classList!=null && !classList.isEmpty()){%>
		 <option value="">--Choose a class-- </option>
		 <%for (Classes cls:classList){ %>   
		 <option value="<%=cls==null?"":cls.getId()%>"> <%=cls==null?"":cls.getCname()%> </option>
		 <% }} %>
		</select>
	</label><br/>
		<input type="submit" value="Save">
<%}%>
</form>
<br/>
<br/>

<h4><u>Student List</u></h4>
<%	List<Students> listStudents=(List<Students>)request.getAttribute("listOfStudents");
	if(listStudents!=null && !(listStudents.isEmpty())){%>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Student's Class</th>
	    <th>Action - Edit</th>
		<th>Action - Delete</th>
	  </tr>
	<%for (Students std:listStudents){ %>
		  <tr>
		   <td><%=std==null?"":std.getId()%></td>
		   <td><%=std==null?"":std.getSname() %></td>
		   <td><%=std==null?"":(std.getClasses()==null?"":std.getClasses().getCname()) %></td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="editStudID" value=<%=std==null?"":std.getId() %>>
					<input type="hidden" name="editCID" value=<%=std==null?"":(std.getClasses()==null?"":std.getClasses().getId()) %>>
					<input type="hidden" name="action" value="edit">	
					<input type="submit" value="Edit">
				</form>
		   </td>
		   <td>
			   	<form method="POST">
					<input type="hidden" name="deleteStudID" value=<%=std==null?"":std.getId() %>>
					<input type="hidden" name="action" value="delete">
					<input type="submit" value="Delete">
				</form>		   
		   </td>
		  </tr>		
	<% }%>
		</table>	
	<%}else{%>
		<div>
		<span>No students registered</span>
		</div>
		<%}%>
		
</body>
</html>