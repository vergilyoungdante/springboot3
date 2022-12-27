package com.example.springboot3.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.event
 * @Author: vergil young
 * @CreateTime: 2022-12-26  15:44
 * @Description: TODO
 */

@Component
@EnableScheduling
public class MessageAutoJob {
    private static int i=0;

    @Autowired
    private PublishService publishService;

    @Scheduled(fixedRate=10000)
    public void sendMessage(){
        publishService.register(new Message("are you ok?",i+1));
    }
}
