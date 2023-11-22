package com.alibaba.ariver.resource.prepare.steps;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTracePhase;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.appxng.AppxNgRuntimeChecker;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.subpackage.DefaultSubPackageDownloader;
import com.alibaba.ariver.resource.subpackage.DownloadQueryPoint;
import com.alibaba.ariver.resource.subpackage.ISubPackageDownloader;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class DownloadStep extends BasePrepareStep {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f6239a = new AtomicInteger(1);

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public /* bridge */ /* synthetic */ boolean isFinished() {
        return super.isFinished();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareStep
    public StepType getType() {
        return StepType.OFFLINE;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceBeginSection(sb.toString());
        super.execute(prepareController, prepareContext, prepareCallback);
        prepareContext.getPrepareData().setOfflineMode(prepareContext.offlineMode);
        offlineMode(prepareController, prepareContext, prepareCallback);
    }

    protected void offlineMode(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) {
        if (prepareContext.offlineMode.isSync()) {
            prepareController.lock(this);
            doSyncOffline(prepareController, prepareContext, prepareCallback);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceEndSection(sb.toString());
        RVLogger.e(this.LOG_TAG, "offlineMode is not Sync!");
    }

    protected void doSyncOffline(final PrepareController prepareController, final PrepareContext prepareContext, final PrepareCallback prepareCallback) {
        final AppModel appModel = prepareContext.getAppModel();
        if (appModel == null) {
            unlockAndMoveToNext(prepareController);
            return;
        }
        a(prepareContext.getAppModel(), prepareContext, prepareController, prepareCallback);
        if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null && appModel.getAppInfoModel().getPlugins().size() > 0) {
            this.f6239a.addAndGet(1);
            RVLogger.d(this.LOG_TAG, "doSyncOffline with plugins!");
            ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadStep.this.checkMainPackage(prepareController, prepareContext, prepareCallback);
                }
            });
            ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadStep downloadStep = DownloadStep.this;
                    AppModel appModel2 = appModel;
                    downloadStep.a(appModel2, appModel2.getAppInfoModel().getPlugins(), prepareController, prepareContext, prepareCallback);
                }
            });
            return;
        }
        RVLogger.d(this.LOG_TAG, "doSyncOffline without plugins!");
        checkMainPackage(prepareController, prepareContext, prepareCallback);
    }

    private void a(AppModel appModel, PrepareContext prepareContext, PrepareController prepareController, PrepareCallback prepareCallback) {
        if (appModel != null) {
            String string = BundleUtils.getString(prepareContext.getStartParams(), "page");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.startsWith(PluginParamModel.PLUGIN_PAGE_PREFIX) && RVResourceUtils.parseDynamicPlugin()) {
                checkDynamicPlugin(appModel, string, prepareContext, prepareController, prepareCallback);
            } else {
                a(appModel, string, prepareContext, prepareController, prepareCallback);
            }
        }
    }

    private void a(final AppModel appModel, final String str, final PrepareContext prepareContext, final PrepareController prepareController, PrepareCallback prepareCallback) {
        Set<String> keySet;
        if (TextUtils.isEmpty(str) || appModel.getAppInfoModel() == null) {
            return;
        }
        boolean isAppxNgSoloPackage = AppxNgRuntimeChecker.isAppxNgSoloPackage(appModel);
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        final JSONObject newSubPackages = isAppxNgSoloPackage ? appInfoModel.getNewSubPackages() : appInfoModel.getSubPackages();
        String str2 = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("requreAppxNgSoloPackage checkSubPackages ");
        sb.append(isAppxNgSoloPackage);
        sb.append(" appId:");
        sb.append(appModel.getAppId());
        RVLogger.d(str2, sb.toString());
        if (newSubPackages == null || newSubPackages.isEmpty() || (keySet = newSubPackages.keySet()) == null || keySet.isEmpty()) {
            return;
        }
        final ISubPackageDownloader.Callback callback = new ISubPackageDownloader.Callback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.3
            @Override // com.alibaba.ariver.resource.subpackage.ISubPackageDownloader.Callback
            public void onSuccess(String str3) {
                String str4 = DownloadStep.this.LOG_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onSuccess checkSubPackages page = ");
                sb2.append(str);
                RVLogger.d(str4, sb2.toString());
                DownloadStep.this.unlockAndMoveToNext(prepareController);
            }

            @Override // com.alibaba.ariver.resource.subpackage.ISubPackageDownloader.Callback
            public void onFail(String str3) {
                String str4 = DownloadStep.this.LOG_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onFail checkSubPackages page = ");
                sb2.append(str);
                RVLogger.d(str4, sb2.toString());
                DownloadStep.this.unlockAndMoveToNext(prepareController);
            }
        };
        for (String str3 : keySet) {
            if (str3 instanceof String) {
                final String str4 = str3;
                if (!"main".equalsIgnoreCase(str4) && !"whole".equalsIgnoreCase(str4) && str.contains(str4)) {
                    prepareContext.getPrepareData().getData().putBoolean(TrackId.ATTR_START_WITH_SUBPACKAGE, true);
                    if ("no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_subpackagePredownload", "no"))) {
                        return;
                    }
                    String str5 = this.LOG_TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("checkSubPackages page = ");
                    sb2.append(str);
                    RVLogger.d(str5, sb2.toString());
                    this.f6239a.addAndGet(1);
                    prepareController.postTimeOut(prepareContext.getTimeout());
                    prepareContext.setAppCreateStepType(getType());
                    prepareCallback.showLoading(true, prepareContext.getEntryInfo());
                    ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ISubPackageDownloader iSubPackageDownloader;
                            DownloadQueryPoint downloadQueryPoint = (DownloadQueryPoint) ExtensionPoint.as(DownloadQueryPoint.class).nullable().create();
                            if (downloadQueryPoint != null) {
                                RVLogger.d(DownloadStep.this.LOG_TAG, "packageQueryPoint");
                                iSubPackageDownloader = downloadQueryPoint.getSubDownloader(appModel, prepareContext.getStartParams());
                            } else {
                                iSubPackageDownloader = null;
                            }
                            if (iSubPackageDownloader == null) {
                                iSubPackageDownloader = new DefaultSubPackageDownloader();
                            }
                            iSubPackageDownloader.prepareSubpackage(prepareContext.getStartParams(), null, appModel, newSubPackages, str4, callback);
                        }
                    });
                    return;
                }
            }
        }
    }

    protected void checkMainPackage(final PrepareController prepareController, final PrepareContext prepareContext, PrepareCallback prepareCallback) {
        if (this.resourceManager.isAvailable(prepareContext.getAppModel())) {
            unlockAndMoveToNext(prepareController);
            return;
        }
        boolean isDownloaded = this.resourceManager.isDownloaded(prepareContext.getAppModel());
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("offlineMode ");
        sb.append(prepareContext.offlineMode);
        sb.append(" isDownloaded ");
        sb.append(isDownloaded);
        RVLogger.d(str, sb.toString());
        if (!isDownloaded) {
            AppModel appModel = prepareContext.getAppModel();
            if (a(prepareContext.getStartParams(), appModel)) {
                prepareContext.getSceneParams().putBoolean(RVConstants.EXTRA_USING_FALLBACK_START, true);
                Bundle bundle = new Bundle();
                bundle.putParcelable(IpcMessageConstants.EXTRA_FALLBACK_APP_MODEL, appModel);
                IpcServerUtils.sendMsgToClient(prepareContext.getAppId(), prepareContext.getStartToken(), 14, bundle);
                unlockAndMoveToNext(prepareController);
                return;
            }
            prepareController.postTimeOut(prepareContext.getTimeout());
            prepareContext.setAppCreateStepType(getType());
            prepareCallback.showLoading(true, prepareContext.getEntryInfo());
            prepareContext.getPrepareData().setDownloadTime(System.currentTimeMillis());
            onDownloadStart(prepareContext);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RVTraceKey.RV_Download_App_);
            sb2.append(prepareContext.getAppModel().getAppId());
            String obj = sb2.toString();
            int i = RVTracePhase.cookieSeed;
            RVTracePhase.cookieSeed = i + 1;
            RVTraceUtils.asyncTraceBegin(obj, i);
            this.resourceManager.downloadApp(prepareContext.getAppModel(), true, new MyPackageDownloadCallback(prepareContext, prepareController, obj, i));
            return;
        }
        prepareContext.getPrepareData().setInstallTime(System.currentTimeMillis());
        onInstallStart(prepareContext);
        this.resourceManager.installApp(prepareContext.getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.5
            @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
            public void onResult(boolean z, String str2) {
                prepareContext.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                String str3 = DownloadStep.this.LOG_TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("install result:");
                sb3.append(z);
                RVLogger.d(str3, sb3.toString());
                if (z) {
                    DownloadStep.this.onInstallFinish(prepareContext);
                    DownloadStep.this.unlockAndMoveToNext(prepareController);
                    return;
                }
                prepareController.moveToError(new PrepareException("5", "unzip exception"));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void checkDynamicPlugin(final com.alibaba.ariver.resource.api.models.AppModel r20, java.lang.String r21, final com.alibaba.ariver.resource.api.prepare.PrepareContext r22, final com.alibaba.ariver.resource.api.prepare.PrepareController r23, com.alibaba.ariver.resource.api.prepare.PrepareCallback r24) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.prepare.steps.DownloadStep.checkDynamicPlugin(com.alibaba.ariver.resource.api.models.AppModel, java.lang.String, com.alibaba.ariver.resource.api.prepare.PrepareContext, com.alibaba.ariver.resource.api.prepare.PrepareController, com.alibaba.ariver.resource.api.prepare.PrepareCallback):void");
    }

    private boolean a(Bundle bundle, AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null || ((appModel.getAppInfoModel().getTemplateConfig() != null && appModel.getAppInfoModel().getTemplateConfig().isTemplateValid()) || TextUtils.isEmpty(appModel.getAppInfoModel().getFallbackBaseUrl()))) {
            return false;
        }
        if ("YES".equalsIgnoreCase(BundleUtils.getString(bundle, RVStartParams.KEY_CAN_FALLBACK))) {
            return true;
        }
        JSONArray configJSONArray = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONArray("ariver_enableFallbackList");
        if (configJSONArray == null) {
            return false;
        }
        return configJSONArray.contains("*") || configJSONArray.contains(appModel.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppModel appModel, List<PluginModel> list, PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) {
        RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
        boolean isAvailable = rVPluginResourceManager.isAvailable(appModel, list);
        Iterator<PluginModel> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getAppId())) {
                String str = this.LOG_TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("pluginid == null , appId = ");
                sb.append(appModel.getAppId());
                RVLogger.d(str, sb.toString());
                unlockAndMoveToNext(prepareController);
                return;
            }
        }
        String appId = prepareContext.getAppId();
        long startToken = prepareContext.getStartToken();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startWithPlugin_");
        sb2.append(isAvailable);
        IpcServerUtils.addStubToClient(appId, startToken, sb2.toString(), SystemClock.elapsedRealtime());
        if (isAvailable) {
            a(prepareContext);
            unlockAndMoveToNext(prepareController);
            return;
        }
        RVLogger.d(this.LOG_TAG, "checkPlugins plugin not all available!");
        prepareController.postTimeOut(prepareContext.getTimeout());
        prepareContext.setAppCreateStepType(getType());
        prepareCallback.showLoading(true, prepareContext.getEntryInfo());
        prepareContext.getPrepareData().setDownloadTime(System.currentTimeMillis());
        rVPluginResourceManager.downloadPlugins(appModel, list, new MyPluginDownloadCallback(appModel, list, prepareContext, prepareController));
    }

    public void unlockAndMoveToNext(PrepareController prepareController) {
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("unLockAndMoveToNext with countDownTime: ");
        sb.append(this.f6239a);
        RVLogger.d(str, sb.toString());
        if (this.f6239a.decrementAndGet() == 0) {
            prepareController.unlock(this);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RVTraceKey.RV_Prepare_Execute_);
            sb2.append(getType());
            RVTraceUtils.traceEndSection(sb2.toString());
            prepareController.moveToNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class MyPluginDownloadCallback implements PluginDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        private final PrepareContext f6241a;
        private final PrepareController b;
        private final List<PluginModel> c;
        private final AppModel d;

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
        }

        MyPluginDownloadCallback(AppModel appModel, List<PluginModel> list, PrepareContext prepareContext, PrepareController prepareController) {
            this.d = appModel;
            this.c = list;
            this.f6241a = prepareContext;
            this.b = prepareController;
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onSuccess() {
            this.f6241a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            this.f6241a.getPrepareData().setInstallTime(System.currentTimeMillis());
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPluginDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).installPlugins(MyPluginDownloadCallback.this.d, MyPluginDownloadCallback.this.c, new PluginInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPluginDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSingleFailed(PluginModel pluginModel, int i, String str) {
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onSuccess(List<Pair<PluginModel, String>> list) {
                            RVLogger.d(DownloadStep.this.LOG_TAG, "installPlugins onSuccess");
                            MyPluginDownloadCallback.this.f6241a.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                            MyPluginDownloadCallback.this.f6241a.getPrepareData().getData().putBoolean(TrackId.PREPARE_STEP_STATIC_PLUGIN_DOWNLOAD, true);
                            DownloadStep.this.unlockAndMoveToNext(MyPluginDownloadCallback.this.b);
                        }

                        @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                        public void onFailed(int i, String str) {
                            String str2 = DownloadStep.this.LOG_TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("installPlugins onFailed ");
                            sb.append(i);
                            sb.append(", ");
                            sb.append(str);
                            RVLogger.w(str2, sb.toString());
                            MyPluginDownloadCallback.this.b.moveToError(new PrepareException("5", "unzip exception"));
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
        public void onFailed(int i, String str) {
            this.f6241a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            String str2 = DownloadStep.this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onFailed ");
            sb.append(i);
            sb.append(" ");
            sb.append(str);
            RVLogger.w(str2, sb.toString());
            PrepareController prepareController = this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(str);
            prepareController.moveToError(new PrepareException("4", sb2.toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class MyPackageDownloadCallback implements PackageDownloadCallback {

        /* renamed from: a  reason: collision with root package name */
        private final PrepareContext f6240a;
        private final PrepareController b;
        private final int c;
        private final String d;

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onCancel(String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onPrepare(String str) {
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onProgress(String str, int i) {
        }

        MyPackageDownloadCallback(PrepareContext prepareContext, PrepareController prepareController, String str, int i) {
            this.f6240a = prepareContext;
            this.b = prepareController;
            this.d = str;
            this.c = i;
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onFinish(String str) {
            RVLogger.d(DownloadStep.this.LOG_TAG, "downloadPackage onFinish");
            RVTraceUtils.asyncTraceEnd(this.d, this.c);
            DownloadStep.this.onDownloadFinish(this.f6240a);
            this.f6240a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            this.f6240a.getPrepareData().setInstallTime(System.currentTimeMillis());
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPackageDownloadCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadStep.this.onInstallStart(MyPackageDownloadCallback.this.f6240a);
                    DownloadStep.this.resourceManager.installApp(MyPackageDownloadCallback.this.f6240a.getAppModel(), new PackageInstallCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.DownloadStep.MyPackageDownloadCallback.1.1
                        @Override // com.alibaba.ariver.resource.api.PackageInstallCallback
                        public void onResult(boolean z, String str2) {
                            MyPackageDownloadCallback.this.f6240a.getPrepareData().setInstallEndTime(System.currentTimeMillis());
                            String str3 = DownloadStep.this.LOG_TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("downloadPackage installResult ");
                            sb.append(z);
                            RVLogger.d(str3, sb.toString());
                            if (z) {
                                DownloadStep.this.onInstallFinish(MyPackageDownloadCallback.this.f6240a);
                                DownloadStep.this.unlockAndMoveToNext(MyPackageDownloadCallback.this.b);
                                return;
                            }
                            MyPackageDownloadCallback.this.b.moveToError(new PrepareException("5", "unzip exception"));
                        }
                    });
                }
            });
        }

        @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
        public void onFailed(String str, int i, String str2) {
            String str3 = DownloadStep.this.LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("downloadPackage ");
            sb.append(i);
            sb.append(" ");
            sb.append(str2);
            RVLogger.d(str3, sb.toString());
            this.f6240a.getPrepareData().setDownloadEndTime(System.currentTimeMillis());
            PrepareController prepareController = this.b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(str2);
            prepareController.moveToError(new PrepareException("4", sb2.toString()));
        }
    }

    protected void onDownloadStart(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("prepare 4 size/");
        sb.append(RVResourceUtils.getPkgSize(prepareContext));
        sb.append(" appx2.0size/");
        sb.append(RVResourceUtils.getNewPkgSize(prepareContext));
        AppLogger.log(builder.setState(sb.toString()).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    protected void onDownloadFinish(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLog.Builder builder = new AppLog.Builder();
        StringBuilder sb = new StringBuilder();
        sb.append("prepare 5 size/");
        sb.append(RVResourceUtils.getPkgSize(prepareContext));
        sb.append(" appx2.0size/");
        sb.append(RVResourceUtils.getNewPkgSize(prepareContext));
        AppLogger.log(builder.setState(sb.toString()).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    protected void onInstallStart(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 6 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    protected void onInstallFinish(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 7 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_DOWNGRADE).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }
}
