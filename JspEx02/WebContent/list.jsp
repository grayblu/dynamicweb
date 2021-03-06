<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="my-5"><i class="fas fa-users"></i> 회원목록</h2>
		<div class="text-right">
			(총: ${pi.totalCount} 건)
		</div>	
		<table class="table table-striped table-hover">
			<tr>
			  <th>No</th>
			  <th>Id</th>
			  <th>name</th>
			  <th>email</th>
			  <th>tel</th>
			  <th>date</th>
			</tr>
  		    <fmt:formatDate var="now" value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd" />
			<c:forEach var="m" items="${pi.list}" varStatus="status">
				<fmt:formatDate var="regdato" value="${m.regDate}" pattern="yyyy-MM-dd"/>
				<tr>
				  <td>${(pi.page-1)*pi.perCount + 1 + status.index}</td>
				  <td>${m.userId}
	  				 <c:if test="${regdato==now}">
	  				 	<span class="badge badge-danger">
		  				 	<i class="fas fa-bolt">new</i>
	  				 	</span>
	  				 </c:if></td>
				  <td>${m.name}</td>
				  <td>${m.email}</td>
				  <td>${m.tel}</td>
				  <td>${regdato}</td>
				</tr>		
			</c:forEach>  
		</table>
	</div>
	<jsp:include page="/common/pagination.jsp" />
</body>
</html>



















