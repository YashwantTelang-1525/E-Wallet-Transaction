<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Active Deactive</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
	    <h1 style="padding: 10px; color: cadetblue;">Activate Deactivate Account</h1>	
	    	<a href="adminsetting.jsp"><button type="button" class="btn btn-outline-success">back</button></a>
		 <hr>
		<form name="frm" method="post" action="AccountActivateDeactivate">
			<table>
				<tr>
					<td>Enter the account no:
					<td><input type="text" name="uid"  class="form-control" required>
				</tr>
				<tr>
					<td>Enter status:
					<td><select name="accountstatus" class="form-control"> <option value="active">active</option>
  						<option value="deactive">deactive</option></select>
		 	        <td><input type="submit"  style="margin-left: 20px" class="btn btn-outline-danger">
				</tr>
			</table>
		</form>
	</div>
</body>
</html>