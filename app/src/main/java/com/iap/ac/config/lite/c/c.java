package com.iap.ac.config.lite.c;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcRequest;
import com.iap.ac.config.lite.facade.result.AmcsConfigCdnResult;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c extends a {
    private final List<String> d;
    private String e;

    public c(ConfigCenterContext configCenterContext, List<String> list) {
        super(configCenterContext);
        this.e = null;
        this.d = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.e = com.iap.ac.config.lite.d.e.a((Iterator<? extends CharSequence>) list.listIterator(), ',');
    }

    @Override // com.iap.ac.config.lite.c.b
    public String a() {
        return "ConfigCdnFetchByKeysTask";
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.e).put("isCDN", Boolean.TRUE).put("success", "1").build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.iap.ac.config.lite.c.b
    public AmcsConfigCdnResult b(String str, JSONObject jSONObject) throws Exception {
        return super.b(str, jSONObject);
    }

    @Override // com.iap.ac.config.lite.c.a
    public AmcsConfigByKeysRpcRequest c(String str, JSONObject jSONObject) {
        AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest = new AmcsConfigByKeysRpcRequest();
        try {
            amcsConfigByKeysRpcRequest.lastResponseTime = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            amcsConfigByKeysRpcRequest.lastResponseTime = 0L;
        }
        amcsConfigByKeysRpcRequest.addParameters(jSONObject);
        amcsConfigByKeysRpcRequest.keys = this.d;
        return amcsConfigByKeysRpcRequest;
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.e).put("isCDN", Boolean.TRUE).put("success", "0").build());
    }
}
