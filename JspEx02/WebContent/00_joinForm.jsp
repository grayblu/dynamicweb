<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		사용자ID: <input type="text" name="userId" required="required" value="${member.userId}"><br>
		비밀번호: <input type="password" name="password" required="required"><br>
		이름: <input type="text" name="name" required="required" value="${member.name}"><br>
		이메일: <input type="text" name="email" value="${member.email}"><br>
		전화번호: <input type="text" name="tel" value="${member.tel}"><br>
		성별:
			<label><input type="radio" name="gender" value="M" >남</label>
			<label><input type="radio" name="gender" value="W" >여</label>
			<br>
		<input type="submit" value="가입하기"/>		 
	</form>
	
	
</body>
</html>