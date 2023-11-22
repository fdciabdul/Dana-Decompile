package com.iap.ac.android.rpccommon.model.facade.result;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes8.dex */
public class BaseServiceResult implements Serializable {
    public String errorCode;
    public String errorMessage;
    public Map<String, String> extendInfo;
    public boolean success;
}
