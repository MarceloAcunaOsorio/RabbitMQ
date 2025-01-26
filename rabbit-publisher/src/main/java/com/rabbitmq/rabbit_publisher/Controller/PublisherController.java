package com.rabbitmq.rabbit_publisher.Controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.rabbit_publisher.RabbitMQConfig;
import com.rabbitmq.rabbit_publisher.Model.RabbitMQMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "publish")
public class PublisherController {


    private final RabbitTemplate template;


    //mensaje para ejemplo
    @PostMapping(path = "ejemplo")
    public String publishEjemplo(@RequestBody RabbitMQMessage ejemplo){
       this.template.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY_EJEMPLO,ejemplo);
       return "Ejemplo message send success";
    }
}
