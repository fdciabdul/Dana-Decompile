package com.alipay.alipaysecuritysdk.rds.v2.b;

import com.alibaba.griver.core.jsapi.actionsheet.ActionSheetItem;
import com.alipay.alipaysecuritysdk.rds.v2.face.RDSClient;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class j extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6892a = {SecurityConstants.KEY_TEXT, ActionSheetItem.BadgeInfo.TYPE_NUM, "action"};
    public Map<String, Object> b;
    public AtomicInteger c;
    public AtomicInteger d;
    public com.alipay.alipaysecuritysdk.rds.v2.b.a.d e;
    public b f;
    private long g;

    public j() {
        this((byte) 0);
        this.e = new com.alipay.alipaysecuritysdk.rds.v2.b.a.d();
        this.b.put(SecurityConstants.KEY_TEXT, String.valueOf(this.g));
        this.b.put(ActionSheetItem.BadgeInfo.TYPE_NUM, String.valueOf(this.c));
        this.b.put("action", this.e);
    }

    private j(byte b) {
        this.b = new HashMap();
        this.g = System.currentTimeMillis();
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(0);
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (String str : f6892a) {
            Object obj = this.b.get(str);
            if (obj != null && (obj instanceof String)) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused) {
                    RDSClient.isDebug();
                }
            } else if (obj != null && (obj instanceof b)) {
                try {
                    jSONObject.put(str, ((b) obj).a());
                } catch (JSONException e) {
                    if (RDSClient.isDebug()) {
                        com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-rds", e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            String b = b(str, str2);
            this.c.incrementAndGet();
            b bVar = this.f;
            if (bVar == null) {
                return;
            }
            if (bVar != null && (bVar instanceof com.alipay.alipaysecuritysdk.rds.v2.b.a.a)) {
                this.e.a("", false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                return;
            }
            com.alipay.alipaysecuritysdk.rds.v2.b.a.a aVar = new com.alipay.alipaysecuritysdk.rds.v2.b.a.a(str, str2, b, this.d.incrementAndGet());
            aVar.c();
            this.e.a(aVar);
            this.f = aVar;
        }
    }

    public final void a(String str, String str2, String str3) {
        synchronized (this) {
            String b = b(str, str2);
            this.c.incrementAndGet();
            b bVar = this.f;
            if (bVar == null) {
                return;
            }
            if (bVar instanceof com.alipay.alipaysecuritysdk.rds.v2.b.a.b) {
                this.e.a(str3, false, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                return;
            }
            com.alipay.alipaysecuritysdk.rds.v2.b.a.b bVar2 = new com.alipay.alipaysecuritysdk.rds.v2.b.a.b(str, str2, b, this.d.incrementAndGet());
            bVar2.b(str3);
            this.e.a(bVar2);
            this.f = bVar2;
        }
    }

    public final void a(String str, String str2, boolean z) {
        synchronized (this) {
            String b = b(str, str2);
            this.c.incrementAndGet();
            b bVar = this.f;
            if (bVar == null) {
                return;
            }
            if (bVar instanceof com.alipay.alipaysecuritysdk.rds.v2.b.a.c) {
                this.e.a("", z, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                return;
            }
            com.alipay.alipaysecuritysdk.rds.v2.b.a.c cVar = new com.alipay.alipaysecuritysdk.rds.v2.b.a.c(str, str2, b, this.d.incrementAndGet());
            cVar.a(z);
            this.e.a(cVar);
            this.f = cVar;
        }
    }

    public static String b(String str, String str2) {
        return com.alipay.alipaysecuritysdk.common.e.e.c(str) ? "2" : com.alipay.alipaysecuritysdk.common.e.e.c(str2) ? "1" : "0";
    }
}
