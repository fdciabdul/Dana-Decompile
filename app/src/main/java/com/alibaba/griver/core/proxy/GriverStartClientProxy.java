package com.alibaba.griver.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.integration.proxy.RVClientStarter;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.base.api.GriverPerformanceStages;
import com.alibaba.griver.base.common.TrackingCodeManager;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.GriverPrepareController;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.core.jsapi.device.location.LocationBridgeExtensionWrapper;
import com.alibaba.griver.core.keepalive.KeepAliveAppManager;
import com.alibaba.griver.core.liteprocess.LiteProcessManager;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.alibaba.griver.core.ui.activity.GriverTransActivity;
import com.alibaba.griver.core.ui.fragment.GriverBaseFragment;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public class GriverStartClientProxy implements RVClientStarter {
    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public Class<? extends Activity> startClient(final Context context, RVAppRecord rVAppRecord, final Intent intent) {
        AppModel appModel;
        boolean equalsIgnoreCase;
        Class<? extends Activity> cls = null;
        if (ProcessUtils.isMainProcess()) {
            try {
                appModel = (AppModel) BundleUtils.getParcelable(rVAppRecord.getSceneParams(), "appInfo");
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("get app info error");
                sb.append(th);
                GriverLogger.w("AriverInt:StartClientProxy", sb.toString());
                appModel = null;
            }
            if (appModel != null && appModel.getContainerInfo() != null && appModel.getContainerInfo().getLaunchParams() != null && appModel.getContainerInfo().getLaunchParams().containsKey("enableMultiProcess")) {
                equalsIgnoreCase = "YES".equalsIgnoreCase(JSONUtils.getString(appModel.getContainerInfo().getLaunchParams(), "enableMultiProcess"));
            } else {
                equalsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(rVAppRecord.getStartParams(), "enableMultiProcess"));
            }
        } else {
            equalsIgnoreCase = false;
        }
        boolean z = BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVParams.isH5App, false);
        boolean z2 = BundleUtils.getBoolean(rVAppRecord.getStartParams(), RVStartParams.KEY_TRANSPARENT, false);
        if (!z && equalsIgnoreCase && LiteProcessManager.needSupportLiteProcess()) {
            cls = LiteProcessManager.getInstance().startApp(rVAppRecord, intent);
        }
        if (!z && KeepAliveAppManager.getInstance().needSupportKeepAlive(rVAppRecord.getAppId(), rVAppRecord.getStartParams())) {
            cls = KeepAliveAppManager.getInstance().startApp(context, rVAppRecord, intent);
        }
        if (!z && cls == null && KeepAliveAppManager.getInstance().enableKeepAlive()) {
            cls = KeepAliveAppManager.getInstance().startMainTaskApp(context, rVAppRecord, intent, z2);
        }
        if (cls == null) {
            GriverFullLinkStageMonitor griverFullLinkStageMonitor = (GriverFullLinkStageMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(rVAppRecord.getAppId(), String.valueOf(rVAppRecord.getStartToken())));
            if (griverFullLinkStageMonitor != null) {
                griverFullLinkStageMonitor.transitToNext(PerfId.startActivity);
            }
            cls = z2 ? GriverTransActivity.Main.class : GriverBaseActivity.Main.class;
            if (!(context instanceof Activity)) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            intent.putExtra("isTransparent", z2);
            intent.putExtras(rVAppRecord.getStartParams());
            intent.setClass(context, cls);
            ExecutorUtils.postMain(new Runnable() { // from class: com.alibaba.griver.core.proxy.GriverStartClientProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            });
            LiteProcessManager.getInstance().getMainProcess().setAppId(rVAppRecord.getAppId());
            LiteProcessManager.getInstance().getMainProcess().setState(1);
        }
        return cls;
    }

    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public Fragment createFragment(Context context, RVAppRecord rVAppRecord, Bundle bundle) {
        return Fragment.instantiate(context, GriverBaseFragment.class.getName(), bundle);
    }

    @Override // com.alibaba.ariver.integration.proxy.RVClientStarter
    public PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        Bundle startParams = prepareContext.getStartParams();
        if (startParams == null || !BundleUtils.getBoolean(startParams, GriverLaunchParams.CREATE_FRAGMENT, false)) {
            GriverLogger.d("AriverInt:StartClientProxy", "create prepare controller");
            Bundle startParams2 = prepareContext.getStartParams();
            TrackingCodeManager.getInstance().setTrackingCode(startParams2);
            String string = BundleUtils.getString(startParams2, "appId");
            if (LocationBridgeExtensionWrapper.enableWhiteList(string)) {
                new LocationBridgeExtensionWrapper().preGetLocation(prepareContext.getStartContext(), string);
            }
            GriverStageMonitorManager griverStageMonitorManager = GriverStageMonitorManager.getInstance();
            String appId = prepareContext.getAppId();
            StringBuilder sb = new StringBuilder();
            sb.append(prepareContext.getStartToken());
            GriverFullLinkStageMonitor createFullStageMonitor = griverStageMonitorManager.createFullStageMonitor(appId, sb.toString());
            if (createFullStageMonitor != null) {
                createFullStageMonitor.transitToNext(PerfId.jumpAppStart);
                createFullStageMonitor.transitToNext(GriverPerformanceStages.KEY_JUMP_APP_START_UNIX, System.currentTimeMillis());
            }
            if (KeepAliveAppManager.getInstance().needSupportKeepAlive(prepareContext.getAppId(), prepareContext.getStartParams())) {
                return KeepAliveAppManager.getInstance().createPrepareController(prepareContext, prepareCallback);
            }
            return new GriverPrepareController(prepareContext, prepareCallback);
        }
        return null;
    }
}
