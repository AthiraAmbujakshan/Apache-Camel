package com.example.demo.Router;



import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.stereotype.Component;

@Component
public class MessageEncryption extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		from("timer:active-mq-time?period=10000")
		.transform().constant("my message for activemq")
		.log("${body}")
		.marshal(createEncryptor())
		.to("activemq:my-activemq-messageencrytion -queue");
		
		
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
