package com.alibaba.ariver.kernel.api.remote.internal;

import android.os.RemoteException;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteCallArgs;
import com.alibaba.ariver.kernel.api.remote.RemoteCallResult;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class DefaultRemoteController implements RemoteController {

    /* renamed from: a  reason: collision with root package name */
    private RemoteControlManagement f6103a;

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public void bindExtensionManager(ExtensionManager extensionManager) {
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public void setRemoteControlManagement(RemoteControlManagement remoteControlManagement) {
        this.f6103a = remoteControlManagement;
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public RemoteControlManagement getRemoteControlManagement() {
        RemoteControlManagement remoteControlManagement;
        synchronized (this) {
            if (this.f6103a == null) {
                this.f6103a = createRemoteControlManagement();
            }
            remoteControlManagement = this.f6103a;
        }
        return remoteControlManagement;
    }

    protected RemoteControlManagement createRemoteControlManagement() {
        return new DefaultRemoteControlManagement();
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public boolean isRemoteCallExtension(Extension extension, Method method) {
        return getRemoteControlManagement().isRemoteExtension(extension, method);
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteController
    public RemoteCallResult remoteCall(RemoteCallArgs remoteCallArgs) throws RemoteException {
        IRemoteCaller remoteCallerProxy = getRemoteControlManagement().getRemoteCallerProxy();
        if (remoteCallerProxy == null) {
            throw new IllegalStateException("RemoteCaller Not Found");
        }
        return remoteCallerProxy.remoteCall(remoteCallArgs);
    }
}
