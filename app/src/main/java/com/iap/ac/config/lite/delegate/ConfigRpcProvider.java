package com.iap.ac.config.lite.delegate;

import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcV1Request;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcV1Request;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;

/* loaded from: classes3.dex */
public interface ConfigRpcProvider {
    AmcsConfigRpcResult fetchConfig(AmcsConfigRpcRequest amcsConfigRpcRequest) throws Exception;

    AmcsConfigRpcResult fetchConfigByKeys(AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest) throws Exception;

    AmcsConfigRpcResult fetchConfigByKeysV1(AmcsConfigByKeysRpcV1Request amcsConfigByKeysRpcV1Request) throws Exception;

    AmcsConfigRpcResult fetchConfigV1(AmcsConfigRpcV1Request amcsConfigRpcV1Request) throws Exception;
}
