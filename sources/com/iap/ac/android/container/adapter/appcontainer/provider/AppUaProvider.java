package com.iap.ac.android.container.adapter.appcontainer.provider;

import com.alipay.mobile.nebula.provider.H5UaProvider;
import com.iap.ac.android.common.container.provider.ContainerUaProvider;

/* loaded from: classes3.dex */
public class AppUaProvider implements H5UaProvider {
    private H5UaProvider oldProvider;
    private ContainerUaProvider uaProvider;

    public AppUaProvider(H5UaProvider h5UaProvider, ContainerUaProvider containerUaProvider) {
        this.oldProvider = h5UaProvider;
        this.uaProvider = containerUaProvider;
    }

    public String getUa(String str) {
        H5UaProvider h5UaProvider = this.oldProvider;
        if (h5UaProvider != null) {
            str = h5UaProvider.getUa(str);
        }
        return this.uaProvider.getUa(str);
    }
}
