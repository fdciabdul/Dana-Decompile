package com.alibaba.ariver.resource.content;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class BaseResourcePackage extends BaseStoragePackage {

    /* renamed from: a */
    private long f6221a;
    String appId;
    String appVersion;
    private AppModel d;
    final ResourceContext mResourceContext;
    String LOG_TAG = "AriverRes:Package";
    private boolean b = false;
    private AtomicBoolean c = new AtomicBoolean(false);
    RVAppInfoManager mAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
    RVResourceManager resourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);

    abstract boolean canHotUpdate(String str);

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public boolean needWaitForSetup() {
        return false;
    }

    abstract void onNotInstalled();

    public BaseResourcePackage(String str, ResourceContext resourceContext) {
        this.appId = str;
        this.mResourceContext = resourceContext;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public String getLogTag() {
        return this.LOG_TAG;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String appId() {
        return this.appId;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public String version() {
        return this.appVersion;
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void reload() {
        if (this.mSetupLock.getCount() > 0 || this.mParseLock.getCount() > 0 || this.c.get()) {
            RVLogger.d(this.LOG_TAG, "current setup and not do reload!");
            return;
        }
        RVLogger.d(this.LOG_TAG, "reload begin!");
        final AppModel prepareAppModel = prepareAppModel(AppInfoQuery.make(this.appId).disableCache());
        String appVersion = prepareAppModel == null ? null : prepareAppModel.getAppVersion();
        AppModel appModel = this.d;
        String appVersion2 = appModel != null ? appModel.getAppVersion() : null;
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("reload got new ");
        sb.append(appVersion);
        sb.append(", current: ");
        sb.append(appVersion2);
        RVLogger.d(str, sb.toString());
        if (prepareAppModel != null && AppModel.COMPARATOR.compare(prepareAppModel, this.d) <= 0) {
            RVLogger.d(this.LOG_TAG, "reload version compare fail, not refresh!");
            return;
        }
        this.b = false;
        this.c.set(true);
        ResourceUtils.downloadAndInstallApp(new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.content.BaseResourcePackage.1
            {
                BaseResourcePackage.this = this;
            }

            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z, String str2) {
                BaseResourcePackage.this.mSetupLock = new CountDownLatch(1);
                BaseResourcePackage.this.mParseLock = new CountDownLatch(1);
                BaseResourcePackage.this.a(true, prepareAppModel);
                BaseResourcePackage.this.c.set(false);
                RVLogger.d(BaseResourcePackage.this.LOG_TAG, "reload end!");
            }
        }, prepareAppModel);
    }

    @Override // com.alibaba.ariver.resource.api.content.ResourcePackage
    public void setup(boolean z) {
        a(z, (AppModel) null);
    }

    public void a(boolean z, AppModel appModel) {
        AppModel appModel2;
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        synchronized (this) {
            if (this.b) {
                RVLogger.w(this.LOG_TAG, "already setupted!");
                return;
            }
            this.b = true;
            String str = this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("begin setup with lock: ");
            sb.append(z);
            RVLogger.d(str, sb.toString());
            this.f6221a = SystemClock.elapsedRealtime();
            if (appModel != null) {
                this.d = appModel;
            } else {
                this.d = prepareAppModel(AppInfoQuery.make(this.appId));
            }
            if (this.mAppInfoManager == null && this.d == null) {
                boolean hitPresetResource = hitPresetResource();
                String str2 = this.LOG_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" cannot find local version for: ");
                sb2.append(this.appId);
                RVLogger.w(str2, sb2.toString());
                if (hitPresetResource) {
                    RVLogger.w(this.LOG_TAG, " hitPresetPkg!");
                    onPrepareDone(true);
                } else {
                    getSetupLock().countDown();
                    getParseLock().countDown();
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                RVLogger.w(this.LOG_TAG, "prepareContent with lock!");
            }
            RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
            Map<String, AppModel> presetAppInfos = rVResourcePresetProxy.getPresetAppInfos();
            if (presetAppInfos != null) {
                AppModel appModel3 = presetAppInfos.get(this.appId);
                if (appModel3 != null && (presetPackage = rVResourcePresetProxy.getPresetPackage()) != null && presetPackage.get(this.appId) != null && presetPackage.get(this.appId).isForceUse() && hitPresetResource()) {
                    RVLogger.w(this.LOG_TAG, "prepareContent use preset force used flag!");
                    return;
                } else if (appModel3 != null && AppModel.COMPARATOR.compare(this.d, appModel3) < 0 && hitPresetResource()) {
                    RVLogger.w(this.LOG_TAG, "prepareContent use preset because lower current AppInfo!");
                    return;
                } else if (appModel3 != null && (appModel2 = this.d) != null && TextUtils.equals(appModel2.getAppVersion(), appModel3.getAppVersion()) && hitPresetResource()) {
                    RVLogger.w(this.LOG_TAG, "prepareContent just hit presetResource!");
                    return;
                }
            }
            AppModel appModel4 = this.d;
            prepareContent(appModel4 != null ? appModel4.getAppVersion() : null);
            if (z) {
                try {
                    getSetupLock().await(5L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    RVLogger.w(this.LOG_TAG, "prepareContent block error", e);
                }
                String str3 = this.LOG_TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("prepareContent block ");
                sb3.append(System.currentTimeMillis() - currentTimeMillis);
                sb3.append(" ms");
                RVLogger.d(str3, sb3.toString());
            }
        }
    }

    public void onPresetParseDone() {
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPresetPrepareDone cost: ");
        sb.append(SystemClock.elapsedRealtime() - this.f6221a);
        RVLogger.d(str, sb.toString());
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onPrepareDone(boolean z) {
        super.onPrepareDone(z);
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPrepareDone cost: ");
        sb.append(SystemClock.elapsedRealtime() - this.f6221a);
        RVLogger.d(str, sb.toString());
    }

    protected AppModel prepareAppModel(AppInfoQuery appInfoQuery) {
        ResourceContext resourceContext = this.mResourceContext;
        AppModel mainPackageInfo = (resourceContext == null || !this.appId.equalsIgnoreCase(resourceContext.getAppId())) ? null : this.mResourceContext.getMainPackageInfo();
        return mainPackageInfo == null ? this.mAppInfoManager.getAppModel(appInfoQuery) : mainPackageInfo;
    }

    public void prepareContent(String str) {
        a(this.appId, str);
        boolean z = false;
        boolean z2 = (TextUtils.isEmpty(this.appVersion) || TextUtils.isEmpty(str) || str.equalsIgnoreCase(this.appVersion)) ? false : true;
        AppModel appModel = this.d;
        if (appModel != null && this.resourceManager.isAvailable(appModel)) {
            z = true;
        }
        String str2 = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("prepareContent appId:");
        sb.append(this.appId);
        sb.append(" appVersion ");
        sb.append(str);
        sb.append(" installed:");
        sb.append(z);
        RVLogger.d(str2, sb.toString());
        if (!z2 && count() != 0) {
            RVLogger.d(this.LOG_TAG, "!versionChanged return");
            return;
        }
        this.appVersion = str;
        if (!z) {
            onNotInstalled();
        } else {
            parseContent(this.appId, this.resourceManager.getInstallPath(this.d));
        }
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("AriverRes:Package_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        this.LOG_TAG = sb.toString();
    }

    void hotUpdateApp(String str, String str2) {
        if (this.mAppInfoManager == null) {
            RVLogger.e(this.LOG_TAG, "failed to get app provider!");
            return;
        }
        String str3 = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("hotUpdateApp hotVersion: ");
        sb.append(str);
        sb.append(" appVersion:");
        sb.append(this.appVersion);
        RVLogger.d(str3, sb.toString());
        if (this.resourceManager.isAvailable(this.d)) {
            if (str2 == null) {
                str2 = this.resourceManager.getInstallPath(this.d);
            }
            parseContent(this.appId, str2);
            return;
        }
        RVLogger.w(this.LOG_TAG, "hot update but not installed!");
        getParseLock().countDown();
    }

    public AppModel getAppModel() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("package {");
        sb.append(this.appId);
        sb.append("_");
        sb.append(this.appVersion);
        sb.append("} size: ");
        sb.append(count());
        return sb.toString();
    }

    public boolean hitPresetResource() {
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        Map<String, AppModel> presetAppInfos;
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        if (rVResourcePresetProxy == null || (presetPackage = rVResourcePresetProxy.getPresetPackage()) == null || !presetPackage.containsKey(this.appId)) {
            return false;
        }
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("prepareForDegrade found preset pkg ");
        sb.append(this.appId);
        RVLogger.d(str, sb.toString());
        RVResourcePresetProxy.PresetPackage presetPackage2 = presetPackage.get(this.appId);
        if (this.mAppInfoManager.getAppModel(AppInfoQuery.make(this.appId).version(presetPackage2.getVersion())) == null && (presetAppInfos = rVResourcePresetProxy.getPresetAppInfos()) != null && presetAppInfos.containsKey(this.appId)) {
            this.d = presetAppInfos.get(this.appId);
        }
        if (this.d != null) {
            RVLogger.d(this.LOG_TAG, "prepareForDegrade start install preset pkg!");
            String version = presetPackage2.getVersion();
            this.appVersion = version;
            a(this.appId, version);
            boolean a2 = a(presetPackage2.getInputStream());
            if (a2) {
                onPresetParseDone();
            }
            return a2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.InputStream r14) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.content.BaseResourcePackage.a(java.io.InputStream):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class HotUpdatePackageInstallCallback implements PackageInstallCallback {

        /* renamed from: a */
        private boolean f6222a;

        public HotUpdatePackageInstallCallback() {
            BaseResourcePackage.this = r1;
            this.f6222a = false;
        }

        public HotUpdatePackageInstallCallback(boolean z) {
            BaseResourcePackage.this = r1;
            this.f6222a = z;
        }

        @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
        public final void onResult(boolean z, String str) {
            String str2 = BaseResourcePackage.this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("HotUpdatePackageInstallCallback onResult install result: ");
            sb.append(z);
            sb.append(" installPath: ");
            sb.append(str);
            sb.append(" forceUpdate: ");
            sb.append(this.f6222a);
            RVLogger.d(str2, sb.toString());
            if (!BaseResourcePackage.this.isDetached() && z) {
                if (BaseResourcePackage.this.d == null) {
                    BaseResourcePackage baseResourcePackage = BaseResourcePackage.this;
                    baseResourcePackage.d = baseResourcePackage.mAppInfoManager.getAppModel(AppInfoQuery.make(BaseResourcePackage.this.appId).version(BaseResourcePackage.this.appVersion));
                }
                if (BaseResourcePackage.this.d == null) {
                    RVLogger.e(BaseResourcePackage.this.LOG_TAG, "HotUpdatePackageInstallCallback onResult do not have AppModel!!!");
                    BaseResourcePackage.this.onPrepareDone(false);
                    return;
                }
                BaseResourcePackage baseResourcePackage2 = BaseResourcePackage.this;
                baseResourcePackage2.appVersion = baseResourcePackage2.d.getAppVersion();
                if (!this.f6222a) {
                    BaseResourcePackage baseResourcePackage3 = BaseResourcePackage.this;
                    if (!baseResourcePackage3.canHotUpdate(baseResourcePackage3.appVersion)) {
                        RVLogger.d(BaseResourcePackage.this.LOG_TAG, "canHotUpdate false");
                        return;
                    }
                }
                BaseResourcePackage baseResourcePackage4 = BaseResourcePackage.this;
                baseResourcePackage4.a(baseResourcePackage4.d.getAppId(), BaseResourcePackage.this.d.getAppVersion());
                BaseResourcePackage baseResourcePackage5 = BaseResourcePackage.this;
                baseResourcePackage5.hotUpdateApp(baseResourcePackage5.d.getAppVersion(), str);
                return;
            }
            RVLogger.d(BaseResourcePackage.this.LOG_TAG, "HotUpdatePackageInstallCallback onResult already released!");
            BaseResourcePackage.this.getSetupLock().countDown();
            BaseResourcePackage.this.getParseLock().countDown();
        }
    }

    public void setAppModel(AppModel appModel) {
        this.d = appModel;
    }
}
