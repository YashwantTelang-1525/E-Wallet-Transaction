<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h1 style="padding: 10px; color: cadetblue; margin-left:545px">login</h1>
	
     <hr>
     <br>
                <form name="frm" method="post" action="Checklogin" style="margin-left:435px">
                <table>
                    <tr>
                        <td>userid</td>
                        <td><input type="text" name="uid" class="form-control" required></td>
                    </tr>

                    <tr>
                        <td>password </td>
                        <td><input type="password" name="psw" class="form-control" required></td>
                    </tr>
                </table>
                <br>
                <table>
                    <tr>
                        <td><input type="submit" value="Submit" style="margin-left: 130px;" class="btn btn-outline-success"></td>
                    </tr>                    
                </table>
                <br>
               	<br><br><br><br><br><br>
                <br>
                <a href="registeruser.html"><button type="button" class="btn btn-outline-warning" style="margin-left: 130px;" >sign up</button></a>    	
                    
        </form>
	</div>
</body>
</html>