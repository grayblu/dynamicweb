<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5">
			<i class="fas fa-hand-point-right"></i> 블로그 가입 신청
		</h2>
		<form:form modelAttribute="blog">
			<div class="form-group">
				<label for="userId">아이디</label> <input type="hidden" name="userId"
					value="${USER.userId}" />
				<p class="form-control-static">${USER.userId}</p>
			</div>
			<div class="form-group">
				<label for="title">블로그 제목</label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="description">블로그 설명</label>
				<form:input path="description" class="form-control" />
				<form:errors path="description" element="div" cssClass="error" />
			</div>

			<div class="text-center">
				<button type="submit" class="btn btn-primary">
					<i class="fas fa-check"></i> 완료
				</button>
				<a href="list?page=${param.page}" class="btn btn-primary back">
					<i class="fas fa-undo"></i> 목록
				</a>
			</div>
		</form:form>
	</div>
</div>