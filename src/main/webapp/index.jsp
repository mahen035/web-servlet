<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <h1>Hello from Web Application!</h1>
    	<form action="<%=request.getContextPath() %>/welcomeServlet" method="post">
	    	<input type = "text" name = "uname" placeholder = "Enter username"/><br><br>
	    	<input type = "password" name = "pwd" placeholder = "Enter Password"/><br><br>
	    	<input type = "submit" value = "LogIn"/><br><br>
   	    </form>
        <a href="<%=request.getContextPath() %>/home">click here to login</a><br><br>
        <a href="<%=request.getContextPath() %>/about">About Us</a>
</body>
</html>