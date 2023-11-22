package com.iap.ac.config.lite.facade.request;

import com.iap.ac.config.lite.utils.ConfigUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class AmcsConfigByKeysRpcRequest extends AmcsConfigRpcRequest {
    public List<String> keys;

    @Override // com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest
    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
