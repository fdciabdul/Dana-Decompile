package com.alibaba.griver.core.webview;

import android.webkit.SslErrorHandler;
import com.alibaba.griver.base.api.APSslErrorHandler;

/* loaded from: classes6.dex */
class AndroidSslErrorHandler implements APSslErrorHandler {

    /* renamed from: a  reason: collision with root package name */
    private SslErrorHandler f6483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f6483a = sslErrorHandler;
    }

    @Override // com.alibaba.griver.base.api.APSslErrorHandler
    public void cancel() {
        this.f6483a.cancel();
    }

    @Override // com.alibaba.griver.base.api.APSslErrorHandler
    public void proceed() {
        this.f6483a.proceed();
    }
}
