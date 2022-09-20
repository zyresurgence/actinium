package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_B))
public class TopicExchangeConsumerB {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("队列[" + RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_B + "]收到消息：" + map.toString());
    }
}