package com.ap.zoloz.hummer.api;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class EkycRequest {
    public String eKYCId;
    public Map<String, String> eKYCConfig = new HashMap();
    public Map<String, Object> bizConfig = new HashMap();
    public String clientCfg = "";

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EkycRequest{eKYCId=");
        sb.append(this.eKYCId);
        sb.append(", eKYCConfig=");
        sb.append(this.eKYCConfig.toString());
        sb.append(", clientCfg=");
        sb.append(this.clientCfg);
        sb.append(", bizConfig=");
        sb.append(this.bizConfig.toString());
        sb.append('}');
        return sb.toString();
    }
}
