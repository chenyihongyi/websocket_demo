package com.websocket.demo.websocket_demo.controller.v5;

import com.websocket.demo.websocket_demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 8:56
 */
@Controller
public class V5StockInfoController {

    @Autowired
    private WebSocketService ws;

    /**
     * 股票推送controller
     *
     */
    //访问地址：localhost:8080/v5/index.html
/*    @Scheduled(fixedRate = 1000)
    public void stockInfo() {
        ws.sendStockInfo();

    }*/
}
