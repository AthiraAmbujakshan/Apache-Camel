package com.cognizant.test.containers;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.stereotype.Component;


@Component
public class CSVRouter extends RouteBuilder {
	
	

	@Override
	public void configure() throws Exception {
		
		from("file:files/csv")
		 .unmarshal(new BindyCsvDataFormat(Vendor.class))
		.process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				
				List<Vendor> data = exchange.getIn().getBody(List.class);

		StringBuilder jsondata = new StringBuilder();		 
				for(Vendor line : data) {
					
					int id = line.getId();
					String payeename = line.getPAYEE_NAME();
					String ExternalID = line.getEXTERNAL_ID();
					String SettlementAccount = line.getSETTLEMENT_ACCOUNT();
					String Active = line.getACTIVE();
					
					
			String ModifiedOutput = "{\nID :" +id +" ,\n PAYEE_NAME:" +payeename+ ",\n EXTERNAL_ID:"+ExternalID
					
					+ ",\n SETTLEMENT_ACCOUNT:" +SettlementAccount+ ",\n ACTIVE:"+ Active+ "\n}";		
			
			
			jsondata.append(ModifiedOutput).append("\n");
				}

         
				Message Finaloutput = exchange.getMessage();
				
				Finaloutput.setBody(jsondata);
		
		
	}

})
		.log("${body}")
.to("file:files/output");	
		
		
		
	}
}