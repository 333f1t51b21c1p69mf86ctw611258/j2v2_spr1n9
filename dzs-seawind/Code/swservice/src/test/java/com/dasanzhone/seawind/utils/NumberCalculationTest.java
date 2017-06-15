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

public class NumberCalculationTest {

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
	public void test_CalculateAluMibLeafNode() {
		// fail("Not yet implemented");

		String cli_node = "1/1/8/1/1";

		int MIB_LEAF_NODE = BusinessUtil.tranformInterfaceToOid(cli_node);

		assertEquals(MIB_LEAF_NODE, 331350016);
	}

}
