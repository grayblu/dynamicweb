package edu.autocar.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public interface WebSocketHandler {
	// 접속 성공시 호출 
	void afterConnectionEstablished(WebSocketSession session) throws Exception; 
	// 메시지 수신시 호출 
	void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception; 
	// 전송 에러 발생시 호출 
	void handleTransportError(WebSocketSession session, Throwable exception) throws Exception; 
	// 접속 해제시 호출 
	void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception; 
	
	boolean supportsPartialMessages();

	
}
