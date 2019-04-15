<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic+Coding" rel="stylesheet">
<style>
	header {
			font-family: 'Nanum Gothic Coding', monospace;
			
}
</style>
<header class="jumbotron" style="background-image: url('${contextPath}/resources/img/home-bg.jpg');
								background-size: cover;">

	<div class="overlay"></div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto" style="text-align: center;">
				<div class="site-heading">
					<h1>Blog</h1>
					<span class="subheading">${blog.userId}'s blog</span>
				</div>
			</div>
		</div>
	</div>
</header>