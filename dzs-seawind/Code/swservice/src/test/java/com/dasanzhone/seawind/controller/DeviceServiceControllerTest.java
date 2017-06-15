package com.dasanzhone.seawind.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dasanzhone.namespace.deviceservice.general.OntInput;
import com.dasanzhone.seawind.ApplicationTestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfiguration.class)
public class DeviceServiceControllerTest {

	@Autowired
	private DeviceServiceController deviceServiceController;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_declareOntId() {
		OntInput ontInput = new OntInput();
		ontInput.setOntInterface("1/1/1/1/30");
		ontInput.setSwVerPland("auto");
		ontInput.setSwDnloadVersion("auto");
		ontInput.setSernum("DSNWoUUP");
		ontInput.setFecUp("enable");
		ontInput.setEnableAes("enable");
		ontInput.setPlndVar("H646EW");
		
		deviceServiceController.declareOntId(ontInput);
	}

}
