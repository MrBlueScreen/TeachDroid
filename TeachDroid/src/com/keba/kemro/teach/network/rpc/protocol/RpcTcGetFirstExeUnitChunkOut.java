package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcGetFirstExeUnitChunkOut implements XDR {
	public int iterHnd;
	public int nrOfExeUnitHnd;
	public int[] exeUnitHnd;  //variable length with max length of rpcChunkLen
	public int exeUnitHnd_count; //countains the number of elements
	public boolean retVal;

	public RpcTcGetFirstExeUnitChunkOut () {
		exeUnitHnd = new int[rpcChunkLen.value];
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(iterHnd);
		out.writeInt(nrOfExeUnitHnd);
		out.writeInt(exeUnitHnd_count);
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			out.writeInt(exeUnitHnd[for_i]);
		}
		out.writeBool(retVal);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		iterHnd = in.readInt();
		nrOfExeUnitHnd = in.readInt();
		exeUnitHnd_count = in.readInt();
		for (int for_i = 0; for_i < exeUnitHnd_count; for_i++) {
			exeUnitHnd[for_i] = in.readInt();
		}
		retVal = in.readBool();
	}
}