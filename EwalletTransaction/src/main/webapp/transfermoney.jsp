<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*;" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer money</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

	<div class="container">
	<%
	    String useridacc=String.valueOf(session.getAttribute("userid"));
		String userid,fromacc,toacc,amount;
		userid = request.getParameter("uid");
		fromacc=request.getParameter("facc");
		toacc=request.getParameter("tacc");
		amount=request.getParameter("tamt");
		
		System.out.println(fromacc+toacc+amount);
		Connection con;
        PreparedStatement pst,pst1,pst3;
					
	        
	        try{
	        	//con=obj.getDbconnection();
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://b778m35afj0hm3pmhpou-mysql.services.clever-cloud.com:3306/b778m35afj0hm3pmhpou?user=uuphcvlz6eijcak1&password=2eDCMXWnjGW6w5S9WYTW");
	            pst = con.prepareStatement("UPDATE walletaccounts SET balance=balance+? where accno=?;");
	            pst.setString(1, amount);
	            pst.setString(2, toacc);
	            
	            pst1 = con.prepareStatement("UPDATE walletaccounts SET balance=balance-? where accno=? and accno=?;");
	            pst1.setString(1, amount);
	            pst1.setString(2, fromacc);
	            pst1.setString(3, useridacc);
	            int cnt = pst.executeUpdate();
	            int cnt1 = pst1.executeUpdate();
	            
	            if(cnt == 1 && cnt1 == 1){
	               response.sendRedirect("moneytransffersuccessful.html");;
	            }
	            else{
	            	pst3 = con.prepareStatement("UPDATE walletaccounts SET balance=balance-? where accno=?;");
		            pst3.setString(1, amount);
		            pst3.setString(2, toacc);
		            pst3.execute();
	               response.sendRedirect("transferfailed.html");
	            }
	            con.close();
	        }
	        catch(Exception e){
	            System.out.println(e);
	            
	        }
	        %>
	</div>
</body>
</html>