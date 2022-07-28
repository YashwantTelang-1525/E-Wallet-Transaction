<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.*" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>User log in successful</title>
        <link rel="stylesheet" href="bootstrap.min.css">
        
    </head>

    <body>
    <section class="ftco-section">
        <div class="container">
        
<%
String uid=String.valueOf(session.getAttribute("userid"));
String typ=String.valueOf(session.getAttribute("usertype"));
//String uid=session.getAttribute("userid").toString();

%>

<table>
<tr>
<td><img src='images/<%=uid%>.jpeg' class="rounded-circle" width="150">
<td width="100">
<td>
<h2 class="display-3" style="color:#226da5">User log in successful</h2>
Logged in as : <%=uid%> | Session ID : <%=session.getId()%>
</tr>
</table>

<hr>
<%
Calendar cal=Calendar.getInstance();
out.println(cal.getTime());
String userid=uid;

%>

            
            
             
			<hr>
			   <a href="userprofile.jsp"><button type="button" class="btn btn-outline-success">user profile</button></a>
               <a href="accountprofile.jsp"><button type="button" class="btn btn-outline-success">account profile</button></a>
               <a href="uploadKYC.html"><button type="button" class="btn btn-outline-success">UploadKYC</button></a>
               
               
               <a href="transfermoneytoaccount.html"><button type="button" class="btn btn-outline-success">Transfer money</button></a>
	           <a href="index.jsp"><button type="button" class="btn btn-outline-success">logout</button></a>
	          
            <hr>
               
               
               
<h5 class="display-7" style="color:#226da5">User profile details:</h5>            
<table class="table table-bordered table-hover table-dark">
<tr style="background-color: #ffbdde">
<th>userid
<th>city
<th>emailid
<th>mobile
               
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
        </section>
    </body>

    </html>