package com.rabbitmq.rabbit_consumer.Consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.rabbit_consumer.RabbitMQConfig;
import com.rabbitmq.rabbit_consumer.Model.RabbitMQMessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListeners {

  @RabbitListener(queues = RabbitMQConfig.QUEUE_EJEMPLO)
  public void readEjemploMsg(RabbitMQMessageDTO rabbitMQMessageModel){
    log.info("Receiving: {}",rabbitMQMessageModel);
  }
}
