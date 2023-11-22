package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {105, 42, 72, -81, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getAuthRequestContext = 50;
    private static final long serialVersionUID = 1811839108042568751L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0031 -> B:11:0x003b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r5, int r6, short r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 12
            int r5 = 15 - r5
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            byte[] r0 = io.reactivex.internal.schedulers.ScheduledDirectTask.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L1b
            r7 = r5
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L3b
        L1b:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L1f:
            int r2 = r2 + 1
            int r6 = r6 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L31
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L31:
            r3 = r0[r6]
            r4 = r7
            r7 = r6
            r6 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            r8 = r4
        L3b:
            int r5 = r5 + r6
            int r5 = r5 + 2
            r6 = r7
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledDirectTask.b(int, int, short, java.lang.Object[]):void");
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public final /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            this.runner = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                this.runnable.run();
                return null;
            } finally {
                lazySet(FINISHED);
                this.runner = null;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
