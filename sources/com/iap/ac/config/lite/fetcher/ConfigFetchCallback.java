package com.iap.ac.config.lite.fetcher;

import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;

/* loaded from: classes.dex */
public interface ConfigFetchCallback {
    void onFetchByKeysSuccess(AmcsConfigRpcResult amcsConfigRpcResult);

    void onFetchFailed(String str, String str2);

    void onFetchSuccess(AmcsConfigRpcResult amcsConfigRpcResult, String str);
}
