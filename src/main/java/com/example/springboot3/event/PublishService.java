package com.example.springboot3.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.event
 * @Author: vergil young
 * @CreateTime: 2022-12-26  14:37
 * @Description: TODO
 */
@Service
public class PublishService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public boolean register(Message message){
        System.out.println("发送信息:"+ message.toString());
        applicationEventPublisher.publishEvent(message);
        return true;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
