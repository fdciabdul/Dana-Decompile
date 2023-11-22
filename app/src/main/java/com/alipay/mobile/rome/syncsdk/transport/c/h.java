package com.alipay.mobile.rome.syncsdk.transport.c;

import com.alipay.mobile.rome.syncsdk.msg.MsgInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7249a = "h";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public h(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 4;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        String str = f7249a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "processPacket: [ PacketListenerImplNotification ] ");
        String f = aVar.f();
        if (f.length() == 0) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "processPacket: [ jsonString=null ]");
        }
        try {
            JSONObject jSONObject = new JSONObject(f);
            MsgInfo msgInfo = new MsgInfo();
            msgInfo.setUserId(jSONObject.optString("linkToken"));
            msgInfo.setMsgData(jSONObject.optString("msgData"));
            msgInfo.setMsgKey(jSONObject.optString("msgKey"));
            msgInfo.setTimestamp(jSONObject.optString("msgCreateTime"));
            StringBuilder sb = new StringBuilder();
            sb.append(msgInfo.getTimestamp());
            sb.append(msgInfo.getMsgKey());
            msgInfo.setPerMsgId(sb.toString());
            StringBuilder sb2 = new StringBuilder("handlePushMsg:[ msgkey=");
            sb2.append(msgInfo.getMsgKey());
            sb2.append(" ][ timestamp=");
            sb2.append(msgInfo.getTimestamp());
            sb2.append(" ][ userId=");
            sb2.append(msgInfo.getUserId());
            sb2.append(" ][ msgData=");
            sb2.append(msgInfo.getMsgData());
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb2.toString());
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "dispatchMsgData: ");
            com.alipay.mobile.rome.syncsdk.msg.b bVar = new com.alipay.mobile.rome.syncsdk.msg.b(this.b.f7222a);
            bVar.a(msgInfo.getUserId());
            if (bVar.a(msgInfo)) {
                com.alipay.mobile.rome.syncsdk.util.c.c(str, "dispatchMsgData: Duplicated Packet ");
            } else {
                bVar.b(msgInfo);
                com.alipay.mobile.rome.syncsdk.util.c.a(str, "dispatchMsgData: saved msg ");
                if (this.b.l() == null) {
                    com.alipay.mobile.rome.syncsdk.util.c.d(str, "dispatchMsgData: [ packetNotifier=null ] ");
                } else {
                    this.b.l().a(msgInfo.getMsgData());
                }
            }
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "handlePacketResponse: ");
            if (aVar.b() != 1) {
                com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
                a2.a(4);
                a2.b(1);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("linkToken", com.alipay.mobile.rome.syncsdk.a.a.a().f7211a);
                    jSONObject2.put("msgKey", msgInfo.getMsgKey());
                    a2.a(jSONObject2.toString());
                    this.b.k().a(a2);
                } catch (Exception e) {
                    String str2 = f7249a;
                    StringBuilder sb3 = new StringBuilder("handlePacketResponse: [ Exception=");
                    sb3.append(e);
                    sb3.append(" ]");
                    com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb3.toString());
                }
            }
        } catch (JSONException e2) {
            String str3 = f7249a;
            StringBuilder sb4 = new StringBuilder("processPacket: [ Exception=");
            sb4.append(e2);
            sb4.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb4.toString());
        }
    }
}
