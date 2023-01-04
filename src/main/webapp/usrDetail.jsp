<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<%@ page import="java.util.List" %>    
<%@ page import="com.training.web.model.User" %> 
<%@ page session = "true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String user = (String)request.getAttribute("user");
out.print("Welcome "+user+" You are successfully logged in" );
out.print(session.getId());
//List<User> usrList = (List<User>)request.getAttribute("usrList");
//out.println("<table border='1'> ");
//out.println("<tr> <th>");
//out.println("Name </th>");
//out.println("<th> Password </th>");
%>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Password</th>
		
		<c:forEach items = "${usrList}" var = "user"> 
		  <tr>
			<td>${user.getUserName()}</td>
			<td>${user.getPassword()} </td>
		</tr>
		
		</c:forEach>
		
		<c:url value="/header.jsp" var="headUrl">
			<c:param name="userName" value="${user}"></c:param>
		</c:url>
		<a href="${headUrl}">Click here</a>
		
</table>

</body>
</html>


