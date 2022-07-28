<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete account</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
		 <h1 style="padding: 10px; color: cadetblue;">Delete Account</h1>	
		 <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWe31l6aG1vBCAwdeplCJOAUZvoniRiX3ZZTWH_iBNVViWzYSd6vxHwxEFjo2QJCxQxU4&usqp=CAU" height="150px" width="300px">
		 <hr>
		 <form name="frm" method="post" action="Deleteaccount">
		 <table>
		 <tr>
		 	<td>Enter the account number:
		 	<td><input type="text" name="uid"  class="form-control" required>
		 	<td><input type="submit" value="Submit" style="margin-left: 20px" class="btn btn-outline-danger">
		 </tr>
		 </table>
		 </form>
		
	</div>
</body>
<script lang="javascipt">
	
</script>
</html>