package com.websocket.demo.websocket_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.List;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 3:35
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    //注册端点，发布或者订阅消息的时候需要连接此端点
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint-websocket").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 配置消息代理(中介转发)
     * enableSimpleBroker 服务端推送给客户端的路径前缀
     * setApplicationDestinationPrefixes 客户端发送数据给服务端的一个前缀
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       registry.enableSimpleBroker("/topic", "/chat");
       registry.setApplicationDestinationPrefixes("/app");
    }

}