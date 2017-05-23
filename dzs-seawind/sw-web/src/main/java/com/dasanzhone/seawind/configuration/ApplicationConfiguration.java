package com.dasanzhone.seawind.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dasanzhone.seawind.controller.DeviceServiceController;
import com.dasanzhone.seawind.controller.WeatherServiceController;


@Configuration
public class ApplicationConfiguration {

	@Bean
	public WeatherServiceController weatherServiceController() {
		return new WeatherServiceController();
	}
	
	@Bean
	public DeviceServiceController deviceServiceController() {
		return new DeviceServiceController();
	}
	
}
