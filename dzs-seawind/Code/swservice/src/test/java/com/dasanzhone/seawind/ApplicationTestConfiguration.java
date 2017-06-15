package com.dasanzhone.seawind;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dasanzhone.namespace.deviceservice.DeviceService;
import com.dasanzhone.namespace.weatherservice.WeatherService;
import com.dasanzhone.seawind.swservice.configuration.ApplicationConfiguration;
import com.dasanzhone.seawind.swservice.endpoint.DeviceServiceEndpoint;
import com.dasanzhone.seawind.swservice.endpoint.WeatherServiceEndpoint;

@Configuration
@Import(ApplicationConfiguration.class)
public class ApplicationTestConfiguration {

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }
    
    @Bean
    public DeviceService deviceService() {
        return new DeviceServiceEndpoint();
    }
    
}
