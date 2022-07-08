package com.example.demo.receiver_activemq;

import java.math.BigDecimal;

public class CurrencyExchangeForXmlfile {

	
private int id;
	
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	
	
	public CurrencyExchangeForXmlfile() {
		
	}


	public CurrencyExchangeForXmlfile(int id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}


	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}


	@Override
	public String toString() {
		return "CurrencyExchangeForXmlfile [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + "]";
	}
	
}
