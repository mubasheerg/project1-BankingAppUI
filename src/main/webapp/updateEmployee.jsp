<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
label {
  display: inline-block;
  width: 160px;
  text-align: center;
}
​
</style>
</head>
<h1>Update Customer</h1><br/></br>
<body style="background-color: gray;text-align: center;">
<form action="UpdateEmployeeController">
<h3><label >Employee Id :</label><input type="number" name="employeeId" value=<%= session.getAttribute("employeeId") %>  readonly="readonly"></h3>
<h3><label >User Name  :</label><input type="text" name="userName" value=<%= session.getAttribute("userName") %>></h3>
<h3><label>Password:</label><input type="text" name="password" value=<%= session.getAttribute("password") %>></h3>
<h3><label>Mobile No: </label><input type="text" name="mobileNumber" value=<%= session.getAttribute("mobileNumber") %>></h3>
<h3><label>Email id: </label><input type="text" name="email" value=<%= session.getAttribute("email") %>></h3>
<h3><label>Address: </label><input type="text" name="address" value=<%= session.getAttribute("address") %>></h3>
<h3><label>salary:</label><input type="number" name="salary" value=<%= session.getAttribute("salary")  %>></h3>
<br/></br>
<span><input type="submit" style="color:green;font-size: large;" value="Update" onclick="alert('Updated Successfully!!')"></span>
</form>
</body>
</html>