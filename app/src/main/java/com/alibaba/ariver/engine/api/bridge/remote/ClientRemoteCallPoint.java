package com.alibaba.ariver.engine.api.bridge.remote;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public interface ClientRemoteCallPoint extends Extension {
    void addClientRemoteCallArgs(Class cls, Method method, RemoteCallArgs remoteCallArgs);
}
