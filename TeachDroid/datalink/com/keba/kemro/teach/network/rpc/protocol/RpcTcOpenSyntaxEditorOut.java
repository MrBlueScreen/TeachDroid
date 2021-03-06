package com.keba.kemro.teach.network.rpc.protocol;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class RpcTcOpenSyntaxEditorOut implements XDR {
	public int editHnd;
	public boolean retVal;

	public RpcTcOpenSyntaxEditorOut () {
	}

	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(editHnd);
		out.writeBool(retVal);
	}

	public void read (RPCInputStream in) throws RPCException, IOException {
		editHnd = in.readInt();
		retVal = in.readBool();
	}
}