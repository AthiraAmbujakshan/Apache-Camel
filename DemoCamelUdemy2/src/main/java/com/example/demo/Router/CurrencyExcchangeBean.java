package com.example.demo.Router;

import java.math.BigDecimal;

public class CurrencyExcchangeBean {

	
	private int id;
	
	private String from;
	private String to;
	private BigDecimal conversionMultiple;

public CurrencyExcchangeBean() {
	
	
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
	return "CurrencyExcchangeBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
			+ conversionMultiple + "]";
}
}