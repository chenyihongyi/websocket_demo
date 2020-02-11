package com.websocket.demo.websocket_demo.model;

import java.util.Date;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 3:22
 */
public class OutMessage {

    private String from;

    private String content;

    private Date time = new Date();

    public OutMessage(){}

    public OutMessage(String content){
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
