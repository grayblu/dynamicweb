<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2 class="my-5"><i class="fas fa-list"></i> 게시글 목록</h2>
	<div class="text-right">
		<a href="create"><i class="fas fa-edit"></i> 글쓰기</a>
		(총: ${pi.totalCount} 건)
	</div>
	<table class="table table-striped table-hover">
		<tr>
			<th>No</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach var="board" items="${pi.list}">
			<tr>
				<td>${board.boardId}</td>
				<td>
					<a href="view/${board.boardId}?page=${pi.page}">
						${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.readCnt}</td>
				<td><fmt:formatDate value="${board.regDate}"
										   pattern="yyyy-MM-dd" /></td>
				
			</tr>
		</c:forEach>
	</table>
	<iot:pagination pageInfo="${pi}"/>
</div>
</body>
</html>