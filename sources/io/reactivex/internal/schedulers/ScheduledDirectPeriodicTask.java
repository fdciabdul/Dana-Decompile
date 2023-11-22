package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {44, -51, -23, -10, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getAuthRequestContext = 200;
    private static final long serialVersionUID = 1811839108042568751L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r6 = r6 * 12
            int r6 = r6 + 4
            int r7 = r7 * 7
            int r7 = 106 - r7
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
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r6 = r6 + 1
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask.b(short, int, int, java.lang.Object[]):void");
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask
    public final /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            this.runner = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                this.runnable.run();
                this.runner = null;
            } catch (Throwable th) {
                this.runner = null;
                lazySet(FINISHED);
                RxJavaPlugins.PlaceComponentResult(th);
            }
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }
}
