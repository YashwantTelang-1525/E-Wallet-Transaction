<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Record</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h2 class="display-5">Transaction record</h2>

	<a href="adminsetting.jsp"><button type="submit" style="padding:10px; border:1px">back</button></a>
	<hr>
		<table class="table table-bordered table-hover table-dark">
		<tr>
			<th>from account</th>
			<th>to account</th>
			<th>amount</th>
			<th>Time and Date</th>
		</tr>
		

<%
Connection con;
Statement st;
ResultSet rs;
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	st=con.createStatement();
	rs=st.executeQuery("select * from TransactionRecord;");
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("frmacc")%></td>
		<td><%=rs.getString("toacc")%></td>
		<td><%=rs.getString("amount")%></td>
		<td><%=rs.getString("date")%></td>
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
	</div>
</body>
</html>