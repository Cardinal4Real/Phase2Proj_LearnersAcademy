<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<% 	String nav=(String)request.getAttribute("nav"); 
	String currentMenu="";	
%>

<h2>Learners' Academy - Welcome</h2>
<a href="dashboard?navigate=classes" <% if (nav!=null){currentMenu=nav.equals("classes")?"para1":"";} %> id=<%=currentMenu %>>Classes</a>
<a href="dashboard?navigate=teachers" <% if (nav!=null){currentMenu=nav.equals("teachers")?"para1":"";} %> id=<%=currentMenu %>>Teachers</a>
<a href="dashboard?navigate=subjects" <% if (nav!=null){currentMenu=nav.equals("subjects")?"para1":"";} %> id=<%=currentMenu %>>Subjects</a>
<a href="dashboard?navigate=students" <% if (nav!=null){currentMenu=nav.equals("students")?"para1":"";} %> id=<%=currentMenu %>>Students</a>

<% if(request.getParameter("navigate")==null){%>
<%}else{%>
<% try { %>
	<% 	//String recParam=request.getParameter("navigate");
		//String requestedPage=recParam + ".jsp";
	%>
	<br/><jsp:include page="${param.navigate}.jsp" />
            <% } catch (Exception e) { e.printStackTrace();%>
            <h3>Error Loading page <%=e.getLocalizedMessage()%></h3>	
<%}} %> 
</body>
</html>