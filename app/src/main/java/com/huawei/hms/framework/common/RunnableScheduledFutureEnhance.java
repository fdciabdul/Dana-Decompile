package com.huawei.hms.framework.common;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes7.dex */
public class RunnableScheduledFutureEnhance<T> implements RunnableScheduledFuture<T> {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private RunnableScheduledFuture<T> getAuthRequestContext;
    public static final byte[] PlaceComponentResult = {16, -72, -107, 15, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 102;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r9 = r9 * 12
            int r9 = 15 - r9
            byte[] r0 = com.huawei.hms.framework.common.RunnableScheduledFutureEnhance.PlaceComponentResult
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L39
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r9 = r9 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L39:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.RunnableScheduledFutureEnhance.a(short, short, int, java.lang.Object[]):void");
    }

    public RunnableScheduledFutureEnhance(RunnableScheduledFuture<T> runnableScheduledFuture) {
        try {
            byte b = (byte) (-PlaceComponentResult[15]);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[15] + 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-PlaceComponentResult[15]), objArr2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
            this.getAuthRequestContext = runnableScheduledFuture;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // java.util.concurrent.RunnableScheduledFuture
    public boolean isPeriodic() {
        return this.getAuthRequestContext.isPeriodic();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.getAuthRequestContext.getDelay(timeUnit);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.getAuthRequestContext.run();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.getAuthRequestContext.isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.getAuthRequestContext.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.getAuthRequestContext.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return (T) this.getAuthRequestContext.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.getAuthRequestContext.get(j, timeUnit);
    }

    public String getParentName() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        return this.getAuthRequestContext.compareTo(delayed);
    }

    public boolean equals(Object obj) {
        return this.getAuthRequestContext.equals(obj);
    }

    public int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }
}
