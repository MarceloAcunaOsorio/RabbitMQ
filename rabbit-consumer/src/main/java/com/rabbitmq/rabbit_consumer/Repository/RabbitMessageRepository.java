package com.rabbitmq.rabbit_consumer.Repository;

import com.rabbitmq.rabbit_consumer.Model.RabbitMQMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RabbitMessageRepository extends JpaRepository<RabbitMQMessage, Long>{

}
