<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>You have logged out successfully</h1>
	</div>
	<%
		response.setHeader("Refresh", "1;login.jsp");
	%>
</body>
</html>