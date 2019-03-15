<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>서블릿</title>
</head>
<body>
	
	<form method="get" action="MethodServlet">
		<input type="text" name="id">
		<input type="text" name="age">
		<input type="submit" value="get 방식으로 호출하기">
	</form>
	<br>
	<br>
	<form method="post" action="MethodServelet">
		<input type="text" name="id">
		<input type="text" name="age">
		<input type="submit" value="post 방식으로 호출하기">
	</form>
</body>
</html>