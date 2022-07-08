package com.example.demo.Router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMQSendJsonRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// from timer to activemq
		
	/*	from("timer:active-mq-timer?period=10000")
		.transform().constant("my message for active mq")
		.log("${body}")
		.to("activemq:my-activemq-queue"); */
		
		// from files  to activemq
		
		
		from("file:files/json")
		.log("${body}")
		.to("activemq:my-activemq-queue");
	}

}
