package com.alibaba.ariver.integration.resource.interceptor;

import android.text.TextUtils;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.ContainerModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class TinyCheckAppXInterceptor implements StepInterceptor {
    private static final String TAG = "Ariver:TinyCheckAppXInterceptor";
    protected String mCheckingVersion;
    private PrepareCallback mPrepareCallback;
    private PrepareContext mPrepareContext;
    private PrepareController mPrepareController;
    private RVAppInfoManager mResourceAppManager;
    private boolean mAlreadyChecked = false;
    private boolean mUsingAppxNg = false;

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.mPrepareContext = prepareContext;
        this.mPrepareCallback = prepareCallback;
        this.mResourceAppManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        if (prepareStep.getType() == StepType.START && this.mPrepareContext.getAppModel() != null) {
            this.mPrepareController = prepareController;
            if (notNeedCheckSdkVersion(this.mPrepareContext)) {
                return false;
            }
            String declaredMinAppxVersion = getDeclaredMinAppxVersion(this.mPrepareContext);
            StringBuilder sb = new StringBuilder();
            sb.append("getDeclareMinAppVersion ");
            sb.append(declaredMinAppxVersion);
            RVLogger.d(TAG, sb.toString());
            if (!TextUtils.isEmpty(declaredMinAppxVersion)) {
                this.mCheckingVersion = declaredMinAppxVersion;
                this.mPrepareContext.setAppCreateStepType(prepareStep.getType());
                if (!checkAppxMinFrameworkVersion(this.mPrepareContext)) {
                    RVLogger.d(TAG, "framework version not compatible!!!");
                    return true;
                }
            } else {
                this.mPrepareContext.setAppCreateStepType(prepareStep.getType());
                if (!checkAppxMinVersion(this.mPrepareContext)) {
                    RVLogger.d(TAG, "deploy version not compatible!!!");
                    return true;
                }
            }
        }
        return false;
    }

    private String getDeclaredMinAppxVersion(PrepareContext prepareContext) {
        String string;
        boolean equalsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(prepareContext.getStartParams(), "appxRouteFramework"));
        String appxMinFrameworkVersionFromPackage = getAppxMinFrameworkVersionFromPackage(this.mPrepareContext.getAppModel(), equalsIgnoreCase);
        JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("ta_minFrameworkVersion");
        if (equalsIgnoreCase) {
            string = JSONUtils.getString(configJSONObject, "appxNg");
        } else {
            string = JSONUtils.getString(configJSONObject, "appx");
        }
        if (RVResourceUtils.compareVersion(string, appxMinFrameworkVersionFromPackage) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkAppxMinFrameworkVersion...get minVersion from config: ");
            sb.append(configJSONObject);
            RVLogger.d(TAG, sb.toString());
            return string;
        }
        return appxMinFrameworkVersionFromPackage;
    }

    public boolean checkAppxMinVersion(PrepareContext prepareContext) {
        String appxMinVersionFromPackage = getAppxMinVersionFromPackage(prepareContext.getAppModel());
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_minSdkVersion", "");
        if (RVResourceUtils.compareVersion(config, appxMinVersionFromPackage) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkAppxMinVersion...get minVersion from config: ");
            sb.append(config);
            RVLogger.d(TAG, sb.toString());
            appxMinVersionFromPackage = config;
        }
        if (TextUtils.isEmpty(appxMinVersionFromPackage)) {
            return true;
        }
        AppModel appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make("66666692"));
        String appVersion = appModel != null ? appModel.getAppVersion() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("checkAppxMinVersion...min: ");
        sb2.append(appxMinVersionFromPackage);
        sb2.append(",current: ");
        sb2.append(appVersion);
        RVLogger.d(TAG, sb2.toString());
        if (TextUtils.isEmpty(appVersion)) {
            handleForceUpdateAppInfo(false);
            return false;
        }
        this.mCheckingVersion = appxMinVersionFromPackage;
        int compareVersion = RVResourceUtils.compareVersion(appVersion, appxMinVersionFromPackage);
        if (compareVersion == 1 || compareVersion == 0) {
            return true;
        }
        handleForceUpdateAppInfo(false);
        return false;
    }

    protected boolean notNeedCheckSdkVersion(PrepareContext prepareContext) {
        JSONArray parseArray;
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_setMinAppxBlacklist", null);
        if (TextUtils.isEmpty(config) || (parseArray = JSONUtils.parseArray(config)) == null) {
            return false;
        }
        if (parseArray.contains("all") || parseArray.contains(prepareContext.getAppId())) {
            StringBuilder sb = new StringBuilder();
            sb.append("isNeedCheck hit blacklist ta_setMinAppxBlacklist: ");
            sb.append(config);
            RVLogger.d(TAG, sb.toString());
            return true;
        }
        return false;
    }

    public boolean checkAppxMinFrameworkVersion(PrepareContext prepareContext) {
        AppModel appModel;
        if ("YES".equalsIgnoreCase(BundleUtils.getString(prepareContext.getStartParams(), "appxRouteFramework"))) {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion check appx-ng version");
            appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make("68687209"));
            this.mUsingAppxNg = true;
        } else {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion check appx version");
            appModel = this.mResourceAppManager.getAppModel(AppInfoQuery.make("66666692"));
        }
        String string = appModel != null ? JSONUtils.getString(appModel.getExtendInfos(), "appxVersion") : null;
        StringBuilder sb = new StringBuilder();
        sb.append("checkAppxMinFrameworkVersion...min: ");
        sb.append(this.mCheckingVersion);
        sb.append(",current: ");
        sb.append(string);
        RVLogger.d(TAG, sb.toString());
        if (TextUtils.isEmpty(string)) {
            RVLogger.d(TAG, "checkAppxMinFrameworkVersion...get sdk version null, just ignore this check!");
            return true;
        }
        int compareVersion = RVResourceUtils.compareVersion(string, this.mCheckingVersion);
        if (compareVersion == 1 || compareVersion == 0) {
            return true;
        }
        handleForceUpdateAppInfo(true);
        return false;
    }

    public String getAppxMinVersionFromPackage(AppModel appModel) {
        ContainerModel containerInfo;
        if (appModel == null || (containerInfo = appModel.getContainerInfo()) == null) {
            return null;
        }
        String string = JSONUtils.getString(containerInfo.getLaunchParams(), "minSDKVersion");
        return !TextUtils.isEmpty(string) ? string : JSONUtils.getString(containerInfo.getLaunchParams(), "minSdkVersion");
    }

    public String getAppxMinFrameworkVersionFromPackage(AppModel appModel, boolean z) {
        ContainerModel containerInfo;
        if (appModel == null || (containerInfo = appModel.getContainerInfo()) == null) {
            return null;
        }
        if (z && JSONUtils.contains(containerInfo.getLaunchParams(), "minAppxNgVersion")) {
            return JSONUtils.getString(containerInfo.getLaunchParams(), "minAppxNgVersion");
        }
        return JSONUtils.getString(containerInfo.getLaunchParams(), "minAppxVersion");
    }

    private void handleForceUpdateAppInfo(boolean z) {
        if (!this.mAlreadyChecked) {
            forceUpdateAppInfo(z);
        } else {
            onUpdateFail(z);
        }
    }

    public void onUpdateSuccess(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onUpdateSuccess checkRealSdkVersion: ");
        sb.append(z);
        RVLogger.d(TAG, sb.toString());
    }

    public void onUpdateFail(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onUpdateFail checkRealSdkVersion: ");
        sb.append(z);
        RVLogger.d(TAG, sb.toString());
        PrepareCallback prepareCallback = this.mPrepareCallback;
        PrepareData prepareData = this.mPrepareContext.getPrepareData();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Appx check failed: ");
        sb2.append(this.mCheckingVersion);
        prepareCallback.prepareFail(prepareData, new PrepareException("7", sb2.toString()));
    }

    protected void forceUpdateAppInfo(final boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("forceUpdateAppInfo...");
        sb.append(this.mPrepareContext);
        RVLogger.d(TAG, sb.toString());
        this.mPrepareController.postTimeOut(this.mPrepareContext.getTimeout());
        this.mPrepareCallback.showLoading(true, this.mPrepareContext.getEntryInfo());
        ResourceUtils.prepare(this.mUsingAppxNg ? "68687209" : "66666692", z ? "*" : this.mCheckingVersion, new PackageInstallCallback() { // from class: com.alibaba.ariver.integration.resource.interceptor.TinyCheckAppXInterceptor.1
            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z2, String str) {
                boolean checkAppxMinVersion;
                TinyCheckAppXInterceptor.this.mAlreadyChecked = true;
                if (z2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("prepareUpdate...onSuccess, checkRealSdkVersion: ");
                    sb2.append(z);
                    RVLogger.d(TinyCheckAppXInterceptor.TAG, sb2.toString());
                    if (z) {
                        TinyCheckAppXInterceptor tinyCheckAppXInterceptor = TinyCheckAppXInterceptor.this;
                        checkAppxMinVersion = tinyCheckAppXInterceptor.checkAppxMinFrameworkVersion(tinyCheckAppXInterceptor.mPrepareContext);
                    } else {
                        TinyCheckAppXInterceptor tinyCheckAppXInterceptor2 = TinyCheckAppXInterceptor.this;
                        checkAppxMinVersion = tinyCheckAppXInterceptor2.checkAppxMinVersion(tinyCheckAppXInterceptor2.mPrepareContext);
                    }
                    if (checkAppxMinVersion) {
                        IpcServerUtils.sendMsgToClient(TinyCheckAppXInterceptor.this.mPrepareContext.getAppId(), TinyCheckAppXInterceptor.this.mPrepareContext.getStartToken(), 13, null);
                        TinyCheckAppXInterceptor.this.onUpdateSuccess(z);
                        TinyCheckAppXInterceptor.this.mPrepareController.moveToNext();
                        return;
                    }
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("prepareUpdate...onError, checkRealSdkVersion: ");
                sb3.append(z);
                RVLogger.d(TinyCheckAppXInterceptor.TAG, sb3.toString());
                TinyCheckAppXInterceptor.this.onUpdateFail(z);
            }
        });
    }
}
