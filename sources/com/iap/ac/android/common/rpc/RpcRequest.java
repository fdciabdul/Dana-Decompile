package com.iap.ac.android.common.rpc;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class RpcRequest implements Serializable {
    public String operationType;
    public Object request;
    public RpcAppInfo rpcAppInfo;

    public RpcRequest(String str, Object obj) {
        this.operationType = str;
        this.request = obj;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public RpcAppInfo getRpcAppInfo() {
        return this.rpcAppInfo;
    }

    public void setOperationType(String str) {
        this.operationType = str;
    }

    public void setRpcAppInfo(RpcAppInfo rpcAppInfo) {
        this.rpcAppInfo = rpcAppInfo;
    }
}
