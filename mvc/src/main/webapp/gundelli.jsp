
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center; color:blue;">
<h2>Welcome babu yadav gundelli</h2>
	<c:forElach var="i" items="${data}">
		<h2>Firstname: ${i.firstname}</h2>
		<h2> lastname: ${i.lastname} </h2>
		<h2>email: ${i.email}</h2>
	</c:forElach><br>
	</body>
</html>