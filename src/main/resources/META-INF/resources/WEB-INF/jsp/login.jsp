<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>
		Welcome to Login Page!
		<%-- ${name} --%>
	</h1>
	<pre>${errormsg}</pre>
	<div class="container">
		<h1>Login</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			Name: <input type="text" name="name"> 
			Password: <input type="password" name="password"> <input type="submit">
		</form>
	</div>
</body>
</html>