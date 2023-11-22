package com.alibaba.griver.api.bridge;

import android.content.Context;
import android.net.http.SslError;
import com.alibaba.griver.api.common.GriverEvent;
import com.alibaba.griver.base.api.APSslErrorHandler;

/* loaded from: classes6.dex */
public interface GriverReceivedSslErrorEvent extends GriverEvent {
    void onReceivedSslError(Context context, APSslErrorHandler aPSslErrorHandler, SslError sslError);
}
