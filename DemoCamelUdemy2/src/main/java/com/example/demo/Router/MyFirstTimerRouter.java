package com.example.demo.Router;





import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 //@Component                        // i will comment @Component annotation, to use another router class. at a time we can use only one router class
public class MyFirstTimerRouter extends RouteBuilder {

	
@Autowired
 private GetCurrentTimeBean getTimeBean;
	
	
@Autowired
private SimpleLoggingProcessingComponent  loggingprocess;
	@Override
	public void configure() throws Exception {
		// will listen to a timer and display log 
		
		// in output response, we can see log message has body type as null

		
	/*	from("timer:first-timer")
	  
		.to("log:first-timer");  */
		
	
		
		// we can pass some constant messages and we can see message 
		
	/*	from("timer:first-timer").transform().constant("my constant message")
		.to("log:first-timer"); */
		
		
		//we can pass data time  but the log messages have same time each time. so to make time dynamic we use spring beans
		
		
		/*from("timer:first-timer").transform().constant("Time now is"+LocalDateTime.now())
		.to("log:first-timer");  */
		
		
		
		// using spring beans to get dynamic time 
		
/*	from("timer:second-timer")
	//.bean("getCurrentTimeBean")    //without autowired annotation
	.bean(getTimeBean)         //using autowired annotation
	
    .to("log:second-timer");*/
		
		
		
		// transformation
		
	/*	from("timer:first-timer")
		.log("${body}")         // output - null
		 .transform().constant("welcome to java camel")
		 .log("${body}")                //  output- welcome to java camel
		 .bean("getCurrentTimeBean")
		 .log("${body}")                 // output - we will get current time
		 .to("log:first-timer");*/
	   
		
		
		
		//processing - body of msg is not changed
		
		
		from("timer:first-timer")
		.log("${body}")              //null
		 .transform().constant("welcome to java camel")
		 .log("${body}")                //welcome to java camel
		 .bean("getCurrentTimeBean")
		 .log("${body}")          //   Time now is2021-11-25T13:33:02.354
		 .bean(loggingprocess)
		 .log("${body}")         //   SimpleLoggingProcessingComponent Time now is2021-11-25T13:33:02.354 - 
		                              //here body is not changed from previous log
		 .to("log:first-timer");
		
		
		
		
		//using processer
		
		
		
		from("timer:first-timer")
		.log("${body}")              
		 .transform().constant("welcome to java camel")
		 .log("${body}")              
		 .bean("getCurrentTimeBean")
		 .log("${body}")         
		 .bean(loggingprocess)
		 .log("${body}") 
		 .process(new LoggerProcessor())     //--- create class LoggerProcessor - body of the msg is not changed after processing
		 .to("log:first-timer");
	}
}
		
		
		



@Component  

  class GetCurrentTimeBean{
	
public	String getCurrentTime(){
		
		return "Time now is"+LocalDateTime.now();
		
		
	
		 }
	}
	

@Component  

class SimpleLoggingProcessingComponent{
	
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	
public	void process(String message){
		
		
		logger.info("SimpleLoggingProcessingComponent {}", message);
		
	
		 }
	}
		
class	LoggerProcessor implements Processor{
	
	private Logger logger = LoggerFactory.getLogger(LoggerProcessor.class);

	public void process(Exchange exchange) throws Exception {
		
		logger.info("LoggerProcessor {}", exchange.getMessage().getBody());
	}
	 
}
		
		
	