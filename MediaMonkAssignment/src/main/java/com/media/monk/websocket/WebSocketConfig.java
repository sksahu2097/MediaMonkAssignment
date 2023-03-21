package com.media.monk.websocket;

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

    private String ENDPOINT = "/ws/message";
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addHandler(new WebSocketMessageHandler(), ENDPOINT)
        .setHandshakeHandler(new UserHandShakeHandler())
        .setAllowedOriginPatterns("*")
        .addInterceptors(new HttpSessionHandshakeInterceptor());
        //System.out.println("registory done!!! "+ ENDPOINT);

    }
    
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(256_000);
        container.setMaxBinaryMessageBufferSize(256_000);
        container.setAsyncSendTimeout(2_678_400_000L);
        container.setMaxSessionIdleTimeout(2_678_400_000L);
        return container;
    }

}
