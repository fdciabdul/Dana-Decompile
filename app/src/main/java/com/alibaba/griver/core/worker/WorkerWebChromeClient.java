package com.alibaba.griver.core.worker;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.alibaba.griver.base.api.APJsPromptResult;
import com.alibaba.griver.base.api.APJsResult;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebView;

/* loaded from: classes6.dex */
public class WorkerWebChromeClient implements APWebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private WebWorker f6500a;

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public View getVideoLoadingProgressView() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onCloseWindow(APWebView aPWebView) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onCreateWindow(APWebView aPWebView, boolean z, boolean z2, Message message) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onHideCustomView() {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsAlert(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsBeforeUnload(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsConfirm(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsPrompt(APWebView aPWebView, String str, String str2, String str3, APJsPromptResult aPJsPromptResult) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onProgressChanged(APWebView aPWebView, int i) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedIcon(APWebView aPWebView, Bitmap bitmap) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedTitle(APWebView aPWebView, String str) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedTouchIconUrl(APWebView aPWebView, String str, boolean z) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onRequestFocus(APWebView aPWebView) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onShowCustomView(View view, APWebChromeClient.CustomViewCallback customViewCallback) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void openFileChooser(ValueCallback valueCallback, boolean z) {
    }

    public WorkerWebChromeClient(WebWorker webWorker) {
        this.f6500a = webWorker;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f6500a.getWorkerControllerProvider().handleMsgFromWorker(consoleMessage.message());
        return false;
    }
}
