package com.iap.ac.android.acs.operation.biz.region;

import android.os.Bundle;
import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.common.container.callback.Callback;

/* loaded from: classes3.dex */
public abstract class FacadeRepository {
    public Callback<Bundle> callback;
    public final int CODE_NETWORK_ERROR = 10104;
    public final String MSG_NETWORK_ERROR = "Network error";
    public final int CODE_SERVER_ERROR = 10105;
    public final String MSG_SERVER_ERROR = "Server error";

    private void netWorkErrorCheck(int i, Callback<Bundle> callback) {
        if (i != 4001 && i != 5000) {
            callback.onResultFailed(10105, "Server error");
        } else {
            callback.onResultFailed(10104, "Network error");
        }
    }

    public void handleException(Throwable th) {
        Callback<Bundle> callback = this.callback;
        if (callback == null) {
            return;
        }
        if (th instanceof RpcException) {
            netWorkErrorCheck(((RpcException) th).getCode(), this.callback);
        } else {
            callback.onResultFailed(10105, "Server error");
        }
    }
}
