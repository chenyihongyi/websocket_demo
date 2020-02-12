package com.websocket.demo.websocket_demo.controller.v2;

import com.websocket.demo.websocket_demo.model.InMessage;
import com.websocket.demo.websocket_demo.model.OutMessage;
import com.websocket.demo.websocket_demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 3:26
 */
@Controller
public class V2GameInfoController {

    @Autowired
    private WebSocketService ws;

    @MessageMapping("/v2/chat")
    public void gameInfo(InMessage message){
        ws.sendTopicMessage("/topic/game_rank", message);
    }


}
