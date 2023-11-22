package io.reactivex.internal.util;

import com.google.common.base.Ascii;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public final class BlockingHelper {
    public static final byte[] MyBillsEntityDataFactory = {Ascii.RS, 119, -63, 113, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 224;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 13
            int r7 = r7 * 7
            int r7 = 106 - r7
            byte[] r0 = io.reactivex.internal.util.BlockingHelper.MyBillsEntityDataFactory
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            int r6 = r6 + 1
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
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.BlockingHelper.a(byte, short, byte, java.lang.Object[]):void");
    }

    private BlockingHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CountDownLatch countDownLatch, Disposable disposable) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            getAuthRequestContext();
            countDownLatch.await();
        } catch (InterruptedException e) {
            disposable.dispose();
            try {
                Object[] objArr = new Object[1];
                a(MyBillsEntityDataFactory[22], (byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = (byte) (-MyBillsEntityDataFactory[15]);
                byte b2 = MyBillsEntityDataFactory[15];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public static void getAuthRequestContext() {
        if (RxJavaPlugins.MyBillsEntityDataFactory()) {
            try {
                Object[] objArr = new Object[1];
                a(MyBillsEntityDataFactory[22], (byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = (byte) (-MyBillsEntityDataFactory[15]);
                byte b2 = MyBillsEntityDataFactory[15];
                Object[] objArr2 = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr2);
                if ((cls.getMethod((String) objArr2[0], null).invoke(null, null) instanceof NonBlockingThread) || RxJavaPlugins.PlaceComponentResult()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempt to block on a Scheduler ");
                    try {
                        Object[] objArr3 = new Object[1];
                        a(MyBillsEntityDataFactory[22], (byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[15], objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                        byte b4 = MyBillsEntityDataFactory[15];
                        Object[] objArr4 = new Object[1];
                        a(b3, b4, (byte) (b4 - 1), objArr4);
                        sb.append(((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getName());
                        sb.append(" that doesn't support blocking operators as they may lead to deadlock");
                        throw new IllegalStateException(sb.toString());
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
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
}
