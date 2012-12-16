package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcRemoveVarsFromGroupIn implements XDR {
	public int varGroupHnd;
	public int[] varId;  //variable length with max length of rpcChunkLen
	public int varId_count; //countains the number of elements

	public RpcTcRemoveVarsFromGroupIn () {
		varId = new int[rpcChunkLen.value];
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(varGroupHnd);
		out.writeInt(varId_count);
		for (int for_i = 0; for_i < varId_count; for_i++) {
			out.writeInt(varId[for_i]);
		}
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		varGroupHnd = in.readInt();
		varId_count = in.readInt();
		for (int for_i = 0; for_i < varId_count; for_i++) {
			varId[for_i] = in.readInt();
		}
	}
}