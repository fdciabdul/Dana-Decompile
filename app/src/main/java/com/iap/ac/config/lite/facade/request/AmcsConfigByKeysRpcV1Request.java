package com.iap.ac.config.lite.facade.request;

import com.iap.ac.config.lite.utils.ConfigUtils;
import java.util.List;

/* loaded from: classes3.dex */
public class AmcsConfigByKeysRpcV1Request extends AmcsConfigRpcV1Request {
    public List<String> keys;

    @Override // com.iap.ac.config.lite.facade.request.AmcsConfigRpcV1Request
    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
