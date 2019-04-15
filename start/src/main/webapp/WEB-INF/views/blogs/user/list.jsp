<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<script>
//좋아요 수 증가 , location 이동
$(function(){
	$('h3').click(function(){
		var postId = $(this).attr('value');
		location = './view/'+postId;
	});
	
	$('h3').mouseover(function(){
		$(this).css("color","blue");
	});
	
	$('h3').mouseout(function(){
		$(this).css("color","black");
	});
})
</script>



<h2 class="my-5">
	<i class="fas fa-images"></i> ${blog.userId} 님의 블로그
</h2>

<div style="height:30px">
	<div class="float-left">
		<a href="../${blog.userId}/write"><i class="fas fa-plus"></i> 글쓰기</a>
	</div>
	<div class="float-right">((총 : ${blog.list.size()} 개의 블로그)</div>
</div>

<table class="table table-striped table-hover"
	style="text-align: center">
	<c:forEach var="blogpost" items="${blog.list}">
		<div>
			<p class="card-text">
				<img src="${contextPath}/member/avata/${blogpost.userId}"
					class="rounded-circle avata-sm"> ${blogpost.userId}
			</p>
			<h3 value = "${blogpost.postId}">${blogpost.title}</h3>
			<br />
			<div>
				${blogpost.content} <img
					src="${contextPath}/gallery/thumb/${blogpost.userId}">
			</div>
			<br /> <a href="#">read </a>${blogpost.readCnt} <a href="#">댓글</a></br>
			<fmt:formatDate value="${blogpost.regDate}" pattern="yyyy-MM-dd" />
			<hr />
		</div>
	</c:forEach>
</table>