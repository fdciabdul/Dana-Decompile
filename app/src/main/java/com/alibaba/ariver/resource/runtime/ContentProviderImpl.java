package com.alibaba.ariver.resource.runtime;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.model.AppxVersionStore;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceSourceType;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.CollectionUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.appxng.AppxNgRuntimeChecker;
import com.alibaba.ariver.resource.api.content.NetworkStream;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.content.ResourceProvider;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.ResourceProviderPoint;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.network.OnlineResourceFetcher;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.api.snapshot.SnapshotModel;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.ariver.resource.content.AppxNgResourcePackage;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.content.ResourcePackagePool;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.image.photo.PhotoContext;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ContentProviderImpl implements NetworkStream.Listener, ResourceProvider {
    public static final String APPX_NG_TINY_RES_HOST = "https://appx-ng/";
    public static final String TAG = "AriverRes:ContentProvider";
    public static final String TINY_RES_HOST = "https://appx/";

    /* renamed from: a  reason: collision with root package name */
    private String f6243a;
    private Map<String, String> b;
    private final List<NetworkStream> c;
    private final List<InputStream> d;
    private Map<String, String> f;
    private String j;
    private String k;
    private ResourceContext m;
    private OnlineResourceFetcher n;

    /* renamed from: o  reason: collision with root package name */
    private RVAppInfoManager f6244o;
    private ResourceProviderPoint p;
    private String q;
    private App r;
    private boolean s;
    private boolean t;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean l = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private HashMap<String, Resource> e = new HashMap<>();

    public ContentProviderImpl(ResourceContext resourceContext) {
        this.f6244o = null;
        this.s = false;
        this.t = false;
        this.m = resourceContext;
        this.n = resourceContext.getOnlineResourceFetcher();
        this.p = (ResourceProviderPoint) ExtensionPoint.as(ResourceProviderPoint.class).node(resourceContext.getApp()).create();
        this.r = this.m.getApp();
        if (resourceContext.getMainPackageInfo() != null) {
            this.q = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
            AppModel mainPackageInfo = resourceContext.getMainPackageInfo();
            boolean isAppxNgSoloPackage = AppxNgRuntimeChecker.isAppxNgSoloPackage(mainPackageInfo);
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.r, "appxNgSoloPackage", isAppxNgSoloPackage ? "yes" : "no");
            AppInfoModel appInfoModel = mainPackageInfo.getAppInfoModel();
            this.f6243a = isAppxNgSoloPackage ? appInfoModel.getNewFallbackBaseUrl() : appInfoModel.getFallbackBaseUrl();
            StringBuilder sb = new StringBuilder();
            sb.append("mCdnHost ");
            sb.append(this.f6243a);
            RVLogger.d(TAG, sb.toString());
        }
        this.c = Collections.synchronizedList(new ArrayList());
        this.d = Collections.synchronizedList(new ArrayList());
        this.b = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
        this.f6244o = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            this.s = "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_enableUseAppxHtmlNebulaX", ""));
            this.t = "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_enableInlineAppxJsFile", ""));
        }
        a();
    }

    private void a() {
        Set<String> keySet;
        this.f = new ConcurrentHashMap();
        if ("YES".equalsIgnoreCase(BundleUtils.getString(this.r.getStartParams(), "appxRouteFramework")) && BundleUtils.contains(this.r.getStartParams(), RVParams.APPX_ROUTE_BIZPREFIX)) {
            String string = BundleUtils.getString(this.r.getStartParams(), RVParams.APPX_ROUTE_BIZPREFIX);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Map<String, String> map = this.f;
            String combinePath = FileUtils.combinePath(this.q, "index.js");
            String str = this.q;
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append("index.js");
            map.put(combinePath, FileUtils.combinePath(str, sb.toString()));
            Map<String, String> map2 = this.f;
            String combinePath2 = FileUtils.combinePath(this.q, "index.html");
            String str2 = this.q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append("index.html");
            map2.put(combinePath2, FileUtils.combinePath(str2, sb2.toString()));
            Map<String, String> map3 = this.f;
            String combinePath3 = FileUtils.combinePath(this.q, "index.worker.js");
            String str3 = this.q;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string);
            sb3.append("index.worker.js");
            map3.put(combinePath3, FileUtils.combinePath(str3, sb3.toString()));
            AppModel appModel = (AppModel) this.r.getData(AppModel.class);
            if (appModel == null || appModel.getAppInfoModel() == null) {
                return;
            }
            boolean isAppxNgSoloPackage = AppxNgRuntimeChecker.isAppxNgSoloPackage(appModel);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("requreAppxNgSoloPackage initAppxRouteUrls ");
            sb4.append(isAppxNgSoloPackage);
            sb4.append(" appId:");
            sb4.append(appModel.getAppId());
            RVLogger.d(TAG, sb4.toString());
            AppInfoModel appInfoModel = appModel.getAppInfoModel();
            JSONObject newSubPackages = isAppxNgSoloPackage ? appInfoModel.getNewSubPackages() : appInfoModel.getSubPackages();
            if (newSubPackages == null || newSubPackages.isEmpty() || (keySet = newSubPackages.keySet()) == null || keySet.isEmpty()) {
                return;
            }
            for (String str4 : keySet) {
                if (!TextUtils.isEmpty(str4) && !"whole".equalsIgnoreCase(str4) && !"main".equalsIgnoreCase(str4)) {
                    Map<String, String> map4 = this.f;
                    String str5 = this.q;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str4);
                    sb5.append("/index.worker.js");
                    String combinePath4 = FileUtils.combinePath(str5, sb5.toString());
                    String str6 = this.q;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str4);
                    sb6.append("/");
                    sb6.append(string);
                    sb6.append("index.worker.js");
                    map4.put(combinePath4, FileUtils.combinePath(str6, sb6.toString()));
                    Map<String, String> map5 = this.f;
                    String str7 = this.q;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str4);
                    sb7.append("/index.js");
                    String combinePath5 = FileUtils.combinePath(str7, sb7.toString());
                    String str8 = this.q;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str4);
                    sb8.append("/");
                    sb8.append(string);
                    sb8.append("index.js");
                    map5.put(combinePath5, FileUtils.combinePath(str8, sb8.toString()));
                }
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getContent(ResourceQuery resourceQuery) {
        String str;
        Object obj;
        byte[] bArr;
        try {
            clearInputException();
            String str2 = resourceQuery.pureUrl;
            if (TextUtils.isEmpty(str2)) {
                RVLogger.e(TAG, "invalid url parameter");
                return null;
            } else if (!str2.startsWith(PhotoContext.FILE_SCHEME) && !str2.startsWith("http://") && !str2.startsWith("https://")) {
                StringBuilder sb = new StringBuilder();
                sb.append("skip load resource for ");
                sb.append(str2);
                RVLogger.d(TAG, sb.toString());
                return null;
            } else {
                boolean isMainDoc = resourceQuery.isMainDoc();
                String purifyUrl = UrlUtils.purifyUrl(str2);
                if (isTinyResource(purifyUrl) && resourceQuery.isAppxNgRoute()) {
                    str = purifyUrl.replace(TINY_RES_HOST, APPX_NG_TINY_RES_HOST);
                    resourceQuery.pureUrl = resourceQuery.pureUrl.replace(TINY_RES_HOST, APPX_NG_TINY_RES_HOST);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("appx-ng replace ");
                    sb2.append(resourceQuery.pureUrl);
                    RVLogger.d(TAG, sb2.toString());
                    resourceQuery.setCanUseFallback(false);
                } else {
                    str = purifyUrl;
                }
                if (this.f.containsKey(purifyUrl) && resourceQuery.isAppxNgRoute()) {
                    str = this.f.get(purifyUrl);
                    resourceQuery.pureUrl = str;
                }
                if (isTinyResource(purifyUrl)) {
                    if (purifyUrl.startsWith(AppxResourcePackage.APPX_RENDER_JS_URL)) {
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_JS_RenderFrameworkStart);
                        obj = "appxVersion";
                    } else {
                        if (purifyUrl.startsWith("https://appx/af-appx.worker.min.js")) {
                            obj = "appxVersion";
                            this.r.putBooleanValue("appxRouteWorker", resourceQuery.isAppxNgRoute());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("appx-ng set appxRouteWorker is ");
                            sb3.append(resourceQuery.isAppxNgRoute());
                            RVLogger.d(TAG, sb3.toString());
                            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.r, "appxRoute", resourceQuery.isAppxNgRoute() ? "yes" : "no");
                            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_JS_WorkerFrameworkStart);
                        } else {
                            obj = "appxVersion";
                            if (purifyUrl.startsWith(AppxNgResourcePackage.APPX_NG_WORKER_JS_URL)) {
                                this.r.putBooleanValue("appxRouteWorker", true);
                                ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.r, "appxRoute", "yes");
                                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_JS_WorkerFrameworkStart);
                            }
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("app ");
                    sb4.append(this.r.getNodeId());
                    sb4.append("load ");
                    sb4.append(purifyUrl);
                    RVLogger.d(TAG, sb4.toString());
                } else {
                    obj = "appxVersion";
                }
                if (this.i && isTinyResource(purifyUrl)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("hasTinyGoOnline true use tinyRes again ");
                    sb5.append(purifyUrl);
                    RVLogger.d(TAG, sb5.toString());
                    String b = b(resourceQuery);
                    if (!TextUtils.isEmpty(b)) {
                        String replace = str.replace("https://", b);
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_Fallback);
                        return this.n.getOnlineResource(replace, true, this.m.getAppId(), false);
                    }
                }
                if (resourceQuery.isMainDoc()) {
                    if (purifyUrl.equalsIgnoreCase(FileUtils.combinePath(this.q, "index.html"))) {
                        boolean isPreRenderMainDoc = resourceQuery.isPreRenderMainDoc();
                        SnapshotModel snapshotIndex = this.m.getSnapshotIndex(resourceQuery.originUrl);
                        if (!isPreRenderMainDoc || RVSnapshotUtils.isPreRenderSnapshotOpen(this.m.getAppId())) {
                            if (snapshotIndex != null) {
                                bArr = isPreRenderMainDoc ? snapshotIndex.getPreRenderSnapshotHtml() : snapshotIndex.getSnapshotHtml();
                            } else {
                                bArr = null;
                            }
                            if (bArr == null && this.m.getApp() != null) {
                                if (!isPreRenderMainDoc || RVSnapshotUtils.isPreRenderSnapshotOpen(this.m.getAppId())) {
                                    AppModel appModel = (AppModel) this.r.getData(AppModel.class);
                                    if (appModel == null) {
                                        RVLogger.d(TAG, "getAppModel from sceneParam");
                                        appModel = (AppModel) BundleUtils.getParcelable(this.r.getSceneParams(), "appInfo");
                                    }
                                    if (appModel != null) {
                                        bArr = RVSnapshotUtils.loadSnapshotFile(this.m.getApp(), appModel, resourceQuery.originUrl, isPreRenderMainDoc);
                                    }
                                }
                            }
                            if (bArr != null && bArr.length > 100) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("SnapshotProvider use snapshotData success! ");
                                sb6.append(purifyUrl);
                                sb6.append(" isPreRender:");
                                sb6.append(isPreRenderMainDoc);
                                RVLogger.d(TAG, sb6.toString());
                                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Use_Snapshot);
                                OfflineResource offlineResource = new OfflineResource(purifyUrl, bArr);
                                offlineResource.setSourceType(ResourceSourceType.SNAPSHOT);
                                return offlineResource;
                            }
                        }
                        bArr = null;
                        if (bArr != null) {
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("SnapshotProvider use snapshotData success! ");
                            sb62.append(purifyUrl);
                            sb62.append(" isPreRender:");
                            sb62.append(isPreRenderMainDoc);
                            RVLogger.d(TAG, sb62.toString());
                            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Use_Snapshot);
                            OfflineResource offlineResource2 = new OfflineResource(purifyUrl, bArr);
                            offlineResource2.setSourceType(ResourceSourceType.SNAPSHOT);
                            return offlineResource2;
                        }
                    }
                    if (resourceQuery.isPreRenderMainDoc()) {
                        resourceQuery.pureUrl = "https://appx-ng/index.prerender.html";
                        if (this.i) {
                            String b2 = b(resourceQuery);
                            if (!TextUtils.isEmpty(b2)) {
                                String replace2 = str.replace("https://", b2);
                                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_Fallback);
                                return this.n.getOnlineResource(replace2, true, this.m.getAppId(), false);
                            }
                        }
                    }
                }
                Bundle startParams = this.m.getStartParams();
                if (this.s && purifyUrl.equalsIgnoreCase(FileUtils.combinePath(this.q, "index.html")) && BundleUtils.getBoolean(startParams, RVParams.isTinyApp, false) && !AppInfoScene.isDevSource(startParams)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("use appx html:\t");
                    sb7.append(purifyUrl);
                    RVLogger.d(TAG, sb7.toString());
                    if (resourceQuery.isAppxNgRoute()) {
                        resourceQuery.pureUrl = FileUtils.combinePath(APPX_NG_TINY_RES_HOST, "index.html");
                    } else {
                        resourceQuery.pureUrl = FileUtils.combinePath(TINY_RES_HOST, "index.html");
                    }
                    Resource rawResource = getRawResource(resourceQuery);
                    if (rawResource == null) {
                        resourceQuery.pureUrl = str;
                        RVLogger.d(TAG, "replace html file fail , global package is null");
                    } else if (this.t) {
                        byte[] replaceJsFile = H5ByteBufferUtil.replaceJsFile((byte[]) rawResource.getBytes().clone(), H5ByteBufferUtil.JS_INLINE_SNIPPET_TO_SEARCH_START, H5ByteBufferUtil.JS_INLINE_SNIPPET_TO_SEARCH_END, this.q, this);
                        if (replaceJsFile != null && replaceJsFile.length > 1) {
                            RVLogger.d(TAG, "replaceJsFile success");
                            rawResource.setBytes(replaceJsFile);
                        }
                        return rawResource;
                    }
                }
                Resource rawResource2 = getRawResource(resourceQuery);
                if (rawResource2 == null) {
                    rawResource2 = null;
                }
                if (!isMainDoc) {
                    ExecutorUtils.execute(ExecutorType.IDLE, new Runnable() { // from class: com.alibaba.ariver.resource.runtime.ContentProviderImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ContentProviderImpl.this.m.updatePackageBrief();
                        }
                    });
                }
                if (rawResource2 != null) {
                    if (isMainDoc) {
                        RVLogger.d(TAG, "H5_AL_SESSION_MAP_SUCCESS");
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_MainDoc_Offline);
                    } else if (!this.h) {
                        this.h = true;
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_SubRes_Offline);
                    }
                    if (AppxResourcePackage.APPX_RENDER_JS_URL.equals(purifyUrl)) {
                        try {
                            Map<String, String> headers = rawResource2.getHeaders();
                            if (!CollectionUtils.isEmpty(headers)) {
                                Object obj2 = obj;
                                if (headers.containsKey(obj2)) {
                                    String str3 = headers.get(obj2);
                                    ((AppxVersionStore) this.m.getApp().getData(AppxVersionStore.class, true)).renderVersion = headers.get(obj2);
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("detect render appx version is: ");
                                    sb8.append(str3);
                                    RVLogger.d(TAG, sb8.toString());
                                }
                            }
                        } catch (Throwable th) {
                            RVLogger.e(TAG, "detect render appx version exception: ", th);
                        }
                    }
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("load response from offline: ");
                    sb9.append(str);
                    RVLogger.d(TAG, sb9.toString());
                    return rawResource2;
                }
                Resource remove = this.e.remove(str);
                if (remove != null) {
                    RVLogger.d(TAG, "load response from map local.");
                    return remove;
                }
                if (!purifyUrl.endsWith("/favicon.ico") && !purifyUrl.endsWith("/favicon.png") && !purifyUrl.endsWith("/favicon2.ico")) {
                    if (isTinyResource(purifyUrl)) {
                        String b3 = b(resourceQuery);
                        if (!TextUtils.isEmpty(b3)) {
                            this.i = true;
                            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_Fallback);
                            return this.n.getOnlineResource(str.replace("https://", b3), true, this.m.getAppId(), false);
                        }
                    }
                    String a2 = a(str, resourceQuery);
                    if (!TextUtils.isEmpty(a2)) {
                        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.r, TrackId.Stub_Resource_Fallback);
                    }
                    if (!TextUtils.isEmpty(a2) && resourceQuery.isCanUseFallback()) {
                        return this.n.getOnlineResource(a2, true, this.m.getAppId(), resourceQuery.isForceNet());
                    }
                    Resource resource = this.p.getResource(resourceQuery);
                    if (resource != null) {
                        RVLogger.d(TAG, "load response from provider point");
                        return resource;
                    }
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("load response from web ");
                    sb10.append(str);
                    RVLogger.d(TAG, sb10.toString());
                    return null;
                }
                RVLogger.d(TAG, "favicon request intercepted");
                return new OfflineResource(purifyUrl, new byte[0], "image/x-icon");
            }
        } catch (Throwable th2) {
            RVLogger.e(TAG, "load response from web catch exception ", th2);
            return null;
        }
    }

    boolean isTinyResource(String str) {
        return str.startsWith(TINY_RES_HOST) || str.startsWith(APPX_NG_TINY_RES_HOST);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getRawResource(ResourceQuery resourceQuery) {
        Resource resource = null;
        if (a(resourceQuery)) {
            return null;
        }
        if (this.m != null && !resourceQuery.isPreRenderMainDoc()) {
            resource = this.m.getRawResource(resourceQuery);
        }
        if (resource == null) {
            resource = ResourcePackagePool.getInstance().get(resourceQuery);
        }
        if (resource == null) {
            resource = ResourceUtils.getResourceFromGlobalPackagePool(resourceQuery);
        }
        this.g = resource != null;
        return resource;
    }

    private boolean a(ResourceQuery resourceQuery) {
        String str;
        boolean z = false;
        if (RVKernelUtils.isDebug()) {
            try {
                b();
                str = resourceQuery.pureUrl;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("forceFallback异常");
                sb.append(e.getMessage());
                RVLogger.e(TAG, sb.toString());
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (isTinyResource(str)) {
                z = this.x;
            } else if (str.startsWith(this.q)) {
                if (str.indexOf("__plugins__") > 0) {
                    z = this.v;
                } else {
                    z = this.w;
                }
            }
            if (z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceFallback生效 ");
                sb2.append(str);
                RVLogger.e(TAG, sb2.toString());
            }
            return z;
        }
        return false;
    }

    private void b() {
        if (this.u) {
            return;
        }
        this.u = true;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null) {
            return;
        }
        this.v = rVConfigService.getConfigBoolean("ta_force_plugin_fallback", false);
        this.w = rVConfigService.getConfigBoolean("ta_force_tiny_package_fallback", false);
        this.x = rVConfigService.getConfigBoolean("ta_force_appx_package_fallback", false);
    }

    private String b(ResourceQuery resourceQuery) {
        if (resourceQuery.isAppxNgRoute()) {
            if (TextUtils.isEmpty(this.k) && this.f6244o != null) {
                AppInfoQuery appInfoQuery = new AppInfoQuery("68687209");
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage("68687209");
                if (resourcePackage != null && !TextUtils.isEmpty(resourcePackage.version())) {
                    appInfoQuery.version(resourcePackage.version());
                }
                AppModel appModel = this.f6244o.getAppModel(appInfoQuery);
                if (appModel == null) {
                    return null;
                }
                this.k = appModel.getAppInfoModel().getFallbackBaseUrl();
                StringBuilder sb = new StringBuilder();
                sb.append("getAppNgTinyResFallbackUrl ");
                sb.append(this.k);
                RVLogger.d(TAG, sb.toString());
            }
            return this.k;
        }
        if (TextUtils.isEmpty(this.j) && this.f6244o != null) {
            AppInfoQuery appInfoQuery2 = new AppInfoQuery("66666692");
            ResourcePackage resourcePackage2 = GlobalPackagePool.getInstance().getPackage("66666692");
            if (resourcePackage2 != null && !TextUtils.isEmpty(resourcePackage2.version())) {
                appInfoQuery2.version(resourcePackage2.version());
            }
            AppModel appModel2 = this.f6244o.getAppModel(appInfoQuery2);
            if (appModel2 == null) {
                return null;
            }
            this.j = appModel2.getAppInfoModel().getFallbackBaseUrl();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getTinyResFallbackUrl ");
            sb2.append(this.j);
            RVLogger.d(TAG, sb2.toString());
        }
        return this.j;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getLocalResource(String str) {
        ResourceQuery asUrl = ResourceQuery.asUrl(str);
        ResourceContext resourceContext = this.m;
        Resource rawResource = resourceContext != null ? resourceContext.getRawResource(asUrl) : null;
        return rawResource == null ? GlobalPackagePool.getInstance().get(asUrl) : rawResource;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public Resource getContent(String str) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(TAG, "getContent url null!!!", new Throwable("Just Print"));
            return null;
        }
        ResourceQuery resourceQuery = new ResourceQuery(str);
        App app = this.r;
        if (app != null) {
            resourceQuery.setAppxNgRoute("YES".equalsIgnoreCase(BundleUtils.getString(app.getStartParams(), "appxRouteFramework")));
        }
        resourceQuery.setCanUseFallback(false);
        resourceQuery.setMainDoc(false);
        return getContent(resourceQuery);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void mapContent(String str, Resource resource) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(TAG, "map Content url null!!!", new Throwable("Just Print"));
        } else {
            this.e.put(str, resource);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void setFallbackCache(String str, byte[] bArr) {
        if (this.m.getMainPackage() != null) {
            this.m.getMainPackage().add(new OfflineResource(UrlUtils.purifyUrl(str), bArr));
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public String getFallbackUrl(String str) {
        Map<String, String> map;
        String purifyUrl = UrlUtils.purifyUrl(str);
        if (TextUtils.isEmpty(purifyUrl) || (map = this.b) == null) {
            return null;
        }
        return map.get(purifyUrl);
    }

    private String a(String str, ResourceQuery resourceQuery) {
        if (TextUtils.isEmpty(this.f6243a)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str) && str.contains("__plugins__/") && "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enablePluginFallback", "yes"))) {
                int indexOf = str.indexOf("__plugins__/") + 12;
                String substring = str.substring(indexOf, indexOf + 16);
                PluginModel pluginModel = ((PluginStore) this.r.getData(PluginStore.class)).getAllPlugins().get(substring);
                if (pluginModel != null) {
                    String combinePath = FileUtils.combinePath(pluginModel.getFallbackBaseUrl(), str.substring(indexOf + 17));
                    StringBuilder sb = new StringBuilder();
                    sb.append("plugin fallback final url ");
                    sb.append(combinePath);
                    RVLogger.d(TAG, sb.toString());
                    a(str, substring, combinePath);
                    return combinePath;
                }
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("get plugin fallback url = ");
            sb2.append(str);
            RVLogger.e(TAG, sb2.toString(), e);
        }
        if (str.startsWith(this.q)) {
            String combinePath2 = FileUtils.combinePath(this.f6243a, str.replace(this.q, ""));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("fallback final url ");
            sb3.append(combinePath2);
            RVLogger.d(TAG, sb3.toString());
            return combinePath2;
        }
        return null;
    }

    private void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("fallbackUrl", str3);
            hashMap.put("originUrl", str);
            hashMap.put("pluginId", str2);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).logNebulaTech("H5_PLUGIN_LOAD_FALLBACK", null, null, null, hashMap);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append(" report plugin fallback erroor: ");
            sb.append(e.getMessage());
            RVLogger.e(TAG, sb.toString());
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputClose(NetworkStream networkStream) {
        RVLogger.debug(TAG, "on input stream close.");
        this.c.remove(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputOpen(NetworkStream networkStream) {
        RVLogger.debug(TAG, "on input stream open.");
        this.c.add(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onResourceError(NetworkStream networkStream, int i) {
        this.c.remove(networkStream);
    }

    @Override // com.alibaba.ariver.resource.api.content.NetworkStream.Listener
    public void onInputException() {
        this.l = true;
        RVLogger.d(TAG, "h5InputStream exception");
    }

    public void clearInputException() {
        this.l = false;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public boolean hasInputException() {
        return this.l;
    }

    public void disconnect() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("disconnect connList ");
            sb.append(this.c.size());
            RVLogger.debug(TAG, sb.toString());
            synchronized (this.c) {
                for (int i = 0; i < this.c.size(); i++) {
                    NetworkStream networkStream = this.c.get(i);
                    if (networkStream != null) {
                        try {
                            networkStream.close();
                        } catch (Exception e) {
                            RVLogger.e(TAG, "close connection exception.", e);
                        }
                    }
                }
                this.c.clear();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("disconnect inputStreamList ");
            sb2.append(this.d.size());
            RVLogger.debug(TAG, sb2.toString());
            synchronized (this.d) {
                Iterator<InputStream> it = this.d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().close();
                    } catch (Exception e2) {
                        RVLogger.e(TAG, e2);
                    }
                }
                this.d.clear();
            }
        } catch (Exception e3) {
            RVLogger.e(TAG, e3);
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public void releaseContent() {
        RVLogger.d(TAG, "releaseContent");
        disconnect();
        Map<String, String> map = this.b;
        if (map != null) {
            try {
                map.clear();
            } catch (Throwable th) {
                RVLogger.e(TAG, "clear mFallbackUrlMap exception ", th);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourceProvider
    public boolean isLocal() {
        return this.g;
    }
}
