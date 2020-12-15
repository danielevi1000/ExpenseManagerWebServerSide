<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script>
	function change() {
		var x = document.getElementById("type").value;
		if (x == "Income") {
			document.getElementById("category").disabled = true;
		} else
			document.getElementById("category").disabled = false;
	}
</script>
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
				href="list">Transactions List</a>
		</h2>
		<c:if test="${movement != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${movement == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<h2>
				<c:if test="${movement != null}">
            			Edit Movement
            		</c:if>
				<c:if test="${movement == null}">
            			Add New Transaction
            		</c:if>
			</h2>
			<c:if test="${movement != null}">
				<input type="hidden" name="id"
					value="<c:out value='${movement.id}' />" />
			</c:if>
			<tr>
				<th>Type:</th>
				<td><select name="type" id="type" onchange="change()">
						<option value="Expense">Expense</option>
						<option value="Income">Income</option>
				</select></td>
			</tr>
			<tr>
				<th>Category:</th>
				<td><select name="category" id="category">
						<option value="Entertainment">Entertainment</option>
						<option value="Food">Food</option>
						<option value="Health Care">Health Care</option>
						<option value="Housing">Hosing</option>
						<option value="Clothing">Clothing</option>
						<option value="Transportation">Transportation</option>
						<option value="Other">Other</option>
				</select></td>
			</tr>
			<tr>
				<th>Details:</th>
				<td><input type="text" name="details" size="45"
					value="<c:out value='${movement.details}' />" /></td>
			</tr>
			<tr>
				<th>Amount:</th>
				<td><input type="number" required="required" step="any"
					name="amount" size="15"
					value="<c:out value='${movement.amount}' />" /></td>
			</tr>
			<tr>
				<th>Month:</th>
				<td><select name="month">
						<option value="January">January</option>
						<option value="February">February</option>
						<option value="March">March</option>
						<option value="April">April</option>
						<option value="May">May</option>
						<option value="June">June</option>
						<option value="July">July</option>
						<option value="August">August</option>
						<option value="September">September</option>
						<option value="October">October</option>
						<option value="November">November</option>
						<option value="December">December</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" class="btn btn-primary" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
