<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>    
<%@ page import="com.training.web.model.User" %>  
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
List<User> usrList = (List<User>)request.getAttribute("usrList");
//out.println("<table border='1'> ");
//out.println("<tr> <th>");
//out.println("Name </th>");
//out.println("<th> Password </th>");
%>
<table border="1">
	<tr>
		<th>Name</th>
		<th>Password</th>
		<%
		for(User usr:usrList) { %>
		<tr>
			<td><%=usr.getUserName() %> </td>
			<td><%=usr.getPassword() %> </td>
		</tr>	
		
		<% } %>
	
</table>

</body>
</html>