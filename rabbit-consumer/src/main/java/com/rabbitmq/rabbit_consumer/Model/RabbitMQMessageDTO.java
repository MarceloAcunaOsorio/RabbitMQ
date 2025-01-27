package com.rabbitmq.rabbit_consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMQMessageDTO {

    private String Nombre;
    private String Descripcion;
}
