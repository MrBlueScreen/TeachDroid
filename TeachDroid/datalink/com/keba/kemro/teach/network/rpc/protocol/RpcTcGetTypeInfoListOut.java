package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcGetTypeInfoListOut implements XDR {
	public int nrOfInfos;
	public RpcTcTypeInfo[] infos;  //variable length with max length of rpcChunkLen
	public int infos_count; //countains the number of elements
	public boolean retVal;

	public RpcTcGetTypeInfoListOut () {
		infos = new RpcTcTypeInfo[rpcChunkLen.value];
		for (int for_i = 0; for_i < rpcChunkLen.value; for_i++) {
			infos[for_i] = new RpcTcTypeInfo();
		}
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(nrOfInfos);
		out.writeInt(infos_count);
		for (int for_i = 0; for_i < infos_count; for_i++) {
			infos[for_i].write(out);
		}
		out.writeBool(retVal);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		nrOfInfos = in.readInt();
		infos_count = in.readInt();
		for (int for_i = 0; for_i < infos_count; for_i++) {
			infos[for_i].read(in);
		}
		retVal = in.readBool();
	}
}