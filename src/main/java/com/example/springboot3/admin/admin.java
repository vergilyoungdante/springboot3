package com.example.springboot3.admin;

import org.springframework.boot.admin.SpringApplicationAdminMXBean;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.admin
 * @Author: vergil young
 * @CreateTime: 2022-12-26  20:09
 * @Description: spring远程管理相关内容
 */
public class admin implements SpringApplicationAdminMXBean {
    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public boolean isEmbeddedWebApplication() {
        return false;
    }

    @Override
    public String getProperty(String key) {
        return null;
    }

    @Override
    public void shutdown() {

    }
}
