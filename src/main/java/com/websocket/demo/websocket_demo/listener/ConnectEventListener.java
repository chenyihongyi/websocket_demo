package com.websocket.demo.websocket_demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 6:16
 */
@Component
public class ConnectEventListener implements ApplicationListener<SessionConnectedEvent> {

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
       StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("[ConnectEventListener监听器事件 类型]" +headerAccessor.getCommand().getMessageType());
    }

}
