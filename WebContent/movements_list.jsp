<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Expenses Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h2>
		<a href="logout">Logout</a>
	</h2>
	<div align="center">
		<h1>Expenses Management</h1>
		<h2>
			<a href="new">Add New Transaction</a> &nbsp;&nbsp;&nbsp; <a
				href="list">Transactions List</a> &nbsp;&nbsp;&nbsp; <a
				href="Summary">Monthly Transactions</a>
		</h2>
		<h2>Transactions List</h2>
		<table border="1" cellpadding="5" width="80%">
			<tr>
				<th>ID</th>
				<th>Type</th>
				<th>Category</th>
				<th>Details</th>
				<th>Amount</th>
				<th>Month</th>
				<th>Actions</th>

			</tr>
			<c:forEach var="movement" items="${movementsList}">
				<tr>
					<td><c:out value="${movement.id}" /></td>
					<td><c:out value="${movement.type}" /></td>
					<td><c:out value="${movement.category}" /></td>
					<td><c:out value="${movement.details}" /></td>
					<td><c:out value="${movement.amount}" /></td>
					<td><c:out value="${movement.month}" /></td>
					<td><a href="edit?id=<c:out value='${movement.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${movement.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
