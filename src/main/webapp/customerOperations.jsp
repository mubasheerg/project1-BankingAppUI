<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Operations</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
h3 {
	padding: 10px;
	color: black;
	font-family: cursive;
	font-style: italic;
	font-size: medium;
	text-align: center;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-left">
		<div>
			<div>
				<ul class="nav navbar-nav">
				<li><a href="DisplayCustomerController">View/Edit Account</a></li>
				<li><a href="ViewBalanceController">View Balance</a></li>
				<li><a href="withdraw.jsp">Withdraw</a></li>
				<li><a href="deposit.jsp">Deposit</a></li>
				<li><a href="transferAmount.jsp">Transfer Amount</a></li>
				<li><a href="ViewStatementController">View Statement</a></li>
				<li><a href="home.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h4 style="color: maroon;">
		Customer Id:
		<%=session.getAttribute("customerId")%></h4>
	<h4 style="color: maroon;">
		Login Time:
		<%=session.getAttribute("loginTime")%></h4>
</body>
</html>