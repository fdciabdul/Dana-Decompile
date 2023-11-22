package com.alipay.plus.android.config.sdk.fetcher.a;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.AmcsConstants;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public class d extends a {
    private static final String d = e.a("RpcFetchTask");
    private boolean e;
    private AmcsConfigRpcRequest f;

    public d(ConfigCenterContext configCenterContext, DistributionNode distributionNode, boolean z) {
        super(configCenterContext, distributionNode, z);
        this.e = false;
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    public String a() {
        return "RpcFetchTask";
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_UPDATE_START, kVBuilder.put("isEncrypt", Boolean.valueOf(this.c)).put(ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, Boolean.valueOf(this.e)).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        a(ConfigMonitor.Events.CONFIG_UPDATE_SUCCESS, kVBuilder.put(ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, Boolean.valueOf(this.e)).put(UserMetadata.KEYDATA_FILENAME, (amcsConfigRpcResult.updateKeys == null || amcsConfigRpcResult.updateKeys.isEmpty()) ? null : e.a((Iterable<? extends CharSequence>) amcsConfigRpcResult.updateKeys.keySet(), ',')).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected List<String> b() {
        return Collections.singletonList("1002");
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void b(KVBuilder kVBuilder) {
        a(ConfigMonitor.Events.CONFIG_UPDATE_FAILURE, kVBuilder.put(ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, Boolean.valueOf(this.e)).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected AmcsConfigRpcResult c() throws Throwable {
        return this.f7369a.getConfigRpcProvider().fetchConfig(this.f, this.b.configName);
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void c(String str) {
        AmcsConfigRpcRequest amcsConfigRpcRequest = new AmcsConfigRpcRequest();
        this.f = amcsConfigRpcRequest;
        amcsConfigRpcRequest.lastResponseTime = str;
        a(this.f);
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void e() throws Exception {
        if (this.c) {
            String staticSafeEncrypt = f().staticSafeEncrypt(16, AmcsConstants.AMCS_ENCRYPT_SECRET_KEY, JSONObject.toJSONString(this.f), this.f7369a.getRpcProfile().authCode);
            if (TextUtils.isEmpty(staticSafeEncrypt)) {
                throw new FetchException("failed to mEncrypt request!");
            }
            String str = d;
            StringBuilder sb = new StringBuilder();
            sb.append("before encrypted: ");
            sb.append(JSONObject.toJSONString(this.f));
            LoggerWrapper.d(str, sb.toString());
            String str2 = this.f.lastResponseTime;
            AmcsConfigRpcRequest amcsConfigRpcRequest = new AmcsConfigRpcRequest();
            this.f = amcsConfigRpcRequest;
            amcsConfigRpcRequest.business = staticSafeEncrypt;
            AmcsConfigRpcRequest amcsConfigRpcRequest2 = this.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-");
            sb2.append(str2);
            amcsConfigRpcRequest2.lastResponseTime = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("after encrypted: ");
            sb3.append(JSONObject.toJSONString(this.f));
            LoggerWrapper.d(str, sb3.toString());
        }
    }
}
