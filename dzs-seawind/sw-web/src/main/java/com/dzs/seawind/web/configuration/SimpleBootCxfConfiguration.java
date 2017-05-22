package com.dzs.seawind.web.configuration;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dzs.seawind.web.endpoint.DeviceServiceEndpoint;
import com.dzs.seawind.web.endpoint.WeatherServiceEndpoint;
import com.dzs.seawind.web.xmlvalidation.WeatherFaultBuilder;

import de.codecentric.cxf.xmlvalidation.CustomFaultBuilder;
import de.codecentric.namespace.deviceservice.DeviceService;
import de.codecentric.namespace.weatherservice.Weather;
import de.codecentric.namespace.weatherservice.WeatherService;

@Configuration
public class SimpleBootCxfConfiguration {

    public static final String SERVICE_URL = "/WeatherSoapService_1.0";
    public static final String SERVICE_URL_DEVICE = "/DeviceSoapService_1.0";

    @Autowired
    private SpringBus springBus;

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }
    
    @Bean
    public DeviceService deviceService() {
        return new DeviceServiceEndpoint();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus, weatherService());
        endpoint.setServiceName(weatherClient().getServiceName());
        endpoint.setWsdlLocation(weatherClient().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL);
        
        endpoint = new EndpointImpl(springBus, deviceService());
        endpoint.setServiceName(deviceClient().getServiceName());
        endpoint.setWsdlLocation(deviceClient().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL_DEVICE);
        
        return endpoint;
    }

    @Bean
    public Weather weatherClient() {
        return new Weather();
    }
    
    @Bean
    public Weather deviceClient() {
        return new Weather();
    }

    @Bean
    public CustomFaultBuilder weatherFaultBuilder() {
        return new WeatherFaultBuilder();
    }
}
