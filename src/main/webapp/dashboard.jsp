<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h2>Learners' Academy - Welcome</h2>
<a href="dashboard?navigate=classes">Classes</a>
<a href="dashboard?navigate=subjects">Subjects</a>
<a href="dashboard?navigate=teachers">Teachers</a>
<a href="dashboard?navigate=students">Students</a>

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