package com.dasanzhone.seawind.swservice.util;

public class BusinessUtil {

	public static int tranformInterfaceToOid(String cli_node) {
		String[] nodes = cli_node.split("/");
		
		int LT_ID = Integer.parseInt(nodes[2]);
		int PON_ID = Integer.parseInt(nodes[3]);
		int ONT_ID = Integer.parseInt(nodes[4]);

		System.out.println("Input: 1/1/" + LT_ID + "/" + PON_ID + "/" + ONT_ID);

		int segment1 = (ONT_ID - 1) << 10;
		int segment2 = (PON_ID - 1) << 17;
		int segment3 = 0b111 << 22;
		int segment4 = (LT_ID + 1) << 25;

		int MIB_LEAF_NODE = segment1 | segment2 | segment3 | segment4;

		System.out.println("Output: " + MIB_LEAF_NODE);

		return MIB_LEAF_NODE;
	}

}
