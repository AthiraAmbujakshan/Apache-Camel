package com.example.demo.receiver_activemq;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiCurrencyExchangecontroller {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeForXmlfile findConversionValue(@PathVariable String from, @PathVariable String to) {
		
		
		return new CurrencyExchangeForXmlfile(1000, from,to,BigDecimal.TEN);
		
		//lauch url in browser to see the rest api localhost:8000/currency-exchange/from/USD/to/INR
	}

}
