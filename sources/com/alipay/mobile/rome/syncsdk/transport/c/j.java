package com.alipay.mobile.rome.syncsdk.transport.c;

import android.text.TextUtils;
import com.alipay.msync.server.model.MsyncInitReturnMessage;

/* loaded from: classes3.dex */
public class j implements a {

    /* renamed from: a */
    private static final String f7251a = "j";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public j(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 0;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        String str;
        this.b.a(System.currentTimeMillis());
        byte[] e = aVar.e();
        if (e == null || e.length <= 0) {
            str = "";
        } else {
            MsyncInitReturnMessage msyncInitReturnMessage = (MsyncInitReturnMessage) com.alipay.mobile.rome.syncsdk.util.f.a(e, MsyncInitReturnMessage.class);
            if (msyncInitReturnMessage == null) {
                com.alipay.mobile.rome.syncsdk.util.c.d(f7251a, "processPacket parsePBObject exception, pb is null.");
                return;
            }
            if (msyncInitReturnMessage.keepLiveTime != null && msyncInitReturnMessage.keepLiveTime.intValue() > 0) {
                com.alipay.mobile.rome.syncsdk.a.b.c(msyncInitReturnMessage.keepLiveTime.intValue());
            }
            if (msyncInitReturnMessage.heartTimeOut != null && msyncInitReturnMessage.heartTimeOut.intValue() > 0) {
                com.alipay.mobile.rome.syncsdk.a.b.a(msyncInitReturnMessage.heartTimeOut.intValue());
            }
            String str2 = msyncInitReturnMessage.cdid;
            if (!TextUtils.isEmpty(str2)) {
                com.alipay.mobile.rome.syncsdk.a.a.a().a(this.b.f7222a, str2);
            }
            str = msyncInitReturnMessage.action;
            if (msyncInitReturnMessage.nextConnectItvl.intValue() >= 10 && msyncInitReturnMessage.nextConnectItvl.intValue() <= 600) {
                String str3 = f7251a;
                StringBuilder sb = new StringBuilder("ImplRegister processPacket: [ flow control =");
                sb.append(msyncInitReturnMessage.nextConnectItvl);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.c(str3, sb.toString());
                long intValue = msyncInitReturnMessage.nextConnectItvl.intValue() * 1000;
                this.b.e();
                com.alipay.mobile.rome.syncsdk.service.f.a().b(intValue);
                return;
            }
        }
        String str4 = f7251a;
        StringBuilder sb2 = new StringBuilder("processPacket： [ action=");
        sb2.append(str);
        sb2.append(" ][ replyTimeout=");
        sb2.append(com.alipay.mobile.rome.syncsdk.a.b.a());
        sb2.append(" ][ keepLiveTime=");
        sb2.append(com.alipay.mobile.rome.syncsdk.a.b.c());
        sb2.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.a(str4, sb2.toString());
        this.b.s();
        com.alipay.mobile.rome.syncsdk.service.e l = this.b.l();
        if (l == null) {
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, "processPacket: [ longLinkNotifer=null ]");
            return;
        }
        this.b.b(System.currentTimeMillis());
        String str5 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        String f = com.alipay.mobile.rome.syncsdk.a.a.a().f();
        int i = k.f7252a[this.b.b().ordinal()];
        if (i == 1) {
            if ("unbind".equals(str)) {
                com.alipay.mobile.rome.syncsdk.util.c.a(str4, "processPacket: [ unbind don't need send device register 1001 ]");
            } else {
                l.b();
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(f)) {
                this.b.i();
            }
        } else if (i == 2) {
            l.a();
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(f)) {
                this.b.j();
            }
        } else if (i == 3) {
            l.c();
            if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(f)) {
                this.b.j();
            }
        }
        com.alipay.mobile.rome.syncsdk.a.c.d();
        if (com.alipay.mobile.rome.syncsdk.transport.a.a().equals("https")) {
            com.alipay.mobile.rome.syncsdk.service.f.a().b(com.alipay.mobile.rome.syncsdk.a.b.c());
        }
    }
}
