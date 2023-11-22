package com.alipay.iap.android.aplog.log.spm;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;

/* loaded from: classes6.dex */
public enum TrackerHelper {
    instance;

    private final String TAG = "TrackerHelper";

    TrackerHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkIsPageBack(Object obj) {
        PageInfo pageInfoByView = SpmTrackIntegrator.getInstance().getPageInfoByView(obj);
        PageInfo pageMonitorCurrentPageInfo = SpmTrackIntegrator.getInstance().getPageMonitorCurrentPageInfo();
        return (pageMonitorCurrentPageInfo == null || pageInfoByView == null || pageMonitorCurrentPageInfo.referPageInfo == null || !pageMonitorCurrentPageInfo.referPageInfo.pageId.equals(pageInfoByView.pageId)) ? false : true;
    }

    private PageInfo getPageInfoByView(Object obj) {
        return SpmTrackIntegrator.getInstance().getPageInfoByView(checkPageIsContextThemeWrap(obj));
    }

    private Object checkPageIsContextThemeWrap(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextThemeWrapper) && SpmTrackIntegrator.getInstance().getPageInfoByView(obj) == null) ? ((ContextThemeWrapper) obj).getBaseContext() : obj;
    }

    public final String getPageId(Object obj) {
        PageInfo pageInfoByView = getPageInfoByView(obj);
        if (pageInfoByView != null) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("getPageId pageId:");
            sb.append(pageInfoByView.pageId);
            traceLogger.debug(str, sb.toString());
            if (pageInfoByView.pageId != null) {
                return pageInfoByView.pageId;
            }
        }
        return "C_NULL";
    }

    public final String getReferSpm(Object obj) {
        PageInfo pageInfoByView = getPageInfoByView(obj);
        return (pageInfoByView == null || pageInfoByView.referClickSpm == null) ? "" : pageInfoByView.referClickSpm;
    }
}
