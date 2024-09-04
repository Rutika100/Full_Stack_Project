<%@page import="com.model.Recharge"%>
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
            margin: 0;
            padding: 20px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        
        table, th, td {
            border: 1px solid #ddd;
        }
        #new{
        background-color: white;
        border:1px solid black;
        font-size: large;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        
        th {
            background-color: #f2f2f2;
        }
        
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        
        tr:hover {
            background-color: #e9e9e9;
        }
        
        a {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            text-align: center;
            width: 100px;
        }
        
        a:hover {
            background-color: #0056b3;
        }
        
        .no-data {
            font-style: italic;
            text-align: center;
        }
    </style>
</style>
</head>
<body>
	<%!List<Recharge> robj1 = null;%>

	<table>
		<%
  if(!session.isNew()){
    robj1=(List<Recharge>) session.getAttribute("transaction");
    if (robj1 != null && !robj1.isEmpty()) {
	for(Recharge r:robj1){
%>
		<tr  id="new">
			<td>Reg No:</td>
			<td><%=r.getRegNo()%></td>
		<tr>
			<td>Mob No:</td>
			<td><%=r.getMobNo() %>
		<tr>
			<td>Service Provider:</td>
			<td><%=r.getSer()%>
		<tr>
			<td>Recharge Amount:</td>
			<td><%=r.getRamt()%></td>
		</tr>
		<%

}
	}  else {
%>

		<tr>
			<td colspan="4">No transactions found.</td>
		</tr>
		<% }}
session.invalidate();%>
		<a href="Dashboard.jsp">Dashboard</a>
</body>
</html>