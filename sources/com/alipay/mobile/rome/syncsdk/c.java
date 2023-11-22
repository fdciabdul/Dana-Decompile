package com.alipay.mobile.rome.syncsdk;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.service.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f7216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f7216a = bVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.service.e
    public final void a(String str) {
        String str2;
        String str3;
        String str4;
        a aVar;
        a aVar2;
        String str5;
        str2 = b.f7214a;
        StringBuilder sb = new StringBuilder("onReceivedPacket[ packet=");
        sb.append(str);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("appId");
            String optString2 = jSONObject.optString("payload");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                aVar = this.f7216a.d;
                if (aVar == null) {
                    str5 = b.f7214a;
                    com.alipay.mobile.rome.syncsdk.util.c.d(str5, "onReceivedPacket: [ packetHanlder=null ]");
                    return;
                }
                aVar2 = this.f7216a.d;
                aVar2.a(optString, optString2);
                return;
            }
            str4 = b.f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, "onReceivedPacket: [ appId or appData =null or empty ]");
        } catch (JSONException e) {
            str3 = b.f7214a;
            StringBuilder sb2 = new StringBuilder("onReceivedPacket: [ Exception=");
            sb2.append(e);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb2.toString());
        }
    }

    @Override // com.alipay.mobile.rome.syncsdk.service.e
    public final void a(byte[] bArr) {
        String str;
        a aVar;
        a aVar2;
        String str2;
        str = b.f7214a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "onReceivedPacketSync");
        aVar = this.f7216a.d;
        if (aVar == null) {
            str2 = b.f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "onReceivedPacketSync: [ packetHanlder=null ]");
            return;
        }
        aVar2 = this.f7216a.d;
        aVar2.a(bArr);
    }

    @Override // com.alipay.mobile.rome.syncsdk.service.e
    public final void a() {
        String str;
        a aVar;
        a aVar2;
        String str2;
        str = b.f7214a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "onLongLinkRegistered ");
        aVar = this.f7216a.d;
        if (aVar == null) {
            str2 = b.f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "onLongLinkRegistered: [ packetHanlder=null ]");
            return;
        }
        aVar2 = this.f7216a.d;
        aVar2.a();
    }

    @Override // com.alipay.mobile.rome.syncsdk.service.e
    public final void b() {
        String str;
        a aVar;
        a aVar2;
        String str2;
        str = b.f7214a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "onLongLinkDeviceBinded： ");
        aVar = this.f7216a.d;
        if (aVar == null) {
            str2 = b.f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "onLongLinkDeviceBinded: [ packetHanlder=null ]");
            return;
        }
        aVar2 = this.f7216a.d;
        aVar2.b();
    }

    @Override // com.alipay.mobile.rome.syncsdk.service.e
    public final void c() {
        String str;
        a aVar;
        a aVar2;
        String str2;
        str = b.f7214a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "onLongLinkUserBinded： ");
        aVar = this.f7216a.d;
        if (aVar == null) {
            str2 = b.f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "onLongLinkUserBinded: [ packetHanlder=null ]");
            return;
        }
        aVar2 = this.f7216a.d;
        aVar2.c();
    }
}
