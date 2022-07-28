<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList</title>
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
<a href="adminpage.jsp"><button type="submit"  class="btn btn-outline-success">back</button></a>
<a href="deleteaccount.jsp"><button type="submit"  class="btn btn-outline-success">delete account</button></a>
<a href="activedeactive.jsp"><button type="submit"  class="btn btn-outline-success">activate-deactivate</button></a>
<hr>

<table class="table table-bordered table-hover table-dark">
<tr style="background-color: #ffbdde">
<th>UserID
<th>City
<th>emailid
<th>Mobile
<th>userstatus
<th>usertype

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
	rs=st.executeQuery("select * from E_wallet_users;");
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("userid")%></td>
		<td><%=rs.getString("city")%></td>
		<td><%=rs.getString("emailid")%></td>
		<td><%=rs.getString("mobile")%></td>
		<td><%=rs.getString("userstatus")%></td>
		<td><%=rs.getString("usertype")%></td>
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