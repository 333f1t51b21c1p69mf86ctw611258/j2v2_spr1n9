package com.dasanzhone.seawind.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dasanzhone.seawind.swservice.util.BusinessUtil;

public class BusinessUtilTest {

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
	public void test_CalculateOntId() {
		// fail("Not yet implemented");

		String cli_node = "1/1/8/1/1";

		int result = BusinessUtil.convertAddressToOntId(cli_node);

		assertEquals(result, 331350016);
	}

	@Test
	public void test_CalculateOntCardSlot() {
		// fail("Not yet implemented");

		String cli_node = "1/1/8/2/1/10";

		int result = BusinessUtil.convertAddressToOntCardSlot(cli_node);

		System.out.println(result);

		assertEquals(result, 578813952);
	}

	@Test
	public void test_CalculateOntPort() {
		// fail("Not yet implemented");

		String cli_node = "1/1/8/2/1/2/1";

		int result = BusinessUtil.convertAddressToOntPort(cli_node);

		System.out.println(result);

		assertEquals(result, 302121088);
	}

	@Test
	public void test_convertSerialNumberHexStringToSerialNumberByteArrayString() {
		String result = new String(BusinessUtil.convertSerialNumberHexStringToSerialNumberByteArrayString("DSNW:6F555550"));

		assertEquals(result, "DSNWoUUP");
	}

}
