package com.iap.ac.config.lite.c;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.result.AmcsConfigCdnResult;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d extends a {
    public d(ConfigCenterContext configCenterContext) {
        super(configCenterContext);
    }

    @Override // com.iap.ac.config.lite.c.b
    public String a() {
        return "ConfigCdnFetchTask";
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        JSONObject jSONObject = amcsConfigRpcResult.updateKeys;
        a(ConfigMonitor.Events.CONFIG_UPDATE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, (jSONObject == null || jSONObject.length() == 0) ? null : com.iap.ac.config.lite.d.e.a((Iterator<? extends CharSequence>) amcsConfigRpcResult.updateKeys.keys(), ',')).put("isCDN", Boolean.TRUE).put("success", "1").build());
    }

    @Override // com.iap.ac.config.lite.c.a
    public AmcsConfigRpcRequest c(String str, JSONObject jSONObject) {
        AmcsConfigRpcRequest amcsConfigRpcRequest = new AmcsConfigRpcRequest();
        try {
            amcsConfigRpcRequest.lastResponseTime = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            amcsConfigRpcRequest.lastResponseTime = 0L;
        }
        amcsConfigRpcRequest.addParameters(jSONObject);
        return amcsConfigRpcRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iap.ac.config.lite.c.b
    public AmcsConfigCdnResult b(String str, JSONObject jSONObject) throws Exception {
        return super.b(str, jSONObject);
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_UPDATE, kVBuilder.put("isCDN", Boolean.TRUE).put("success", "0").build());
    }
}
