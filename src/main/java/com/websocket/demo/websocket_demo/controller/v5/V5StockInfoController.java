package com.websocket.demo.websocket_demo.controller.v5;

import com.websocket.demo.websocket_demo.service.WebSocketService;
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

private WebSocketService ws;

    /**
     * 股票推送controller
     */
    @MessageMapping("/v5/schedule/push_stock")
    @Scheduled(fixedRate = 5000)
    public void stockInfo() {
        ws.sendStockInfo();

    }
}
