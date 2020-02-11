package com.websocket.demo.websocket_demo.model;

import java.util.Date;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 3:18
 */
public class InMessage {

    private String from;

    private String to;

    private String content;

    private Date time;

    public InMessage(){}

    public InMessage(String content){
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
