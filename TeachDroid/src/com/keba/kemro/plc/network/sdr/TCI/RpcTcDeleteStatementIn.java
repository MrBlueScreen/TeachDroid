package com.keba.kemro.plc.network.sdr.TCI;

import com.keba.jsdr.sdr.*;
import java.io.*;

public class RpcTcDeleteStatementIn implements SDR {
   /** Int */
   public int clientId;
   /** Int */
   public int routineHnd;
   /** RpcTcPos */
   public RpcTcPos begPos;
   /** RpcTcPos */
   public RpcTcPos endPos;

   /** Added by SdrGen */
   private int mMemberDone = 0;

   public RpcTcDeleteStatementIn() {
      begPos = new RpcTcPos();
      endPos = new RpcTcPos();
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
         routineHnd = in.readInt(context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
      if (mMemberDone == actMember) {
         begPos.read(in, context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
      if (mMemberDone == actMember) {
         endPos.read(in, context);
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
         out.writeInt(routineHnd, context);
         if (!context.done)
            return;
         mMemberDone++;
      }
      actMember++;
      if (mMemberDone == actMember) {
         begPos.write(out, context);
         if (!context.done)
            return;
         mMemberDone++;
         begPos.reset(); //done for multiple use of input parameters
      }
      actMember++;
      if (mMemberDone == actMember) {
         endPos.write(out, context);
         if (!context.done)
            return;
         mMemberDone++;
         endPos.reset(); //done for multiple use of input parameters
      }
      actMember++;
   }

   public int size() {
      int size = 0;
      size += SDRUtil.sizeInt(clientId);
      size += SDRUtil.sizeInt(routineHnd);
      size += begPos.size();
      size += endPos.size();
      return size;
   }

   public void reset() {
      mMemberDone = 0;
      begPos.reset();
      endPos.reset();
   }
}
