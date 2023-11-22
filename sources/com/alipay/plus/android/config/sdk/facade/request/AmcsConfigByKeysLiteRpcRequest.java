package com.alipay.plus.android.config.sdk.facade.request;

import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class AmcsConfigByKeysLiteRpcRequest extends AmcsConfigRpcLiteRequest {
    public List<String> keys;

    @Override // com.alipay.plus.android.config.sdk.facade.request.AmcsConfigRpcLiteRequest
    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
