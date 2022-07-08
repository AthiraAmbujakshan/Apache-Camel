package com.example.demo.Router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestApiReceiver extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().host("localhost").port("8000");
		
	/*	from("timer:rest-api-consumer?period=100000")
		.log("${body}")
		.to("rest:get:/currency-exchange/from/USD/to/INR")
		.log("${body}");*/
		
		
		//to make dynamic we use set header
		
		from("timer:rest-api-consumer?period=100000")
		.setHeader("from",()->"EUR")
		.setHeader("to",()->"INR")
		.log("${body}")
		.to("rest:get:/currency-exchange/from/{from}/to/{to}")
		.log("${body}");
		
		
		
	}
	
	
	

}
