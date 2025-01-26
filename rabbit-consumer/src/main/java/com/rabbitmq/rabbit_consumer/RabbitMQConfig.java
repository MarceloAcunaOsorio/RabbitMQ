package com.rabbitmq.rabbit_consumer;

import java.util.Map;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY_EJEMPLO = "ejemplo_routing_key";

    public static final String QUEUE_EJEMPLO = "ejemplo_queue";


    //cola
    @Bean
    public Queue ejemplo_Queue(){
        return new Queue("ejemplo_queue",true, false, false, Map.of("x-dead-letter-exchange","dlx-exchange"));
    }


    //topico
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE);
    }


    //Binding
    @Bean
    public Binding bindingEjemplo(Queue queueEjemplo, TopicExchange topicExchange){
       return BindingBuilder
              .bind(queueEjemplo)
              .to(topicExchange)
              .with(ROUTING_KEY_EJEMPLO);
    }


    //convertir a JSON
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connection){
       final var template = new RabbitTemplate(connection);
       template.setMessageConverter(messageConverter());
       return template;
    }
}
