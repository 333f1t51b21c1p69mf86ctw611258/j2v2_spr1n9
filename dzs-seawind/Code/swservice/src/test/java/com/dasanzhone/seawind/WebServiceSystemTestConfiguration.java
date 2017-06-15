package com.dasanzhone.seawind;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dasanzhone.namespace.weatherservice.WeatherService;
import com.dasanzhone.seawind.configuration.WebServiceConfiguration;

@Configuration
public class WebServiceSystemTestConfiguration {
    
    @Bean
    public WeatherService weatherServiceSystemTestClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactory = new JaxWsProxyFactoryBean();
        jaxWsProxyFactory.setServiceClass(WeatherService.class);
        jaxWsProxyFactory.setAddress("http://localhost:8090" + WebServiceConfiguration.BASE_URL + WebServiceConfiguration.SERVICE_URL_WEATHER);
        return (WeatherService) jaxWsProxyFactory.create();
    }
}
