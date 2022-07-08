package com.example.demo.Router;

import java.util.ArrayList;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public class ArrayListAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		//return newExchange;
		
		//lets say we are having 3 files
		 /*
		  * intially value is oldexchange 
		  * oldexchange-> value  corresponding to "to" from 1st file(result)
		  * result ->  value  corresponding to "to" from 2nd file(result1)
		  * result1->  value  corresponding to "to" from 3rdd file (newExchange)
		  
		  * 
		  * 
		  * 
		  */
		
		// to have as list 
		
		
		        Object newBody = newExchange.getIn().getBody();
		        ArrayList<Object> list = null;
		        if (oldExchange == null) {
		            list = new ArrayList<Object>();
		            list.add(newBody);
		            newExchange.getIn().setBody(list);
		            return newExchange;
		        } else {
		            list = oldExchange.getIn().getBody(ArrayList.class);
		            list.add(newBody);
		            return oldExchange;
		        }
		    }
	}


