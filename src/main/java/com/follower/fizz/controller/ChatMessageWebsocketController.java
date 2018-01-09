package com.follower.fizz.controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by lin on 18-1-9.
 */

@EnableWebMvc
@EnableWebSocket
@Configurable
public class ChatMessageWebsocketController extends WebMvcConfigurerAdapter
        implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        String[] allowsOrigins = {"*"};
        webSocketHandlerRegistry.addHandler(
                new WebSocketHandler() {
                    @Override
                    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
                        System.out.println("connection established");
                    }

                    @Override
                    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
                        System.out.println("hello receive chat message");
                    }

                    @Override
                    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

                    }

                    @Override
                    public boolean supportsPartialMessages() {
                        return false;
                    }
                },
                "/webSocketIMServer"
        ).setAllowedOrigins(allowsOrigins);
        //.addInterceptors(new WebsocketInterceptor());
    }
}
