package com.websocket.demo.websocket_demo.service;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 5:42
 */

import com.websocket.demo.websocket_demo.controller.v5.StockService;
import com.websocket.demo.websocket_demo.controller.v6.User;
import com.websocket.demo.websocket_demo.model.InMessage;
import com.websocket.demo.websocket_demo.model.OutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 简单消息模板，用来推送消息
 */
@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    public void sendTopicMessage(String dest,InMessage message) {
        for (int i = 0; i < 20; i++) {
            template.convertAndSend(dest,new OutMessage(message.getContent()) + "" + i);
        }

    }

    public void sendChatMessage(InMessage message) {
        template.convertAndSend("/chat/single/" + message.getTo(),new OutMessage(message.getFrom() + "发送:" + message.getContent()));
    }

    /**
     * 获取系统信息,推送给客户端
     */
    public void sendServerInfo() {

        int processors = Runtime.getRuntime().availableProcessors();

        Long freeMem = Runtime.getRuntime().freeMemory();

        Long maxMem = Runtime.getRuntime().maxMemory();

        String message = String.format("服务器可用处理器:%s; 虚拟机空闲内容大小:%s; 最大内存大小: %s;",processors,freeMem,maxMem);

        template.convertAndSend("/topic/server_info",new OutMessage(message));
    }

    /**
     * 股票信息推送
     */
    public void sendStockInfo() {

        Map<String, String> stockInfoMap = StockService.getStockInfo();
        String msgTpl = "名称: %s ; 价格: %s元 ; 最高价: %s ; 最低价: %s ; 涨跌幅: %s ; 市盈率TTM: %s ; 总市值: %s";

        if (null != stockInfoMap) {
            String msg = String.format(msgTpl,stockInfoMap.get("prod_name"),stockInfoMap.get("last_px"),stockInfoMap.get("high_px"),stockInfoMap.get("low_px"),stockInfoMap.get("px_change"),stockInfoMap.get("market_value"),stockInfoMap.get("amplitude"));

            template.convertAndSend("/topic/stock_info",new OutMessage(msg));
        }
    }

    /**
     * 发送在线用户
     * @param onlineUser
     */
    public void sendOnlineUser(Map<String, User> onlineUser) {
        String msg = "";
        for (Map.Entry<String, User> entry : onlineUser.entrySet()) {
            msg = msg.concat(entry.getValue().getUsername() + "||");
        }
        template.convertAndSend("/topic/onlineuser", msg);
    }

    /**
     * 用于多人聊天
     * @param message
     */
    public void sendTopicChat(InMessage message) {
        String msg = message.getFrom() + "发送:"+message.getContent();
        template.convertAndSend("/topic/chat", new OutMessage(msg));
    }
}