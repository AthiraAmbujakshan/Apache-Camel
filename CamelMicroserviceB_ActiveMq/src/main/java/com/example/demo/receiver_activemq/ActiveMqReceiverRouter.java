package com.example.demo.receiver_activemq;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ActiveMqReceiverRouter extends RouteBuilder {
	
	
	@Autowired
	private CurrencyExchangeProcessor currencyExchangeProcessor;
	
	
	@Autowired
	private CurrencyExchangeTransformation currencyExchangeTransformation;
	
	

	@Override
	public void configure() throws Exception {
		
		
		
		//to receive msg from activemq
	/*	from("activemq:my-activemq-queue")
		.to("log:received-message-from-activemq");*/
		
		
		//to map json file received from activemq to local bean say CurrencyExchange
		
	/*	from("activemq:my-activemq-queue")
		.unmarshal().json(JsonLibrary.Jackson,CurrencyExcchangeBean.class)
		.to("log:received-message-from-activemq");  */
		
		
		//to do some processing - will not change the message  just do some processing
		
	/*	from("activemq:my-activemq-queue")
		.unmarshal().json(JsonLibrary.Jackson,CurrencyExcchangeBean.class)
		.bean(currencyExchangeProcessor)
		.to("log:received-message-from-activemq"); */
		
		
		
		//to do some transformation on received message
		
		
	/*	from("activemq:my-activemq-queue")
		.unmarshal().json(JsonLibrary.Jackson,CurrencyExcchangeBean.class)
		.bean(currencyExchangeTransformation)
		.to("log:received-message-from-activemq"); */
		
		
		
		//receive from activemq-using  split patterns(csv file)
		
		/*from("activemq:split-queue")
		.to("log:received "); */
		
		
		
		//message encryption 
		
		from("activemq:my-activemq-messageencrytion -queue")
		.marshal(createEncryptor())
		.to("log:message received from activemq ");
		
	}
	
	
	private CryptoDataFormat createEncryptor() throws KeyStoreException, IOException, NoSuchAlgorithmException,
	CertificateException, UnrecoverableKeyException {
KeyStore keyStore = KeyStore.getInstance("JCEKS");
ClassLoader classLoader = getClass().getClassLoader();
keyStore.load(classLoader.getResourceAsStream("myDesKey.jceks"), "someKeystorePassword".toCharArray());
Key sharedKey = keyStore.getKey("myDesKey", "someKeyPassword".toCharArray());

CryptoDataFormat sharedKeyCrypto = new CryptoDataFormat("DES", sharedKey);
return sharedKeyCrypto;
}

}

@Component 

class CurrencyExchangeProcessor{
	Logger logger = LoggerFactory.getLogger(CurrencyExchangeProcessor.class);
	
	public void processMessage(CurrencyExcchangeBean currencyExchange) {
		
		logger.info("Do some processing with currencyExchange.getConversionMultiple() {}",currencyExchange.getConversionMultiple());
		
		
	}
	
	
}


@Component 

class CurrencyExchangeTransformation{
	
	
	public CurrencyExcchangeBean TransformMessage(CurrencyExcchangeBean currencyExchange) {
		
		currencyExchange.setConversionMultiple(currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
		return currencyExchange;
		
		
	}
	
	
}
