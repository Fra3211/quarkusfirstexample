package com.example.undertowwebsockets;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@ServerEndpoint(value = "/chat/{username}")
public class ChatSocket {

    private final ConcurrentHashMap<String, Session> stringSessionConcurrentHashMap = new ConcurrentHashMap<String, Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username){
        stringSessionConcurrentHashMap.put(username, session);
        sendMessage(String.format("User %s logged in", username));
    }

    @OnMessage
    public void onMessage(String message, @PathParam("username") String username){
        sendMessage(String.format(">> %s; %s", username, message));
    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        stringSessionConcurrentHashMap.remove(username);
        sendMessage(String.format("User %S logged out", username));
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username, Throwable throwable){
        stringSessionConcurrentHashMap.remove(username);
        throwable.printStackTrace();
        sendMessage(String.format("User %s logged out because on a error", username));
    }

    public void sendMessage(String message){
        stringSessionConcurrentHashMap.values().forEach(value -> {
            value.getAsyncRemote().sendObject(message, result -> {
                if(result.getException() != null) {
                    result.getException().printStackTrace();
                }
            });
        });
    }
}
