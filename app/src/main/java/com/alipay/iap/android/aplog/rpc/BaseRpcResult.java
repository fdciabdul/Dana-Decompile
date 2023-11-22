package com.alipay.iap.android.aplog.rpc;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BaseRpcResult extends ToString {
    public String errorCode;
    public String errorMessage;
    public String interaction;
    public String traceId;
    public boolean success = false;
    public Map<String, String> extendInfo = new HashMap();
    public Map<String, String> errorActions = new HashMap();
}
