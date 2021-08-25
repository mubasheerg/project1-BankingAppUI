//external js
function validateSignup()
{
	var allFields = new Array();
		for(i=0;i<5;i++)
		{
			allFields[i]=document.forms[0].elements[i].value;
		}
		console.log(allFields)
		//IF NAME IS EMPTY
		if(allFields[0].length==0 ){
			alert("Enter username")
			return false;
		}
		//IF PASS IS EMPTY
		else if(allFields[1].length==0){
			alert("Enter Password")
			return false;
		}
		//VALID PASSWORD CHECK
		else if(allFields[1].length<6 || allFields[1].length>10){
			alert("Invalid Password!! (6-10 characters)")
			return false;
		}
		//IF PASSWORD IS EMPTY
		else if(allFields[2].length==0){
				alert("Enter Confirm Password")
				return false;
		}
		//IF NOT MATCHED PASSWORD
		else if(allFields[1]!=allFields[2])
		{
			alert("Confirm Password Not matched with password")
			return false;
		}
		//IF EMAIL IS EMPTY
		else if(allFields[3].length==0){
			alert("Enter email")
			return false;
		}
		
		//IF PHONE IS EMPTY
		else if(allFields[4].length==0){
			alert("Enter Phone no")
			return false;
		}
		//VALID LENGTH OF PHONE NO
		else if(allFields[4].length>10 || allFields[4].length<10)
		{
			alert("Enter valid Phone no")
			return false;
		}
	else{
			//GENDER VALIDATION
			var group = document.forms[0].gender;
			for (var i=0; i<group.length; i++) {
			if (group[i].checked)
			break;
			}
			if(i==group.length){
			alert("Please select  gender");
			return false;
		}
		
			//NOTIFIACTION VALIDATION
		group = document.forms[0].notification;
		for (var i=0; i<group.length; i++) {
		if (group[i].checked)
		break;
		}
		if(i==group.length){
			alert("Please select Notification option");
			return false;
		}
		
		//PAYMENT VALIDATAION
		payment= document.getElementById("PaymentOptions");
		if (payment.value=="--select--") {
            alert("Please select Payment option!");
            return false;
        }
		}
		return true;
}