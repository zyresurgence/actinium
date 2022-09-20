package com.zy.actinium.rabbitmq.consumer;

import com.zy.actinium.rabbitmq.consumer.constants.RabbitMessageQueueConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicExchangeConsumerA {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicExchangeConsumerA.class);

    enum Action{
        SUCCESS,
        RETRY,
        REJECT
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_A),containerFactory = "rabbitListenerContainerFactory")
    public void process(Message message, Channel channel) throws Exception {
        long tag = message.getMessageProperties().getDeliveryTag();
        LOGGER.info("tag:{}",tag);
        String msg = new String(message.getBody());
        Action action = Action.SUCCESS;
        try {
            LOGGER.info("consumer TopicExchangeConsumerA accept message success:{} ", msg);
            ObjectMapper objectMapper = new ObjectMapper();
            Map map = objectMapper.readValue(msg, Map.class);
            String str = map.get("msg").toString();
            if ("bad".equals(str)) {
                throw new IllegalArgumentException("throw retry exception");
            }
            if ("error".equals(str)) {
                throw new Exception("throw reject exception");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            action = Action.RETRY;
        } catch (Exception e) {
            e.printStackTrace();
            action = Action.REJECT;
        }finally {
            try {
                if (action == Action.SUCCESS) {
                    //multiple 消息是否批处理，true标识处理比tag小的所有的消息，false测处理当前消息。
                    channel.basicAck(tag,false);
                }
//                if (action == Action.RETRY) {
//                    //拒绝策略 消息重回队列。 会死循环。
//                    channel.basicNack(tag,false,true);
//                }
                if (action == Action.REJECT) {
                    //拒绝策略 并且从队列删除。
                    channel.basicNack(tag,false,false);
                }
                channel.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}