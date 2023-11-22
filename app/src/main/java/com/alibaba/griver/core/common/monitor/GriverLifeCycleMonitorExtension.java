package com.alibaba.griver.core.common.monitor;

import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.preload.point.OnPreloadPoint;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class GriverLifeCycleMonitorExtension implements PageDestroyPoint, PageEnterPoint, PageExitPoint, PagePausePoint, PageResumePoint {
    private static final String TAG = "GriverLifeCycleMonitorExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        pageStart(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
    public void onPageEnter(Page page) {
        pageStart(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        pageEnd(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        pageEnd(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageDestroyPoint
    public void onPageDestroy(Page page) {
        if (shouldLog(page)) {
            GriverMonitor.pageDestroy(page);
        }
    }

    private void pageStart(Page page) {
        if (shouldLog(page)) {
            GriverMonitor.pageStart(page, getSpmId(page.getApp().getAppId(), page.getPageURI()));
            if (RemoteDebugCompatUtils.isInDebugMode(page.getApp()) || !page.getApp().isTinyApp()) {
                return;
            }
            ((OnPreloadPoint) RVProxy.get(OnPreloadPoint.class)).createPageContext(page.getApp());
        }
    }

    private void pageEnd(Page page) {
        JSONObject extendInfos;
        if (shouldLog(page)) {
            HashMap hashMap = new HashMap();
            String appId = page.getApp().getAppId();
            hashMap.put("appId", appId);
            hashMap.put("version", page.getApp().getAppVersion());
            hashMap.put("url", page.getOriginalURI());
            AppModel queryAppInfo = GriverAppCenter.queryAppInfo(page.getApp().getAppId(), page.getApp().getAppVersion());
            if (queryAppInfo != null && (extendInfos = queryAppInfo.getExtendInfos()) != null && extendInfos.containsKey("acquirerId")) {
                hashMap.put(GriverMonitorConstants.KEY_MONITOR_SOURCE_SITE, extendInfos.getString("acquirerId"));
            }
            String spmId = getSpmId(page.getApp().getAppId(), page.getPageURI());
            StringBuilder sb = new StringBuilder();
            sb.append(GriverMonitorConstants.APPX_BEHAVIOR_BIZ_TYPE_PREFIX);
            sb.append(appId);
            GriverMonitor.pageExit(page, spmId, sb.toString(), hashMap);
        }
    }

    private String getSpmId(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MiniApp_");
        sb.append(str);
        String obj = sb.toString();
        String pathFromUrl = getPathFromUrl(str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(".");
        sb2.append(pathFromUrl);
        return sb2.toString();
    }

    private String getPathFromUrl(String str) {
        try {
            return Uri.parse(str).getFragment();
        } catch (Exception e) {
            GriverLogger.e(TAG, "parse url failed", e);
            return str;
        }
    }

    private boolean shouldLog(Page page) {
        return (page == null || BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false)) ? false : true;
    }
}
