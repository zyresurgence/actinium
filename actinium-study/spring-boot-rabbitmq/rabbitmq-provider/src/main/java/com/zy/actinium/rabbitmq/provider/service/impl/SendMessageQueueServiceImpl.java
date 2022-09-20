package com.zy.actinium.rabbitmq.provider.service.impl;

import com.zy.actinium.rabbitmq.provider.constants.RabbitMessageQueueConstants;
import com.zy.actinium.rabbitmq.provider.service.SendMessageQueueService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/27 16:56
 */
@Service
public class SendMessageQueueServiceImpl implements SendMessageQueueService {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 使用direct 一对一交换机发送消息
     * @param messageBody   消息体。
     */
    @Override
    public String sendMessageByDirectExchange(String messageBody) {
        Map<String, Object> message = getMessage(messageBody);
        /**
         * 发送消息
         * exchange
         * RoutingKey
         * Message
         */
        try {
            CorrelationData correlationData = (CorrelationData) message.remove("correlationData");
            rabbitTemplate.convertAndSend(RabbitMessageQueueConstants.NAME_EXCHANGE_DIRECT,RabbitMessageQueueConstants.NAME_KEY_QUEUE_DIRECT,message,correlationData);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 使用 fanout exchange 一对多发送消息
     * @param messageBody   消息体。
     * @return
     */
    @Override
    public String sendMessageByFanoutExchange(String messageBody) {
        Map<String, Object> message = getMessage(messageBody);
        try {
            CorrelationData correlationData = (CorrelationData) message.remove("correlationData");
            rabbitTemplate.convertAndSend(RabbitMessageQueueConstants.NAME_EXCHANGE_FANOUT,"", message,
                    correlationData);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMessageByTopicExchange(String messageBody,String routingKey) {
        Map<String, Object> message = getMessage(messageBody);
        Message message1 = new Message(messageBody.getBytes());
        MessageProperties messageProperties = new MessageProperties();
        try {
            CorrelationData correlationData = (CorrelationData) message.remove("correlationData");
            messageProperties.setMessageId(correlationData.getId());
            rabbitTemplate.convertAndSend(RabbitMessageQueueConstants.NAME_EXCHANGE_TOPIC,routingKey,message1,correlationData);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String sendMessageByHeadersExchange(String messageBody, Map<String, Object> map) {

        try {
            String messageId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
            CorrelationData correlationData = new CorrelationData(messageId);
            MessageProperties messageProperties = new MessageProperties();
            //消息持久化
            messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            messageProperties.setContentType("UTF-8");
            //添加消息
            messageProperties.getHeaders().putAll(map);
            Message message = new Message(messageBody.getBytes(), messageProperties);
            rabbitTemplate.convertAndSend(RabbitMessageQueueConstants.NAME_EXCHANGE_HEADERS, null, message,
                    correlationData);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 封装消息体
     * @param messageBody   消息体
     * @return
     */
    private Map<String,Object> getMessage(String messageBody){
        String messageId = UUID.randomUUID().toString().replace("-", "").substring(0, 32);
        CorrelationData correlationData = new CorrelationData(messageId);
        String sendTime = sdf.format(new Date());
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("sendTime", sendTime);
        map.put("messageBody", messageBody);
        map.put("correlationData", correlationData);
        return map;
    }


}
