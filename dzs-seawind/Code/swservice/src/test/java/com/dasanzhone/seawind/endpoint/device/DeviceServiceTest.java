package com.dasanzhone.seawind.endpoint.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dasanzhone.namespace.deviceservice.DeviceException;
import com.dasanzhone.namespace.deviceservice.general.DeviceInformationReturn;
import com.dasanzhone.seawind.ApplicationTestConfiguration;
import com.dasanzhone.seawind.swservice.endpoint.DeviceServiceEndpoint;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class DeviceServiceTest {

    @Autowired
    private DeviceServiceEndpoint deviceServiceEndpoint;

    @Test
    public void getDeviceInformation() throws DeviceException {
        // Given
        String zip = "084";

        // When
        DeviceInformationReturn deviceInformationReturn = deviceServiceEndpoint.getDeviceInformation(zip);

        // Then
        assertNotNull(deviceInformationReturn);
        assertEquals(true, deviceInformationReturn.isSuccess());
        assertEquals("abc", deviceInformationReturn.getResponseText());
    }
}
