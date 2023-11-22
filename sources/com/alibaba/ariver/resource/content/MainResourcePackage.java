package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventAttr;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.LowMemoryUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.DownloadInstallCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.PackageParsedPoint;
import com.alibaba.ariver.resource.api.network.OnlineResourceFetcher;
import com.alibaba.ariver.resource.content.BaseResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class MainResourcePackage extends BaseResourcePackage {
    private static String d = "https:/";

    /* renamed from: a */
    private AtomicBoolean f6225a;
    private boolean b;
    private AtomicInteger c;
    protected String mOnlineHost;

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    protected boolean needWaitSetupWhenGet() {
        return false;
    }

    public MainResourcePackage(ResourceContext resourceContext) {
        super(resourceContext.getAppId(), resourceContext);
        this.mOnlineHost = null;
        this.f6225a = new AtomicBoolean(false);
        this.b = false;
        this.c = new AtomicInteger(3);
        if (resourceContext.getMainPackageInfo() != null) {
            OnlineResourceFetcher onlineResourceFetcher = resourceContext.getOnlineResourceFetcher();
            final String fallbackBaseUrl = resourceContext.getMainPackageInfo().getAppInfoModel().getFallbackBaseUrl();
            final String vhost = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
            onlineResourceFetcher.setFallbackListener(new OnlineResourceFetcher.FallbackListener() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.1
                {
                    MainResourcePackage.this = this;
                }

                @Override // com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.FallbackListener
                public void onSuccess(String str, Resource resource) {
                    MainResourcePackage.this.b = true;
                    if (str.endsWith(RVConstants.FILE_APP_CONFIG) || str.endsWith(RVConstants.FILE_API_PERMISSION) || str.endsWith(RVConstants.FILE_TABBAR)) {
                        String combinePath = FileUtils.combinePath(vhost, str.replace(fallbackBaseUrl, ""));
                        String logTag = MainResourcePackage.this.getLogTag();
                        StringBuilder sb = new StringBuilder();
                        sb.append("replace url [");
                        sb.append(str);
                        sb.append("] to [");
                        sb.append(combinePath);
                        sb.append("]");
                        RVLogger.d(logTag, sb.toString());
                        MainResourcePackage.this.add(new OfflineResource(combinePath, resource.getBytes()));
                        if (MainResourcePackage.this.c.decrementAndGet() == 0) {
                            RVLogger.d(MainResourcePackage.this.getLogTag(), "all key resource onSuccess, just release setup lock!");
                            MainResourcePackage.this.getSetupLock().countDown();
                            MainResourcePackage.this.a();
                        }
                    }
                }

                @Override // com.alibaba.ariver.resource.api.network.OnlineResourceFetcher.FallbackListener
                public void onFailed(String str) {
                    String logTag = MainResourcePackage.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResource fallback failed! ");
                    sb.append(str);
                    RVLogger.d(logTag, sb.toString());
                }
            });
            this.mOnlineHost = resourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    void onNotInstalled() {
        if (this.mResourceContext == null) {
            return;
        }
        if (this.resourceManager.isAvailable(getAppModel())) {
            this.resourceManager.installApp(getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.2
                {
                    MainResourcePackage.this = this;
                }

                @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                public void onResult(boolean z, String str) {
                    MainResourcePackage mainResourcePackage = MainResourcePackage.this;
                    mainResourcePackage.parseContent(mainResourcePackage.appId, str);
                }
            });
            return;
        }
        getParseLock().countDown();
        long j = 0;
        if (this.b || this.mResourceContext.getSceneParams().getBoolean(RVConstants.EXTRA_USING_FALLBACK_START)) {
            RVLogger.d(this.LOG_TAG, "already fallback, just release setupLock!");
            j = RangedBeacon.DEFAULT_MAX_TRACKING_AGE;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.resource.content.MainResourcePackage.3
            {
                MainResourcePackage.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainResourcePackage.this.resourceManager.downloadApp(MainResourcePackage.this.getAppModel(), false, new MainResourceDownloadCallback());
            }
        }, j);
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return (this.mResourceContext == null || this.mResourceContext.getApp() == null || !this.mResourceContext.getApp().isTinyApp()) ? false : true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    protected boolean canHotUpdate(String str) {
        return str == null || TextUtils.equals(str, this.appVersion);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        Resource fromStorage;
        String str = resourceQuery.pureUrl;
        if (resourceQuery.isNeedAutoCompleteHost() && !TextUtils.isEmpty(this.mOnlineHost)) {
            str = FileUtils.combinePath(this.mOnlineHost, resourceQuery.pureUrl);
        }
        if (resourceQuery.isLanguageAware()) {
            String appLanguage = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppLanguage();
            if (!TextUtils.isEmpty(appLanguage)) {
                String str2 = this.mOnlineHost;
                String replace = str.replace(str2, FileUtils.combinePath(str2, appLanguage));
                if (contains(replace)) {
                    String logTag = getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("replace query to language awared url: ");
                    sb.append(replace);
                    RVLogger.d(logTag, sb.toString());
                    str = replace;
                } else {
                    String logTag2 = getLogTag();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("replace query to language awared url: ");
                    sb2.append(replace);
                    sb2.append(" not found!!!");
                    RVLogger.w(logTag2, sb2.toString());
                }
            }
        }
        Resource fromStorage2 = super.getFromStorage(str);
        if (fromStorage2 != null) {
            return fromStorage2;
        }
        try {
            if (!"yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableGetOnlineResource", "yes"))) {
                if (LowMemoryUtils.onLowMemoryMode && this.mResourceContext != null && this.mResourceContext.getApp() != null && this.mResourceContext.getApp().isTinyApp()) {
                    if (LowMemoryUtils.removeIndexWorkerJs && str.endsWith("index.worker.js")) {
                        String logTag3 = getLogTag();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onLowMemoryMode, remove from pkg: ");
                        sb3.append(str);
                        RVLogger.w(logTag3, sb3.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeAppConfig && str.endsWith(RVConstants.FILE_APP_CONFIG)) {
                        String logTag4 = getLogTag();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onLowMemoryMode, remove from pkg:  ");
                        sb4.append(str);
                        RVLogger.w(logTag4, sb4.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeApiPermission && str.endsWith(RVConstants.FILE_API_PERMISSION)) {
                        String logTag5 = getLogTag();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onLowMemoryMode, remove from pkg:  ");
                        sb5.append(str);
                        RVLogger.w(logTag5, sb5.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeTabBarJson && str.endsWith(RVConstants.FILE_TABBAR)) {
                        String logTag6 = getLogTag();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("onLowMemoryMode, remove from pkg:  ");
                        sb6.append(str);
                        RVLogger.w(logTag6, sb6.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                }
                return null;
            } else if (str.startsWith(this.mOnlineHost) || !str.startsWith(d) || (fromStorage = super.getFromStorage((str = str.replace(d, this.mOnlineHost)))) == null) {
                if (LowMemoryUtils.onLowMemoryMode && this.mResourceContext != null && this.mResourceContext.getApp() != null && this.mResourceContext.getApp().isTinyApp()) {
                    if (LowMemoryUtils.removeIndexWorkerJs && str.endsWith("index.worker.js")) {
                        String logTag7 = getLogTag();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("onLowMemoryMode, remove from pkg: ");
                        sb7.append(str);
                        RVLogger.w(logTag7, sb7.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeAppConfig && str.endsWith(RVConstants.FILE_APP_CONFIG)) {
                        String logTag8 = getLogTag();
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("onLowMemoryMode, remove from pkg:  ");
                        sb8.append(str);
                        RVLogger.w(logTag8, sb8.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeApiPermission && str.endsWith(RVConstants.FILE_API_PERMISSION)) {
                        String logTag9 = getLogTag();
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("onLowMemoryMode, remove from pkg:  ");
                        sb9.append(str);
                        RVLogger.w(logTag9, sb9.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeTabBarJson && str.endsWith(RVConstants.FILE_TABBAR)) {
                        String logTag10 = getLogTag();
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("onLowMemoryMode, remove from pkg:  ");
                        sb10.append(str);
                        RVLogger.w(logTag10, sb10.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                }
                return null;
            } else {
                String logTag11 = getLogTag();
                StringBuilder sb11 = new StringBuilder();
                sb11.append("get resource from replace mOnlineHost , url = ");
                sb11.append(resourceQuery.pureUrl);
                RVLogger.d(logTag11, sb11.toString());
                if (LowMemoryUtils.onLowMemoryMode && this.mResourceContext != null && this.mResourceContext.getApp() != null && this.mResourceContext.getApp().isTinyApp()) {
                    if (LowMemoryUtils.removeIndexWorkerJs && str.endsWith("index.worker.js")) {
                        String logTag12 = getLogTag();
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append("onLowMemoryMode, remove from pkg: ");
                        sb12.append(str);
                        RVLogger.w(logTag12, sb12.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeAppConfig && str.endsWith(RVConstants.FILE_APP_CONFIG)) {
                        String logTag13 = getLogTag();
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("onLowMemoryMode, remove from pkg:  ");
                        sb13.append(str);
                        RVLogger.w(logTag13, sb13.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeApiPermission && str.endsWith(RVConstants.FILE_API_PERMISSION)) {
                        String logTag14 = getLogTag();
                        StringBuilder sb14 = new StringBuilder();
                        sb14.append("onLowMemoryMode, remove from pkg:  ");
                        sb14.append(str);
                        RVLogger.w(logTag14, sb14.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                    if (LowMemoryUtils.removeTabBarJson && str.endsWith(RVConstants.FILE_TABBAR)) {
                        String logTag15 = getLogTag();
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append("onLowMemoryMode, remove from pkg:  ");
                        sb15.append(str);
                        RVLogger.w(logTag15, sb15.toString(), new RuntimeException("Just Print"));
                        this.mStorage.remove(str);
                    }
                }
                return fromStorage;
            }
        } finally {
            if (LowMemoryUtils.onLowMemoryMode && this.mResourceContext != null && this.mResourceContext.getApp() != null && this.mResourceContext.getApp().isTinyApp()) {
                if (LowMemoryUtils.removeIndexWorkerJs && str.endsWith("index.worker.js")) {
                    String logTag16 = getLogTag();
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append("onLowMemoryMode, remove from pkg: ");
                    sb16.append(str);
                    RVLogger.w(logTag16, sb16.toString(), new RuntimeException("Just Print"));
                    this.mStorage.remove(str);
                }
                if (LowMemoryUtils.removeAppConfig && str.endsWith(RVConstants.FILE_APP_CONFIG)) {
                    String logTag17 = getLogTag();
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append("onLowMemoryMode, remove from pkg:  ");
                    sb17.append(str);
                    RVLogger.w(logTag17, sb17.toString(), new RuntimeException("Just Print"));
                    this.mStorage.remove(str);
                }
                if (LowMemoryUtils.removeApiPermission && str.endsWith(RVConstants.FILE_API_PERMISSION)) {
                    String logTag18 = getLogTag();
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append("onLowMemoryMode, remove from pkg:  ");
                    sb18.append(str);
                    RVLogger.w(logTag18, sb18.toString(), new RuntimeException("Just Print"));
                    this.mStorage.remove(str);
                }
                if (LowMemoryUtils.removeTabBarJson && str.endsWith(RVConstants.FILE_TABBAR)) {
                    String logTag19 = getLogTag();
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append("onLowMemoryMode, remove from pkg:  ");
                    sb19.append(str);
                    RVLogger.w(logTag19, sb19.toString(), new RuntimeException("Just Print"));
                    this.mStorage.remove(str);
                }
            }
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone(boolean z) {
        if (this.mResourceContext == null) {
            RVLogger.w("MainResource parse need resource context");
        }
        super.onPrepareDone(z);
        String string = (this.mResourceContext == null || this.mResourceContext.getStartParams() == null) ? "" : BundleUtils.getString(this.mResourceContext.getStartParams(), RVParams.START_APP_SESSION_ID);
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("load app ");
        sb.append(z ? "success" : "fail");
        sb.append(" : ");
        sb.append(this.appId);
        sb.append("/");
        sb.append(version());
        AppLogger.log(builder.setState(sb.toString()).setAppId(this.appId).setParentId(string).build());
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        if (this.mResourceContext == null) {
            throw new IllegalStateException("MainResource parse need resource context");
        }
        super.beforeParsePackage(parseContext);
        parseContext.needCache = true;
        parseContext.adaptAppModel(this.mResourceContext.getMainPackageInfo());
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void afterParsePackage(ParseContext parseContext) {
        if (this.mResourceContext == null) {
            throw new IllegalStateException("MainResource parse need resource context");
        }
        super.afterParsePackage(parseContext);
        a();
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mResourceContext.getApp(), TrackId.Stub_PkgParse);
        if (parseContext.fromCache) {
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mResourceContext.getApp(), "parseFromCache", "1");
        } else {
            ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.mResourceContext.getApp(), "parseFromCache", "0");
        }
    }

    public void a() {
        if (this.f6225a.getAndSet(true)) {
            return;
        }
        ((PackageParsedPoint) ExtensionPoint.as(PackageParsedPoint.class).node(this.mResourceContext.getApp()).create()).onResourceParsed(this.mResourceContext.getMainPackageInfo(), this);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onVerifyError(ParseFailedException parseFailedException) {
        super.onVerifyError(parseFailedException);
        Event error = ((EventTracker) RVProxy.get(EventTracker.class)).error(this.mResourceContext != null ? this.mResourceContext.getApp() : null, "ResVerifyFail", "mainPkgParseFailed");
        if (error != null) {
            error.putAttr(EventAttr.Key_resourceDBFailMsg, parseFailedException.getCode());
            error.putAttr(EventAttr.Key_resourceParseFailMsg, parseFailedException.getMessage());
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        if (this.mResourceContext == null) {
            throw new IllegalStateException("main resource cannot setup without app context");
        }
        if (this.mResourceContext.getMainPackageInfo() == null) {
            throw new IllegalStateException("main resource cannot setup without app main packageInfo");
        }
        this.mOnlineHost = this.mResourceContext.getMainPackageInfo().getAppInfoModel().getVhost();
        super.setup(z);
    }

    /* loaded from: classes6.dex */
    class MainResourceDownloadCallback extends DownloadInstallCallback {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        MainResourceDownloadCallback() {
            super(r3.getAppModel(), true, true, new BaseResourcePackage.HotUpdatePackageInstallCallback());
            MainResourcePackage.this = r3;
        }
    }
}
