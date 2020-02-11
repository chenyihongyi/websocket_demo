package com.websocket.demo.websocket_demo.service;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 5:42
 */

import com.websocket.demo.websocket_demo.model.InMessage;
import com.websocket.demo.websocket_demo.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 简单消息模板，用来推送消息
 */
@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendTopicMessage(String dest, InMessage message) {
        for (int i = 0; i < 20; i++) {
            template.convertAndSend(dest,new OutMessage(message.getContent()) + "" + i);
        }

    }

    public void sendChatMessage(InMessage message) {
        template.convertAndSend("/chat/single/"+message.getTo(), new OutMessage(message.getFrom()+ "发送:"+ message.getContent()));
    }

    /**
     * 获取系统信息,推送给客户端
     */
    public void sendServerInfo() {

        int processors = Runtime.getRuntime().availableProcessors();

        Long freeMem = Runtime.getRuntime().freeMemory();

        Long maxMem = Runtime.getRuntime().maxMemory();

        String message = String.format("服务器可用处理器:%s; 虚拟机空闲内容大小:%s; 最大内存大小: %s;", processors, freeMem, maxMem);

        template.convertAndSend("/topic/server_info", new OutMessage(message));
    }
}
