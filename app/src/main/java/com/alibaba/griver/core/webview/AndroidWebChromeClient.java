package com.alibaba.griver.core.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.alibaba.griver.base.api.APJsPromptResult;
import com.alibaba.griver.base.api.APJsResult;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.nebula.DynamicProxy;
import com.alibaba.griver.core.render.H5PermissionUtils;

/* loaded from: classes6.dex */
class AndroidWebChromeClient extends WebChromeClient {
    public static final String TAG = "AndroidWebChromeClient";

    /* renamed from: a  reason: collision with root package name */
    private APWebView f6485a;
    private APWebChromeClient b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidWebChromeClient(APWebView aPWebView, APWebChromeClient aPWebChromeClient) {
        this.f6485a = aPWebView;
        this.b = aPWebChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onProgressChanged(this.f6485a, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedTitle(this.f6485a, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedIcon(this.f6485a, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onReceivedTouchIconUrl(this.f6485a, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onShowCustomView(view, (APWebChromeClient.CustomViewCallback) DynamicProxy.dynamicProxy(APWebChromeClient.CustomViewCallback.class, customViewCallback));
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.b.onCreateWindow(this.f6485a, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onRequestFocus(this.f6485a);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onCloseWindow(this.f6485a);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsAlert(this.f6485a, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsConfirm(this.f6485a, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.b.onJsPrompt(this.f6485a, str, str2, str3, (APJsPromptResult) DynamicProxy.dynamicProxy(APJsPromptResult.class, jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.b.onJsBeforeUnload(this.f6485a, str, str2, (APJsResult) DynamicProxy.dynamicProxy(APJsResult.class, jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onGeolocationPermissionsShowPrompt(str, (GeolocationPermissions.Callback) DynamicProxy.dynamicProxy(GeolocationPermissions.Callback.class, callback));
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        APWebChromeClient aPWebChromeClient = this.b;
        return aPWebChromeClient != null && aPWebChromeClient.onConsoleMessage(new ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name())));
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            return aPWebChromeClient.getDefaultVideoPoster();
        }
        return null;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            return aPWebChromeClient.getVideoLoadingProgressView();
        }
        return null;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.b.getVisitedHistory((ValueCallback) DynamicProxy.dynamicProxy(ValueCallback.class, valueCallback));
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.openFileChooser(valueCallback, str, null);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            aPWebChromeClient.openFileChooser(valueCallback, str, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        APWebChromeClient aPWebChromeClient = this.b;
        if (aPWebChromeClient != null) {
            return aPWebChromeClient.onShowFileChooser(valueCallback, fileChooserParams);
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        if (H5PermissionUtils.enableAllowH5Permission()) {
            H5PermissionUtils.processPermission(this.b, permissionRequest);
        } else {
            super.onPermissionRequest(permissionRequest);
        }
    }
}
