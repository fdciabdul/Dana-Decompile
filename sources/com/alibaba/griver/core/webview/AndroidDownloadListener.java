package com.alibaba.griver.core.webview;

import android.webkit.DownloadListener;
import com.alibaba.griver.base.api.APDownloadListener;

/* loaded from: classes6.dex */
class AndroidDownloadListener implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    private APDownloadListener f6481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidDownloadListener(APDownloadListener aPDownloadListener) {
        this.f6481a = aPDownloadListener;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        APDownloadListener aPDownloadListener = this.f6481a;
        if (aPDownloadListener != null) {
            aPDownloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
