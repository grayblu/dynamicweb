<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="06_addition.jsp">
 	숫자1: <input type="text" name="num1"><br>	
 	숫자2: <input type="text" name="num2"><br>
 	${param.num1} + ${param.num2 } = ${param.num1 + param.num2}
 </form>
</body>
</html>