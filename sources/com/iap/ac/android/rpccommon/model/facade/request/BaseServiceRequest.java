package com.iap.ac.android.rpccommon.model.facade.request;

import com.iap.ac.android.rpccommon.model.facade.MobileEnvInfo;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes8.dex */
public class BaseServiceRequest implements Serializable {
    public MobileEnvInfo envInfo;
    public Map<String, String> extParams;
    public String userId;
}
