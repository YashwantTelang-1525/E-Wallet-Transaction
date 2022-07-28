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
		<h2 class="display-3" style="color:#226da5">account profile</h2>
		
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
<th>accnumber
<th>accname
<th>actype
<th>balance available
<th>walletID


</tr>


<%
//String id = request.getParameter("userid");
//Accessing servelets variable of Checklogin.jsp
//String uid=(String)request.getAttribute("userloginid");

String idaccount=String.valueOf(session.getAttribute("userid"));


Connection con;
PreparedStatement pst;
ResultSet rs,count;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	pst=con.prepareStatement("select * from walletaccounts where accno=?;");
	
	pst.setString(1, idaccount);
	rs=pst.executeQuery();
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("accno")%></td>
		<td><%=rs.getString("accnm")%></td>
		<td><%=rs.getString("acctype")%></td>
		<td><%=rs.getString("balance")%></td>
		<td><%=rs.getString("walletid")%></td>
		
		</tr>
		<%
		
		
		
	}
	
	con.close();
}
catch(Exception e)
{
	out.println(e);
	out.println("No such account available");
}
%>
</table>
<br>


		
		
		
	</div>
</body>
</html>