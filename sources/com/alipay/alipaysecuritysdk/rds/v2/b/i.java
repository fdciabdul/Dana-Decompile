package com.alipay.alipaysecuritysdk.rds.v2.b;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class i extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6891a = {"appKey", SecurityConstants.KEY_TEXT, "wua"};
    private Map<String, Object> b;

    public i() {
        this((byte) 0);
    }

    private i(byte b) {
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (String str : f6891a) {
            Object obj = this.b.get(str);
            if (obj != null && (obj instanceof String)) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
