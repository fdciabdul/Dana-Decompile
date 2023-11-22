package com.alibaba.ariver.kernel.ipc.uniform;

/* loaded from: classes3.dex */
public interface LocalCallRetryHandler {
    boolean retryLocalCall(IPCParameter iPCParameter, IPCResult iPCResult, ServiceBeanManager serviceBeanManager, int i);
}
