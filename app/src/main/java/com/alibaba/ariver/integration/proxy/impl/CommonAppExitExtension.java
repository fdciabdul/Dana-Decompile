package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.kernel.common.bytebuffer.RVByteBufferManager;

/* loaded from: classes6.dex */
public class CommonAppExitExtension implements AppExitPoint {
    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        RVByteBufferManager.releaseAllBuffer();
    }
}
