package com.rabbitmq.rabbit_publisher.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class models{
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Ejemplo{
        private String name;
        private String numero;
    }
}