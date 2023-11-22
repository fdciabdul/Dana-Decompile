package com.alibaba.ariver.kernel.ipc.uniform;

import android.content.Context;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes3.dex */
public class UniformIpcUtils {
    public static final String TAG = "AriverKernel:RemoteCall";

    /* renamed from: a  reason: collision with root package name */
    private static IPCContextManager f6173a;
    private static IIPCManager b;

    public static void init(Context context, IIPCManager iIPCManager) {
        IPCContextManager ipcContextManager = getIpcContextManager();
        if (ipcContextManager != null) {
            ipcContextManager.init(context, iIPCManager);
        }
    }

    public static ServiceBeanManager getServiceBeanManager() {
        IPCContextManager ipcContextManager = getIpcContextManager();
        if (ipcContextManager != null) {
            return ipcContextManager.getServiceBeanManager();
        }
        return null;
    }

    public static IPCContextManager getIpcContextManager() {
        if (f6173a == null) {
            synchronized (UniformIpcUtils.class) {
                if (f6173a == null) {
                    try {
                        f6173a = IPCApiFactory.getIPCContextManager();
                    } catch (Throwable th) {
                        RVLogger.e(TAG, Log.getStackTraceString(th));
                    }
                }
            }
        }
        return f6173a;
    }

    public static IIPCManager getIpcManager() {
        if (b == null) {
            synchronized (UniformIpcUtils.class) {
                if (b == null) {
                    try {
                        b = IPCApiFactory.getIPCManager();
                    } catch (Throwable th) {
                        RVLogger.e(TAG, Log.getStackTraceString(th));
                    }
                }
            }
        }
        return b;
    }
}
