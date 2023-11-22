package com.iap.ac.android.container.adapter.appcontainer.provider;

import com.alipay.mobile.nebula.webview.APSslErrorHandler;
import com.iap.ac.android.common.container.provider.interf.ISslErrorHandler;

/* loaded from: classes8.dex */
public class AppSslErrorHandler implements ISslErrorHandler {
    private APSslErrorHandler errorHandler;

    public AppSslErrorHandler(APSslErrorHandler aPSslErrorHandler) {
        this.errorHandler = aPSslErrorHandler;
    }

    @Override // com.iap.ac.android.common.container.provider.interf.ISslErrorHandler
    public void proceed() {
        APSslErrorHandler aPSslErrorHandler = this.errorHandler;
        if (aPSslErrorHandler == null) {
            return;
        }
        aPSslErrorHandler.proceed();
    }

    @Override // com.iap.ac.android.common.container.provider.interf.ISslErrorHandler
    public void cancel() {
        APSslErrorHandler aPSslErrorHandler = this.errorHandler;
        if (aPSslErrorHandler == null) {
            return;
        }
        aPSslErrorHandler.cancel();
    }
}
