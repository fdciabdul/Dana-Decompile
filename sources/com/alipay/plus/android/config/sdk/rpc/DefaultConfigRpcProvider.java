package com.alipay.plus.android.config.sdk.rpc;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.plus.android.config.sdk.ConfigCenter;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider;
import com.alipay.plus.android.config.sdk.facade.config.AmcsConfigRpcFacade;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysLiteRpcRequest;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysRpcRequest;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;

/* loaded from: classes7.dex */
public class DefaultConfigRpcProvider implements ConfigRpcProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7385a = e.a("DefaultConfigRpcProvider");

    @Override // com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchApps(AmcsConfigByKeysLiteRpcRequest amcsConfigByKeysLiteRpcRequest) throws Throwable {
        return ((AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class)).fetchLiteConfigByKeys(amcsConfigByKeysLiteRpcRequest);
    }

    @Override // com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfig(AmcsConfigRpcRequest amcsConfigRpcRequest, String str) throws Throwable {
        String str2 = f7385a;
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultConfigRpcProvider. distributionName: ");
        sb.append(str);
        LoggerWrapper.i(str2, sb.toString());
        AmcsConfigRpcFacade amcsConfigRpcFacade = (AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class);
        if (AmcsRpcUtils.isGrayscaleService(str)) {
            return amcsConfigRpcFacade.fetchConfigListGrayscale(amcsConfigRpcRequest);
        }
        if (AmcsRpcUtils.isMdsService(str)) {
            return ConfigCenter.getInstance().getConfigContext().isUseExternalOperationType() ? amcsConfigRpcFacade.fetchConfigListExternal(amcsConfigRpcRequest) : amcsConfigRpcFacade.fetchConfigList(amcsConfigRpcRequest);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find distributionName method for:");
        sb2.append(str);
        throw new FetchException(sb2.toString());
    }

    @Override // com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfigByKeys(AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest, String str) throws Throwable {
        String str2 = f7385a;
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultConfigRpcProvider. distributionName: ");
        sb.append(str);
        LoggerWrapper.i(str2, sb.toString());
        AmcsConfigRpcFacade amcsConfigRpcFacade = (AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class);
        if (AmcsRpcUtils.isGrayscaleService(str)) {
            return amcsConfigRpcFacade.fetchConfigListByKeys(amcsConfigByKeysRpcRequest);
        }
        if (AmcsRpcUtils.isMdsService(str)) {
            throw new FetchException(String.format("Cannot use this %s method for fetchConfigByKeys", str));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find distributionName method for:");
        sb2.append(str);
        throw new FetchException(sb2.toString());
    }
}
