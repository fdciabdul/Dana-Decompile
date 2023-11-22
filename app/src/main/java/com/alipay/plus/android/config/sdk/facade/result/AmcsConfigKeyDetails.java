package com.alipay.plus.android.config.sdk.facade.result;

import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class AmcsConfigKeyDetails implements Serializable {
    public long version;

    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
