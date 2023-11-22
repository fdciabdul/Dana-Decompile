package com.alibaba.griver.base.common.rpc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BaseGriverRpcResult implements Serializable {
    public String errorCode;
    public String errorMessage;
    public boolean success = false;
    public Map<String, String> extendInfo = new HashMap();
}
