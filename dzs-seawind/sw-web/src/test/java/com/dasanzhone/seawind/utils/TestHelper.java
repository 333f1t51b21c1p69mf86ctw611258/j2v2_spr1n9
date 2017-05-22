package com.dasanzhone.seawind.utils;

import com.dasanzhone.namespace.weatherservice.datatypes.ProductName;
import com.dasanzhone.namespace.weatherservice.general.ForecastCustomer;
import com.dasanzhone.namespace.weatherservice.general.ForecastRequest;

public class TestHelper {

    public static ForecastRequest generateDummyRequest() {
        ForecastRequest forecastRequest = new ForecastRequest();
        forecastRequest.setZIP("99425");
        forecastRequest.setFlagcolor("blackblue");
        forecastRequest.setProductName(ProductName.FORECAST_BASIC);
        ForecastCustomer customer = new ForecastCustomer();
        customer.setAge(67);
        customer.setContribution(500);
        customer.setMethodOfPayment("Bitcoin");
        forecastRequest.setForecastCustomer(customer);
        return forecastRequest;
    }
}
