package com.iap.ac.android.rpccommon.model.domain.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BaseRpcResult implements Serializable {
    public String errorCode;
    public String errorMessage;
    public String interaction;
    public String thirdPartyError;
    public String traceId;
    public boolean success = false;
    public Map<String, String> extendInfo = new HashMap();
    public Map<String, String> errorActions = new HashMap();
}
