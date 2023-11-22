package com.alipay.iap.android.aplog.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.api.DeviceIdProvider;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.api.LogEncryptClient;
import com.alipay.iap.android.aplog.api.LogEventType;
import com.alipay.iap.android.aplog.api.Uploader;
import com.alipay.iap.android.aplog.api.abtest.AbtestInfoGetter;
import com.alipay.iap.android.aplog.core.appender.AppenderManager;
import com.alipay.iap.android.aplog.core.appender.LogEvent;
import com.alipay.iap.android.aplog.core.filter.Filter;
import com.alipay.iap.android.aplog.core.filter.LogCustomizeControl;
import com.alipay.iap.android.aplog.core.filter.StrategyManager;
import com.alipay.iap.android.aplog.core.layout.LogLayout;
import com.alipay.iap.android.aplog.core.layout.LogLayoutManager;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.core.uploader.LogThreadPool;
import com.alipay.iap.android.aplog.core.uploader.UploadManager;
import com.alipay.iap.android.aplog.core.uploader.rpc.RpcClient;
import com.alipay.iap.android.aplog.log.BaseLogInfo;
import com.alipay.iap.android.aplog.log.FlushLog;
import com.alipay.iap.android.aplog.log.spm.ISpmMonitor;
import com.alipay.iap.android.aplog.log.spm.SpmMonitor;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import com.alipay.iap.android.aplog.network.NetWorkProvider;
import com.alipay.iap.android.aplog.util.DeviceHWInfo;
import com.alipay.iap.android.aplog.util.ServiceUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.utils.permission.ManifestPermission;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public class LogContextImpl implements LogContext {
    public static final String TAG = "LogContextImpl";
    private AbtestInfoGetter abtestInfoGetter;
    private String appKey;
    private volatile AppendWorker appLogLogAppendWorker;
    private final ArrayBlockingQueue<BaseLogInfo> appLogQueue;
    private String appVersion;
    private String clientID;
    private Context context;
    private Filter filter;
    private String logConfigHost;
    private LogCustomizeControl logCustomizeControl;
    private LogEncryptClient logEncryptClient;
    private String logHost;
    private ContextInfo mContextInfo;
    private RpcClient mRpcClient;
    private volatile AppendWorker monitorLogAppendWorker;
    private final ArrayBlockingQueue<BaseLogInfo> monitorLogQueue;
    private String productID;
    private String sessionID;
    private StrategyManager strategyManager;
    private UploadManager uploadManager;
    private Uploader uploader;
    private String userID;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {12, -73, 84, 57, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 176;
    private Map<String, String> externParamMap = new ConcurrentHashMap();
    private LinkedList<String> autoLogActivity = new LinkedList<>();
    private long aliveInterval = 1800000;
    private LinkedList<String> pages = new LinkedList<>();
    private LinkedList<String> spmPages = new LinkedList<>();
    private String layoutType = "MAS";
    private ISpmMonitor mSpmMonitor = SpmMonitor.INTANCE;
    private boolean mEventQueueFlag = true;
    private DeviceIdProvider deviceIdProvider = new UtdidDeviceIdProvider();
    private AppenderManager appenderManager = AppenderManager.createInstance(this);

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.iap.android.aplog.core.LogContextImpl.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r6 = r6 * 12
            int r6 = 16 - r6
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.LogContextImpl.a(byte, int, int, java.lang.Object[]):void");
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void diagnoseLog(long j, long j2, UploadTaskStatusCallback uploadTaskStatusCallback) {
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void updateLogStrategy(String str) {
    }

    public LogContextImpl(Context context) {
        this.context = context;
        this.mContextInfo = new ContextInfo(context);
        UploadManager.createInstancecreateInstance(context);
        this.uploadManager = UploadManager.getIntance();
        StrategyManager.createInstance(context);
        StrategyManager strategyManager = StrategyManager.getInstance();
        this.strategyManager = strategyManager;
        setFilter(strategyManager);
        NetWorkProvider.createInstance(context);
        updateTimeZone();
        initExtParam();
        refreshSessionID();
        this.monitorLogQueue = new ArrayBlockingQueue<>(2048);
        this.appLogQueue = new ArrayBlockingQueue<>(2048);
    }

    public static boolean shouldLogCrash() {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = LoggerFactory.getLogContext().getApplicationContext().getSharedPreferences("time", 0);
        if (currentTimeMillis - sharedPreferences.getLong("lastCrashTime", 0L) > 3000) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("lastCrashTime", currentTimeMillis);
            edit.apply();
            return true;
        }
        return false;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public Context getApplicationContext() {
        return this.context;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public LogCustomizeControl getLogCustomizeControl() {
        return this.logCustomizeControl;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogCustomizeControl(LogCustomizeControl logCustomizeControl) {
        this.logCustomizeControl = logCustomizeControl;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setMaxLogSize(int i) {
        this.uploadManager.setMaxUploadFileSize(i);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getProductVersion() {
        if (!TextUtils.isEmpty(this.appVersion)) {
            return this.appVersion;
        }
        return this.mContextInfo.getProductVersion();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void flush() {
        appendLog(new FlushLog("flush"));
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void flush(boolean z) {
        if (z) {
            realAppendLog(new FlushLog("flush"));
        } else {
            flush();
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void flush(String str) {
        appendLog(new FlushLog(LogEventType.CATEGORY_FLUSH_BY_TYPE, str));
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void flush(String str, Bundle bundle) {
        appendLog(new FlushLog(LogEventType.CATEGORY_FLUSH_BY_TYPE, str, bundle));
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void uploadAll() {
        flush();
        upload(LogCategory.LOG_ALIVEREPORT);
        upload(LogCategory.LOG_BEHAVIOUR_AUTO);
        upload(LogCategory.LOG_BEHAVIOUR_MANUAL);
        upload("crash");
        upload("performance");
        upload("exception");
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void upload(String str) {
        upload(str, null);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void upload(String str, String str2) {
        upload(str, str2, null);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void upload(String str, String str2, Bundle bundle) {
        if (LoggerFactory.getProcessInfo().isMainProcess()) {
            Intent intent = new Intent();
            intent.setClassName(this.context, LogContext.TOOLS_SERVICE_CLASS_NAME);
            uploadCoreByStartService(intent, str, str2, bundle);
        } else if (LoggerFactory.getProcessInfo().isToolsProcess()) {
            adjustUploadCoreByCategoryDirectly(str, str2, bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void uploadCoreByStartService(android.content.Intent r8, java.lang.String r9, java.lang.String r10, android.os.Bundle r11) {
        /*
            r7 = this;
            java.lang.String r0 = "LogContextImpl"
            if (r8 != 0) goto L5
            return
        L5:
            android.content.Context r1 = r7.context     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = r1.getPackageName()     // Catch: java.lang.Throwable -> Lf
            r8.setPackage(r1)     // Catch: java.lang.Throwable -> Lf
            goto L17
        Lf:
            r1 = move-exception
            com.alipay.iap.android.aplog.core.logger.TraceLogger r2 = com.alipay.iap.android.aplog.core.LoggerFactory.getInnerTraceLogger()
            r2.error(r0, r1)
        L17:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r7.context
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ".UPLOAD_LOG"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r8.setAction(r1)
            if (r11 == 0) goto L36
            r8.putExtras(r11)
        L36:
            java.lang.String r1 = "logCategory"
            r8.putExtra(r1, r9)
            java.lang.String r1 = "uploadUrl"
            r8.putExtra(r1, r10)
            com.alipay.iap.android.aplog.api.ProcessInfo r1 = com.alipay.iap.android.aplog.core.LoggerFactory.getProcessInfo()
            java.lang.String r1 = r1.getProcessAlias()
            java.lang.String r3 = "invokerProcessAlias"
            r8.putExtra(r3, r1)
            r1 = 1
            r3 = 0
            com.alipay.iap.android.aplog.core.logger.TraceLogger r4 = com.alipay.iap.android.aplog.core.LoggerFactory.getInnerTraceLogger()     // Catch: java.lang.Throwable -> L90
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90
            r5.<init>()     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = "uploadCoreByStartService start, action: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L90
            android.content.Context r6 = r7.context     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> L90
            r5.append(r6)     // Catch: java.lang.Throwable -> L90
            r5.append(r2)     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L90
            r4.debug(r0, r2)     // Catch: java.lang.Throwable -> L90
            android.content.Context r2 = r7.context     // Catch: java.lang.Throwable -> L90
            com.alipay.iap.android.aplog.util.ServiceUtil.startForegroundService(r2, r8)     // Catch: java.lang.Throwable -> L90
            com.alipay.iap.android.aplog.core.logger.TraceLogger r8 = com.alipay.iap.android.aplog.core.LoggerFactory.getInnerTraceLogger()     // Catch: java.lang.Throwable -> L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r2.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "uploadCoreByStartService: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L8e
            r2.append(r1)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8e
            r8.debug(r0, r2)     // Catch: java.lang.Throwable -> L8e
            goto L9b
        L8e:
            r8 = move-exception
            goto L92
        L90:
            r8 = move-exception
            r1 = 0
        L92:
            com.alipay.iap.android.aplog.core.logger.TraceLogger r2 = com.alipay.iap.android.aplog.core.LoggerFactory.getInnerTraceLogger()
            java.lang.String r3 = "uploadCoreByStartService"
            r2.error(r0, r3, r8)
        L9b:
            if (r1 == 0) goto L9e
            return
        L9e:
            r7.asyncUploadCoreByCategoryDirectly(r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.LogContextImpl.uploadCoreByStartService(android.content.Intent, java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void adjustUploadCoreByCategoryDirectly(String str, String str2, Bundle bundle) {
        TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("adjustUploadCoreByCategoryDirectly ");
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            innerTraceLogger.debug(TAG, sb.toString());
            try {
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                Object[] objArr3 = new Object[1];
                a(b4, b4, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b6 = b5;
                Object[] objArr4 = new Object[1];
                a(b5, b6, (byte) (b6 - 1), objArr4);
                if ("main".equalsIgnoreCase(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName())) {
                    asyncUploadCoreByCategoryDirectly(str, str2, bundle);
                } else {
                    syncUploadCoreByCategoryDirectly(str, str2, bundle);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    private void asyncUploadCoreByCategoryDirectly(final String str, final String str2, final Bundle bundle) {
        LoggerFactory.getInnerTraceLogger().debug(TAG, "asyncUploadCoreByCategoryDirectly: begin");
        LogThreadPool.newCachedThreadPool().submit(new Runnable() { // from class: com.alipay.iap.android.aplog.core.LogContextImpl.1
            {
                LogContextImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                LogContextImpl.this.syncUploadCoreByCategoryDirectly(str, str2, bundle);
            }
        }, "LogContextImpl.upload");
    }

    public void syncUploadCoreByCategoryDirectly(String str, String str2, Bundle bundle) {
        TraceLogger innerTraceLogger = LoggerFactory.getInnerTraceLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(LoggerFactory.getProcessInfo().getProcessAlias());
        sb.append(" syncUploadCoreByCategoryDirectly: ");
        sb.append(str);
        innerTraceLogger.debug(TAG, sb.toString());
        boolean z = false;
        boolean z2 = bundle != null && bundle.getBoolean(LogContext.SYNC_ALL_LOG);
        if (!LoggerFactory.getProcessInfo().isMainProcess() && str == null) {
            z = true;
        }
        if (z || z2) {
            try {
                LoggerFactory.getInnerTraceLogger().info(TAG, "sync all log to upload dir...");
                this.uploadManager.syncLog();
            } catch (Throwable th) {
                TraceLogger innerTraceLogger2 = LoggerFactory.getInnerTraceLogger();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("syncUploadCoreByCategoryDirectly, syncLog: ");
                sb2.append(th);
                innerTraceLogger2.error(TAG, sb2.toString());
            }
        }
        try {
            LoggerFactory.getInnerTraceLogger().debug(TAG, "uploadManager.uploadLog");
            this.uploadManager.uploadLog(str, str2, bundle);
        } catch (Throwable th2) {
            TraceLogger innerTraceLogger3 = LoggerFactory.getInnerTraceLogger();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("syncUploadCoreByCategoryDirectly, uploadLog: ");
            sb3.append(th2);
            innerTraceLogger3.error(TAG, sb3.toString(), th2);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void appendLogEvent(LogEvent logEvent) {
        this.appenderManager.appendEvent(logEvent);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getProductID() {
        return this.productID;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setProductID(String str) {
        this.productID = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setConfigRequestTimeSpan(long j) {
        StrategyManager.getInstance().setConfigRequestTimeSpan(j);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getConfigRequestTimeSpan(long j) {
        return StrategyManager.getInstance().getConfigRequestTimeSpan();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getUserID() {
        return this.userID;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setUserID(String str) {
        this.userID = str;
        if (LoggerFactory.getProcessInfo().isMainProcess()) {
            Intent intent = new Intent();
            intent.setClassName(this.context, LogContext.TOOLS_SERVICE_CLASS_NAME);
            intent.setPackage(this.context.getPackageName());
            StringBuilder sb = new StringBuilder();
            sb.append(this.context.getPackageName());
            sb.append(LogContext.ACTION_UPDATE_USERID);
            intent.setAction(sb.toString());
            intent.putExtra("userID", str);
            ServiceUtil.startForegroundService(this.context, intent);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getClientID() {
        return this.clientID;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getDeviceID() {
        try {
            return this.deviceIdProvider.getDeviceId();
        } catch (Exception e) {
            LoggerFactory.getInnerTraceLogger().error(TAG, e);
            return " ";
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getSessionID() {
        return this.sessionID;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void appendLog(BaseLogInfo baseLogInfo) {
        if (baseLogInfo == null) {
            return;
        }
        if (baseLogInfo.getLogCategory().equals("applog")) {
            appendAppLog(baseLogInfo);
        } else {
            appendMonitorLog(baseLogInfo);
        }
    }

    private void appendAppLog(BaseLogInfo baseLogInfo) {
        if (this.appLogLogAppendWorker == null) {
            synchronized (this) {
                if (this.appLogLogAppendWorker == null) {
                    AppendWorker appendWorker = new AppendWorker(this.appLogQueue, 1);
                    appendWorker.setDaemon(true);
                    appendWorker.setName("AppLogAppendWorker");
                    appendWorker.start();
                    setAppLogAppendWorker(appendWorker);
                }
            }
        }
        try {
            if (this.appLogQueue.add(baseLogInfo)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("add log event to queue fail, current size: ");
            sb.append(this.appLogQueue.size());
            throw new RuntimeException(sb.toString());
        } catch (Throwable th) {
            LoggerFactory.getInnerTraceLogger().error(TAG, "appendAppLogEvent", th);
        }
    }

    private void appendMonitorLog(BaseLogInfo baseLogInfo) {
        if (this.monitorLogAppendWorker == null) {
            synchronized (this) {
                if (this.monitorLogAppendWorker == null) {
                    AppendWorker appendWorker = new AppendWorker(this.monitorLogQueue, 0);
                    appendWorker.setDaemon(true);
                    appendWorker.setName("MonitorLogAppendWorker");
                    appendWorker.start();
                    setMonitorLogAppendWorker(appendWorker);
                }
            }
        }
        try {
            if (this.monitorLogQueue.add(baseLogInfo)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("add log event to queue fail, current size: ");
            sb.append(this.monitorLogQueue.size());
            throw new RuntimeException(sb.toString());
        } catch (Throwable th) {
            LoggerFactory.getInnerTraceLogger().error(TAG, "appendMonitorLogEvent", th);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void syncAppendLog(BaseLogInfo baseLogInfo) {
        realAppendLog(baseLogInfo);
    }

    public void realAppendLog(BaseLogInfo baseLogInfo) {
        if (!baseLogInfo.getLogCategory().equals("crash") || shouldLogCrash()) {
            if (baseLogInfo.getLogCategory().equals("flush")) {
                try {
                    this.appenderManager.appendFlushLog((FlushLog) baseLogInfo);
                    return;
                } catch (Exception e) {
                    LoggerFactory.getInnerTraceLogger().error(TAG, e.getMessage());
                    return;
                }
            }
            LogLayout logLayout = LogLayoutManager.getInstance().getLogLayout(baseLogInfo, getLayoutType());
            if (logLayout != null) {
                AppenderManager.getInstance().appendLog(logLayout);
            }
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public LogEncryptClient getLogEncryptClient() {
        return this.logEncryptClient;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogEncryptClient(LogEncryptClient logEncryptClient) {
        this.logEncryptClient = logEncryptClient;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public RpcClient getLogUploadRpcClient() {
        return this.mRpcClient;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogUploadRpcClient(RpcClient rpcClient) {
        this.mRpcClient = rpcClient;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLogHost() {
        return this.logHost;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogHost(String str) {
        this.logHost = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLogConfigHost() {
        return this.logConfigHost;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogConfigHost(String str) {
        this.logConfigHost = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void putBizExternParams(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.externParamMap.put(str, str2);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLanguage() {
        return Locale.getDefault().toString();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public Map<String, String> getBizExternParams() {
        return this.externParamMap;
    }

    private void updateTimeZone() {
        try {
            putBizExternParams(H5GetLogInfoBridge.RESULT_TIMEZONE, TimeZone.getDefault().getID());
        } catch (Throwable th) {
            LoggerFactory.getInnerTraceLogger().error(TAG, th);
        }
    }

    private void initExtParam() {
        Location lastKnownLocation;
        String brandName = DeviceHWInfo.getBrandName();
        if (!TextUtils.isEmpty(brandName)) {
            putBizExternParams(H5GetLogInfoBridge.RESULT_BRAND, brandName);
        }
        int KClassImpl$Data$declaredNonStaticMembers$22 = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
        int KClassImpl$Data$declaredNonStaticMembers$23 = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext(), ManifestPermission.ACCESS_COARSE_LOCATION);
        if (KClassImpl$Data$declaredNonStaticMembers$22 == 0 && KClassImpl$Data$declaredNonStaticMembers$23 == 0) {
            LocationManager locationManager = (LocationManager) getApplicationContext().getSystemService("location");
            if (locationManager.isProviderEnabled("gps") && (lastKnownLocation = locationManager.getLastKnownLocation("gps")) != null) {
                LoggerFactory.getInnerTraceLogger().debug(TAG, "location not null");
                StringBuilder sb = new StringBuilder();
                sb.append(lastKnownLocation.getLatitude());
                putBizExternParams("latitude", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lastKnownLocation.getLongitude());
                putBizExternParams("longitude", sb2.toString());
            }
            LocationListener locationListener = new LocationListener() { // from class: com.alipay.iap.android.aplog.core.LogContextImpl.2
                @Override // android.location.LocationListener
                public void onLocationChanged(Location location) {
                }

                @Override // android.location.LocationListener
                public void onProviderDisabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onProviderEnabled(String str) {
                }

                @Override // android.location.LocationListener
                public void onStatusChanged(String str, int i, Bundle bundle) {
                }

                {
                    LogContextImpl.this = this;
                }
            };
            Location location = null;
            if (locationManager.getAllProviders().contains("network")) {
                try {
                    locationManager.requestLocationUpdates("network", 1000L, 0.0f, locationListener);
                    location = locationManager.getLastKnownLocation("network");
                } catch (Exception e) {
                    LoggerFactory.getInnerTraceLogger().error(TAG, e.getMessage());
                }
            }
            if (location != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(location.getLatitude());
                putBizExternParams("latitude", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(location.getLongitude());
                putBizExternParams("longitude", sb4.toString());
            }
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void refreshSessionID() {
        this.sessionID = UUID.randomUUID().toString();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public Filter getFilter() {
        Filter filter = this.filter;
        return filter == null ? this.strategyManager : filter;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLayoutType() {
        return this.layoutType;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLayoutType(String str) {
        this.layoutType = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void addPage(String str) {
        synchronized (this) {
            if (this.pages == null) {
                this.pages = new LinkedList<>();
            }
            if (this.pages.size() >= 20) {
                this.pages.removeFirst();
            }
            this.pages.add(str);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLastPage() {
        synchronized (this) {
            LinkedList<String> linkedList = this.pages;
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return this.pages.getLast();
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void addSPMPage(String str) {
        synchronized (this) {
            if (this.spmPages == null) {
                this.spmPages = new LinkedList<>();
            }
            if (this.spmPages.size() >= 20) {
                this.spmPages.removeFirst();
            }
            this.spmPages.add(str);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getLastSPMPage() {
        synchronized (this) {
            LinkedList<String> linkedList = this.spmPages;
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return this.spmPages.getLast();
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public LinkedList<String> getAutoLogActivities() {
        return this.autoLogActivity;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void addAutoLogActivity(String str) {
        this.autoLogActivity.add(str);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public Uploader getUploader() {
        return this.uploader;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public long getLogAliveInterval() {
        return this.aliveInterval;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setLogAliveInterval(Long l) {
        this.aliveInterval = l.longValue();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void notifyClientEvent(String str, Object obj) {
        if (str == null) {
            return;
        }
        str.hashCode();
        if (str.equals(LogEventType.ENVENT_GOTOBACKGROUND)) {
            LoggerFactory.getLogContext().flush();
            Bundle bundle = new Bundle();
            bundle.putString("event", LogEventType.ENVENT_GOTOBACKGROUND);
            LoggerFactory.getLogContext().upload("crash", null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_BEHAVIOUR_MANUAL, null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_BEHAVIOUR_AUTO, null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_ALIVEREPORT, null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_SPM, null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_CATEGORY_HIGHAVAIL, null, bundle);
            LoggerFactory.getLogContext().upload(LogCategory.LOG_CATEGORY_APM, null, bundle);
            LoggerFactory.getLogContext().upload("exception", null, bundle);
            LoggerFactory.getLogContext().upload("performance", null, bundle);
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getAppKey() {
        return this.appKey;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setAppKey(String str) {
        this.appKey = str;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public String getReleaseType() {
        return this.mContextInfo.getReleaseType();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setReleaseType(String str) {
        this.mContextInfo.setReleaseType(str);
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void takeDownCrashReport() {
        try {
            Method declaredMethod = Class.forName("com.alipay.iap.android.aplog.core.logger.CrashLogBinder").getDeclaredMethod("takeDown", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e) {
            LoggerFactory.getInnerTraceLogger().error(TAG, TextUtils.isEmpty(e.getMessage()) ? "takeDown crashLog fail" : e.getMessage());
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setSpmMonitor(ISpmMonitor iSpmMonitor) {
        this.mSpmMonitor = iSpmMonitor;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public ISpmMonitor getSpmMonitor() {
        return this.mSpmMonitor;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public boolean isZipAndSevenZip() {
        return StrategyManager.getInstance().isZipAndSevenZip();
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setAbtestInfoGetter(AbtestInfoGetter abtestInfoGetter) {
        this.abtestInfoGetter = abtestInfoGetter;
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public AbtestInfoGetter getAbtestInfoGetter() {
        return this.abtestInfoGetter;
    }

    /* loaded from: classes3.dex */
    public class AppendWorker extends Thread {
        private ArrayBlockingQueue<BaseLogInfo> logQueue;
        private int type;

        public AppendWorker(ArrayBlockingQueue<BaseLogInfo> arrayBlockingQueue, int i) {
            LogContextImpl.this = r1;
            this.logQueue = arrayBlockingQueue;
            this.type = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            StringBuilder sb;
            int priority = Looper.getMainLooper().getThread().getPriority() - 2;
            if (priority < 5) {
                priority = 5;
            }
            setPriority(priority);
            while (LogContextImpl.this.mEventQueueFlag) {
                try {
                    LogContextImpl.this.takeAndSync(this.logQueue);
                } catch (Throwable th) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AppendWorker take: ");
                        sb2.append(th);
                        InstrumentInjector.log_e(LogContextImpl.TAG, sb2.toString());
                        try {
                            int i = this.type;
                            if (i == 0) {
                                LogContextImpl.this.setMonitorLogAppendWorker(null);
                            } else if (i == 1) {
                                LogContextImpl.this.setAppLogAppendWorker(null);
                            }
                            Iterator<BaseLogInfo> it = this.logQueue.iterator();
                            while (it.hasNext()) {
                                BaseLogInfo next = it.next();
                                LogContextImpl.this.realAppendLog(next);
                                this.logQueue.remove(next);
                            }
                            LogContextImpl.this.takeAndSync(null);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            sb = new StringBuilder();
                            sb.append("AppendWorker finally: ");
                            sb.append(th);
                            InstrumentInjector.log_e(LogContextImpl.TAG, sb.toString());
                        }
                    } catch (Throwable th3) {
                        try {
                            int i2 = this.type;
                            if (i2 == 0) {
                                LogContextImpl.this.setMonitorLogAppendWorker(null);
                            } else if (i2 == 1) {
                                LogContextImpl.this.setAppLogAppendWorker(null);
                            }
                            Iterator<BaseLogInfo> it2 = this.logQueue.iterator();
                            while (it2.hasNext()) {
                                BaseLogInfo next2 = it2.next();
                                LogContextImpl.this.realAppendLog(next2);
                                this.logQueue.remove(next2);
                            }
                            LogContextImpl.this.takeAndSync(null);
                        } catch (Throwable th4) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("AppendWorker finally: ");
                            sb3.append(th4);
                            InstrumentInjector.log_e(LogContextImpl.TAG, sb3.toString());
                        }
                        throw th3;
                    }
                }
            }
            try {
                int i3 = this.type;
                if (i3 == 0) {
                    LogContextImpl.this.setMonitorLogAppendWorker(null);
                } else if (i3 == 1) {
                    LogContextImpl.this.setAppLogAppendWorker(null);
                }
                Iterator<BaseLogInfo> it3 = this.logQueue.iterator();
                while (it3.hasNext()) {
                    BaseLogInfo next3 = it3.next();
                    LogContextImpl.this.realAppendLog(next3);
                    this.logQueue.remove(next3);
                }
                LogContextImpl.this.takeAndSync(null);
            } catch (Throwable th5) {
                th = th5;
                sb = new StringBuilder();
                sb.append("AppendWorker finally: ");
                sb.append(th);
                InstrumentInjector.log_e(LogContextImpl.TAG, sb.toString());
            }
        }
    }

    public void takeAndSync(ArrayBlockingQueue<BaseLogInfo> arrayBlockingQueue) throws InterruptedException {
        if (arrayBlockingQueue == null) {
            return;
        }
        realAppendLog(arrayBlockingQueue.take());
        this.mEventQueueFlag = true;
    }

    public void setMonitorLogAppendWorker(AppendWorker appendWorker) {
        synchronized (this) {
            this.monitorLogAppendWorker = appendWorker;
        }
    }

    public void setAppLogAppendWorker(AppendWorker appendWorker) {
        synchronized (this) {
            this.appLogLogAppendWorker = appendWorker;
        }
    }

    @Override // com.alipay.iap.android.aplog.api.LogContext
    public void setDeviceIdProvider(DeviceIdProvider deviceIdProvider) {
        if (deviceIdProvider != null) {
            this.deviceIdProvider = deviceIdProvider;
        }
    }
}
