package com.zoloz.builder.monitor;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.bio.log.BehaviourIdEnum;
import com.alipay.mobile.security.bio.log.VerifyBehavior;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.local.monitorlog.MonitorLogService;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.Thread;
import java.util.Map;

/* loaded from: classes8.dex */
public class ZLZCrashHandler implements Thread.UncaughtExceptionHandler {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {Ascii.EM, 60, 112, -12, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int MyBillsEntityDataFactory = 216;
    private static final String TAG = "ZLZCrashHandler";
    private static ZLZCrashHandler sInstance;
    private boolean isHandleMessage = true;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mOringinalHandler;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r5, byte r6, int r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.zoloz.builder.monitor.ZLZCrashHandler.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 * 15
            int r5 = r5 + 12
            int r6 = r6 * 26
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = r7 + 103
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L1c
            r7 = r6
            r2 = r1
            r3 = -1
            r6 = r5
            r1 = r0
            r0 = r8
            r8 = r7
            goto L39
        L1c:
            r4 = r7
            r7 = r6
            r6 = r4
        L1f:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            if (r2 != r5) goto L2f
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2f:
            r3 = r0[r7]
            r4 = r6
            r6 = r5
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r4
        L39:
            int r7 = r7 + 1
            int r5 = -r5
            int r8 = r8 + r5
            int r5 = r8 + 2
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r4 = r6
            r6 = r5
            r5 = r4
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.builder.monitor.ZLZCrashHandler.a(short, byte, int, java.lang.Object[]):void");
    }

    private void saveErrorMessages(Throwable th) {
    }

    public static ZLZCrashHandler getInstance() {
        if (sInstance == null) {
            synchronized (ZLZCrashHandler.class) {
                if (sInstance == null) {
                    synchronized (ZLZCrashHandler.class) {
                        sInstance = new ZLZCrashHandler();
                    }
                }
            }
        }
        return sInstance;
    }

    private ZLZCrashHandler() {
    }

    public void enable(Context context) {
        this.mContext = context.getApplicationContext();
        if (this != InstrumentInjector.getDefaultUncaughtExceptionHandler()) {
            this.mOringinalHandler = InstrumentInjector.getDefaultUncaughtExceptionHandler();
        }
        InstrumentInjector.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        th.getLocalizedMessage();
        reportCrashInfo(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mOringinalHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            System.exit(0);
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    private void reportCrashInfo(Throwable th) {
        try {
            VerifyBehavior verifyBehavior = new VerifyBehavior();
            verifyBehavior.setSeedID("crash");
            verifyBehavior.getExtParams().put("name", th.getClass().getName());
            verifyBehavior.getExtParams().put("method", th.getStackTrace()[0].getMethodName());
            Map<String, String> extParams = verifyBehavior.getExtParams();
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[36] - 1);
                byte b2 = BuiltInFictitiousFunctionClassFactory[16];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[16];
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 + 1), BuiltInFictitiousFunctionClassFactory[16], objArr2);
                extParams.put("class", cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null));
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (StackTraceElement stackTraceElement2 : th.getStackTrace()) {
                    i++;
                    sb.append(stackTraceElement2.toString());
                    if (i >= 5) {
                        break;
                    }
                }
                verifyBehavior.getExtParams().put("detail", sb.toString());
                MonitorLogService monitorLogService = (MonitorLogService) BioServiceManager.getLocalService(this.mContext, MonitorLogService.class);
                monitorLogService.logBehavior(BehaviourIdEnum.EXCEPTION, verifyBehavior);
                monitorLogService.trigUpload();
                Thread.sleep(1000L);
            } catch (Throwable th2) {
                Throwable cause = th2.getCause();
                if (cause == null) {
                    throw th2;
                }
                throw cause;
            }
        } catch (Exception unused) {
        }
    }

    public void disable() {
        InstrumentInjector.setDefaultUncaughtExceptionHandler(this.mOringinalHandler);
    }
}
