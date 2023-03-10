<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
</head>
<body>
<h3>Class Registration</h3>

<form action="ClassesController" method="POST">
	<label>Class Name</label>
	<input type="text" name="cname"><br/>
	<input type="submit" value="Save">
</form>

</body>
</html>