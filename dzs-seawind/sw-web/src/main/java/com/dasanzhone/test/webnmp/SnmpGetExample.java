package com.dasanzhone.test.webnmp;
/*$Id: SnmpGetExample.src,v 1.3 2002/09/09 05:36:28 tonyjpaul Exp $*/

import java.util.ArrayList;
import java.util.List;

/*
 * @(#)SnmpGetExample.java
 * Copyright (c) 2012 ZOHO Corp. All Rights Reserved.
 * Please read the associated COPYRIGHTS file for more details.
 */

/** 
 *  Get SNMP data based on command line arguments.  Loads MIBs 
 *  as specified, and converts to/from names for loaded MIB data. 
 *
 * [-d]                - Debug output. By default off.
 * [-c] <community>    - community String. By default "public".
 * [-p] <port>         - remote port no. By default 161.
 * [-t] <Timeout>      - Timeout. By default 5000ms.
 * [-r] <Retries>      - Retries. By default 0.      
 * [-m] <mibs>           - The mibs to be loaded.
 *<img SRC="images/v3only.jpg" ALT="v3 only"> [-v] <version>      - version(v1 / v2 / v3). By default v1.
 * [-u] <username>     - The v3 principal/userName
 * [-a] <autProtocol>  - The authProtocol(MD5/SHA). Mandatory if authPassword is specified
 * [-w] <authPassword> - The authentication password.
 * [-s] <privPassword> - The privacy protocol password. Must be accompanied with auth password and authProtocol fields.
 * [-n] <contextName>  - The snmpv3 contextName to be used.
 * [-i] <contextID>    - The snmpv3 contextID to be used.
 * host Mandatory      - The RemoteHost (agent).Format (string without double qoutes/IpAddress).
 * OID  Mandatory      - Give multiple no. of Object Identifiers.
 */
import com.adventnet.snmp.beans.SnmpTarget;
import com.adventnet.snmp.snmp2.SnmpVar;
import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class SnmpGetExample {

	// private static final int COMMUNITY = 1;
	// private static final int PORT = 2;
	// private static final int RETRIES = 3;
	// private static final int TIMEOUT = 4;
	// private static final int MIBS = 5;
	//
	// private static final int VERSION = 0;
	// private static final int USER_NAME = 6;
	// private static final int AUTH_PROTOCOL = 7;
	// private static final int AUTH_PASSWORD = 8;
	// private static final int PRIV_PASSWORD = 9;
	// private static final int CONTEXT_NAME = 10;
	// private static final int CONTEXT_ID = 11;
	// private static final int DEBUG = 12;

	class PossibleVersion implements IParameterValidator {
		public void validate(String name, String value)
				throws ParameterException {

			if (!"v1".equals(value) && !"v2".equals(value) && !"v3".equals(value)) {
				throw new ParameterException("Parameter " + name + " should be 'v1' or 'v2' or 'v3' (found " + value + ")");
			}
		}
	}

	@Parameter(names = { "--version", "-v" }, description = "version(v1,v2,v3)", validateWith = PossibleVersion.class)
	private String version;
	@Parameter(names = { "--mibs", "-m" }, description = "MIB_files")
	private String mibs;
	@Parameter(names = { "--community", "-c" })
	private String community;
	@Parameter(names = { "--port", "-p" })
	private String port;
	@Parameter(names = { "--timeout", "-t" })
	private String timeout;
	@Parameter(names = { "--retries", "-r" })
	private String retries;
	@Parameter(names = { "--user", "-u" })
	private String user;
	@Parameter(names = { "--auth_protocol", "-a" }, description = "auth_protocol(MD5/SHA)")
	private String authProtocol;
	@Parameter(names = { "--auth_password", "-w" })
	private String authPassword;
	@Parameter(names = { "--priv_password", "-s" })
	private String privPassword;
	@Parameter(names = { "--contextName", "-n" })
	private String contextName;
	@Parameter(names = { "--contextID", "-i" })
	private String contextID;
	@Parameter(names = { "--debug", "-d" })
	private String debug;
	@Parameter(names = { "--host", "-h" }, required = true)
	private String host;
	@Parameter(names = { "--oid", "-o" }, required = true, variableArity = true)
	private List<String> oids = new ArrayList<String>();

	public static void main(String args[]) {
		SnmpGetExample example = new SnmpGetExample();

		JCommander.newBuilder()
				.addObject(example)
				.build()
				.parse(args);

		example.run();

		System.exit(0);

	}

	public void run() {
		// Take care of getting options
		String usage = "SnmpGetExample [-v version(v1,v2,v3)] [-m MIB_files] [-c community] [-p port] [-t timeout] [-r retries]"
				+ " [-u user] [-a auth_protocol(MD5/SHA)] [-w auth_password] [-s priv_password] [-n contextName] [-i contextID] [-d] host"
				+ " OID [OID] ...";
		String options[] = { "-v", "-c", "-p", "-r", "-t", "-m", "-u", "-a", "-w", "-s", "-n", "-i", "-d" };
		// String values[] = { null, null, null, null, null, null, null, null, null, null, null, null, "None" };

		String authProtocol = new String("NO_AUTH");

		// ParseOptions opt = new ParseOptions(args, options, values, usage);

		// // check for at least hostname and one OID in remaining arguments
		// if (opt.remArgs.length < 2)
		// opt.usage_error();
		// if ((version == "v3") && (user == null))
		// opt.usage_error();

		// Use an SNMP target bean to perform SNMP operations
		SnmpTarget target = new SnmpTarget();

		// To load MIBs from compiled file
		target.setLoadFromCompiledMibs(true);

		if (debug != null && debug.equals("Set"))
			target.setDebug(true);

		if (version != null) { // if SNMP version is specified, set it
			if (version.equals("v2"))
				target.setSnmpVersion(SnmpTarget.VERSION2C);
			else if (version.equals("v1"))
				target.setSnmpVersion(SnmpTarget.VERSION1);
			else if (version.equals("v3"))
				target.setSnmpVersion(SnmpTarget.VERSION3);
			else {
				System.out.println("Invalid Version Number");
				System.exit(1);
			}
		}

		target.setTargetHost(host); // set the agent hostname
		if (community != null) // set the community if specified
			target.setCommunity(community);

		try { // set the timeout/retries/port parameters, if specified
			if (port != null)
				target.setTargetPort(Integer.parseInt(port));
			if (retries != null)
				target.setRetries(Integer.parseInt(retries));
			if (timeout != null)
				target.setTimeout(Integer.parseInt(timeout));
		} catch (NumberFormatException ex) {
			System.err.println("Invalid Integer Argument " + ex);
		}

		if (target.getSnmpVersion() == target.VERSION3) {
			if (user != null)
				target.setPrincipal(user);
			if (authProtocol != null) {
				// System.out.println("authProtocol = " + authProtocol);
				authProtocol = authProtocol;
			}
			if (authProtocol.equals("SHA"))
				target.setAuthProtocol(target.SHA_AUTH);
			else if (authProtocol.equals("MD5"))
				target.setAuthProtocol(target.MD5_AUTH);
			else
				target.setAuthProtocol(target.NO_AUTH);
			if (authPassword != null)
				target.setAuthPassword(authPassword);
			if (privPassword != null)
				target.setPrivPassword(privPassword);
			if (contextName != null)
				target.setContextName(contextName);
			if (contextID != null)
				target.setContextID(contextID);
		}

		if (mibs != null)
			try { // Load the MIB files
				System.err.println("Loading MIBs: " + mibs);
				target.loadMibs(mibs);
			} catch (Exception ex) {
				System.err.println("Error loading MIBs: " + ex);
			}

		if (target.getSnmpVersion() == target.VERSION3) {
			target.create_v3_tables();
		}

		// create OID array from command line arguments
		// String oids[] = new String[opt.remArgs.length - 1];
		// for (int i = 1; i < opt.remArgs.length; i++)
		// oids[i - 1] = opt.remArgs[i];

		// Set the OID List on the SnmpTarget instance
		target.setObjectIDList(oids.toArray(new String[0]));

		SnmpVar[] result = target.snmpGetVariables(); // do a get request

		if (result == null) {
			System.err.println("Request failed or timed out. \n" +
					target.getErrorString());

		} else { // print the values
			System.out.println("Response received.  Values:");

			for (int i = 0; i < oids.size(); i++) {
				System.out.println(target.getObjectID(i) + ": '" + result[i] + "'");
			}
		}
	}

}
