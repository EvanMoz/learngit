package com.tencent.demo.config;

import com.tencent.demo.services.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {
    @Bean
    public HelloService helloService(){
        System.out.println("配置类给容器添加组件了");
        return new HelloService();
    }
}
