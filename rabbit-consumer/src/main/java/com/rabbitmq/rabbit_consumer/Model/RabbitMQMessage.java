package com.rabbitmq.rabbit_consumer.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "rabbitmq_messages")
public class RabbitMQMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message_content", nullable = false)
    private String messageContent;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public RabbitMQMessage() {
    }

    public RabbitMQMessage(String messageContent) {
        this.messageContent = messageContent;
        this.createdAt = LocalDateTime.now();
    }
}
