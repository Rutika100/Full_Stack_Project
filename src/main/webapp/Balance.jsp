<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.back{
display:flex;
justify-content: center;
padding:10px;
border:1px solid #ccc;
outline:4px dotted;
outline-color:transparent;
margin-left:40%;
margin-right:40%;
}
</style>
</head>
<body>
<center> <h2>Balance</h2></center>
<div class="back">
                  
					<% HttpSession sess=request.getSession(); 
                      if (session != null) {  
                      Float balance=(Float)sess.getAttribute("balance");
                      %><%=balance %>
						<%
                           }
                          %>
</div>
</body>
</html>