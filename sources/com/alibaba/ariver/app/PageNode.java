package com.alibaba.ariver.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.Visit;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.biz.VisitUrlPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageCreateRenderPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.point.view.CollectPerformanceCallback;
import com.alibaba.ariver.app.api.point.view.CollectPerformancePoint;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.URLVisitListener;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.Action;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.T2PageInfo;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class PageNode extends NodeInstance implements Page {

    /* renamed from: a */
    private static String f5961a = "AriverApp:Page";
    private String c;
    private Render d;
    private EmbedType e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final List<Page.RenderReadyListener> k;
    private boolean l;
    private final List<Page.JsBridgeReadyListener> m;
    protected PageContext mPageContext;
    protected boolean mRenderReady;
    protected Bundle mSceneParams;
    protected Bundle mStartParams;
    private int n;

    /* renamed from: o */
    private Page.ExitListener f5962o;
    private Page p;
    private App q;
    private boolean r;
    private String s;
    private static AtomicInteger b = new AtomicInteger(1);
    public static final Parcelable.Creator<PageNode> CREATOR = new Parcelable.Creator<PageNode>() { // from class: com.alibaba.ariver.app.PageNode.8
        @Override // android.os.Parcelable.Creator
        public final PageNode createFromParcel(Parcel parcel) {
            return new PageNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PageNode[] newArray(int i) {
            return new PageNode[i];
        }
    };

    public void onDestroy() {
    }

    protected void onHide() {
    }

    protected void onShow() {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean waitResourceReady(String str, boolean z, boolean z2) {
        return true;
    }

    public PageNode(App app, String str, Bundle bundle, Bundle bundle2) {
        this(app, str, bundle, bundle2, EmbedType.NO);
    }

    @Deprecated
    public PageNode(App app, String str, Bundle bundle, Bundle bundle2, boolean z) {
        this(app, str, bundle, bundle2, z ? EmbedType.FULL : EmbedType.NO);
    }

    public PageNode(App app, String str, Bundle bundle, Bundle bundle2, EmbedType embedType) {
        super(app);
        this.e = EmbedType.NO;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = new ArrayList();
        this.m = new ArrayList();
        this.r = true;
        this.q = app;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_constructor);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageCreate);
        this.e = embedType;
        this.r = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_useParentAppWhenParentNull", true);
        if (BundleUtils.getBoolean(bundle, RVParams.IS_PAGE_PRERENDER, false)) {
            RVLogger.d(f5961a, "PagePreRender ignore init when new Page");
        } else {
            init(str, bundle, bundle2);
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageCreated);
        RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_createPage);
        RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_waitEngineInit);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_constructor);
    }

    public void setRender(Render render) {
        this.d = render;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public App getApp() {
        return (App) getParentNode();
    }

    @Override // com.alibaba.ariver.app.NodeInstance, com.alibaba.ariver.kernel.api.node.Node
    public Node getParentNode() {
        Node parentNode = super.getParentNode();
        if (parentNode != null) {
            return parentNode;
        }
        if (this.r) {
            return this.q;
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getStartParams() {
        return this.mStartParams;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageType() {
        App app = getApp();
        if (app != null) {
            return app.getAppType();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Render getRender() {
        return this.d;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageURI() {
        Visit visit = (Visit) peekChild();
        if (visit != null) {
            return visit.getVisitUrl();
        }
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getOriginalURI() {
        return this.c;
    }

    public void init(String str, Bundle bundle, Bundle bundle2) {
        ResourceContext resourceContext;
        String str2 = f5961a;
        StringBuilder sb = new StringBuilder();
        sb.append("init Page with url ");
        sb.append(str);
        sb.append(", startParams: ");
        sb.append(bundle);
        RVLogger.d(str2, sb.toString());
        this.c = str;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        a(str);
        try {
            if (RVSnapshotUtils.isHomePage(this.q, str) && RVSnapshotUtils.isSnapshotEnabled(this.q) && (resourceContext = ResourceContextManager.getInstance().get(this.q.getAppId(), this.q.getStartToken())) != null) {
                String snapshotTitleBarParams = resourceContext.getSnapshotTitleBarParams();
                if (!TextUtils.isEmpty(snapshotTitleBarParams)) {
                    JSONObject parseObject = JSONObject.parseObject(snapshotTitleBarParams);
                    for (String str3 : parseObject.keySet()) {
                        if ("titleBarColor".equalsIgnoreCase(str3)) {
                            try {
                                this.mStartParams.putString(str3, String.valueOf(Integer.parseInt(parseObject.getString(str3)) & FlexItem.MAX_SIZE));
                            } catch (Exception e) {
                                RVLogger.w(f5961a, "snapshot restore LONG_TITLE_BAR_COLOR failed ", e);
                            }
                        } else {
                            this.mStartParams.putString(str3, parseObject.getString(str3));
                        }
                    }
                    String str4 = f5961a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SnapshotProvider set snapshot titleBar success: ");
                    sb2.append(snapshotTitleBarParams);
                    RVLogger.d(str4, sb2.toString());
                }
            }
        } catch (Throwable th) {
            String str5 = f5961a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("SnapshotProvider set snapshot titleBar params error: ");
            sb3.append(th);
            RVLogger.e(str5, sb3.toString());
        }
        if (this.mStartParams.getBoolean(RVStartParams.KEY_FROM_EMBED_H5, false)) {
            this.e = EmbedType.SHARE;
        }
        this.mStartParams.putString("url", str);
        this.n = generatePageId();
        ParamUtils.unifyAll(this.mStartParams, true);
        ((PageInitPoint) ExtensionPoint.as(PageInitPoint.class).node(this).create()).onPageInit(this.c, this.mStartParams, this.mSceneParams);
    }

    private void a(String str) {
        JSONObject pageLaunchParams;
        String hash = UrlUtils.getHash(str);
        if (hash == null) {
            RVLogger.w(f5961a, "not fillParam with empty hash url!");
            return;
        }
        if (hash.startsWith(PluginParamModel.PLUGIN_PAGE_PREFIX)) {
            pageLaunchParams = ((PluginParamModel) getApp().getData(PluginParamModel.class, true)).getStartupParams();
        } else {
            AppConfigModel appConfigModel = (AppConfigModel) getApp().getData(AppConfigModel.class);
            pageLaunchParams = (appConfigModel == null || appConfigModel.getPageLaunchParams() == null) ? null : appConfigModel.getPageLaunchParams();
        }
        if (pageLaunchParams == null) {
            RVLogger.w(f5961a, "not fillParam because empty paramSource!");
            return;
        }
        JSONObject jSONObject = JSONUtils.getJSONObject(pageLaunchParams, hash, null);
        if (jSONObject != null) {
            a(jSONObject);
            String str2 = f5961a;
            StringBuilder sb = new StringBuilder();
            sb.append("put page param for ");
            sb.append(hash);
            sb.append(" ");
            sb.append(jSONObject);
            RVLogger.d(str2, sb.toString());
            this.mStartParams.putAll(JSONUtils.toBundle(jSONObject));
        }
    }

    public void fillStartParamsForPreCreatePage(Bundle bundle) {
        if ("no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_fillParamsForPreCreatePage", "yes"))) {
            RVLogger.d(f5961a, "fillStartParamsForPreCreatePage disable");
            return;
        }
        try {
            RVLogger.d(f5961a, "fillStartParamsForPreCreatePage");
            Bundle clone = BundleUtils.clone(bundle);
            clone.putAll(this.mStartParams);
            this.mStartParams = clone;
        } catch (Exception e) {
            RVLogger.e(f5961a, "fillStartParamsForPreCreatePage error", e);
        }
    }

    private void a(JSONObject jSONObject) {
        if (getApp() == null || !getApp().isTinyApp() || jSONObject == null || !jSONObject.containsKey("usePresetPopmenu")) {
            return;
        }
        jSONObject.remove("usePresetPopmenu");
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void bindContext(PageContext pageContext) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_bindContext);
        this.mPageContext = pageContext;
        CreateParams createParams = new CreateParams();
        createParams.createUrl = this.c;
        createParams.startParams = getStartParams();
        createParams.useForEmbed = isUseForEmbed();
        createParams.urlVisitListener = new URLVisitListener() { // from class: com.alibaba.ariver.app.PageNode.1
            {
                PageNode.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.model.URLVisitListener
            public DataNode onVisitStart(String str) {
                String str2 = PageNode.f5961a;
                StringBuilder sb = new StringBuilder();
                sb.append("onVisitStart:");
                sb.append(str);
                RVLogger.d(str2, sb.toString());
                VisitNode visitNode = new VisitNode(PageNode.this);
                visitNode.setVisitUrl(str);
                PageNode.this.pushChild(visitNode);
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(visitNode, TrackId.Stub_Visit);
                ((VisitUrlPoint) ExtensionPoint.as(VisitUrlPoint.class).node(PageNode.this).create()).onVisit(visitNode);
                return visitNode;
            }
        };
        createParams.containerHeight = AppUtils.getContainerHeight(pageContext);
        createParams.containerWidth = AppUtils.getContainerWidth(pageContext);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        RVEngine engineProxy = getApp().getEngineProxy();
        if (this.d == null) {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_createRender);
            this.d = a(pageContext, createParams, engineProxy);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_createRender);
        }
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_initRender);
        initRender(engineProxy);
        notifyRenderReady();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_initRender);
        this.s = ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).getScreenOrientation(pageContext.getActivity());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this, TrackId.Cost_NXView_Create, SystemClock.elapsedRealtime() - elapsedRealtime);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_bindContext);
    }

    private Render a(PageContext pageContext, CreateParams createParams, RVEngine rVEngine) {
        Render createRender;
        PageCreateRenderPoint pageCreateRenderPoint = (PageCreateRenderPoint) ExtensionPoint.as(PageCreateRenderPoint.class).node(this).nullable().create();
        if (pageCreateRenderPoint != null && (createRender = pageCreateRenderPoint.createRender(pageContext.getActivity(), this, createParams)) != null) {
            RVLogger.d(f5961a, "createRender hacked by PageCreateRenderPoint!");
            return createRender;
        }
        return rVEngine.createRender(pageContext.getActivity(), this, createParams);
    }

    public void initRender(RVEngine rVEngine) {
        if (!isUseForEmbed()) {
            rVEngine.getEngineRouter().registerRender(this.d.getRenderId(), this.d);
        }
        if (this.e == EmbedType.SHARE) {
            String string = BundleUtils.getString(this.mStartParams, LottieParams.KEY_ELEMENT_ID);
            if (!TextUtils.isEmpty(string)) {
                IEmbedViewManager embedViewManager = getPageContext().getEmbedViewManager();
                if (embedViewManager.findViewById(string) == null) {
                    embedViewManager.createView(string, "web-view-stub");
                }
                this.mSceneParams.putString(RVConstants.EXTRA_EMBED_VIEW_ID, string);
            }
        }
        this.d.init();
    }

    public void notifyRenderReady() {
        synchronized (this.k) {
            this.mRenderReady = true;
            Iterator<Page.RenderReadyListener> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().onRenderReady();
            }
            this.k.clear();
        }
    }

    @Override // com.alibaba.ariver.app.api.Page
    public PageContext getPageContext() {
        return this.mPageContext;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void hide() {
        RVLogger.d(f5961a, "sendToView page event pagePause");
        EngineUtils.sendToRender(getRender(), RVEvents.PAGE_PAUSE, null, null);
        ((PageHidePoint) ExtensionPoint.as(PageHidePoint.class).node(this).create()).onPageHide(this);
        onHide();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void resume() {
        JSONObject jSONObject;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_resume);
        App.PopParams popParams = (App.PopParams) getApp().getData(App.PopParams.class);
        if (popParams != null) {
            jSONObject = new JSONObject();
            jSONObject.put("data", (Object) popParams.data);
            getApp().setData(App.PopParams.class, null);
        } else {
            jSONObject = null;
        }
        ((PageResumePoint) ExtensionPoint.as(PageResumePoint.class).node(this).create()).onPageResume(this);
        EngineUtils.sendToRender(getRender(), "resume", jSONObject, null);
        onResume();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_resume);
    }

    protected void onResume() {
        this.d.onResume();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void show(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
        } else {
            jSONObject2 = null;
        }
        if (!isUseForEmbed()) {
            RVLogger.d(f5961a, "sendToView page event pageResume");
            EngineUtils.sendToRender(getRender(), RVEvents.PAGE_RESUME, jSONObject2, null);
        }
        ((PageShowPoint) ExtensionPoint.as(PageShowPoint.class).node(this).create()).onPageShow(this, null);
        onShow();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void enter() {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageEnter);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(getApp(), this.c, PerfId.pageStart);
        ((PageEnterPoint) ExtensionPoint.as(PageEnterPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.PageNode.2
            {
                PageNode.this = this;
            }

            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(Void r6) {
                String str = PageNode.f5961a;
                StringBuilder sb = new StringBuilder();
                sb.append("page Enter schedule: ");
                sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                RVLogger.d(str, sb.toString());
                PageNode.this.onEnter();
            }
        }).create()).onPageEnter(this);
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_applyStartParam);
        a();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_applyStartParam);
    }

    private void a() {
        Bundle startParams = getStartParams();
        if (startParams == null) {
            return;
        }
        if (getRender() != null && getRender().getView() != null && !ParamUtils.isShowTransAnimate(startParams)) {
            getRender().getView().setBackgroundColor(BundleUtils.getInt(startParams, "backgroundColor"));
        }
        if (getRender() == null || getRender().getView() == null || !ParamUtils.transparentBackground(startParams)) {
            return;
        }
        getRender().getView().setBackgroundColor(BundleUtils.getInt(startParams, "backgroundColor"));
    }

    protected void onEnter() {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_onEnter);
        String str = f5961a;
        StringBuilder sb = new StringBuilder();
        sb.append("onEnter ");
        sb.append(this.c);
        RVLogger.d(str, sb.toString());
        LoadParams loadParams = new LoadParams();
        loadParams.url = this.c;
        loadParams.isFirstLoad = true;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_LoadUrl);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(getApp(), this.c, PerfId.loadUrl);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_FirstRequest);
        if (RVStartParams.START_SCENE_CREATE_PAGE.equals(BundleUtils.getString(getStartParams(), RVStartParams.KEY_START_SCENE)) && this.d.hasTriggeredLoad()) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_onEnter);
            return;
        }
        if (((PageEnterInterceptPoint) ExtensionPoint.as(PageEnterInterceptPoint.class).node(this).create()).interceptLoadMainDoc(this, loadParams)) {
            String str2 = f5961a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("render.load has be intercepted：");
            sb2.append(loadParams);
            RVLogger.d(str2, sb2.toString());
        } else {
            this.d.load(loadParams);
        }
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_onEnter);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setExitListener(Page.ExitListener exitListener) {
        this.f5962o = exitListener;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public int getPageId() {
        return this.n;
    }

    public void setPageId(int i) {
        this.n = i;
    }

    public int generatePageId() {
        return b.addAndGet(1);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isExited() {
        return this.g;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isShadowNode() {
        return this.h;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isPageLoaded() {
        return this.i;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setPageLoaded() {
        this.i = true;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void exit(final boolean z) {
        synchronized (this) {
            if (this.g) {
                RVLogger.w(f5961a, "already exited!");
            } else if (this.h) {
                RVLogger.w(f5961a, "exit with shadowNode!");
                Bundle bundle = new Bundle();
                bundle.putLong(IpcMessageConstants.EXTRA_PAGE_NODE_ID, getNodeId());
                IpcServerUtils.sendMsgToClient(getApp().getAppId(), getApp().getStartToken(), 10, bundle);
            } else {
                ((PageExitInterceptPoint) ExtensionPoint.as(PageExitInterceptPoint.class).node(this).resolve(ResultResolver.POSITIVE_RESOLVER).when(new Action.Complete<Boolean>() { // from class: com.alibaba.ariver.app.PageNode.3
                    {
                        PageNode.this = this;
                    }

                    @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                    public void onComplete(Boolean bool) {
                        if (bool == null || !bool.booleanValue()) {
                            PageNode.this.a(z);
                        } else {
                            RVLogger.d(PageNode.f5961a, "PageExit intercept by extension point.");
                        }
                    }
                }).create()).interceptPageExit(this);
            }
        }
    }

    public void a(final boolean z) {
        String str = f5961a;
        StringBuilder sb = new StringBuilder();
        sb.append("exit ");
        sb.append(toString());
        sb.append(" by stack ");
        sb.append(Log.getStackTraceString(new Throwable("Just Print")));
        RVLogger.d(str, sb.toString());
        this.g = true;
        if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_appContextPerExitPage", "no"))) {
            RVLogger.d(f5961a, "run Exit per exit page.");
            AppContext appContext = getApp().getAppContext();
            if (appContext != null) {
                appContext.exitPage(this, z);
            }
        }
        Render render = this.d;
        if (render != null) {
            render.runExit(new ExitCallback() { // from class: com.alibaba.ariver.app.PageNode.4
                {
                    PageNode.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.bridge.model.ExitCallback
                public void afterProcess(boolean z2) {
                    PageNode.this.b(z);
                }
            });
        } else {
            b(z);
        }
    }

    public void b(final boolean z) {
        String str = f5961a;
        StringBuilder sb = new StringBuilder();
        sb.append("PageNode ");
        sb.append(this);
        sb.append(" doExit!");
        RVLogger.d(str, sb.toString());
        PageContext pageContext = this.mPageContext;
        if (pageContext != null && pageContext.getActivity() != null) {
            if (!TextUtils.equals(this.s, ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).getScreenOrientation(this.mPageContext.getActivity()))) {
                ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).setScreenOrientation(this.mPageContext.getActivity(), this.s, this);
            }
        }
        ((PageExitPoint) ExtensionPoint.as(PageExitPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.PageNode.5
            {
                PageNode.this = this;
            }

            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(Void r3) {
                String str2 = PageNode.f5961a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PageNode ");
                sb2.append(PageNode.this);
                sb2.append(" doExit onComplete");
                RVLogger.d(str2, sb2.toString());
                if (PageNode.this.isUseForEmbed()) {
                    PageNode.this.destroy();
                    PageNode.this.onFinalized();
                    return;
                }
                if (PageNode.this.getApp() != null) {
                    PageNode.this.getApp().removePage(PageNode.this, z);
                }
                if (PageNode.this.f5962o != null) {
                    PageNode.this.f5962o.onExit();
                }
            }
        }).create()).onPageExit(this);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean backPressed() {
        Render render;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_BACK_PRESSED);
        PageContext pageContext = this.mPageContext;
        if ((pageContext == null || pageContext.getLoadingView() == null || !this.mPageContext.getLoadingView().backPressed()) && (render = this.d) != null) {
            render.goBack(new GoBackCallback() { // from class: com.alibaba.ariver.app.PageNode.6
                {
                    PageNode.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.bridge.model.GoBackCallback
                public void afterProcess(final boolean z) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.PageNode.6.1
                        {
                            AnonymousClass6.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (PageNode.this.getApp() == null) {
                                RVLogger.d(PageNode.f5961a, "goBack afterProcess but app is null!");
                                return;
                            }
                            boolean booleanValue = PageNode.this.getApp().getBooleanValue(RVConstants.EXTRA_RECEIVED_PREPARE_FINISH);
                            String str = PageNode.f5961a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("goBack afterProcess intercept: ");
                            sb.append(z);
                            sb.append(", receivedPrepareFinish: ");
                            sb.append(booleanValue);
                            RVLogger.d(str, sb.toString());
                            if (!z && booleanValue) {
                                AppContext appContext = PageNode.this.getApp().getAppContext();
                                if (PageNode.this.getApp().getChildCount() == 1 && appContext != null && appContext.getContext() != null && appContext.isTaskRoot() && appContext.moveToBackground()) {
                                    RVLogger.d(PageNode.f5961a, "goBack keep alive intercept");
                                    return;
                                }
                            }
                            if (z || PageNode.this.j) {
                                return;
                            }
                            PageNode.this.performBack();
                        }
                    });
                }
            });
        }
        return true;
    }

    protected void performBack() {
        synchronized (this) {
            this.j = true;
            ((PageBackPoint) ExtensionPoint.as(PageBackPoint.class).node(this).create()).onBackPerformed(this);
            getApp().performBack();
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class<? extends Scope> getScopeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void pause() {
        ((PagePausePoint) ExtensionPoint.as(PagePausePoint.class).node(this).create()).onPagePause(this);
        EngineUtils.sendToRender(getRender(), "pause", null, null);
        onPause();
    }

    protected void onPause() {
        RVLogger.d(f5961a, "onPause");
        this.d.onPause();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isDestroyed() {
        return this.f;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void destroy() {
        if (this.f) {
            return;
        }
        if (this.h) {
            RVLogger.w(f5961a, "destroy with shadowNode!");
            Bundle bundle = new Bundle();
            bundle.putLong(IpcMessageConstants.EXTRA_PAGE_NODE_ID, getNodeId());
            IpcServerUtils.sendMsgToClient(getApp().getAppId(), getApp().getStartToken(), 10, bundle);
            return;
        }
        this.f = true;
        if (this.d != null && getApp().getEngineProxy() != null) {
            getApp().getEngineProxy().getEngineRouter().unRegisterRender(this.d.getRenderId());
        }
        ((PageDestroyPoint) ExtensionPoint.as(PageDestroyPoint.class).node(this).create()).onPageDestroy(this);
        EngineUtils.sendToRender(getRender(), RVEvents.BEFORE_UNLOAD, null, null);
        EngineUtils.sendToRender(getRender(), RVEvents.BEFORE_DESTROY, null, null);
        T2PageInfo t2PageInfo = (T2PageInfo) getData(T2PageInfo.class, false);
        if (t2PageInfo != null && t2PageInfo.isPageT2Switch() && this.d != null) {
            CollectPerformancePoint collectPerformancePoint = (CollectPerformancePoint) ExtensionPoint.as(CollectPerformancePoint.class).node(this).create();
            if (collectPerformancePoint != null) {
                collectPerformancePoint.onCollectWhenDestroy(this, new CollectPerformanceCallback() { // from class: com.alibaba.ariver.app.PageNode.7
                    {
                        PageNode.this = this;
                    }

                    @Override // com.alibaba.ariver.app.api.point.view.CollectPerformanceCallback
                    public void afterProcess() {
                        String str = PageNode.f5961a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("androidT2 page render destroy cause by collectT2 callback,androidT2AppId");
                        sb.append(PageNode.this.getApp().getAppId());
                        RVLogger.d(str, sb.toString());
                        PageNode.this.b();
                    }
                });
                return;
            }
            String str = f5961a;
            StringBuilder sb = new StringBuilder();
            sb.append("androidT2 page render destroy cause by collectT2 callback but collectPerformancePoint is null,androidT2AppId");
            sb.append(getApp().getAppId());
            RVLogger.d(str, sb.toString());
            b();
            return;
        }
        String str2 = f5961a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("androidT2 page render destroy cause by normal,androidT2AppId");
        sb2.append(getApp().getAppId());
        RVLogger.d(str2, sb2.toString());
        b();
    }

    public void b() {
        Render render = this.d;
        if (render != null) {
            render.destroy();
        }
        PageContext pageContext = this.mPageContext;
        if (pageContext != null) {
            pageContext.destroy();
        }
        onDestroy();
        onFinalized();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isRenderReady() {
        boolean z;
        synchronized (this.k) {
            z = this.mRenderReady;
        }
        return z;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void addRenderReadyListener(Page.RenderReadyListener renderReadyListener) {
        if (this.mRenderReady) {
            renderReadyListener.onRenderReady();
            return;
        }
        synchronized (this.k) {
            if (this.mRenderReady) {
                renderReadyListener.onRenderReady();
            } else {
                this.k.add(renderReadyListener);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isJsBridgeReady() {
        boolean z;
        synchronized (this.m) {
            z = this.l;
        }
        return z;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setJsBridgeReady() {
        if (this.l) {
            return;
        }
        synchronized (this.m) {
            this.l = true;
            Iterator<Page.JsBridgeReadyListener> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onJsBridgeReady();
            }
            this.m.clear();
        }
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void addJsBridgeReadyListener(Page.JsBridgeReadyListener jsBridgeReadyListener) {
        if (this.l) {
            jsBridgeReadyListener.onJsBridgeReady();
            return;
        }
        synchronized (this.m) {
            if (this.l) {
                jsBridgeReadyListener.onJsBridgeReady();
            } else {
                this.m.add(jsBridgeReadyListener);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.Page
    public EmbedType getEmbedType() {
        return this.e;
    }

    public void setEmbedType(EmbedType embedType) {
        this.e = embedType;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isUseForEmbed() {
        return this.e == EmbedType.FULL || this.e == EmbedType.MINI;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public ExtensionManager getExtensionManager() {
        return sExtensionManager;
    }

    public String toString() {
        int hashCode = hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(hashCode);
        sb.append("@uri=");
        sb.append(getPageURI());
        String obj = sb.toString();
        if (this.h) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append("@Shadow");
            obj = sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("@instance=");
        sb3.append(getInstanceType());
        return sb3.toString();
    }

    public PageNode(Parcel parcel) {
        super(parcel);
        this.e = EmbedType.NO;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = new ArrayList();
        this.m = new ArrayList();
        this.r = true;
        this.c = parcel.readString();
        this.mStartParams = parcel.readBundle(Page.class.getClassLoader());
        this.mSceneParams = parcel.readBundle(Page.class.getClassLoader());
        this.e = EmbedType.parse(parcel.readInt());
        this.h = true;
    }

    @Override // com.alibaba.ariver.app.NodeInstance, com.alibaba.ariver.kernel.api.node.Node
    public void onFinalized() {
        synchronized (this) {
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    getChildAt(i).onFinalized();
                }
            }
            super.onFinalized();
        }
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        a(parcel);
        parcel.writeBundle(this.mSceneParams);
        parcel.writeInt(this.e.getTypeValue());
    }

    private void a(Parcel parcel) {
        JSONArray parseArray = JSONUtils.parseArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_filterStartParamsOnParcel", null));
        if (parseArray != null && !parseArray.isEmpty()) {
            Bundle bundle = (Bundle) this.mStartParams.clone();
            AppUtils.filterBundleKey(bundle, parseArray);
            parcel.writeBundle(bundle);
            return;
        }
        parcel.writeBundle(this.mStartParams);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Page getEmbedPage() {
        return this.p;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setEmbedPage(Page page) {
        this.p = page;
    }

    public void setPageURI(String str) {
        this.c = str;
    }
}
