<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transaction</title>
<script type="text/javascript">
function isCustomer()
{
	if( document.forms[0].customerId.value == "" ) {
        alert( "Please Enter Customer  Id!" );
        document.forms[0].customerId.focus() ;
        return false;
     }
	else
		{
		return true;
		}
}
</script>

</head>
<body  onsubmit="return isCustomer()" bgcolor="gray" style="padding: 100px;text-align: center;">
<h2 style="color:maroon">Search Customer Statement </h2><br/><br/>
<form action="ViewAStatementController">
<h3>customerId: <input type="number"  name="customerId" min="1"/> </h3><br/><br/>
<input type="submit" value="Search Statement"  style="color:green;font-size: large;">
<a href="employeeOperations.jsp">Back</a>
</form>
</body>
</html>