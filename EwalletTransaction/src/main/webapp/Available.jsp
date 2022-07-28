<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*;" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available</title>
</head>
<body>
<% 
	String id = request.getParameter("uid");

Connection con;
PreparedStatement pst;
ResultSet rs;

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	pst=con.prepareStatement("select * from E_wallet_users where userid=?;");
	pst.setString(1,id);
	rs=pst.executeQuery();
	if(rs.next())
	{
		%>
		<span style="color:red">Sorry! userID <%=id %> not available</span>
		<%
	}
	else
	{
		%>
		<span style="color:green">Congrats! userID <%=id %> is available</span>
		<%
	}
	con.close();
}
catch(Exception e){
	out.println(e.getMessage());
}
%>
</body>
</html>