<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "adminpage" method = "post">
To start the registering of the students for the election press the button below
<br>                                                                                                                                                                                                                             
<input type = "submit" name = "s" value = "registration"/>
</form>
<form action = "adminpage" method = "post">
To start the voting of the students for the election press the button below                                                                                                                                                                                                                             
<br>
<input type = "submit" name = "s" value = "voting"/>
</form>
<form action = "adminpage" method = "post">
To close election press the button below                                                                                                                                                                                                                             
<br>
<input type = "submit" name = "s" value = "close"/>
</form>
<h2><% if(null != request.getAttribute("error"))
	{
	out.println(request.getAttribute("error"));
	}
	%>
	</h2>
<a href = "welcome.html">logout</a>
</body>
</html>