<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="pagination justify-content-center">
	<c:forEach var="ix" begin="1" end="${pi.totalPage }">
		<c:choose>
			<c:when test="${ix == pi.page}">
				<li class="page-item active">
					<a class="page-link" href="#">${ix }</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item">
					<a class="page-link" href="?page=${ix}">${ix }</a>
				</li>				
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>