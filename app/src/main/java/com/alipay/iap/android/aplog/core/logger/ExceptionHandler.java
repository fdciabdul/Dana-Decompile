package com.alipay.iap.android.aplog.core.logger;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.crash.CrashLog;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.Thread;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static ExceptionHandler f6922a;
    private Thread.UncaughtExceptionHandler b;
    private Application c;
    private Runnable d;
    private boolean e;
    private boolean f = false;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.RS, 119, -63, 113, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 162;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 12
            int r7 = r7 + 4
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r0 = com.alipay.iap.android.aplog.core.logger.ExceptionHandler.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = r7 + 1
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.logger.ExceptionHandler.g(short, short, int, java.lang.Object[]):void");
    }

    private ExceptionHandler(final Application application) {
        this.c = application;
        this.d = new Runnable() { // from class: com.alipay.iap.android.aplog.core.logger.ExceptionHandler.1
            @Override // java.lang.Runnable
            public void run() {
                NativeCrashHandler.initialize(application);
                ExceptionHandler.this.b = InstrumentInjector.getDefaultUncaughtExceptionHandler();
                InstrumentInjector.setDefaultUncaughtExceptionHandler(ExceptionHandler.this);
            }
        };
    }

    public static ExceptionHandler createInstance(Application application) {
        ExceptionHandler exceptionHandler;
        synchronized (ExceptionHandler.class) {
            if (f6922a == null) {
                f6922a = new ExceptionHandler(application);
            }
            exceptionHandler = f6922a;
        }
        return exceptionHandler;
    }

    public static ExceptionHandler getInstance() {
        ExceptionHandler exceptionHandler = f6922a;
        if (exceptionHandler != null) {
            return exceptionHandler;
        }
        throw new IllegalStateException("need createInstance befor use");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f = true;
        if (LoggerFactory.getProcessInfo().isMainProcess()) {
            NativeCrashHandler.ENANBLE_JAVA_LOG = true;
            NativeCrashHandler.ENABLE_UNEXP_LOG = true;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            NativeCrashHandler.initialize(this.c);
            this.b = InstrumentInjector.getDefaultUncaughtExceptionHandler();
            InstrumentInjector.setDefaultUncaughtExceptionHandler(this);
        } else if (this.d != null) {
            new Handler(Looper.getMainLooper()).post(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f = false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Throwable th2;
        boolean z;
        if (this.f) {
            CrashLog crashLog = new CrashLog();
            if ("NegligibleThrowable".equals(th.getMessage())) {
                th2 = th.getCause();
                z = true;
            } else {
                th2 = th;
                z = false;
            }
            if (LoggerFactory.getProcessInfo().isMainProcess()) {
                LoggerFactory.getTraceLogger().debug("ExceptionHandler", "enter uncaughtException.");
                if (th2 != null && !z) {
                    crashLog.setEx(th);
                    crashLog.setThreadName(thread.getName());
                    crashLog.putExtParam(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, this.c.getPackageName());
                }
                try {
                    if (a(th)) {
                        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) this.c.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)).getProcessMemoryInfo(new int[]{Process.myPid()});
                        if (processMemoryInfo.length > 0) {
                            Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                            StringBuilder sb = new StringBuilder();
                            sb.append("totalProportional: ");
                            sb.append(Debug.getPss());
                            traceLogger.info("OOMException", sb.toString());
                            TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("dalvikHeapAlloc: ");
                            sb2.append(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
                            traceLogger2.info("OOMException", sb2.toString());
                            TraceLogger traceLogger3 = LoggerFactory.getTraceLogger();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("totalPss: ");
                            sb3.append(memoryInfo.getTotalPss());
                            traceLogger3.info("OOMException", sb3.toString());
                            TraceLogger traceLogger4 = LoggerFactory.getTraceLogger();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("dalvikPss: ");
                            sb4.append(memoryInfo.dalvikPss);
                            traceLogger4.info("OOMException", sb4.toString());
                            TraceLogger traceLogger5 = LoggerFactory.getTraceLogger();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("nativePss: ");
                            sb5.append(memoryInfo.nativePss);
                            traceLogger5.info("OOMException", sb5.toString());
                            TraceLogger traceLogger6 = LoggerFactory.getTraceLogger();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("otherPss: ");
                            sb6.append(memoryInfo.otherPss);
                            traceLogger6.info("OOMException", sb6.toString());
                            new HashMap();
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(Debug.getPss());
                            crashLog.putExtParam("totalProportional", sb7.toString());
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
                            crashLog.putExtParam("dalvikHeapAlloc", sb8.toString());
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(memoryInfo.getTotalPss());
                            crashLog.putExtParam("totalPss", sb9.toString());
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append(memoryInfo.dalvikPss);
                            crashLog.putExtParam("dalvikPss", sb10.toString());
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append(memoryInfo.nativePss);
                            crashLog.putExtParam("nativePss", sb11.toString());
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(memoryInfo.otherPss);
                            crashLog.putExtParam("otherPss", sb12.toString());
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (!TextUtils.isEmpty(crashLog.getStackTrace())) {
                LoggerFactory.getLogContext().syncAppendLog(crashLog);
            }
            LoggerFactory.getLogContext().flush(true);
            th = th2;
        }
        try {
            this.b.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    private boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        while (th != null) {
            if (th instanceof RuntimeException) {
                String message = th.getMessage();
                if (!TextUtils.isEmpty(message) && message.contains("InputChannel is not initialized.")) {
                    return true;
                }
            }
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public void handleNativeException(String str, String str2) {
        if (a(str, str2)) {
            return;
        }
        b(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "ExceptionHandler"
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.app.Application r2 = r8.c
            java.lang.String r3 = "com.alipay.iap.android.aplog.service.LogServiceInToolsProcess"
            r1.setClassName(r2, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.app.Application r3 = r8.c
            java.lang.String r3 = r3.getPackageName()
            r2.append(r3)
            java.lang.String r3 = ".NATIVE_CRASH"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setAction(r2)
            com.alipay.iap.android.aplog.api.ProcessInfo r2 = com.alipay.iap.android.aplog.core.LoggerFactory.getProcessInfo()
            java.lang.String r2 = r2.getProcessAlias()
            java.lang.String r4 = "invokerProcessAlias"
            r1.putExtra(r4, r2)
            java.lang.String r2 = "filePath"
            r1.putExtra(r2, r9)
            java.lang.String r2 = "callStack"
            r1.putExtra(r2, r10)
            r2 = 0
            r4 = 1
            com.alipay.iap.android.aplog.core.logger.TraceLogger r5 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> L86
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r6.<init>()     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = "uploadCoreByStartService start, action: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L86
            android.app.Application r7 = r8.c     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Throwable -> L86
            r6.append(r7)     // Catch: java.lang.Throwable -> L86
            r6.append(r3)     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L86
            r5.debug(r0, r3)     // Catch: java.lang.Throwable -> L86
            android.app.Application r3 = r8.c     // Catch: java.lang.Throwable -> L86
            com.alipay.iap.android.aplog.util.ServiceUtil.startForegroundService(r3, r1)     // Catch: java.lang.Throwable -> L86
            com.alipay.iap.android.aplog.core.logger.TraceLogger r1 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r3.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r5 = "uploadCoreByStartService: "
            r3.append(r5)     // Catch: java.lang.Throwable -> L83
            r3.append(r4)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L83
            r1.debug(r0, r3)     // Catch: java.lang.Throwable -> L83
            r3 = 1
            goto L92
        L83:
            r1 = move-exception
            r3 = 1
            goto L88
        L86:
            r1 = move-exception
            r3 = 0
        L88:
            com.alipay.iap.android.aplog.core.logger.TraceLogger r5 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()
            java.lang.String r6 = "uploadCoreByStartService"
            r5.error(r0, r6, r1)
        L92:
            if (r3 == 0) goto L95
            return r4
        L95:
            r8.b(r9, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.logger.ExceptionHandler.a(java.lang.String, java.lang.String):boolean");
    }

    private void b(String str, String str2) {
        String processAlias = LoggerFactory.getProcessInfo().getProcessAlias();
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
            byte b2 = b;
            Object[] objArr = new Object[1];
            g(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            Object[] objArr2 = new Object[1];
            g(b3, b3, KClassImpl$Data$declaredNonStaticMembers$2[15], objArr2);
            LoggerFactory.getTraceLogger().error("ExceptionHandler", String.format("a native crash occured in [%s] process [%s] thread. callStack: %s, filePath: %s", processAlias, ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName(), str2, str));
            String replaceAll = CrashCombineUtils.UserTrackReport(str, str2).replaceAll("\n", "###");
            CrashLog crashLog = new CrashLog();
            crashLog.setJavaCrash(false);
            crashLog.putExtParam("callStack", str2);
            crashLog.putExtParam(SemanticAttributes.MessagingOperationValues.PROCESS, processAlias);
            crashLog.putExtParam("crashInfo", replaceAll);
            try {
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                byte b5 = b4;
                Object[] objArr3 = new Object[1];
                g(b4, b5, (byte) (b5 - 1), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                Object[] objArr4 = new Object[1];
                g(b6, b6, KClassImpl$Data$declaredNonStaticMembers$2[15], objArr4);
                crashLog.putExtParam("thread", ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
                LoggerFactory.getLogContext().syncAppendLog(crashLog);
                CrashCombineUtils.deleteFileByPath(str);
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
}
