package com.alibaba.ariver.kernel.ipc.uniform;

/* loaded from: classes3.dex */
public final class IPCApiFactory {

    /* renamed from: a  reason: collision with root package name */
    private static IPCContextManager f6172a;
    private static IIPCManager b;

    public static final IIPCManager getIPCManager() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (IIPCManager) Class.forName("com.alibaba.ariver.ipc.uniform.IPCManagerService").newInstance();
    }

    public static final IIPCManager getSingletonIPCManager() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IIPCManager iIPCManager = b;
        if (iIPCManager != null) {
            return iIPCManager;
        }
        synchronized (IIPCManager.class) {
            IIPCManager iIPCManager2 = b;
            if (iIPCManager2 != null) {
                return iIPCManager2;
            }
            IIPCManager iIPCManager3 = (IIPCManager) Class.forName("com.alibaba.ariver.ipc.uniform.IPCManagerService").newInstance();
            b = iIPCManager3;
            return iIPCManager3;
        }
    }

    public static final IPCContextManager getIPCContextManager() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (IPCContextManager) Class.forName("com.alibaba.ariver.ipc.uniform.IPCContextManagerImpl").newInstance();
    }

    public static final IPCContextManager getSingletonIPCContextManager() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IPCContextManager iPCContextManager = f6172a;
        if (iPCContextManager != null) {
            return iPCContextManager;
        }
        synchronized (IPCApiFactory.class) {
            IPCContextManager iPCContextManager2 = f6172a;
            if (iPCContextManager2 != null) {
                return iPCContextManager2;
            }
            IPCContextManager iPCContextManager3 = (IPCContextManager) Class.forName("com.alibaba.ariver.ipc.uniform.IPCContextManagerImpl").newInstance();
            f6172a = iPCContextManager3;
            return iPCContextManager3;
        }
    }

    public static final ServiceBeanManager getSingletonServiceBeanManager() {
        try {
            return getSingletonIPCContextManager().getServiceBeanManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
