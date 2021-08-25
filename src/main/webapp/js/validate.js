//external js
function validate()
{
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	if(username.length==0)
		{
			alert ("Please Enter Username");
			return false;
		}
	else if(password.length==0)
		{
			alert("please Enter Password")
			return false;
		}
	else
		{
			if(password.length<6 || password.length>10){
				alert("Invalid password!!");
				return false;
			}
			else
				alert("Welcome, "+username);
				
		}
}