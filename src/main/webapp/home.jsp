<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:import var="val" url="/demo.jsp"/>
    <c:out value = "${val}"/>
	<h1> Welcome ${requestScope.usrName}! </h1>
	
	<h2><c:out value="This is an example from jstl core" /></h2>
	<c:set var="url" value="http://mypage.com" />
	Before removing the url variable: <c:out value ="${url}" />
	<c:remove var="url"/>
	After removing the url variable: <c:out value ="${url}" />
	<c:catch var="exception">
		<% int x = 4/0; %>
	</c:catch>
	<c:if test = "${exception != null}">
		<p>Exception Occurred: ${exception}</p>
	</c:if>
	<c:set var="num" value="9" />
	<c:choose>
		<c:when test="${num >10 }">
			Number is greater than 10
		</c:when>
		<c:when test="${num == 10 }">
			Number is equal to 10
		</c:when>
		<c:otherwise>
			Number is less than 10
		</c:otherwise>
	
	</c:choose>
	
	<c:forEach var="i" begin="1" end ="10">
		<p><c:out value="${i *5}"></c:out></p>
	
	</c:forEach>
	
	<%--
	    out.print("Name of the generated servlet is: "+this.getServletInfo());
	--%>
</body>
</html>

