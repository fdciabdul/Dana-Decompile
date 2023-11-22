package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class o0 {
    public static o0 BuiltInFictitiousFunctionClassFactory;
    public static o0 MyBillsEntityDataFactory;
    public static o0 getAuthRequestContext;
    public ThreadPoolExecutor KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public Runnable KClassImpl$Data$declaredNonStaticMembers$2;

        public a(Runnable runnable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    y.PlaceComponentResult("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements ThreadFactory {
        public final ThreadGroup KClassImpl$Data$declaredNonStaticMembers$2;
        public final AtomicInteger MyBillsEntityDataFactory = new AtomicInteger(1);
        public final String PlaceComponentResult;
        public static final byte[] getAuthRequestContext = {82, -89, -124, -60, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 210;
        public static final AtomicInteger BuiltInFictitiousFunctionClassFactory = new AtomicInteger(1);

        public b() {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                try {
                    byte b = getAuthRequestContext[15];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (getAuthRequestContext[15] - 1);
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    threadGroup = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getThreadGroup();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = threadGroup;
            StringBuilder sb = new StringBuilder();
            sb.append("FormalHASDK-base-");
            sb.append(BuiltInFictitiousFunctionClassFactory.getAndIncrement());
            this.PlaceComponentResult = sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 13
                int r7 = r7 * 7
                int r7 = r7 + 99
                byte[] r0 = com.huawei.hms.hatool.o0.b.getAuthRequestContext
                int r6 = r6 * 12
                int r6 = r6 + 4
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1d
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L37
            L1d:
                r3 = 0
            L1e:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                r3 = r0[r6]
                r5 = r7
                r7 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L37:
                int r8 = r8 + r6
                int r6 = r7 + 1
                int r7 = r8 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.o0.b.a(byte, short, int, java.lang.Object[]):void");
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append(this.MyBillsEntityDataFactory.getAndIncrement());
            return new Thread(threadGroup, runnable, sb.toString(), 0L);
        }
    }

    static {
        new o0();
        new o0();
        getAuthRequestContext = new o0();
        MyBillsEntityDataFactory = new o0();
        BuiltInFictitiousFunctionClassFactory = new o0();
    }

    public static o0 MyBillsEntityDataFactory() {
        return MyBillsEntityDataFactory;
    }

    public static o0 PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static o0 getAuthRequestContext() {
        return getAuthRequestContext;
    }
}
