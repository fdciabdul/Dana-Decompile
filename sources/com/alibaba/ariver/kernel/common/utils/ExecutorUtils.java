package com.alibaba.ariver.kernel.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes2.dex */
public class ExecutorUtils {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 184;

    /* renamed from: a  reason: collision with root package name */
    private static Handler f6160a = new Handler(Looper.getMainLooper());

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r9 = r9 * 7
            int r9 = r9 + 99
            int r8 = r8 * 12
            int r8 = 16 - r8
            byte[] r0 = com.alibaba.ariver.kernel.common.utils.ExecutorUtils.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r9 = r8
            r3 = r1
            r5 = 0
            r8 = r7
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r9 = r9 + 1
            int r10 = r10 + r7
            int r7 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.ExecutorUtils.b(short, int, int, java.lang.Object[]):void");
    }

    public static void runOnMainAtFrontOfQueue(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            f6160a.postAtFrontOfQueue(runnable);
        }
    }

    public static void postMain(Runnable runnable) {
        f6160a.post(runnable);
    }

    public static void runOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            f6160a.post(runnable);
        }
    }

    public static void runOnMain(Runnable runnable, long j) {
        f6160a.postDelayed(runnable, j);
    }

    public static void removeOnMain(Runnable runnable) {
        f6160a.removeCallbacks(runnable);
    }

    public static void runNotOnMain(ExecutorType executorType, Runnable runnable) {
        if (isMainThread()) {
            execute(executorType, runnable);
        } else {
            runnable.run();
        }
    }

    public static void execute(ExecutorType executorType, Runnable runnable) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(executorType).execute(runnable);
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getScheduledExecutor();
    }

    public static boolean isMainThread() {
        if (!ProcessUtils.isInTestProcess()) {
            return Looper.myLooper() == Looper.getMainLooper();
        }
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr = new Object[1];
            b(b, (byte) (b - 1), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr2 = new Object[1];
            b(b2, b3, (byte) (b3 - 1), objArr2);
            return "main".equals(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String getCurrentScheduleType() {
        return ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getCurrentScheduleType();
    }

    public static boolean currentThreadInArray(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            String currentScheduleType = getCurrentScheduleType();
            for (String str : strArr) {
                if (TextUtils.equals(str, currentScheduleType)) {
                    return true;
                }
            }
        }
        return false;
    }
}
