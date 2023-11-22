package com.alibaba.ariver.resource.prepare.steps;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.RVResourceUtils;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.preset.PresetUtils;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class UpdateStep extends BasePrepareStep {
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
        return StepType.UPDATE;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceBeginSection(sb.toString());
        super.execute(prepareController, prepareContext, prepareCallback);
        String str = this.LOG_TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("update with ");
        sb2.append(prepareContext);
        RVLogger.d(str, sb2.toString());
        AppModel appModel = prepareContext.getAppModel();
        String version = appModel == null ? null : appModel.getAppInfoModel().getVersion();
        String string = BundleUtils.getString(prepareContext.getStartParams(), RVStartParams.LONG_NB_VERSION);
        JSONObject configJSONObject = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_nbversionCfg");
        if (configJSONObject != null && configJSONObject.containsKey(prepareContext.getAppId())) {
            String string2 = configJSONObject.getString(prepareContext.getAppId());
            if (!TextUtils.isEmpty(string2) && RVResourceUtils.compareVersion(string2, string) > 0) {
                String str2 = this.LOG_TAG;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("wantNebulaVersion update from config: ");
                sb3.append(string2);
                RVLogger.d(str2, sb3.toString());
                prepareContext.updateMode = UpdateMode.SYNC_FORCE;
                prepareContext.getStartParams().putString(RVStartParams.LONG_NB_VERSION, string2);
                string = string2;
            }
        }
        String string3 = BundleUtils.getString(prepareContext.getStartParams(), RVParams.REQUIRE_NBVERSION);
        boolean z2 = TextUtils.isEmpty(string3) || TextUtils.equals(string3, version);
        boolean z3 = TextUtils.isEmpty(string) || RVResourceUtils.compareVersion(version, string) < 0;
        if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null && appModel.getAppInfoModel().getPlugins().size() > 0) {
            Iterator<PluginModel> it = appModel.getAppInfoModel().getPlugins().iterator();
            while (it.hasNext()) {
                if (ResourceUtils.needForceUpdate(it.next())) {
                    prepareContext.updateMode = UpdateMode.SYNC_FORCE;
                    RVLogger.d(this.LOG_TAG, "force update because of NbPluginVersion");
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z4 = appModel == null || (prepareContext.updateMode.isSync() && z3) || z || !z2;
        prepareContext.getPrepareData().setRequestMode(prepareContext.updateMode);
        if (z4) {
            RVLogger.d(this.LOG_TAG, "enter force updateLoadingInfo step");
            prepareContext.setAppCreateStepType(getType());
            prepareCallback.showLoading(true, prepareContext.getEntryInfo());
            prepareController.postTimeOut(prepareContext.getTimeout());
            prepareController.lock(this);
            a(prepareController, prepareContext, prepareCallback);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(RVTraceKey.RV_Prepare_Execute_);
        sb4.append(getType());
        RVTraceUtils.traceEndSection(sb4.toString());
    }

    private void a(final PrepareController prepareController, final PrepareContext prepareContext, final PrepareCallback prepareCallback) {
        a(prepareContext);
        final boolean z = prepareContext.getAppModel() != null;
        prepareContext.getPrepareData().setRequestBeginTime(System.currentTimeMillis());
        UpdateAppCallback updateAppCallback = new UpdateAppCallback() { // from class: com.alibaba.ariver.resource.prepare.steps.UpdateStep.1
            private AppModel a(List<AppModel> list) {
                if (list != null) {
                    for (AppModel appModel : list) {
                        if (TextUtils.equals(appModel.getAppInfoModel().getAppId(), prepareContext.getAppId())) {
                            return appModel;
                        }
                    }
                    return null;
                }
                return null;
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onSuccess(List<AppModel> list) {
                String str = UpdateStep.this.LOG_TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("updateAppInfo result: ");
                sb.append(list);
                RVLogger.d(str, sb.toString());
                AppModel a2 = a(list);
                boolean z2 = a2 != null;
                String str2 = UpdateStep.this.LOG_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateAppInfo onSuccess find target: ");
                sb2.append(z2);
                RVLogger.d(str2, sb2.toString());
                prepareContext.getPrepareData().setRequestEndTime(System.currentTimeMillis());
                if (z2) {
                    prepareContext.setupAppInfo(a2);
                    prepareController.onGetAppInfo(a2);
                    prepareCallback.updateLoading(prepareContext.getEntryInfo(), a2);
                    prepareController.unlock(UpdateStep.this);
                    UpdateStep.this.b(prepareContext);
                    prepareController.moveToNext();
                    return;
                }
                UpdateAppException updateAppException = new UpdateAppException("1", "no app info");
                updateAppException.setNeedShowError(true);
                onError(updateAppException);
            }

            @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
            public void onError(UpdateAppException updateAppException) {
                PrepareException prepareException;
                RVLogger.w(UpdateStep.this.LOG_TAG, "updateApp onError!", updateAppException);
                if (UpdateStep.this.a(updateAppException, prepareContext)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateApp appId = ");
                    sb.append(prepareContext.getAppId());
                    sb.append(" is offline");
                    RVLogger.w(sb.toString());
                    PrepareException prepareException2 = new PrepareException(PrepareException.ERROR_OFFLINE_APP, "", updateAppException);
                    prepareException2.setNeedShowFail(true);
                    prepareController.unlock(UpdateStep.this);
                    prepareController.moveToError(prepareException2);
                    return;
                }
                AppModel presetAppModel = PresetUtils.getPresetAppModel(prepareContext.getAppId());
                if (presetAppModel != null) {
                    RVLogger.d(UpdateStep.this.LOG_TAG, "updateApp onError but hit preset!");
                    prepareContext.setupAppInfo(presetAppModel);
                    prepareController.onGetAppInfo(presetAppModel);
                    UpdateStep.this.b(prepareContext);
                    prepareController.unlock(UpdateStep.this);
                    prepareController.moveToNext();
                } else if (z && prepareContext.updateMode != UpdateMode.SYNC_FORCE) {
                    UpdateStep.this.b(prepareContext);
                    prepareController.unlock(UpdateStep.this);
                    prepareController.moveToNext();
                } else {
                    if (updateAppException != null && !TextUtils.isEmpty(updateAppException.getCode())) {
                        prepareException = new PrepareException(updateAppException.getCode(), updateAppException.getMessage(), updateAppException);
                        prepareException.setNeedShowFail(updateAppException.isNeedShowError());
                    } else {
                        prepareException = new PrepareException("2", "", updateAppException);
                    }
                    prepareController.unlock(UpdateStep.this);
                    prepareController.moveToError(prepareException);
                }
            }
        };
        UpdateAppParam updateAppParam = new UpdateAppParam(prepareContext.getAppId(), null);
        updateAppParam.setForce(true);
        updateAppParam.setUpdateMode(prepareContext.updateMode);
        updateAppParam.setQueryScene(prepareContext.getAppInfoQuery().getScene());
        updateAppParam.setExtras(prepareContext.getStartParams());
        HashMap hashMap = new HashMap();
        if (!prepareContext.getAppInfoQuery().isOnlineScene()) {
            hashMap.put(prepareContext.getAppId(), prepareContext.getAppInfoQuery().getVersion());
        } else {
            hashMap.put(prepareContext.getAppId(), "*");
        }
        updateAppParam.setRequestApps(hashMap);
        IAppUpdater createUpdater = AppUpdaterFactory.createUpdater(prepareContext.getAppId(), prepareContext.getStartParams());
        if (createUpdater != null) {
            createUpdater.updateApp(updateAppParam, updateAppCallback);
            return;
        }
        String str = this.LOG_TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("cannot find IAppUpdater for ");
        sb.append(prepareContext.getAppId());
        sb.append(" and param: ");
        sb.append(prepareContext.getStartParams());
        RVLogger.w(str, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find updater for ");
        sb2.append(prepareContext.getAppId());
        prepareController.moveToError(new PrepareException("0", sb2.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(UpdateAppException updateAppException, PrepareContext prepareContext) {
        return updateAppException.getCode().equalsIgnoreCase("2") && prepareContext.getAppId().equalsIgnoreCase(updateAppException.getMessage());
    }

    private void a(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 2 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PrepareContext prepareContext) {
        if (prepareContext == null) {
            return;
        }
        AppLogger.log(new AppLog.Builder().setState("prepare 3 ").setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
    }
}
