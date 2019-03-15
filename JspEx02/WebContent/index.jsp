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

<h1> 첫 페이지.</h1>
<c:choose>
	<c:when test="${not empty id}">
		${id}(${name}) |
		<a href="logout">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="login">로그인</a>
		<a href="join">회원가입</a>
	</c:otherwise>
</c:choose>

</body>
</html>