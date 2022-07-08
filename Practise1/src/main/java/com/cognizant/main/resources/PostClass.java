package com.cognizant.main.resources;



import org.apache.camel.BeanInject;

import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.rest.RestBindingMode;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;


import com.cognizant.main.processor.JsonProcessor;



@Component
public class PostClass  extends RouteBuilder{

	@BeanInject
	private JsonProcessor processor; 
	
	@Override
	public void configure() throws Exception {
		
	restConfiguration().component("servlet").port(8480).host("20.212.16.243").bindingMode(RestBindingMode.json);
	
	
	rest().post("/irisR18/api/v1.0.0/postmastervendorlist").consumes(MediaType.APPLICATION_JSON_VALUE).route()
	.process(processor).endRest();
	}
}
	
	


	