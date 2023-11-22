package com.alibaba.ariver.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppInteractionPoint;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint;
import com.alibaba.ariver.app.api.point.page.prerender.PagePreRenderInitPoint;
import com.alibaba.ariver.app.api.ui.DialogService;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.extensions.UnlockWorkerPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.Action;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableBundle;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogContext;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.PageSource;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class AppNode extends NodeInstance implements App {
    public static final Parcelable.Creator<AppNode> CREATOR = new Parcelable.Creator<AppNode>() { // from class: com.alibaba.ariver.app.AppNode.12
        @Override // android.os.Parcelable.Creator
        public final AppNode createFromParcel(Parcel parcel) {
            return new AppNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AppNode[] newArray(int i) {
            return new AppNode[i];
        }
    };

    /* renamed from: a */
    private String f5956a;
    protected String appId;
    private Callable<Boolean> b;
    private boolean c;
    private boolean d;
    private boolean e;
    private Object f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private PageNode k;
    private boolean l;
    private AtomicInteger m;
    protected AppUIContext mAppContext;
    protected AppManager mAppManager;
    protected String mAppType;
    protected String mAppVersion;
    protected ImmutableBundle mImmutableStartParams;
    protected Bundle mSceneParams;
    protected Bundle mStartParams;
    protected long mStartToken;
    private String n;

    /* renamed from: o */
    private RVEngine f5957o;
    private AtomicBoolean p;
    protected JSONArray pageLinks;
    private IpcMessageHandler q;
    private Object r;
    private boolean s;
    private final List<App.PageReadyListener> t;
    private NetworkUtil.NetworkListener u;

    public AppNode(AppManager appManager) {
        super(appManager);
        this.pageLinks = new JSONArray();
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new Object();
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = false;
        this.m = new AtomicInteger(2);
        this.p = new AtomicBoolean(false);
        this.r = new Object();
        this.s = false;
        this.t = new ArrayList();
        this.mAppManager = appManager;
        this.q = createAppMsgReceiver();
    }

    protected AppMsgReceiver createAppMsgReceiver() {
        return new AppMsgReceiver(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public IpcMessageHandler getMsgHandler() {
        return this.q;
    }

    public SplashView getSplashView() {
        AppUIContext appUIContext = this.mAppContext;
        if (appUIContext != null) {
            return appUIContext.getSplashView();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public RVEngine getEngineProxy() {
        return this.f5957o;
    }

    @Override // com.alibaba.ariver.app.api.App
    public long getStartToken() {
        return this.mStartToken;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void bindContext(AppContext appContext) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_bindContext);
        try {
            RVLogger.d("AriverApp:App", "bindContext.....");
            this.mAppContext = (AppUIContext) appContext;
            ClientMsgReceiver.getInstance().registerAppHandler(this);
            if (isExited()) {
                RVLogger.w("AriverApp:App", "bindContext but already exit in AppMsgReceiver!");
            } else {
                a();
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_bindContext_trySetProxyAndStart);
                synchronized (this.r) {
                    a(this.mAppType);
                }
                RVLogger.d("AriverApp:App", "bindContext ready, try trigger onStart!");
                c();
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext_trySetProxyAndStart);
            }
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext);
        }
    }

    private void a() {
        JSONArray jSONArray;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null || (jSONArray = JSONUtils.getJSONArray(rVConfigService.getConfigJSONObject("h5_jsapiandPluginsConfig"), "extensions", null)) == null) {
            return;
        }
        getExtensionManager().getExtensionRegistry().unRegister(Arrays.asList(jSONArray.toArray(new String[0])));
    }

    public void preCreateInit(String str, Bundle bundle, Bundle bundle2) {
        this.appId = str;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        this.mStartToken = BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L);
        this.mImmutableStartParams = new ImmutableBundle(this.mStartParams);
        this.mAppType = bundle2.getString("appType", "WEB_TINY");
        ParamUtils.unifyAll(this.mStartParams, false);
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mSceneParams, RVConstants.EXTRA_ENTRY_INFO);
        if (entryInfo != null) {
            setData(EntryInfo.class, entryInfo);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void init(String str, Bundle bundle, Bundle bundle2) {
        setInstanceType(MultiInstanceUtils.getInstanceTypeFromParam(bundle));
        this.appId = str;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        this.mStartToken = BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L);
        this.mImmutableStartParams = new ImmutableBundle(this.mStartParams);
        this.mAppType = bundle2.getString("appType", "WEB_TINY");
        ParamUtils.unifyAll(this.mStartParams, false);
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mSceneParams, RVConstants.EXTRA_ENTRY_INFO);
        if (entryInfo != null) {
            setData(EntryInfo.class, entryInfo);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("init with appType: ");
        sb.append(this.mAppType);
        RVLogger.d("AriverApp:App", sb.toString());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_AppInit);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init("RV_APP_STARTUP", str, Long.valueOf(this.mStartToken), getStartUrl());
        this.l = true;
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void restartFromServer(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("startParams", bundle);
        IpcClientUtils.sendMsgToServerByApp(this, 8, bundle2);
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void restart(final Bundle bundle, final Bundle bundle2) {
        if (this.h) {
            RVLogger.w("AriverApp:App", "restart with shadowNode not work!");
        } else if (this.s) {
            RVLogger.w("AriverApp:App", "cannot restart during restarting");
        } else {
            ParamUtils.unify(bundle, "url", false);
            String string = BundleUtils.getString(bundle, "url");
            if (!isTinyApp()) {
                if (TextUtils.isEmpty(string)) {
                    RVLogger.d("AriverApp:App", "not restart because of url == null in h5");
                    return;
                }
                ParamUtils.unify(bundle, RVParams.LONG_CAN_DESTROY, false);
                if (!BundleUtils.getBoolean(bundle, RVParams.LONG_CAN_DESTROY, true)) {
                    RVLogger.d("AriverApp:App", "not restart because of canDestroy == false in h5");
                    return;
                }
            }
            this.s = true;
            this.i = true;
            this.f5956a = BundleUtils.getString(bundle, RVParams.START_APP_SESSION_ID);
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_CONTAINER_AWAKE).setAppId(this.appId).setDesc(bundle == null ? "" : bundle.toString()).setParentId(this.f5956a).build());
            AppRestartResult appRestartResult = new AppRestartResult();
            appRestartResult.startUrl = string;
            appRestartResult.closeAllWindow = false;
            appRestartResult.canRestart = true;
            appRestartResult.startParam = bundle;
            try {
                this.mStartParams.putBundle(RVStartParams.KEY_RESTART_START_PARAMS, bundle);
            } catch (Exception e) {
                RVLogger.w("AriverApp:App", "putParams restart start params error!", e);
            }
            ((AppRestartPoint) ExtensionPoint.as(AppRestartPoint.class).node(this).defaultValue(appRestartResult).when(new Action.Complete<AppRestartResult>() { // from class: com.alibaba.ariver.app.AppNode.1
                {
                    AppNode.this = this;
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(AppRestartResult appRestartResult2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("restart with ");
                    sb.append(appRestartResult2);
                    RVLogger.d("AriverApp:App", sb.toString());
                    if (appRestartResult2 != null && appRestartResult2.canRestart) {
                        AppNode.this.onRestart(appRestartResult2, appRestartResult2.startParam, bundle2);
                        return;
                    }
                    AppNode.this.onRestart(appRestartResult2, bundle, bundle2);
                    AppNode.this.s = false;
                }
            }).create()).onAppRestart(this, bundle, bundle2);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isTinyApp() {
        return "WEB_TINY".equalsIgnoreCase(getAppType());
    }

    protected void onRestart(final AppRestartResult appRestartResult, Bundle bundle, Bundle bundle2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onRestart);
        StringBuilder sb = new StringBuilder();
        sb.append("onRestart with ");
        sb.append(appRestartResult);
        RVLogger.d("AriverApp:App", sb.toString());
        if (getAppContext() == null) {
            return;
        }
        try {
            this.mStartParams.putString("url", appRestartResult.startUrl);
            if (bundle != null) {
                this.mStartParams.putAll(bundle);
            }
            this.mStartParams.putString("enablePolyfillWorker", SummaryActivity.CHECKED);
            if (bundle2 != null) {
                this.mSceneParams.putAll(bundle2);
            }
            this.mImmutableStartParams = new ImmutableBundle(appRestartResult.startParam);
            this.d = true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll(BundleUtils.toJSONObject(bundle));
            if (appRestartResult.canRestart) {
                jSONObject.put("shouldNotReLaunch", (Object) Boolean.TRUE);
            }
            jSONObject.put("isAliveStartup", (Object) Boolean.TRUE);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("send appResume with data: ");
            sb2.append(jSONObject);
            RVLogger.d("AriverApp:App", sb2.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            jSONObject2.put("isAliveStartup", (Object) Boolean.TRUE);
            AppUtils.sendToApp(this, RVEvents.APP_RESUME, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.ariver.app.AppNode.2
                {
                    AppNode.this = this;
                }

                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                public void onCallBack(JSONObject jSONObject3) {
                    if (!appRestartResult.canRestart || !AppNode.this.isTinyApp()) {
                        AppNode.this.s = false;
                        return;
                    }
                    if (jSONObject3 != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("resume onCallback: ");
                        sb3.append(jSONObject3);
                        RVLogger.d("AriverApp:App", sb3.toString());
                    }
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.2.1
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str = appRestartResult.startUrl;
                            Bundle clone = BundleUtils.clone(AppNode.this.getStartParams());
                            clone.putString(RVStartParams.KEY_FROM_TYPE, RVStartParams.FROM_TYPE_PUSH_RELAUNCH);
                            Bundle clone2 = BundleUtils.clone(AppNode.this.getSceneParams());
                            if (appRestartResult.closeAllWindow) {
                                AppNode.this.relaunchToUrl(str, clone, clone2);
                            } else {
                                AppNode.this.pushPage(str, clone, clone2);
                            }
                            AppNode.this.s = false;
                        }
                    });
                }
            });
            if (!isTinyApp()) {
                relaunchToUrl(appRestartResult.startUrl, BundleUtils.clone(getStartParams()), bundle2);
                return;
            }
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onRestart);
        } catch (Throwable th) {
            RVLogger.w("AriverApp:App", "putParams error! not restart", th);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void relaunchToUrl(String str, Bundle bundle, Bundle bundle2) {
        if (this.h) {
            RVLogger.w("AriverApp:App", "relaunchToUrl with shadowNode not work!");
        } else if (isExited()) {
            RVLogger.w("AriverApp:App", "relaunchToUrl failed because already exited!");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("relaunchToUrl ");
            sb.append(str);
            sb.append(" with stack: ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print")));
            RVLogger.d("AriverApp:App", sb.toString());
            if (getActivePage() != null) {
                String pageURI = getActivePage().getPageURI();
                if (str.startsWith("#")) {
                    int indexOf = pageURI.indexOf(35);
                    if (indexOf != -1) {
                        String substring = pageURI.substring(0, indexOf);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(substring);
                        sb2.append(str);
                        str = sb2.toString();
                    }
                } else {
                    str = UrlUtils.mergeUrl(pageURI, str);
                }
            }
            if (!isTinyApp() && !TextUtils.isEmpty(str) && str.startsWith("/")) {
                AppModel appModel = (AppModel) getData(AppModel.class);
                if (appModel == null) {
                    RVLogger.d("AriverApp:App", "relaunchToUrl but not put appModel! get from DB now.");
                    appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(this.appId).scene(AppInfoScene.extractScene(bundle)));
                    bundle2.putParcelable("appInfo", appModel);
                }
                if (appModel != null) {
                    str = FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), str);
                }
            }
            a(false);
            pushPage(str, bundle, bundle2);
            this.s = false;
        }
    }

    private void a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("exitAllPages: ");
        sb.append(z);
        RVLogger.w("AriverApp:App", sb.toString());
        int i = 0;
        if (getAppContext() != null && ((AppUIContext) getAppContext()).getTabBar() != null) {
            TabBar tabBar = ((AppUIContext) getAppContext()).getTabBar();
            int childCount = getChildCount();
            ArrayList arrayList = new ArrayList();
            while (i < childCount) {
                Page pageByIndex = getPageByIndex(i);
                ((Page.AnimStore) pageByIndex.getData(Page.AnimStore.class, true)).disableExit = true;
                if (!tabBar.isTabPage(pageByIndex)) {
                    arrayList.add(pageByIndex);
                }
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Page) it.next()).exit(z);
            }
            ((AppUIContext) getAppContext()).getTabBar().reset();
            return;
        }
        int childCount2 = getChildCount();
        ArrayList arrayList2 = new ArrayList();
        while (i < childCount2) {
            Page pageByIndex2 = getPageByIndex(i);
            ((Page.AnimStore) pageByIndex2.getData(Page.AnimStore.class, true)).disableExit = true;
            arrayList2.add(pageByIndex2);
            i++;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((Page) it2.next()).exit(z);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppType() {
        return this.mAppType;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void setAppType(String str) {
        this.mAppType = str;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppId() {
        return this.appId;
    }

    public ImmutableBundle getOriginalStartParams() {
        return this.mImmutableStartParams;
    }

    public AppManager getAppManager() {
        return this.mAppManager;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getStartParams() {
        return this.mStartParams;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByNodeId(long j) {
        return (Page) getChild(j);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void addPageReadyListener(App.PageReadyListener pageReadyListener) {
        synchronized (this.t) {
            RVLogger.d("AriverApp:App", "addPageReadyListener");
            Page activePage = getActivePage();
            if (activePage != null) {
                pageReadyListener.onPageReady(activePage);
            } else {
                this.t.add(pageReadyListener);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByIndex(int i) {
        return (Page) getChildAt(i);
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page preCreatePage() {
        PageNode createPage = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, this.j, BundleUtils.clone(this.mStartParams), BundleUtils.clone(this.mSceneParams));
        this.k = createPage;
        return createPage;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getActivePage() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (!pageByIndex.isUseForEmbed() && !pageByIndex.isExited()) {
                return pageByIndex;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public int getAlivePageCount() {
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (getPageByIndex(i).isExited()) {
                childCount--;
            }
        }
        return childCount;
    }

    @Override // com.alibaba.ariver.app.api.App
    public AppContext getAppContext() {
        return this.mAppContext;
    }

    public void setEngineProxy(RVEngine rVEngine) {
        this.f5957o = rVEngine;
    }

    private void a(String str) {
        if (this.f5957o != null && TextUtils.equals(str, this.mAppType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("trySetupEngineProxy already setup with ");
            sb.append(str);
            RVLogger.d("AriverApp:App", sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("trySetupEngineProxy with appType: ");
        sb2.append(str);
        RVLogger.d("AriverApp:App", sb2.toString());
        String engineType = ((EngineFactory) RVProxy.get(EngineFactory.class)).getEngineType(str);
        putStringValue(RVParams.APP_ENGINE_TYPE, engineType);
        if (this.mAppContext == null) {
            RVLogger.d("AriverApp:App", "trySetupEngineProxy cannot init without appContext!");
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        RVEngine createEngine = ((EngineFactory) RVProxy.get(EngineFactory.class)).createEngine(engineType, this, this.appId);
        this.f5957o = createEngine;
        if (createEngine == null) {
            RVLogger.e("AriverApp:App", "mEngineProxy == null !!!");
            return;
        }
        if (!createEngine.isReady() && getSplashView() != null) {
            RVLogger.d("AriverApp:App", "showLoading because engine not ready");
            getSplashView().showLoading((EntryInfo) getData(EntryInfo.class, false));
        }
        this.f5957o.setup(this.mStartParams, this.mSceneParams, new EngineSetupCallback() { // from class: com.alibaba.ariver.app.AppNode.3
            {
                AppNode.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback
            public void setupResult(boolean z, String str2) {
                if (z) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onSetupFinish, cost=");
                    sb3.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                    RVLogger.d("AriverApp:App", sb3.toString());
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_EngineSetup);
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("onSetupFail, msg=");
                sb4.append(str2);
                RVLogger.d("AriverApp:App", sb4.toString());
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void start() {
        synchronized (this.f) {
            if (this.e) {
                RVLogger.d("AriverApp:App", "try start but mAlreadyStarted true!");
                return;
            }
            this.e = true;
            b();
        }
    }

    private void b() {
        synchronized (this) {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_start);
            AppLog.Builder appId = new AppLog.Builder().setAppId(this.appId);
            Bundle bundle = this.mStartParams;
            AppLogger.log(appId.setDesc(bundle == null ? "" : bundle.toString()).setParentId(BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID)).setState(AppLog.APP_LOG_CONTAINER_START).build());
            StringBuilder sb = new StringBuilder();
            sb.append("start ");
            sb.append(this.appId);
            RVLogger.d("AriverApp:App", sb.toString());
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            ((AppLoadPoint) ExtensionPoint.as(AppLoadPoint.class).node(this).create()).loadApp(this.appId, getStartParams(), getSceneParams(), new AppLoadPoint.LoadResultCallback() { // from class: com.alibaba.ariver.app.AppNode.4
                {
                    AppNode.this = this;
                }

                @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint.LoadResultCallback
                public void onResult(AppLoadResult appLoadResult) {
                    RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_AppLoadPointOnResult);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("loadApp onResult ");
                    sb2.append(AppNode.this.appId);
                    sb2.append(" result ");
                    sb2.append(appLoadResult);
                    sb2.append(" cost ");
                    sb2.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                    RVLogger.d("AriverApp:App", sb2.toString());
                    ((AppOnLoadResultPoint) ExtensionPoint.as(AppOnLoadResultPoint.class).node(AppNode.this).create()).onLoadResult(AppNode.this, appLoadResult);
                    AppNode.this.a(appLoadResult, elapsedRealtime);
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_AppLoadPointOnResult);
                }
            });
            AppLogger.log(new AppLog.Builder().setAppId(this.appId).setParentId(BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID)).setState(AppLog.APP_LOG_CONTAINER_FINISH).build());
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_start);
        }
    }

    public void a(AppLoadResult appLoadResult, long j) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onLoadResult);
            synchronized (this.r) {
                if (!TextUtils.equals(appLoadResult.appType, this.mAppType)) {
                    this.f5957o = null;
                    this.mAppType = appLoadResult.appType;
                }
                a(appLoadResult.appType);
            }
            this.n = appLoadResult.mainJsUrl;
            this.j = appLoadResult.mainHtmlUrl;
            this.mAppVersion = appLoadResult.appVersion;
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PkgLoad);
            ((EventTracker) RVProxy.get(EventTracker.class)).cost(this, TrackId.Stub_PkgLoad, SystemClock.elapsedRealtime() - j);
            if (this.p.get()) {
                RVLogger.d("AriverApp:App", "app has been destroyed!");
            } else {
                this.b = appLoadResult.waitLoadFuture;
                RVLogger.d("AriverApp:App", "onLoadResult ready, try trigger onStart!");
                c();
            }
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onLoadResult);
        }
    }

    protected void preProcessStartParams() {
        try {
            AppModel appModel = (AppModel) BundleUtils.getParcelable(getSceneParams(), "appInfo");
            if (getStartParams().containsKey("backBehavior")) {
                return;
            }
            if (appModel != null) {
                getStartParams().putString("backBehavior", RVStartParams.BACK_BEHAVIOR_POP);
            } else {
                getStartParams().putString("backBehavior", "back");
            }
        } catch (Exception e) {
            RVLogger.e("AriverApp:App", " pre process start params error, ex =", e);
        }
    }

    private void c() {
        if (this.m.decrementAndGet() <= 0) {
            onStart();
        }
    }

    protected void onStart() {
        RVEngine rVEngine = this.f5957o;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onStart);
        StringBuilder sb = new StringBuilder();
        sb.append("onStart:");
        sb.append(this.j);
        RVLogger.d("AriverApp:App", sb.toString());
        preProcessStartParams();
        InitParams initParams = new InitParams();
        initParams.mainResourceUrl = this.n;
        initParams.startParams = this.mStartParams;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_AppStart);
        RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appPhase_waitLoadApp);
        RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_createPage);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(this, getStartUrl(), PerfId.appStart);
        this.mStartParams.putString("enablePolyfillWorker", SummaryActivity.CHECKED);
        this.mStartParams.putBoolean(RVStartParams.KEY_DISCARD_CAN_RENDER, true);
        ((UnlockWorkerPoint) ExtensionPoint.as(UnlockWorkerPoint.class).node(this).create()).unlockWorker();
        RVLogger.printPerformanceLog("App", "End create app");
        if (rVEngine == null || rVEngine.isDestroyed()) {
            RVLogger.e("AriverApp:App", "engine is null or isDestroyed!");
            return;
        }
        final PageNode pageNode = null;
        boolean equals = TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_disable_pre_create_page", null), "yes");
        PageNode pageNode2 = this.k;
        if (pageNode2 != null) {
            pageNode2.setPageURI(this.j);
            Bundle startParams = this.k.getStartParams();
            if (startParams != null) {
                startParams.putString("url", this.j);
            }
            pageNode = this.k;
        } else if (!equals) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ahead createPage ");
            sb2.append(this.j);
            RVLogger.d("AriverApp:App", sb2.toString());
            Bundle clone = BundleUtils.clone(this.mStartParams);
            Bundle clone2 = BundleUtils.clone(this.mSceneParams);
            PagePushInterceptPoint pagePushInterceptPoint = (PagePushInterceptPoint) ExtensionPoint.as(PagePushInterceptPoint.class).node(this).nullable().create();
            if (pagePushInterceptPoint != null) {
                String interceptPushPage = pagePushInterceptPoint.interceptPushPage(this, this.j, clone);
                if (!TextUtils.isEmpty(interceptPushPage)) {
                    this.j = interceptPushPage;
                }
            }
            pageNode = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, this.j, clone, clone2);
        }
        this.f5957o.init(initParams, new EngineInitCallback() { // from class: com.alibaba.ariver.app.AppNode.5
            {
                AppNode.this = this;
            }

            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback
            public void initResult(boolean z, String str) {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitResult);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("EngineInitCallback initResult success: ");
                sb3.append(z);
                RVLogger.d("AriverApp:App", sb3.toString());
                if (!z) {
                    AppNode.this.b(pageNode);
                } else {
                    RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_waitEngineInit);
                    RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_postToMain);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_EngineInit);
                    RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
                    AppNode appNode = AppNode.this;
                    rVPerformanceTracker.track(appNode, appNode.getStartUrl(), PerfId.engineInit);
                    AppNode.this.a(pageNode);
                }
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitResult);
            }
        });
        RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onStart);
    }

    /* renamed from: com.alibaba.ariver.app.AppNode$6 */
    /* loaded from: classes6.dex */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ PageNode val$preCreatePage;

        AnonymousClass6(PageNode pageNode) {
            AppNode.this = r1;
            this.val$preCreatePage = pageNode;
        }

        @Override // java.lang.Runnable
        public void run() {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitSuccess);
            ((EngineInitSuccessPoint) ExtensionPoint.as(EngineInitSuccessPoint.class).node(AppNode.this).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.6.1
                {
                    AnonymousClass6.this = this;
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Void r1) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.6.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_postToMain);
                                RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_pageStart);
                                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitSuccessPointOnComplete);
                                if (AppNode.this.p.get()) {
                                    RVLogger.d("AriverApp:App", "app has been destroyed!");
                                    return;
                                }
                                PageNode pageNode = AnonymousClass6.this.val$preCreatePage;
                                if (pageNode == null) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("normal createPage ");
                                    sb.append(AppNode.this.j);
                                    RVLogger.d("AriverApp:App", sb.toString());
                                    Bundle clone = BundleUtils.clone(AppNode.this.mStartParams);
                                    Bundle clone2 = BundleUtils.clone(AppNode.this.mSceneParams);
                                    PagePushInterceptPoint pagePushInterceptPoint = (PagePushInterceptPoint) ExtensionPoint.as(PagePushInterceptPoint.class).node(AppNode.this).nullable().create();
                                    if (pagePushInterceptPoint != null) {
                                        String interceptPushPage = pagePushInterceptPoint.interceptPushPage(AppNode.this, AppNode.this.j, clone);
                                        if (!TextUtils.isEmpty(interceptPushPage)) {
                                            AppNode.this.j = interceptPushPage;
                                        }
                                    }
                                    pageNode = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(AppNode.this, AppNode.this.j, clone, clone2);
                                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(pageNode, TrackId.Attr_isPreCreatePage, "0");
                                } else {
                                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(pageNode, TrackId.Attr_isPreCreatePage, "1");
                                    pageNode.fillStartParamsForPreCreatePage(AppNode.this.mStartParams);
                                }
                                PageSource pageSource = ((AppLogContext) pageNode.getData(AppLogContext.class, true)).getPageSource();
                                pageSource.sourceType = PageSource.SourceType.START_APP;
                                pageSource.sourcePageAppLogToken = BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_SOURCE_PAGE_APP_LOG_TOKEN);
                                String string = BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_START_APP_SOURCE_ID);
                                String string2 = BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_CHINFO);
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(" appId: ");
                                sb2.append(string);
                                sb2.append(" chinfo: ");
                                sb2.append(string2);
                                pageSource.sourceDesc = sb2.toString();
                                AppNode.this.pushChild(pageNode);
                                ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_PageInit);
                                ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(AppNode.this, AppNode.this.getStartUrl(), PerfId.pageInit);
                                AppNode.this.mAppContext.start(pageNode);
                                AppNode.this.onPageStarted(pageNode);
                            } finally {
                                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitSuccessPointOnComplete);
                            }
                        }
                    });
                }
            }).create()).onInitSuccess();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitSuccess);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.alibaba.ariver.app.PageNode r5) {
        /*
            r4 = this;
            com.alibaba.ariver.app.AppNode$6 r0 = new com.alibaba.ariver.app.AppNode$6
            r0.<init>(r5)
            java.util.concurrent.Callable<java.lang.Boolean> r5 = r4.b
            java.lang.String r1 = "AriverApp:App"
            if (r5 == 0) goto L1e
            java.lang.Object r5 = r5.call()     // Catch: java.lang.Exception -> L18
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Exception -> L18
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Exception -> L18
            r5 = r5 ^ 1
            goto L1f
        L18:
            r5 = move-exception
            java.lang.String r2 = "onEngineInitSuccess get waitLoadFuture exception!"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r2, r5)
        L1e:
            r5 = 0
        L1f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onEngineInitSuccess startPageAsync: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r2)
            if (r5 == 0) goto L3b
            com.alibaba.ariver.kernel.common.service.executor.ExecutorType r5 = com.alibaba.ariver.kernel.common.service.executor.ExecutorType.URGENT_DISPLAY
            com.alibaba.ariver.kernel.common.utils.ExecutorUtils.execute(r5, r0)
            return
        L3b:
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.AppNode.a(com.alibaba.ariver.app.PageNode):void");
    }

    protected void onPageStarted(Page page) {
        if (this.mAppContext == null) {
            return;
        }
        RVLogger.d("AriverApp:App", "onPageStarted");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.t) {
            Iterator<App.PageReadyListener> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().onPageReady(page);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onPageStarted flush pageReadyListener size: ");
            sb.append(this.t.size());
            sb.append(" cost: ");
            sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
            RVLogger.d("AriverApp:App", sb.toString());
            this.t.clear();
        }
        if (this.mAppContext == null) {
            return;
        }
        this.u = new NetworkUtil.NetworkListener() { // from class: com.alibaba.ariver.app.AppNode.7
            {
                AppNode.this = this;
            }

            @Override // com.alibaba.ariver.kernel.common.network.NetworkUtil.NetworkListener
            public void onNetworkChanged(NetworkUtil.Network network, NetworkUtil.Network network2) {
                AppNode.this.a(network2);
            }
        };
        NetworkUtil.addListener(this.mAppContext.getContext(), this.u);
    }

    public void a(NetworkUtil.Network network) {
        Page activePage = getActivePage();
        if (activePage == null || activePage.getRender() == null) {
            return;
        }
        String transferNetworkType = NetworkUtil.transferNetworkType(network);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isConnected", (Object) Boolean.valueOf(!"none".equals(transferNetworkType)));
        jSONObject.put("networkType", (Object) transferNetworkType);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        EngineUtils.sendToRender(activePage.getRender(), RVEvents.NETWORK_CHANGE, jSONObject2, null);
    }

    public void b(final PageNode pageNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("onEngineInitFailed! type: ");
        sb.append(getAppType());
        RVLogger.d("AriverApp:App", sb.toString());
        this.e = false;
        ((EventTracker) RVProxy.get(EventTracker.class)).error(this, "EngineInitFail", null);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(getActivePage(), ErrId.RV_TYPE_APP_PREPARE_ERROR, "EngineInitFail", "", null, null);
        if (this.p.get()) {
            RVLogger.d("AriverApp:App", "app has been destroyed!");
            return;
        }
        ((EngineInitFailedPoint) ExtensionPoint.as(EngineInitFailedPoint.class).node(this).defaultValue(EngineInitFailedPoint.Action.IGNORE).resolve(EngineInitFailedPoint.RESULT_RESOLVER).when(new Action.Complete<EngineInitFailedPoint.Action>() { // from class: com.alibaba.ariver.app.AppNode.8
            {
                AppNode.this = this;
            }

            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(EngineInitFailedPoint.Action action) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("EngineInitFailedPoint got result: ");
                sb2.append(action);
                RVLogger.d("AriverApp:App", sb2.toString());
                int i = AnonymousClass13.$SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[action.ordinal()];
                if (i == 1) {
                    AppNode.this.a(pageNode);
                } else if (i == 2) {
                    AppNode.this.start();
                } else if (i == 3) {
                    RVLogger.d("AriverApp:App", "EngineInitCallback initResult faile and splashView is null ");
                    AppNode.this.exit();
                } else if (i == 4) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.8.1
                        {
                            AnonymousClass8.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            ((DialogService) RVProxy.get(DialogService.class)).showErrorDialog(AppNode.this, false);
                        }
                    });
                } else if (AppNode.this.getSplashView() != null) {
                    AppNode.this.getSplashView().showError("0", "engine init failed!", null);
                }
            }
        }).create()).onEngineInitFailed();
    }

    /* renamed from: com.alibaba.ariver.app.AppNode$13 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action;

        static {
            int[] iArr = new int[EngineInitFailedPoint.Action.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action = iArr;
            try {
                iArr[EngineInitFailedPoint.Action.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.REENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.EXIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.SHOW_ALERT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.SHOW_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean pushPage(String str, Bundle bundle, Bundle bundle2) {
        synchronized (this) {
            if (this.h) {
                RVLogger.w("AriverApp:App", "pushPage with shadowNode not work!");
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("pushPage ");
            sb.append(str);
            sb.append(" with stack: ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print")));
            RVLogger.d("AriverApp:App", sb.toString());
            Page activePage = getActivePage();
            if (activePage != null) {
                activePage.hide();
            }
            PageNode pageNode = null;
            PagePreRenderInitPoint.PagePreRenderHolder readyPreRenderHolderWithReset = ((PagePreRenderInitPoint) ExtensionPoint.as(PagePreRenderInitPoint.class).node(this).create()).getReadyPreRenderHolderWithReset(this, bundle, bundle2, str, false);
            if (readyPreRenderHolderWithReset != null) {
                pageNode = readyPreRenderHolderWithReset.preRenderPage;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("PagePreRender use prerender  pageNode is ");
                sb2.append(str);
                RVLogger.d("AriverApp:App", sb2.toString());
                ((PageNode) pageNode).init(str, bundle, bundle2);
            }
            if (pageNode == null) {
                pageNode = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, str, bundle, bundle2);
            }
            pushChild(pageNode);
            PageSource pageSource = ((AppLogContext) pageNode.getData(AppLogContext.class, true)).getPageSource();
            pageSource.sourceType = PageSource.SourceType.PUSH_WINDOW;
            if (activePage != null) {
                pageSource.sourcePageAppLogToken = AppLogUtils.getParentId(activePage);
                pageSource.sourceDesc = activePage.getPageURI();
            }
            AppUIContext appUIContext = this.mAppContext;
            if (appUIContext != null) {
                if (appUIContext.getTabBar() != null && this.mAppContext.getTabBar().isTabPage(pageNode)) {
                    return this.mAppContext.getTabBar().switchTab(this.mAppContext.getTabBar().getIndexByPage(pageNode), 3);
                }
                return this.mAppContext.pushPage(pageNode);
            }
            return false;
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void removePage(Page page, boolean z) {
        if (this.h) {
            RVLogger.w("AriverApp:App", "removePage with shadowNode not work!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("exitPage: ");
        sb.append(page);
        RVLogger.d("AriverApp:App", sb.toString());
        if (page.isDestroyed()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("exitPage but already destroyed! ");
            sb2.append(page);
            RVLogger.w("AriverApp:App", sb2.toString());
            return;
        }
        App.PopParams popParams = (App.PopParams) getData(App.PopParams.class);
        JSONObject jSONObject = popParams != null ? popParams.data : null;
        if (getChild(page.getNodeId()) != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("exitPage but not a child! ");
            sb3.append(page);
            RVLogger.w("AriverApp:App", sb3.toString());
            removeChild(page);
        }
        AppUIContext appUIContext = this.mAppContext;
        if (appUIContext != null) {
            appUIContext.exitPage(page, z);
        }
        page.destroy();
        Page activePage = getActivePage();
        if (activePage != null && !activePage.getBooleanValue("isWaitExit")) {
            activePage.show(jSONObject);
        }
        if (activePage == null && z) {
            this.mAppManager.exitApp(getNodeId());
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void popPage(JSONObject jSONObject) {
        synchronized (this) {
            if (this.h) {
                RVLogger.w("AriverApp:App", "popPage with shadowNode not work!");
                return;
            }
            if (jSONObject != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("popPage with param ");
                sb.append(jSONObject);
                RVLogger.d("AriverApp:App", sb.toString());
                setData(App.PopParams.class, new App.PopParams(jSONObject));
            }
            Page activePage = getActivePage();
            if (activePage != null) {
                activePage.exit(true);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void popTo(final int i, final boolean z, final JSONObject jSONObject) {
        if (this.h) {
            RVLogger.w("AriverApp:App", "popTo with shadowNode not work!");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.9
                {
                    AppNode.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        AppNode.this.setData(App.PopParams.class, new App.PopParams(jSONObject2));
                    }
                    int childCount = AppNode.this.getChildCount();
                    ArrayList arrayList = new ArrayList();
                    int i2 = i;
                    if (i2 < 0) {
                        int i3 = i2 + childCount;
                        StringBuilder sb = new StringBuilder();
                        sb.append("popTo ");
                        sb.append(i);
                        sb.append(" to minIndex ");
                        sb.append(i3);
                        RVLogger.d("AriverApp:App", sb.toString());
                        while (true) {
                            childCount--;
                            if (childCount < i3) {
                                break;
                            }
                            Page pageByIndex = AppNode.this.getPageByIndex(childCount);
                            if (pageByIndex.isUseForEmbed() && i3 > 0) {
                                i3--;
                            }
                            pageByIndex.putBooleanValue("isWaitExit", true);
                            arrayList.add(pageByIndex);
                        }
                    } else {
                        int i4 = childCount - 1;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("popTo ");
                        sb2.append(i);
                        sb2.append(" to maxIndex ");
                        sb2.append(i4);
                        RVLogger.d("AriverApp:App", sb2.toString());
                        for (int i5 = i + 1; i5 <= i4; i5++) {
                            Page pageByIndex2 = AppNode.this.getPageByIndex(i5);
                            if (pageByIndex2 != null) {
                                pageByIndex2.putBooleanValue("isWaitExit", true);
                                arrayList.add(pageByIndex2);
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Page) it.next()).exit(z);
                    }
                }
            });
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isExited() {
        return this.g;
    }

    public boolean isInited() {
        return this.l;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isShadowNode() {
        return this.h;
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void exit() {
        synchronized (this) {
            if (this.g) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("exitApp with stack ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print")));
            RVLogger.d("AriverApp:App", sb.toString());
            this.g = true;
            if (this.h) {
                RVLogger.d("AriverApp:App", "exit with shadowNode!");
                IpcServerUtils.sendMsgToClient(getAppId(), getStartToken(), 4, null);
                return;
            }
            ((AppExitPoint) ExtensionPoint.as(AppExitPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.10
                {
                    AppNode.this = this;
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Void r1) {
                    AppNode.this.onExit();
                }
            }).create()).onAppExit(this);
        }
    }

    protected void onExit() {
        synchronized (this) {
            a(true);
            destroy();
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public final boolean isDestroyed() {
        return this.p.get();
    }

    public final void destroy() {
        synchronized (this) {
            if (this.p.get()) {
                return;
            }
            if (this.h) {
                RVLogger.d("AriverApp:App", "destroy with shadowNode!");
                IpcServerUtils.sendMsgToClient(getAppId(), getStartToken(), 4, null);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("destroy ");
            sb.append(this);
            sb.append(" with stack ");
            sb.append(Log.getStackTraceString(new Throwable("Just Print")));
            RVLogger.d("AriverApp:App", sb.toString());
            this.p.set(true);
            ((AppDestroyPoint) ExtensionPoint.as(AppDestroyPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.11
                {
                    AppNode.this = this;
                }

                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Void r1) {
                    AppNode.this.onDestroy();
                }
            }).create()).onAppDestroy(this);
        }
    }

    protected void onDestroy() {
        AppUIContext appUIContext;
        StringBuilder sb = new StringBuilder();
        sb.append("onDestroy ");
        sb.append(this);
        RVLogger.d("AriverApp:App", sb.toString());
        if (this.u != null && (appUIContext = this.mAppContext) != null) {
            NetworkUtil.removeListener(appUIContext.getContext(), this.u);
        }
        RVEngine rVEngine = this.f5957o;
        if (rVEngine != null) {
            rVEngine.destroy();
            this.f5957o = null;
        }
        AppUIContext appUIContext2 = this.mAppContext;
        if (appUIContext2 != null) {
            appUIContext2.destroy();
            this.mAppContext = null;
        }
        onFinalized();
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isFirstPage() {
        Page activePage;
        if (getAlivePageCount() == 1) {
            return true;
        }
        AppUIContext appUIContext = this.mAppContext;
        return (appUIContext == null || appUIContext.getTabBar() == null || (activePage = getActivePage()) == null || !this.mAppContext.getTabBar().isTabPage(activePage)) ? false : true;
    }

    @Override // com.alibaba.ariver.app.api.App
    public final boolean backPressed() {
        AppUIContext appUIContext = this.mAppContext;
        if (appUIContext != null && appUIContext.getFontBar() != null && this.mAppContext.getFontBar().onBackPressed()) {
            RVLogger.d("AriverApp:App", "backPressed: intercept by font bar");
            return true;
        } else if (getSplashView() != null && getSplashView().backPressed()) {
            RVLogger.d("AriverApp:App", "backPressed: just exit on splash loading");
            return true;
        } else {
            Page activePage = getActivePage();
            if (activePage != null) {
                return activePage.backPressed();
            }
            destroy();
            return true;
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void performBack() {
        if (isFirstPage()) {
            RVLogger.d("AriverApp:App", "performBack with firstPage, direct exit!");
            exit();
            return;
        }
        RVLogger.d("AriverApp:App", "performBack just exit active page");
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.exit(true);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void resume() {
        StringBuilder sb = new StringBuilder();
        sb.append("resume with mSendResumeInRestart: ");
        sb.append(this.d);
        RVLogger.d("AriverApp:App", sb.toString());
        String str = this.f5956a;
        if (str == null) {
            str = BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID);
        }
        if (this.i) {
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_APPEARANCE_START).setAppId(this.appId).setParentId(str).build());
        }
        String stringValue = getStringValue("lastCalledJsApi");
        putStringValue("lastCalledJsApi", null);
        if (TextUtils.isEmpty(stringValue)) {
            RVLogger.w("AriverApp:App", "lastCalledJsApi is null");
            if (this.c && !this.d) {
                AppUtils.sendToApp(this, RVEvents.APP_RESUME, null, null);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lastCalledJsApi is ");
            sb2.append(stringValue);
            RVLogger.w("AriverApp:App", sb2.toString());
        }
        this.d = false;
        ((AppResumePoint) ExtensionPoint.as(AppResumePoint.class).node(this).create()).onAppResume(this);
        if (this.i) {
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_APPEARANCE_FINISH).setAppId(this.appId).setParentId(str).build());
        }
        this.i = false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void pause() {
        AppUtils.sendToApp(this, RVEvents.APP_PAUSE, null, null);
        this.c = true;
        ((AppPausePoint) ExtensionPoint.as(AppPausePoint.class).node(this).create()).onAppPause(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onConfigurationChanged(Configuration configuration) {
        ((AppOnConfigurationChangedPoint) ExtensionPoint.as(AppOnConfigurationChangedPoint.class).node(this).create()).onConfigurationChanged(this, configuration, ThemeUtils.getColorScheme(configuration));
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserLeaveHint() {
        ((AppLeaveHintPoint) ExtensionPoint.as(AppLeaveHintPoint.class).node(this).create()).onAppLeaveHint(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserInteraction() {
        ((AppInteractionPoint) ExtensionPoint.as(AppInteractionPoint.class).node(this).create()).onAppInteraction(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getStartUrl() {
        return this.j;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class<? extends Scope> getScopeType() {
        return App.class;
    }

    public String toString() {
        String appId = getAppId();
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this.mStartToken);
        sb.append("@appid=");
        sb.append(appId);
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

    @Override // com.alibaba.ariver.app.api.App
    public ExtensionManager getExtensionManager() {
        return sExtensionManager;
    }

    public AppNode(Parcel parcel) {
        super(parcel);
        this.pageLinks = new JSONArray();
        this.b = null;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new Object();
        this.g = false;
        this.h = false;
        this.i = true;
        this.l = false;
        this.m = new AtomicInteger(2);
        this.p = new AtomicBoolean(false);
        this.r = new Object();
        this.s = false;
        this.t = new ArrayList();
        this.appId = parcel.readString();
        this.mStartToken = parcel.readLong();
        this.mAppType = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mStartParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.mSceneParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.j = parcel.readString();
        this.h = true;
        a(parcel, EntryInfo.class);
        a(parcel, AppModel.class);
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.mStartToken);
        parcel.writeString(this.mAppType);
        String str = this.mAppVersion;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        a(parcel);
        parcel.writeBundle(this.mSceneParams);
        String str2 = this.j;
        parcel.writeString(str2 != null ? str2 : "");
        b(parcel, EntryInfo.class);
        b(parcel, AppModel.class);
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

    private <T extends Parcelable> void a(Parcel parcel, Class<T> cls) {
        Parcelable readParcelable;
        if (parcel.readInt() != 1 || (readParcelable = parcel.readParcelable(AppNode.class.getClassLoader())) == null) {
            return;
        }
        setData(cls, readParcelable);
    }

    private void b(Parcel parcel, Class<? extends Parcelable> cls) {
        Parcelable parcelable = (Parcelable) getData(cls);
        if (parcelable != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(parcelable, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
