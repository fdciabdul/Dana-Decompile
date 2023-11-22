package com.alibaba.ariver.kernel.ipc.uniform;

/* loaded from: classes3.dex */
public interface ServiceBeanManager {
    Object getServiceBean(String str);

    int getServiceBeanCount();

    void register(String str, Object obj);

    void registerAndOverride(String str, Object obj);

    void unregister(String str);

    void unregisterAll();
}
