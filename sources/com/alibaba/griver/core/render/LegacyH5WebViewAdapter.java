package com.alibaba.griver.core.render;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.api.APDownloadListener;
import com.alibaba.griver.base.api.APHitTestResult;
import com.alibaba.griver.base.api.APWebBackForwardList;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebSettings;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.api.APWebViewListener;
import com.alibaba.griver.base.api.H5OverScrollListener;
import com.alibaba.griver.base.api.H5ScrollChangedCallback;
import com.alibaba.griver.base.api.IH5EmbedViewJSCallback;
import com.alibaba.griver.base.api.NXH5WebViewAdapter;
import com.alibaba.griver.base.api.NXH5WebViewClientAdapter;
import com.alibaba.griver.base.nebula.WebViewType;
import java.util.Map;

/* loaded from: classes3.dex */
public class LegacyH5WebViewAdapter implements NXH5WebViewAdapter {

    /* renamed from: a */
    private H5WebView f6454a;
    private NXAPWebViewListener b;
    private GriverWebRenderImpl c;
    private NXH5WebViewClientAdapter d;

    public LegacyH5WebViewAdapter(GriverWebRenderImpl griverWebRenderImpl, H5WebView h5WebView, NXAPWebViewListener nXAPWebViewListener) {
        this.f6454a = h5WebView;
        this.b = nXAPWebViewListener;
        this.c = griverWebRenderImpl;
    }

    public void setNxh5WebViewClientAdapter(NXH5WebViewClientAdapter nXH5WebViewClientAdapter) {
        this.d = nXH5WebViewClientAdapter;
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public int getWebViewIndex() {
        return this.f6454a.getWebViewIndex();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void init(boolean z) {
        this.f6454a.init(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setTextSize(int i) {
        this.f6454a.setTextSize(i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebSettings.TextSize getTextSize(int i) {
        return this.f6454a.getTextSize(i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void loadUrl(String str) {
        this.f6454a.loadUrl(str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        this.f6454a.execJavaScript4EmbedView(str, iH5EmbedViewJSCallback);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setH5OverScrollListener(H5OverScrollListener h5OverScrollListener) {
        NXAPWebViewListener nXAPWebViewListener = this.b;
        if (nXAPWebViewListener != null) {
            nXAPWebViewListener.setH5OverScrollListener(h5OverScrollListener);
        }
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void addJavascriptInterface(Object obj, String str) {
        this.f6454a.addJavascriptInterface(obj, str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setWebContentsDebuggingEnabled(boolean z) {
        this.f6454a.setWebContentsDebuggingEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void flingScroll(int i, int i2) {
        this.f6454a.flingScroll(i, i2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean zoomIn() {
        return this.f6454a.zoomIn();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean zoomOut() {
        return this.f6454a.zoomOut();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setHorizontalScrollbarOverlay(boolean z) {
        this.f6454a.setHorizontalScrollbarOverlay(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setVerticalScrollbarOverlay(boolean z) {
        this.f6454a.setVerticalScrollbarOverlay(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean overlayHorizontalScrollbar() {
        return this.f6454a.overlayHorizontalScrollbar();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean overlayVerticalScrollbar() {
        return this.f6454a.overlayVerticalScrollbar();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public SslCertificate getCertificate() {
        return this.f6454a.getCertificate();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void savePassword(String str, String str2, String str3) {
        this.f6454a.savePassword(str, str2, str3);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.f6454a.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.f6454a.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void destroy() {
        this.f6454a.destroy();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setNetworkAvailable(boolean z) {
        this.f6454a.setNetworkAvailable(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebBackForwardList saveState(Bundle bundle) {
        return this.f6454a.saveState(bundle);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebBackForwardList restoreState(Bundle bundle) {
        return this.f6454a.restoreState(bundle);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void loadUrl(String str, Map<String, String> map) {
        this.f6454a.loadUrl(str, map);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void postUrl(String str, byte[] bArr) {
        this.f6454a.postUrl(str, bArr);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void loadData(String str, String str2, String str3) {
        this.f6454a.loadData(str, str2, str3);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f6454a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.f6454a.evaluateJavascript(str, valueCallback);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void stopLoading() {
        this.f6454a.stopLoading();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void reload() {
        this.f6454a.reload();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean canGoBack() {
        return this.f6454a.canGoBack();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void goBack() {
        this.f6454a.goBack();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean canGoForward() {
        return this.f6454a.canGoForward();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void goForward() {
        this.f6454a.goForward();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean canGoBackOrForward(int i) {
        return this.f6454a.canGoBackOrForward(i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void goBackOrForward(int i) {
        this.f6454a.goBackOrForward(i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean pageUp(boolean z) {
        return this.f6454a.pageUp(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean pageDown(boolean z) {
        return this.f6454a.pageDown(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setInitialScale(int i) {
        this.f6454a.setInitialScale(i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void invokeZoomPicker() {
        this.f6454a.invokeZoomPicker();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public String getUrl() {
        return this.f6454a.getUrl();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public String getOriginalUrl() {
        return this.f6454a.getOriginalUrl();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public String getTitle() {
        return this.f6454a.getTitle();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public Bitmap getFavicon() {
        return this.f6454a.getFavicon();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public int getProgress() {
        return this.f6454a.getProgress();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public int getContentHeight() {
        return this.f6454a.getContentHeight();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public int getContentWidth() {
        return this.f6454a.getContentWidth();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void onPause() {
        this.f6454a.onPause();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void onResume() {
        this.f6454a.onResume();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean isPaused() {
        return this.f6454a.isPaused();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void freeMemory() {
        this.f6454a.freeMemory();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void clearCache(boolean z) {
        this.f6454a.clearCache(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void clearFormData() {
        this.f6454a.clearFormData();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void clearHistory() {
        this.f6454a.clearHistory();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void clearSslPreferences() {
        this.f6454a.clearSslPreferences();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebBackForwardList copyBackForwardList() {
        return this.f6454a.copyBackForwardList();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setDownloadListener(APDownloadListener aPDownloadListener) {
        this.f6454a.setDownloadListener(aPDownloadListener);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void removeJavascriptInterface(String str) {
        this.f6454a.removeJavascriptInterface(str);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void onRelease() {
        H5WebView h5WebView = this.f6454a;
        if (h5WebView != null) {
            h5WebView.onRelease();
            this.f6454a = null;
        }
        this.c = null;
        this.b = null;
        this.d = null;
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebSettings getSettings() {
        return this.f6454a.getSettings();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APHitTestResult getHitTestResult() {
        return this.f6454a.getHitTestResult();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public Picture capturePicture() {
        return this.f6454a.capturePicture();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
        this.f6454a.setAPWebViewListener(aPWebViewListener);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public View getView() {
        return this.f6454a.getView();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public WebViewType getType() {
        H5WebView h5WebView = this.f6454a;
        if (h5WebView == null) {
            return null;
        }
        return h5WebView.getType();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public String getVersion() {
        return this.f6454a.getVersion();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public float getScale() {
        return this.f6454a.getScale();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setScale(float f) {
        this.f6454a.setScale(f);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setVerticalScrollBarEnabled(boolean z) {
        this.f6454a.setVerticalScrollBarEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.f6454a.setHorizontalScrollBarEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
        this.f6454a.setOnScrollChangedCallback(h5ScrollChangedCallback);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public int getScrollY() {
        return this.f6454a.getScrollY();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6454a.dispatchKeyEvent(keyEvent);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i) {
        return this.f6454a.getCurrentPageSnapshot(rect, rect2, bitmap, z, i);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public Page getH5Page() {
        H5WebView h5WebView = this.f6454a;
        if (h5WebView == null) {
            return null;
        }
        return h5WebView.getH5Page();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebView getInternalContentView() {
        return this.f6454a.getInternalContentView();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public NXH5WebViewClientAdapter getWebViewClient() {
        return this.d;
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setWebViewClient(APWebViewClient aPWebViewClient) {
        this.f6454a.setWebViewClient(aPWebViewClient);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public APWebChromeClient getWebChromeClient() {
        return this.c.getNxWebChromeClient();
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
        this.f6454a.setWebChromeClient(aPWebChromeClient);
    }

    @Override // com.alibaba.griver.base.api.NXH5WebViewAdapter
    public void getStartupPerformanceStatistics(ValueCallback<String> valueCallback) {
        this.f6454a.getStartupPerformanceStatistics(valueCallback);
    }
}
