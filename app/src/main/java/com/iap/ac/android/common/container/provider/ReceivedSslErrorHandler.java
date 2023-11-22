package com.iap.ac.android.common.container.provider;

import android.net.http.SslError;
import com.iap.ac.android.common.container.ContainerWebView;
import com.iap.ac.android.common.container.provider.interf.ISslErrorHandler;

/* loaded from: classes3.dex */
public interface ReceivedSslErrorHandler {
    void onReceivedSslError(ContainerWebView containerWebView, ISslErrorHandler iSslErrorHandler, SslError sslError);
}
