package com.alibaba.ariver.ariverexthub.api.instance;

import com.alibaba.ariver.ariverexthub.api.RVEApiConfig;
import com.alibaba.ariver.ariverexthub.api.model.RVEApiInfo;

/* loaded from: classes3.dex */
public class RVEApiInfoManager {
    public static RVEApiInfo getApiInfo(String str) {
        RVEApiConfig rveApiConfig = RVEProxyCenter.getInstance().getRveApiConfig();
        if (rveApiConfig != null) {
            return rveApiConfig.getApiInfo(str);
        }
        return null;
    }
}
