package edu.autocar.broker;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observer;

import org.springframework.stereotype.Component;

@Component
public class MjpegBroker {
	Map<Integer, List<Observer>> map = 
			Collections.synchronizedMap(new HashMap<>());
	
//	뷰가 호출함
	synchronized	//한 메서드를 하나의 트랜잭션을 본다
	public void addObserver(int deviceId, Observer observer) {
		List<Observer> list = map.get(deviceId);
		if(list == null) {
			list = new LinkedList<>(); 
			map.put(deviceId, list);
		}
		list.add(observer);
	}
	
//	null이 아닌 것만 observer에게 업데이트함 camera에서 호출
	synchronized
	public void update(int deviceId, byte[] image) {
		List<Observer> list = map.get(deviceId); 
		if(list != null) { 
			for(Observer observer : list) { 
				observer.update(null, image); 
			} 
		}
	}
	
// observer 탈퇴
	synchronized
	public void deleteObserver(int deviceId, Observer observer) {
		List<Observer> list = map.get(deviceId); 
		if(list != null) { 
			list.remove(observer); 
		} 
	}
}














