package com.rabbitmq.rabbit_publisher.Controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.rabbit_publisher.RabbitMQConfig;
import com.rabbitmq.rabbit_publisher.Model.models;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "publish")
public class PublisherController {


    private RabbitTemplate template;


    //mensaje para color
    @PostMapping(path = "color")
    public String publishColor(@RequestBody models.Color color){
       this.template.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY_COLOR,color);
       return "color message send success";
    }


    
    //mensaje para ejemplo
    @PostMapping(path = "ejemplo")
    public String publishEjemplo(@RequestBody models.Ejemplo ejemplo){
       this.template.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY_EJEMPLO,ejemplo);
       return "Ejemplo message send success";
    }
}
