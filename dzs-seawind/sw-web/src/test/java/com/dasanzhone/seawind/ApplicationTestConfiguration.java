package com.dasanzhone.seawind;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dasanzhone.namespace.weatherservice.WeatherService;
import com.dasanzhone.seawind.configuration.ApplicationConfiguration;
import com.dasanzhone.seawind.endpoint.WeatherServiceEndpoint;

@Configuration
@Import(ApplicationConfiguration.class)
public class ApplicationTestConfiguration {

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceEndpoint();
    }
}
