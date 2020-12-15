<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	/* The image used */
	background-image:
		url("https://blog.mint.com/wp-content/uploads/2019/03/be-prepared-for-possible-adjustments.png");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

</head>
<body>
	<div class="bg">
		<div align="center">
			<br>
			<h1>Expenses Management</h1>
			<button type="button" class="btn btn-primary"
				onclick="document.location='login.jsp'">Login</button>
			<button type="button" class="btn btn-primary"
				onclick="document.location='register.jsp'">Register</button>
		</div>
	</div>
</body>
</html>