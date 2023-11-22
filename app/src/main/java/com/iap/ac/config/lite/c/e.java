package com.iap.ac.config.lite.c;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.delegate.ConfigRpcProvider;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcV1Request;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e extends b {
    private static final String e = com.iap.ac.config.lite.d.e.b("ConfigRpcFetchByKeysTask");
    private final List<String> c;
    private String d;

    public e(ConfigCenterContext configCenterContext, List<String> list) {
        super(configCenterContext);
        this.d = null;
        this.c = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.d = com.iap.ac.config.lite.d.e.a((Iterator<? extends CharSequence>) list.listIterator(), ',');
    }

    @Override // com.iap.ac.config.lite.c.b
    public String a() {
        return "ConfigRpcFetchByKeysTask";
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.d).put("success", "1").build());
    }

    @Override // com.iap.ac.config.lite.c.b
    protected AmcsConfigRpcResult b(String str, JSONObject jSONObject) throws Exception {
        ConfigRpcProvider configRpcProvider = this.f7627a.getConfigRpcProvider();
        if (this.f7627a.getVersion() == ConfigCenterContext.SchemeVersion.V1) {
            AmcsConfigByKeysRpcV1Request amcsConfigByKeysRpcV1Request = new AmcsConfigByKeysRpcV1Request();
            a(amcsConfigByKeysRpcV1Request, jSONObject);
            amcsConfigByKeysRpcV1Request.keys = this.c;
            String str2 = e;
            StringBuilder sb = new StringBuilder();
            sb.append("start fetch request: ");
            sb.append(JsonUtils.toJson(amcsConfigByKeysRpcV1Request));
            ACLog.i(str2, sb.toString());
            return configRpcProvider.fetchConfigByKeysV1(amcsConfigByKeysRpcV1Request);
        }
        AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest = new AmcsConfigByKeysRpcRequest();
        a(amcsConfigByKeysRpcRequest, jSONObject);
        amcsConfigByKeysRpcRequest.keys = this.c;
        String str3 = e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("start fetch request: ");
        sb2.append(JsonUtils.toJson(amcsConfigByKeysRpcRequest));
        ACLog.i(str3, sb2.toString());
        return configRpcProvider.fetchConfigByKeys(amcsConfigByKeysRpcRequest);
    }

    @Override // com.iap.ac.config.lite.c.b
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.d).put("success", "0").build());
    }
}
