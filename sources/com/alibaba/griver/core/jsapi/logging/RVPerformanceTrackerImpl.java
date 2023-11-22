package com.alibaba.griver.core.jsapi.logging;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.stagemonitor.GriverPVConfig;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverPVMonitor;
import com.alibaba.griver.base.stagemonitor.impl.GriverWhiteScreenStageMonitor;
import com.alibaba.griver.base.t2.T2Utils;
import com.fullstory.instrumentation.InstrumentInjector;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class RVPerformanceTrackerImpl implements RVPerformanceTracker {
    public static final String RV_PERFORMANCE_APP_STARTUP_TYPE = "RV_APP_STARTUP";
    public static final String RV_PERFORMANCE_PAGE_TYPE = "RV_APP_PAGE";
    public static final String TAG = "RVPerformanceTracker";

    /* renamed from: a  reason: collision with root package name */
    private Map<String, RVPerformanceModel> f6414a = new ConcurrentHashMap();
    private Map<String, RVPerformanceModel> b = new ConcurrentHashMap();

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void setPerformanceStageReentrantWhiteList(List<String> list) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void init(String str, String str2, Long l, String str3) {
        try {
            a(str, str2, l, str3);
        } catch (Throwable th) {
            RVLogger.e(TAG, "performance logger init error.", th);
        }
    }

    private void a(String str, String str2, Long l, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(l);
        String obj = sb.toString();
        if ("RV_APP_STARTUP".equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(GriverFullLinkStageMonitor.MONITOR_TOKEN);
            sb2.append(obj);
            String obj2 = sb2.toString();
            if (GriverStageMonitorManager.getInstance().getStageMonitor(obj2) == null) {
                GriverStageMonitorManager.getInstance().registerStageMonitor(obj2, new GriverFullLinkStageMonitor());
            }
            if (this.f6414a.containsKey(obj)) {
                RVLogger.d(TAG, "app perf already init");
                return;
            }
        }
        if ("RV_APP_PAGE".equals(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "default_url";
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(l);
            sb3.append(UrlUtils.getPathAndHash(str3));
            obj = sb3.toString();
            if (GriverStageMonitorManager.getInstance().getStageMonitor(obj) == null) {
                GriverStageMonitorManager.getInstance().registerStageMonitor(obj, new GriverWhiteScreenStageMonitor());
                GriverStageMonitorManager.getInstance().getStageMonitor(obj).addParam(GriverMonitorConstants.KEY_PAGE_URL, str3);
            }
            if (this.b.containsKey(obj)) {
                RVLogger.d(TAG, "page perf already init");
                return;
            }
        }
        RVPerformanceModel rVPerformanceModel = new RVPerformanceModel();
        rVPerformanceModel.setCurrentAppId(str2);
        rVPerformanceModel.setInitScene(str);
        rVPerformanceModel.setCurrentStartToken(l);
        if ("RV_APP_STARTUP".equals(str)) {
            this.f6414a.put(obj, rVPerformanceModel);
        } else {
            this.b.put(obj, rVPerformanceModel);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2) {
        track(app, str, str2, SystemClock.elapsedRealtime());
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2, long j) {
        if (TextUtils.equals(str2, PerfId.jumpAppStart) && j == 0) {
            return;
        }
        track(app, str, str2, null, null, j);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void track(App app, String str, String str2, Map<String, Object> map, Map<String, Object> map2, long j) {
        GriverStageMonitor stageMonitor;
        if (RVKernelUtils.isDebug()) {
            RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", str2, Long.valueOf(j)));
        }
        if (j < 0) {
            j = SystemClock.elapsedRealtime();
        }
        long j2 = j;
        String embeddedAppMainUrl = AppInfoUtils.getEmbeddedAppMainUrl(app);
        String appPerfKey = RVPerformanceLogHelper.getAppPerfKey(app);
        String pagePerfKey = RVPerformanceLogHelper.getPagePerfKey(app, str);
        RVPerformanceModel rVPerformanceModel = this.f6414a.get(appPerfKey);
        RVPerformanceModel rVPerformanceModel2 = this.b.get(pagePerfKey);
        if (app != null && app.getStartParams() != null) {
            RVPerformanceLogHelper.safelyFillForConcurrentMap(GriverMonitorConstants.KEY_START_MODE, app.getStartParams().getString(GriverMonitorConstants.KEY_START_MODE), map);
        }
        if (!TextUtils.isEmpty(embeddedAppMainUrl) && "firstScreen".equals(str2)) {
            if (!H5UrlHelper.equalsUrl(embeddedAppMainUrl, str)) {
                return;
            }
            rVPerformanceModel2 = this.b.get(RVPerformanceLogHelper.getPagePerfKey(app, app.getStartUrl()));
        }
        if (rVPerformanceModel != null && !"appLoaded".equals(str2) && !"appxWorkerFrameworkLoaded".equals(str2) && !"appxPageLoaded".equals(str2) && (stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(GriverFullLinkStageMonitor.getMonitorToken(app.getAppId(), String.valueOf(app.getStartToken())))) != null) {
            stageMonitor.transitToNext(str2, j2);
        }
        if (rVPerformanceModel2 == null) {
            RVPerformanceModel rVPerformanceModel3 = this.b.get(RVPerformanceLogHelper.getPagePerfKey(app, ""));
            if (rVPerformanceModel3 != null) {
                rVPerformanceModel3.track(str2, str, map, map2, j2);
                return;
            }
            return;
        }
        rVPerformanceModel2.track(str2, str, map, map2, j2);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void uploadPerfLog(App app, String str, String str2) {
        try {
            a(app, str, str2);
        } catch (Throwable th) {
            InstrumentInjector.log_e(TAG, "doLogStartup error!", th);
        }
    }

    private void a(App app, String str, String str2) {
        RVPerformanceModel rVPerformanceModel;
        String appPerfKey;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            sb.append("logPerf : ");
            sb.append(app.getAppId());
            sb.append("startTokne=");
            sb.append(app.getStartToken());
            sb.append(", ");
            sb.append(str);
            sb.append(", ");
            sb.append(str2);
            RVLogger.debug(TAG, sb.toString());
            if ("RV_APP_PAGE".equals(str2)) {
                appPerfKey = RVPerformanceLogHelper.getPagePerfKey(app, str);
                rVPerformanceModel = this.b.get(appPerfKey);
                if (rVPerformanceModel == null) {
                    appPerfKey = RVPerformanceLogHelper.getPagePerfKey(app, "");
                    rVPerformanceModel = this.b.get(appPerfKey);
                }
            } else {
                rVPerformanceModel = this.f6414a.get(RVPerformanceLogHelper.getAppPerfKey(app));
                if (app.isTinyApp() && GriverPVConfig.canMonit(app)) {
                    GriverPVMonitor griverPVMonitor = (GriverPVMonitor) GriverStageMonitorManager.getInstance().getStageMonitor(GriverPVMonitor.getMonitorToken(app));
                    if (griverPVMonitor != null) {
                        griverPVMonitor.upload(app);
                    }
                    GriverStageMonitorManager.getInstance().unRegisterStageMonitor(GriverPVMonitor.getMonitorToken(app.getAppId(), String.valueOf(app.getStartToken())));
                }
                appPerfKey = RVPerformanceLogHelper.getAppPerfKey(app);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(GriverFullLinkStageMonitor.MONITOR_TOKEN);
                sb2.append(appPerfKey);
                String obj = sb2.toString();
                T2Utils.performanceJST2(app);
                GriverStageMonitorManager.getInstance().unRegisterStageMonitor(obj);
            }
            if (rVPerformanceModel == null) {
                return;
            }
            rVPerformanceModel.fillAppInfo(app);
            if (rVPerformanceModel.getCommonDatas() != null) {
                rVPerformanceModel.getCommonDatas().put("url", str);
            }
            HashMap hashMap = new HashMap(rVPerformanceModel.getCommonDatas());
            HashMap hashMap2 = new HashMap(rVPerformanceModel.getExtDatas());
            HashMap hashMap3 = new HashMap(rVPerformanceModel.getPerformanceStages());
            HashMap hashMap4 = new HashMap(rVPerformanceModel.getEvents());
            rVPerformanceModel.clear();
            if ("RV_APP_STARTUP".equals(str2)) {
                this.f6414a.remove(appPerfKey);
            } else {
                this.b.remove(appPerfKey);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).performance("RV_APP_PAGE", hashMap, hashMap2, hashMap3, hashMap4);
                GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(appPerfKey);
                if (stageMonitor != null) {
                    stageMonitor.upload(app);
                }
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addData2Performance(App app, String str, String str2, String str3) {
        RVPerformanceModel a2 = a(app);
        RVPerformanceModel a3 = a(app, str);
        if (a2 != null) {
            a2.addData2Performance(str2, str3);
        }
        if (a3 != null) {
            a3.addData2Performance(str2, str3);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addDatas2Performance(App app, String str, String str2, Map<String, String> map) {
        RVPerformanceModel a2 = a(app);
        RVPerformanceModel a3 = a(app, str);
        if (a2 != null) {
            a2.addDatas2Performance(str2, map);
        }
        if (a3 != null) {
            a3.addDatas2Performance(str2, map);
        }
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVPerformanceTracker
    public void addEvent2Performance(App app, String str, String str2, Map<String, String> map) {
        RVPerformanceModel a2 = a(app);
        RVPerformanceModel a3 = a(app, str);
        if (a2 != null) {
            a2.addEvent2Performance(str2, map);
        }
        if (a3 != null) {
            a3.addEvent2Performance(str2, map);
        }
    }

    private RVPerformanceModel a(App app, String str) {
        RVPerformanceModel rVPerformanceModel = this.b.get(RVPerformanceLogHelper.getPagePerfKey(app, str));
        if (rVPerformanceModel == null) {
            return this.b.get(RVPerformanceLogHelper.getPagePerfKey(app, ""));
        }
        return rVPerformanceModel;
    }

    private RVPerformanceModel a(App app) {
        return this.f6414a.get(RVPerformanceLogHelper.getAppPerfKey(app));
    }
}
