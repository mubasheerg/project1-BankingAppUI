<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Search</title>
<script type="text/javascript">
function isCustomerId()
{
	if( document.forms[0].customerId.value == "" ) {
        alert( "Please Enter customerId!" );
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
<body  onsubmit="return isCustomerId()" bgcolor="aqua" style="padding: 100px;text-align: center;">
<h2 style="color:maroon">Search Customer By Id</h2><br/><br/>
<form action="FindCustomerController">
<h3>Customer ID: <input type="number"  name="customerId" min="0"/> </h3><br/><br/>
<input type="submit" value="Search"  style="color: green;font-size: large;">
</form>

</body>
</html>