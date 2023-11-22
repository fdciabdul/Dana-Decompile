package com.alipay.plus.android.config.sdk.fetcher.a;

import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c extends a {
    private static final String d = e.a("ConfigRpcFetchByKeysTask");
    private final List<String> e;
    private AmcsConfigByKeysRpcRequest f;
    private String g;

    public c(ConfigCenterContext configCenterContext, DistributionNode distributionNode, List<String> list) {
        super(configCenterContext, distributionNode);
        this.g = null;
        this.e = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.g = e.a((Iterable<? extends CharSequence>) list, ',');
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    public String a() {
        return "RpcFetchByKeysTask";
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE_START, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.g).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE_SUCCESS, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.g).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected List<String> b() {
        return new ArrayList();
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void b(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_BY_KEYS_UPDATE_FAILURE, kVBuilder.put(UserMetadata.KEYDATA_FILENAME, this.g).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected AmcsConfigRpcResult c() throws Throwable {
        return this.f7369a.getConfigRpcProvider().fetchConfigByKeys(this.f, this.b.configName);
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void c(String str) {
        AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest = new AmcsConfigByKeysRpcRequest();
        this.f = amcsConfigByKeysRpcRequest;
        a(amcsConfigByKeysRpcRequest);
        this.f.keys = this.e;
        String str2 = d;
        StringBuilder sb = new StringBuilder();
        sb.append("start fetch request: ");
        sb.append(JSONObject.toJSONString(this.f));
        LoggerWrapper.i(str2, sb.toString());
    }
}
