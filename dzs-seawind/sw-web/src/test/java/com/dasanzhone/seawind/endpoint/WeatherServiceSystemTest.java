package com.dasanzhone.seawind.endpoint;

import static com.dasanzhone.seawind.utils.TestHelper.generateDummyRequest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dasanzhone.namespace.weatherservice.WeatherException;
import com.dasanzhone.namespace.weatherservice.WeatherService;
import com.dasanzhone.namespace.weatherservice.general.ForecastRequest;
import com.dasanzhone.namespace.weatherservice.general.ForecastReturn;
import com.dasanzhone.seawind.SimpleBootCxfSystemTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SimpleBootCxfSystemTestApplication.class)
@WebIntegrationTest("server.port:8090")
public class WeatherServiceSystemTest {

    @Autowired
    private WeatherService weatherServiceSystemTestClient;
    
    @Test
    public void getCityForecastByZIP() throws WeatherException {
        // Given
        ForecastRequest forecastRequest = generateDummyRequest();
        
        // When
        ForecastReturn forecastReturn = weatherServiceSystemTestClient.getCityForecastByZIP(forecastRequest);
        
        // Then
        assertNotNull(forecastReturn);
        assertEquals(true, forecastReturn.isSuccess());
        assertEquals("Weimar", forecastReturn.getCity());
        assertEquals("22%", forecastReturn.getForecastResult().getForecast().get(0).getProbabilityOfPrecipiation().getDaytime());
    }
}
