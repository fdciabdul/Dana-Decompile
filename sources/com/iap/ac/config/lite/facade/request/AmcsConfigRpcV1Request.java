package com.iap.ac.config.lite.facade.request;

import com.iap.ac.config.lite.utils.ConfigUtils;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class AmcsConfigRpcV1Request implements Serializable {
    public String business;
    public String clientVersion;
    public String lastResponseTime;
    public String mobileModel;
    public String osVersion;
    public String productId;
    public String reference;
    public String systemType;
    public String utdid;

    public String toString() {
        return ConfigUtils.toJSONString(this);
    }
}
