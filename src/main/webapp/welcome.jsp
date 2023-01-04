<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			String userName = request.getParameter("uname");
			if (userName.equals("abc")){
				request.setAttribute("usrName", userName);
				//response.sendRedirect("home.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else{
				out.print("Wrong Credentials..");
				
			}
		%>
		

</body>
</html>