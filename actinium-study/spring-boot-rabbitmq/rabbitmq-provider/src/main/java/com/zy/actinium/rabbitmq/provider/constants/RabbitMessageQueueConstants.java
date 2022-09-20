package com.zy.actinium.rabbitmq.provider.constants;

/**
 * TODO
 *  消息队列常量。
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/27 14:12
 */
public class RabbitMessageQueueConstants {

    /**
     * 队列名。
     */
    public static final String NAME_QUEUE_DIRECT = "mail.queue.direct.demo";
    public static final String NAME_QUEUE_FANOUT_A = "mail.queue.fanout.demo.a";
    public static final String NAME_QUEUE_FANOUT_B = "mail.queue.fanout.demo.b";
    public static final String NAME_QUEUE_TOPIC_A = "mail.queue.topic.demo.a";
    public static final String NAME_QUEUE_TOPIC_B = "mail.queue.topic.demo.b";
    public static final String NAME_QUEUE_TOPIC_C = "mail.queue.topic.demo.c";
    public static final String NAME_QUEUE_HEADERS_A = "mail.queue.headers.demo.a";
    public static final String NAME_QUEUE_HEADERS_B = "mail.queue.headers.demo.b";

    /**
     * 交换机名。
     */
    public static final String NAME_EXCHANGE_DIRECT = "mail.exchange.direct.demo";
    public static final String NAME_EXCHANGE_FANOUT = "mail.exchange.fanout.demo";
    public static final String NAME_EXCHANGE_TOPIC = "mail.exchange.topic.demo";
    public static final String NAME_EXCHANGE_HEADERS = "mail.exchange.headers.demo";

    /**
     * 路由名。
     */
    public static final String NAME_KEY_QUEUE_DIRECT = "mail.routing.direct.demo";

}
