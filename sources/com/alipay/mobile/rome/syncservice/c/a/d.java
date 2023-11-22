package com.alipay.mobile.rome.syncservice.c.a;

import com.alipay.msync.core.model.spcode.pb.ProtoSyncOpCode3002;

/* loaded from: classes3.dex */
public final class d extends a {
    @Override // com.alipay.mobile.rome.syncservice.c.a.a
    public final byte[] b() {
        com.alipay.mobile.rome.syncsdk.util.c.b("Operation3002", "sendSync3002");
        try {
            return com.alipay.mobile.rome.syncsdk.util.f.a(new ProtoSyncOpCode3002(), 3002);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("sendSync3002:  [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d("Operation3002", sb.toString());
            return null;
        }
    }
}
