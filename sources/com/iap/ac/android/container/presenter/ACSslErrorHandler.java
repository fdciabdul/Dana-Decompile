package com.iap.ac.android.container.presenter;

import android.webkit.SslErrorHandler;
import com.iap.ac.android.common.container.provider.interf.ISslErrorHandler;

/* loaded from: classes3.dex */
public class ACSslErrorHandler implements ISslErrorHandler {
    private SslErrorHandler handler;

    public ACSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.handler = sslErrorHandler;
    }

    @Override // com.iap.ac.android.common.container.provider.interf.ISslErrorHandler
    public void proceed() {
        SslErrorHandler sslErrorHandler = this.handler;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    @Override // com.iap.ac.android.common.container.provider.interf.ISslErrorHandler
    public void cancel() {
        SslErrorHandler sslErrorHandler = this.handler;
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }
}
