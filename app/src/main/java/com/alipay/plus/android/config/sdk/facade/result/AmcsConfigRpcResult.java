package com.alipay.plus.android.config.sdk.facade.result;

import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class AmcsConfigRpcResult implements Serializable {
    public List<String> deleteKeys;
    public String errorCode;
    public String errorMessage;
    public Map<String, String> extendInfo;
    public boolean increment;
    public String responseTime;
    public boolean success;
    public Map<String, AmcsConfigKeyDetails> updateKeyDetails;
    public Map<String, Object> updateKeys;

    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
