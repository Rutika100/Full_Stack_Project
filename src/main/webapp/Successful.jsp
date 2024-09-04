<%@page import="com.model.Recharge"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Recharge Succesfully</h2>
<%List<Recharge> robj1; %>

<table>
<%
if(!session.isNew()){
	robj1=(List<Recharge>)request.getAttribute("success");
	Recharge robj=robj1.get(0);
%>
<tr><td>Reg No:</td><td><%=robj.getRegNo()%></td>
<tr><td>Mob No:</td><td><%=robj.getMobNo() %>
<tr><td>Service Provider:</td><td><%=robj.getSer()%>
<tr><td>Recharge Amount:</td><td><%=robj.getRamt()%></td></tr>
<%

}
session.invalidate();%>
<a href="Dashboard.jsp">Dashboard</a>
</table>
</body>
</html>