package com.alibaba.griver.base.api;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebResourceResponse;

/* loaded from: classes6.dex */
public abstract class UcService {

    /* loaded from: classes6.dex */
    public interface UCInitListener {
        void onFailed();

        void onSuccess();
    }

    public abstract void addInitSuccessListener(UCInitListener uCInitListener);

    public abstract boolean clearServiceWorkerCacheEnabled();

    public abstract APWebView createWebView(Context context, boolean z) throws IllegalArgumentException;

    public abstract APWebView createWebView(Context context, boolean z, Bundle bundle) throws IllegalArgumentException;

    public APWebView createWebViewForNebulaX(Context context, boolean z) throws IllegalArgumentException {
        return null;
    }

    public abstract String getDefaultUserAgent(Context context);

    public abstract WebResourceResponse getResponse(String str);

    public abstract String getUcVersion();

    public abstract boolean init(boolean z);

    public abstract boolean init(boolean z, Bundle bundle);

    @Deprecated
    public abstract String initUC7zSo();

    public abstract void removeInitSuccessListener(UCInitListener uCInitListener);
}
