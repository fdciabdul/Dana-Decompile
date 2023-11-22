package com.alibaba.ariver.resource.content;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.extension.ParsePackageSuccessPoint;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourcePresetProxy;
import com.alibaba.ariver.resource.content.BaseResourcePackage;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class NormalResourcePackage extends BaseResourcePackage {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6226a;

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    protected boolean canHotUpdate(String str) {
        return true;
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    protected boolean needWaitSetupWhenGet() {
        return false;
    }

    public NormalResourcePackage(String str, ResourceContext resourceContext) {
        super(str, resourceContext);
        this.f6226a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void onParsePackageSuccess(ParseContext parseContext) {
        super.onParsePackageSuccess(parseContext);
        if (this.mResourceContext != null) {
            Bundle bundle = new Bundle();
            bundle.putString("appId", parseContext.appId);
            ((ParsePackageSuccessPoint) ExtensionPoint.as(ParsePackageSuccessPoint.class).node(this.mResourceContext.getApp()).create()).onParsePackageSuccess(bundle);
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseResourcePackage
    void onNotInstalled() {
        this.f6226a = false;
        boolean z = getAppModel() != null && this.resourceManager.isDownloaded(getAppModel());
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onNotInstalled ");
        sb.append(this.appId);
        sb.append(" ");
        sb.append(this.appVersion);
        sb.append(" isDownloaded: ");
        sb.append(z);
        RVLogger.d(str, sb.toString());
        if (z) {
            ResourceUtils.prepare(this.appId, this.appVersion, new BaseResourcePackage.HotUpdatePackageInstallCallback(!"NO".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("nebulax_hotUpdateInDownload", "YES"))));
            return;
        }
        boolean z2 = this.mResourceContext == null;
        final String str2 = this.appVersion;
        if (a(str2)) {
            this.f6226a = true;
        } else {
            getParseLock().countDown();
        }
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.resource.content.NormalResourcePackage.1
            @Override // java.lang.Runnable
            public void run() {
                ResourceUtils.prepare(NormalResourcePackage.this.appId, str2, new BaseResourcePackage.HotUpdatePackageInstallCallback());
            }
        };
        if (z2 || this.f6226a) {
            ExecutorUtils.getScheduledExecutor().schedule(runnable, 5L, TimeUnit.SECONDS);
        } else {
            ExecutorUtils.execute(ExecutorType.URGENT, runnable);
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public Resource get(ResourceQuery resourceQuery) {
        if (resourceQuery.isDisableResourcePackage()) {
            RVLogger.d(this.LOG_TAG, "disable resource package!");
            return null;
        } else if (this.f6226a && resourceQuery.isMainDoc()) {
            RVLogger.d(this.LOG_TAG, "main url cannot degrade!");
            return null;
        } else {
            return super.get(resourceQuery);
        }
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage
    public void beforeParsePackage(ParseContext parseContext) {
        super.beforeParsePackage(parseContext);
        parseContext.onlineHost = null;
    }

    private boolean a(String str) {
        JSONObject configJSONObject;
        Map<String, RVResourcePresetProxy.PresetPackage> presetPackage;
        String installedAppVersion = this.resourceManager.getInstalledAppVersion(this.appId);
        if (TextUtils.isEmpty(installedAppVersion)) {
            if (hitPresetResource()) {
                RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 0!");
                return true;
            }
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] failed - 0!");
            return false;
        }
        boolean z = (TextUtils.isEmpty(installedAppVersion) || TextUtils.equals(installedAppVersion, str)) ? false : true;
        AppModel appModel = this.mAppInfoManager.getAppModel(AppInfoQuery.make(this.appId).version(installedAppVersion));
        RVResourcePresetProxy rVResourcePresetProxy = (RVResourcePresetProxy) RVProxy.get(RVResourcePresetProxy.class);
        String str2 = null;
        if (rVResourcePresetProxy != null && (presetPackage = rVResourcePresetProxy.getPresetPackage()) != null && presetPackage.containsKey(this.appId)) {
            str2 = presetPackage.get(this.appId).getVersion();
            String str3 = this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("[prepareForDegrade] found preset version: ");
            sb.append(str2);
            RVLogger.d(str3, sb.toString());
        }
        if (appModel != null) {
            if (TextUtils.equals(str2, appModel.getAppVersion())) {
                RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 1-1!");
                return hitPresetResource();
            } else if (z) {
                String str4 = this.LOG_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[prepareForDegrade] degrade for current installed version: ");
                sb2.append(installedAppVersion);
                RVLogger.d(str4, sb2.toString());
                if (appModel != null && (configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("ta_addPkgResStricklyMatch")) != null) {
                    String string = JSONUtils.getString(configJSONObject, this.appId);
                    if (!TextUtils.isEmpty(string)) {
                        boolean z2 = RVResourceUtils.compareVersion(appModel.getAppVersion(), string) < 0;
                        String str5 = this.LOG_TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("downgrade got minVersion from cfg: ");
                        sb3.append(string);
                        sb3.append(", current: ");
                        sb3.append(appModel.getAppVersion());
                        sb3.append("cantDowngrade = ");
                        sb3.append(z2);
                        RVLogger.d(str5, sb3.toString());
                        if (z2) {
                            return false;
                        }
                    }
                }
                setAppModel(appModel);
                prepareContent(installedAppVersion);
                return true;
            } else if (hitPresetResource()) {
                RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 1-2!");
                return true;
            } else {
                return false;
            }
        } else if (hitPresetResource()) {
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] hitPresetResource - 2!");
            return true;
        } else {
            RVLogger.d(this.LOG_TAG, "[prepareForDegrade] failed!");
            return false;
        }
    }
}
