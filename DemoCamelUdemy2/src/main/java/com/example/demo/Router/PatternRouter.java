package com.example.demo.Router;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class PatternRouter extends RouteBuilder {
	
	
	@Autowired
	SplitterBean splitter;
	
	@Autowired
	DynamicRouterBean dynamicRouterBean;

	@Override
	public void configure() throws Exception {
		//using multicast pattern 
		
	/*	from("timer:multicast?period=10000")
		.multicast()
		.to("log:something1", "log:something2","log:something3"); */
		
		
		//split patterns - make use of csv files
		 // here data is read as a single file
		//add dependency csv starter in pom.xml
	/*	from("file:files/csv")
		.split(body())
		.to("log:split-files"); */
		
		
		// we want to read file line by line - so we use unmarshal
		
		//we can see each line in the input file is becoming seperate messages.
		//here in the input csv file, we have 4 lines. 
	/*	from("file:files/csv")
		.unmarshal().csv()
		.split(body())
		.to("log:split-files"); */
		
		
	// using active mq, we can see 4 messages in a queue	
		
	/*	from("file:files/csv")
		.unmarshal().csv()
		.split(body())
		.to("activemq:split-queue"); */
		
		
		//custom split based on comma delimiter
		//message1, message2 , message 3 etc we need to split based on comma
		
	/*	from("file:files/csv")
		.convertBodyTo(String.class)
		.split(body(),",")
		.to("log:split-files"); */
		
		
		//we can also use bean to use split
		
		
	/*	from("file:files/csv")
		.convertBodyTo(String.class)
		.split(method(splitter))
		.to("activemq:split-queue"); */
		
		
		//Aggregate- identify some criteria in mutliple files and aggregate and then move to endpoint
		//we need to unmarshal to spefic class to use "to" 
	/*	from("file:files/aggregate-json")
		.unmarshal().json(JsonLibrary.Jackson,CurrencyExcchangeBean.class)
		.aggregate(simple("${body.to}"), new ArrayListAggregationStrategy())
		.completionSize(3)
		//.completionTimeout(HIGHEST)
		.to("log:aggregate-json"); */
		
		
		//routing slip pattern 
		
		// we would have some logic to determine which end points to route to. end point to route to will be in a string
		
	
		/*String routingSlip ="direct:endpoint1, direct:endpoint3";
		
		from("timer:routingSlip?period=10000")
		.transform().constant("my message is hardcoded")
		.routingSlip(simple(routingSlip));
		
		from("direct:endpoint1")
		.to("log:directendpoint1");
		
		from("direct:endpoint2")
		.to("log:directendpoint2");
		
		from("direct:endpoint3")
		.to("log:directendpoint3"); */
		
		
		
		//dynamic routing->we can right logic to decide which endpoint to invoke after each step of processing
		
		
		
		
		
		from("timer:DynamicRoute?period=10000")
		.transform().constant("my message is hardcoded")
		.dynamicRouter(method(dynamicRouterBean));
		
		
		
		from("direct:endpoint1")
		.to("log:directendpoint1");
		
		from("direct:endpoint2")
		.to("log:directendpoint2");
		
		from("direct:endpoint3")
		.to("log:directendpoint3");
		
	}
	
	
	@Component 
	class DynamicRouterBean{
		
		Logger logger = LoggerFactory.getLogger(DynamicRouterBean.class);
		 int invocations;
		
		public String decideTheNextEndPoint(@ExchangeProperties Map<String, String> properties,
				@Headers  Map<String, String> headers, @Body String body) {
			
		logger.info("{},{},{},properties, headers, body");	
		invocations++;
		if(invocations%3 ==0) {
			return "direct:endpoint1";
		}
		if(invocations%3==1) {
			return "direct:endpoint2,direct:endpoint3";
		}
		return null;	
		}
	}

	@Component
	class SplitterBean{
		
		public List<String>splitInput(String body){
			return Arrays.asList("ABC","DEF","GHI");
		}
	}
}
