package com.ecology.bbzy.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        ServerEndpointExporter exporter = new ServerEndpointExporter();
        // 手动注册 WebSocket 端点
        //在 WebSocket 端点上添加 @Component 注解，使用 Spring 自动扫描，这样的话不需要
        // 手动调用 setAnnotatedEndpointClasses 方法进行注册
        //exporter.setAnnotatedEndpointClasses(EchoChannel.class);
        return exporter;
    }
}
