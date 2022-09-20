package com.zy.actinium.rabbitmq.provider.controller;

import com.zy.actinium.rabbitmq.provider.service.SendMessageQueueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/27 17:10
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitMessageQueueController {

    @Autowired
    SendMessageQueueService sendMessageQueueService;

    /**
     * 接收 direct 交换机消息
     * @param message   消息体
     * @return          消息结果
     */
    @PostMapping("/sendMessageByDirectExchange")
    public String sendMessageByDirectExchange(@RequestParam(name = "message") String message){

        return sendMessageQueueService.sendMessageByDirectExchange(message);
    }

    /**
     * 接收 fanout 交换机消息
     * @param message   消息体
     * @return          消息结果
     */
    @PostMapping("/sendMessageByFanoutExchange")
    public String sendMessageByFanoutExchange(@RequestParam(name = "message") String message){
        return sendMessageQueueService.sendMessageByFanoutExchange(message);
    }

    /**
     * 接收 topic 交换机消息
     * @param message       消息体
     * @param routingKey    路由地址    a.b
     * @return              消息结果
     */
    @PostMapping("/sendMessageByTopicExchange")
    public String sendMessageByTopicExchange(@RequestParam(name = "message") String message, @RequestParam(name = "routingKey") String routingKey){
        return sendMessageQueueService.sendMessageByTopicExchange(message,routingKey);
    }

    /**
     * 接收 headers 交换机消息
     * @param message   消息体
     * @param json      消息头 {"key_one":"java","key_two":"rabbit"}  a {"headers_A":"coke","headers_B":"sky"} b
     * @return          消息结果
     */
    @PostMapping("/sendMessageByHeadersExchange")
    public String sendMessageByHeadersExchange(@RequestParam(name = "message") String message, @RequestParam(name = "json") String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        return sendMessageQueueService.sendMessageByHeadersExchange(message,map);
    }

}
