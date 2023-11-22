package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.proxy.RVAppFactory;
import com.alibaba.ariver.kernel.common.RVProxy;

/* loaded from: classes6.dex */
public class DefaultAppFactoryImpl implements RVAppFactory {
    @Override // com.alibaba.ariver.app.proxy.RVAppFactory
    public AppNode createApp() {
        return new AppNode((AppManager) RVProxy.get(AppManager.class));
    }
}
