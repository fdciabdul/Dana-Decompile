package com.alibaba.griver.base.stagemonitor.impl;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.cache.H5WebViewCacheExtension;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.RecordReportConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.performance.PerformanceMonitorFactory;
import com.alibaba.griver.base.performance.jsapi.PerformanceJSAPIMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import id.dana.data.here.HereOauthManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverFullLinkStageMonitor extends GriverStageMonitor {
    public static final String MONITOR_TOKEN = "full_link";

    /* renamed from: a */
    private boolean f6381a;

    public GriverFullLinkStageMonitor() {
        addParam(GriverConfigConstants.KEY_EXECUTOR_ENABLE, Boolean.valueOf(GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_EXECUTOR_ENABLE, false)));
        addParam(GriverMonitorConstants.KEY_KEEP_ALIVE, 0);
        HashMap<String, String> performanceConfigMonitor = GriverInnerConfig.getPerformanceConfigMonitor();
        for (String str : performanceConfigMonitor.keySet()) {
            addParam(str, performanceConfigMonitor.get(str));
        }
    }

    public static String getMonitorToken(App app) {
        if (app == null) {
            return MONITOR_TOKEN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        return sb.toString();
    }

    public static String getMonitorToken(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return MONITOR_TOKEN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void transitToError(String str) {
        this.paramMap.put(GriverMonitorConstants.KEY_OPEN_APP_ERROR, str);
    }

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void transitToNext(String str) {
        if (a(str)) {
            super.transitToNext(str);
        }
    }

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void transitToNext(String str, long j) {
        if (a(str)) {
            super.transitToNext(str, j);
        }
    }

    private boolean a(String str) {
        if (str == null || this.stageMap.containsKey(str)) {
            return false;
        }
        Object obj = this.paramMap.get(GriverMonitorConstants.KEY_RELOAD_COUNT);
        return !(obj instanceof Long) || ((Long) obj).longValue() == 0;
    }

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void upload(App app) {
        this.f6381a = true;
        H5WebViewCacheExtension h5WebViewCacheExtension = (H5WebViewCacheExtension) RVProxy.get(H5WebViewCacheExtension.class);
        if (h5WebViewCacheExtension != null) {
            addParam(GriverMonitorConstants.KEY_CCDN_HTTP_CACHE, Integer.valueOf(h5WebViewCacheExtension.canUseH5Cache(app.getAppId()) ? 1 : 0));
        }
        PerformanceJSAPIMonitor performanceJSAPIMonitor = (PerformanceJSAPIMonitor) PerformanceMonitorFactory.getPerformanceMonitor(app.getAppId(), PerformanceMonitorFactory.PerformanceType.JSAPI);
        if (performanceJSAPIMonitor != null) {
            addParam("getAuthCodeTimes", performanceJSAPIMonitor.getAuthCodeEncodeString());
        }
        addParam(AppInfoScene.PARAM_SCENE, BundleUtils.getString(app.getStartParams(), AppInfoScene.PARAM_SCENE, AppInfoScene.ONLINE.toString()));
        if (!this.paramMap.containsKey("snapshot")) {
            addParam("snapshot", 0);
        }
        String string = BundleUtils.getString(app.getStartParams(), "query", "");
        try {
            string = URLEncoder.encode(URLDecoder.decode(string, HereOauthManager.ENC), HereOauthManager.ENC);
        } catch (UnsupportedEncodingException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("encode error");
            sb.append(string);
            GriverLogger.d("FullLinkStepMonitor", sb.toString());
        }
        addParam("query", string);
        try {
            Map<String, String> a2 = a(app);
            GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
            if (griverAllRecordsExtension != null && griverAllRecordsExtension.canUseRecords(app)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putAll(a2);
                jSONObject.put("RV_APP_STARTUP", (Object) jSONObject2);
                jSONObject.put(RecordReportConstants.REPORT_TS, Long.valueOf(System.currentTimeMillis()));
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                if (appModel != null) {
                    jSONObject.put(RecordReportConstants.APP_INFO, appModel.getAppInfoModel());
                }
                griverAllRecordsExtension.updateRecordReport(app, jSONObject);
            }
            GriverMonitor.performance("RV_APP_STARTUP", "GriverAppContainer", a2);
        } catch (Exception e) {
            GriverLogger.e("FullLinkStepMonitor", "get common data failed", e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:178:0x0178
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.util.Map<java.lang.String, java.lang.String> a(com.alibaba.ariver.app.api.App r27) {
        /*
            Method dump skipped, instructions count: 1048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor.a(com.alibaba.ariver.app.api.App):java.util.Map");
    }

    private boolean a(Map<String, Long> map, String str) {
        return map != null && map.containsKey(str) && map.get(str) != null && map.get(str).longValue() > 0;
    }

    public boolean isUploaded() {
        return this.f6381a;
    }

    public void setUpload() {
        this.f6381a = true;
    }
}
