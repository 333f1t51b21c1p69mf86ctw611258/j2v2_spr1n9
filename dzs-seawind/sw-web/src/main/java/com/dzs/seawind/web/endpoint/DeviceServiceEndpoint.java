package com.dzs.seawind.web.endpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.dzs.seawind.web.controller.DeviceServiceController;

import de.codecentric.namespace.deviceservice.DeviceException;
import de.codecentric.namespace.deviceservice.DeviceService;
import de.codecentric.namespace.deviceservice.general.DeviceInformationReturn;
import de.codecentric.namespace.deviceservice.general.DeviceReturn;
import de.codecentric.namespace.deviceservice.general.ForecastRequest;
import de.codecentric.namespace.deviceservice.general.ForecastReturn;


public class DeviceServiceEndpoint implements DeviceService {

    @Autowired
    private DeviceServiceController deviceServiceController;
    
    @Override
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) throws DeviceException {
        return deviceServiceController.getCityForecastByZIP(forecastRequest);
    }
    
    @Override
    public DeviceInformationReturn getDeviceInformation(String zip)
            throws DeviceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DeviceReturn getCityDeviceByZIP(ForecastRequest forecastRequest)
            throws DeviceException {
        // TODO Auto-generated method stub
        return null;
    }

}
