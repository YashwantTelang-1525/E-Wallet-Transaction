<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add money</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
	<h1 style="padding: 10px; color: cadetblue; ">add money to wallet</h1>
	 <a href="adminsetting.jsp"><button type="button" class="btn btn-outline-success">back</button></a>
     <hr>
     <br>
                <form name="frm" method="post" action="AddMoneyToWallet" ">
                <table>
                    <tr>
                        <td>accountno</td>
                        <td><input type="text" name="uid" class="form-control" required></td>
                    </tr>
                     <tr>
                        <td>password(user)</td>
                        <td><input type="password" name="pws" class="form-control" required></td>
                    </tr>
					<tr>
                        <td>walletid</td>
                        <td><input type="text" name="wid" class="form-control" required></td>
                    </tr>
                    <tr>
                        <td>amount</td>
                        <td><input type="text" name="amt" class="form-control" required></td>
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
               
                    
        </form>
	</div>
</body>
</html>