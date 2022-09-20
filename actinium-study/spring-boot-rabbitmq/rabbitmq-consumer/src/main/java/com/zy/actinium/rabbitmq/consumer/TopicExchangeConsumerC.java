package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_C))
public class TopicExchangeConsumerC {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("队列[" + RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_C + "]收到消息：" + map.toString());
    }
}