package com.alipay.iap.android.aplog.core.filter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.appender.AppenderManager;
import com.alipay.iap.android.aplog.core.appender.DiagnoseLogAppender;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.network.NetWorkProvider;
import com.alipay.iap.android.aplog.util.CommonUtils;
import com.alipay.iap.android.common.config.ConfigProxy;
import com.alipay.iap.android.common.config.ISectionConfigChangeListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class StrategyManager implements Filter {
    public static final String ACTION_TYPE_MDAPUPLOAD = "mdapupload";
    private static long CURRENT_REQUEST_TIME_SPAN = 0;
    private static long DEFAULT_REQUEST_TIME_SPAN = 0;
    private static final String DIAGNOSE_LOG_CONFIG = "diagnosticConfig";
    private static final int DISABLE_TOOLS_PROCESS_NO = 1;
    private static final int DISABLE_TOOLS_PROCESS_YES = 2;
    private static final int ENABLE_NOLOCK_LOG_NO = 2;
    private static final int ENABLE_NOLOCK_LOG_YES = 1;
    private static final int ENABLE_TRAFFIC_LIMIT_NO = 2;
    private static final int ENABLE_TRAFFIC_LIMIT_YES = 1;
    private static final String IAPLOG_SECTION_CONFIG = "IAPLogConfig";
    private static final String JSON_DATA_CONTENT = "content";
    private static final String KEY_CURRENT_REQUEST_TIMESPAN = "CurrentRequestTimeSpan";
    private static final String KEY_DISABLE_TOOLS_PROCESS = "DisableToolsProcess";
    private static final String KEY_ENABLE_NOLOCK_LOG = "Disable_NoLock_Log";
    private static final String KEY_ENABLE_TRAFFIC_LIMIT = "EnableTrafficLimit";
    private static final String KEY_POSITIVE_DIAGNOSE = "PositiveDiagnose";
    private static final String KEY_PREVIOUS_REQUEST_TIME = "PreviousRequestTime";
    private static final String KEY_STRATEG_CONFIG_CONTENT = "StrategConfigContent2nd";
    private static final String KEY_ZIP_AND_SEVENZIP = "ZipAndSevenZip";
    private static final int PERFORMANCE_THRESHOLD = 10;
    private static final int POSITIVE_DIAGNOSE_ALL = 3;
    private static final int POSITIVE_DIAGNOSE_NO = 1;
    private static final int POSITIVE_DIAGNOSE_WIFI = 2;
    private static final String REQUEST_URL_SUFFIX = "/loggw/logConfig.do";
    private static final String SP_NAME_LOGSTRATEGY_CONFIG = "LogStrategyConfig";
    public static final String TAG = "StrategyManager";
    private static final String UPLOAD_STRATEGY = "uploadStrategy";
    private static final int ZIP_AND_SEVENZIP_NO = 1;
    private static final int ZIP_AND_SEVENZIP_YES = 2;
    private static StrategyManager strategyManager;
    private Context context;
    private int disableNoLockLog;
    private int disableToolsProcessTag;
    private int enableTrafficLimitTag;
    private int positiveDiagnoseTag;
    private int zipAndSevenZipTag;
    private static final long REQUEST_TWICE_SPAN = TimeUnit.SECONDS.toMillis(5);
    private static final long MAXIMAL_REQUEST_TIME_SPAN = TimeUnit.HOURS.toMillis(1);
    public static long MINIMUM_REQUEST_TIME_SPAN = TimeUnit.MINUTES.toMillis(3);
    private boolean performanceLogEnable = false;
    private RealTimeConfig realTimeConfig = new RealTimeConfig();
    private Map<String, LogStrategyInfo> strategyDataMap = new ConcurrentHashMap();
    private int retryCount = 0;

    static /* synthetic */ int access$008(StrategyManager strategyManager2) {
        int i = strategyManager2.retryCount;
        strategyManager2.retryCount = i + 1;
        return i;
    }

    static {
        long millis = TimeUnit.MINUTES.toMillis(30L);
        DEFAULT_REQUEST_TIME_SPAN = millis;
        CURRENT_REQUEST_TIME_SPAN = millis;
    }

    /* loaded from: classes6.dex */
    class DiagnoseConfig {
        static final String cleaningFileSize = "cleaningFileSize";
        static final String cleaningRate = "cleaningRate";
        static final String outdate = "outdate";

        private DiagnoseConfig() {
            StrategyManager.this = r1;
        }
    }

    private StrategyManager(Context context) {
        this.context = context;
        fetchLogConfig();
    }

    private void handleIapLogConfigRetry() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alipay.iap.android.aplog.core.filter.StrategyManager.1
            {
                StrategyManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                StrategyManager.access$008(StrategyManager.this);
                StrategyManager.this.handleIapLogConfig();
            }
        }, 1500L);
    }

    private void fetchLogConfig() {
        ConfigProxy.getInstance().addSectionConfigChangeListener(IAPLOG_SECTION_CONFIG, new ISectionConfigChangeListener() { // from class: com.alipay.iap.android.aplog.core.filter.StrategyManager.2
            {
                StrategyManager.this = this;
            }

            @Override // com.alipay.iap.android.common.config.ISectionConfigChangeListener
            public void onSectionConfigChange(String str, String str2) {
                try {
                    if (TextUtils.isEmpty(str2) || !str.equals(StrategyManager.IAPLOG_SECTION_CONFIG)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    StrategyManager.this.handleConfigData(jSONObject.getString(StrategyManager.UPLOAD_STRATEGY));
                    StrategyManager.this.handleDiagnoseConfig(jSONObject.getJSONObject(StrategyManager.DIAGNOSE_LOG_CONFIG));
                } catch (JSONException e) {
                    LoggerFactory.getTraceLogger().error(StrategyManager.TAG, CommonUtils.getExceptionMessage(e, "parseLogStrategy JSONException"));
                }
            }
        });
        handleIapLogConfig();
    }

    public void handleIapLogConfig() {
        try {
            String sectionConfig = ConfigProxy.getInstance().getSectionConfig(IAPLOG_SECTION_CONFIG);
            if (TextUtils.isEmpty(sectionConfig)) {
                if (this.retryCount <= 0) {
                    handleIapLogConfigRetry();
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject(sectionConfig);
            handleConfigData(jSONObject.getString(UPLOAD_STRATEGY));
            handleDiagnoseConfig(jSONObject.getJSONObject(DIAGNOSE_LOG_CONFIG));
        } catch (JSONException e) {
            LoggerFactory.getTraceLogger().error(TAG, CommonUtils.getExceptionMessage(e, "parseLogStrategy JSONException"));
        }
    }

    public void handleDiagnoseConfig(JSONObject jSONObject) {
        DiagnoseLogAppender diagnoseLogAppender = AppenderManager.getInstance().getDiagnoseLogAppender();
        if (jSONObject == null || diagnoseLogAppender == null) {
            return;
        }
        diagnoseLogAppender.setExpiredSize(jSONObject.optInt("cleaningFileSize"));
        diagnoseLogAppender.setExpiredTime(jSONObject.optInt("outdate"));
        diagnoseLogAppender.setCleaningRate(jSONObject.optDouble("cleaningRate"));
    }

    public void handleConfigData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("content")) {
                LoggerFactory.getTraceLogger().info(TAG, "syncRequestLogConfig: has configs");
                parseLogStrategy(jSONObject.getString("content"));
            }
        } catch (JSONException e) {
            LoggerFactory.getTraceLogger().error(TAG, CommonUtils.getExceptionMessage(e, "FormatConfig JSONException"));
        }
    }

    public static StrategyManager createInstance(Context context) {
        if (strategyManager == null) {
            strategyManager = new StrategyManager(context);
        }
        return strategyManager;
    }

    public static StrategyManager getInstance() {
        StrategyManager strategyManager2 = strategyManager;
        if (strategyManager2 != null) {
            return strategyManager2;
        }
        throw new IllegalStateException("need createInstance before use");
    }

    public boolean isLogUpload(String str, int i) {
        int i2;
        if (LogCategory.LOG_BEHAVIOUR_MANUAL.equals(str) || LogCategory.LOG_BEHAVIOUR_AUTO.equals(str)) {
            i2 = 50;
        } else if (LogCategory.LOG_ALIVEREPORT.equals(str) || "crash".equals(str)) {
            i2 = 1;
        } else {
            i2 = (LogCategory.LOG_CATEGORY_HIGHAVAIL.equals(str) || LogCategory.LOG_CATEGORY_APM.equals(str)) ? 10 : 100;
        }
        LogStrategyInfo logStrategyInfo = this.strategyDataMap.get(str);
        if (logStrategyInfo != null && logStrategyInfo.threshold > 0) {
            i2 = logStrategyInfo.threshold;
        }
        return i >= i2;
    }

    public boolean needEncrypt(String str) {
        LogStrategyInfo logStrategyInfo;
        if (TextUtils.isEmpty(str) || (logStrategyInfo = this.strategyDataMap.get(str)) == null) {
            return false;
        }
        TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(" needEncrypt ");
        sb.append(logStrategyInfo.isEncrypt);
        innerTraceLogger.debug(TAG, sb.toString());
        return logStrategyInfo.isEncrypt;
    }

    public String isLogSend(String str, String str2) {
        LogStrategyInfo logStrategyInfo;
        String[] split = str.split("_");
        if (split.length < 3) {
            return null;
        }
        String str3 = split[2];
        if (str2 == null || str2.equals(str3)) {
            String currentNetworkType2Str = NetWorkProvider.getInstance().getCurrentNetworkType2Str();
            if ("unknown".equals(currentNetworkType2Str) || (logStrategyInfo = this.strategyDataMap.get(str3)) == null || !logStrategyInfo.hasSendCondition) {
                return str3;
            }
            if (!"4g".equals(currentNetworkType2Str) || logStrategyInfo.sendCondition.contains("4g")) {
                if (!"3g".equals(currentNetworkType2Str) || logStrategyInfo.sendCondition.contains("3g")) {
                    if (!"2g".equals(currentNetworkType2Str) || logStrategyInfo.sendCondition.contains("2g")) {
                        if (!"wifi".equals(currentNetworkType2Str) || logStrategyInfo.sendCondition.contains("wifi")) {
                            return str3;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:458:0x0290 A[Catch: all -> 0x02c9, TRY_LEAVE, TryCatch #23 {all -> 0x02c9, blocks: (B:456:0x028a, B:458:0x0290), top: B:573:0x028a }] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x02be A[Catch: all -> 0x02cf, TryCatch #27 {all -> 0x02cf, blocks: (B:460:0x0296, B:462:0x02a3, B:464:0x02ab, B:467:0x02b5, B:470:0x02be, B:471:0x02c5), top: B:581:0x0296 }] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x02da A[Catch: all -> 0x02e6, TRY_LEAVE, TryCatch #2 {all -> 0x02e6, blocks: (B:475:0x02cf, B:476:0x02d4, B:478:0x02da), top: B:533:0x02cf }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseLogStrategy(java.lang.String r29) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.filter.StrategyManager.parseLogStrategy(java.lang.String):void");
    }

    @Override // com.alipay.iap.android.aplog.core.filter.Filter
    public boolean shouldWrite(String str) {
        LogStrategyInfo logStrategyInfo = this.strategyDataMap.get(str);
        LogWriteInfo logWriteInfo = new LogWriteInfo();
        logWriteInfo.logCategory = str;
        if (LoggerFactory.getLogContext().getLogCustomizeControl() == null || LoggerFactory.getLogContext().getLogCustomizeControl().isLogWrite(logWriteInfo)) {
            if (logStrategyInfo != null) {
                return logStrategyInfo.isWrite;
            }
            return true;
        }
        return false;
    }

    @Override // com.alipay.iap.android.aplog.core.filter.Filter
    public boolean shouldUpload(String str, int i) {
        return isLogUpload(str, i);
    }

    public String getConfigRequestTimeSpan() {
        return String.valueOf(DEFAULT_REQUEST_TIME_SPAN);
    }

    public void setConfigRequestTimeSpan(long j) {
        DEFAULT_REQUEST_TIME_SPAN = j;
    }

    public boolean isZipAndSevenZip() {
        if (this.zipAndSevenZipTag == 0) {
            this.zipAndSevenZipTag = this.context.getSharedPreferences(SP_NAME_LOGSTRATEGY_CONFIG, 4).getInt(KEY_ZIP_AND_SEVENZIP, 1);
        }
        return this.zipAndSevenZipTag == 2;
    }

    public boolean isPerformanceLogEnable() {
        return this.performanceLogEnable;
    }
}
