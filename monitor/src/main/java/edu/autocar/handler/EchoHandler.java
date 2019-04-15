package edu.autocar.handler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler{
	
	List<WebSocketSession> list = 
			Collections.synchronizedList(new LinkedList<>());
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		System.out.println("연결 됬습니다");
		list.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) 
																throws Exception {
		// TODO Auto-generated method stub
		String rcvMsg = message.getPayload();
		System.out.println("메시지 수신: " + rcvMsg); 
		TextMessage sendMsg = new TextMessage(rcvMsg); 
		for(WebSocketSession s : list) { 
			if(s!=session) {
					s.sendMessage(sendMsg); 
			} 
		}
		 
		
	}
	

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		System.out.println("연결이 끊겼습니다.");
	}
	
}
