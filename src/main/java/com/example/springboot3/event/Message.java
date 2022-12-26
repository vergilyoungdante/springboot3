package com.example.springboot3.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.event
 * @Author: vergil young
 * @CreateTime: 2022-12-26  14:33
 * @Description: TODO
 */
public class Message extends ApplicationEvent {

    private String message;
    private int times;

    public Message(String message,int times){
        super(message);
        this.message = message;
        this.times = times;
    }

    public Message(Object source, String message, int times) {
        super(source);
        this.message = message;
        this.times = times;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", times=" + times +
                "} " + super.toString();
    }
}
