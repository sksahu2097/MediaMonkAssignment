package com.media.monk.websocket;

import com.media.monk.model.Message;
import com.media.monk.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
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
	
    @Autowired
    public WebSocketMessageHandler (MessageService messageService) {
    	this.messageService = messageService;
        System.out.println("Obj created =>");
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // TODO Auto-generated method stub
//        super.afterConnectionEstablished(session);
        System.out.println("Connection Established");
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        // TODO Auto-generated method stub
//        super.afterConnectionClosed(session, status);
        System.out.println("Connection closed");
    }
    
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
            throws Exception {
        // TODO Auto-generated method stub
        //super.handleMessage(session, message);
        System.out.println("Handle Message => " + message.getPayload());
        String arr[] = message.getPayload().toString().split("=");
        
        messageService.insertMessage(new Message().setKey(arr[0].trim()).setValue(arr[1].trim()));
    }
    
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception)
            throws Exception {
        // TODO Auto-generated method stub
        //super.handleTransportError(session, exception);
        System.out.println("Transport Error");
    }
    
}
