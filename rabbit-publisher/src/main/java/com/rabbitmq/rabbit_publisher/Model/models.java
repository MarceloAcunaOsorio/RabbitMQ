package com.rabbitmq.rabbit_publisher.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

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

         // Getters y Setters
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("numero")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    }
}