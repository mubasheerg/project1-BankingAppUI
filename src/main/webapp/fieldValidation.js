 
function validate(){
	
		if( document.myForm.userName.value == "" ) {
            alert( "Please provide your name!" );
            document.myForm.userName.focus() ;
            return false;
         }
         if( document.myForm.password.value == "" ) {
            alert( "Please provide your password!" );
            document.myForm.password.focus() ;
            return false;
         }
		 if( document.myForm.confirmPassword.value == "" ) {
            alert( "Please provide your confirmpassword!" );
            document.myForm.confirmPassword.focus() ;
            return false;
         }

		if(document.myForm.password.value != document.myForm.confirmPassword.value )
		{
			alert( "Confirm Password not matched with given password as above!" );
            document.myForm.confirmPassword.focus() ;
            return false;
		}
         if( document.myForm.mobileNumber.value == "" || isNaN( document.myForm.mobileNumber.value ) ||
            document.myForm.mobileNumber.value.length < 10 ||document.myForm.mobileNumber.value.length >10 ) {
            
            alert( "Please provide a mobile number in the format ##########." );
            document.myForm.mobileNumber.focus() ;
            return false;
         }
         if( document.myForm.email.value == "" ) {
            alert( "Please provide your email!" );
 			document.myForm.email.focus() ;
            return false;
         }

		 if( document.myForm.address.value == "" ) {
            alert( "Please provide your address!" );
 			document.myForm.address.focus() ;
            return false;
         }
		if( document.myForm.salary.value == "" ) {
            alert( "Please provide your salary!" );
 			document.myForm.salary.focus() ;
            return false;
         }

		if( document.myForm.salary.value <0) {
            alert( "Salary must be grater than 0 !" );
 			document.myForm.salary.focus() ;
            return false;
         }
		
         return( true );
      }