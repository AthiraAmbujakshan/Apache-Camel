package com.example.demo.fileconversion;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileConversion  extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		//example1 -txt to json conversion
		
		from("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\input")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception{
				
				
				
				//read i/p message from source
				
				Message input = exchange.getIn();
				
				//read body of input message as String
				
				String data = input.getBody(String.class);
				
				//perform some operations
				
				StringTokenizer str = new StringTokenizer(data,",");
				String eid = str.nextToken();
				String ename = str.nextToken();
				String esal = str.nextToken();
				
				String modifiedoutput = "{eid :" +eid +" , ename:" +ename+ " , esal:"+esal+"}";
				//read output message 
				
				
				Message finaloutput = exchange.getMessage();
				
				//set modifiedoutput to final output
				
			finaloutput.setBody(modifiedoutput);
				
			}
			
			
		}
				
				
				
				)
		.to("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\output"); 
		
		
		// if we want output file extension as json
		
	//	.to("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\output?fileName=data.json");	
		
		
		
		
		//example 2 - txt to txt (some condition) 
		
		//1,2, 3   -> onlinetransaction, telephonic order, rm
		
		
		
		
		
	/*	from("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\input")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception{
				
				
				
				//read i/p message from source
				
				Message input = exchange.getIn();
				
				//read body of input message as String
				
				String data = input.getBody(String.class);
				
				//perform some operations
				String modifieddata;
				StringBuilder converteddata = new StringBuilder();
				  String splitteddata [] = data.split(",");
				  
				  int i=0;
				  
				  while(i< splitteddata.length)
				  {
					  
					  if(splitteddata[i].equals("1"))
					  {
						  modifieddata = "Online Transaction" ;
					  }
					  
					  else if(splitteddata[i].equals("2"))
					  {
						   modifieddata = "Telephonic order" ;
						  
					  }
					  else
					  {
						   modifieddata = "RM" ;
					  }
					  
					  converteddata.append(modifieddata).append(",");
					  
					  i++;
				  }
				  converteddata.deleteCharAt(converteddata.length()-1);
			
				StringBuilder modifiedoutput = converteddata;
				//read output message 
				
				
				Message finaloutput = exchange.getMessage();
				
				//set modifiedoutput to final output
				
			finaloutput.setBody(modifiedoutput);
				
			}
			
			
		}
				
				
				
				)
		.log("${body}")
		.to("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\output?fileName=outputfile.txt");
		
		
		
		
		
		//using lamba expression
		
		
	/*	from("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\input")
		.process(
				
			(exchange)->{
				
//read i/p message from source
				
				Message input = exchange.getIn();
				
				//read body of input message as String
				
				String data = input.getBody(String.class);
				
				//perform some operations
				String modifieddata;
				StringBuilder converteddata = new StringBuilder();
				  String splitteddata [] = data.split(",");
				  
				  int i=0;
				  
				  while(i< splitteddata.length)
				  {
					  
					  if(splitteddata[i].equals("1"))
					  {
						  modifieddata = "Online Transaction" ;
					  }
					  
					  else if(splitteddata[i].equals("2"))
					  {
						   modifieddata = "Telephonic order" ;
						  
					  }
					  else
					  {
						   modifieddata = "RM" ;
					  }
					  
					  converteddata.append(modifieddata).append(",");
					  
					  i++;
				  }
				  converteddata.deleteCharAt(converteddata.length()-1);
			
				StringBuilder modifiedoutput = converteddata;
				//read output message 
				
				
				Message finaloutput = exchange.getMessage();
				
				//set modifiedoutput to final output
				
			finaloutput.setBody(modifiedoutput);
				
			}
			
				)
		
		
		.log("${body}")
	.to("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\output?fileName=outputata.txt");  */
		
		
		
		
		//example4 - txt to xml file converstion
		
		
		
	/*	from("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\input")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
			
				
				Message input = exchange.getIn();
				
				String data = input.getBody(String.class);
				
				StringTokenizer str = new StringTokenizer(data,",");
				
				String studentid = str.nextToken();
				String studentname = str.nextToken();
				String studentcourse = str.nextToken();
				
				String modifiedoutput =
						"<Student> \n<studentId>" +studentid+ "</studentId>\n<studentname>" +studentname
						+"</studentname>\n<studentcourse>"+studentcourse+"</studentcourse>\n</Student>";
				
				Message output = exchange.getMessage();
				
				output.setBody(modifiedoutput);
			}
		
		}
			)
		
		.to("file:C:\\Users\\845269\\Downloads\\camel-main\\camel-main\\01.files\\output?");*/
		
	}

}
