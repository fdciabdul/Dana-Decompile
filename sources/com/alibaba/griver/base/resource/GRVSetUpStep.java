package com.alibaba.griver.base.resource;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
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
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.prepare.steps.SetupStep;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.resource.predownload.AppPreDownloadManager;
import com.alibaba.griver.base.resource.preset.GriverMiniAppPreset;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GRVSetUpStep extends SetupStep {
    @Override // com.alibaba.ariver.resource.prepare.steps.SetupStep, com.alibaba.ariver.resource.prepare.steps.BasePrepareStep, com.alibaba.ariver.resource.api.prepare.PrepareStep
    public void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(RVTraceKey.RV_Prepare_Execute_);
        sb.append(getType());
        RVTraceUtils.traceBeginSection(sb.toString());
        prepareContext.getPrepareData().setBeginTime(SystemClock.elapsedRealtime());
        RVAppInfoManager rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        String appId = prepareContext.getAppId();
        AppLogger.log(new AppLog.Builder().setState("prepare 1 ").setAppId(appId).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).build());
        prepareContext.getStartParams().putString("appId", appId);
        AppInfoQuery appInfoQuery = new AppInfoQuery(appId);
        if (AppInfoScene.isDevSource(prepareContext.getStartParams())) {
            appInfoQuery.scene(AppInfoScene.extractScene(prepareContext.getStartParams()));
            string = AppInfoScene.extractSceneVersion(prepareContext.getStartParams());
            appInfoQuery.version(string);
        } else {
            string = BundleUtils.getString(prepareContext.getStartParams(), RVParams.REQUIRE_NBVERSION);
            if (!TextUtils.isEmpty(string)) {
                appInfoQuery.version(string);
            }
        }
        prepareContext.setAppInfoQuery(appInfoQuery);
        AppModel appModel = rVAppInfoManager.getAppModel(appInfoQuery);
        AppModel availableAppForAppId = AppPreDownloadManager.availableAppForAppId(appId, appModel, string, prepareContext.getStartParams());
        if (availableAppForAppId != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(availableAppForAppId);
            rVAppInfoManager.saveAppModelList(arrayList);
            GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(prepareContext.getAppId(), String.valueOf(prepareContext.getStartToken())));
            if (stageMonitor != null) {
                stageMonitor.addParam(GriverMonitorConstants.KEY_PRE_DOWNLOAD_FETCHEDSCENETYPE, 1);
            }
            appModel = availableAppForAppId;
        } else {
            GriverStageMonitor stageMonitor2 = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(prepareContext.getAppId(), String.valueOf(prepareContext.getStartToken())));
            if (stageMonitor2 != null) {
                stageMonitor2.addParam(GriverMonitorConstants.KEY_PRE_DOWNLOAD_FETCHEDSCENETYPE, 0);
            }
        }
        if (appModel == null) {
            AppModel presetAppModel = GriverMiniAppPreset.getPresetAppModel(appId, string, prepareContext.getStartParams());
            if (presetAppModel != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(presetAppModel);
                rVAppInfoManager.saveAppModelList(arrayList2);
                GriverStageMonitor stageMonitor3 = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(prepareContext.getAppId(), String.valueOf(prepareContext.getStartToken())));
                if (stageMonitor3 != null) {
                    stageMonitor3.addParam(GriverMonitorConstants.KEY_APP_PRESET, Boolean.TRUE);
                }
                appModel = presetAppModel;
            } else {
                GriverStageMonitor stageMonitor4 = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(prepareContext.getAppId(), String.valueOf(prepareContext.getStartToken())));
                if (stageMonitor4 != null) {
                    stageMonitor4.addParam(GriverMonitorConstants.KEY_APP_PRESET, Boolean.FALSE);
                }
            }
        }
        boolean z = appModel != null;
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append(RVTraceKey.RV_Prepare_Execute_);
        sb2.append(getType());
        RVTraceUtils.traceEndSection(sb2.toString());
    }
}
