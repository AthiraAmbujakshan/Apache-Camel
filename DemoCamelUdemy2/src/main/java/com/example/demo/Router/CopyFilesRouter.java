package com.example.demo.Router;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class CopyFilesRouter  extends RouteBuilder {
	
	
	
	@Autowired
	private DeciderBean deciderBean;
	
	@Autowired
	private DeciderBean1 deciderBean1;


	@Override
	public void configure() throws Exception {
		
		
		
		
		
		// to move file from input to output folder
		
	/*	from("file:files/input")
		.log("${body}")
		.to("file:files/output"); */
		
		
		
		//using choice and simple language in camel routes
		
		
		
		//lets say i need to check the file extension as xml
		
		
	/*	from("file:files/input")
		.routeId("file-input-route")
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		.to("file:files/output");*/
		
		
		
	//	lets say i need to check the content of json file and check whether it contains "AUD"
		
		
	/*	from("file:files/input")
		.routeId("file-input-route")
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.when(simple("${body} contains 'AUD' "))
		 .log(" not an xml file but contains 'USD' ")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		.to("file:files/output"); */
		
		//here  second when condition is false as body is not string. so we get output as " not an  xml file"
		// (otherwise part is evaluated). so we need to transform to string 
		
		
		
/*	from("file:files/input")
		.routeId("file-input-route")
		.transform().body(String.class)
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.when(simple("${body} contains 'USD' "))
		 .log(" not an xml file but contains 'USD' ")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		//to print message history 
		
		.log("${messageHistory}")
	 
		//to see headers
		.log("${headers}")
		//to see specific headers
		.log("${headers.CamelFileAbsolute}")
		//gives the absolute path of the file
		.log("${file:absolute.path}")
		//to log other details
	.log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
	
	.log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
	.log("${file:size} ${file:modified} ${routeId} ${camelId} ")
		.to("file:files/output"); 
		.to("file:files/output");  */
		
	
		
		
		// reusable end points 	
		
		
		
	/*	from("file:files/input")
		.routeId("file-input-route")
		.transform().body(String.class)
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.when(simple("${body} contains 'USD' "))
		 .log(" not an xml file but contains 'USD' ")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		.to("direct://log-file-values")
		.to("file:files/output");
		
		
		
		
		
		from("direct:log-file-values")
		
		.log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
		
		.log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
		.log("${file:size} ${file:modified} ${routeId} ${camelId} ");  */
		
		
		
		
		//using beans to define  complex logic
		
		
		
		
	/*	from("file:files/input")
		.routeId("file-input-route")
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.when(method(deciderBean))
		 .log(" not an xml file but contains 'USD' ")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		.to("file:files/output");  */
		
		
		
		
		//we can add multiple paremeters in bean to get header details. exchange properties etc
		
		
		from("file:files/input")
		.routeId("file-input-route")
		.choice()
		.when(simple("${file:ext} ends with 'xml' "))
		.log("xml file")
		.when(method(deciderBean1))
		 .log(" not an xml file but contains 'USD' ")
		.otherwise()
		.log("not an xml file")
		.end()
		.log("${body}")
		.to("file:files/output");
		
		
			
	}

}


@Component

class DeciderBean{
	
	Logger logger = LoggerFactory.getLogger(DeciderBean.class);
			
			
			public Boolean isConditionMet(String body) {
		
		 logger.info("DeciderBean {}",body);
		 return true;
	}
}



//we can add multiple parameters in bean to get header details. exchange properties etc



@Component

class DeciderBean1{
	
	Logger logger = LoggerFactory.getLogger(DeciderBean.class);
			
			
			public Boolean isConditionMet(@Body String body, @Headers Map<String, String > headers,
					@ExchangeProperties Map<String, String> exchangeproperties) {
		
		 logger.info("DeciderBean {} {} {}",body, headers, exchangeproperties);
		 return true;
	}
}







