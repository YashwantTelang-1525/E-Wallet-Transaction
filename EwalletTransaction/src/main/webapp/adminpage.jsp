<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin home page</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
	
<%
String uid=String.valueOf(session.getAttribute("userid"));
String typ=String.valueOf(session.getAttribute("usertype"));
//String uid=session.getAttribute("userid").toString();

%>
<br>	
<table>
<tr>
<td><img src='images/<%=uid%>.jpeg' class="rounded-circle" width="130">
<td width="100">
<td>
<h2 class="display-4" style="color:#226da5">Log in successful</h2>
Logged in as : <%=uid%> | Session ID : <%=session.getId()%>
</tr>
</table>
<br>	
<% Calendar cal=Calendar.getInstance();%>
<h6 style="margin-left:254px"><%out.println(cal.getTime());%></h6><% 
%>
	
	
		<h1 style="padding: 10px; color: cadetblue;">Admin Panel</h1>
		<hr>
		<a href="adminsetting.jsp"><button type="submit"  class="btn btn-outline-success">setting</button></a>
	<%//	<a href="ewalletuserrecord.jsp"><button type="submit"  class="btn btn-outline-success">user record</button></a> %>
		<a href="index.jsp"><button type="submit"  class="btn btn-outline-success">log out</button></a>
	</div>
</body>
</html>