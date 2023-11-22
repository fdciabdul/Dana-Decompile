package com.alipay.iap.android.aplog.core.layout.mas;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.layout.mas.MasLog;
import com.alipay.iap.android.aplog.log.behavior.SPMLog;
import com.alipay.iap.android.aplog.util.DeviceUtil;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.alipay.iap.android.aplog.util.NetUtil;

/* loaded from: classes.dex */
public class MasSPMLog implements MasLog<SPMLog> {
    private static final String LOG_MAGIC = "D-VM";
    public static final String TAG = "MasSPMLog";
    protected static final String XPATH_STARTER = "//";
    private LogContext logContext;
    private String logStr;

    public MasSPMLog(LogContext logContext) {
        this.logContext = logContext;
    }

    @Override // com.alipay.iap.android.aplog.core.layout.mas.MasLog
    public String getLayout(SPMLog sPMLog) {
        sPMLog.dealAbTestInfo(sPMLog);
        StringBuilder sb = new StringBuilder();
        sb.append(LOG_MAGIC);
        LoggingUtil.appendParam(sb, LoggingUtil.getNowTime());
        LoggingUtil.appendParam(sb, this.logContext.getProductID());
        LoggingUtil.appendParam(sb, this.logContext.getProductVersion());
        LoggingUtil.appendParam(sb, "2");
        LoggingUtil.appendParam(sb, this.logContext.getDeviceID());
        LoggingUtil.appendParam(sb, this.logContext.getSessionID());
        LoggingUtil.appendParam(sb, this.logContext.getUserID());
        LoggingUtil.appendParam(sb, LogCategory.LOG_SPM);
        LoggingUtil.appendParam(sb, sPMLog.getAbTestInfo());
        LoggingUtil.appendParam(sb, sPMLog.getRefer());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, sPMLog.getSeedID());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, TextUtils.isEmpty(sPMLog.getBizType()) ? "behavior" : sPMLog.getBizType());
        LoggingUtil.appendParam(sb, "c");
        LoggingUtil.appendParam(sb, sPMLog.getRefer());
        if (sPMLog.getBehaviourPageInfo().getEndTime() != null && sPMLog.getBehaviourPageInfo().getStartTime() != null) {
            try {
                LoggingUtil.appendParam(sb, String.valueOf(Long.valueOf(Long.valueOf(sPMLog.getBehaviourPageInfo().getEndTime()).longValue() - Long.valueOf(sPMLog.getBehaviourPageInfo().getStartTime()).longValue())));
            } catch (Exception unused) {
            }
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendExtParam(sb, sPMLog.getExtParam());
        LoggingUtil.appendParam(sb, "-");
        if (sPMLog.getBehaviourPageInfo().getEndTime() != null && sPMLog.getBehaviourPageInfo().getStartTime() != null) {
            try {
                long longValue = Long.valueOf(sPMLog.getBehaviourPageInfo().getEndTime()).longValue();
                long longValue2 = Long.valueOf(sPMLog.getBehaviourPageInfo().getStartTime()).longValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Long.valueOf(longValue - longValue2));
                LoggingUtil.appendParam(sb, sb2.toString());
            } catch (Exception unused2) {
            }
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        LoggingUtil.appendParam(sb, this.logContext.getDeviceID());
        LoggingUtil.appendParam(sb, "-");
        if (sPMLog.getBehaviourPageInfo() != null && sPMLog.getBehaviourPageInfo().getPageID() != null) {
            LoggingUtil.appendParam(sb, sPMLog.getBehaviourPageInfo().getPageID());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        if (sPMLog.getBehaviourPageInfo() != null && sPMLog.getBehaviourPageInfo().getLastPage() != null) {
            LoggingUtil.appendParam(sb, sPMLog.getBehaviourPageInfo().getLastPage());
        } else {
            LoggingUtil.appendParam(sb, "-");
        }
        if (sPMLog.getBehaviourPageInfo() != null && sPMLog.getBehaviourPageInfo().getViewID() != null) {
            LoggingUtil.appendParam(sb, sPMLog.getBehaviourPageInfo().getViewID());
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
        LoggingUtil.appendParam(sb, this.logContext.getAppKey());
        LoggingUtil.appendParam(sb, this.logContext.getLanguage());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getNumCoresOfCPU()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getCPUMaxFreqMHz()));
        LoggingUtil.appendParam(sb, String.valueOf(DeviceUtil.getTotalMem(this.logContext.getApplicationContext())));
        LoggingUtil.appendExtParam(sb, this.logContext.getBizExternParams());
        LoggingUtil.appendParam(sb, "-");
        LoggingUtil.appendParam(sb, LoggingUtil.getResolution());
        LoggingUtil.appendParam(sb, LoggerFactory.getProcessInfo().getProcessAlias());
        LoggingUtil.appendParam(sb, "-");
        sb.append(MasLog.Constant.GAP);
        return sb.toString();
    }
}
