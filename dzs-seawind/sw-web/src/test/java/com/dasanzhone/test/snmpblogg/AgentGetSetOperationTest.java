package com.dasanzhone.test.snmpblogg;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.event.ResponseListener;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class AgentGetSetOperationTest {

	public static final String READ_COMMUNITY = "public";
	public static final String WRITE_COMMUNITY = "private";
	public static final int mSNMPVersion = 0; // 0 represents SNMP version=1
	public static final String OID_UPS_OUTLET_GROUP1 = "1.3.6.1.4.1.318.1.1.1.12.3.2.1.3.1";
	public static final String OID_UPS_BATTERY_CAPACITY = "1.3.6.1.4.1.318.1.1.1.2.2.1.0";

	public static void main(String[] args) {
		try {
			String strIPAddress = "192.168.16.10";
			AgentGetSetOperationTest objSNMP = new AgentGetSetOperationTest();
			// objSNMP.snmpSet();
			///////////////////////////////////////////
			// Set Value=2 to trun OFF UPS OUTLET Group1
			// Value=1 to trun ON UPS OUTLET Group1
			//////////////////////////////////////////

			int Value = 2;
			objSNMP.snmpSet(strIPAddress, WRITE_COMMUNITY,
					OID_UPS_OUTLET_GROUP1, Value);
			//////////////////////////////////////////////////////////
			// Get Basic state of UPS
			/////////////////////////////////////////////////////////
			String batteryCap = objSNMP.snmpGet(strIPAddress,
					READ_COMMUNITY,
					OID_UPS_BATTERY_CAPACITY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * The following code valid only SNMP version1. This
	 * method is very useful to set a parameter on remote device.
	 */
	public void snmpSet(String host, String community, String strOID, int Value) {
		host = host + "/" + "161";
		Address tHost = GenericAddress.parse(host);
		Snmp snmp;
		try {
			TransportMapping transport = new DefaultUdpTransportMapping();
			snmp = new Snmp(transport);
			transport.listen();
			CommunityTarget target = new CommunityTarget();
			target.setCommunity(new OctetString(community));
			target.setAddress(tHost);
			target.setRetries(2);
			target.setTimeout(5000);
			target.setVersion(SnmpConstants.version1); // Set the correct SNMP version here
			PDU pdu = new PDU();
			// Depending on the MIB attribute type, appropriate casting can be done here
			pdu.add(new VariableBinding(new OID(strOID), new Integer32(Value)));
			pdu.setType(PDU.SET);
			ResponseListener listener = new ResponseListener() {
				public void onResponse(ResponseEvent event) {
					PDU strResponse;
					String result;
					((Snmp) event.getSource()).cancel(event.getRequest(), this);
					strResponse = event.getResponse();
					if (strResponse != null) {
						result = strResponse.getErrorStatusText();
						System.out.println("Set Status is: " + result);
					}
				}
			};
			snmp.send(pdu, target, null, listener);
			snmp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final int SNMP_PORT = 161;

	/*
	 * The code is valid only SNMP version1. SnmpGet method
	 * return Response for given OID from the Device.
	 */
	public String snmpGet(String strAddress, String community, String strOID) {
		String str = "";
		try {
			OctetString osCommunity = new OctetString(community);
			strAddress = strAddress + "/" + SNMP_PORT;
			Address targetaddress = new UdpAddress(strAddress);
			TransportMapping transport = new DefaultUdpTransportMapping();
			transport.listen();

			CommunityTarget comtarget = new CommunityTarget();
			comtarget.setCommunity(osCommunity);
			comtarget.setVersion(SnmpConstants.version1);
			comtarget.setAddress(targetaddress);
			comtarget.setRetries(2);
			comtarget.setTimeout(5000);

			PDU pdu = new PDU();
			ResponseEvent response;
			Snmp snmp;
			pdu.add(new VariableBinding(new OID(strOID)));
			pdu.setType(PDU.GET);
			snmp = new Snmp(transport);
			response = snmp.get(pdu, comtarget);
			if (response != null) {
				if (response.getResponse().getErrorStatusText().equalsIgnoreCase("Success")) {
					PDU pduresponse = response.getResponse();
					str = pduresponse.getVariableBindings().firstElement().toString();
					if (str.contains("=")) {
						int len = str.indexOf("=");
						str = str.substring(len + 1, str.length());
					}
				}
			} else {
				System.out.println("Feeling like a TimeOut occured ");
			}
			snmp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Response=" + str);
		return str;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
