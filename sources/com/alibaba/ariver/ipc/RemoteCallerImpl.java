package com.alibaba.ariver.ipc;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;

/* loaded from: classes6.dex */
public class RemoteCallerImpl implements RVRemoteCallerProxy {
    @Override // com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy
    public <T> void registerServiceBean(Class<T> cls, T t) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("RemoteCallerImpl registerServiceBean interfaceClassName ");
            sb.append(cls);
            sb.append(" object ");
            sb.append(t);
            RVLogger.d(UniformIpcUtils.TAG, sb.toString());
            ServiceBeanManager serviceBeanManager = UniformIpcUtils.getServiceBeanManager();
            if (serviceBeanManager != null) {
                serviceBeanManager.register(cls.getName(), t);
            }
        } catch (Exception e) {
            RVLogger.e(UniformIpcUtils.TAG, Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy
    public <T> T getRemoteCaller(Class<T> cls) {
        try {
            return (T) RemoteCallClient.getIpcProxy(cls);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getRemoteCaller ");
            sb.append(cls);
            sb.append(" exception!");
            RVLogger.e(UniformIpcUtils.TAG, sb.toString(), th);
            return null;
        }
    }
}
