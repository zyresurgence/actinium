package com.zy.actinium.rabbitmq.provider.service;

import java.util.Map;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/27 16:54
 */
public interface SendMessageQueueService {

    /**
     * 发送消息
     * @param messageBody   消息体。
     */
    String sendMessageByDirectExchange(String messageBody);

    /**
     * 发送消息 由fanout交换机发送。
     * @param messageBody   消息体。
     * @return 发送消息结果
     */
    String sendMessageByFanoutExchange(String messageBody);

    /**
     * 发送消息 由topic交换机发送。
     * @param messageBody   消息体。
     * @param routingKey    路由路径
     * @return 发送消息结果
     */
    String sendMessageByTopicExchange(String messageBody,String routingKey);

    /**
     * 发送消息 由topic交换机发送。
     * @param messageBody   消息体。
     * @param map           消息头
     * @return 发送消息结果
     */
    String sendMessageByHeadersExchange(String messageBody, Map<String,Object> map);

}
