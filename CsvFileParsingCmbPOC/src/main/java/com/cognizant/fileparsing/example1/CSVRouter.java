package com.cognizant.fileparsing.example1;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CSVRouter extends RouteBuilder {
	
	@Autowired
	private VendorJpaRepository repo;

	@Override
	public void configure() throws Exception {
		
		from("file:files/csv")
		 .unmarshal(new BindyCsvDataFormat(Vendor.class))
		.process(new Processor() {

			public void process(Exchange exchange) throws Exception {
				
				List<Vendor> data = exchange.getIn().getBody(List.class);

				 

                 for (Vendor line : data) {
                      repo.save(line);
                        
                 }

				
			}
			
			
			
			
		});
		
		
		
		
		
		
	}

}
