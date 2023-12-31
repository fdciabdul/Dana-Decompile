package com.alipay.iap.android.aplog.log.spm;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.log.behavior.BehaviorID;
import com.alipay.iap.android.aplog.log.behavior.BehaviourLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum SpmMonitor implements ISpmMonitor {
    INTANCE;

    private static final String TAG = SpmMonitor.class.getName();
    private WeakReference<Object> mTopPage;

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final void pageOnStart(Object obj, String str) {
        this.mTopPage = new WeakReference<>(obj);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SpmTrackIntegrator.getInstance().logPageStartWithSpmId(str, obj);
    }

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final void pageOnEnd(Object obj, String str, String str2, Map<String, String> map) {
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("pageOnPause spmId:");
        sb.append(str);
        traceLogger.debug(str3, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("referSpm", TrackerHelper.instance.getReferSpm(obj));
        SpmTrackIntegrator.getInstance().logPageEndWithSpmId(str, obj, str2, map);
    }

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final void pageOnDestroy(Object obj) {
        SpmTrackIntegrator.getInstance().pageOnDestroy(obj);
    }

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final void spmClick(Object obj, String str, String str2, Map<String, String> map) {
        setLastClickSpm(str);
        BehaviourLog.Builder behaviourBuilder = getBehaviourBuilder(obj, str, str2, map);
        behaviourBuilder.setBehaviourID(BehaviorID.CLICK);
        LoggerFactory.getLogContext().appendLog(behaviourBuilder.build());
    }

    private void setLastClickSpm(String str) {
        SpmTrackIntegrator.getInstance().setLastClickViewSpm(str);
    }

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final void spmExpose(Object obj, String str, String str2, Map<String, String> map) {
        BehaviourLog.Builder behaviourBuilder = getBehaviourBuilder(obj, str, str2, map);
        behaviourBuilder.setBehaviourID(BehaviorID.EXPOSURE);
        LoggerFactory.getLogContext().appendLog(behaviourBuilder.build());
    }

    @Override // com.alipay.iap.android.aplog.log.spm.ISpmMonitor
    public final Object getTopPage() {
        WeakReference<Object> weakReference = this.mTopPage;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private BehaviourLog.Builder getBehaviourBuilder(Object obj, String str, String str2, Map<String, String> map) {
        BehaviourLog.Builder builder = new BehaviourLog.Builder();
        String pageId = TrackerHelper.instance.getPageId(obj);
        builder.setPageId(pageId).setSeedID(str).setBizType(str2).addAllExtParam(map).setLastPage(LoggerFactory.getLogContext().getLastSPMPage());
        LoggerFactory.getLogContext().addSPMPage(pageId);
        return builder;
    }
}
