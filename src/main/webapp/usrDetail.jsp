<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="com.training.web.model.User"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<c:out value="Welcome ${user} You are successfully logged in" />

	<table border="1">
		<tr>
			<th>Name</th>
			<th>Password</th>

			<c:forEach items="${usrList}" var="user">
				<tr>
					<td>${user.getUserName()}</td>
					<td>${user.getPassword()}</td>
				</tr>

			</c:forEach>

			<c:url value="/header.jsp" var="headUrl">
				<c:param name="userName" value="${user}"></c:param>
			</c:url>
			<a href="${headUrl}">Click here</a>
	</table>
	<c:set var="num" value="45321.56435" />
	Number after setting type attribute:
	<br />
	<fmt:formatNumber value="${num}" type="currency" /><br/>
	Number after setting maxIntegerDigit and maxFractionDigit type attribute:
	<br />
	<fmt:formatNumber value="${num}" type="number" maxIntegerDigits="4"
	maxFractionDigits="3" /><br/>
	Number after setting pattern attribute:
	<br />
	<fmt:formatNumber value="${num}" type="number" pattern="##,###.###"/><br/>
	Number after setting Integrals:
	<br />
	<fmt:parseNumber value="${num}" type="number" integerOnly = "true"/><br/>
	<c:set var="currentDate" value ="<%=new java.util.Date() %>"/>
	Today's Date:
	<br />
	<c:out value="${currentDate}"/><br/>
	Today's Date after formatting:
	<br />
	<fmt:formatDate value="${currentDate}" pattern="dd-MM-yyyy"/>
</body>
</html>


