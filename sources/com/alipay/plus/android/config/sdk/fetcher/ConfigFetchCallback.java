package com.alipay.plus.android.config.sdk.fetcher;

import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;

/* loaded from: classes7.dex */
public interface ConfigFetchCallback {
    void onFetchByKeysSuccess(AmcsConfigRpcResult amcsConfigRpcResult);

    void onFetchFailed(String str, String str2);

    void onFetchSuccess(AmcsConfigRpcResult amcsConfigRpcResult, String str);
}
