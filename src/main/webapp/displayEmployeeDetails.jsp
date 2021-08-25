<%@page import="com.revature.pms.model.Employee"%>
<%@page import="com.revature.pms.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body bgcolor="aqua">
	<h2>Employee details</h2>
	<%
	List<Employee> employees = (List<Employee>) session.getAttribute("employeeDetails");
	%>
	<table border="5" cellpadding="4" cellspacing="7" bordercolor="rgb(70,70,70)">
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Email</th>
		<th>Mobile Number</th>
		<th>Salary</th>
		<th>Address</th>
		<th>Edit</th>
		<%
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
		%>
		<tr>
			<td><%=employee.getEmployeeId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getEmailId()%></td>
			<td><%=employee.getPhoneNo()%></td>
			<td><%=employee.getSalary() %></td>
			<td><%=employee.getAddress()%></td>
			<td><a href="EditEmployeeAccountController"><button style=color:"green">Edit</button></a></td>
		</tr>
		<%
		}
		%>

	</table>
<br/>
<br/>
<a href="employeeOperations.jsp"><button>Back</button></a>
</body>
</html>
