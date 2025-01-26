package com.rabbitmq.rabbit_consumer;

import org.springframework.amqp.core.AmqpTemplate;
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
    public static final String ROUTING_KEY_COLOR = "color_routing_key";

    public static final String QUEUE_EJEMPLO = "ejemplo_queue";
    public static final String QUEUE_COLOR = "color_queue";


    //cola
    @Bean
    public Queue queueEjemplo(){
        return new Queue(QUEUE_EJEMPLO);
    }

    //cola
    @Bean
    public Queue queueColor(){
        return new Queue(QUEUE_COLOR);
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

     //Binding
     @Bean
     public Binding bindingColor(Queue queueColor, TopicExchange topicExchange){
        return BindingBuilder
               .bind(queueColor)
               .to(topicExchange)
               .with(ROUTING_KEY_COLOR);
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
