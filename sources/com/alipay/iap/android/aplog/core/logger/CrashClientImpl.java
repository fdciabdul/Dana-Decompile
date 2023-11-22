package com.alipay.iap.android.aplog.core.logger;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.fullstory.instrumentation.InstrumentInjector;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import java.io.File;

/* loaded from: classes6.dex */
public class CrashClientImpl implements ICrashClient {
    @Override // com.uc.crashsdk.export.ICrashClient
    public boolean onAddCrashStats(String str, int i, int i2) {
        return false;
    }

    @Override // com.uc.crashsdk.export.ICrashClient
    public File onBeforeUploadLog(File file) {
        return null;
    }

    @Override // com.uc.crashsdk.export.ICrashClient
    public void onCrashRestarting(boolean z) {
    }

    @Override // com.uc.crashsdk.export.ICrashClient
    public String onGetCallbackInfo(String str) {
        try {
            if (NativeCrashHandlerApi.CAT_LAST_PRODUCT_INFO.equalsIgnoreCase(str)) {
                String productVersion = LoggerFactory.getLogContext().getProductVersion();
                if (!TextUtils.isEmpty(NativeCrashHandlerApi.sLastRunningProductVersion)) {
                    productVersion = NativeCrashHandlerApi.sLastRunningProductVersion;
                }
                String packageCodePath = LoggerFactory.getLogContext().getApplicationContext().getPackageCodePath();
                if (!TextUtils.isEmpty(NativeCrashHandlerApi.sLastCodePath)) {
                    packageCodePath = NativeCrashHandlerApi.sLastCodePath;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("LastRuntimeVersion: ");
                sb.append(productVersion);
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append("\n");
                String obj2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(obj2);
                sb3.append("LastRuntimeCodePath: ");
                sb3.append(packageCodePath);
                return sb3.toString();
            }
            return null;
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn("CrashClientImpl", th);
            return null;
        }
    }

    @Override // com.uc.crashsdk.export.ICrashClient
    public void onLogGenerated(File file, String str) {
        if (file == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("logType: ");
        sb.append(str);
        sb.append(" onLogGenerated = ");
        sb.append(file.getAbsolutePath());
        InstrumentInjector.log_w("CrashClientImpl", sb.toString());
        if (LogType.NATIVE_TYPE.equalsIgnoreCase(str)) {
            ExceptionHandler.getInstance().handleNativeException(file.getAbsolutePath(), str);
        } else if (LogType.UNEXP_TYPE.equalsIgnoreCase(str)) {
            try {
                if (file.exists()) {
                    TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delete on file:");
                    sb2.append(file.getAbsolutePath());
                    sb2.append(" result: ");
                    sb2.append(file.delete());
                    traceLogger.warn("CrashClientImpl", sb2.toString());
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" onLogGenerated but log file not exist.");
                InstrumentInjector.log_w("CrashClientImpl", sb3.toString());
            } catch (Throwable th) {
                LoggerFactory.getTraceLogger().warn("CrashClientImpl", th);
            }
        } else if ("java".equalsIgnoreCase(str)) {
            try {
                if (file.exists()) {
                    TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("delete on file:");
                    sb4.append(file.getAbsolutePath());
                    sb4.append(" result: ");
                    sb4.append(file.delete());
                    traceLogger2.warn("CrashClientImpl", sb4.toString());
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(" onLogGenerated but log file not exist.");
                InstrumentInjector.log_w("CrashClientImpl", sb5.toString());
            } catch (Throwable th2) {
                LoggerFactory.getTraceLogger().warn("CrashClientImpl", th2);
            }
        } else {
            try {
                if (file.exists()) {
                    TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("delete on file:");
                    sb6.append(file.getAbsolutePath());
                    sb6.append(" result: ");
                    sb6.append(file.delete());
                    traceLogger3.warn("CrashClientImpl", sb6.toString());
                    return;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append(" onLogGenerated but log file not exist.");
                InstrumentInjector.log_w("CrashClientImpl", sb7.toString());
            } catch (Throwable th3) {
                LoggerFactory.getTraceLogger().warn("CrashClientImpl", th3);
            }
        }
    }
}
