package com.keba.kemro.plc.network.sysrpc.TCI;

import com.keba.jrpc.rpc.*;
import java.io.*;

public class SysRpcTcErrorParamType implements XDR {
	public static final int rpcIntParam = 0;
	public static final int rpcFloatParam = 1;
	public static final int rpcStringParam = 2;
	public int value;



	public SysRpcTcErrorParamType () {
	}
	public void write (RPCOutputStream out) throws RPCException, IOException {
		out.writeInt(value); 
	}
	public void read (RPCInputStream in) throws RPCException, IOException {
		value = in.readInt(); 
	}
}