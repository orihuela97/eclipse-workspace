<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Prueba/ServletController?action=register" method="POST">
		<input type="text" name="user"/>
		<input type="password" name="pass"/>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>