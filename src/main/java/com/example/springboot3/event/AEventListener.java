package com.example.springboot3.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.event
 * @Author: vergil young
 * @CreateTime: 2022-12-26  15:36
 * @Description: TODO
 */

@Component
public class AEventListener {

    @EventListener
    public void listener(Message message){
        System.out.println("A收到信息:" + message);
    }
}
