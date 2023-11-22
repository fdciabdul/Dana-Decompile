package com.iap.ac.android.mpm.node.base;

/* loaded from: classes3.dex */
public abstract class NodeRequest {
    private final NodeType nodeType;

    public NodeRequest(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public NodeType getNodeType() {
        return this.nodeType;
    }
}
