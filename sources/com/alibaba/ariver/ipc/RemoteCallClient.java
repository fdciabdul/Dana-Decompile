package com.alibaba.ariver.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCContextManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class RemoteCallClient {
    private static final String TAG = "AriverKernel:RemoteCall";
    private static AtomicBoolean ipcInited = new AtomicBoolean(false);
    private static boolean hasPrepared = false;
    private static IpcCallClientHelper sIpcCallClientHelper = new IpcCallClientHelper();

    public static void bindContext(Context context) {
        if (ProcessUtils.isMainProcess()) {
            StringBuilder sb = new StringBuilder();
            sb.append("IpcCallClientHelper bindContext must be in lite process. ");
            sb.append(Log.getStackTraceString(new Throwable()));
            RVLogger.e("AriverKernel:RemoteCall", sb.toString());
            return;
        }
        sIpcCallClientHelper.bindContext(context);
    }

    public static void prepare() {
        synchronized (RemoteCallClient.class) {
            if (ProcessUtils.isMainProcess()) {
                StringBuilder sb = new StringBuilder();
                sb.append("IpcCallClientHelper prepare must be in lite process. ");
                sb.append(Log.getStackTraceString(new Throwable()));
                RVLogger.e("AriverKernel:RemoteCall", sb.toString());
            } else if (hasPrepared) {
            } else {
                hasPrepared = true;
                ipcInited.set(false);
                RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper prepare");
                sIpcCallClientHelper.bindService(RemoteCallService.class, new IpcCallConn());
                ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.ipc.RemoteCallClient.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        RemoteCallClient.sIpcCallClientHelper.bind();
                    }
                });
                RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper prepare finish");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class IpcCallConn implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private IIPCManager f6067a = null;

        IpcCallConn() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper onServiceConnected");
            if (iBinder == null) {
                RemoteCallClient.sIpcCallClientHelper.rebind();
                return;
            }
            this.f6067a = IIPCManager.Stub.asInterface(iBinder);
            RemoteCallClient.sIpcCallClientHelper.setBind(true);
            try {
                UniformIpcUtils.init(ProcessUtils.getContext(), this.f6067a);
                StringBuilder sb = new StringBuilder();
                sb.append("IpcCallClientHelper init ipcManager ");
                sb.append(this.f6067a);
                RVLogger.d("AriverKernel:RemoteCall", sb.toString());
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("IpcCallClientHelper init error ");
                sb2.append(Log.getStackTraceString(e));
                RVLogger.d("AriverKernel:RemoteCall", sb2.toString());
            }
            RemoteCallClient.ipcInited.set(true);
            synchronized (RemoteCallClient.class) {
                RemoteCallClient.class.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper onServiceDisconnected");
            this.f6067a = null;
            RemoteCallClient.sIpcCallClientHelper.setBind(false);
            RemoteCallClient.sIpcCallClientHelper.rebind();
            RemoteCallClient.ipcInited.set(false);
        }
    }

    private static void waitBindedIfNeed() {
        IpcCallClientHelper ipcCallClientHelper = sIpcCallClientHelper;
        if (ipcCallClientHelper == null) {
            RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper waitBindedIfNeed but sIpcCallClientHelper is null");
        } else if (ipcCallClientHelper.isBind()) {
        } else {
            synchronized (RemoteCallClient.class) {
                if (!sIpcCallClientHelper.isBind()) {
                    if (!sIpcCallClientHelper.bind()) {
                        RVLogger.e("AriverKernel:RemoteCall", "IpcCallClientHelper bind failed!!!");
                        return;
                    }
                    try {
                        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper begin wait bind");
                        RemoteCallClient.class.wait(RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
                        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper end wait bind");
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("IpcCallClientHelper wait error ");
                        sb.append(Log.getStackTraceString(e));
                        RVLogger.e("AriverKernel:RemoteCall", sb.toString());
                    }
                }
            }
        }
    }

    private static void waitIpcIfNeed() {
        if (sIpcCallClientHelper == null) {
            RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper not need waitIpcIfNeed");
        } else if (ipcInited.get()) {
        } else {
            synchronized (RemoteCallClient.class) {
                if (!ipcInited.get()) {
                    try {
                        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper begin wait ipc");
                        RemoteCallClient.class.wait();
                        RVLogger.d("AriverKernel:RemoteCall", "IpcCallClientHelper end wait ipc");
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("IpcCallClientHelper wait ipc error ");
                        sb.append(Log.getStackTraceString(e));
                        RVLogger.e("AriverKernel:RemoteCall", sb.toString());
                    }
                }
            }
        }
    }

    public static <T> T getIpcProxy(Class<T> cls) throws IllegalStateException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            IpcCallClientHelper ipcCallClientHelper = sIpcCallClientHelper;
            if (ipcCallClientHelper == null || !ipcCallClientHelper.isBind()) {
                throw new IllegalStateException("IpcCallClientHelper.getIpcProxy should not call on main thread!!!");
            }
            RVLogger.w("AriverKernel:RemoteCall", "IpcCallClientHelper.getIpcProxy should not call on main thread!!!");
        }
        if (!hasPrepared) {
            prepare();
        }
        waitBindedIfNeed();
        waitIpcIfNeed();
        IPCContextManager ipcContextManager = UniformIpcUtils.getIpcContextManager();
        if (ipcContextManager == null || ipcContextManager.getIpcCallManager() == null) {
            return null;
        }
        return (T) ipcContextManager.getIpcCallManager().getIpcProxy(cls);
    }
}
