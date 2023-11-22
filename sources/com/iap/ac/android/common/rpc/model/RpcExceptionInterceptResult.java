package com.iap.ac.android.common.rpc.model;

import com.iap.ac.android.common.a.a;

/* loaded from: classes3.dex */
public class RpcExceptionInterceptResult {
    public boolean isHandled;
    public Object response;

    public String toString() {
        StringBuilder a2 = a.a("RpcExceptionInterceptResult{isHandled=");
        a2.append(this.isHandled);
        a2.append(", response=");
        a2.append(this.response);
        a2.append('}');
        return a2.toString();
    }
}
