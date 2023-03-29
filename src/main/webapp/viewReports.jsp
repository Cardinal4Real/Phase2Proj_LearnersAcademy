<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.entities.Classes" %>
<%@ page import="com.entities.Subjects" %>
<%@ page import="com.entities.Students" %>
<%@ page import="com.entities.Teachers" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
</head>
<body>

<%List<Subjects> listSubjectReport=(List<Subjects>)request.getAttribute("generateSubjectsTaughtInClass"); %>
<%List<Students> listStudentReport=(List<Students>)request.getAttribute("generateStudentsInClass"); %>

<h3><u>Subjects Report</u></h3>
<% 
if(listSubjectReport!=null && !listSubjectReport.isEmpty()){%>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>Name</th>
	  </tr>	
<% for(Subjects lcs:listSubjectReport){%>
	    <tr>
	   <td><%=lcs==null?"":lcs.getId()%></td>
	   <td><%=lcs==null?"":lcs.getSubname() %></td>
	   </tr>
	<%}%>
		</table>
		<br>	
		<div>
			<span>Total Number of subjects taught in class: <b><%=listSubjectReport.size() %></b></span>
		</div>
	<%}else{%>
		<div>
		<span>No subjects being taught in class</span>
		</div>
		<%}%>

<h3><u>Students Report</u></h3>
<% 
if(listStudentReport!=null && !listStudentReport.isEmpty()){%>
	<table border="1px">
	  <tr>
	    <th>ID</th>
	    <th>Name</th>
	  </tr>	
<% for(Students std:listStudentReport){%>
	    <tr>
	   <td><%=std==null?"":std.getId()%></td>
	   <td><%=std==null?"":std.getSname() %></td>
	   </tr>
	<%}%>
		</table>
		<br>	
		<div>
			<span>Total Number of students in class: <b><%=listStudentReport.size() %></b></span>
		</div>
	<%}else{%>
		<div>
		<span>No student belongs to class</span>
		</div>
		<%}%>		
</body>
</html>