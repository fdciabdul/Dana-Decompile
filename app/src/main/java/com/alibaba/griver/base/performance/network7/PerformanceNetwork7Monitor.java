package com.alibaba.griver.base.performance.network7;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.performance.PerformanceBaseMonitor;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PerformanceNetwork7Monitor extends PerformanceBaseMonitor {
    public static final String KEY_GRIVER_MPP_IMG_NON_CACHE = "griver_mpp_img_non_cache";
    public static final String KEY_GRIVER_MPP_NETWORK_HTTP = "griver_mpp_network_http";

    /* renamed from: a  reason: collision with root package name */
    private PerformanceNetwork7Model f6338a = new PerformanceNetwork7Model();
    private List<String> b = new ArrayList();

    public void setNetWorkHttp(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String scheme = parse.getScheme();
        String host = parse.getHost();
        String path = parse.getPath();
        if (!SemanticAttributes.FaasTriggerValues.HTTP.equals(scheme) || TextUtils.isEmpty(host)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(host);
        sb.append(path);
        this.f6338a.setNetWorkHttp(sb.toString());
    }

    public void setImageCacheData(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String host = parse.getHost();
        String path = parse.getPath();
        if (TextUtils.isEmpty(host)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(host);
        sb.append(path);
        this.b.add(sb.toString());
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void clear() {
        this.f6338a.clear();
        this.b.clear();
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public void upload(App app) {
        Map<String, String> uploadMap = this.f6338a.getUploadMap();
        if (uploadMap != null) {
            GriverMonitor.event(KEY_GRIVER_MPP_NETWORK_HTTP, "GriverAppContainer", getExtendInfo(app, uploadMap));
        }
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.size() > 0) {
            GriverMonitor.event(KEY_GRIVER_MPP_IMG_NON_CACHE, "GriverAppContainer", getExtendInfo(app, arrayList));
        }
    }

    @Override // com.alibaba.griver.base.performance.PerformanceMonitor
    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        if (this.f6338a.getUploadMap() != null) {
            jSONObject.put(InvoiceConstant.SUMMARY, (Object) encodeMap(jSONObject));
        }
        ArrayList arrayList = new ArrayList(this.b);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(InvoiceConstant.SUMMARY, (Object) encodeArray(arrayList));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(KEY_GRIVER_MPP_NETWORK_HTTP, (Object) jSONObject);
        jSONObject3.put(KEY_GRIVER_MPP_IMG_NON_CACHE, (Object) jSONObject2);
        return jSONObject3;
    }
}
