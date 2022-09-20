package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_DIRECT))
public class DirectExchangeConsumer {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
 
}