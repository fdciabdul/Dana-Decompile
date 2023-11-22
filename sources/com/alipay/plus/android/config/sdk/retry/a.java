package com.alipay.plus.android.config.sdk.retry;

import com.alibaba.fastjson.JSONObject;
import com.alipay.plus.android.config.sdk.utils.ConfigUtils;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class a implements Serializable {
    public JSONObject data;
    public String version;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BackupConfigCdnEntity ");
        sb.append(ConfigUtils.toJSONString(this));
        return sb.toString();
    }
}
