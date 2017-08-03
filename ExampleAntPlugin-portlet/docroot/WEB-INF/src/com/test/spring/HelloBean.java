package com.test.spring;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.jsf.FacesContextUtils;

@ManagedBean
@RequestScoped  //can be viewScope or requestScope
public class HelloBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("simpleServiceClient")
	SimpleService simpleServiceClient;
	
	@PostConstruct
    private void init() {
        FacesContextUtils
            .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
            .getAutowireCapableBeanFactory().autowireBean(this);

        // springBeanName is now available.
    }

	private String name;

	public String getName() {	
		System.out.println("name: " + name);
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSomething() {
		System.out.println("Result from SOAP: " + simpleServiceClient.getCitiesByCountry("Finland"));
		return "success";
	}
}