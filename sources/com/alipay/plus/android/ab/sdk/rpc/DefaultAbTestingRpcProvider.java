package com.alipay.plus.android.ab.sdk.rpc;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.plus.android.ab.sdk.facade.AbTestingFacade;
import com.alipay.plus.android.ab.sdk.facade.request.AbTestingRequest;
import com.alipay.plus.android.ab.sdk.facade.result.AbTestingResponse;
import com.alipay.plus.android.config.sdk.a.e;

/* loaded from: classes7.dex */
public class DefaultAbTestingRpcProvider implements AbTestingRpcProvider {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7344a = e.a("DefaultAbTestingRpcProvider");

    @Override // com.alipay.plus.android.ab.sdk.rpc.AbTestingRpcProvider
    public AbTestingResponse fetchVariation(AbTestingRequest abTestingRequest) throws Throwable {
        LoggerWrapper.i(f7344a, "execute fetch AB variation without customize setting.");
        return ((AbTestingFacade) RPCProxyHost.getInterfaceProxy(AbTestingFacade.class)).getVariation(abTestingRequest);
    }
}
