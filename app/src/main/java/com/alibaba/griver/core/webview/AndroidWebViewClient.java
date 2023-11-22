package com.alibaba.griver.core.webview;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.nebula.H5ResourceCORSUtil;
import com.alibaba.griver.base.nebula.H5Utils;
import com.google.common.net.HttpHeaders;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class AndroidWebViewClient extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private APWebView f6490a;
    private APWebViewClient b;
    private long c;
    private int d = H5Utils.getUid(GriverEnv.getApplicationContext());

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidWebViewClient(APWebView aPWebView, APWebViewClient aPWebViewClient) {
        this.b = aPWebViewClient;
        this.f6490a = aPWebView;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.b;
        return aPWebViewClient != null && aPWebViewClient.shouldOverrideUrlLoading(this.f6490a, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.b != null) {
            this.c = a();
            this.b.onPageStarted(this.f6490a, str, bitmap);
        }
    }

    private long a() {
        try {
            return TrafficStats.getUidRxBytes(this.d);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.b != null) {
            this.b.onPageFinished(this.f6490a, str, a() - this.c);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onLoadResource(this.f6490a, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            return aPWebViewClient.shouldInterceptRequest(this.f6490a, str);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String cORSUrl;
        if (this.b != null) {
            WebResourceResponse shouldInterceptRequest = this.b.shouldInterceptRequest(this.f6490a, new AndroidWebResourceRequest(webResourceRequest));
            if (shouldInterceptRequest != null) {
                String obj = webResourceRequest.getUrl().toString();
                Map<String, String> responseHeaders = shouldInterceptRequest.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                if (!responseHeaders.containsKey("Cache-Control")) {
                    responseHeaders.put("Cache-Control", SplitHttpHeadersBuilder.CACHE_CONTROL_NO_CACHE);
                }
                String pageUrl = this.b.getPageUrl();
                if (pageUrl != null && H5ResourceCORSUtil.needAddHeader(obj) && (cORSUrl = H5ResourceCORSUtil.getCORSUrl(pageUrl)) != null) {
                    responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, cORSUrl);
                }
                String cORSUrl2 = H5ResourceCORSUtil.getCORSUrl(pageUrl);
                if (!responseHeaders.containsKey(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN) && !TextUtils.isEmpty(obj) && H5Utils.containNebulaAddcors(obj) && !TextUtils.isEmpty(pageUrl) && !TextUtils.isEmpty(cORSUrl2)) {
                    responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, cORSUrl2);
                }
                if (!responseHeaders.containsKey(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN) && H5Utils.addChooseImageCrossOrigin(obj) && !TextUtils.isEmpty(pageUrl) && !TextUtils.isEmpty(cORSUrl2)) {
                    responseHeaders.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, cORSUrl2);
                }
                shouldInterceptRequest.setResponseHeaders(responseHeaders);
                return shouldInterceptRequest;
            }
            return shouldInterceptRequest;
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedError(this.f6490a, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (this.b != null) {
            this.b.onReceivedHttpError(this.f6490a, webResourceResponse != null ? webResourceResponse.getStatusCode() : 0, webResourceRequest != null ? webResourceRequest.getUrl().toString() : "");
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onFormResubmission(this.f6490a, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.doUpdateVisitedHistory(this.f6490a, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedSslError(this.f6490a, new AndroidSslErrorHandler(sslErrorHandler), new AndroidSslError(0, null, sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onReceivedHttpAuthRequest(this.f6490a, new AndroidHttpAuthHandler(httpAuthHandler), str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        APWebViewClient aPWebViewClient = this.b;
        return aPWebViewClient != null && aPWebViewClient.shouldOverrideKeyEvent(this.f6490a, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        APWebView aPWebView = this.f6490a;
        if (aPWebView != null) {
            this.b.onUnhandledKeyEvent(aPWebView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        APWebViewClient aPWebViewClient = this.b;
        if (aPWebViewClient != null) {
            aPWebViewClient.onScaleChanged(this.f6490a, f, f2);
        }
    }
}
