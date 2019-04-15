<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script
	src="${contextPath}/resources/bower_components/tinymce/tinymce.min.js"></script>

<script>
	$(function() {
		tinymce.init({
			selector : 'textarea',
			height : 500
		});
	})
</script>


<form:form modelAttribute="post">
	<div class="form-group">
		<form:input type="hidden" path="userId" value="${USER.userId}" />
	</div>
	<div class="form-group">
		<label for="title">제목</label>
		<form:input path="title" class="form-control" />
		<form:errors path="title" element="div" cssClass="error" />
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<form:textarea path="content" class="form-control" rows="10" />
	</div>
	<div class="text-center">
		<button type="submit" class="btn btn-primary ok">
			<i class="fas fa-check"></i> 완료
		</button>
		<a href="list" class="btn btn-primary back"> <i
			class="fas fa-undo"></i> 취소
		</a>
	</div>
</form:form>