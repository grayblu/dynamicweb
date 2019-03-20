<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${contextPath}/resources/js/member.js"></script>
<script>
$(function(){
	$('.id-check').checkUserId() // 사용자 ID 중복 체크 플러그인
	$('#member').checkPassword() // 비밀번호 일치 체크 플러그인
})
</script>
<!--  스프링이 제공하는 태그라이브러리에 의해 커맨드 객체(member)와 폼 요소간 동기화가 이뤄짐 -->
<h2 class="my-5">
	<i class="fas fa-edit"></i> 회원 가입
</h2>
<form:form modelAttribute="member">
<!-- <form id="member" action="/tour/board/create" method="post">을 의미함 -->
	<div class="form-group">
		<label for="userId">사용자 ID
		<button type="button"
		class="btn btn-primary btn-sm id-check">
			<i class="fas fa-user-check"></i>
			중복 체크</button>
			<span id="message"></span>
		</label>
		<form:input path="userId" class="form-control" />
		<form:errors path="userId" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="password">비밀번호</label>
		<form:password path="password" class="form-control" />
		<form:errors path="password" element="div" cssClass="error" />
	</div>
	<!-- 비번 확인을 확인 라벨 추가-->
	<div class="form-group">
		<label for="password2">비밀번호 확인</label> <input type="password"
			id="password2" class="form-control" />
	</div>
	<div class="form-group">
		<label for="name">이름</label>
		<form:input path="name" class="form-control" />
		<form:errors path="name" element="div" cssClass="error" />
	</div>
	<!-- for each를 통해 배열에 해당하는 값을 items에 의해 꺼냄 -->
	<div class="form-group">
		<label for="userLevel">사용자 레벨</label>
		<form:select path="userLevel" class="form-control"
			items="${userLevels}" />
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
		<button type="submit" class="btn btn-primary" disabled>
			<i class="fas fa-check"></i> 완료
		</button>
			<a href="list?page=${param.page}" class="btn btn-primary back">
			<i class="fas fa-undo"></i> 목록
			</a>
	</div>
</form:form>

