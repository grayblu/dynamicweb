<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--  스프링이 제공하는 태그라이브러리에 의해 커맨드 객체(member)와 폼 요소간 동기화가 이뤄짐 -->
<h2 class="my-5">
	<i class="fas fa-edit"></i> 회원 가입
</h2>
<form:form modelAttribute="member">
<!-- <form id="member" action="/tour/board/create" method="post">을 의미함 -->
	<div class="form-group">
		<label for="userId">아이디</label>
		<form:input path="userId" class="form-control" />
		<form:errors path="userId" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="password">비밀번호</label>
		<form:password path="password" class="form-control" />
		<form:errors path="password" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="name">이름</label>
		<form:input path="name" class="form-control" />
		<form:errors path="name" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="email">이메일</label>
		<form:input path="email" class="form-control"/>
	</div>
	
	<div class="form-group">
		<label for="phone">전화번호</label>
		<form:input path="phone" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="address">주소</label>
		<form:textarea path="address" class="form-control" rows="2"/>
	</div>
	
	<div class="text-center">
		<button type="submit" class="btn btn-primary ok">
			<i class="fas fa-check"></i> 완료
		</button>
		<button>
			<a href="list?page=${param.page}" class="btn btn-primary back">
			<i class="fas fa-undo"></i> 목록
			</a>
		</button>
	</div>
</form:form>

