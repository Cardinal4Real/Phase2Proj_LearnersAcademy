<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style>
  #para1{
	  background-color: #f44336;
	  color: white;
	  padding: 4px 5px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
   }
</style>
</head>
<body>
<% 	String nav=(String)Optional.ofNullable(request.getAttribute("nav_final")).orElse(""); 
	String currentMenu="";	
%>

<h2>Learners' Academy - Welcome</h2>
<a href="dashboard?navigate=classes" <%currentMenu=nav.equals("classes")?"para1":""; %> id=<%=currentMenu %>>Classes</a>
<a href="dashboard?navigate=teachers" <%currentMenu=nav.equals("teachers")?"para1":""; %> id=<%=currentMenu %>>Teachers</a>
<a href="dashboard?navigate=subjects" <%currentMenu=nav.equals("subjects")?"para1":""; %> id=<%=currentMenu %>>Subjects</a>
<a href="dashboard?navigate=students" <%currentMenu=nav.equals("students")?"para1":""; %> id=<%=currentMenu %>>Students</a>

<% if(request.getParameter("navigate")==null){%>
<%}else{%>
<% try { %>
	<br/><jsp:include page="${param.navigate}.jsp" />
            <% } catch (Exception e) { e.printStackTrace();%>
            <h3>Error Loading page <%=e.getLocalizedMessage()%></h3>	
<%}} %> 
</body>
</html>