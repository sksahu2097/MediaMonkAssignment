package com.media.monk.websocket;

import com.sun.security.auth.UserPrincipal;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

/**
 * This class will generate a new UUID for all the user connecting to the websocket.
 * 
 * @author Santosh sahu.
 *
 */
public class UserHandShakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
            Map<String, Object> attributes) {
        return new UserPrincipal(UUID.randomUUID().toString());
    }

}
