package com.rabbitmq.rabbit_consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Models {


      @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Ejemplo{
        private String name;
        private String numero;
    }
}
