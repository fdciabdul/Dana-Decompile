package com.iap.ac.android.container.adapter.appcontainer;

import android.net.http.SslCertificate;
import com.alipay.mobile.nebula.webview.APWebView;
import com.iap.ac.android.common.container.ContainerWebView;
import java.util.Map;

/* loaded from: classes8.dex */
public class AppContainerWebView implements ContainerWebView {
    private APWebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContainerWebView(APWebView aPWebView) {
        this.mWebView = aPWebView;
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public SslCertificate getCertificate() {
        return this.mWebView.getCertificate();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void loadUrl(String str, Map<String, String> map) {
        this.mWebView.loadUrl(str, map);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void loadUrl(String str) {
        this.mWebView.loadUrl(str);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void postUrl(String str, byte[] bArr) {
        this.mWebView.postUrl(str, bArr);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void loadData(String str, String str2, String str3) {
        this.mWebView.loadData(str, str2, str3);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void stopLoading() {
        this.mWebView.stopLoading();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void reload() {
        this.mWebView.reload();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public boolean canGoBack() {
        return this.mWebView.canGoBack();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void goBack() {
        this.mWebView.goBack();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public boolean canGoForward() {
        return this.mWebView.canGoForward();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void goForward() {
        this.mWebView.goForward();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public boolean canGoBackOrForward(int i) {
        return this.mWebView.canGoBackOrForward(i);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void goBackOrForward(int i) {
        this.mWebView.goBackOrForward(i);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public boolean pageUp(boolean z) {
        return this.mWebView.pageUp(z);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public boolean pageDown(boolean z) {
        return this.mWebView.pageDown(z);
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public String getUrl() {
        return this.mWebView.getUrl();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public String getOriginalUrl() {
        return this.mWebView.getOriginalUrl();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public String getTitle() {
        return this.mWebView.getTitle();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void clearHistory() {
        this.mWebView.clearHistory();
    }

    @Override // com.iap.ac.android.common.container.ContainerWebView
    public void clearSslPreferences() {
        this.mWebView.clearSslPreferences();
    }
}
