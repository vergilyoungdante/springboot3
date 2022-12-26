package com.example.springboot3.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.event
 * @Author: vergil young
 * @CreateTime: 2022-12-26  15:56
 * @Description: TODO
 */
@Component
public class BEventListener implements ApplicationListener<Message> {
    @Override
    public void onApplicationEvent(Message event) {
        System.out.println("B收到信息:" + event);
    }
}
