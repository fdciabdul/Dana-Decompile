package com.alipay.plus.android.config.sdk.delegate;

import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysLiteRpcRequest;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysRpcRequest;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;

/* loaded from: classes7.dex */
public interface ConfigRpcProvider {
    AmcsConfigRpcResult fetchApps(AmcsConfigByKeysLiteRpcRequest amcsConfigByKeysLiteRpcRequest) throws Throwable;

    AmcsConfigRpcResult fetchConfig(AmcsConfigRpcRequest amcsConfigRpcRequest, String str) throws Throwable;

    AmcsConfigRpcResult fetchConfigByKeys(AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest, String str) throws Throwable;
}
