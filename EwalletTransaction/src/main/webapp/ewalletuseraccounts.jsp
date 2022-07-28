<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ewallet users record</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<%
if(session.getAttribute("userid")!=null || session.getAttribute("usertype").toString().equals("admin"))//at || we can place && so that only admin can access
{
%>


<br><br>
<h2 class="display-5">User List</h2>
<a href="adminsetting.jsp"><button type="submit"  class="btn btn-outline-success">back</button></a>

<hr>

<table class="table table-bordered table-hover table-dark">
<tr style="background-color: #ffbdde">
<th>account no
<th>accountant name
<th>account type
<th>balance
<th>wallet id
<th>accountstatus

</tr>


<%
Connection con;
Statement st;
ResultSet rs,count;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	st=con.createStatement();
	rs=st.executeQuery("select * from walletaccounts;");
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("accno")%></td>
		<td><%=rs.getString("accnm")%></td>
		<td><%=rs.getString("acctype")%></td>
		<td><%=rs.getString("balance")%></td>
		<td><%=rs.getString("walletid")%></td>
		<td><%=rs.getString("accountstatus")%></td>
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

<%
}
else
{
%>
<br><br>
<h2 class="display-4">Invalid session...please login</h2>
<hr>

<%
}
%>
</div>
</body>
</html>