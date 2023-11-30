package com.ecology.bbzy.socket;


import cn.hutool.core.util.ObjUtil;
import com.ecology.bbzy.logger.Logger;
import com.ecology.bbzy.service.UserService;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@ServerEndpoint(value = "/channel/echo/{token}")
public class EchoChannel implements ApplicationContextAware {  // 实现 ApplicationContextAware 接口， Spring 会在运行时注入 ApplicationContext


    // 全局静态变量，保存 ApplicationContext
    private static ApplicationContext applicationContext;

    private static Map<String, Session> sessionMap = new HashMap<>();
    private static Map<String, String> tokenId = new HashMap<>();

    private UserService userService;

    // 保存 Spring 注入的 ApplicationContext 到静态变量
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        EchoChannel.applicationContext = applicationContext;
    }

    // 收到消息
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        //session.getAsyncRemote().sendText("[" + Instant.now().toEpochMilli() + "] Hello " + message);
        //...... 根据消息内容调用对应服务处理
        //userService.addUser(tbAccount);
    }

    /**
     * 主动推动消息
     */
    public void sendMessage(String token, String message) {
        Session session = this.getSession(token);
        if (ObjUtil.isEmpty(session)) {
            Logger.warn("主动发送socket消息--用户未在线");
            return;
        }
        session.getAsyncRemote().sendText(message);
    }

    // 连接打开
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token, EndpointConfig endpointConfig) {
        // 保存 session 到对象
        this.setSession(token, session);

        // 连接创建的时候，从 ApplicationContext 获取到 Bean 进行初始化
        this.userService = EchoChannel.applicationContext.getBean(UserService.class);
        Logger.info("[websocket] 新的连接：token={},sessionId={}", token, session.getId());
    }

    // 连接关闭
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        Logger.info("[websocket] 连接断开：id={}，reason={}", session.getId(), closeReason);
        this.delSession(session.getId());
    }

    // 连接异常
    @OnError
    public void onError(Throwable throwable, Session session) throws IOException {
        Logger.info("[websocket] 连接异常：id={}，throwable={}", session.getId(), throwable.getMessage());
        // 关闭连接。状态码为 UNEXPECTED_CONDITION（意料之外的异常）
        session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, throwable.getMessage()));
    }

    private void setSession(String token, Session session) {
        tokenId.put(session.getId(), token);
        sessionMap.put(token, session);
    }

    private Session getSession(String token) {
        return sessionMap.get(token);
    }

    private void delSession(String id) {
        String token = tokenId.get(id);
        sessionMap.remove(token);
    }

}
