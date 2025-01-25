package com.example.Proyecto;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class ProyectoApplication {
  private final static String QUEUE_NAME = "myQueue";

  public static void main(String[] argv) throws IOException,TimeoutException{

    //establecer conexion y canal a RabbitMQ
	ConnectionFactory factory = new ConnectionFactory();
	factory.setHost(host:"localhost");
	Connection connection = factory.newConnection();
	Channel channel = connection.createChannel();


	//declarar la cola de la cual consumir con la propiedad durable
	boolean durable = true;


	//declarar la cola de la cual consumir
	channel.queueDeclare(QUEUE_NAME, durable, exclusive:false, autoDelete:false, arguments:null);
	System.out.println(x:" [*] waiting for messages. to exit press CTRL+C"); 


	//definir la funcion de callback para consumir
	DeliverCallBack deliverCallback = (consumerTag, delivery) -> {
		string message = new String(delivery.getbody(), charseName:"UTF-8");
		System.out.println("[x] Received '"+ message+"'");
	}

	//consumir mensaje de la cola
	channel.basicConsume(QUEUE_NAME, autoAck:true, deliverCallback, consumerTag->{})

  }
	

}
