package com.zy.actinium.rabbitmq.provider.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * TODO
 *  RabbitMessageQueue消息确认监听类。
 * @author Neo
 * @version 1.0.0
 * @date 2021/10/9 9:54
 */
@Component
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitConfirmCallback.class);

    /**
     *  监听消息是否到达Exchange。
     * @param correlationData   包含消息的唯一标识对象。
     * @param ack               true标识ack,false标识lack。
     * @param cause             lack投递失败的原因。
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            LOGGER.info("send message success,id:{}", correlationData.getId());
        } else {
            LOGGER.error("send message fail,id:{},cause:{}",correlationData.getId(),cause);
        }
    }

    /**
     * 监听发送消息到队列失败的返回消息体。
     * @param returned  发送失败消息体。
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        LOGGER.info("send message to queue fail,get return message.");

        Message message = returned.getMessage();
        String exchange = returned.getExchange();
        int replyCode = returned.getReplyCode();
        String replyText = returned.getReplyText();
        String routingKey = returned.getRoutingKey();

        LOGGER.info("message body: {}",new String(message.getBody()));
        LOGGER.info("replyCode: {}", replyCode);
        LOGGER.info("replyText: {}", replyText);
        LOGGER.info("exchange: {}", exchange);
        LOGGER.info("routingKey: {}", routingKey);
        LOGGER.info("------------> end <------------");
    }
}
