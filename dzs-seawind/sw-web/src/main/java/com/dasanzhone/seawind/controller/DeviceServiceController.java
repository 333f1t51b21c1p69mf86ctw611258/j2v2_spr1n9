package com.dasanzhone.seawind.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.Variable;
import org.springframework.stereotype.Component;

import com.dasanzhone.namespace.deviceservice.general.DeviceInformationReturn;
import com.dasanzhone.namespace.deviceservice.general.ForecastRequest;
import com.dasanzhone.namespace.deviceservice.general.ForecastReturn;
import com.dasanzhone.seawind.service.SnmpManager;

/*
 *  Example-Controller:
 *  This Class would be responsible for Mapping from Request to internal Datamodel (and backwards),
 *  for calling Backend-Services and handling Backend-Exceptions
 *  So it decouples the WSDL-generated Classes from the internal Classes - for when the former changes,
 *  nothing or only the mapping has to be changed
 */
@Component
public class DeviceServiceController {

	private static final Logger LOG = LoggerFactory.getLogger(DeviceServiceController.class);

	public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) {
		/*
		 * We leave out inbound transformation, plausibility-checking, logging,
		 * backend-calls e.g. for the moment
		 *
		 * Just some Log-Statements here :)
		 */
		LOG.info("Starting inbound transformation into internal datamodel");

		LOG.info("Checking plausibility of data");

		LOG.info("Calling Backend No. 1");

		LOG.info("Calling Backend No. 2");

		LOG.info("Starting outbound transformation into external datamodel");

		return null; // GetCityForecastByZIPOutMapper.mapGeneralOutlook2Forecast();
	}

	/*
	 * Other Methods would follow here...
	 */
	// public DeviceReturn getCityDeviceByZIP(ForecastRequest forecastRequest)
	// throws BusinessException {}

	public DeviceInformationReturn getDeviceInformation(String zip) throws IOException {
		/**
		 * Port 161 is used for Read and Other operations Port 162 is used for
		 * the trap generation
		 */
		SnmpManager client = new SnmpManager("udp:10.72.200.125/161");
		client.start();

		/**
		 * OID - .1.3.6.1.2.1.1.1.0 => SysDec OID - .1.3.6.1.2.1.1.5.0 =>
		 * SysName => MIB explorer will be usefull here, as discussed in
		 * previous article
		 */
		// final String oid = ".1.3.6.1.4.1.637.61.1.35.10.1.1.5.331481088";
		final String oid = ".1.3.6.1.4.1.637.61.1.35.10.1.1.82.331481088";

		Variable var = client.getAsVariable(new OID(oid));

		OctetString sysDescr = (OctetString) var;

		LOG.info(String.format("sysDescr [%s] = %s", oid, sysDescr.toString()));

		DeviceInformationReturn deviceInformationReturn = new DeviceInformationReturn();

		deviceInformationReturn.setResponseText(sysDescr.toString());
		deviceInformationReturn.setSuccess(true);

		return deviceInformationReturn;
	}

}
