package com.example.springboot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: springboot3
 * @BelongsPackage: com.example.springboot3.config
 * @Author: vergil young
 * @CreateTime: 2023-01-05  11:07
 * @Description: 跨域配置
 */

@Configuration(proxyBeanMethods = false)
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        //是否允许发放cookie信息，设置成true会报错
                        .allowCredentials(false)
                        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                        .maxAge(3600);
            }

        };
    }
}
