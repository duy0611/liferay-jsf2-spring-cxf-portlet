package com.test.spring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "GlobalWeather", targetNamespace = "http://www.webserviceX.NET")
public interface SimpleService {

	@WebMethod(action = "http://www.webserviceX.NET/GetCitiesByCountry", operationName = "GetCitiesByCountry")
	@WebResult(name = "GetCitiesByCountryResult", targetNamespace = "http://www.webserviceX.NET")
	String getCitiesByCountry(@WebParam(name="CountryName", targetNamespace = "http://www.webserviceX.NET") String countryName);
	
}
