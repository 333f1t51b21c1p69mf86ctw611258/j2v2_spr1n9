package com.dzs.seawind.web.controller;

import org.springframework.stereotype.Component;

import de.codecentric.namespace.deviceservice.general.ForecastRequest;
import de.codecentric.namespace.deviceservice.general.ForecastReturn;

/*
 *  Example-Controller:
 *  This Class would be responsible for Mapping from Request to internal Datamodel (and backwards),
 *  for calling Backend-Services and handling Backend-Exceptions
 *  So it decouples the WSDL-generated Classes from the internal Classes - for when the former changes,
 *  nothing or only the mapping has to be changed
 */ 
@Component
public class DeviceServiceController {
 
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) {
	    /*
	     * We leave out inbound transformation, plausibility-checking, logging, backend-calls e.g.
	     * for the moment
	     */
        return null;
	}
	
	/*
	 * Other Methods would follow here...
	 */
	//public DeviceReturn getCityDeviceByZIP(ForecastRequest forecastRequest) throws BusinessException {}

	//public DeviceInformationReturn getDeviceInformation(String zip) throws BusinessException {}
}
