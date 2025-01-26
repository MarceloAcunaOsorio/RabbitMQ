package com.rabbitmq.rabbit_consumer.Consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.rabbit_consumer.Model.RabbitMQMessage;
import com.rabbitmq.rabbit_consumer.Repository.RabbitMessageRepository;
import lombok.extern.slf4j.Slf4j;



@Service

@Slf4j
public class ConsumerListeners {

  private final RabbitMessageRepository repository;

  public ConsumerListeners(RabbitMessageRepository repository) {
    this.repository = repository;
}


@RabbitListener(queues = "ejemplo_queue")
public void handleMessage(String message) {
    System.out.println("Mensaje recibido: " + message);

// Guardar el mensaje en la base de datos
  RabbitMQMessage rabbitMQMessage = new RabbitMQMessage(message);
  repository.save(rabbitMQMessage);

        System.out.println("Mensaje guardado en la base de datos.");

}
    


}
