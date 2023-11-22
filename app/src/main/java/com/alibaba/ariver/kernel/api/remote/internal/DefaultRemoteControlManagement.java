package com.alibaba.ariver.kernel.api.remote.internal;

import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.remote.IRemoteCaller;
import com.alibaba.ariver.kernel.api.remote.RemoteControlManagement;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.ipc.RVRemoteCallerProxy;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultRemoteControlManagement implements RemoteControlManagement {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Map<Method, Boolean>> f6102a = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteControlManagement
    public boolean isRemoteExtension(Extension extension, Method method) {
        if (ProcessUtils.isMainProcess()) {
            return false;
        }
        return hasRemoteAnnotation(extension, method);
    }

    protected boolean hasRemoteAnnotation(Extension extension, Method method) {
        Map<Method, Boolean> map = this.f6102a.get(extension.getClass().getName());
        if (map != null) {
            if (map.get(method) != null) {
                return map.get(method).booleanValue();
            }
        } else {
            map = new ConcurrentHashMap<>();
            this.f6102a.put(extension.getClass().getName(), map);
        }
        try {
            if (method.getDeclaringClass().getAnnotation(Remote.class) != null) {
                map.put(method, Boolean.TRUE);
                return true;
            } else if (extension.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).getAnnotation(Remote.class) != null) {
                map.put(method, Boolean.TRUE);
                return true;
            } else {
                map.put(method, Boolean.FALSE);
                return false;
            }
        } catch (NoSuchMethodException unused) {
            map.put(method, Boolean.FALSE);
            return false;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.remote.RemoteControlManagement
    public IRemoteCaller getRemoteCallerProxy() {
        return (IRemoteCaller) ((RVRemoteCallerProxy) RVProxy.get(RVRemoteCallerProxy.class)).getRemoteCaller(IRemoteCaller.class);
    }
}
