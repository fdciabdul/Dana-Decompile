package com.alibaba.ariver.kernel.ipc.uniform;

/* loaded from: classes3.dex */
public interface IPCCallManager {
    <T> T getIpcProxy(Class<T> cls);

    void setIIPCManager(IIPCManager iIPCManager);

    void setIPCCallRetryHandler(IPCRetryHandler iPCRetryHandler);
}
