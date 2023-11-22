package com.alibaba.griver.core.render;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.webview.AndroidWebView;
import com.alibaba.griver.core.webview.AndroidWebViewDelegateView;

/* loaded from: classes6.dex */
public class NXWebViewFactory {

    /* renamed from: a  reason: collision with root package name */
    private static NXWebViewFactory f6459a;

    private NXWebViewFactory() {
    }

    public static NXWebViewFactory instance() {
        if (f6459a == null) {
            f6459a = new NXWebViewFactory();
        }
        return f6459a;
    }

    public APWebView createWebView(String str, Context context, Bundle bundle, boolean z, APWebView aPWebView) {
        long currentTimeMillis = System.currentTimeMillis();
        if (aPWebView == null) {
            try {
                RVLogger.d("Griver:NXWebViewFactory", "create android web view");
                aPWebView = new AndroidWebView(context);
            } finally {
                if (z) {
                }
            }
        }
        if (aPWebView != null) {
            String version = aPWebView.getVersion();
            StringBuilder sb = new StringBuilder();
            sb.append("webview version: ");
            sb.append(version);
            RVLogger.d("Griver:NXWebViewFactory", sb.toString());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("createWebView elapse ");
        sb2.append(currentTimeMillis2 - currentTimeMillis);
        RVLogger.d("Griver:NXWebViewFactory", sb2.toString());
        a(bundle, aPWebView);
        return aPWebView;
    }

    private void a(Bundle bundle, APWebView aPWebView) {
        if (!BundleUtils.getBoolean(bundle, RVParams.isH5App, false)) {
            RVLogger.d("Griver:NXWebViewFactory", "mini program not support CONTAINER_BACKGROUND_COLOR field now");
        } else if (BundleUtils.contains(bundle, GriverLaunchParams.CONTAINER_BACKGROUND_COLOR)) {
            int i = BundleUtils.getInt(bundle, GriverLaunchParams.CONTAINER_BACKGROUND_COLOR);
            if (!(aPWebView.getView() instanceof AndroidWebViewDelegateView) || ((AndroidWebViewDelegateView) aPWebView.getView()).getChildAt(0) == null) {
                return;
            }
            GriverLogger.d("Griver:NXWebViewFactory", "apWebView.getView() is AndroidWebView");
            ((AndroidWebViewDelegateView) aPWebView.getView()).getChildAt(0).setBackgroundColor(i);
        }
    }
}
