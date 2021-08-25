
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Operations</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
h3{
	padding:10px;
	color:gray;
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
				<li ><a href="DisplayEmployeeController">View / Edit Account</a></li>
				<li ><a href="searchCustomer.jsp">Search Customer</a></li>
				<li ><a href="ViewAllCustomerController">View All Customers</a></li>
				<li ><a href="searchCustomerStatement.jsp">View Customer Statement </a></li>
				<li ><a href="ViewAllCustomerStatements">View All Statements </a></li>
				<li ><a href="home.jsp">Logout</a></li>	
			</ul>
		</div>
	</div>
	</nav>
	<h4 style="color:olive;">Employee ID: <%=session.getAttribute("employeeId") %></h4>
	<h4 style="color:olive;">Login Time: <%=session.getAttribute("loginTime") %></h4>
					
</body>
</html>