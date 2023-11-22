package com.alibaba.ariver.ipc.uniform;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import com.alibaba.ariver.kernel.ipc.uniform.UniformIpcUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ServiceBeanManagerImpl implements ServiceBeanManager {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f6075a = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void register(String str, Object obj) {
        if (this.f6075a.get(str) != null) {
            return;
        }
        this.f6075a.put(str, obj);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceBeanManagerImpl ihashcode=[");
        sb.append(hashCode());
        sb.append("]   register className=");
        sb.append(str);
        RVLogger.d(UniformIpcUtils.TAG, sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void registerAndOverride(String str, Object obj) {
        this.f6075a.put(str, obj);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceBeanManagerImpl ihashcode=[");
        sb.append(hashCode());
        sb.append("]  registerAndOverride className=");
        sb.append(str);
        RVLogger.d(UniformIpcUtils.TAG, sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void unregister(String str) {
        this.f6075a.remove(str);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceBeanManagerImpl unregister className=");
        sb.append(str);
        RVLogger.d(UniformIpcUtils.TAG, sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public void unregisterAll() {
        this.f6075a.clear();
        RVLogger.d(UniformIpcUtils.TAG, "ServiceBeanManagerImpl unregisterAll");
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public Object getServiceBean(String str) {
        Object obj = this.f6075a.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceBeanManagerImpl getServiceBean className=");
        sb.append(str);
        sb.append(",obj is ");
        sb.append(obj == null ? "null" : "not null");
        RVLogger.debug(UniformIpcUtils.TAG, sb.toString());
        return obj;
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager
    public int getServiceBeanCount() {
        return this.f6075a.size();
    }
}
