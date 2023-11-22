package com.alibaba.griver.core.render;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceResponse;
import com.alibaba.griver.base.api.APHttpAuthHandler;
import com.alibaba.griver.base.api.APSslErrorHandler;
import com.alibaba.griver.base.api.APWebResourceRequest;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.NXH5WebViewClientAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LegacyNXH5WebViewClientAdapter implements NXH5WebViewClientAdapter {

    /* renamed from: a  reason: collision with root package name */
    private GriverWebViewClient f6455a;

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public String getRedirectUrl() {
        return "";
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public String getShareUrl() {
        return "";
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public boolean hasPageStartButNoInterceptRequest() {
        return true;
    }

    public LegacyNXH5WebViewClientAdapter(GriverWebViewClient griverWebViewClient) {
        this.f6455a = griverWebViewClient;
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public String getPageUrl() {
        return this.f6455a.getPageUrl();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public boolean shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        return this.f6455a.shouldOverrideUrlLoading(aPWebView, str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
        this.f6455a.onPageStarted(aPWebView, str, bitmap);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onPageFinished(APWebView aPWebView, String str, long j) {
        this.f6455a.onPageFinished(aPWebView, str, j);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onLoadResource(APWebView aPWebView, String str) {
        this.f6455a.onLoadResource(aPWebView, str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
        return this.f6455a.shouldInterceptRequest(aPWebView, aPWebResourceRequest);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, String str) {
        return this.f6455a.shouldInterceptRequest(aPWebView, str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onTooManyRedirects(APWebView aPWebView, Message message, Message message2) {
        this.f6455a.onTooManyRedirects(aPWebView, message, message2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        this.f6455a.onReceivedError(aPWebView, i, str, str2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        this.f6455a.onReceivedHttpError(aPWebView, i, str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public boolean shouldInterceptResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        return this.f6455a.shouldInterceptResponse(aPWebView, hashMap);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onWebViewEvent(APWebView aPWebView, int i, Object obj) {
        this.f6455a.onWebViewEvent(aPWebView, i, obj);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onFirstVisuallyRender(APWebView aPWebView) {
        this.f6455a.onFirstVisuallyRender(aPWebView);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onFormResubmission(APWebView aPWebView, Message message, Message message2) {
        this.f6455a.onFormResubmission(aPWebView, message, message2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
        this.f6455a.doUpdateVisitedHistory(aPWebView, str, z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedSslError(APWebView aPWebView, APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        this.f6455a.onReceivedSslError(aPWebView, aPSslErrorHandler, sslError);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedHttpAuthRequest(APWebView aPWebView, APHttpAuthHandler aPHttpAuthHandler, String str, String str2) {
        this.f6455a.onReceivedHttpAuthRequest(aPWebView, aPHttpAuthHandler, str, str2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public boolean shouldOverrideKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        return this.f6455a.shouldOverrideKeyEvent(aPWebView, keyEvent);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onUnhandledKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        this.f6455a.onUnhandledKeyEvent(aPWebView, keyEvent);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onScaleChanged(APWebView aPWebView, float f, float f2) {
        this.f6455a.onScaleChanged(aPWebView, f, f2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedLoginRequest(APWebView aPWebView, String str, String str2, String str3) {
        this.f6455a.onReceivedLoginRequest(aPWebView, str, str2, str2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public String getJSBridge() {
        return this.f6455a.getJSBridge();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onResourceResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        this.f6455a.onResourceResponse(aPWebView, hashMap);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onResourceFinishLoad(APWebView aPWebView, String str, long j) {
        this.f6455a.onResourceFinishLoad(aPWebView, str, j);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public void onReceivedResponseHeader(Map<String, List<String>> map) {
        this.f6455a.onReceivedResponseHeader(map);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public boolean shouldOverrideUrlLoadingForUC(APWebView aPWebView, String str, int i) {
        return this.f6455a.shouldOverrideUrlLoadingForUC(aPWebView, str, i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewClientAdapter
    public Map getRequestMap() {
        return this.f6455a.getRequestMap();
    }
}
