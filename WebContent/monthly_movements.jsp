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
				href="list">Transactions List</a>
		</h2>

		<form action="Summary" method="post">
			select a month: <select name="month">
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
			</select> <input type="submit" value="submit" class="btn btn-primary">
		</form>
		<table border="1" cellpadding="5" width="80%">
			<tr>
				<th>ID</th>
				<th>Type</th>
				<th>Category</th>
				<th>Details</th>
				<th>Amount</th>
				<th>Month</th>
			</tr>
			<c:forEach var="movement" items="${movementsList}">
				<tr>
					<td><c:out value="${movement.id}" /></td>
					<td><c:out value="${movement.type}" /></td>
					<td><c:out value="${movement.category}" /></td>
					<td><c:out value="${movement.details}" /></td>
					<td><c:out value="${movement.amount}" /></td>
					<td><c:out value="${movement.month}" /></td>
				</tr>
			</c:forEach>
		</table>
		<c:set var="expenses" value="${0}" />
		<c:set var="incomes" value="${0}" />
		<c:forEach var="article" items="${movementsList}">
			<c:if test="${article.type == 'Expense'}">
				<c:set var="expenses" value="${expenses + article.amount}" />
			</c:if>
			<c:if test="${article.type == 'Income'}">
				<c:set var="incomes" value="${incomes + article.amount}" />
			</c:if>
		</c:forEach>
		<c:set var="saving" value="${incomes - expenses}" />
		<br>
		<table border="1" cellpadding="5" width="50%">
			<tr>
				<th>Total Expenses:</th>
				<th>Total Incomes:</th>
				<th>Total Saving:</th>
			<tr>
				<td><c:out value="${expenses}" /></td>
				<td><c:out value="${incomes}" /></td>
				<td><c:out value="${saving}" /></td>
			</tr>
		</table>
		<br>

		<c:set var="entertainment" value="${0}" />
		<c:set var="food" value="${0}" />
		<c:set var="health" value="${0}" />
		<c:set var="housing" value="${0}" />
		<c:set var="clothing" value="${0}" />
		<c:set var="trasportation" value="${0}" />
		<c:set var="other" value="${0}" />
		<c:forEach var="article" items="${movementsList}">
			<c:if
				test="${article.category == 'Entertainment' && article.type == 'Expense'}">
				<c:set var="entertainment" value="${entertainment + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Food' && article.type == 'Expense'}">
				<c:set var="food" value="${food + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Health Care' && article.type == 'Expense'}">
				<c:set var="health" value="${health + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Housing' && article.type == 'Expense'}">
				<c:set var="housing" value="${housing + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Clothing' && article.type == 'Expense'}">
				<c:set var="clothing" value="${clothing + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Transportation' && article.type == 'Expense'}">
				<c:set var="trasportation" value="${trasportation + article.amount}" />
			</c:if>
			<c:if
				test="${article.category == 'Other' && article.type == 'Expense'}">
				<c:set var="other" value="${other + article.amount}" />
			</c:if>
		</c:forEach>

		<script>
			var entertainmentp = <c:out value="${entertainment / expenses * 100}" />
			var foodp = <c:out value="${food / expenses * 100}" />
			var healthp = <c:out value="${health / expenses * 100}" />
			var housingp = <c:out value="${housing / expenses * 100}" />
			var clothingp = <c:out value="${clothing / expenses * 100}" />
			var trasportationp = <c:out value="${trasportation / expenses * 100}" />
			var otherp = <c:out value="${other / expenses * 100}" />
			window.onload = function() {

				var chart = new CanvasJS.Chart("chartContainer", {
					animationEnabled : true,
					data : [ {
						type : "pie",
						startAngle : 240,
						yValueFormatString : "##0.00\"%\"",
						indexLabel : "{label} {y}",
						dataPoints : [ {
							y : entertainmentp,
							label : "Entertainment"
						}, {
							y : foodp,
							label : "Food"
						}, {
							y : healthp,
							label : "Health Care"
						}, {
							y : housingp,
							label : "Housing"
						}, {
							y : clothingp,
							label : "Clothing"
						}, {
							y : trasportationp,
							label : "Trasportation"
						}, {
							y : otherp,
							label : "Other"
						} ]
					} ]
				});
				chart.render();

			}
		</script>
		<div id="chartContainer" style="height: 370px; width: 100%;"></div>
		<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	</div>
</body>
</html>
