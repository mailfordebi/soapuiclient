package com.dd.soapuui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dd.soapuui.client.SoapServiceClient;

@Configuration
public class SoapUIClientConfiguration {

	private final static String FTS_PRO_SOAP_URL = "http://dev.unity-payment.monamisoft.net:80/monamitech/nackupdate";

	@Bean
	public SoapServiceClient callService() {
		SoapServiceClient client = new SoapServiceClient();
		client.setDefaultUri(FTS_PRO_SOAP_URL);
		return client;
	}

}
