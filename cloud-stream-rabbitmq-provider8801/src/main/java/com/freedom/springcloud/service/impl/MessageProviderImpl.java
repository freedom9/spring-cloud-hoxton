package com.freedom.springcloud.service.impl;

import com.freedom.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author freedom
 * @date 2020/5/10 18:05
 */
// 定义消息的推送管道
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    // 消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        log.info("serial: {}" , serial);
        output.send(MessageBuilder.withPayload(serial).build());
    }
}
