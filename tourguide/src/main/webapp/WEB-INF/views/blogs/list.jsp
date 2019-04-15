<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<h2 class="my-5">
	<i class="fas fa-blog"></i> 블로그 목록
</h2>
<div style="height:30px">
	<div class="float-left">
		<a href="create?page=${pi.page}"><i class="fas fa-plus"></i> 새 블로그 만들기</a>
	</div>
	<div class="float-right">(총 : ${pi.totalCount} 개의 블로그)</div>
</div>

<div class="row my-3">
	<c:forEach var="blog" items="${pi.list}">
		<div class="col-md-4 my-3">
			<div class="card w-100">
				<div class="text-center">
					<img class="card-img-top rounded-circle mt-3" style="width:180px"
						src="${contextPath}/member/avata/${blog.userId}">
				</div>
				<div class="card-body">
					<p class="float-right">
						<i class="far fa-heart text-danger"></i> ${blog.goodCnt}
					</p>
					<h4 class="card-title">
						${blog.userId} <span class="badge badge-pill badge-success">
							${blog.list.size()}</span>
					</h4>
					<h5 class="card-title text-center">
					${blog.title}
					</h5>
					<p class="card-text text-center">
					${blog.description}
					</p>
					<p class="card-text text-center">
						 생성 날짜 : 
						<fmt:formatDate value="${blog.regDate}" pattern="yyyy-MM-dd" />
					</p>
					<p class="card-text text-right">
					<a href="${blog.userId}/list">블로그로 이동 <i class="fas fa-arrow-circle-right"></i></a>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<iot:pagination pageInfo="${pi}" />