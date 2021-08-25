<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Money Transaction</title>
<script type="text/javascript">
function isAmount()
{
	if( document.forms[0].receiver.value == "" ) {
        alert( "Please Enter Receiver Account No!" );
        document.forms[0].receiver.focus() ;
        return false;
     }
	if( document.forms[0].amount.value == "" ) {
        alert( "Please Enter Amount!" );
        document.forms[0].amount.focus() ;
        return false;
     }
	else
		{
		return true;
		}
}
</script>
<style type="text/css">
label {
  display: inline-block;
  width: 200px;
  text-align: center;
}
​
</style>
</head>
<body  bgcolor="aqua" style="padding: 100px;text-align: center;">
<h2 style="color:maroon">Welcome to Transaction page</h2><br/><br/>
<form action="TransferMoneyController" onsubmit="return isAmount()" >
<h3><label>Account No. to be transferred: <input type="number"  name="receiver" min="0"/></label> </h3><br/><br/>
<h3><label>Enter Amount : <input type="number"  name="amount" min="1"/> </label></h3><br/><br/>
<input type="submit" value="Transfer"  style="color:green;font-size: large;">
<br/>
<br/><a href="customerOperations.jsp">BACK</a>
</form>
</body>
</html>