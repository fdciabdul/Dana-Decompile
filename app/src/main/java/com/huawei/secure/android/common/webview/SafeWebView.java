package com.huawei.secure.android.common.webview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes8.dex */
public class SafeWebView extends WebView {
    private String[] BuiltInFictitiousFunctionClassFactory;
    private String[] KClassImpl$Data$declaredNonStaticMembers$2;
    private String[] MyBillsEntityDataFactory;
    private String PlaceComponentResult;
    private WebViewLoadCallBack getAuthRequestContext;

    /* loaded from: classes8.dex */
    static class b implements DialogInterface.OnClickListener {
        private final SslErrorHandler PlaceComponentResult;

        b(SslErrorHandler sslErrorHandler) {
            this.PlaceComponentResult = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.PlaceComponentResult.cancel();
        }
    }

    /* loaded from: classes8.dex */
    static class c implements DialogInterface.OnClickListener {
        private final SslErrorHandler BuiltInFictitiousFunctionClassFactory;

        c(SslErrorHandler sslErrorHandler) {
            this.BuiltInFictitiousFunctionClassFactory = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.BuiltInFictitiousFunctionClassFactory.proceed();
        }
    }

    /* loaded from: classes8.dex */
    final class d extends WebViewClient {
        private boolean BuiltInFictitiousFunctionClassFactory;
        private WebViewClient getAuthRequestContext;

        /* synthetic */ d(SafeWebView safeWebView, WebViewClient webViewClient, boolean z, byte b) {
            this(webViewClient, z);
        }

        @Override // android.webkit.WebViewClient
        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null && !this.BuiltInFictitiousFunctionClassFactory) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (!SafeWebView.this.isWhiteListUrl(str)) {
                SafeWebView.this.onCheckError(webView, str);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // android.webkit.WebViewClient
        public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onScaleChanged(WebView webView, float f, float f2) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        private d(WebViewClient webViewClient, boolean z) {
            this.getAuthRequestContext = webViewClient;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.getAuthRequestContext;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    public SafeWebView(Context context) {
        super(context);
        SafeWebSettings.KClassImpl$Data$declaredNonStaticMembers$2(this);
        InstrumentInjector.setWebViewClient(this, null);
    }

    public String getDefaultErrorPage() {
        return this.PlaceComponentResult;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.getAuthRequestContext;
    }

    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistWithPath() {
        String[] strArr = this.MyBillsEntityDataFactory;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public boolean isWhiteListUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.MyBillsEntityDataFactory("SafeWebView", HummerZCodeConstant.URL_ERROR_MSG);
            return false;
        } else if (URLUtil.isNetworkUrl(str)) {
            String[] whitelistWithPath = getWhitelistWithPath();
            String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
            String[] whitelist = getWhitelist();
            if (whitelistWithPath != null && whitelistWithPath.length != 0) {
                return UriUtil.PlaceComponentResult(str, whitelistWithPath);
            }
            if (whitelistNotMatchSubDomain != null && whitelistNotMatchSubDomain.length != 0) {
                return UriUtil.getAuthRequestContext(str, whitelistNotMatchSubDomain);
            }
            return UriUtil.BuiltInFictitiousFunctionClassFactory(str, whitelist);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (URLUtil.isHttpUrl(str)) {
            InstrumentInjector.log_e("SafeWebView", "loadDataWithBaseURL: http url , not safe");
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                String str6 = this.PlaceComponentResult;
                InstrumentInjector.trackWebView(this);
                super.loadDataWithBaseURL(str6, str2, str3, str4, str5);
                return;
            } else if (getWebViewLoadCallBack() != null) {
                InstrumentInjector.log_e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack();
                WebViewLoadCallBack.ErrorCode errorCode = WebViewLoadCallBack.ErrorCode.HTTP_URL;
                return;
            } else {
                return;
            }
        }
        InstrumentInjector.trackWebView(this);
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (URLUtil.isHttpUrl(str)) {
            InstrumentInjector.log_e("SafeWebView", "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                String str2 = this.PlaceComponentResult;
                InstrumentInjector.trackWebView(this);
                super.loadUrl(str2);
                return;
            } else if (getWebViewLoadCallBack() != null) {
                InstrumentInjector.log_e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack();
                WebViewLoadCallBack.ErrorCode errorCode = WebViewLoadCallBack.ErrorCode.HTTP_URL;
                return;
            } else {
                return;
            }
        }
        InstrumentInjector.trackWebView(this);
        super.loadUrl(str);
    }

    public final void onCheckError(WebView webView, String str) {
        LogsUtil.KClassImpl$Data$declaredNonStaticMembers$2("SafeWebView", "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            InstrumentInjector.trackWebView(webView);
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            InstrumentInjector.log_e("SafeWebView", "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack();
            WebViewLoadCallBack.ErrorCode errorCode = WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST;
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (URLUtil.isHttpUrl(str)) {
            InstrumentInjector.log_e("SafeWebView", "postUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                String str2 = this.PlaceComponentResult;
                InstrumentInjector.trackWebView(this);
                super.postUrl(str2, bArr);
                return;
            } else if (getWebViewLoadCallBack() != null) {
                InstrumentInjector.log_e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack();
                WebViewLoadCallBack.ErrorCode errorCode = WebViewLoadCallBack.ErrorCode.HTTP_URL;
                return;
            } else {
                return;
            }
        }
        InstrumentInjector.trackWebView(this);
        super.postUrl(str, bArr);
    }

    public void setDefaultErrorPage(String str) {
        this.PlaceComponentResult = str;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new d(this, webViewClient, true, (byte) 0));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.getAuthRequestContext = webViewLoadCallBack;
    }

    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.BuiltInFictitiousFunctionClassFactory = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistWithPath(String[] strArr) {
        this.MyBillsEntityDataFactory = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    protected final void showNoticeWhenSSLErrorOccurred(String str, String str2, String str3, String str4, SslErrorHandler sslErrorHandler) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        c cVar = new c(sslErrorHandler);
        b bVar = new b(sslErrorHandler);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, cVar);
        builder.setNegativeButton(str4, bVar);
        builder.create().show();
    }

    public void setWebViewClient(WebViewClient webViewClient, boolean z) {
        super.setWebViewClient(new d(this, webViewClient, z, (byte) 0));
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SafeWebSettings.KClassImpl$Data$declaredNonStaticMembers$2(this);
        InstrumentInjector.setWebViewClient(this, null);
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SafeWebSettings.KClassImpl$Data$declaredNonStaticMembers$2(this);
        InstrumentInjector.setWebViewClient(this, null);
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        SafeWebSettings.KClassImpl$Data$declaredNonStaticMembers$2(this);
        InstrumentInjector.setWebViewClient(this, null);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (URLUtil.isHttpUrl(str)) {
            InstrumentInjector.log_e("SafeWebView", "loadUrl: http url , not safe");
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                String str2 = this.PlaceComponentResult;
                InstrumentInjector.trackWebView(this);
                super.loadUrl(str2, map);
                return;
            } else if (getWebViewLoadCallBack() != null) {
                InstrumentInjector.log_e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack();
                WebViewLoadCallBack.ErrorCode errorCode = WebViewLoadCallBack.ErrorCode.HTTP_URL;
                return;
            } else {
                return;
            }
        }
        InstrumentInjector.trackWebView(this);
        super.loadUrl(str, map);
    }
}
