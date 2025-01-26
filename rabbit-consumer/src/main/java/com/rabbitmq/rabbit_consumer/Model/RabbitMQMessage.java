package com.rabbitmq.rabbit_consumer.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "rabbitmq_messages")
public class RabbitMQMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Numero", nullable = false)
    private String numero;

    @CreationTimestamp
    @Column(name = "Fecha_Creacion", nullable = false, updatable = false)
    private LocalDateTime createdAt;



    //constructor
    public RabbitMQMessage() {
    }

    //construcctor
    public RabbitMQMessage(String name, String numero) {
        this.name = name;
        this.numero = numero;
    }


    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
