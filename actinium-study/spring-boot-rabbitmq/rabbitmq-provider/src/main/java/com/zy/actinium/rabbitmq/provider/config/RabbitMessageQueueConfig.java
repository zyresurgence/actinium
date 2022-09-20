package com.zy.actinium.rabbitmq.provider.config;

import com.zy.actinium.rabbitmq.provider.callback.RabbitConfirmCallback;
import com.zy.actinium.rabbitmq.provider.constants.RabbitMessageQueueConstants;
import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *  队列配置。
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/27 14:06
 */
@Configuration
public class RabbitMessageQueueConfig {

    @Autowired
    private RabbitConfirmCallback rabbitConfirmCallback;
    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(rabbitConfirmCallback);
        rabbitTemplate.setReturnsCallback(rabbitConfirmCallback);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     *  配置Direct队列。
     *  Direct 一对一 点对点发送。
     * @return
     */
    @Bean
    Queue directQueue(){

        /*
         * name         队列名。
         * durable      是否持久化。
         * exclusive    是否独享排外，设置为true则只有创建者可以使用。默认false
         * autoDelete   是否自动删除，设置为true则表示为临时队列，当最后一个消费者断开连接，自动删除。 默认false
         * arguments    其它配置
         *      x-message-ttl                发送到队列的消息在丢弃之前可以存活多长时间（毫秒）。
         *      x-expires                    队列在被自动删除（毫秒）之前可以使用多长时间。
         *      x-max-length                 队列在开始从头部删除之前可以包含多少就绪消息。
         *      x-max-length-bytes           队列在开始从头部删除之前可以包含的就绪消息的总体大小。
         *      x-dead-letter-exchange       设置队列溢出行为。这决定了在达到队列的最大长度时消息会发生什么。有效值为drop-head或reject-publish。交换的可选名称，如果消息被拒绝或过期，将重新发布这些名称。
         *      x-dead-letter-routing-key    可选的替换路由密钥，用于在消息以字母为单位时使用。如果未设置，将使用消息的原始路由密钥。
         *      x-max-priority               队列支持的最大优先级数;如果未设置，队列将不支持消息优先级。
         *      x-queue-mode                 将队列设置为延迟模式，在磁盘上保留尽可能多的消息以减少内存使用;如果未设置，队列将保留内存缓存以尽快传递消息。
         *      x-queue-master-locator       将队列设置为主位置模式，确定在节点集群上声明时队列主机所在的规则。
         */
        Map<String, Object> arguments = new HashMap<>();
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_DIRECT,true,false,false,arguments);
    }

    /**
     *  配置fanoutA队列。
     *  fanout      给所有绑定到该交换机的队列发送消息。
     * @return
     */
    @Bean
    Queue fanoutQueueA(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_FANOUT_A, true,false,false);
    }

    /**
     *  配置fanoutB队列。
     *  fanout      给所有绑定到该交换机的队列发送消息。
     * @return
     */
    @Bean
    Queue fanoutQueueB(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_FANOUT_B, true,false,false);
    }

    /**
     *  配置topic队列。
     *  topic       通配符。
     *              * 仅匹配一个字符 a.* 仅仅值针对a.b 无法匹配 a.b.c。
     *              # 匹配一个或者多个。
     * @return
     */
    @Bean
    Queue topicQueueA(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_A, true,false,false);
    }
    @Bean
    Queue topicQueueB(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_B, true,false,false);
    }
    @Bean
    Queue topicQueueC(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_TOPIC_C, true,false,false);
    }

    /**
     *  配置 headers队列。
     *  headers     根据请求头带的值进行匹配。
     *              分为部分匹配和全匹配。
     * @return
     */
    @Bean
    Queue headersQueueA(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_HEADERS_A, true,false,false);
    }

    @Bean
    Queue headersQueueB(){
        return new Queue(RabbitMessageQueueConstants.NAME_QUEUE_HEADERS_B, true,false,false);
    }

    /**
     * 配置交换机。
     * direct.
     * @return
     */
    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(RabbitMessageQueueConstants.NAME_EXCHANGE_DIRECT);
    }

    /**
     * 配置交换机。
     * fanout.
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(RabbitMessageQueueConstants.NAME_EXCHANGE_FANOUT,true,false);
    }

    /**
     * 配置交换机。
     * topic.
     * @return
     */
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(RabbitMessageQueueConstants.NAME_EXCHANGE_TOPIC);
    }

    /**
     * 配置交换机。
     * headers.
     * @return
     */
    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(RabbitMessageQueueConstants.NAME_EXCHANGE_HEADERS);
    }

    /**
     * 绑定 direct 队列交换机并设置路由。
     * @return
     */
    @Bean
    Binding directBinding(){
        return BindingBuilder
                //绑定队列
                .bind(directQueue())
                //绑定交换机
                .to(directExchange())
                //设置路由
                .with(RabbitMessageQueueConstants.NAME_KEY_QUEUE_DIRECT);
    }

    /**
     * 绑定 fanout 交换机和队列 不需要配置路由。
     * @return
     */
    @Bean
    Binding fanoutBindingA(){
        return BindingBuilder
                .bind(fanoutQueueA())
                .to(fanoutExchange());
    }

    @Bean
    Binding fanoutBindingB(){
        return BindingBuilder
                .bind(fanoutQueueB())
                .to(fanoutExchange());
    }

    /**
     * 绑定 topic 交换机与队列并设置通配符。
     * @return
     */
    @Bean
    Binding topicBindingA(){
        return BindingBuilder
                .bind(topicQueueA())
                .to(topicExchange())
                .with("a.*");
    }

    @Bean
    Binding topicBindingB(){
        return BindingBuilder
                .bind(topicQueueB())
                .to(topicExchange())
                .with("b.*");
    }

    @Bean
    Binding topicBindingC(){
        return BindingBuilder
                .bind(topicQueueC())
                .to(topicExchange())
                .with("rabbit.#");
    }

    /**
     * 配置 headers 交换机和队列
     * @return
     */
    @Bean
    Binding headersBindingA(){
        Map<String, Object> map = new HashMap<>();
        map.put("key_one", "java");
        map.put("key_two", "rabbit");
        //全匹配
        return BindingBuilder.bind(headersQueueA())
                .to(headersExchange())
                .whereAll(map).match();
    }

    @Bean
    Binding headersBindingB(){
        Map<String, Object> map = new HashMap<>();
        map.put("headers_A", "coke");
        map.put("headers_B", "sky");
        //部分匹配
        return BindingBuilder.bind(headersQueueB())
                .to(headersExchange())
                .whereAny(map).match();
    }

}
