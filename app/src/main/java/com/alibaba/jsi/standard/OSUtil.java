package com.alibaba.jsi.standard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class OSUtil {
    public static final String TAG = "jsi";
    public static final byte[] MyBillsEntityDataFactory = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int getAuthRequestContext = 57;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 6
            int r6 = r6 + 97
            byte[] r0 = com.alibaba.jsi.standard.OSUtil.MyBillsEntityDataFactory
            int r7 = r7 * 22
            int r7 = 26 - r7
            int r8 = r8 * 5
            int r8 = 23 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r6 + 1
            int r6 = r8 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.jsi.standard.OSUtil.a(short, byte, byte, java.lang.Object[]):void");
    }

    public static void i(String str) {
        InstrumentInjector.log_i(TAG, str);
    }

    public static void w(String str) {
        InstrumentInjector.log_w(TAG, str);
    }

    public static void e(String str) {
        InstrumentInjector.log_e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getDataDir(Object obj) {
        try {
            byte b = MyBillsEntityDataFactory[41];
            Object[] objArr = new Object[1];
            a(b, (byte) (b + 1), MyBillsEntityDataFactory[41], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext & 7);
            byte b3 = MyBillsEntityDataFactory[41];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr2);
            return ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(obj, null)).dataDir;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getNativeLibDir(Object obj) {
        try {
            byte b = MyBillsEntityDataFactory[41];
            Object[] objArr = new Object[1];
            a(b, (byte) (b + 1), MyBillsEntityDataFactory[41], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext & 7);
            byte b3 = MyBillsEntityDataFactory[41];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr2);
            return ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(obj, null)).nativeLibraryDir;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getPackageName(Object obj) {
        return ((Context) obj).getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getPackageVersionName(Object obj, String str) {
        try {
            return ((Context) obj).getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Throwable unused) {
            return "<unknown>";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object createStringMethodLruBuffer(int i) {
        return new LruCache(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putIntoLruBuffer(Object obj, String str, Method method) {
        ((LruCache) obj).put(str, method);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Method getMethodFromLruBuffer(Object obj, String str) {
        return (Method) ((LruCache) obj).get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBooleanValueFromArgs(Object obj, String str, boolean z) {
        return ((Bundle) obj).getBoolean(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object createHandlerForCurrentThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return new Handler(myLooper);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean handlerInCurrentThread(Object obj) {
        return obj != null && ((Handler) obj).getLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postTask(Object obj, Runnable runnable) {
        ((Handler) obj).post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void postTask(Object obj, Runnable runnable, long j) {
        if (j == 0) {
            ((Handler) obj).post(runnable);
        } else {
            ((Handler) obj).postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeTask(Object obj, Runnable runnable) {
        ((Handler) obj).removeCallbacks(runnable);
    }
}
