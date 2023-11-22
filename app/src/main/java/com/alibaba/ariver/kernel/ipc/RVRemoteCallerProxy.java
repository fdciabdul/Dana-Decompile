package com.alibaba.ariver.kernel.ipc;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.ipc.RemoteCallerImpl")
/* loaded from: classes3.dex */
public interface RVRemoteCallerProxy extends Proxiable {
    <T> T getRemoteCaller(Class<T> cls);

    <T> void registerServiceBean(Class<T> cls, T t);
}
