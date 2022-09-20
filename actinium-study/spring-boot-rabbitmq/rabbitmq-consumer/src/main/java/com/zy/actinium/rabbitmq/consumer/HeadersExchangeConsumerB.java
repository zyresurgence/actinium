package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeadersExchangeConsumerB {
    @RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_HEADERS_B))
    public void process(Message message) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        System.out.println("队列[" + RabbitMessageQueueConstants.NAME_QUEUE_HEADERS_B + "]收到消息：" + new String(message.getBody(), contentType));
    }
}