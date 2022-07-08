package com.example.demo.receiver_activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMQReceiverXmlRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	
		// to recieve from active mq
	/*	from("activemq:activemq-xml-queue")
		.log("${body}")
		.to("log:received message from active mq");*/
		
		
		from("activemq:activemq-xml-queue")
		.unmarshal()
		.jacksonxml(CurrencyExchangeForXmlfile.class)
		.to("log:received -message-from-activemq");
		
	}
	
	
	

}
