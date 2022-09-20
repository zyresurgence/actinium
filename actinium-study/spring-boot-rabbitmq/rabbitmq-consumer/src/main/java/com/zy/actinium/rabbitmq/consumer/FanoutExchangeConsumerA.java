package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/10/8 15:27
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_FANOUT_A))
public class FanoutExchangeConsumerA {

    @RabbitHandler
    public void process(Map message){
        System.out.println("FanoutReceiverA消费者收到消息  : " + message.toString());
    }
}
