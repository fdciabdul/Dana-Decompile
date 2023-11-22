package com.alibaba.ariver.kernel.api.node;

import com.alibaba.ariver.kernel.api.node.Node;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public interface NodeAware<T extends Node> {
    Class<T> getNodeType();

    void setNode(WeakReference<T> weakReference);
}
