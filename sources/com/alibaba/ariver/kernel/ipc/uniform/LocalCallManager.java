package com.alibaba.ariver.kernel.ipc.uniform;

/* loaded from: classes3.dex */
public interface LocalCallManager {
    IPCResult call(IPCParameter iPCParameter);

    void setLocalCallRetryHandler(LocalCallRetryHandler localCallRetryHandler);
}
