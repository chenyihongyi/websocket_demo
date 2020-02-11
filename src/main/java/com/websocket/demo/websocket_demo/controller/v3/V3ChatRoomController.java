package com.websocket.demo.websocket_demo.controller.v3;

import com.websocket.demo.websocket_demo.model.InMessage;
import com.websocket.demo.websocket_demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 6:36
 */

/**
 * 简单版单人聊天
 */
@Controller
public class V3ChatRoomController {

    @Autowired
    private WebSocketService ws;

    @MessageMapping("/v3/single/chat")
    public void singleChat(InMessage message){
        ws.sendChatMessage(message);
    }

}
