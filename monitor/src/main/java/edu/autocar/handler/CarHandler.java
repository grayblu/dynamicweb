package edu.autocar.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import edu.autocar.domain.CarMessage;

public class CarHandler extends TextWebSocketHandler{
	
	Map<Integer, List<WebSocketSession>> map = Collections.synchronizedMap(new HashMap<>());
	Map<Integer, List<WebSocketSession>> map2 = Collections.synchronizedMap(new HashMap<>());
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionEstablished(session);
		System.out.println("연결 됬습니다");
//		list.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) 
																throws Exception {
		// TODO Auto-generated method stub
		String rcvMsg = message.getPayload();
		Gson gson = new Gson();
		
//		받은 메시지를 객체로 변환 
		CarMessage carMsg = gson.fromJson(rcvMsg, CarMessage.class);
		int target = carMsg.getTarget();
		System.out.println(target);
		if(carMsg.getMsgType().equals("POSITION_SUB")) {
			addObserver(target, session);
		}else if(carMsg.getMsgType().equals("POSITION")) {
			List<WebSocketSession> list = map.get(target);
			//System.out.println(target + "의 리스트 : " + list);
			if(list!=null) {
				for(WebSocketSession s: list) {
					s.sendMessage(message);
					System.out.println(message);
				}
			}
		}else if(carMsg.getMsgType().contentEquals("CONTROL")) {
//			addObserver2(target, session);
			List<WebSocketSession> list = map.get(target);
			//System.out.println(target + "의 리스트 : " + list);
			if(list!=null) {
				for(WebSocketSession s: list) {
					s.sendMessage(message);
					System.out.println(message);
				}
			}
		}
		
		/*
		 * System.out.println("메시지 수신: " + rcvMsg); TextMessage sendMsg = new
		 * TextMessage(rcvMsg); for(WebSocketSession s : list) { if(s!=session) {
		 * s.sendMessage(sendMsg); } }
		 */
		
	}
	
	private void addObserver2(int target, WebSocketSession session) {
		// TODO Auto-generated method stub
		List<WebSocketSession> list = map2.get(target);
		if(list==null) {
			list = new LinkedList<WebSocketSession>();
			map2.put(target, list);
		}
		list.add(session);
		System.out.println(list);
	}
	
	
	private void addObserver(int target, WebSocketSession session) {
		// TODO Auto-generated method stub
		List<WebSocketSession> list = map.get(target);
		if(list==null) {
			list = new LinkedList<WebSocketSession>();
			map.put(target, list);
		}
		list.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
		for (int target : map.keySet()) {
			List<WebSocketSession> list = map.get(target);
			if(list.remove(session))
				break;
		}
	}
	
}
