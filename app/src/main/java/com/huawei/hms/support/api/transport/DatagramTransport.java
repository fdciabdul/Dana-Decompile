package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

/* loaded from: classes8.dex */
public interface DatagramTransport {

    /* loaded from: classes8.dex */
    public interface a {
        void BuiltInFictitiousFunctionClassFactory(int i, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, a aVar);

    void send(ApiClient apiClient, a aVar);
}
