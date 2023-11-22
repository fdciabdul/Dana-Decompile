package com.alibaba.griver.base.resource.interceptor;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PermissionModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.ui.splash.SplashEntryInfo;
import com.alibaba.griver.base.R;
import com.alibaba.griver.base.api.GriverAsyncUpdateManager;
import com.alibaba.griver.base.api.GriverPerformanceStages;
import com.alibaba.griver.base.appxng.GriverAppxNgRuntimeChecker;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.MonitorUtils;
import com.alibaba.griver.base.resource.GriverDynamicResManager;
import com.alibaba.griver.base.resource.GriverRVResourceManagerImpl;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class GriverPrepareInterceptor implements StepInterceptor {
    public static final int PROGRESS_STEP_OFFLINE = 30;
    public static final float PROGRESS_STEP_OFFLINE_RATE = 0.6f;
    public static final int PROGRESS_STEP_SETUP = 0;
    public static final int PROGRESS_STEP_START = 90;
    public static final int PROGRESS_STEP_START_END = 100;
    public static final int PROGRESS_STEP_UPDATE = 10;
    public static final String TAG = "GriverPrepareInterceptor";

    /* renamed from: a  reason: collision with root package name */
    private PrepareContext f6365a;
    private PrepareCallback b;
    private GriverFullLinkStageMonitor c;
    public boolean needShowLoading;

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void init(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.f6365a = prepareContext;
        this.b = prepareCallback;
        this.c = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(prepareContext.getAppId(), String.valueOf(prepareContext.getStartToken())));
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public void onGetAppInfo(AppModel appModel) {
        Bundle startParams;
        if (appModel == null || (startParams = this.f6365a.getStartParams()) == null) {
            return;
        }
        startParams.putString("appVersion", appModel.getAppVersion());
        try {
            startParams.putBoolean(PermissionConstant.STARTPARAMS_IGNORE_HTTP_REQUEST_PERMISSION, appModel.getExtendInfos().getJSONObject("extData").getJSONObject("packageInfo").getJSONObject("extendInfo").getJSONObject(RVConstants.EXTRA_RES_LAUNCH_PARAMS).getBoolean(PermissionConstant.STARTPARAMS_IGNORE_HTTP_REQUEST_PERMISSION).booleanValue());
            startParams.putBoolean("ignoreWebViewDomainCheck", appModel.getExtendInfos().getJSONObject("extData").getJSONObject("packageInfo").getJSONObject("extendInfo").getJSONObject(RVConstants.EXTRA_RES_LAUNCH_PARAMS).getBoolean("ignoreWebViewDomainCheck").booleanValue());
        } catch (Exception unused) {
            GriverLogger.w(TAG, "get launchParams ignoreHttpReqPermission ignoreWebViewDomainCheck failed");
        }
        try {
            appModel.getExtendInfos().remove("appxVersion");
            if (GriverAppxNgRuntimeChecker.isUseAppxNg(appModel, startParams)) {
                startParams.putString("appxVersion", "2");
                appModel.getExtendInfos().put("appxVersion", "2");
            } else {
                startParams.putString("appxVersion", "1");
                appModel.getExtendInfos().put("appxVersion", "1");
            }
            GriverAppCenter.updateAppInfo(appModel);
        } catch (Exception unused2) {
            GriverLogger.w(TAG, "get appx ng");
        }
        if (appModel.getAppInfoModel() == null || this.c == null) {
            return;
        }
        this.c.addParamUnique("appName", appModel.getAppInfoModel().getName());
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean onError(PrepareException prepareException, PrepareController prepareController) {
        AppModel appModel = this.f6365a.getAppModel();
        if (appModel == null || TextUtils.isEmpty(appModel.getAppId())) {
            return false;
        }
        RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager instanceof GriverRVResourceManagerImpl) {
            ((GriverRVResourceManagerImpl) rVResourceManager).removeDownloadCallback(appModel.getAppId());
            return false;
        }
        return false;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean before(PrepareStep prepareStep, PrepareController prepareController) {
        if (prepareStep.getType() == StepType.SETUP) {
            GriverFullLinkStageMonitor griverFullLinkStageMonitor = this.c;
            if (griverFullLinkStageMonitor != null) {
                griverFullLinkStageMonitor.transitToNext(PerfId.setupStart);
            }
            GriverDynamicResManager.getInstance().start(this.f6365a.getAppId());
        } else if (prepareStep.getType() == StepType.UPDATE) {
            GriverFullLinkStageMonitor griverFullLinkStageMonitor2 = this.c;
            if (griverFullLinkStageMonitor2 != null) {
                griverFullLinkStageMonitor2.transitToNext(GriverPerformanceStages.KEY_APP_INFO_START);
            }
            PrepareContext prepareContext = this.f6365a;
            prepareContext.setEntryInfo(getEntryInfo(prepareContext.getAppModel(), 10, false));
            if (this.f6365a.updateMode == UpdateMode.SYNC_FORCE) {
                this.needShowLoading = true;
            }
            PrepareCallback prepareCallback = this.b;
            if (prepareCallback != null && this.needShowLoading) {
                prepareCallback.showLoading(false, this.f6365a.getEntryInfo());
            }
        } else if (prepareStep.getType() == StepType.OFFLINE) {
            AppModel appModel = this.f6365a.getAppModel();
            if (appModel != null && !TextUtils.isEmpty(appModel.getAppId())) {
                RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
                if (rVResourceManager instanceof GriverRVResourceManagerImpl) {
                    ((GriverRVResourceManagerImpl) rVResourceManager).addDownloadCallback(appModel.getAppId(), new PackageDownloadCallback() { // from class: com.alibaba.griver.base.resource.interceptor.GriverPrepareInterceptor.1
                        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                        public void onCancel(String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                        public void onFailed(String str, int i, String str2) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                        public void onFinish(String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                        public void onPrepare(String str) {
                            GriverPrepareInterceptor.this.needShowLoading = true;
                        }

                        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                        public void onProgress(String str, int i) {
                            int i2 = (int) ((i * 0.6f) + 30.0f);
                            if (i2 != ((Integer) GriverPrepareInterceptor.this.f6365a.getEntryInfo().extraInfo.get("progress")).intValue()) {
                                PrepareContext prepareContext2 = GriverPrepareInterceptor.this.f6365a;
                                GriverPrepareInterceptor griverPrepareInterceptor = GriverPrepareInterceptor.this;
                                prepareContext2.setEntryInfo(griverPrepareInterceptor.getEntryInfo(griverPrepareInterceptor.f6365a.getAppModel(), i2, false));
                                if (GriverPrepareInterceptor.this.b != null) {
                                    GriverPrepareInterceptor.this.b.updateLoading(GriverPrepareInterceptor.this.f6365a.getEntryInfo(), GriverPrepareInterceptor.this.f6365a.getAppModel());
                                }
                            }
                        }
                    });
                }
            }
        } else if (prepareStep.getType() == StepType.START) {
            PrepareContext prepareContext2 = this.f6365a;
            prepareContext2.setEntryInfo(getEntryInfo(prepareContext2.getAppModel(), 90, false));
            PrepareCallback prepareCallback2 = this.b;
            if (prepareCallback2 != null && this.needShowLoading) {
                prepareCallback2.updateLoading(this.f6365a.getEntryInfo(), this.f6365a.getAppModel());
            }
            a();
        }
        return false;
    }

    private void a() {
        AppModel appModel;
        try {
            PrepareContext prepareContext = this.f6365a;
            if (prepareContext != null) {
                Bundle startParams = prepareContext.getStartParams();
                AppInfoScene extractScene = AppInfoScene.extractScene(startParams);
                if ((startParams == null || !AppInfoScene.isDevSource(startParams)) && extractScene.ordinal() != AppInfoScene.DEBUG.ordinal() && extractScene.ordinal() != AppInfoScene.REVIEW.ordinal() && extractScene.ordinal() != AppInfoScene.TRIAL.ordinal() && extractScene.ordinal() != AppInfoScene.INSPECT.ordinal() && extractScene.ordinal() != AppInfoScene.YUNTEST.ordinal()) {
                    startParams.putString("envVersion", "release");
                    if (this.f6365a.getAppModel() != null && this.f6365a.getAppModel().getAppInfoModel() != null) {
                        startParams.putString("package_nick", this.f6365a.getAppModel().getAppInfoModel().getDeveloperVersion());
                    }
                    appModel = this.f6365a.getAppModel();
                    if (appModel != null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    JSONObject jSONObject = new JSONObject();
                    for (PluginModel pluginModel : appModel.getAppInfoModel().getPlugins()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("attach plugin model package: ");
                        sb.append(pluginModel);
                        sb.append(" permission: ");
                        sb.append(pluginModel.getPermission());
                        RVLogger.d(TAG, sb.toString());
                        arrayList.add(pluginModel.getAppId());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("version", pluginModel.getVersion());
                        PermissionModel pluginPermissionModel = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).getPluginPermissionModel(appModel.getAppId(), pluginModel.getAppId());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("check plugin:");
                        sb2.append(pluginModel.getAppId());
                        sb2.append(" permission:");
                        sb2.append(pluginPermissionModel);
                        RVLogger.d(TAG, sb2.toString());
                        JSONArray jSONArray = new JSONArray();
                        if (pluginPermissionModel != null) {
                            for (String str : pluginPermissionModel.getJsapiList()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("check plugin:");
                                sb3.append(pluginModel.getAppId());
                                sb3.append(" api: ");
                                sb3.append(str);
                                RVLogger.d(TAG, sb3.toString());
                                if (!TextUtils.isEmpty(str) && str.startsWith("_appxFwExtra_")) {
                                    jSONArray.add(str);
                                }
                            }
                        }
                        jSONObject2.put("componentContext", (Object) jSONArray);
                        jSONObject2.put("developerVersion", pluginModel.getDeveloperVersion());
                        jSONObject.put(pluginModel.getAppId(), (Object) jSONObject2);
                    }
                    try {
                        startParams.putStringArrayList(RVStartParams.KEY_APPX_PLUGINS, arrayList);
                        startParams.putSerializable(RVStartParams.KEY_APPX_PLUGINS_EXTRA, jSONObject);
                        return;
                    } catch (Throwable th) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("add start params error: ");
                        sb4.append(th.getMessage());
                        RVLogger.d(TAG, sb4.toString());
                        return;
                    }
                }
                startParams.putString("envVersion", "develop");
                if (this.f6365a.getAppModel() != null) {
                    startParams.putString("package_nick", this.f6365a.getAppModel().getAppInfoModel().getDeveloperVersion());
                }
                appModel = this.f6365a.getAppModel();
                if (appModel != null) {
                }
            }
        } catch (Exception e) {
            GriverLogger.e(TAG, "appendStartParams", e);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepInterceptor
    public boolean after(PrepareStep prepareStep, PrepareController prepareController) {
        AppModel queryAppInfo;
        if (prepareStep.getType() == StepType.SETUP) {
            GriverFullLinkStageMonitor griverFullLinkStageMonitor = this.c;
            if (griverFullLinkStageMonitor != null) {
                griverFullLinkStageMonitor.transitToNext(PerfId.setupEnd);
            }
            String appId = this.f6365a.getAppId();
            if (this.f6365a.updateMode != UpdateMode.SYNC_FORCE) {
                long syncUpdatePeriod = GriverAppConfig.getInstance().getSyncUpdatePeriod();
                if (a(appId) || AppInfoUtils.isOutOfTime(appId, syncUpdatePeriod) || (!TextUtils.isEmpty(GriverEnv.getEnvironment()) && !"prod".equalsIgnoreCase(GriverEnv.getEnvironment().trim()))) {
                    this.f6365a.updateMode = UpdateMode.SYNC_FORCE;
                    this.f6365a.getPrepareData().setRequestMode(this.f6365a.updateMode);
                }
            }
        } else if (prepareStep.getType() == StepType.UPDATE) {
            AppModel appModel = this.f6365a.getAppModel();
            if (appModel != null && (queryAppInfo = GriverAppCenter.queryAppInfo(appModel.getAppId(), appModel.getAppVersion())) != null && (TextUtils.equals(AppInfoUtils.getPublishingStatus(queryAppInfo), "SUSPENDED") || TextUtils.equals(AppInfoUtils.getPublishingStatus(queryAppInfo), "REMOVED") || 2 != AppInfoUtils.getAppType(queryAppInfo))) {
                if (2 != AppInfoUtils.getAppType(queryAppInfo)) {
                    prepareController.moveToError(new PrepareException("10003", GriverEnv.getResources().getString(R.string.griver_app_not_exist)));
                    return true;
                } else if (TextUtils.equals(AppInfoUtils.getPublishingStatus(queryAppInfo), "SUSPENDED")) {
                    prepareController.moveToError(new PrepareException("1002", GriverEnv.getResources().getString(R.string.griver_app_suspended)));
                    return true;
                } else if (TextUtils.equals(AppInfoUtils.getPublishingStatus(queryAppInfo), "REMOVED")) {
                    prepareController.moveToError(new PrepareException("1001", GriverEnv.getResources().getString(R.string.griver_app_removed)));
                    return true;
                } else {
                    return true;
                }
            }
            GriverFullLinkStageMonitor griverFullLinkStageMonitor2 = this.c;
            if (griverFullLinkStageMonitor2 != null) {
                griverFullLinkStageMonitor2.transitToNext(GriverPerformanceStages.KEY_APP_INFO_END);
            }
        } else if (prepareStep.getType() == StepType.OFFLINE) {
            AppModel appModel2 = this.f6365a.getAppModel();
            if (appModel2 != null && !TextUtils.isEmpty(appModel2.getAppId())) {
                RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
                if (rVResourceManager instanceof GriverRVResourceManagerImpl) {
                    ((GriverRVResourceManagerImpl) rVResourceManager).removeDownloadCallback(appModel2.getAppId());
                }
            }
            GriverFullLinkStageMonitor griverFullLinkStageMonitor3 = this.c;
            if (griverFullLinkStageMonitor3 != null) {
                griverFullLinkStageMonitor3.transitToNext(GriverPerformanceStages.KEY_RESOURCE_READY);
            }
        } else if (prepareStep.getType() == StepType.START) {
            if (AppInfoUtils.isOutOfTime(this.f6365a.getAppId(), GriverAppConfig.getInstance().getAsyncUpdatePeriod())) {
                b();
                GriverFullLinkStageMonitor griverFullLinkStageMonitor4 = this.c;
                if (griverFullLinkStageMonitor4 != null) {
                    griverFullLinkStageMonitor4.addParam(GriverMonitorConstants.KEY_START_MODE, GriverMonitorConstants.MINI_PROGRAM_START_ASYNC_UPDATE);
                }
            } else {
                GriverFullLinkStageMonitor griverFullLinkStageMonitor5 = this.c;
                if (griverFullLinkStageMonitor5 != null) {
                    griverFullLinkStageMonitor5.addParam(GriverMonitorConstants.KEY_START_MODE, GriverMonitorConstants.MINI_PROGRAM_START_NO_UPDATE);
                }
            }
            if (this.f6365a.updateMode == UpdateMode.SYNC_FORCE) {
                if (this.f6365a.isOriginHasAppInfo()) {
                    GriverFullLinkStageMonitor griverFullLinkStageMonitor6 = this.c;
                    if (griverFullLinkStageMonitor6 != null) {
                        griverFullLinkStageMonitor6.addParam(GriverMonitorConstants.KEY_START_MODE, GriverMonitorConstants.MINI_PROGRAM_START_SYNC_UPDATE);
                    }
                } else {
                    GriverFullLinkStageMonitor griverFullLinkStageMonitor7 = this.c;
                    if (griverFullLinkStageMonitor7 != null) {
                        griverFullLinkStageMonitor7.addParam(GriverMonitorConstants.KEY_START_MODE, GriverMonitorConstants.MINI_PROGRAM_START_NO_EXIST);
                    }
                }
            }
            GriverFullLinkStageMonitor griverFullLinkStageMonitor8 = this.c;
            if (griverFullLinkStageMonitor8 != null) {
                griverFullLinkStageMonitor8.addParam("sourceInfo", MonitorUtils.getSourceInfoFromStartupParams(this.f6365a.getStartParams()));
            }
            if (this.b != null && this.needShowLoading) {
                PrepareContext prepareContext = this.f6365a;
                prepareContext.setEntryInfo(getEntryInfo(prepareContext.getAppModel(), 100, false));
                this.b.updateLoading(this.f6365a.getEntryInfo(), this.f6365a.getAppModel());
            }
        }
        return false;
    }

    private void b() {
        if (AppInfoScene.isDevSource(this.f6365a.getStartParams())) {
            GriverLogger.d(TAG, "not updateAppAsync by debug scene!");
            return;
        }
        long appAsyncUpdateDelay = GriverAppConfig.getInstance().getAppAsyncUpdateDelay();
        ScheduledThreadPoolExecutor scheduledExecutor = GriverExecutors.getScheduledExecutor();
        if (scheduledExecutor != null) {
            scheduledExecutor.schedule(new Runnable() { // from class: com.alibaba.griver.base.resource.interceptor.GriverPrepareInterceptor.2
                @Override // java.lang.Runnable
                public void run() {
                    String appId = GriverPrepareInterceptor.this.f6365a.getAppId();
                    String appVersion = GriverPrepareInterceptor.this.f6365a.getAppVersion();
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateAppAsync appId:");
                    sb.append(appId);
                    GriverLogger.d(GriverPrepareInterceptor.TAG, sb.toString());
                    UpdateAppParam updateAppParam = new UpdateAppParam(appId, appVersion);
                    HashMap hashMap = new HashMap();
                    hashMap.put(appId, appVersion);
                    updateAppParam.setRequestApps(hashMap);
                    final GriverAsyncUpdateManager griverAsyncUpdateManager = (GriverAsyncUpdateManager) RVProxy.get(GriverAsyncUpdateManager.class);
                    griverAsyncUpdateManager.setAppId(appId);
                    AppUpdaterFactory.createUpdater(appId, null).updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.griver.base.resource.interceptor.GriverPrepareInterceptor.2.1
                        @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                        public void onSuccess(List<AppModel> list) {
                            if (list == null || list.size() <= 0) {
                                return;
                            }
                            for (AppModel appModel : list) {
                                if (!AppInfoUtils.shouldInstall(appModel)) {
                                    griverAsyncUpdateManager.onUpdateResult(false);
                                } else {
                                    RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
                                    if (rVResourceManager != null) {
                                        if (rVResourceManager.isAvailable(appModel) || rVResourceManager.isDownloaded(appModel)) {
                                            griverAsyncUpdateManager.onUpdateResult(false);
                                        } else {
                                            int downloadType = AppInfoUtils.getDownloadType(appModel);
                                            if (downloadType == 2) {
                                                griverAsyncUpdateManager.onUpdateResult(false);
                                            } else if (downloadType == 0 && !"wifi".equalsIgnoreCase(NetworkUtil.getSimpleNetworkType(GriverEnv.getApplicationContext()))) {
                                                griverAsyncUpdateManager.onUpdateResult(false);
                                            } else {
                                                griverAsyncUpdateManager.onUpdateResult(true);
                                                rVResourceManager.downloadApp(appModel, false, new PackageDownloadCallback() { // from class: com.alibaba.griver.base.resource.interceptor.GriverPrepareInterceptor.2.1.1
                                                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                                                    public void onCancel(String str) {
                                                    }

                                                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                                                    public void onPrepare(String str) {
                                                    }

                                                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                                                    public void onProgress(String str, int i) {
                                                    }

                                                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                                                    public void onFinish(String str) {
                                                        griverAsyncUpdateManager.onDownloadResult(true);
                                                    }

                                                    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
                                                    public void onFailed(String str, int i, String str2) {
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("async download failed: ");
                                                        sb2.append(str);
                                                        sb2.append(", ");
                                                        sb2.append(i);
                                                        sb2.append(", ");
                                                        sb2.append(str2);
                                                        GriverLogger.w(GriverPrepareInterceptor.TAG, sb2.toString());
                                                        griverAsyncUpdateManager.onDownloadResult(false);
                                                    }
                                                });
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                        public void onError(UpdateAppException updateAppException) {
                            GriverLogger.w(GriverPrepareInterceptor.TAG, "async update failed with exception", updateAppException);
                        }
                    });
                }
            }, appAsyncUpdateDelay, TimeUnit.SECONDS);
        }
    }

    private boolean a(String str) {
        PrepareContext prepareContext = this.f6365a;
        if (prepareContext == null || TextUtils.isEmpty(prepareContext.getAppVersion())) {
            return false;
        }
        return GriverAppConfig.getInstance().ifSyncUpdate(str, this.f6365a.getAppVersion());
    }

    public EntryInfo getEntryInfo(AppModel appModel, int i, boolean z) {
        AppInfoModel appInfoModel;
        AppModel queryAppInfo;
        String language;
        String country;
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.extraInfo = new JSONObject();
        entryInfo.extraInfo.put("progress", (Object) Integer.valueOf(i));
        entryInfo.extraInfo.put(SplashEntryInfo.NEED_REFRESH, (Object) Boolean.valueOf(z));
        if (appModel == null || (appInfoModel = appModel.getAppInfoModel()) == null || (queryAppInfo = GriverAppCenter.queryAppInfo(appModel.getAppId(), appModel.getAppVersion())) == null) {
            return entryInfo;
        }
        entryInfo.iconUrl = appInfoModel.getLogo();
        entryInfo.title = appInfoModel.getName();
        entryInfo.desc = appInfoModel.getDesc();
        entryInfo.slogan = appInfoModel.getSlogan();
        JSONObject languages = AppInfoUtils.getLanguages(queryAppInfo);
        if (languages == null) {
            return entryInfo;
        }
        String appLanguage = GriverEnv.getAppLanguage();
        if (!TextUtils.isEmpty(appLanguage) && appLanguage.split("-").length == 2) {
            language = appLanguage.split("-")[0];
            country = appLanguage.split("-")[1];
        } else {
            language = Locale.getDefault().getLanguage();
            country = Locale.getDefault().getCountry();
        }
        if (TextUtils.isEmpty(language)) {
            return entryInfo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language);
        sb.append("-");
        sb.append(country);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(language);
        sb2.append("_");
        sb2.append(country);
        String obj2 = sb2.toString();
        String str = language;
        String a2 = a(obj, obj2, str, languages, "name");
        String a3 = a(obj, obj2, str, languages, "iconUrl");
        String a4 = a(obj, obj2, str, languages, "description");
        if (!TextUtils.isEmpty(a2)) {
            entryInfo.title = a2;
        }
        if (!TextUtils.isEmpty(a3)) {
            entryInfo.iconUrl = a3;
        }
        if (!TextUtils.isEmpty(a4)) {
            entryInfo.desc = a4;
        }
        return entryInfo;
    }

    private String a(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        if (jSONObject.containsKey(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            if (jSONObject2.containsKey(str4)) {
                return jSONObject2.getString(str4);
            }
        }
        if (jSONObject.containsKey(str2)) {
            JSONObject jSONObject3 = jSONObject.getJSONObject(str2);
            if (jSONObject3.containsKey(str4)) {
                return jSONObject3.getString(str4);
            }
        }
        if (jSONObject.containsKey(str3)) {
            JSONObject jSONObject4 = jSONObject.getJSONObject(str3);
            if (jSONObject4.containsKey(str4)) {
                return jSONObject4.getString(str4);
            }
            return null;
        }
        return null;
    }
}
