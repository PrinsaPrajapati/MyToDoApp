<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to My TDo APP</title>
</head>
<body>
<div>WELCOME TO MY TODO APP</div>
<div> Your Name: ${name} </div>
<hr> --%>

<%@  include file="comman/header.jspf"%>
<%@  include file="comman/navigation.jspf"%>
<div class="container">
	<h1>Welcome ${name}</h1>
	<a href="list-todos">Manage</a> Your ToDos
</div>
<%@ include file="comman/footer.jspf"%>