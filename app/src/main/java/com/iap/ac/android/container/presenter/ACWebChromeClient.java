package com.iap.ac.android.container.presenter;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.js.ACJSBridge;

/* loaded from: classes3.dex */
public class ACWebChromeClient extends WebChromeClient {
    private static final String TAG = "ACWebChromeClient";
    private String bizCode;
    private ACContainerPresenter containerPresenter;
    private WebView mWebView;

    public ACWebChromeClient(WebView webView, ACContainerPresenter aCContainerPresenter, String str) {
        this.mWebView = webView;
        this.containerPresenter = aCContainerPresenter;
        this.bizCode = str;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        StringBuilder sb = new StringBuilder();
        sb.append("onProgressChanged: ");
        sb.append(i);
        ACLog.d(TAG, sb.toString());
        ACContainerPresenter aCContainerPresenter = this.containerPresenter;
        if (aCContainerPresenter != null) {
            aCContainerPresenter.onProgressChanged(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedTitle: ");
        sb.append(str);
        ACLog.d(TAG, sb.toString());
        ACContainerPresenter aCContainerPresenter = this.containerPresenter;
        if (aCContainerPresenter != null) {
            aCContainerPresenter.setTitle(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onConsoleMessage msg: ");
        sb.append(consoleMessage.message());
        ACLog.d(TAG, sb.toString());
        if (consoleMessage.message().startsWith(ACJSBridge.JSAPI_PREFIX)) {
            return ACJSBridge.getInstance(this.bizCode).handleMsgFromJs(consoleMessage.message(), this.mWebView, this.containerPresenter);
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
