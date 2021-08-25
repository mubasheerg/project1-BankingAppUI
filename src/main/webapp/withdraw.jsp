<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transaction</title>
<script type="text/javascript">
	function isAmount() {
		if (document.forms[0].amount.value == "") {
			alert("Please Enter Amount!");
			document.forms[0].amount.focus();
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body onsubmit="return isAmount()" bgcolor="aqua"
	style="padding: 100px; text-align: center;">
	<h2 style="color: maroon">Welcome to Transaction page</h2>
	<br />
	<br />
	<form action="WithdrawMoneyController">
		<h3>
			Enter Amount to Withdraw : <input type="number" name="amount" min="1" />
		</h3>
		<br />
		<br /> <input type="submit" value="Withdraw"
			style="color: green; font-size: large;"> <br /> <br />
		<a href="customerOperations.jsp">BACK</a>
	</form>
</body>
</html>