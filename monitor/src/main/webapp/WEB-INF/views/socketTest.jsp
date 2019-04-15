<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
</head>
<body>
<script type="text/javascript">
$(function(){
	if(!window.WebSocket){
		alert('웹 소켓을 지원하지 않는 브라우저 입니다.');
		return;
	}
	
	var socket = new WebSocket("ws://localhost:8080/start/echo");
	
	socket.onopen = function(){
		console.log('접속 성공'); 
		// 접속후 바로 데이터 전송 
		socket.send('Hello');
	}
	
	socket.close = function(){
		console.log('접속 해제');
	}
	
	socket.onmessage = function(msg){
		console.log('데이터 수신: ', msg.data);
		allMsg = $('#recv-message').html();
		allMsg = msg.data + '<br>' + allMsg;
		$('#recv-message').text(msg.data);
	}
	
	socket.onerror = function(err){
		console.log('에러', err);
	}
	
	$('#send-btn').click(function(){
		var msg = $('#send-message').val();
		socket.send(msg);
	})
})
</script>

<h1>웹 소켓 테스트</h1>

<div>
	전송 메시지:
	<input type="text" id="send-message">
	<button type="button" id="send-btn">전송</button>
</div>
<div>
	수신 메시지: <span id="recv-message"></span>
</div>
</body>
</html>