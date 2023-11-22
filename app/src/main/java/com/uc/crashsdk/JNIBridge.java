package com.uc.crashsdk;

import android.os.Looper;
import android.os.Process;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class JNIBridge {
    public static final byte[] MyBillsEntityDataFactory = {99, 56, -99, 122, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 18;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r7 = 106 - r7
            byte[] r0 = com.uc.crashsdk.JNIBridge.MyBillsEntityDataFactory
            int r8 = r8 * 12
            int r8 = 27 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
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
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.JNIBridge.a(byte, byte, int, java.lang.Object[]):void");
    }

    public static native boolean nativeAddCachedInfo(String str, String str2);

    public static native int nativeAddCallbackInfo(String str, boolean z, boolean z2, long j);

    public static native int nativeAddDumpFile(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public static native void nativeAddHeaderInfo(String str, String str2);

    public static native void nativeBreakpadInited(String str);

    public static native boolean nativeChangeState(String str, String str2, boolean z);

    public static native void nativeCloseFile(int i);

    public static native void nativeCrash(int i, int i2);

    public static native boolean nativeCreateCachedInfo(String str, int i);

    public static native String nativeDumpThreads(String str);

    public static native int nativeGenerateUnexpLog(long j);

    public static native String nativeGetCallbackInfo(String str, long j);

    public static native String nativeGetNativeBuildseq();

    public static native void nativeInitNative();

    public static native void nativeInstallBreakpad();

    public static native boolean nativeIsCrashing();

    public static native boolean nativeLockFile(int i, boolean z);

    public static native int nativeLog(int i, String str, String str2);

    public static native int nativeOpenFile(String str);

    public static native void nativePrepareUnexpInfos(boolean z);

    public static native void nativeRegisterCurrentThread(String str);

    public static native void nativeReserveFileHandle(int i, int i2);

    public static native void nativeSetCrashCustoms(boolean z, boolean z2, int i, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, int i5, boolean z7);

    public static native void nativeSetCrashLogFileNames(String str, String str2, String str3);

    public static native void nativeSetCrashLogFilesUploaded();

    public static native void nativeSetFolderNames(String str, String str2, String str3, String str4);

    public static native void nativeSetForeground(boolean z);

    public static native void nativeSetLogStrategy(boolean z, boolean z2, long j);

    public static native void nativeSetMobileInfo(String str, String str2, String str3);

    public static native void nativeSetPackageInfo(String str, String str2, String str3);

    public static native void nativeSetProcessNames(String str, String str2);

    public static native void nativeSetProcessType(boolean z);

    public static native void nativeSetVersionInfo(String str, String str2, String str3, String str4);

    public static native void nativeSetZip(boolean z, String str, int i);

    public static native boolean nativeSyncInfo(String str, String str2, long j, long j2);

    public static native boolean nativeSyncStatus(String str, String str2, int i);

    public static native void nativeUninstallBreakpad();

    public static native void nativeUpdateCrashLogNames();

    public static native void nativeUpdateSignals(int i, int i2, int i3);

    public static native void nativeUpdateUnexpInfo(int i);

    private static long getMaxHeapSize() {
        return Runtime.getRuntime().maxMemory();
    }

    private static String getLogFileNamePart1() {
        return f.b();
    }

    private static String getProcessList(String str, String str2) {
        return f.a(str, str2);
    }

    private static String getJavaMemory() {
        return f.c();
    }

    protected static String getCallbackInfo(String str) {
        return a.a(str);
    }

    private static String getJavaStackTrace(Thread thread, int i) {
        if (i != 0 && i == Process.myPid()) {
            thread = Looper.getMainLooper().getThread();
        }
        if (thread != null) {
            try {
                byte b = MyBillsEntityDataFactory[21];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 + 2), (byte) (-MyBillsEntityDataFactory[15]), objArr2);
                return f.a((StackTraceElement[]) cls.getMethod((String) objArr2[0], null).invoke(thread, null), "getJavaStackTrace").toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return null;
    }

    private static void onCrashLogGenerated(String str, boolean z) {
        d.a(str, z ? LogType.NATIVE_TYPE : LogType.UNEXP_TYPE);
        if (z) {
            f.b(true);
        }
    }

    private static void onCrashRestarting() {
        d.a(false);
        r.b();
    }

    private static void addHeaderInfo(String str, String str2) {
        a.a(str, str2);
    }

    private static int registerCurrentThread(String str, int i) {
        return a.a(i, str);
    }

    private static int registerInfoCallback(String str, int i, long j) {
        return a.a(str, i, (Callable<String>) null, j);
    }

    private static int addDumpFile(String str, String str2, boolean z, boolean z2, int i, boolean z3) {
        return a.a(str, str2, z, z2, i, z3);
    }

    private static int createCachedInfo(String str, int i, int i2) {
        return a.a(str, i, i2);
    }

    private static int addCachedInfo(String str, String str2) {
        return a.b(str, str2);
    }

    private static boolean generateCustomLog(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3, String str4, String str5, String str6) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return f.a(stringBuffer, str2, z, z2, z3, z4, z5, a.b(str3), a.b(str4), a.b(str5), str6);
    }

    private static void onKillProcess(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder("onKillProcess. SIG: ");
        sb.append(i2);
        com.uc.crashsdk.a.c.b(sb.toString());
        StringBuilder d = f.d("onKillProcess");
        d.insert(0, String.format(Locale.US, "State in disk: '%s'\n", b.i()));
        d.insert(0, String.format(Locale.US, "SIG: %d, fg: %s, exiting: %s, main process: %s, time: %s\n", Integer.valueOf(i2), Boolean.valueOf(b.o()), Boolean.valueOf(b.l()), Boolean.valueOf(b.s()), f.g()));
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = f.a(i);
        objArr[2] = Integer.valueOf(Process.myPid());
        objArr[3] = f.a(Process.myPid());
        objArr[4] = Integer.valueOf(Process.myTid());
        try {
            byte b = MyBillsEntityDataFactory[21];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a((byte) (-MyBillsEntityDataFactory[15]), (byte) (-MyBillsEntityDataFactory[8]), MyBillsEntityDataFactory[6], objArr3);
            objArr[5] = ((Thread) cls.getMethod((String) objArr3[0], null).invoke(null, null)).getName();
            d.insert(0, String.format(locale, "Kill PID: %d (%s) by pid: %d (%s) tid: %d (%s)\n", objArr));
            String obj = d.toString();
            com.uc.crashsdk.a.c.b(obj);
            com.uc.crashsdk.a.b.a(new File(str), obj.getBytes());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
