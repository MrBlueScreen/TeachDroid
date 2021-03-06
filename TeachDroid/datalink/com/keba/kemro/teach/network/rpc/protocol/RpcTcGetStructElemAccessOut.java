package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcGetStructElemAccessOut implements XDR {
	public RpcTcVarAccess elemAccess;
	public boolean retVal;

	public RpcTcGetStructElemAccessOut () {
		elemAccess = new RpcTcVarAccess();
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		elemAccess.write(out);
		out.writeBool(retVal);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		elemAccess.read(in);
		retVal = in.readBool();
	}
}