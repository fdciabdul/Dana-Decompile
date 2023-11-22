package com.iap.ac.android.biz.common.base;

import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseNetwork<T> {

    /* loaded from: classes3.dex */
    public interface FacadeProcessor<F, S> {
        S processFacade(F f);
    }

    public String getBizCode() {
        return "ac_biz";
    }

    public T getFacade() {
        return getFacade(getFacadeClass());
    }

    public abstract Class<T> getFacadeClass();

    public void reportRpcResult(String str, boolean z, String str2, String str3, long j, String str4) {
        if (z) {
            ACLogEvent.commonRpcSuccessEvent("iapconnect_center", str, j, str4);
        } else {
            ACLogEvent.commonRpcFailEvent("iapconnect_center", str, str2, str3, j, str4);
        }
    }

    public <S extends BaseRpcResult> S wrapper(FacadeProcessor<T, S> facadeProcessor) throws Exception {
        return facadeProcessor.processFacade(getFacade());
    }

    private <T> T getFacade(Class<T> cls) {
        return (T) RPCProxyHost.getInterfaceProxy(cls, getBizCode());
    }

    public void reportRpcResult(String str, boolean z, String str2, String str3, long j, String str4, Map<String, String> map) {
        if (z) {
            ACLogEvent.commonRpcSuccessEvent("iapconnect_center", str, j, str4, map);
        } else {
            ACLogEvent.commonRpcFailEvent("iapconnect_center", str, str2, str3, j, str4, map);
        }
    }
}
