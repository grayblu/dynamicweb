package edu.autocar.webSocketConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import edu.autocar.handler.CarHandler;
import edu.autocar.handler.EchoHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(echoHandler(), "/echo");
		registry.addHandler(carHandler(), "/car");
	}
	
	@Bean
	public WebSocketHandler echoHandler() {
		return new EchoHandler();
	}
	
	@Bean
	public WebSocketHandler carHandler() {
		return new CarHandler();
	}
}
