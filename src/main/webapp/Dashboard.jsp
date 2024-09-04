<%@page import="com.model.Login"%>
<%@page import="com.model.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	height: 100vh;
	margin: 0;
}

.navbar {
	background-color: #333;
	color: #fff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10px 20px;
}

.logo img {
	height: 50px;
}

.nav-links a {
	text-decoration: none;
	color: #fff;
	margin-left: 80px;
	font-size: 16px;
	transition: opacity 0.3s ease;
}

.nav-links a:hover {
	opacity: 0.8; /* Reduce opacity on hover */
}

.container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	flex-wrap: wrap; 
	gap: 20px; 
}

.box {
	background-color: white;
	width: 600px;
	height: 100px;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 8px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	
	text-align: center;
	margin: 10px;
}

.box a {
	text-decoration: none;
	color: black;
	font-weight: bold;
}

.label {
	display: block;
	margin-top: 20px;
}

h2 {
	display: flex;
	justify-content: center;
	align-items: center;
}


</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
	<form action="#">
		<nav class="navbar">
			<div class="logo">
				<h3>QuickRecharge</h3>
			
			</div>
			<div class="nav-links">
				<i class="fa-solid  fa-right-from-bracket" style="color: white;"></i><a href="Home.html">Logout</a>
				<i class="fa-solid  fa-right-from-bracket" style="color: white;"></i><a href="Profile.jsp">Profile</a>
				
			</div>
		</nav>
		<div class="container">
			<h2>Dashboard</h2>

			<div class="box">
				<a href="RechargeView.jsp"> <span class="label">Recharge</span>
				</a>
			</div>
			
			<div class="box">
				<div class="card">
				    <div class="front">
					<a href="CheckController"> <span class="label">Check
							Balance</span>
					</a>
					</div>
					
				</div>
			</div>
			<div class="box">
				<a href="AddBalance.jsp"> <span class="label">Add Balance</span>
				</a>
			</div>
			<div class="box">
				<a href="alltransaction"> <span class="label">All
						Transaction</span>
				</a>
			</div>
		</div>
	</form>
</body>
</html>