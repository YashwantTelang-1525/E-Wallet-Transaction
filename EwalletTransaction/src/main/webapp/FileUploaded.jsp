<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>File Uploaded successfully</h2>
	<%String uid=String.valueOf(session.getAttribute("userid")); %>
	<h6>Your walletid is SBI<%=uid%></h6>
	<a href="homepage.jsp">home</a>
	<%//<a href="showkycdoc.jsp">show document</a>%>
</body>
</html>