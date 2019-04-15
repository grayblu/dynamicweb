//package edu.autocar.view;
//
//import java.util.Map;
//import java.util.Observable;
//import java.util.Observer;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import edu.autocar.jpgSource.JpgImageSource;
//
//@Component("camera")
//@Scope("request")	// camera view 요청에서 대하여 각각의 인스턴스를 생성하여 1 스레드당 1 view로 함
//public class SingleCameraView extends MjpegView implements Observer{
//	@Autowired		// 타입으로 bean 검색, JpgImageSource 타입의 bean이 있는지 검색
//	JpgImageSource source; 
//	
//	// 큐를 리스트로 생성하고 5개로 선언(이미지가 들어가는 큐)
//	BlockingQueue<byte[]> queue = new LinkedBlockingQueue<>(5); 
//	
//	@Override protected void init(Map<String, Object> model, 
//					HttpServletResponse response) throws Exception { 
//		super.init(model, response);
//		
//		source.addObserver(this);
//	} 
//	
//	@Override protected byte[] getImage() throws Exception { 
//		// 큐에 들어가 있는 이미지를 꺼내고, 없으면 대기
//		return queue.take(); 
//	}
//
//	@Override
//	public void update(Observable o, Object image) {
//		try {
//			queue.put((byte[])image);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	protected void cleanup() throws Exception {
//		// TODO Auto-generated method stub
//		super.cleanup();
//		queue.clear();
//		source.deleteObserver(this);
//	}
//	
//	
//	
//}
