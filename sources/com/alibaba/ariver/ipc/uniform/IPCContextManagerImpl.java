package com.alibaba.ariver.ipc.uniform;

import android.content.Context;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* loaded from: classes3.dex */
public class IPCContextManagerImpl implements IPCContextManager {

    /* renamed from: a  reason: collision with root package name */
    private IPCCallManager f6072a;
    private ServiceBeanManager b;
    private LocalCallManager c;
    private IIPCManager d;
    private Context e;

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public void init(Context context, IIPCManager iIPCManager) {
        this.e = context;
        this.d = iIPCManager;
        getIpcCallManager().setIIPCManager(this.d);
        IIPCManager iIPCManager2 = this.d;
        if (iIPCManager2 instanceof IPCManagerService) {
            ((IPCManagerService) iIPCManager2).setLocalCallManager(getLocalCallManager());
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public void resetIIPCManager() {
        synchronized (this) {
            RVLogger.d(UniformIpcUtils.TAG, "IPCContextManagerImpl resetIIPCManager !");
            this.d = null;
            getIpcCallManager().setIIPCManager(null);
            RVLogger.d(UniformIpcUtils.TAG, "IPCContextManagerImpl [resetIIPCManager] reset iIpcManager to null.");
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public IPCCallManager getIpcCallManager() {
        IPCCallManager iPCCallManager = this.f6072a;
        if (iPCCallManager != null) {
            return iPCCallManager;
        }
        synchronized (this) {
            IPCCallManager iPCCallManager2 = this.f6072a;
            if (iPCCallManager2 != null) {
                return iPCCallManager2;
            }
            IPCCallManagerImpl iPCCallManagerImpl = new IPCCallManagerImpl();
            this.f6072a = iPCCallManagerImpl;
            return iPCCallManagerImpl;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public ServiceBeanManager getServiceBeanManager() {
        ServiceBeanManager serviceBeanManager = this.b;
        if (serviceBeanManager != null) {
            return serviceBeanManager;
        }
        synchronized (this) {
            ServiceBeanManager serviceBeanManager2 = this.b;
            if (serviceBeanManager2 != null) {
                return serviceBeanManager2;
            }
            ServiceBeanManagerImpl serviceBeanManagerImpl = new ServiceBeanManagerImpl();
            this.b = serviceBeanManagerImpl;
            return serviceBeanManagerImpl;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager
    public LocalCallManager getLocalCallManager() {
        LocalCallManager localCallManager = this.c;
        if (localCallManager != null) {
            return localCallManager;
        }
        synchronized (this) {
            LocalCallManager localCallManager2 = this.c;
            if (localCallManager2 != null) {
                return localCallManager2;
            }
            LocalCallManagerImpl localCallManagerImpl = new LocalCallManagerImpl(getServiceBeanManager());
            this.c = localCallManagerImpl;
            return localCallManagerImpl;
        }
    }
}
