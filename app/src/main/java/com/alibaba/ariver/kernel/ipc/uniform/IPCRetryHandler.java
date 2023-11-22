package com.alibaba.ariver.kernel.ipc.uniform;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public interface IPCRetryHandler {
    boolean retryIPCCall(Method method, Object[] objArr, IPCException iPCException, int i);
}
