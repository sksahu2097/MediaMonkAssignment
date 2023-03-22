package com.media.monk.websocket;

import com.media.monk.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	MessageService messageService;
	
    private String ENDPOINT = "/ws/message";
    private Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addHandler(new WebSocketMessageHandler(messageService), ENDPOINT)
        .setHandshakeHandler(new UserHandShakeHandler())
        .setAllowedOriginPatterns("*")
        .addInterceptors(new HttpSessionHandshakeInterceptor());
        logger.info("registory done!!! = {} ", ENDPOINT);

    }

    @Bean
    ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(256_000);
        container.setMaxBinaryMessageBufferSize(256_000);
        container.setAsyncSendTimeout(2_678_400_000L);
        container.setMaxSessionIdleTimeout(2_678_400_000L);
        return container;
    }

}
