package com.cognizant.main.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class JsonProcessor  implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		
					
			String ModifiedOutput =
					
		"\r{\n"	+"\""+"header"+"\": { },\n" +"\"body\":\n"+
					
					
			"{\n\"vendorId\" :"  +"123457"+
			",\n\"VendorName\" :"  +"ABC"+
			",\n\"VendorCategory\" :" +"TATA"+"\n}\n}";
							
	ModifiedOutput = exchange.getIn().getBody(String.class);			
					
	JSONObject  myresponse = new JSONObject(ModifiedOutput);
				Message Finaloutput = exchange.getMessage();
				
				Finaloutput.setBody(myresponse);
		   
		System.out.println(myresponse); 
	}

}