package com.alibaba.exthub.bridge;

import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public abstract class BridgeDispatchCallContext<T extends Node> {
    public abstract String getId();

    public abstract String getName();

    public abstract T getNode();

    public abstract JSONObject getParams();
}
