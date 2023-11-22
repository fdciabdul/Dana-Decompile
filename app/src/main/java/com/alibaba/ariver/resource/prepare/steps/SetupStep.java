package com.alibaba.ariver.resource.prepare.steps;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.OfflineMode;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;

/* loaded from: classes6.dex */
public class SetupStep extends BasePrepareStep {
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
        return StepType.SETUP;
    }

    @Override // com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceBeginSection(sb.toString());
        prepareContext.getPrepareData().setBeginTime(SystemClock.elapsedRealtime());
        super.execute(prepareController, prepareContext, prepareCallback);
        String appId = prepareContext.getAppId();
        AppLogger.log(new AppLog.Builder().setState("prepare 1 ").setAppId(appId).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
        prepareContext.getStartParams().putString("appId", appId);
        AppInfoQuery appInfoQuery = new AppInfoQuery(appId);
        if (AppInfoScene.isDevSource(prepareContext.getStartParams())) {
            appInfoQuery.scene(AppInfoScene.extractScene(prepareContext.getStartParams()));
            appInfoQuery.version(AppInfoScene.extractSceneVersion(prepareContext.getStartParams()));
        } else {
            String string = BundleUtils.getString(prepareContext.getStartParams(), RVParams.REQUIRE_NBVERSION);
            if (!TextUtils.isEmpty(string)) {
                appInfoQuery.version(string);
            }
        }
        prepareContext.setAppInfoQuery(appInfoQuery);
        AppModel appModel = this.appInfoManager.getAppModel(appInfoQuery);
        boolean z = appModel != null;
        String str = this.LOG_TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("syncApp for ");
        sb2.append(appId);
        sb2.append(" ");
        sb2.append(prepareContext.getOriginStartParams());
        sb2.append(" ");
        sb2.append(z);
        RVLogger.d(str, sb2.toString());
        if (z) {
            prepareContext.setOriginHasAppInfo(true);
            prepareContext.getPrepareData().setOriginHasAppInfo(true);
            prepareContext.setupAppInfo(appModel);
            prepareController.onGetAppInfo(appModel);
        }
        Bundle startParams = prepareContext.getStartParams();
        prepareContext.offlineMode = OfflineMode.fromString(BundleUtils.getString(startParams, RVStartParams.LONG_NB_OFFLINE), BundleUtils.getString(startParams, RVParams.LONG_NB_OFFMODE));
        prepareContext.updateMode = UpdateMode.fromString(BundleUtils.getString(startParams, RVStartParams.LONG_NB_UPDATE));
        prepareContext.degradeUrl = BundleUtils.getString(startParams, RVStartParams.LONG_NB_URL);
        prepareContext.getPrepareData().setNbUrl(prepareContext.degradeUrl);
        if (!z) {
            prepareContext.setOriginHasAppInfo(false);
            prepareContext.getPrepareData().setOriginHasAppInfo(false);
            prepareContext.updateMode = UpdateMode.SYNC_FORCE;
        }
        prepareContext.getPrepareData().setAppId(appId);
        prepareContext.getPrepareData().setAppType(prepareContext.appType);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(RVTraceKey.RV_Prepare_Execute_);
        sb3.append(getType());
        RVTraceUtils.traceEndSection(sb3.toString());
    }
}
