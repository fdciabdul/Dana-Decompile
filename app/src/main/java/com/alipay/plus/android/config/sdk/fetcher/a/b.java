package com.alipay.plus.android.config.sdk.fetcher.a;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.common.KVBuilder;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import com.alipay.plus.android.transport.proxy.HttpTransportProxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends a {
    private static final String d = e.a("CdnFetchTask");

    public b(ConfigCenterContext configCenterContext, DistributionNode distributionNode) {
        super(configCenterContext, distributionNode);
    }

    private KVBuilder c(KVBuilder kVBuilder) {
        if (kVBuilder == null) {
            kVBuilder = KVBuilder.newBuilder();
        }
        return kVBuilder.put("cdnType", this.b.type).put("cdnName", this.b.configName);
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    public String a() {
        return "CdnFetchTask";
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder) {
        String str = d;
        StringBuilder sb = new StringBuilder();
        sb.append("CDN fetch start. backupConfig = ");
        sb.append(this.b);
        LoggerWrapper.i(str, sb.toString());
        a(ConfigMonitor.Events.CONFIG_CDN_UPDATE_START, c(kVBuilder).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void a(KVBuilder kVBuilder, AmcsConfigRpcResult amcsConfigRpcResult) {
        String str = d;
        StringBuilder sb = new StringBuilder();
        sb.append("CDN fetch success. backupConfig = ");
        sb.append(this.b);
        LoggerWrapper.i(str, sb.toString());
        a(ConfigMonitor.Events.CONFIG_CDN_UPDATE_SUCCESS, c(kVBuilder).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("429");
        if (this.b.type == DistributionNode.a.ALICLOUD) {
            arrayList.add("403");
        }
        return arrayList;
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected void b(KVBuilder kVBuilder) {
        String str = d;
        StringBuilder sb = new StringBuilder();
        sb.append("CDN fetch Failed. backupConfig = ");
        sb.append(this.b);
        LoggerWrapper.i(str, sb.toString());
        a(ConfigMonitor.Events.CONFIG_CDN_UPDATE_FAILURE, c(kVBuilder).build());
    }

    @Override // com.alipay.plus.android.config.sdk.fetcher.a.a
    protected AmcsConfigRpcResult c() throws Throwable {
        String str = d;
        StringBuilder sb = new StringBuilder();
        sb.append("will perform CDN retry. backupConfig = ");
        sb.append(this.b);
        LoggerWrapper.i(str, sb.toString());
        com.alipay.plus.android.config.sdk.retry.a a2 = ((com.alipay.plus.android.config.sdk.retry.b) HttpTransportProxy.getInterfaceProxy(com.alipay.plus.android.config.sdk.retry.b.class, new HttpTransportProxy.DelegateAdapter() { // from class: com.alipay.plus.android.config.sdk.fetcher.a.b.1
            @Override // com.alipay.plus.android.transport.proxy.HttpTransportProxy.DelegateAdapter, com.alipay.plus.android.transport.proxy.HttpTransportProxy.Delegate
            public String transformUrl(String str2) {
                return b.this.b.url;
            }
        })).a();
        if (a2 != null) {
            AmcsConfigRpcResult amcsConfigRpcResult = new AmcsConfigRpcResult();
            amcsConfigRpcResult.success = true;
            amcsConfigRpcResult.updateKeys = a2.data;
            amcsConfigRpcResult.responseTime = a2.version;
            return amcsConfigRpcResult;
        }
        throw new FetchException("CdnResultIsNull", "CDN fetched config result is null!");
    }
}
