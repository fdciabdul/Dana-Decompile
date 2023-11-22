package com.alibaba.ariver.kernel.api.remote;

import android.os.RemoteException;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public interface RemoteController {
    void bindExtensionManager(ExtensionManager extensionManager);

    RemoteControlManagement getRemoteControlManagement();

    boolean isRemoteCallExtension(Extension extension, Method method);

    RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) throws RemoteException;

    void setRemoteControlManagement(RemoteControlManagement remoteControlManagement);
}
