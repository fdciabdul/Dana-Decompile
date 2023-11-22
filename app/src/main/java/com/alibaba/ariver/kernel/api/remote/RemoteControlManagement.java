package com.alibaba.ariver.kernel.api.remote;

import com.alibaba.ariver.kernel.api.extension.Extension;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public interface RemoteControlManagement {
    IRemoteCaller getRemoteCallerProxy();

    boolean isRemoteExtension(Extension extension, Method method);
}
