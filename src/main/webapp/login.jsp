<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Administrator Login</h2>
<form action="AuthLogin" method="POST">
	<label>Username</label>
	<input type="text" name="username"><br/>
	<label>Password</label>
	<input type="password" name="password"><br/>
	<input type="submit" value="Login">
</form>
</body>
</html>