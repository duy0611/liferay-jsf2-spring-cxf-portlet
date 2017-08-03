package com.test.spring;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

	@Bean(name = "simpleServiceClient")
	public SimpleService generateProxy() {
	    return (SimpleService) proxyFactoryBean().create();
	}
	
	@Bean
	public JaxWsProxyFactoryBean proxyFactoryBean() {
	    JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
	    proxyFactory.setServiceClass(SimpleService.class);
	    proxyFactory.setAddress("http://www.webservicex.com/globalweather.asmx");
	    return proxyFactory;
	}
}
