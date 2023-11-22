package com.alibaba.griver.core.render;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.appinfo.AppType;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.network.DownloadCallback;
import com.alibaba.griver.api.common.page.GriverRenderCreateEvent;
import com.alibaba.griver.api.common.page.GriverRenderType;
import com.alibaba.griver.api.file.GriverFileExtension;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alibaba.griver.api.ui.loadingview.GriverLoadingViewExtension;
import com.alibaba.griver.base.api.APDownloadListener;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.H5ScrollChangedCallback;
import com.alibaba.griver.base.api.NXH5PageAdapter;
import com.alibaba.griver.base.api.ShouldLoadUrlPoint;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.AppTypeUtils;
import com.alibaba.griver.base.common.utils.GriverAllRecordsUtils;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alibaba.griver.base.common.webview.GriverWebviewSetting;
import com.alibaba.griver.base.nebula.H5DevConfig;
import com.alibaba.griver.base.nebula.H5Utils;
import com.alibaba.griver.base.nebula.WebViewType;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.snapshot.GriverRVSnapshotUtils;
import com.alibaba.griver.core.preload.PreloadInitializer;
import com.alibaba.griver.core.webview.AndroidWebView;
import com.alibaba.griver.core.webview.extension.GriverWebChromeClientExtension;
import id.dana.data.here.HereOauthManager;
import id.dana.sendmoney.summary.SummaryActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class GriverWebRenderImpl extends BaseGriverRender implements NXH5PageAdapter {

    /* renamed from: a */
    private String f6448a;
    private GriverWebViewClient b;
    private NXWebChromeClient c;
    private NXAPWebViewListener d;
    private H5ScriptLoader e;
    private LegacyH5WebViewAdapter f;
    private H5WebView g;
    private RenderBridge h;
    private CreateParams i;
    private boolean j;
    private APWebView k;
    private boolean l;
    private String m;

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    public GriverWebRenderImpl(RVEngine rVEngine, Activity activity, Node node, CreateParams createParams, APWebView aPWebView, String str) {
        super(rVEngine, activity, (DataNode) node, createParams);
        APWebView aPWebView2;
        WebView webView;
        this.f6448a = "Griver:GriverWebRenderImpl";
        this.j = false;
        this.l = true;
        this.m = str;
        this.i = createParams;
        if (!(node instanceof Page)) {
            RVLogger.e("Griver:GriverWebRenderImpl", "GriverWebRenderImpl construct params  node is not a H5Page");
            throw new IllegalArgumentException("node must is  H5Page Node");
        }
        Bundle bundle = createParams.startParams;
        String a2 = a(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("bizType", a2);
        this.k = NXWebViewFactory.instance().createWebView(a2, activity, bundle, true, aPWebView);
        this.d = new NXAPWebViewListener((Page) node, true);
        this.g = new H5WebView(activity, this.h5Page, bundle2, this.k, this.d);
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_GRIVER_RENDER_CREATE_EVENT_CONFIG, true) && (aPWebView2 = this.k) != null && (aPWebView2 instanceof AndroidWebView) && (webView = ((AndroidWebView) aPWebView2).getWebView()) != null && BundleUtils.getBoolean(bundle, RVParams.isH5App, false)) {
            ((GriverRenderCreateEvent) ExtensionPoint.as(GriverRenderCreateEvent.class).node(node).create()).renderCreate(webView, GriverRenderType.H5);
        }
        this.f = new LegacyH5WebViewAdapter(this, this.g, this.d);
        this.h = new GriverWebRenderBridge(node, this.k);
        if (((GriverEnv.isDebuggable() ? H5DevConfig.getBooleanConfig(H5DevConfig.H5_FORCE_V8WORKER, false) : false) || (this.g.getType() == WebViewType.SYSTEM_BUILD_IN && bundle.getBoolean(RVParams.isTinyApp) && !SummaryActivity.CHECKED.equalsIgnoreCase(bundle.getString("enablePolyfillWorker")))) && H5Utils.isWebWorkerSupported()) {
            bundle.putString("enablePolyfillWorker", SummaryActivity.CHECKED);
            RVLogger.d(this.f6448a, "degradeToSystemWebView...switch is supported");
        }
        this.e = new H5ScriptLoader(this.h5Page, this.g);
        H5WebViewGoBackPerform h5WebViewGoBackPerform = new H5WebViewGoBackPerform(this);
        h5WebViewGoBackPerform.setBackBehavior(BundleUtils.getString(getStartParams(), "backBehavior"));
        setBackPerform(h5WebViewGoBackPerform);
        if (!"no".equalsIgnoreCase(GriverConfig.getConfig(GriverConfigConstants.KEY_USE_CUSTOM_CHROME_CLIENT, "YES"))) {
            this.c = ((GriverWebChromeClientExtension) RVProxy.get(GriverWebChromeClientExtension.class)).createWebChromeClient(this.h5Page, this, this.e, true);
        }
        if (this.c == null) {
            this.c = new NXWebChromeClient(this.h5Page, this, this.e, true);
        }
        GriverWebViewClient griverWebViewClient = new GriverWebViewClient(this.h5Page);
        this.b = griverWebViewClient;
        this.f.setNxh5WebViewClientAdapter(new LegacyNXH5WebViewClientAdapter(griverWebViewClient));
        setWebViewAdapter(this.f);
        this.g.setWebChromeClient(this.c);
        this.g.setWebViewClient(this.b);
        if (GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_ANDROID_WEBVIEW_SUPPORT_FILE_DOWNLOAD, true)) {
            this.g.setDownloadListener(new AnonymousClass1(activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.core.render.GriverWebRenderImpl$1 */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements APDownloadListener {
        final /* synthetic */ Activity val$activity;

        AnonymousClass1(Activity activity) {
            GriverWebRenderImpl.this = r1;
            this.val$activity = activity;
        }

        @Override // com.alibaba.griver.base.api.APDownloadListener
        public void onDownloadStart(final String str, String str2, String str3, String str4, long j) {
            final GriverFileExtension griverFileExtension = (GriverFileExtension) RVProxy.get(GriverFileExtension.class);
            final GriverLoadingViewExtension griverLoadingViewExtension = (GriverLoadingViewExtension) RVProxy.get(GriverLoadingViewExtension.class);
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.1.1
                {
                    AnonymousClass1.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    griverLoadingViewExtension.show(AnonymousClass1.this.val$activity, AnonymousClass1.this.val$activity.getString(R.string.griver_core_loading), true);
                }
            });
            griverFileExtension.downloadFile(str, str2, str3, str4, j, new DownloadCallback() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.1.2
                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onPrepare(String str5) {
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onProgress(String str5, int i) {
                }

                {
                    AnonymousClass1.this = this;
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onCancel(String str5) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.1.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            griverLoadingViewExtension.dismiss();
                        }
                    });
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onFinish(final String str5) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.1.2.2
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            griverLoadingViewExtension.dismiss();
                            griverFileExtension.openDocument(AnonymousClass1.this.val$activity, str5);
                        }
                    });
                }

                @Override // com.alibaba.griver.api.common.network.DownloadCallback
                public void onFailed(String str5, int i, String str6) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.1.2.3
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            griverLoadingViewExtension.dismiss();
                        }
                    });
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    GriverMonitor.commonException(GriverMonitorConstants.EVENT_ANDROID_WEBVIEW_DOWNLOAD_FAILED, "GriverAppContainer", String.valueOf(i), str6, hashMap);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public String getUserAgent() {
        String userAgentString;
        synchronized (this) {
            userAgentString = this.g.getSettings().getUserAgentString();
        }
        return userAgentString;
    }

    private String a(Bundle bundle) {
        String string = BundleUtils.getString(bundle, "bizType", "");
        if (TextUtils.isEmpty(string)) {
            string = BundleUtils.getString(bundle, GriverParam.PUBLIC_ID, "");
        }
        return TextUtils.isEmpty(string) ? BundleUtils.getString(bundle, "appId") : string;
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void load(final LoadParams loadParams) {
        if (this.l && getApWebView().isPreload()) {
            PageContext pageContext = this.h5Page.getPageContext();
            if (pageContext != null && pageContext.getLoadingView() != null) {
                pageContext.getLoadingView().dismiss();
            }
            if (pageContext != null && pageContext.getTitleBar() != null) {
                pageContext.getTitleBar().showTitleLoading(false);
            }
            this.l = true;
            return;
        }
        super.load(loadParams);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.2
            {
                GriverWebRenderImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GriverWebRenderImpl.this.a(loadParams);
            }
        });
    }

    public void a(LoadParams loadParams) {
        boolean z;
        String str = this.f6448a;
        StringBuilder sb = new StringBuilder();
        sb.append("webview start load url,url=");
        sb.append(loadParams.url);
        GriverLogger.d(str, sb.toString());
        H5Utils.handleTinyAppKeyEvent("main", "H5PageImpl.loadUrl()");
        JSONObject a2 = a(loadParams.url);
        App app = (App) getPage().bubbleFindNode(App.class);
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null || appModel.getAppInfoModel() == null || !loadParams.url.startsWith(appModel.getAppInfoModel().getVhost())) {
            z = false;
        } else {
            RVLogger.d(this.f6448a, "nxh5webview loadUrl from onlineHost direct load!");
            z = true;
        }
        boolean z2 = BundleUtils.getBoolean(app.getStartParams(), RVParams.isTinyApp, false);
        if ((loadParams.forceLoad || z) && z2) {
            loadUrl(loadParams.url, a2.getString("Referer"), this.i.startParams);
            return;
        }
        ApiPermissionCheckResult interceptSchemeForTiny = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).interceptSchemeForTiny(loadParams.url, (Page) getPage());
        if (interceptSchemeForTiny != ApiPermissionCheckResult.IGNORE) {
            a(ErrorPageUtils.WEB_VIEW_SCHEME_ERROR, a2, loadParams.url);
            String str2 = this.f6448a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("interceptSchemeForTiny =");
            sb2.append(loadParams.url);
            RVLogger.d(str2, sb2.toString());
            int indexOf = loadParams.url.indexOf("&url=");
            String str3 = loadParams.url;
            if (indexOf != -1) {
                str3 = str3.substring(indexOf + 5);
            }
            if (interceptSchemeForTiny == ApiPermissionCheckResult.DENY_N22205) {
                GriverAllRecordsUtils.put(RecordError.ERROR_NAVIGATION_NON_SCHEME, new MapBuilder.Builder().map("appId", app.getAppId()).map("url", str3).map("scheme", str3).build());
            } else {
                ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_NAVIGATION_NON_ALLOWED).append("appId", app.getAppId()).append("page", app.getActivePage() != null ? app.getActivePage().getPageURI() : "").append("url", str3).build());
            }
        } else if (((ShouldLoadUrlPoint) ExtensionPoint.as(ShouldLoadUrlPoint.class).node(getPage()).defaultValue(Boolean.TRUE).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.3
            {
                GriverWebRenderImpl.this = this;
            }

            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        Boolean bool = list.get(i);
                        if (bool != null && !bool.booleanValue()) {
                            String str4 = GriverWebRenderImpl.this.f6448a;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("shouldLoad false in index ");
                            sb3.append(i);
                            sb3.append(" !!!");
                            RVLogger.w(str4, sb3.toString());
                            return Boolean.FALSE;
                        }
                    }
                }
                return Boolean.TRUE;
            }
        }).create()).shouldLoad(a2, loadParams.url)) {
            if (AppTypeUtils.isEmbedPage(this.mAriverPage)) {
                String str4 = loadParams.url;
                try {
                    Uri parse = Uri.parse(str4);
                    if (parse == null || TextUtils.isEmpty(str4) || !str4.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                        a(ErrorPageUtils.WEB_VIEW_SCHEME_ERROR, a2, str4);
                        return;
                    } else if (!str4.startsWith("https")) {
                        if (!a()) {
                            a(ErrorPageUtils.WEB_VIEW_HTTP_FORBIDDEN, a2, str4);
                            ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_NAVIGATION_NON_HTTPS).append("appId", app.getAppId()).append("page", app.getActivePage() != null ? app.getActivePage().getPageURI() : "").append("url", loadParams.url).build());
                            return;
                        }
                        JSONArray c = c();
                        if (c != null && !c.isEmpty() && !c.contains(parse.getHost())) {
                            String str5 = this.f6448a;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("the url: ");
                            sb3.append(str4);
                            sb3.append(" in web-view is not in whitelist, do not load");
                            GriverLogger.d(str5, sb3.toString());
                            a(ErrorPageUtils.WEB_VIEW_HTTP_FORBIDDEN, a2, str4);
                            return;
                        }
                    }
                } catch (Exception e) {
                    String str6 = this.f6448a;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("parse uri failed for ");
                    sb4.append(str4);
                    GriverLogger.e(str6, sb4.toString(), e);
                    a(ErrorPageUtils.WEB_VIEW_SCHEME_ERROR, a2, str4);
                    ((GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)).addRecord(new Record.Builder(RecordError.ERROR_NAVIGATION_NON_ALLOWED).append("appId", app.getAppId()).append("url", loadParams.url).build());
                    return;
                }
            }
            loadUrl(JSONUtils.getString(a2, "url"), a2.getString("Referer"), this.i.startParams);
        }
    }

    private void a(int i, JSONObject jSONObject, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ErrorPageUtils.getErrorStatusPageUrl(), getAppId(), Integer.valueOf(i), "MINI_PROGRAM"));
        sb.append("&url=");
        sb.append(H5UrlHelper.encode(str));
        loadUrl(sb.toString(), jSONObject.getString("Referer"), this.i.startParams);
    }

    private boolean a() {
        return JSONUtils.getBoolean(b(), "enable", false);
    }

    private JSONObject b() {
        return JSONUtils.parseObject(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_EMBEDED_WEBVIEW_HTTP_CONTROL, "{\"enable\":false,\"whitelist\":[]}"));
    }

    private JSONArray c() {
        return b().getJSONArray("whitelist");
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public View getView() {
        return this.g.getView();
    }

    public APWebView getApWebView() {
        return this.k;
    }

    public boolean isVideoFullscreen() {
        return this.c.isVideoFullscreen();
    }

    public void updatePageStatus(int i) {
        getBackPerform().updatePageStatus(i);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void setTextSize(int i) {
        H5WebView h5WebView = this.g;
        if (h5WebView == null) {
            RVLogger.d(this.f6448a, "setTextSize webview is null");
        } else if (i != -1) {
            h5WebView.setTextSize(i);
        }
    }

    @Override // com.alibaba.griver.core.render.BaseGriverRender
    public void setViewParams(String str, String str2) {
        this.e.setParamsToWebPage(str, str2);
    }

    @Override // com.alibaba.griver.core.render.BaseGriverRender
    public void insertJS(String str) {
        if (GriverEnv.isDebuggable() && !TextUtils.isEmpty(str)) {
            H5DevConfig.H5_LOAD_JS = str;
            this.e.loadDynamicJs4Jsapi(this.g, str);
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void reload() {
        H5WebView h5WebView = this.g;
        if (h5WebView != null) {
            h5WebView.reload();
        }
    }

    private JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) str);
        jSONObject.put("requestPreAuth", (Object) Boolean.valueOf(BundleUtils.getBoolean(this.i.startParams, "requestPreAuth", false)));
        if (this.i.startParams.containsKey("Referer")) {
            jSONObject.put("Referer", (Object) BundleUtils.getString(this.i.startParams, "Referer"));
        }
        jSONObject.put(GriverParam.PUBLIC_ID, (Object) BundleUtils.getString(this.i.startParams, GriverParam.PUBLIC_ID, ""));
        H5WebView h5WebView = this.g;
        if (h5WebView != null && TextUtils.isEmpty(h5WebView.getUrl())) {
            jSONObject.put("appId", (Object) BundleUtils.getString(this.i.startParams, "appId"));
            String string = BundleUtils.getString(this.i.startParams, RVParams.LONG_PRESSO_LOGIN);
            String string2 = BundleUtils.getString(this.i.startParams, RVParams.LONG_PRESSO_LOGIN_BINDINGPAGE);
            String string3 = BundleUtils.getString(this.i.startParams, RVParams.LONG_PRESSO_LOGIN_URL);
            jSONObject.put(RVParams.PRESSO_LOGIN, (Object) string);
            jSONObject.put(RVParams.PRESSO_LOGIN_BINDINGPAGE, (Object) string2);
            jSONObject.put(RVParams.PRESSO_LOGIN_URL, (Object) string3);
            jSONObject.put(RVParams.START_URL, (Object) Boolean.TRUE);
        }
        return jSONObject;
    }

    public void loadUrl(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.d(this.f6448a, "internal load url null");
        } else if (this.g == null) {
            RVLogger.d(this.f6448a, "internal load h5WebView null");
        } else {
            String str3 = this.f6448a;
            StringBuilder sb = new StringBuilder();
            sb.append("internal load url,url=");
            sb.append(str);
            RVLogger.d(str3, sb.toString());
            if (TextUtils.equals(BundleUtils.getString(bundle, "openUrlMethod"), "POST")) {
                String string = BundleUtils.getString(bundle, "openUrlPostParams");
                if (bundle != null) {
                    bundle.putString("openUrlMethod", "GET");
                    bundle.putString("openUrlPostParams", "");
                }
                String str4 = this.f6448a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("postUrl   url=");
                sb2.append(str);
                RVLogger.d(str4, sb2.toString());
                this.g.postUrl(str, string.getBytes());
            } else if (!TextUtils.isEmpty(str2)) {
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", str2);
                this.g.loadUrl(str, hashMap);
            } else {
                this.g.loadUrl(str);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getPageId() {
        if (this.h5Page == null) {
            return -1;
        }
        return this.h5Page.getPageId();
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl
    public void onDestroy() {
        RVLogger.d(this.f6448a, "destroy nx view");
        H5WebView h5WebView = this.g;
        if (h5WebView != null) {
            h5WebView.onRelease();
            this.g = null;
        }
        this.f = null;
        if (this.b != null) {
            this.b = null;
        }
        NXWebChromeClient nXWebChromeClient = this.c;
        if (nXWebChromeClient != null) {
            nXWebChromeClient.onRelease();
            this.c = null;
        }
        this.d = null;
        this.e = null;
        this.h5Page = null;
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onResume() {
        super.onResume();
        H5WebView h5WebView = this.g;
        if (h5WebView != null) {
            try {
                h5WebView.onResume();
            } catch (Exception e) {
                RVLogger.e(this.f6448a, "webview on resume exception", e);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onPause() {
        super.onPause();
        H5WebView h5WebView = this.g;
        if (h5WebView != null) {
            try {
                h5WebView.onPause();
            } catch (Exception e) {
                RVLogger.e(this.f6448a, "webview on pause exception", e);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(final ScrollChangedCallback scrollChangedCallback) {
        this.g.setOnScrollChangedCallback(new H5ScrollChangedCallback() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.4
            {
                GriverWebRenderImpl.this = this;
            }

            @Override // com.alibaba.griver.base.api.H5ScrollChangedCallback
            public void onScroll(int i, int i2) {
                scrollChangedCallback.onScroll(i, i2);
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void init() {
        RVLogger.d(this.f6448a, "start init nxh5webview ");
        boolean b = b(this.i.startParams);
        String str = this.f6448a;
        StringBuilder sb = new StringBuilder();
        sb.append("allow webview access from file URL ");
        sb.append(b);
        RVLogger.d(str, sb.toString());
        this.g.init(b);
        if (this.l && getApWebView().isPreload()) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.5
                {
                    GriverWebRenderImpl.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    GriverWebRenderImpl.this.e.loadScript();
                    GriverWebRenderImpl griverWebRenderImpl = GriverWebRenderImpl.this;
                    griverWebRenderImpl.b(griverWebRenderImpl.i.createUrl);
                }
            });
        } else {
            d();
        }
        a(getActivity(), this.g);
    }

    private void d() {
        String userAgentString = this.g.getSettings().getUserAgentString();
        StringBuilder sb = new StringBuilder();
        sb.append(userAgentString);
        sb.append(" Language/en ");
        sb.append(EngineUtils.getUserAgentSuffix());
        sb.append(GriverWebviewSetting.getUserAgent());
        String obj = sb.toString();
        if (AppType.parse(this.h5Page.getApp().getAppType()).isTiny() && !Pattern.compile(".*[\\\\]'.*").matcher(obj).matches()) {
            obj = obj.replace("'", "\\'");
        }
        if (PWAUtils.isLoadNewWay()) {
            if (AppTypeUtils.isEmbedPage(this.mAriverPage)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(" MiniProgram");
                obj = sb2.toString();
            }
        } else if (AppTypeUtils.isEmbedPage(this.mAriverPage) || AppInfoUtils.isEmbeddedApp(this.mAriverPage)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append(" MiniProgram");
            obj = sb3.toString();
        }
        String str = this.f6448a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("set final user agent: ");
        sb4.append(obj);
        GriverLogger.d(str, sb4.toString());
        this.g.getSettings().setUserAgentString(obj);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void triggerSaveSnapshot() {
        super.triggerSaveSnapshot();
        if (!BundleUtils.getBoolean(getStartParams(), RVParams.isTinyApp, false) || AppTypeUtils.isEmbedPage(this.mAriverPage)) {
            return;
        }
        String str = this.f6448a;
        StringBuilder sb = new StringBuilder();
        sb.append("handleSnapshotEvent webView.loadUrl(), call saveSnapshot jsapi, appId: ");
        sb.append(getAppId());
        RVLogger.d(str, sb.toString());
        H5WebView h5WebView = this.g;
        if (h5WebView != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("javascript: AlipayJSBridge.call('saveSnapshot', {snapshot: document.documentElement.outerHTML.replace(");
            sb2.append("/<script src=\\\"https:\\/\\/appx\\/af-appx.min.js#nebula-addcors\\\" crossorigin=\\\"\\\"><\\/script>\\n/g");
            sb2.append(", '')});");
            h5WebView.loadUrl(sb2.toString());
            return;
        }
        RVLogger.e(this.f6448a, "triggerSaveSnapshot webview is null!");
    }

    private void a(Activity activity, H5WebView h5WebView) {
        final GestureDetector gestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.6
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            {
                GriverWebRenderImpl.this = this;
            }
        });
        h5WebView.getView().setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.griver.core.render.GriverWebRenderImpl.7
            {
                GriverWebRenderImpl.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getScrollY() {
        H5WebView h5WebView = this.g;
        if (h5WebView == null) {
            RVLogger.d(this.f6448a, "getScrollY web view  is null");
            return 0;
        }
        return h5WebView.getScrollY();
    }

    @Override // com.alibaba.griver.core.render.BaseGriverRender
    public H5WebView getH5WebView() {
        return this.g;
    }

    private boolean b(Bundle bundle) {
        Uri parseUrl = H5UrlHelper.parseUrl(BundleUtils.getString(bundle, "url"));
        if (parseUrl != null && "file".equals(parseUrl.getScheme())) {
            String path = parseUrl.getPath();
            String str = this.f6448a;
            StringBuilder sb = new StringBuilder();
            sb.append("uri path : ");
            sb.append(path);
            RVLogger.d(str, sb.toString());
            return (TextUtils.isEmpty(path) || path.contains("..") || path.contains("\\") || path.contains("%")) ? false : true;
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.NXH5PageAdapter
    public void sendEvent(String str, JSONObject jSONObject) {
        if (invokeEventPoint(str, jSONObject)) {
            RVLogger.d(this.f6448a, "sendEvent handled by event point!");
        }
    }

    @Override // com.alibaba.griver.base.api.NXH5PageAdapter
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        H5WebView h5WebView = this.g;
        if (h5WebView == null) {
            RVLogger.d(this.f6448a, "loadDataWithBaseURL web view  is null");
        } else {
            h5WebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.alibaba.griver.base.api.NXH5PageAdapter
    public boolean scriptbizLoadedAndBridgeLoaded() {
        H5ScriptLoader h5ScriptLoader = this.e;
        return h5ScriptLoader != null && h5ScriptLoader.bizLoaded && this.e.bridgeLoaded;
    }

    public NXWebChromeClient getNxWebChromeClient() {
        return this.c;
    }

    public int getBackBehavior() {
        return getBackPerform().getBackBehavior();
    }

    public boolean isShouldResumeWebView() {
        return this.j;
    }

    public void setShouldResumeWebView(boolean z) {
        this.j = z;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public Bitmap getCapture(int i) {
        if (this.g == null) {
            return null;
        }
        if (i == 1) {
            RVLogger.d(this.f6448a, "getCapture CAPTURE_RANGE_DOCUMENT");
            try {
                Picture capturePicture = this.g.capturePicture();
                if (capturePicture == null) {
                    return null;
                }
                Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                capturePicture.draw(new Canvas(createBitmap));
                return createBitmap;
            } catch (Throwable th) {
                RVLogger.e(this.f6448a, "getCapture CAPTURE_RANGE_DOCUMENT exception!", th);
            }
        }
        RVLogger.d(this.f6448a, "getCapture CAPTURE_RANGE_VIEWPORT");
        try {
            View view = this.g.getView();
            view.setDrawingCacheEnabled(true);
            Bitmap copy = view.getDrawingCache().copy(view.getDrawingCache().getConfig(), false);
            view.setDrawingCacheEnabled(false);
            return copy;
        } catch (Throwable th2) {
            RVLogger.e(this.f6448a, "getCapture CAPTURE_RANGE_VIEWPORT exception!", th2);
            return null;
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RenderBridge getRenderBridge() {
        return this.h;
    }

    public H5ScriptLoader getH5ScriptLoader() {
        return this.e;
    }

    public void b(String str) {
        AppModel appModel;
        byte[] loadSnapshotFile;
        int indexOf;
        try {
            String substring = (TextUtils.isEmpty(str) || (indexOf = str.indexOf("#")) <= 0) ? null : str.substring(indexOf + 1);
            StringBuilder sb = new StringBuilder();
            sb.append("(function(){history.replaceState(null,null, '#");
            sb.append(substring);
            sb.append("');console.log('prerenderng replaceState success');})();");
            String obj = sb.toString();
            APWebView aPWebView = this.k;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RDConstant.JAVASCRIPT_SCHEME);
            sb2.append(obj);
            aPWebView.evaluateJavascript(sb2.toString(), null);
            if (PreloadInitializer.canSnapshot(this.mAriverApp) && (appModel = (AppModel) this.mAriverApp.getData(AppModel.class)) != null && (loadSnapshotFile = GriverRVSnapshotUtils.loadSnapshotFile(this.mAriverApp, appModel, str, false, true)) != null) {
                this.k.evaluateJavascript(new String(loadSnapshotFile, HereOauthManager.ENC), null);
                GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(this.mAriverApp));
                if (stageMonitor != null) {
                    stageMonitor.addParam("snapshot", 1);
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(function(d, script) {   console.log('begin prerenderng launch in js');if(window.HASINJECTPRERENDER){console.log('has load prerenderng:' + window.HASINJECTPRERENDER);return;}window.HASINJECTPRERENDER=true;script  = d.createElement('script');script.textContent = ");
            sb3.append(this.m);
            sb3.append(";\n if (d.body) { d.body.appendChild(script); } else {  console.log('prerender without body');   d.addEventListener('DOMContentLoaded', function () { console.log('prerender body ready');d.body.appendChild(script); }); } }(document));");
            String obj2 = sb3.toString();
            String str2 = this.f6448a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("prerenderng launchMaindDocJs ");
            sb4.append(obj2);
            RVLogger.d(str2, sb4.toString());
            APWebView aPWebView2 = this.k;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(RDConstant.JAVASCRIPT_SCHEME);
            sb5.append(obj2);
            aPWebView2.evaluateJavascript(sb5.toString(), null);
        } catch (Exception unused) {
            RVLogger.d(this.f6448a, "prerenderng tryInjectPreRenderJs ");
        }
    }
}
