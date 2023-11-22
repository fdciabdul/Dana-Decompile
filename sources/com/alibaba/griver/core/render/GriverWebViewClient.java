package com.alibaba.griver.core.render;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.page.PageStartedPoint;
import com.alibaba.ariver.app.api.point.page.ShouldLoadUrlResultPoint;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.api.RVFlag;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.bridge.GriverReceivedSslErrorEvent;
import com.alibaba.griver.api.cache.H5WebViewCacheExtension;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.api.stauts.PageStatus;
import com.alibaba.griver.api.webview.GriverWebViewReceivedErrorExtension;
import com.alibaba.griver.api.webview.H5ErrorCode;
import com.alibaba.griver.api.webview.PageAbnormalPoint;
import com.alibaba.griver.api.webview.PageErrorPoint;
import com.alibaba.griver.api.webview.PageFinishedPoint;
import com.alibaba.griver.base.api.APHttpAuthHandler;
import com.alibaba.griver.base.api.APSslErrorHandler;
import com.alibaba.griver.base.api.APWebResourceRequest;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.APWebViewClient;
import com.alibaba.griver.base.api.ShouldLoadUrlPoint;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorManager;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.nebula.H5Utils;
import com.alibaba.griver.base.stagemonitor.GriverPVConfig;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverPVMonitor;
import com.alibaba.griver.core.utils.GriverDialogUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.sendmoney.contact.provider.ContactProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverWebViewClient extends WebViewClient implements APWebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private Page f6449a;
    private long b;
    private String c;
    private String e;
    private boolean f = false;
    private boolean g = false;
    private Map<String, ResourceInfo> d = new HashMap();

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void doUpdateVisitedHistory(APWebView aPWebView, String str, boolean z) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public String getJSBridge() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public String getPageUrl() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public Map getRequestMap() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onFirstVisuallyRender(APWebView aPWebView) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onFormResubmission(APWebView aPWebView, Message message, Message message2) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onLoadResource(APWebView aPWebView, String str) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedHttpAuthRequest(APWebView aPWebView, APHttpAuthHandler aPHttpAuthHandler, String str, String str2) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedLoginRequest(APWebView aPWebView, String str, String str2, String str3) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedResponseHeader(Map<String, List<String>> map) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onResourceFinishLoad(APWebView aPWebView, String str, long j) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onScaleChanged(APWebView aPWebView, float f, float f2) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onTooManyRedirects(APWebView aPWebView, Message message, Message message2) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onUnhandledKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldInterceptResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideKeyEvent(APWebView aPWebView, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideUrlLoadingForUC(APWebView aPWebView, String str, int i) {
        return false;
    }

    public GriverWebViewClient(Page page) {
        this.f6449a = page;
        this.e = getVhost(page);
    }

    private boolean a(String str) {
        boolean shouldLoad = ((ShouldLoadUrlPoint) ExtensionPoint.as(ShouldLoadUrlPoint.class).node(this.f6449a).defaultValue(Boolean.TRUE).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.render.GriverWebViewClient.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        Boolean bool = list.get(i);
                        if (bool != null && !bool.booleanValue()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("shouldLoad false in index ");
                            sb.append(i);
                            sb.append(" !!!");
                            RVLogger.w("GriverWebViewClient", sb.toString());
                            return Boolean.FALSE;
                        }
                    }
                }
                return Boolean.TRUE;
            }
        }).create()).shouldLoad(null, str);
        ((ShouldLoadUrlResultPoint) ExtensionPoint.as(ShouldLoadUrlResultPoint.class).node(this.f6449a).create()).shouldOverrideUrlLoading(str, shouldLoad);
        return shouldLoad;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        Render render = this.f6449a.getRender();
        if (render instanceof GriverWebRenderImpl) {
            ((GriverWebRenderImpl) render).updatePageStatus(PageStatus.LOADING);
        }
        ((PageStartedPoint) ExtensionPoint.as(PageStartedPoint.class).node(this.f6449a).create()).onStarted(str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String mergeVHost = VHostUrlInterceptor.mergeVHost(webResourceRequest.getUrl().toString(), getVhost(this.f6449a));
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.f6449a).create()).load(ResourceLoadContext.newBuilder().originUrl(mergeVHost).build());
        if (load != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("shouldInterceptRequest got resource: ");
            sb.append(load);
            RVLogger.d("GriverWebViewClient", sb.toString());
            WebResourceResponse webResourceResponse = new WebResourceResponse(load.getMimeType(), load.getEncoding(), load.getStream());
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, UrlUtils.getCORSUrl(this.f6449a.getPageURI()));
                webResourceResponse.setResponseHeaders(hashMap);
            }
            return webResourceResponse;
        }
        if (b(mergeVHost)) {
            MonitorMap.Builder builder = new MonitorMap.Builder();
            builder.appId(this.f6449a.getApp().getAppId()).version(this.f6449a.getApp()).needAsynAppType(true).pageUrl(this.f6449a.getPageURI()).requestUrl(mergeVHost).append("errorType", GriverMonitorConstants.PAGE_ABNORMAL_WHITESCREEN).code("1").message(GriverMonitorConstants.MESSAGE_OFFLINE_RESOURCE_LOST);
            GriverMonitor.error(GriverMonitorConstants.ERROR_PAGE_ABNORMAL, "GriverAppContainer", builder.build());
        }
        ResourceInfo resourceInfo = new ResourceInfo(System.currentTimeMillis(), webResourceRequest.getMethod());
        boolean equals = TextUtils.equals(this.f6449a.getOriginalURI(), webResourceRequest.getUrl().toString());
        if (webResourceRequest.getUrl() != null && equals) {
            this.d.clear();
            resourceInfo.mIsMainDoc = true;
        }
        resourceInfo.mUrl = webResourceRequest.getUrl().toString();
        this.d.put(webResourceRequest.getUrl().toString(), resourceInfo);
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    private boolean b(String str) {
        if (TextUtils.equals(str, AppxResourcePackage.APPX_RENDER_JS_URL)) {
            return true;
        }
        AppModel appModel = (AppModel) this.f6449a.getApp().getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(appModel.getAppInfoModel().getVhost());
        sb.append("/index.html");
        if (!TextUtils.equals(str, sb.toString())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(appModel.getAppInfoModel().getVhost());
            sb2.append("/index.js");
            if (!TextUtils.equals(str, sb2.toString())) {
                return false;
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a));
        super.onPageFinished(webView, mergeVHost);
        StringBuilder sb = new StringBuilder();
        sb.append("page finished: ");
        sb.append(mergeVHost);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        Render render = this.f6449a.getRender();
        if (render instanceof GriverWebRenderImpl) {
            ((GriverWebRenderImpl) render).updatePageStatus(PageStatus.FINISHED);
        }
        ((PageFinishedPoint) ExtensionPoint.as(PageFinishedPoint.class).node(this.f6449a).create()).onPageFinished(mergeVHost);
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public boolean shouldOverrideUrlLoading(APWebView aPWebView, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("should override url loading: ");
        sb.append(str);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        return !a(VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a)));
    }

    public void onPageStarted(APWebView aPWebView, String str, Bitmap bitmap) {
        App app;
        GriverPVMonitor griverPVMonitor;
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a));
        StringBuilder sb = new StringBuilder();
        sb.append("page started: ");
        sb.append(mergeVHost);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        Render render = this.f6449a.getRender();
        if (render instanceof GriverWebRenderImpl) {
            ((GriverWebRenderImpl) render).updatePageStatus(PageStatus.LOADING);
        }
        Page page = this.f6449a;
        if (page != null && (app = page.getApp()) != null && app.isTinyApp() && GriverPVConfig.canMonit(app) && !TextUtils.isEmpty(mergeVHost) && !mergeVHost.contains(app.getAppId()) && (griverPVMonitor = (GriverPVMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverPVMonitor.getMonitorToken(app))) != null) {
            griverPVMonitor.addUrlCount(mergeVHost);
        }
        ((PageStartedPoint) ExtensionPoint.as(PageStartedPoint.class).node(this.f6449a).create()).onStarted(mergeVHost);
    }

    public void onPageFinished(APWebView aPWebView, String str, long j) {
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a));
        StringBuilder sb = new StringBuilder();
        sb.append("page finished: ");
        sb.append(mergeVHost);
        sb.append(", pageSize: ");
        sb.append(j);
        sb.append(", progress: ");
        sb.append(aPWebView.getProgress());
        GriverLogger.d("GriverWebViewClient", sb.toString());
        Render render = this.f6449a.getRender();
        if (render instanceof GriverWebRenderImpl) {
            ((GriverWebRenderImpl) render).updatePageStatus(PageStatus.FINISHED);
        }
        ((PageFinishedPoint) ExtensionPoint.as(PageFinishedPoint.class).node(this.f6449a).create()).onPageFinished(mergeVHost);
    }

    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, APWebResourceRequest aPWebResourceRequest) {
        return a(aPWebView, aPWebResourceRequest.getUrl(), aPWebResourceRequest.getMethod(), aPWebResourceRequest.getRequestHeaders(), aPWebResourceRequest.isForMainFrame());
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public WebResourceResponse shouldInterceptRequest(APWebView aPWebView, String str) {
        return a(aPWebView, H5UrlHelper.parseUrl(str), "GET", null, false);
    }

    private WebResourceResponse a(APWebView aPWebView, Uri uri, String str, Map<String, String> map, boolean z) {
        App app;
        String mergeVHost = VHostUrlInterceptor.mergeVHost(uri.toString(), getVhost(this.f6449a));
        StringBuilder sb = new StringBuilder();
        sb.append("shouldInterceptRequest == 111 ");
        sb.append(mergeVHost);
        RVLogger.d("GriverWebViewClient", sb.toString());
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.f6449a).create()).load(ResourceLoadContext.newBuilder().originUrl(mergeVHost).isMainDoc(z).build());
        if (load != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("shouldInterceptRequest == 111 got resource: ");
            sb2.append(load);
            RVLogger.d("GriverWebViewClient", sb2.toString());
            WebResourceResponse webResourceResponse = new WebResourceResponse(load.getMimeType(), load.getEncoding(), load.getStream());
            if (Build.VERSION.SDK_INT >= 21) {
                HashMap hashMap = new HashMap();
                hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                webResourceResponse.setResponseHeaders(hashMap);
            }
            a(load.getBytes(), uri);
            return webResourceResponse;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("shouldInterceptRequest == url is null");
        sb3.append(mergeVHost);
        RVLogger.d("GriverWebViewClient", sb3.toString());
        ResourceInfo resourceInfo = new ResourceInfo(System.currentTimeMillis(), str);
        boolean equals = TextUtils.equals(this.f6449a.getOriginalURI(), uri.toString());
        synchronized (GriverWebViewClient.class) {
            if (equals) {
                this.d.clear();
                resourceInfo.mIsMainDoc = true;
            }
            resourceInfo.mUrl = uri.toString();
            this.d.put(uri.toString(), resourceInfo);
        }
        Page page = this.f6449a;
        if (page == null || (app = page.getApp()) == null || !app.isTinyApp()) {
            return null;
        }
        return ((H5WebViewCacheExtension) RVProxy.get(H5WebViewCacheExtension.class)).getEntry(app.getAppId(), mergeVHost, str, map);
    }

    private void a(byte[] bArr, Uri uri) {
        if (bArr == null || !MonitorManager.exceedThreshold(GriverMonitorConstants.ERROR_PAGE_SIZE_EXCEPTION, bArr.length)) {
            return;
        }
        GriverMonitor.error(GriverMonitorConstants.ERROR_PAGE_SIZE_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(this.f6449a.getApp().getAppId()).version(this.f6449a.getApp()).url(uri.toString()).pageUrl(this.f6449a.getOriginalURI()).requestUrl(uri.toString()).needAsynAppType(true).size(String.valueOf(bArr.length)).threshold(String.valueOf(MonitorManager.getThreshold(GriverMonitorConstants.ERROR_PAGE_SIZE_EXCEPTION))).build());
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedError(APWebView aPWebView, int i, String str, String str2) {
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str2, getVhost(this.f6449a));
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedError errorCode ");
        sb.append(i);
        sb.append(" description ");
        sb.append(str);
        sb.append(" failingUrl ");
        sb.append(mergeVHost);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        b(mergeVHost, sb2.toString(), str);
        if (i == -97) {
            return;
        }
        a(mergeVHost, i);
    }

    private void a(String str, int i) {
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a));
        if (TextUtils.equals(mergeVHost, this.c) && System.currentTimeMillis() - this.b <= 500) {
            GriverLogger.d("GriverWebViewClient", "the same error not load");
            return;
        }
        this.b = System.currentTimeMillis();
        this.c = mergeVHost;
        a(String.valueOf(i), mergeVHost, "genericError");
        StringBuilder sb = new StringBuilder();
        sb.append("loadErrorPage ");
        sb.append(mergeVHost);
        sb.append(" statusCode ");
        sb.append(i);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        Page page = this.f6449a;
        if (page == null) {
            return;
        }
        if (page.getStartParams() != null) {
            this.f6449a.getStartParams().putBoolean("dsl_error", true);
        }
        if (b(mergeVHost, i)) {
            return;
        }
        ((GriverWebViewReceivedErrorExtension) RVProxy.get(GriverWebViewReceivedErrorExtension.class)).showError(this.f6449a, mergeVHost, i);
    }

    private boolean b(String str, int i) {
        if ((i == 403 && !a()) || i == 404) {
            GriverLogger.d("GriverWebViewClient", "loadErrorPage 404 or 403, return ");
            return true;
        }
        String string = BundleUtils.getString(this.f6449a.getStartParams(), "bizType");
        StringBuilder sb = new StringBuilder();
        sb.append("bizType:");
        sb.append(string);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        if (TextUtils.equals(string, "Advertisement")) {
            try {
                this.f6449a.getPageContext().getPageContainer().getView().setVisibility(8);
            } catch (Exception e) {
                GriverLogger.w("GriverWebViewClient", "hide advertisement view exception", e);
            }
            return true;
        } else if (!BundleUtils.getBoolean(this.f6449a.getStartParams(), RVParams.TRANSPARENT, false) || BundleUtils.getBoolean(this.f6449a.getStartParams(), RVParams.TRANS_ANIMATE, false)) {
            return false;
        } else {
            GriverLogger.d("GriverWebViewClient", "loadErrorPage in transparent case return directly");
            this.f6449a.getApp().popPage(null);
            return true;
        }
    }

    private boolean a() {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_ANDROID_CUSTOMIZE_ERROR_PAGE_USAGE_CONFIG);
        if (configJSONObject != null) {
            return JSONUtils.getBoolean(configJSONObject, GriverConfigConstants.PARAM_USE_CUSTOMIZE_ERROR_PAGE_WHEN_403, false);
        }
        return false;
    }

    private void a(String str, String str2, String str3) {
        if (this.f6449a == null) {
            return;
        }
        ((PageAbnormalPoint) ExtensionPoint.as(PageAbnormalPoint.class).node(this.f6449a).create()).pageAbnoraml(str3, str, GriverMonitorConstants.MESSAGE_RECEIVED_PAGE_ERROR);
        ((PageErrorPoint) ExtensionPoint.as(PageErrorPoint.class).node(this.f6449a).create()).onPageError(str2);
    }

    private void b(String str, String str2, String str3) {
        Page page = this.f6449a;
        if (page == null || page.getRender() == null || this.f6449a.getRender().getRenderBridge() == null || TextUtils.equals(str2, "200") || TextUtils.equals(str2, RecordError.ERROR_NAVIGATION_NON_ALLOWED) || TextUtils.equals(str2, "304")) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sendErrorResource:");
        sb.append(str);
        sb.append("  errorCode:");
        sb.append(str2);
        sb.append(" description:");
        sb.append(str3);
        GriverLogger.debug("GriverWebViewClient", sb.toString());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) str);
        jSONObject.put("error", (Object) str2);
        jSONObject.put("errorMessage", (Object) str3);
        jSONObject.put("client", (Object) "android");
        new JSONObject().put("data", (Object) jSONObject);
        this.f6449a.getRender().getRenderBridge().sendToRender(new RenderCallContext.Builder(this.f6449a.getRender()).action("h5ResourceLost").param(jSONObject).build(), null);
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedHttpError(APWebView aPWebView, int i, String str) {
        Page page;
        String mergeVHost = VHostUrlInterceptor.mergeVHost(str, getVhost(this.f6449a));
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedHttpError statusCode : ");
        sb.append(i);
        sb.append(" requestUrl : ");
        sb.append(mergeVHost);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        if (TextUtils.isEmpty(mergeVHost) || (page = this.f6449a) == null) {
            return;
        }
        if (!TextUtils.equals(page.getPageURI(), mergeVHost)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceivedHttpError : ");
            sb2.append(this.f6449a.getPageURI());
            GriverLogger.d("GriverWebViewClient", sb2.toString());
            if (this.d.containsKey(mergeVHost)) {
                ResourceInfo remove = this.d.remove(mergeVHost);
                if (remove != null) {
                    remove.mStatusCode = i;
                }
                a(remove, "load resource fail");
                return;
            }
            return;
        }
        a(mergeVHost, i);
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onWebViewEvent(APWebView aPWebView, int i, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("onWebViewEvent: ");
        sb.append(i);
        sb.append(", ");
        sb.append(obj);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        if (i != 13 && i != 14) {
            if (i != 16) {
                switch (i) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 9:
                        break;
                    default:
                        return;
                }
            }
            a(aPWebView, obj, i);
            return;
        }
        a(obj, i);
    }

    public static boolean isScreenOn() {
        PowerManager powerManager = (PowerManager) GriverEnv.getApplicationContext().getSystemService("power");
        if (powerManager != null) {
            return powerManager.isScreenOn();
        }
        GriverLogger.d("GriverWebViewClient", "powerManager == null");
        return true;
    }

    private void a(APWebView aPWebView, Object obj, int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append("onWebViewEvent empty page ");
        sb.append(aPWebView.getUrl());
        GriverLogger.d("GriverWebViewClient", sb.toString());
        try {
            i2 = Integer.parseInt(String.valueOf(obj));
        } catch (Exception e) {
            GriverLogger.e("GriverWebViewClient", "parse blank time exception", e);
            i2 = 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onWebViewEvent empty page blankTime is ");
        sb2.append(i2);
        GriverLogger.d("GriverWebViewClient", sb2.toString());
        if (i2 == 3) {
            this.f = true;
        }
        if (i2 == 6) {
            this.g = true;
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            if ((rVEnvironmentService != null && rVEnvironmentService.isBackgroundRunning()) || !isScreenOn()) {
                GriverLogger.d("GriverWebViewClient", "activity isBackgroundRunning or screenOff");
                return;
            }
        }
        if (i2 == 9) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onWebViewEvent empty page blankTime 3&6 ");
            sb3.append(this.f);
            sb3.append(ContainerUtils.FIELD_DELIMITER);
            sb3.append(this.g);
            GriverLogger.d("GriverWebViewClient", sb3.toString());
            RVEnvironmentService rVEnvironmentService2 = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            if ((rVEnvironmentService2 != null && rVEnvironmentService2.isBackgroundRunning()) || !isScreenOn()) {
                GriverLogger.d("GriverWebViewClient", "activity isBackgroundRunning or screenOff");
            } else if (this.f && this.g && !RVFlag.hasShowLoading) {
                GriverLogger.d("GriverWebViewClient", "onWebViewEvent empty page blankTime is report monitor");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorType", (Object) "ucLongRender");
                int i3 = i == 9 ? H5ErrorCode.BLANK_SCREEN_UC_EMPTY_SCREEN : H5ErrorCode.BLANK_SCREEN_UC_BASECOLOR_EMPTY_SCREEN;
                jSONObject.put("errorCode", (Object) Integer.valueOf(i3));
                ((PageAbnormalPoint) ExtensionPoint.as(PageAbnormalPoint.class).node(this.f6449a).create()).pageAbnoraml("ucLongRender", String.valueOf(i3), GriverMonitorConstants.MESSAGE_UC_EMPTY_PAGE_ERROR);
            }
        }
    }

    private void a(Object obj, int i) {
        if (i == 7) {
            StringBuilder sb = new StringBuilder();
            sb.append("first screen t2: ");
            sb.append(SystemClock.elapsedRealtime());
            GriverLogger.d("GriverWebViewClient", sb.toString());
            ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(this.f6449a.getApp(), this.f6449a.getOriginalURI(), "firstScreen");
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onReceivedSslError(APWebView aPWebView, final APSslErrorHandler aPSslErrorHandler, SslError sslError) {
        WeakReference<Activity> topActivity;
        GriverLogger.e("GriverWebViewClient", "onReceivedSslError");
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_ANDROID_SSL_ERROR_HANDLE, GriverConfigConstants.ANDROID_SSL_ERROR_HANDLE_VALUE);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        JSONObject parseObject = JSONUtils.parseObject(config);
        if (parseObject.containsKey("enable") && parseObject.getBoolean("enable").booleanValue()) {
            if (parseObject.containsKey("externalEnable") && parseObject.getBoolean("externalEnable").booleanValue()) {
                GriverLogger.d("GriverWebViewClient", "send GriverReceivedSslErrorEvent");
                GriverReceivedSslErrorEvent griverReceivedSslErrorEvent = (GriverReceivedSslErrorEvent) ExtensionPoint.as(GriverReceivedSslErrorEvent.class).node(this.f6449a).create();
                if (griverReceivedSslErrorEvent != null) {
                    griverReceivedSslErrorEvent.onReceivedSslError(aPWebView.getView().getContext(), aPSslErrorHandler, sslError);
                    return;
                }
                return;
            }
            GriverLogger.d("GriverWebViewClient", "ssl process");
            if (parseObject.containsKey("way")) {
                String string = parseObject.getString("way");
                string.hashCode();
                char c = 65535;
                int hashCode = string.hashCode();
                if (hashCode != -1367724422) {
                    if (hashCode != 3548) {
                        if (hashCode == 3327780 && string.equals("lost")) {
                            c = 2;
                        }
                    } else if (string.equals("ok")) {
                        c = 1;
                    }
                } else if (string.equals("cancel")) {
                    c = 0;
                }
                if (c == 0) {
                    aPSslErrorHandler.cancel();
                } else if (c == 1) {
                    aPSslErrorHandler.proceed();
                } else if (c != 2) {
                    Activity context = aPWebView.getView().getContext();
                    if ((context instanceof Application) && (topActivity = GriverEnv.getTopActivity()) != null && topActivity.get() != null) {
                        context = topActivity.get();
                    }
                    Context context2 = context;
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SSL error: ");
                        sb.append(sslError.getUrl());
                        GriverDialogUtils.showMessageBox(context2, sb.toString(), "continue", "cancel", new View.OnClickListener() { // from class: com.alibaba.griver.core.render.GriverWebViewClient.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aPSslErrorHandler.proceed();
                            }
                        }, new View.OnClickListener() { // from class: com.alibaba.griver.core.render.GriverWebViewClient.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                aPSslErrorHandler.cancel();
                            }
                        });
                    } catch (Exception e) {
                        GriverLogger.e("GriverWebViewClient", "showMessageBox", e);
                    }
                }
            }
        }
    }

    @Override // com.alibaba.griver.base.api.APWebViewClient
    public void onResourceResponse(APWebView aPWebView, HashMap<String, String> hashMap) {
        int parseInt = H5Utils.parseInt(hashMap.get("httpcode"));
        String str = hashMap.get("url");
        StringBuilder sb = new StringBuilder();
        sb.append("onResourceResponse statusCode ");
        sb.append(parseInt);
        sb.append(" url ");
        sb.append(str);
        GriverLogger.d("GriverWebViewClient", sb.toString());
        if (this.d.containsKey(str)) {
            ResourceInfo remove = this.d.remove(str);
            if (this.f6449a == null || remove == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(parseInt);
            b(str, sb2.toString(), "");
            remove.mMimeType = hashMap.get(ContactProvider.Column.MIMETYPE);
            remove.mStatusCode = parseInt;
            if (remove.mIsMainDoc && (parseInt == 301 || parseInt == 302 || parseInt >= 400)) {
                try {
                    this.f6449a.getPageContext().getLoadingView().dismiss();
                } catch (Exception unused) {
                    GriverLogger.e("GriverWebViewClient", "hide loading");
                }
            }
            if (remove.mStatusCode < 400) {
                return;
            }
            if (remove.mIsMainDoc) {
                a(String.valueOf(parseInt), remove.mUrl, "genericError");
            }
            a(remove, "load resource failed");
        }
    }

    private void a(ResourceInfo resourceInfo, String str) {
        if (this.f6449a == null || resourceInfo == null) {
            return;
        }
        try {
            MonitorMap.Builder builder = new MonitorMap.Builder();
            builder.appId(this.f6449a.getApp().getAppId()).version(this.f6449a.getApp()).url(this.f6449a.getOriginalURI()).append("targetUrl", resourceInfo.mUrl).requestUrl(resourceInfo.mUrl).pageUrl(this.f6449a.getOriginalURI()).append("method", resourceInfo.mMethod).append("type", resourceInfo.mMimeType).code(String.valueOf(resourceInfo.mStatusCode)).message(str).needAsynAppType(true);
            GriverMonitor.error(GriverMonitorConstants.ERROR_RESOURCES, "GriverAppContainer", builder.build());
        } catch (Exception e) {
            GriverLogger.e("GriverWebViewClient", "send monitor failed", e);
        }
    }

    public String getVhost(Page page) {
        AppModel appModel;
        if (TextUtils.isEmpty(this.e) && page != null && (appModel = (AppModel) page.getApp().getData(AppModel.class)) != null) {
            this.e = appModel.getAppInfoModel().getVhost();
        }
        return this.e;
    }
}
