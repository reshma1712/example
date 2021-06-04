<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<body>

voting details of college president election
<table border="1">
<tr>
<td>rollno</td>
<td>ID</td>
<td>votes</td>
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
int yy = 0;
String vv ="";
int count =  0;
try{
	
connection = DriverManager.getConnection(connectionUrl, userid, password);

String sql ="select rollno,ID from candidate where elecType = ?;";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setString(1, "college");
resultSet =ps.executeQuery();
while(resultSet.next()){
	
int x = resultSet.getInt(2);

 String ql ="select count(*) from college where ID = ?;";
PreparedStatement ss = connection.prepareStatement(ql);

ss.setInt(1, x);
ResultSet rs =ss.executeQuery();
rs.next();
int y = rs.getInt(1);
if(y==yy){
	vv = vv+","+resultSet.getString(1);
}
else if(yy<y){
	yy = y;
	vv = resultSet.getString(1);
}
%>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getInt(2) %></td>
<td><%=y %>
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
<p><%=vv %> is the winner</p>
voting details of dept president election
<table border="1">
<tr>
<td>rollno</td>
<td>ID</td>
<td>votes</td>
</tr>
<%

try {
Class.forName(driver);
} 
catch (ClassNotFoundException e) {
e.printStackTrace();
}
 connection = null;
 resultSet = null;
 yy = 0;
 vv ="";
count =  0;
try{
	
connection = DriverManager.getConnection(connectionUrl, userid, password);

String sql ="select rollno,ID from candidate where elecType = ?;";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setString(1, "department-IT");
resultSet =ps.executeQuery();
while(resultSet.next()){
	
int x = resultSet.getInt(2);

 String ql ="select count(*) from dept where ID = ?;";
PreparedStatement ss = connection.prepareStatement(ql);

ss.setInt(1, x);
ResultSet rs =ss.executeQuery();
rs.next();
int y = rs.getInt(1);
if(y==yy){
	vv = vv+","+resultSet.getString(1);
}
else if(yy<y){
	yy = y;
	vv = resultSet.getString(1);
}
%>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getInt(2) %></td>
<td><%=y %>
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
<p><%=vv %> is the winner</p>
voting details of it-4 year president election
<table border="1">
<tr>
<td>rollno</td>
<td>ID</td>
<td>votes</td>
</tr>
<%

try {
Class.forName(driver);
} 
catch (ClassNotFoundException e) {
e.printStackTrace();
}
 connection = null;
 resultSet = null;
 yy = 0;
 vv ="";
count =  0;
try{
	
connection = DriverManager.getConnection(connectionUrl, userid, password);

String sql ="select rollno,ID from candidate where elecType = ?;";
PreparedStatement ps = connection.prepareStatement(sql);
ps.setString(1, "IT-4-year");
resultSet =ps.executeQuery();
while(resultSet.next()){
	
int x = resultSet.getInt(2);

 String ql ="select count(*) from year where ID = ?;";
PreparedStatement ss = connection.prepareStatement(ql);

ss.setInt(1, x);
ResultSet rs =ss.executeQuery();
rs.next();
int y = rs.getInt(1);
if(y==yy){
	vv = vv+","+resultSet.getString(1);
}
else if(yy<y){
	yy = y;
	vv = resultSet.getString(1);
}
%>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getInt(2) %></td>
<td><%=y %>
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
<p><%=vv %> is the winner</p>
<a href = "welcome.html">logout</a>
</body>
</html>