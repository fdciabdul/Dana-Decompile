package com.alibaba.griver.core.webview;

import android.webkit.HttpAuthHandler;
import com.alibaba.griver.base.api.APHttpAuthHandler;

/* loaded from: classes6.dex */
class AndroidHttpAuthHandler implements APHttpAuthHandler {
    HttpAuthHandler httpAuthHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidHttpAuthHandler(HttpAuthHandler httpAuthHandler) {
        this.httpAuthHandler = httpAuthHandler;
    }

    @Override // com.alibaba.griver.base.api.APHttpAuthHandler
    public void cancel() {
        HttpAuthHandler httpAuthHandler = this.httpAuthHandler;
        if (httpAuthHandler != null) {
            httpAuthHandler.cancel();
        }
    }

    @Override // com.alibaba.griver.base.api.APHttpAuthHandler
    public void proceed(String str, String str2) {
        HttpAuthHandler httpAuthHandler = this.httpAuthHandler;
        if (httpAuthHandler != null) {
            httpAuthHandler.proceed(str, str2);
        }
    }

    @Override // com.alibaba.griver.base.api.APHttpAuthHandler
    public boolean useHttpAuthUsernamePassword() {
        HttpAuthHandler httpAuthHandler = this.httpAuthHandler;
        return httpAuthHandler != null && httpAuthHandler.useHttpAuthUsernamePassword();
    }
}
