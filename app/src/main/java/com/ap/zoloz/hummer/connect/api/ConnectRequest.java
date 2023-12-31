package com.ap.zoloz.hummer.connect.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ConnectRequest {
    public Map<String, Object> bizConfig = new HashMap();
    public String connectConfig;
    public String connectId;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectRequest{connectId=");
        sb.append(this.connectId);
        sb.append(", connectConfig=");
        sb.append(this.connectConfig.toString());
        sb.append(", bizConfig=");
        sb.append(this.bizConfig.toString());
        sb.append('}');
        return sb.toString();
    }
}
