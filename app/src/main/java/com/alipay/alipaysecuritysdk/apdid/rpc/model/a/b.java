package com.alipay.alipaysecuritysdk.apdid.rpc.model.a;

import com.alipay.alipaysecuritysdk.common.e.c;
import com.alipay.alipaysecuritysdk.common.e.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6866a = false;
    public String b = "";
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Map<String, String> i;

    public final String b() {
        return c.a(this.i, "apse_degrade");
    }

    public final String c() {
        return c.a(this.i, "webrtcUrl");
    }

    public final String d() {
        return c.a(this.i, "timeInterval");
    }

    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", this.f6866a);
            jSONObject.put("token", this.d);
            jSONObject.put("apdid", this.c);
            jSONObject.put("lastTime", this.e);
            jSONObject.put("vkeySwitch", this.f);
            jSONObject.put("bugTrackSwitch", this.g);
            jSONObject.put("dynamicKey", this.h);
            jSONObject.put("resultData", c.a(this.i));
            return jSONObject.toString();
        } catch (JSONException e) {
            com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-apdid", e);
            return "{}";
        }
    }

    public final boolean e() {
        return "1".equals(this.g);
    }

    public final int a() {
        return this.f6866a ? e.c(this.c) ? 2 : 1 : "APPKEY_ERROR".equals(this.b) ? 3 : 2;
    }
}
