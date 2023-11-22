package com.iap.ac.android.mpm.node.base;

import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeResponse;

/* loaded from: classes3.dex */
public abstract class BaseNode<Req extends NodeRequest, Resp extends NodeResponse> {
    private Req mRequest;
    private Resp mResponse;

    public abstract void handleNode(Req req, INodeCallback<Resp> iNodeCallback);
}
