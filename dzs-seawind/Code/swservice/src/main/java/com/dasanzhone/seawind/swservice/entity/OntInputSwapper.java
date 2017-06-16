package com.dasanzhone.seawind.swservice.entity;

import org.apache.cxf.common.util.StringUtils;

import com.dasanzhone.namespace.deviceservice.general.OntInput;

public class OntInputSwapper {

	private static final String STRING_DOWN = "DOWN";
	private static final String STRING_UP = "UP";
	private static final String STRING_DISABLE = "DISABLE";
	private static final String STRING_ENABLE = "ENABLE";

	private final OntInput ontInput;

	public OntInputSwapper(OntInput ontInput) {
		this.ontInput = ontInput;
	}

	public String getOntInterface() {
		return this.ontInput.getOntInterface();
	}

	public String getSwVerPland() {
		return this.ontInput.getSwVerPland();
	}

	public String getSwDnloadVersion() {
		return this.ontInput.getSwDnloadVersion();
	}

	public String getSernum() {
		return this.ontInput.getSernum();
	}

	public String getFecUp() {
		String first = this.ontInput.getFecUp();
		String swapper = null;

		if (STRING_ENABLE.equalsIgnoreCase(first)) {
			swapper = "1";
		} else if (STRING_DISABLE.equalsIgnoreCase(first)) {
			swapper = "2";
		}

		return swapper;
	}

	public String getEnableAes() {
		String first = this.ontInput.getEnableAes();
		String swapper = null;

		if (STRING_ENABLE.equalsIgnoreCase(first)) {
			swapper = "1";
		} else if (STRING_DISABLE.equalsIgnoreCase(first)) {
			swapper = "0";
		}

		return swapper;
	}

	public String getPlndVar() {
		return this.ontInput.getPlndVar();
	}

	public String getOpticsHist() {
		String first = STRING_ENABLE.equalsIgnoreCase(this.ontInput.getOpticsHist()) || STRING_DISABLE.equalsIgnoreCase(this.ontInput.getOpticsHist())
				? this.ontInput.getOpticsHist() : STRING_DISABLE;

		String swapper = null;

		if (STRING_ENABLE.equalsIgnoreCase(first)) {
			swapper = "1";
		} else if (STRING_DISABLE.equalsIgnoreCase(first)) {
			swapper = "2";
		}

		return swapper;
	}

	public String getBerint() {
		if (StringUtils.isEmpty(this.ontInput.getBerint())) {
			return "8000";
		}

		return this.ontInput.getBerint();
	}

	public String getProvversion() {
		if (StringUtils.isEmpty(this.ontInput.getProvversion())) {
			return "*";
		}

		return this.ontInput.getProvversion();
	}

	public String getAdminState() {
		String first = this.ontInput.getAdminState();
		String swapper = null;

		if (STRING_UP.equalsIgnoreCase(first)) {
			swapper = "1";
		} else if (STRING_DOWN.equalsIgnoreCase(first)) {
			swapper = "2";
		}

		return swapper;
	}

}
