<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "candidatePage" method = "post">
To get registered for the college president click the button below
<br>                                                                                                                                                                                                                             
<input type = "submit" name = "s" value = "college"/>
</form>
<form action = "candidatePage" method = "post">                                                                                                                                                                                                                         
To get registered for the department-IT president click the button below
<br>
<input type = "submit" name = "s" value = "department-IT"/>
</form>
<form action = "candidatePage" method = "post">                                                                                                                                                                                                                    
To get registered for the IT-4-year president click the button below
<br>
<input type = "submit" name = "s" value = "IT-4-year"/>
</form>
<h2><% if(null != request.getAttribute("error"))
	{
	out.println(request.getAttribute("error"));
	}
	%>
	</h2>
<a href = "welcome.html">logut</a>
</body>
</html>