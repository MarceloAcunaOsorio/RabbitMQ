package com.rabbitmq.rabbit_consumer.Consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.rabbit_consumer.RabbitMQConfig;
import com.rabbitmq.rabbit_consumer.Model.Models;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListeners {

    //metodo para leer los mensajes
    @RabbitListener(queues = RabbitMQConfig.QUEUE_EJEMPLO)
    public void readEjemploMsg(Models.Ejemplo ejemplo){
      log.info("Receiving ejemplo:{}",ejemplo);
    }

}
