package com.media.monk.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.media.monk.model.Message;
import com.media.monk.service.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/**
 * This class will handle the message received over the websocket.
 * @author Santosh Sahu.
 *
 */
public class WebSocketMessageHandler extends TextWebSocketHandler {
    
	
	private MessageService messageService;
	private Logger logger = LoggerFactory.getLogger(WebSocketMessageHandler.class);
	
    public WebSocketMessageHandler (MessageService messageService) {
    	this.messageService = messageService;
        System.out.println("Obj created =>");
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
//        super.afterConnectionEstablished(session);
        logger.info("Connection Established");
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        // TODO Auto-generated method stub
//        super.afterConnectionClosed(session, status);
        logger.info("Connection closed");
    }
    
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		// super.handleMessage(session, message);
		logger.info("Message Recevied {} ", message.getPayload());
		if (message.getPayload().toString() == null || message.getPayload().toString() == ""
				|| message.getPayload().toString().split("=").length < 2) {
			session.sendMessage(new TextMessage(
					new ObjectMapper().writeValueAsString("Invalid message allowed format => key=value")));
		} else {
			String arr[] = message.getPayload().toString().split("=");

			messageService.insertMessage(new Message().setKey(arr[0].trim()).setValue(arr[1].trim()));
		}

	}
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception)
            throws Exception {
        // TODO Auto-generated method stub
        //super.handleTransportError(session, exception);
        logger.error("Transport error occurred ", exception);
    }
    
}
