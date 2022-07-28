<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>change</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<br><br>
<%
String id,curps,newps,confps;
id=request.getParameter("uid");
curps=request.getParameter("curps");
newps=request.getParameter("newps");
confps=request.getParameter("confps");
//out.println(id+" | "+curps+" | "+newps+" | "+confps);

Connection con;
PreparedStatement pst;

if(newps.equals(confps))
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
		pst=con.prepareStatement("update E_wallet_users set password=? where userid=? and password=?;");
		pst.setString(1,newps);
		pst.setString(2,id);
		pst.setString(3,curps);
		int cnt=pst.executeUpdate();
		if(cnt==1)
		{
			out.println("<h5 class='display-5'>password changed successfully</h5>");
		}
		else
			out.println("<h5 class='display-5'>authentication failed</h5>");
		
		con.close();
		
	}
	catch(Exception e)
	{
		out.println(e);
	}
}
else
{
	out.println("<h2 class='display-5'>New passwords mismatched</h2>");
}
%>
<hr>
<a href="adminpage.jsp">back</a>
</div>
</body>
</html>