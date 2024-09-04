<%@page import="com.model.Login"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<style>
body {
    font-family: Arial, sans-serif;
}

.profile {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Full viewport height */
}

.p1 {
    border: 1px solid #ccc;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    background-color: #f9f9f9;
}

table {
    width: 100%;
    border-collapse: collapse;
}

td {
    padding: 10px;
    vertical-align: top;
}

td:first-child {
    font-weight: bold;
}
</style>
</style>
</head>
<body>
<div class="profile">


<div class="p1">
<h2>Your Profile</h2>
<%List<Login> lobj1; %>

<table>
<%
if(!session.isNew()){
	lobj1=(List<Login>)session.getAttribute("login");
	Login lobj=lobj1.get(0);
%>
<tr><td>Reg No:</td><td><%=lobj.getRegno()%>
<tr><td>Email Id:</td><td><%=lobj.getLemail()%></td>
<tr><td>Password:</td><td><%=lobj.getLpass() %>


<%

}
session.invalidate();%>
<tr><td><a href="Dashboard.jsp">Back</a></td></tr>
</table>
</div>
</div>
</body>
</html>