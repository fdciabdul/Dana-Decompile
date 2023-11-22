package com.alipay.alipaysecuritysdk.rds.v2.b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class f extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6885a = {"alipay", "taobao"};
    private Map<String, Object> b;

    public f() {
        this((byte) 0);
    }

    private f(byte b) {
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (String str : f6885a) {
            Object obj = this.b.get(str);
            if (obj != null && (obj instanceof String)) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused) {
                }
            } else if (obj != null && (obj instanceof b)) {
                jSONObject.put(str, ((b) obj).a());
            }
        }
        return jSONObject;
    }
}
