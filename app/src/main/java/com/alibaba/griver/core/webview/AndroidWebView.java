package com.alibaba.griver.core.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.APDownloadListener;
import com.alibaba.griver.base.api.APHitTestResult;
import com.alibaba.griver.base.api.APWebBackForwardList;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebMessagePort;
import com.alibaba.griver.base.api.APWebSettings;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.api.APWebViewListener;
import com.alibaba.griver.base.api.H5ScrollChangedCallback;
import com.alibaba.griver.base.api.IH5EmbedViewJSCallback;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.nebula.APWebMessage;
import com.alibaba.griver.base.nebula.H5PatternHelper;
import com.alibaba.griver.base.nebula.WebViewType;
import com.alipay.mobile.zebra.data.ZebraData;
import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class AndroidWebView implements APWebView {

    /* renamed from: a  reason: collision with root package name */
    private APWebSettings f6489a;
    private WebView b;
    private APWebViewListener c;
    private H5ScrollChangedCallback d;
    private String e;
    private AndroidWebViewDelegateView f;
    private boolean g = false;
    private float h = 1.0f;

    /* loaded from: classes6.dex */
    public interface EmbedViewRenderCallback {
        void onError(String str);

        void onRender(String str, String str2, int i, int i2, int i3, int i4);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void execJavaScript4EmbedView(String str, IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean isPaused() {
        return false;
    }

    public AndroidWebView(Context context) {
        WebViewEx webViewEx = new WebViewEx(context);
        this.b = webViewEx;
        webViewEx.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.alibaba.griver.core.webview.AndroidWebView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return false;
            }
        });
        AndroidWebViewDelegateView androidWebViewDelegateView = new AndroidWebViewDelegateView(context);
        this.f = androidWebViewDelegateView;
        androidWebViewDelegateView.setAndroidWebView(this.b);
        this.b.setBackgroundColor(0);
        this.f6489a = new AndroidWebSettings(this.b.getSettings());
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                cookieManager.setAcceptThirdPartyCookies(this.b, true);
            } catch (Throwable th) {
                RVLogger.e("AndroidWebView", "setAcceptThirdPartyCookies", th);
            }
        }
        this.f6489a.setSavePassword(false);
    }

    public void addEmbedView(String str, View view, int i, int i2, int i3, int i4) {
        this.f.addEmbedView(str, view, i, i2, i3, i4);
    }

    public void removeEmbedView(String str) {
        this.f.removeEmbedView(str);
    }

    public void tryRenderEmbedView(String str, final EmbedViewRenderCallback embedViewRenderCallback) {
        if (Build.VERSION.SDK_INT > 18) {
            StringBuilder sb = new StringBuilder();
            sb.append("document.androidEmbedViewManager.render(\"");
            sb.append(str);
            sb.append("\");");
            evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.alibaba.griver.core.webview.AndroidWebView.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                    if (TextUtils.isEmpty(str2)) {
                        embedViewRenderCallback.onError("empty render value!");
                        return;
                    }
                    JSONObject parseObject = JSONUtils.parseObject(str2);
                    if (parseObject == null) {
                        EmbedViewRenderCallback embedViewRenderCallback2 = embedViewRenderCallback;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("render value exception: ");
                        sb2.append(str2);
                        embedViewRenderCallback2.onError(sb2.toString());
                        return;
                    }
                    embedViewRenderCallback.onRender(parseObject.getString("elementId"), parseObject.getString("type"), parseObject.getInteger("x").intValue(), parseObject.getInteger("y").intValue(), parseObject.getInteger(ZebraData.ATTR_WIDTH).intValue(), parseObject.getInteger(ZebraData.ATTR_HEIGHT).intValue());
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sdk incompatible: ");
        sb2.append(Build.VERSION.SDK_INT);
        embedViewRenderCallback.onError(sb2.toString());
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public View getView() {
        return this.f;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getScrollY() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getScrollY();
        }
        return 0;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        WebView webView = this.b;
        if (webView != null) {
            return webView.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    public WebView getWebView() {
        return this.b;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getVersion() {
        String str;
        Pattern compile;
        if (TextUtils.isEmpty(this.e)) {
            if (Build.VERSION.SDK_INT >= 19) {
                String userAgentString = this.f6489a.getUserAgentString();
                try {
                    compile = H5PatternHelper.compile("Chrome/\\d+\\.\\d+\\.\\d+\\.\\d+");
                } catch (Throwable th) {
                    RVLogger.e("AndroidWebView", "catch exception ", th);
                }
                if (compile != null) {
                    Matcher matcher = compile.matcher(userAgentString);
                    if (matcher.find()) {
                        str = matcher.group(0);
                        this.e = str;
                    }
                }
            }
            str = SemanticAttributes.HttpFlavorValues.HTTP_1_1;
            this.e = str;
        }
        return this.e;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public WebViewType getType() {
        return WebViewType.SYSTEM_BUILD_IN;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public Picture capturePicture() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.capturePicture();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
        this.c = aPWebViewListener;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void addJavascriptInterface(Object obj, String str) {
        WebView webView = this.b;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void removeJavascriptInterface(String str) {
        WebView webView;
        if (Build.VERSION.SDK_INT < 11 || (webView = this.b) == null) {
            return;
        }
        webView.removeJavascriptInterface(str);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebMessagePort[] createWebMessageChannel() {
        WebView webView;
        if (Build.VERSION.SDK_INT < 23 || (webView = this.b) == null) {
            return null;
        }
        WebMessagePort[] createWebMessageChannel = webView.createWebMessageChannel();
        return new APWebMessagePort[]{new AndroidWebMessagePort(createWebMessageChannel[0]), new AndroidWebMessagePort(createWebMessageChannel[1])};
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void postWebMessage(APWebMessage aPWebMessage, Uri uri) {
        if (Build.VERSION.SDK_INT < 23 || this.b == null) {
            return;
        }
        APWebMessagePort[] ports = aPWebMessage.getPorts();
        WebMessagePort[] webMessagePortArr = null;
        if (ports != null) {
            webMessagePortArr = new WebMessagePort[ports.length];
            for (int i = 0; i < ports.length; i++) {
                webMessagePortArr[i] = ((AndroidWebMessagePort) ports[i]).getWebMessagePort();
            }
        }
        this.b.postWebMessage(new WebMessage(aPWebMessage.getData(), webMessagePortArr), uri);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setPreload(boolean z) {
        this.g = z;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean isPreload() {
        return this.g;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setJavaScriptEnabled(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void flingScroll(int i, int i2) {
        WebView webView = this.b;
        if (webView != null) {
            webView.flingScroll(i, i2);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean zoomIn() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.zoomIn();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean zoomOut() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.zoomOut();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHorizontalScrollbarOverlay(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setHorizontalScrollbarOverlay(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setVerticalScrollbarOverlay(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setVerticalScrollbarOverlay(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean overlayHorizontalScrollbar() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.overlayHorizontalScrollbar();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean overlayVerticalScrollbar() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.overlayVerticalScrollbar();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public SslCertificate getCertificate() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getCertificate();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void savePassword(String str, String str2, String str3) {
        WebView webView = this.b;
        if (webView != null) {
            webView.savePassword(str, str2, str3);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getHttpAuthUsernamePassword(str, str2);
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void destroy() {
        WebView webView = this.b;
        if (webView != null) {
            webView.destroy();
            this.b = null;
        }
        this.f = null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setNetworkAvailable(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setNetworkAvailable(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList saveState(Bundle bundle) {
        WebBackForwardList saveState;
        WebView webView = this.b;
        if (webView == null || (saveState = webView.saveState(bundle)) == null) {
            return null;
        }
        return new AndroidWebBackForwardList(saveState);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList restoreState(Bundle bundle) {
        WebBackForwardList restoreState;
        WebView webView = this.b;
        if (webView == null || (restoreState = webView.restoreState(bundle)) == null) {
            return null;
        }
        return new AndroidWebBackForwardList(restoreState);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadUrl(String str, Map<String, String> map) {
        WebView webView = this.b;
        if (webView != null) {
            InstrumentInjector.trackWebView(webView);
            webView.loadUrl(str, map);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadUrl(String str) {
        WebView webView = this.b;
        if (webView != null) {
            InstrumentInjector.trackWebView(webView);
            webView.loadUrl(str);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void postUrl(String str, byte[] bArr) {
        WebView webView = this.b;
        if (webView != null) {
            InstrumentInjector.trackWebView(webView);
            webView.postUrl(str, bArr);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadData(String str, String str2, String str3) {
        WebView webView = this.b;
        if (webView != null) {
            InstrumentInjector.trackWebView(webView);
            webView.loadData(str, str2, str3);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.b != null) {
            if (Build.VERSION.SDK_INT < 29 && Build.VERSION.SDK_INT >= 19) {
                WebView webView = this.b;
                InstrumentInjector.trackWebView(webView);
                webView.loadDataWithBaseURL(str, str2, str3, str4, str5);
                this.b.setVisibility(8);
                ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.webview.AndroidWebView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AndroidWebView.this.b.setVisibility(0);
                    }
                }, 64L);
                return;
            }
            WebView webView2 = this.b;
            InstrumentInjector.trackWebView(webView2);
            webView2.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        WebView webView;
        if (Build.VERSION.SDK_INT >= 19 && (webView = this.b) != null) {
            webView.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("");
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void stopLoading() {
        WebView webView = this.b;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void reload() {
        WebView webView = this.b;
        if (webView != null) {
            webView.reload();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoBack() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.canGoBack();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goBack() {
        WebView webView = this.b;
        if (webView != null) {
            webView.goBack();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoForward() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.canGoForward();
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goForward() {
        WebView webView = this.b;
        if (webView != null) {
            webView.goForward();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoBackOrForward(int i) {
        WebView webView = this.b;
        if (webView != null) {
            return webView.canGoBackOrForward(i);
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goBackOrForward(int i) {
        WebView webView = this.b;
        if (webView != null) {
            webView.goBackOrForward(i);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean pageUp(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            return webView.pageUp(z);
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean pageDown(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            return webView.pageDown(z);
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setInitialScale(int i) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setInitialScale(i);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void invokeZoomPicker() {
        WebView webView = this.b;
        if (webView != null) {
            webView.invokeZoomPicker();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getUrl() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getOriginalUrl() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getOriginalUrl();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getTitle() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getTitle();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public Bitmap getFavicon() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getFavicon();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getProgress() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getProgress();
        }
        return 0;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getContentHeight() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getContentHeight();
        }
        return 0;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getContentWidth() {
        RVLogger.w("AndroidWebView", "getContentWidth() is currently not supported yet");
        return 0;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void onPause() {
        WebView webView;
        if (Build.VERSION.SDK_INT < 11 || (webView = this.b) == null) {
            return;
        }
        webView.onPause();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void onResume() {
        WebView webView;
        if (Build.VERSION.SDK_INT < 11 || (webView = this.b) == null) {
            return;
        }
        webView.onResume();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void freeMemory() {
        WebView webView = this.b;
        if (webView != null) {
            webView.freeMemory();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearCache(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.clearCache(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearFormData() {
        WebView webView = this.b;
        if (webView != null) {
            webView.clearFormData();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearHistory() {
        WebView webView = this.b;
        if (webView != null) {
            webView.clearHistory();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearSslPreferences() {
        WebView webView = this.b;
        if (webView != null) {
            webView.clearSslPreferences();
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList copyBackForwardList() {
        WebBackForwardList copyBackForwardList;
        WebView webView = this.b;
        if (webView == null || (copyBackForwardList = webView.copyBackForwardList()) == null) {
            return null;
        }
        return new AndroidWebBackForwardList(copyBackForwardList);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebViewClient(APWebViewClient aPWebViewClient) {
        WebView webView = this.b;
        if (webView != null) {
            InstrumentInjector.setWebViewClient(webView, new AndroidWebViewClient(this, aPWebViewClient));
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setDownloadListener(APDownloadListener aPDownloadListener) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setDownloadListener(new AndroidDownloadListener(aPDownloadListener));
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setWebChromeClient(new AndroidWebChromeClient(this, aPWebChromeClient));
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebSettings getSettings() {
        return this.f6489a;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APHitTestResult getHitTestResult() {
        WebView.HitTestResult hitTestResult;
        WebView webView = this.b;
        if (webView == null || (hitTestResult = webView.getHitTestResult()) == null) {
            return null;
        }
        return new AndroidHitTestResult(hitTestResult);
    }

    public String getUserAgentString() {
        WebView webView = this.b;
        if (webView != null) {
            return webView.getSettings().getUserAgentString();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public float getScale() {
        return this.h;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setScale(float f) {
        this.h = f;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setVerticalScrollBarEnabled(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setVerticalScrollBarEnabled(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHorizontalScrollBarEnabled(boolean z) {
        WebView webView = this.b;
        if (webView != null) {
            webView.setHorizontalScrollBarEnabled(z);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
        this.d = h5ScrollChangedCallback;
    }

    public void injectJsEarly(String str) {
        if (this.b != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                WebView webView = this.b;
                StringBuilder sb = new StringBuilder();
                sb.append(RDConstant.JAVASCRIPT_SCHEME);
                sb.append(str);
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.alibaba.griver.core.webview.AndroidWebView.4
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        GriverLogger.d("", str2);
                    }
                });
            } else {
                WebView webView2 = this.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RDConstant.JAVASCRIPT_SCHEME);
                sb2.append(str);
                String obj = sb2.toString();
                InstrumentInjector.trackWebView(webView2);
                webView2.loadUrl(obj);
            }
            RVLogger.d("AndroidWebView", "bridge data loaded!");
        }
    }

    /* loaded from: classes6.dex */
    final class WebViewEx extends WebView {
        public WebViewEx(Context context) {
            super(context);
            setTag("H5WebView");
        }

        @Override // android.view.View
        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (i2 < 0 && i4 == 0 && AndroidWebView.this.c != null) {
                return AndroidWebView.this.c.overScrollBy(i, i2, i3, i4);
            }
            return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (AndroidWebView.this.c != null) {
                AndroidWebView.this.c.onDetachedFromWindow();
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected final void onScrollChanged(int i, int i2, int i3, int i4) {
            if (AndroidWebView.this.f != null) {
                AndroidWebView.this.f.onWebViewScrollChanged(i, i2, i3, i4);
            }
            if (AndroidWebView.this.d != null) {
                AndroidWebView.this.d.onScroll(i - i3, i2 - i4);
            } else {
                super.onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        public final boolean requestFocus(int i, Rect rect) {
            StringBuilder sb = new StringBuilder();
            sb.append("requestFocus: ");
            sb.append(i);
            GriverLogger.d("AndroidWebView", sb.toString());
            return super.requestFocus(130, rect);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchWindowFocusChanged(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("dispatchWindowFocusChanged: ");
            sb.append(z);
            GriverLogger.d("AndroidWebView", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("has focus: ");
            sb2.append(hasFocus());
            GriverLogger.d("AndroidWebView", sb2.toString());
            if (Build.VERSION.SDK_INT >= 28 && z && !hasFocus()) {
                requestFocus();
            }
            super.dispatchWindowFocusChanged(z);
        }
    }

    /* loaded from: classes6.dex */
    static class AndroidHitTestResult implements APHitTestResult {
        WebView.HitTestResult droidHitTestResult;

        AndroidHitTestResult(WebView.HitTestResult hitTestResult) {
            this.droidHitTestResult = hitTestResult;
        }

        @Override // com.alibaba.griver.base.api.APHitTestResult
        public String getExtra() {
            return this.droidHitTestResult.getExtra();
        }

        @Override // com.alibaba.griver.base.api.APHitTestResult
        public int getType() {
            return this.droidHitTestResult.getType();
        }
    }
}
