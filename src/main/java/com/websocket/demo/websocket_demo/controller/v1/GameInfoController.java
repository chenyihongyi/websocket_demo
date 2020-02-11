package com.websocket.demo.websocket_demo.controller.v1;

import com.websocket.demo.websocket_demo.model.InMessage;
import com.websocket.demo.websocket_demo.model.OutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 3:26
 */
@Controller
public class GameInfoController {

    @MessageMapping("/v1/chat")
    @SendTo("/topic/game_chat")
    public OutMessage gameInfo(InMessage message){
        return new OutMessage(message.getContent());
    }


}
