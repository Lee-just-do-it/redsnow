package com.redsnow.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc web端 实时推送
 * @author lee
 */
@ServerEndpoint(value = "/ws/message/{userId}", encoders = {WebSocketEncoder.class})
@Slf4j
@Component
public class WebSocketSeverEndPoint {
    /**
     * 存活的session集合（使用线程安全的map保存）
     */
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    /**
     * 未发送出的消息
     */
    public static Map<String, Map<String,String>> unSensMessages = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String id) {
        livingSessions.put(id,session);
        Iterator<Map.Entry<String, Map<String, String>>> iterator = unSensMessages.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Map<String, String>> next = iterator.next();
            Map<String, String> nextValue = next.getValue();
            Iterator<Map.Entry<String, String>> iterator1 = nextValue.entrySet().iterator();
            while (iterator1.hasNext()){
                Map.Entry<String, String> next1 = iterator1.next();
                if(next1.getKey().equals(id)){
                    sendMessage(session,next1.getValue());
                    //移除已发送的消息
                    iterator1.remove();
                }
            }
            if(next.getValue().size() == 0){
                // 当前事件已全部发送 移除该事件
                iterator.remove();
            }
        }
        System.out.println("创建链接成功{}");
    }

    /**
     * 发送消息全都回执
     * @param msg 前端回传消息
     * @param session
     * @param id
     */
    @OnMessage
    public void onMessage(String msg, Session session, @PathParam("uderid") String id) {
        System.out.println("websocket-发送成功");
    }

    /**
     * 发送失败
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("websocket-发送失败{}");
    }

    /**
     * 客户端主动关闭链接
     * @param session
     * @param id
     */
    @OnClose
    public void onClose(Session session, @PathParam("userId") String id) {
        livingSessions.remove(id);
    }

    /**
     * 单独发送消息
     *
     * @param session
     * @param args 消息体
     */
    public void sendMessage(Session session, String args) {
        try {
            session.getBasicRemote().sendText(args);
        } catch (Exception e) {
            System.out.println("websocket错误{}");
        }
    }

    /**
     * 群发消息
     * userIds 需要接收消息的用户id集合 可单发，可群发
     *
     * @param args
     */
    public void sendMessageToAll(String args, String usrid) {
        Map<String,String> unSendsUsers = new ConcurrentHashMap<>(10);
        // 当前登陆的用户则发送消息，未登陆用户则缓存消息
            if(livingSessions.get(usrid) != null){
                sendMessage(livingSessions.get(usrid), args);
            }else{
                unSendsUsers.put(usrid, args);
            }
        unSensMessages.put(usrid, unSendsUsers);
    }
}
