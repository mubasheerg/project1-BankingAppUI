<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/home.css">
</head>
<body>
	<header>
		<div class="logo">
			<img src="images/banklogo.jpg" alt="">
		</div>
		<div class="navbar">
			<a href="#">Home</a><a href="#services">Services</a>
			<div class="dropdown">
				<button class="dropbtn">
					Login
					<!-- <i class="fa fa-caret-down"></i> -->
				</button>
				<div class="dropdown-content">
					<a href="employeeLogin.html">Employee</a> <a
						href="customerLogin.jsp">Customer</a>
				</div>
			</div>
			<div class="dropdown">
				<button class="dropbtn">
					SignUp
					<!-- <i class="fa fa-caret-down"></i> -->
				</button>
				<div class="dropdown-content">
					<a href="employeeSignup.html">Employee</a> <a
						href="customerSignup.html">Customer</a>
				</div>
			</div>

		</div>
		<div class="welcome-text">
			<h1>Banking Management System</h1>
			<a href="#footer">Contact US</a>
		</div>
	</header>
	<div>
		<div id="services" style="text-align: center">
			<h1 style="padding: 30px">Services</h1>
		</div>
		<div>
			<h3>
				<div>Customer can create an account and do all kind of
					transaction.</div>
				<div>Employee can go through the customer details.</div>
			</h3>
		</div>
	</div>


	<footer id="footer">
		<p class="contact">
			Contact us : <a href="mailto:mubasheerg@gmail.com">mubasheer1401@gmail.com</a>
		</p>
	</footer>
</body>
</html>