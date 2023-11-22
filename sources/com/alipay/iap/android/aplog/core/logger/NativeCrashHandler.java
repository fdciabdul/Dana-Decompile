package com.alipay.iap.android.aplog.core.logger;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.NativeCrashHandlerApi;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.iap.android.aplog.util.CrashFilterUtils;
import com.alipay.iap.android.aplog.util.LoggingUtil;
import com.google.common.base.Ascii;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;

/* loaded from: classes6.dex */
public class NativeCrashHandler {
    public static boolean ENABLE_NATIVE_LOG = true;
    public static boolean ENABLE_UNEXP_LOG = false;
    public static boolean ENANBLE_JAVA_LOG = false;
    public static final String FILE_PATH = "app_crash";
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {TarHeader.LF_LINK, 16, -25, 45, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 108;

    /* renamed from: a */
    private static String f6924a;
    private static CrashApi b;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 6
            int r8 = 103 - r8
            int r6 = r6 * 22
            int r6 = 26 - r6
            int r7 = r7 * 5
            int r7 = r7 + 18
            byte[] r0 = com.alipay.iap.android.aplog.core.logger.NativeCrashHandler.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r7 + 1
            int r7 = r9 + (-8)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.logger.NativeCrashHandler.c(byte, short, byte, java.lang.Object[]):void");
    }

    public static final String getPath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f6924a;
        }
        return str;
    }

    public static void initialize(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
            byte b3 = b2;
            Object[] objArr = new Object[1];
            c(b2, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[41];
            byte b5 = b4;
            Object[] objArr2 = new Object[1];
            c(b4, b5, b5, objArr2);
            sb.append(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).dataDir);
            sb.append(File.separator);
            sb.append(FILE_PATH);
            f6924a = sb.toString();
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.mVersion = LoggerFactory.getLogContext().getProductVersion();
            CrashApi createInstance = CrashApi.createInstance(context, b(), versionInfo, new CrashClientImpl(), null, ENANBLE_JAVA_LOG, ENABLE_NATIVE_LOG, ENABLE_UNEXP_LOG);
            b = createInstance;
            createInstance.setCrashLogUploadUrl(null);
            a(context);
            NativeCrashHandlerApi.setCrashGetter(new NativeCrashHandlerApi.NativeCrashApiGetter() { // from class: com.alipay.iap.android.aplog.core.logger.NativeCrashHandler.1
                @Override // com.alipay.iap.android.aplog.core.logger.NativeCrashHandlerApi.NativeCrashApiGetter
                public final CrashApi getCrashApi() {
                    return NativeCrashHandler.b;
                }
            });
            b.addHeaderInfo(CrashFilterUtils.MPAAS_PRODUCT_VERSION, LoggerFactory.getLogContext().getProductVersion());
            if (ENABLE_UNEXP_LOG && LoggerFactory.getProcessInfo().isMainProcess()) {
                b.registerInfoCallback(NativeCrashHandlerApi.CAT_LAST_PRODUCT_INFO, 256);
            }
            LoggerFactory.getTraceLogger().info("NativeCrashHandler", "initialize ok");
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private static CustomInfo b() {
        CustomInfo customInfo = new CustomInfo();
        customInfo.mCrashLogPrefix = CrashCombineUtils.TOMB;
        customInfo.mMaxNativeLogcatLineCount = 1000;
        customInfo.mMaxUnexpLogcatLineCount = 500;
        customInfo.mMaxJavaLogcatLineCount = 1;
        customInfo.mMaxCrashLogFilesCount = 3;
        customInfo.mCrashLogsFolderName = FILE_PATH;
        customInfo.mZipLog = false;
        customInfo.mOmitJavaCrash = false;
        customInfo.mCallJavaDefaultHandler = true;
        customInfo.mUnexpDelayMillSeconds = 5000;
        customInfo.mSyncUploadSetupCrashLogs = false;
        return customInfo;
    }

    private static void a(Context context) {
        try {
            if (LoggingUtil.loadLibrary(context, "crashsdk")) {
                b.crashSoLoaded();
                if (ENABLE_UNEXP_LOG && LoggerFactory.getProcessInfo().isMainProcess()) {
                    new Thread(new Runnable() { // from class: com.alipay.iap.android.aplog.core.logger.NativeCrashHandler.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                Thread.sleep(3000L);
                            } catch (Throwable unused) {
                            }
                            try {
                                NativeCrashHandler.b.setMainProcess();
                            } catch (Throwable th) {
                                LoggerFactory.getTraceLogger().error("NativeCrashHandler", "setMainProcess exception", th);
                            }
                        }
                    }, "prepareCrashInfo").start();
                    return;
                }
                return;
            }
            LoggerFactory.getTraceLogger().error("NativeCrashHandler", "loadLibrary failed");
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().error("NativeCrashHandler", "loadLibrary exception", th);
        }
    }
}
