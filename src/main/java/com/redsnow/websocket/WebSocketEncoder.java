package com.redsnow.websocket;

import com.alibaba.fastjson.JSON;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @desc 转码器
 *       Encoder.Text<String> String 自定义为 anyType
 * @author lee
 */
public class WebSocketEncoder implements Encoder.Text<String>{

    @Override
    public String encode(String s){
        return JSON.toJSONString(s);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {}

    @Override
    public void destroy() {

    }
}
