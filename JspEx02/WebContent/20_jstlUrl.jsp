<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/image/Koala.jpg" var="data">
		<c:param name="query">한글쿼리</c:param>
		<c:param name="keyword">코알라</c:param>
	</c:url>
	<h3>${data }</h3>
	<img src="${data }">
</body>
</html>