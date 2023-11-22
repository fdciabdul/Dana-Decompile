package com.alipay.iap.android.aplog.core.layout.mas;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.alipay.iap.android.aplog.log.behavior.BehaviourLog;
import com.alipay.iap.android.aplog.util.DeviceUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.alipay.iap.android.aplog.util.NetUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes.dex */
public class MasManualBehaviourLog implements MasLog<BehaviourLog> {
    private static final String LOG_MAGIC = "D-VM";
    public static final String TAG = "MasManualBehaviourLog";
    protected static final String XPATH_STARTER = "//";
    private LogContext logContext;

    public MasManualBehaviourLog(LogContext logContext) {
        this.logContext = logContext;
    }

    @Override // com.alipay.iap.android.aplog.core.layout.mas.MasLog
    public String getLayout(BehaviourLog behaviourLog) {
        behaviourLog.dealAbTestInfo(behaviourLog);
        StringBuilder sb = new StringBuilder();
        sb.append(LOG_MAGIC);
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, this.logContext.getProductID());
        LoggingUtil.appendParam(sb, this.logContext.getProductVersion());
        LoggingUtil.appendParam(sb, "2");
        LoggingUtil.appendParam(sb, this.logContext.getDeviceID());
        LoggingUtil.appendParam(sb, this.logContext.getSessionID());
        LoggingUtil.appendParam(sb, this.logContext.getUserID());
        if (!TextUtils.isEmpty(behaviourLog.getBehaviourID())) {
            LoggingUtil.appendParam(sb, behaviourLog.getBehaviourID());
        } else {
            LoggingUtil.appendParam(sb, "event");
        }
        LoggingUtil.appendParam(sb, behaviourLog.getAbTestInfo());
        if (behaviourLog.getBehaviourPageInfo() != null && !TextUtils.isEmpty(behaviourLog.getBehaviourPageInfo().getLastPage())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LoggingUtil.getViewID(behaviourLog.getBehaviourPageInfo().getLastPage()));
            sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb2.append(behaviourLog.getBehaviourPageInfo().getLastPage());
            LoggingUtil.appendParam(sb, sb2.toString());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        if (behaviourLog.getBehaviourPageInfo().getViewID() != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(XPATH_STARTER);
            sb3.append(behaviourLog.getBehaviourPageInfo().getViewID());
            LoggingUtil.appendParam(sb, sb3.toString());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, "-");
        if (behaviourLog.getSeedID() != null) {
            LoggingUtil.appendParam(sb, behaviourLog.getSeedID());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(behaviourLog.getLoggerLevel());
        LoggingUtil.appendParam(sb, sb4.toString());
        LoggingUtil.appendParam(sb, TextUtils.isEmpty(behaviourLog.getBizType()) ? "behavior" : behaviourLog.getBizType());
        LoggingUtil.appendParam(sb, "c");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, behaviourLog.getExtParam());
        LoggingUtil.appendParam(sb, behaviourLog.getSourceID());
        if (behaviourLog.getBehaviourPageInfo().getEndTime() != null && behaviourLog.getBehaviourPageInfo().getStartTime() != null) {
            try {
                long longValue = Long.valueOf(behaviourLog.getBehaviourPageInfo().getEndTime()).longValue();
                long longValue2 = Long.valueOf(behaviourLog.getBehaviourPageInfo().getStartTime()).longValue();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Long.valueOf(longValue - longValue2));
                LoggingUtil.appendParam(sb, sb5.toString());
            } catch (Exception unused) {
            }
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, this.logContext.getDeviceID());
        LoggingUtil.appendParam(sb, "-");
        if (behaviourLog.getBehaviourPageInfo() != null && behaviourLog.getBehaviourPageInfo().getPageID() != null) {
            LoggingUtil.appendParam(sb, behaviourLog.getBehaviourPageInfo().getPageID());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        if (behaviourLog.getBehaviourPageInfo() != null && behaviourLog.getBehaviourPageInfo().getLastPage() != null) {
            LoggingUtil.appendParam(sb, behaviourLog.getBehaviourPageInfo().getLastPage());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        if (behaviourLog.getBehaviourPageInfo() != null && behaviourLog.getBehaviourPageInfo().getViewID() != null) {
            LoggingUtil.appendParam(sb, behaviourLog.getBehaviourPageInfo().getViewID());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "1000");
        LoggingUtil.appendParam(sb, Build.MODEL);
        LoggingUtil.appendParam(sb, Build.VERSION.RELEASE);
        LoggingUtil.appendParam(sb, NetUtil.getNetworkTypeOptimized(this.logContext.getApplicationContext()));
        LoggingUtil.appendParam(sb, this.logContext.getProductVersion());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, this.logContext.getLanguage());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getNumCoresOfCPU()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getCPUMaxFreqMHz()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getTotalMem(this.logContext.getApplicationContext())));
        LoggingUtil.appendExtParam(sb, this.logContext.getBizExternParams());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, LoggingUtil.getResolution());
        LoggingUtil.appendParam(sb, LoggerFactory.getProcessInfo().getProcessAlias());
        LoggingUtil.appendParam(sb, behaviourLog.getSequenceID());
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }
}
