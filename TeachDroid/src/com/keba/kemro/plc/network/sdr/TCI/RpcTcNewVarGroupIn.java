package com.keba.kemro.plc.network.sdr.TCI;

import com.keba.jsdr.sdr.*;
import java.io.*;

public class RpcTcNewVarGroupIn implements SDR {
   /** Int */
   public int clientId;
   /** String */
   public StringBuffer groupName;

   /** Added by SdrGen */
   private int mMemberDone = 0;

   public RpcTcNewVarGroupIn() {
      groupName = new StringBuffer();
   }

   public void read(SDRInputStream in, SDRContext context) throws SDRException, IOException {
      /** Added by SdrGen */
      int actMember = 0;

      if (mMemberDone == actMember) {
         clientId = in.readInt(context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
      if (mMemberDone == actMember) {
         groupName = in.readString(groupName, context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
   }

   public void write(SDROutputStream out, SDRContext context) throws SDRException, IOException {
      /** Added by SdrGen */
      int actMember = 0;

      if (mMemberDone == actMember) {
         out.writeInt(clientId, context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
      if (mMemberDone == actMember) {
         if (groupName.length() > TCI.rpcMaxNameLen)
            throw new java.lang.IllegalArgumentException();
         out.writeString(groupName, context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
   }

   public int size() {
      int size = 0;
      size += SDRUtil.sizeInt(clientId);
      size += SDRUtil.sizeString(groupName);
      return size;
   }

   public void reset() {
      mMemberDone = 0;
   }
}
