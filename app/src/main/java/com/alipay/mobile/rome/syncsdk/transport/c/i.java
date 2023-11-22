package com.alipay.mobile.rome.syncsdk.transport.c;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7250a = "i";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public i(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 2;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        try {
            int optInt = new JSONObject(aVar.f()).optInt("reconnectTime");
            String str = f7250a;
            StringBuilder sb = new StringBuilder("processPacket: [ reconnectInterval=");
            sb.append(optInt);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            com.alipay.mobile.rome.syncsdk.a.b.b(optInt);
        } catch (JSONException e) {
            String str2 = f7250a;
            StringBuilder sb2 = new StringBuilder("processPacket: [ Exception=");
            sb2.append(e);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
        }
        this.b.f();
    }
}
