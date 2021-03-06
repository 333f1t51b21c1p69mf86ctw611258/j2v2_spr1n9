
package com.dasanzhone.namespace.deviceservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "DeviceException", targetNamespace = "http://www.dasanzhone.com/namespace/deviceservice/exception")
public class DeviceException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.dasanzhone.namespace.deviceservice.exception.DeviceException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DeviceException(String message, com.dasanzhone.namespace.deviceservice.exception.DeviceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DeviceException(String message, com.dasanzhone.namespace.deviceservice.exception.DeviceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.dasanzhone.namespace.deviceservice.exception.DeviceException
     */
    public com.dasanzhone.namespace.deviceservice.exception.DeviceException getFaultInfo() {
        return faultInfo;
    }

}
