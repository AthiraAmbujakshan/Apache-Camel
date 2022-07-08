package com.example.demo.Router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMQSendXmlRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	
		
		from("file:files/xml")
		.log("${body}")
		.to("activemq:activemq-xml-queue");
		
	}

}
