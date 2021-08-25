<%@page import="com.revature.pms.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="aqua">
	<h2>Customer details</h2>
	<%
	List<Customer> customers = (List<Customer>) session.getAttribute("allCustomers");
	%>
	<table border="5" cellpadding="4" cellspacing="7"
		bordercolor="rgb(70,70,70)">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th>Balance</th>
		<th>Registration Date</th>
		<th>Edit</th>
		<th>Delete</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%=customer.getCustomerId()%></td>
			<td><%=customer.getCustomerName()%></td>
			<td><%=customer.getEmailId()%></td>
			<td><%=customer.getMobileNumber()%></td>
			<td><%=customer.getBalance()%></td>
			<td><%=customer.getRegistrationDate()%></td>
			<td><a
				href="EditCustomersController?customerId=<%=customer.getCustomerId()%>"
				onclick="alert('Editing Customer Id: <%=customer.getCustomerId()%>!!')"><button
						style="color: olive">Edit</button></a></td>
			<td><a
				href="DeleteCustomerAccountController?customerId=<%=customer.getCustomerId()%>"
				onclick="alert('Deleting Customer Id: <%=customer.getCustomerId()%>!!')"><button
						style="color: red">Delete</button></a></td>
		</tr>
		<%
		}
		%>

	</table>
	<br />
	<br />
	<a href="employeeOperations.jsp"><button>Back</button></a>
	<br />
	<br />


</body>
</html>
