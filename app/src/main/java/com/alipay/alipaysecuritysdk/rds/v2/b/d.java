package com.alipay.alipaysecuritysdk.rds.v2.b;

import android.content.Context;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.alipay.mobile.verifyidentity.base.message.EnvDataConstants;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6883a = {"asdk", "board", H5GetLogInfoBridge.RESULT_BRAND, "device", "displayid", "em", EnvDataConstants.MANUFACTURER, H5GetLogInfoBridge.RESULT_MODEL, "name", "incremental", H5GetLogInfoBridge.RESULT_OS, "qemu", "osRelease", "kerver", "root", PageLog.PAGE_LOG_TAGS, "processor", "pf", "pn", "pm"};
    private Map<String, Object> b;

    public d(Context context) {
        this();
        this.b.put("asdk", com.alipay.alipaysecuritysdk.common.collector.c.l());
        this.b.put("board", com.alipay.alipaysecuritysdk.common.collector.c.c());
        this.b.put(H5GetLogInfoBridge.RESULT_BRAND, com.alipay.alipaysecuritysdk.common.collector.c.d());
        this.b.put("device", com.alipay.alipaysecuritysdk.common.collector.c.e());
        this.b.put("displayid", com.alipay.alipaysecuritysdk.common.collector.c.f());
        this.b.put("em", com.alipay.alipaysecuritysdk.common.collector.c.a(context) ? SummaryActivity.CHECKED : "false");
        this.b.put(EnvDataConstants.MANUFACTURER, com.alipay.alipaysecuritysdk.common.collector.c.h());
        this.b.put(H5GetLogInfoBridge.RESULT_MODEL, com.alipay.alipaysecuritysdk.common.collector.c.i());
        this.b.put("name", com.alipay.alipaysecuritysdk.common.collector.c.j());
        this.b.put("incremental", com.alipay.alipaysecuritysdk.common.collector.c.g());
        this.b.put(H5GetLogInfoBridge.RESULT_OS, com.alipay.alipaysecuritysdk.common.collector.c.a());
        this.b.put("qemu", com.alipay.alipaysecuritysdk.common.collector.c.n());
        this.b.put("osRelease", com.alipay.alipaysecuritysdk.common.collector.c.k());
        this.b.put("kerver", com.alipay.alipaysecuritysdk.common.collector.b.l());
        this.b.put("root", com.alipay.alipaysecuritysdk.common.collector.c.b() ? SummaryActivity.CHECKED : "false");
        this.b.put(PageLog.PAGE_LOG_TAGS, com.alipay.alipaysecuritysdk.common.collector.c.m());
        this.b.put("processor", com.alipay.alipaysecuritysdk.common.collector.b.g());
        this.b.put("pf", com.alipay.alipaysecuritysdk.common.collector.b.f());
        this.b.put("pn", com.alipay.alipaysecuritysdk.common.collector.b.e());
        this.b.put("pm", com.alipay.alipaysecuritysdk.common.collector.b.d());
    }

    private d() {
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    /* renamed from: b  reason: merged with bridge method [inline-methods] */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (String str : f6883a) {
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
