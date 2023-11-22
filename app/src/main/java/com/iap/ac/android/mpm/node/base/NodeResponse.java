package com.iap.ac.android.mpm.node.base;

import com.iap.ac.android.biz.common.model.Result;

/* loaded from: classes3.dex */
public abstract class NodeResponse {
    public String endNode;
    public String logResultCode;
    public String logResultMsg;
    public Result result = new Result();

    public abstract boolean isSuccess();

    public abstract NodeType nodeType();
}
