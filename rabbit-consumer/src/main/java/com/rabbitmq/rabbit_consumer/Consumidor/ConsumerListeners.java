package com.rabbitmq.rabbit_consumer.Consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.rabbit_consumer.Model.RabbitMQMessage;
import com.rabbitmq.rabbit_consumer.Model.RabbitMQMessageDTO;
import com.rabbitmq.rabbit_consumer.Repository.RabbitMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListeners {


  //guardar mensaje deserializado en la base de datos
  @Autowired
  private RabbitMessageRepository repository;

  @RabbitListener(queues = "ejemplo_queue")
  public void recibirMensaje(RabbitMQMessageDTO message) {
      System.out.println("Receiving: " + message);
      
      // Guardar en la base de datos
      RabbitMQMessage entity = new RabbitMQMessage();
      entity.setNombre(message.getNombre());
      entity.setDescripcion(message.getDescripcion());
      repository.save(entity);
  }


}
