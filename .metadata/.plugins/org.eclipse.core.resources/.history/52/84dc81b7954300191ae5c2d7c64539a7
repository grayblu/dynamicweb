<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String[] files = (String[])request.getAttribute("files");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("06_application.jsp");
	String serverInfo = application.getServerInfo();
%>
	웹 애플리케이션의 컨텍스트 패스명<br>
	<b><%=appPath%></b><hr>
	웹 애플리케이션의 파일 경로명<br>
	<b><%=filePath%></b><hr>
	컨테이너의 이름과 버전 변환<br>
	<b><%=serverInfo%></b><hr>
	이미지 파일 목록<br>
	<% for(String file: files){ %>
	<img alt="" src="<%=application.getContextPath()%>/image/<%=file%>" width="400"/><br>
	<% }%>

</body>
</html>