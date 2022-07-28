<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user profile</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 class="display-3" style="color:#226da5">User Profile</h2>

			
<%
//doubt
String uid=String.valueOf(session.getAttribute("userid"));
String typ=String.valueOf(session.getAttribute("usertype"));
//String uid=session.getAttribute("userid").toString();
%>
<img src='images/<%=uid%>.jpeg' class="rounded-circle" width="150">


<br><br>

<a href="homepage.jsp"><button type="submit"  class="btn btn-outline-success">back</button></a>

<hr>

<table class="table table-bordered table-hover table-dark">
<tr style="background-color: #ffbdde">
<th>userid
<th>city
<th>emailid
<th>mobile


</tr>


<%
//String id = request.getParameter("userid");
//Accessing servelets variable of Checklogin.jsp
//String uid=(String)request.getAttribute("userloginid");

String id=String.valueOf(session.getAttribute("userid"));


Connection con;
PreparedStatement pst;
ResultSet rs,count;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	pst=con.prepareStatement("select * from E_wallet_users where userid=?;");
	//rs=pst.executeQuery("select * from E_wallet_users where userid=?;");
	pst.setString(1, id);
	rs=pst.executeQuery();
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("userid")%></td>
		<td><%=rs.getString("city")%></td>
		<td><%=rs.getString("emailid")%></td>
		<td><%=rs.getString("mobile")%></td>
		
		</tr>
		<%
		
		
		
	}
	
	con.close();
}
catch(Exception e)
{
	out.println(e);
}
%>
</table>
<br>


		
		
		
	</div>
</body>
</html>