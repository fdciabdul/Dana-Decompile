package com.alibaba.griver.core.render;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;
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
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.webview.ReleaseWebViewPoint;
import com.alibaba.griver.base.api.APDownloadListener;
import com.alibaba.griver.base.api.APHitTestResult;
import com.alibaba.griver.base.api.APWebBackForwardList;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebMessagePort;
import com.alibaba.griver.base.api.APWebSettings;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.api.APWebViewListener;
import com.alibaba.griver.base.api.APWebViewPerformance;
import com.alibaba.griver.base.api.H5EmbededViewProvider;
import com.alibaba.griver.base.api.H5ScrollChangedCallback;
import com.alibaba.griver.base.api.IH5EmbedViewJSCallback;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.nebula.APWebMessage;
import com.alibaba.griver.base.nebula.WebViewType;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.ui.GriverPage;
import com.alibaba.griver.core.utils.WebViewUtils;
import com.alibaba.griver.core.webview.extension.GriverWebViewSettingsExtension;
import com.google.common.base.Ascii;
import id.dana.data.here.HereOauthManager;
import java.util.Map;

/* loaded from: classes2.dex */
public class H5WebView implements APWebView, APWebViewPerformance {
    public static String TAG = "H5WebView";

    /* renamed from: a  reason: collision with root package name */
    private static int f6452a;
    protected APWebView apWebView;
    private Bundle b;
    private int c;
    private float d;
    private String e;
    private boolean f;
    private String g;
    private GriverPage h;
    private Bundle i;
    private long j;
    private String k;
    public static final byte[] PlaceComponentResult = {86, TarHeader.LF_NORMAL, -68, 79, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 107;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l(short r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 6
            int r8 = 103 - r8
            int r7 = r7 * 5
            int r7 = r7 + 18
            int r9 = r9 * 22
            int r9 = 25 - r9
            byte[] r0 = com.alibaba.griver.core.render.H5WebView.PlaceComponentResult
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r9 = r9 + r7
            int r7 = r9 + (-8)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.render.H5WebView.l(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setAPWebViewListener(APWebViewListener aPWebViewListener) {
    }

    public H5WebView() {
        this.c = 0;
        this.d = 1.0f;
        this.f = false;
        this.j = -1L;
        this.k = null;
    }

    public H5WebView(Activity activity, GriverPage griverPage, Bundle bundle) {
        this(activity, griverPage, bundle, null, null);
    }

    public H5WebView(Activity activity, GriverPage griverPage, Bundle bundle, APWebView aPWebView, APWebViewListener aPWebViewListener) {
        this.c = 0;
        this.d = 1.0f;
        this.f = false;
        this.j = -1L;
        this.k = null;
        init(activity, griverPage, bundle, aPWebView, aPWebViewListener);
    }

    public void init(Activity activity, GriverPage griverPage, Bundle bundle, APWebView aPWebView, APWebViewListener aPWebViewListener) {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(hashCode());
        TAG = sb.toString();
        this.b = bundle;
        this.h = griverPage;
        Bundle startParams = griverPage.getStartParams();
        this.i = startParams;
        if (BundleUtils.getBoolean(startParams, GriverParam.LONG_ISPRERENDER, false)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(TAG);
            sb2.append("_preRender");
            TAG = sb2.toString();
        }
        String string = BundleUtils.getString(bundle, "bizType");
        this.g = BundleUtils.getString(griverPage.getStartParams(), "appId");
        String str = TAG;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createWebView bizType ");
        sb3.append(string);
        RVLogger.d(str, sb3.toString());
        this.apWebView = aPWebView;
        if (aPWebView == null) {
            RVLogger.e(TAG, "apWebView == null return");
            return;
        }
        if (aPWebViewListener != null) {
            aPWebView.setAPWebViewListener(aPWebViewListener);
        }
        boolean z = BundleUtils.getBoolean(griverPage.getStartParams(), RVParams.LONG_ENABLE_SCROLLBAR, true);
        String str2 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("enableScrollBar:");
        sb4.append(z);
        RVLogger.d(str2, sb4.toString());
        if (!z) {
            this.apWebView.setHorizontalScrollBarEnabled(z);
            this.apWebView.setVerticalScrollBarEnabled(z);
        }
        int i = f6452a;
        f6452a = i + 1;
        this.c = i;
    }

    public static String getApplicationDir() {
        Application applicationContext = GriverEnv.getApplicationContext();
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 5);
            byte b2 = b;
            Object[] objArr = new Object[1];
            l(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = PlaceComponentResult[41];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            l(b3, b4, b4, objArr2);
            if (!TextUtils.isEmpty(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(applicationContext, null)).dataDir)) {
                try {
                    byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 5);
                    byte b6 = b5;
                    Object[] objArr3 = new Object[1];
                    l(b5, b6, b6, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b7 = PlaceComponentResult[41];
                    byte b8 = b7;
                    Object[] objArr4 = new Object[1];
                    l(b7, b8, b8, objArr4);
                    return ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(applicationContext, null)).dataDir;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            try {
                return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).applicationInfo.dataDir;
            } catch (Throwable th2) {
                RVLogger.e(TAG, "exception detail", th2);
                return null;
            }
        } catch (Throwable th3) {
            Throwable cause2 = th3.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th3;
        }
    }

    public int getWebViewIndex() {
        return this.c;
    }

    public void init(boolean z) {
        RVLogger.d(TAG, "initWebView");
        b();
        a();
        a(z);
        if (this.apWebView == null) {
            RVLogger.e(TAG, "FATAL ERROR, the internal glue apWebView is null!");
        }
        setWebContentsDebuggingEnabled(GriverEnv.isDebuggable());
    }

    private void a() {
        GriverPage griverPage = this.h;
        if (griverPage == null) {
            return;
        }
        TextUtils.isEmpty(BundleUtils.getString(griverPage.getStartParams(), "url"));
    }

    private void a(boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("applyCustomSettings allowAccessFromFileURL ");
        sb.append(z);
        RVLogger.d(str, sb.toString());
        final APWebSettings settings = getSettings();
        settings.setEnableFastScroller(false);
        settings.setPageCacheCapacity(0);
        settings.setDefaultTextEncodingName(HereOauthManager.ENC);
        settings.setSupportMultipleWindows(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            RVLogger.d(TAG, "Ignore the exception in AccessibilityInjector when init");
            RVLogger.e(TAG, "exception detail", e);
        }
        settings.setDefaultFontSize(16);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setPluginState(APWebSettings.PluginState.ON);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(z);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getApplicationDir());
        sb2.append("/app_h5container");
        String obj = sb2.toString();
        H5FileUtil.mkdirs(obj);
        settings.setDatabaseEnabled("yes".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_ENABLE_WEBVIEW_DATABASE, "NO")));
        if (Build.VERSION.SDK_INT < 19) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append("/databases");
            H5FileUtil.mkdirs(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj);
            sb4.append("/databases");
            settings.setDatabasePath(sb4.toString());
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj);
        sb5.append("/appcache");
        H5FileUtil.mkdirs(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(obj);
        sb6.append("/appcache");
        settings.setAppCachePath(sb6.toString());
        settings.setAppCacheEnabled(true);
        settings.getUserAgentString();
        settings.setCacheMode(-1);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setGeolocationEnabled(true);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(obj);
        sb7.append("/geolocation");
        H5FileUtil.mkdirs(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(obj);
        sb8.append("/geolocation");
        settings.setGeolocationDatabasePath(sb8.toString());
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 11) {
            settings.setDisplayZoomControls(false);
        }
        settings.setAllowFileAccessFromFileURLs(z);
        settings.setAllowUniversalAccessFromFileURLs(z);
        settings.setTextSize(APWebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        if ("no".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_CUSTOM_WEB_SETTINGS, "YES"))) {
            return;
        }
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.render.H5WebView.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((GriverWebViewSettingsExtension) RVProxy.get(GriverWebViewSettingsExtension.class)).customizeWebViewSettings(settings);
                } catch (Exception e2) {
                    GriverLogger.e(H5WebView.TAG, "customize web settings failed", e2);
                }
            }
        });
    }

    private void b() {
        String str;
        APWebSettings settings = getSettings();
        try {
            String userAgentString = settings.getUserAgentString();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("origin ua ");
            sb.append(userAgentString);
            RVLogger.d(str2, sb.toString());
            if (userAgentString.contains("UCBS") || !userAgentString.contains("UWS")) {
                str = userAgentString;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(userAgentString);
                sb2.append(" UCBS/");
                sb2.append(getVersion());
                str = sb2.toString();
            }
            this.e = str;
            a(settings, str, userAgentString);
            String str3 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("set final ua ");
            sb3.append(this.e);
            RVLogger.d(str3, sb3.toString());
        } catch (Exception e) {
            RVLogger.e(TAG, "setUserAgent exception", e);
        }
    }

    private void a(APWebSettings aPWebSettings, String str, String str2) {
        aPWebSettings.setUserAgentString(str);
    }

    public void setTextSize(int i) {
        APWebSettings settings = getSettings();
        if (Build.VERSION.SDK_INT >= 14) {
            settings.setTextZoom(i);
        } else {
            settings.setTextSize(getTextSize(i));
        }
    }

    public APWebSettings.TextSize getTextSize(int i) {
        if (i >= 200) {
            return APWebSettings.TextSize.LARGEST;
        }
        if (i >= 150) {
            return APWebSettings.TextSize.LARGER;
        }
        if (i >= 100) {
            return APWebSettings.TextSize.NORMAL;
        }
        if (i >= 75) {
            return APWebSettings.TextSize.SMALLER;
        }
        return APWebSettings.TextSize.NORMAL;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadUrl(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript")) {
            this.j = System.currentTimeMillis();
            this.k = str;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.H5WebView.2
            @Override // java.lang.Runnable
            public void run() {
                H5WebView.this.a(str, null);
            }
        });
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void execJavaScript4EmbedView(final String str, final IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.H5WebView.3
            @Override // java.lang.Runnable
            public void run() {
                H5WebView.this.a(str, iH5EmbedViewJSCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final IH5EmbedViewJSCallback iH5EmbedViewJSCallback) {
        try {
            if (str.startsWith("javascript")) {
                boolean z = false;
                boolean z2 = Build.VERSION.SDK_INT >= 19;
                String str2 = this.e;
                if (str2 != null && (str2.contains("UCBS") || this.e.contains("UWS") || this.e.contains("U3"))) {
                    z = true;
                }
                if (z) {
                    if (iH5EmbedViewJSCallback == null) {
                        evaluateJavascript(str, null);
                        return;
                    } else {
                        evaluateJavascript(str, new ValueCallback<String>() { // from class: com.alibaba.griver.core.render.H5WebView.4
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(String str3) {
                                iH5EmbedViewJSCallback.onReceiveValue(str3);
                            }
                        });
                        return;
                    }
                } else if (!z2) {
                    this.apWebView.loadUrl(str);
                    return;
                } else if (iH5EmbedViewJSCallback == null) {
                    evaluateJavascript(str, null);
                    return;
                } else {
                    evaluateJavascript(str, new ValueCallback<String>() { // from class: com.alibaba.griver.core.render.H5WebView.5
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str3) {
                            iH5EmbedViewJSCallback.onReceiveValue(str3);
                        }
                    });
                    return;
                }
            }
            this.apWebView.loadUrl(str);
        } catch (Throwable th) {
            RVLogger.e(TAG, "loadUrl exception.", th);
            try {
                this.apWebView.loadUrl(str);
            } catch (Throwable th2) {
                RVLogger.e(TAG, "loadUrl exception.", th2);
            }
        }
    }

    public final Bundle getWebViewConfig() {
        return this.b;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void addJavascriptInterface(Object obj, String str) {
        this.apWebView.addJavascriptInterface(obj, str);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebContentsDebuggingEnabled(boolean z) {
        this.apWebView.setWebContentsDebuggingEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void flingScroll(int i, int i2) {
        this.apWebView.flingScroll(i, i2);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean zoomIn() {
        return this.apWebView.zoomIn();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean zoomOut() {
        return this.apWebView.zoomOut();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHorizontalScrollbarOverlay(boolean z) {
        this.apWebView.setHorizontalScrollbarOverlay(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setVerticalScrollbarOverlay(boolean z) {
        this.apWebView.setVerticalScrollbarOverlay(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean overlayHorizontalScrollbar() {
        return this.apWebView.overlayHorizontalScrollbar();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean overlayVerticalScrollbar() {
        return this.apWebView.overlayVerticalScrollbar();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public SslCertificate getCertificate() {
        return this.apWebView.getCertificate();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void savePassword(String str, String str2, String str3) {
        this.apWebView.savePassword(str, str2, str3);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.apWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.apWebView.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void destroy() {
        this.apWebView.destroy();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setNetworkAvailable(boolean z) {
        this.apWebView.setNetworkAvailable(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList saveState(Bundle bundle) {
        return this.apWebView.saveState(bundle);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList restoreState(Bundle bundle) {
        return this.apWebView.restoreState(bundle);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadUrl(String str, Map<String, String> map) {
        this.j = System.currentTimeMillis();
        this.k = str;
        this.apWebView.loadUrl(str, map);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void postUrl(String str, byte[] bArr) {
        this.apWebView.postUrl(str, bArr);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadData(String str, String str2, String str3) {
        this.apWebView.loadData(str, str2, str3);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.apWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.apWebView.evaluateJavascript(str, valueCallback);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void stopLoading() {
        this.apWebView.stopLoading();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void reload() {
        this.apWebView.reload();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoBack() {
        return this.apWebView.canGoBack();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goBack() {
        this.apWebView.goBack();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoForward() {
        return this.apWebView.canGoForward();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goForward() {
        this.apWebView.goForward();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean canGoBackOrForward(int i) {
        return this.apWebView.canGoForward();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void goBackOrForward(int i) {
        this.apWebView.goBackOrForward(i);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean pageUp(boolean z) {
        return this.apWebView.pageUp(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean pageDown(boolean z) {
        return this.apWebView.pageDown(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setInitialScale(int i) {
        this.apWebView.setInitialScale(i);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void invokeZoomPicker() {
        this.apWebView.invokeZoomPicker();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getUrl() {
        return this.apWebView.getUrl();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getOriginalUrl() {
        return this.apWebView.getOriginalUrl();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getTitle() {
        return this.apWebView.getTitle();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public Bitmap getFavicon() {
        return this.apWebView.getFavicon();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getProgress() {
        return this.apWebView.getProgress();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getContentHeight() {
        return this.apWebView.getContentHeight();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getContentWidth() {
        return this.apWebView.getContentWidth();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebMessagePort[] createWebMessageChannel() {
        return this.apWebView.createWebMessageChannel();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void postWebMessage(APWebMessage aPWebMessage, Uri uri) {
        this.apWebView.postWebMessage(aPWebMessage, uri);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setPreload(boolean z) {
        this.apWebView.setPreload(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean isPreload() {
        return this.apWebView.isPreload();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setJavaScriptEnabled(boolean z) {
        this.apWebView.setJavaScriptEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void onPause() {
        this.apWebView.onPause();
        RVLogger.d(TAG, "H5WebView onWebViewPause");
        GriverPage griverPage = this.h;
        if (griverPage != null) {
            if (griverPage.ifContainsEmbedView()) {
                H5EmbededViewProvider embededViewProvider = this.h.getEmbededViewProvider();
                if (embededViewProvider != null) {
                    embededViewProvider.onWebViewPause();
                }
            } else if (this.h.getEmbedPage() != null) {
                this.h.getEmbedPage().pause();
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void onResume() {
        this.apWebView.onResume();
        RVLogger.d(TAG, "H5WebView onWebViewResume");
        GriverPage griverPage = this.h;
        if (griverPage != null && griverPage.getEmbedPage() != null) {
            this.h.getEmbedPage().resume();
        }
        GriverPage griverPage2 = this.h;
        if (griverPage2 != null) {
            if (griverPage2.ifContainsEmbedView()) {
                H5EmbededViewProvider embededViewProvider = this.h.getEmbededViewProvider();
                if (embededViewProvider != null) {
                    embededViewProvider.onWebViewResume();
                }
            } else if (this.h.getEmbedPage() != null) {
                this.h.getEmbedPage().resume();
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean isPaused() {
        return this.apWebView.isPaused();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void freeMemory() {
        this.apWebView.freeMemory();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearCache(boolean z) {
        this.apWebView.clearCache(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearFormData() {
        this.apWebView.clearFormData();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearHistory() {
        this.apWebView.clearHistory();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void clearSslPreferences() {
        this.apWebView.clearSslPreferences();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebBackForwardList copyBackForwardList() {
        return this.apWebView.copyBackForwardList();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setDownloadListener(APDownloadListener aPDownloadListener) {
        this.apWebView.setDownloadListener(aPDownloadListener);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebViewClient(APWebViewClient aPWebViewClient) {
        this.apWebView.setWebViewClient(aPWebViewClient);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setWebChromeClient(APWebChromeClient aPWebChromeClient) {
        this.apWebView.setWebChromeClient(aPWebChromeClient);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void removeJavascriptInterface(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("removeJavascriptInterface ");
        sb.append(str);
        RVLogger.d(str2, sb.toString());
        if (Build.VERSION.SDK_INT >= 11) {
            this.apWebView.removeJavascriptInterface(str);
        }
    }

    protected void onAttachedToWindow() {
        RVLogger.d(TAG, "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        RVLogger.d(TAG, "onDetachedFromWindow");
    }

    public void onRelease() {
        if (this.f) {
            return;
        }
        this.f = true;
        RVLogger.d(TAG, "releaseWebView!");
        ((ReleaseWebViewPoint) ExtensionPoint.as(ReleaseWebViewPoint.class).node(this.h).create()).releaseWebView();
        final int i = 1000;
        if (ProcessUtils.isMainProcess() && ((WebViewUtils.useSW(this.i) || BundleUtils.getBoolean(this.i, RVParams.isTinyApp, false)) && !"no".equalsIgnoreCase(GriverConfig.getConfigWithProcessCache("h5_webview_release", "")))) {
            i = 500;
            RVLogger.d(TAG, "useSw use 500");
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.H5WebView.6
            @Override // java.lang.Runnable
            public void run() {
                H5WebView.this.a(i);
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        H5EmbededViewProvider embededViewProvider;
        try {
            RVLogger.d(TAG, "loadBlankPage");
            RVLogger.d(TAG, "H5WebView onWebViewDestory");
            GriverPage griverPage = this.h;
            if (griverPage != null && griverPage.ifContainsEmbedView() && (embededViewProvider = this.h.getEmbededViewProvider()) != null) {
                embededViewProvider.onWebViewDestory();
            }
            if ("yes".equalsIgnoreCase(GriverConfig.getConfig("h5_unableLoadBlankPage", ""))) {
                if (this.apWebView != null && WebViewType.SYSTEM_BUILD_IN == this.apWebView.getType()) {
                    RVLogger.d(TAG, "loadBlankPage in System WebView");
                    loadUrl(GriverParam.ABOUT_BLANK);
                } else {
                    RVLogger.d(TAG, "do not loadBlankPage in UCWebView");
                }
            } else {
                RVLogger.d(TAG, "loadBlankPage in UC/System WebView");
                loadUrl(GriverParam.ABOUT_BLANK);
            }
        } catch (Throwable th) {
            RVLogger.e(TAG, "loadBlankPage exception.", th);
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.H5WebView.7
            @Override // java.lang.Runnable
            public void run() {
                H5WebView.this.c();
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        H5EmbededViewProvider embededViewProvider;
        try {
            RVLogger.d(TAG, "releaseWebView");
            GriverPage griverPage = this.h;
            if (griverPage != null && griverPage.ifContainsEmbedView() && (embededViewProvider = this.h.getEmbededViewProvider()) != null) {
                embededViewProvider.releaseView();
            }
            this.h = null;
            View view = this.apWebView.getView();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            view.setVisibility(8);
            view.clearFocus();
            view.clearAnimation();
            setDownloadListener(null);
            setWebViewClient(null);
            setWebChromeClient(null);
            stopLoading();
            clearHistory();
            clearSslPreferences();
            view.destroyDrawingCache();
            freeMemory();
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APWebSettings getSettings() {
        return this.apWebView.getSettings();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public APHitTestResult getHitTestResult() {
        return this.apWebView.getHitTestResult();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public Picture capturePicture() {
        return this.apWebView.capturePicture();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public View getView() {
        return this.apWebView.getView();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public WebViewType getType() {
        return this.apWebView.getType();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public String getVersion() {
        APWebView aPWebView = this.apWebView;
        return aPWebView == null ? "(Null webview)" : aPWebView.getVersion();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public float getScale() {
        return this.d;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setScale(float f) {
        this.d = f;
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setVerticalScrollBarEnabled(boolean z) {
        this.apWebView.setVerticalScrollBarEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.apWebView.setHorizontalScrollBarEnabled(z);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public void setOnScrollChangedCallback(H5ScrollChangedCallback h5ScrollChangedCallback) {
        this.apWebView.setOnScrollChangedCallback(h5ScrollChangedCallback);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public int getScrollY() {
        return this.apWebView.getScrollY();
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.apWebView.dispatchKeyEvent(keyEvent);
    }

    @Override // com.alibaba.griver.base.api.APWebView
    public boolean getCurrentPageSnapshot(Rect rect, Rect rect2, Bitmap bitmap, boolean z, int i) {
        return this.apWebView.getCurrentPageSnapshot(rect, rect2, bitmap, z, i);
    }

    public Page getH5Page() {
        return this.h;
    }

    public APWebView getInternalContentView() {
        return this.apWebView;
    }

    @Override // com.alibaba.griver.base.api.APWebViewPerformance
    public void getStartupPerformanceStatistics(ValueCallback<String> valueCallback) {
        APWebView aPWebView = this.apWebView;
        if (aPWebView == null || !(aPWebView instanceof APWebViewPerformance)) {
            return;
        }
        ((APWebViewPerformance) aPWebView).getStartupPerformanceStatistics(valueCallback);
    }
}
