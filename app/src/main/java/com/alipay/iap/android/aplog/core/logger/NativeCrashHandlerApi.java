package com.alipay.iap.android.aplog.core.logger;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.uc.crashsdk.export.CrashApi;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class NativeCrashHandlerApi {
    public static final String CAT_LAST_PRODUCT_INFO = "last product info:";
    public static final String KEY_LAST_RUNTIME_CODE_PATH = "LastRuntimeCodePath";
    public static final String KEY_LAST_RUNTIME_VERSION = "LastRuntimeVersion";

    /* renamed from: a  reason: collision with root package name */
    private static String f6925a = "NativeCrashHandlerApi";
    private static NativeCrashApiGetter b = null;
    private static OnNativeCrashUploadListener c = null;
    private static Map<String, ReportCrashListener> d = null;
    private static volatile int e = -1;
    public static String sLastCodePath = "";
    public static String sLastRunningProductVersion = "";

    /* loaded from: classes6.dex */
    public interface NativeCrashApiGetter {
        CrashApi getCrashApi();
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public interface OnNativeCrashUploadListener {
        @Deprecated
        void onUpload(String str);
    }

    /* loaded from: classes6.dex */
    public interface ReportCrashListener {
        Object onReportCrash(String str, String str2, String str3, String str4, boolean z);
    }

    public static void setNewInstall() {
        CrashApi crashApi = getCrashApi();
        if (crashApi != null) {
            crashApi.setNewInstall();
            LoggerFactory.getTraceLogger().info(f6925a, "setNewInstall");
            return;
        }
        LoggerFactory.getTraceLogger().info(f6925a, "setNewInstall failed, crashApi is null");
    }

    public static void setForeground(boolean z) {
        CrashApi crashApi = getCrashApi();
        if (crashApi != null) {
            if (z && e == 1) {
                return;
            }
            if (!z && e == 0) {
                return;
            }
            crashApi.setForeground(z);
            if (z) {
                e = 1;
            } else {
                e = 0;
            }
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            String str = f6925a;
            StringBuilder sb = new StringBuilder();
            sb.append("setForeground: ");
            sb.append(z);
            traceLogger.info(str, sb.toString());
        } else {
            LoggerFactory.getTraceLogger().info(f6925a, "setForeground failed, crashApi is null");
        }
        LoggerFactory.getTraceLogger().info(f6925a, "flush applog");
        LoggerFactory.getTraceLogger().info(f6925a, "flush applog done");
    }

    public static void onExit() {
        CrashApi crashApi = getCrashApi();
        if (crashApi != null) {
            if (e == 2) {
                return;
            }
            crashApi.onExit();
            e = 2;
            LoggerFactory.getTraceLogger().info(f6925a, "onExit");
        } else {
            LoggerFactory.getTraceLogger().info(f6925a, "onExit failed, crashApi is null");
        }
        LoggerFactory.getTraceLogger().info(f6925a, "flush applog");
        LoggerFactory.getTraceLogger().info(f6925a, "flush applog done");
    }

    public static void setLastRunningProductVersion(String str) {
        sLastRunningProductVersion = str;
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        String str2 = f6925a;
        StringBuilder sb = new StringBuilder();
        sb.append("setLastRunningProductVersion: ");
        sb.append(sLastRunningProductVersion);
        traceLogger.info(str2, sb.toString());
    }

    public static void setLastCodePath(String str) {
        sLastCodePath = str;
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        String str2 = f6925a;
        StringBuilder sb = new StringBuilder();
        sb.append("setLastCodePath: ");
        sb.append(sLastCodePath);
        traceLogger.info(str2, sb.toString());
    }

    public static boolean addCrashHeadInfo(String str, String str2) {
        NativeCrashApiGetter nativeCrashApiGetter = b;
        if (nativeCrashApiGetter != null) {
            CrashApi crashApi = nativeCrashApiGetter.getCrashApi();
            if (crashApi != null) {
                crashApi.addHeaderInfo(str, str2);
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                String str3 = f6925a;
                StringBuilder sb = new StringBuilder();
                sb.append("addCrashHeadInfo success, key: ");
                sb.append(str);
                traceLogger.info(str3, sb.toString());
                return true;
            }
            TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
            String str4 = f6925a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("addCrashHeadInfo failed, CrashApi is null, key: ");
            sb2.append(str);
            traceLogger2.warn(str4, sb2.toString());
            return false;
        }
        TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
        String str5 = f6925a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("addCrashHeadInfo failed, crashGetter is null, key: ");
        sb3.append(str);
        traceLogger3.warn(str5, sb3.toString());
        return false;
    }

    public static CrashApi getCrashApi() {
        NativeCrashApiGetter nativeCrashApiGetter = b;
        if (nativeCrashApiGetter != null) {
            CrashApi crashApi = nativeCrashApiGetter.getCrashApi();
            if (crashApi != null) {
                return crashApi;
            }
            LoggerFactory.getTraceLogger().info(f6925a, "getCrashApi failed, api is null");
            return null;
        }
        LoggerFactory.getTraceLogger().warn(f6925a, "getCrashApi failed, crashGetter is null");
        return null;
    }

    public static void setOnNativeCrashUploadListener(OnNativeCrashUploadListener onNativeCrashUploadListener) {
        c = onNativeCrashUploadListener;
    }

    public static NativeCrashApiGetter getCrashGetter() {
        return b;
    }

    public static void setCrashGetter(NativeCrashApiGetter nativeCrashApiGetter) {
        b = nativeCrashApiGetter;
    }

    private static void a() {
        if (d != null) {
            return;
        }
        synchronized (NativeCrashHandlerApi.class) {
            if (d != null) {
                return;
            }
            d = new LinkedHashMap();
        }
    }

    public static boolean putReportCrashListener(String str, ReportCrashListener reportCrashListener) {
        if (reportCrashListener == null || TextUtils.isEmpty(str)) {
            return false;
        }
        a();
        if (d.containsKey(str)) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            String str2 = f6925a;
            StringBuilder sb = new StringBuilder();
            sb.append("putReportCrashListener, exist: ");
            sb.append(str);
            traceLogger.warn(str2, sb.toString());
            return false;
        }
        d.put(str, reportCrashListener);
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        String str3 = f6925a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("putReportCrashListener: ");
        sb2.append(str);
        traceLogger2.info(str3, sb2.toString());
        return true;
    }

    public static boolean removeReportCrashListener(String str) {
        if (d == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (d.remove(str) == null) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            String str2 = f6925a;
            StringBuilder sb = new StringBuilder();
            sb.append("removeReportCrashListener, not exist: ");
            sb.append(str);
            traceLogger.warn(str2, sb.toString());
            return false;
        }
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        String str3 = f6925a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("removeReportCrashListener: ");
        sb2.append(str);
        traceLogger2.info(str3, sb2.toString());
        return true;
    }

    public static void onReportCrash(String str, String str2, String str3, boolean z) {
        long currentTimeMillis;
        LoggerFactory.getTraceLogger().info(f6925a, "onReportCrash");
        if (c != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                c.onUpload(str);
                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                String str4 = f6925a;
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis2);
                sb.append(" spend, OnNativeCrashUploadListener.onUpload");
                traceLogger.info(str4, sb.toString());
            } catch (Throwable th) {
                long currentTimeMillis3 = System.currentTimeMillis();
                TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                String str5 = f6925a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(currentTimeMillis3 - currentTimeMillis2);
                sb2.append(" spend, OnNativeCrashUploadListener.onUpload");
                traceLogger2.error(str5, sb2.toString(), th);
            }
        }
        Map<String, ReportCrashListener> map = d;
        if (map == null || map.size() <= 0) {
            return;
        }
        long currentTimeMillis4 = System.currentTimeMillis();
        for (Map.Entry<String, ReportCrashListener> entry : d.entrySet()) {
            String key = entry.getKey();
            try {
                entry.getValue().onReportCrash(key, str, str2, str3, z);
                currentTimeMillis = System.currentTimeMillis();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
                String str6 = f6925a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(currentTimeMillis - currentTimeMillis4);
                sb3.append(" spend, ReportCrashListener.onReportCrash: ");
                sb3.append(key);
                traceLogger3.info(str6, sb3.toString());
            } catch (Throwable th3) {
                th = th3;
                currentTimeMillis4 = currentTimeMillis;
                currentTimeMillis = System.currentTimeMillis();
                TraceLogger traceLogger4 = LoggerFactory.getTraceLogger();
                String str7 = f6925a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(currentTimeMillis - currentTimeMillis4);
                sb4.append(" spend, ReportCrashListener.onReportCrash: ");
                sb4.append(key);
                traceLogger4.error(str7, sb4.toString(), th);
                currentTimeMillis4 = currentTimeMillis;
            }
            currentTimeMillis4 = currentTimeMillis;
        }
    }
}
