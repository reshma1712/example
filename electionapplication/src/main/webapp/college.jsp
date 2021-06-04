<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<body>

<h1>candidates participating in for college president</h1>
<table border="1">
<tr>
<td>rollno</td>
<td>ID</td>

</tr>
<%

String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/example";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} 
catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
ResultSet resultSet = null;
try{
	
connection = DriverManager.getConnection(connectionUrl, userid, password);

String sql ="select rollno,ID from candidate where elecType = ?;";
PreparedStatement ps = connection.prepareStatement(sql);

ps.setString(1, "college");
resultSet =ps.executeQuery();
while(resultSet.next()){
	
%>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getInt(2) %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
	//System.out.println(e);
e.printStackTrace();
}
%>
</table>
<form action = "vote" method = "post">
Enter the candidate ID that you want to vote
<input type = "text" , name = "id"/>
<br>
<input type = "submit" name = "v" value = "voteForCollegePresident"/>
</form>
<h2><% if(null != request.getAttribute("error"))
	{
	out.println(request.getAttribute("error"));
	}
	%>
	</h2>
<a href = "voting.html">move to voting menu</a>
</body>
</html>