<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
	 포스팅 글의 대한 view 입니다.<br>
	 
	 출력 테스트 : <br>
	 ${post.title}<br>
	 ${post.content}<br>
	 ${post.regDate}<br>
	 ${post.readCnt}<br>
	
	<div id="delete-panel" style="display: none"></div>
	<div class="text-center">
		<a href="../edit/${post.postId}"
		class="btn btn-primary text-white"><i class="fas fa-edit"></i> 수정</a>

		<button class="btn btn-danger delete">
			<i class="fas fa-trash"></i> 삭제
		</button>
		<a href="../list" class="btn btn-primary text-white">
			<i class="fas fa-undo"></i> 목록
		</a>
	</div>
</div>