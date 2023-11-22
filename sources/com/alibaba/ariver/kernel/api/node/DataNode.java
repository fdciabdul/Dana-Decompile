package com.alibaba.ariver.kernel.api.node;

/* loaded from: classes2.dex */
public interface DataNode extends Node {
    <T> T getData(Class<T> cls);

    @Override // com.alibaba.ariver.kernel.api.node.Node
    <T> T getData(Class<T> cls, boolean z);

    <T> void setData(Class<T> cls, T t);
}
