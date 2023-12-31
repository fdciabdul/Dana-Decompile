package com.alipay.iap.android.aplog.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.ProcessInfo;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class CrashFilterUtils {
    private static final String CRASH_SPLIT = ":";
    private static final String FILTER_PROCESS = ">>> %s <<<";
    public static final String MPAAS_PRODUCT_VERSION = "mPaaSProductVersion";
    private static final String TAG = "CrashFilter";

    private static boolean isTargetProcess(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean find = Pattern.compile(String.format(FILTER_PROCESS, str2)).matcher(str).find();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" call 'isTargetProcess' spend ");
                sb.append(uptimeMillis2 - uptimeMillis);
                traceLogger.info(TAG, sb.toString());
                return find;
            } catch (Throwable th) {
                TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isTargetProcess: ");
                sb2.append(th);
                traceLogger2.error(TAG, sb2.toString());
            }
        }
        return false;
    }

    public static String getProcessAlias(String str) {
        return isTargetProcess(str, LoggerFactory.getProcessInfo().getMainProcessName()) ? "main" : isTargetProcess(str, LoggerFactory.getProcessInfo().getToolsProcessName()) ? ProcessInfo.ALIAS_TOOLS : "unknown";
    }
}
