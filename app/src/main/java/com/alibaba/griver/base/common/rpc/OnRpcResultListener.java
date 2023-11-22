package com.alibaba.griver.base.common.rpc;

import com.alibaba.griver.base.common.rpc.BaseGriverRpcResult;

/* loaded from: classes3.dex */
public interface OnRpcResultListener<T extends BaseGriverRpcResult> {
    void onResultFailed(int i, String str);

    void onResultSuccess(T t);
}
