package com.alipay.alipaysecuritysdk.rds.v2.b;

import android.content.Context;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6884a = {"active", "bssid", "cid", "omac", "la", "lac", "lo", BranchLinkConstant.OauthParams.MCC, "mnc", "acc", "ssid", "strength", "carrier", "nettype", SecurityConstants.KEY_TEXT};
    private Map<String, Object> b;

    public e(Context context) {
        this();
        com.alipay.alipaysecuritysdk.common.collector.d a2 = com.alipay.alipaysecuritysdk.common.collector.d.a(context);
        this.b.put("active", com.alipay.alipaysecuritysdk.common.e.e.c(a2.e) ? "false" : SummaryActivity.CHECKED);
        String str = a2.c;
        String str2 = a2.i;
        String str3 = a2.b;
        String str4 = a2.j;
        String str5 = a2.f6872a;
        String str6 = a2.g;
        String str7 = a2.h;
        String str8 = a2.d;
        String str9 = a2.f;
        String e = com.alipay.alipaysecuritysdk.common.collector.b.e(context);
        String b = com.alipay.alipaysecuritysdk.common.collector.c.b(context);
        this.b.put("bssid", com.alipay.alipaysecuritysdk.common.e.e.c(str) ? "" : str);
        this.b.put("cid", com.alipay.alipaysecuritysdk.common.e.e.c(str2) ? "" : str2);
        this.b.put("omac", new JSONArray());
        this.b.put("la", com.alipay.alipaysecuritysdk.common.e.e.c(str3) ? "" : str3);
        this.b.put("lac", com.alipay.alipaysecuritysdk.common.e.e.c(str4) ? "" : str4);
        this.b.put("lo", com.alipay.alipaysecuritysdk.common.e.e.c(str5) ? "" : str5);
        this.b.put(BranchLinkConstant.OauthParams.MCC, com.alipay.alipaysecuritysdk.common.e.e.c(str6) ? "" : str6);
        this.b.put("mnc", com.alipay.alipaysecuritysdk.common.e.e.c(str7) ? "" : str7);
        this.b.put("acc", "");
        this.b.put("ssid", com.alipay.alipaysecuritysdk.common.e.e.c(str8) ? "" : str8);
        this.b.put("strength", com.alipay.alipaysecuritysdk.common.e.e.c(str9) ? "" : str9);
        this.b.put("carrier", com.alipay.alipaysecuritysdk.common.e.e.c(e) ? "" : e);
        this.b.put("nettype", com.alipay.alipaysecuritysdk.common.e.e.c(b) ? "" : b);
        this.b.put(SecurityConstants.KEY_TEXT, Long.valueOf(System.currentTimeMillis()));
    }

    private e() {
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (String str : f6884a) {
            Object obj = this.b.get(str);
            if (obj != null && ((obj instanceof String) || (obj instanceof JSONArray))) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
