<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<% if(null != request.getAttribute("error"))
	{
	out.println(request.getAttribute("error"));
	}
	%>
	<form action="loging" method="post">
	<table >
		<tr>
			<td>user name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>password</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr><td><input type = "submit" value = "login"></td>
	</table>
	</form>
</body>
</html>