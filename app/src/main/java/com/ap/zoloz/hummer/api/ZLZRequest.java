package com.ap.zoloz.hummer.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ZLZRequest {
    public Map<String, Object> bizConfig = new HashMap();
    public String zlzConfig;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZLZRequest{zlzConfig=");
        sb.append(this.zlzConfig);
        sb.append(", bizConfig=");
        sb.append(this.bizConfig.toString());
        sb.append('}');
        return sb.toString();
    }
}
