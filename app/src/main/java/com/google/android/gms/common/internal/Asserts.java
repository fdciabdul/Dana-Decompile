package com.google.android.gms.common.internal;

import android.os.Looper;
import com.fullstory.instrumentation.InstrumentInjector;
import javax.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes7.dex */
public final class Asserts {
    public static final byte[] MyBillsEntityDataFactory = {116, -27, -60, 115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getAuthRequestContext = 181;

    private Asserts() {
        throw new AssertionError("Uninstantiable");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 7
            int r8 = r8 + 99
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = com.google.android.gms.common.internal.Asserts.MyBillsEntityDataFactory
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.Asserts.a(short, int, int, java.lang.Object[]):void");
    }

    public static void checkMainThread(String str) {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            Object[] objArr = new Object[1];
            a((byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[22], MyBillsEntityDataFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = MyBillsEntityDataFactory[15];
            byte b2 = (byte) (-b);
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr2);
            if (thread == cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                return;
            }
            try {
                Object[] objArr3 = new Object[1];
                a((byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[22], MyBillsEntityDataFactory[15], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b3 = MyBillsEntityDataFactory[15];
                byte b4 = (byte) (-b3);
                Object[] objArr4 = new Object[1];
                a(b3, b4, (byte) (b4 + 1), objArr4);
                String valueOf = String.valueOf(cls2.getMethod((String) objArr4[0], null).invoke(null, null));
                String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
                StringBuilder sb = new StringBuilder();
                sb.append("checkMainThread: current thread ");
                sb.append(valueOf);
                sb.append(" IS NOT the main thread ");
                sb.append(valueOf2);
                sb.append("!");
                InstrumentInjector.log_e("Asserts", sb.toString());
                throw new IllegalStateException(str);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    public static void checkNotMainThread(String str) {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            Object[] objArr = new Object[1];
            a((byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[22], MyBillsEntityDataFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = MyBillsEntityDataFactory[15];
            byte b2 = (byte) (-b);
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr2);
            if (thread != cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                return;
            }
            try {
                Object[] objArr3 = new Object[1];
                a((byte) (MyBillsEntityDataFactory[15] - 1), MyBillsEntityDataFactory[22], MyBillsEntityDataFactory[15], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b3 = MyBillsEntityDataFactory[15];
                byte b4 = (byte) (-b3);
                Object[] objArr4 = new Object[1];
                a(b3, b4, (byte) (b4 + 1), objArr4);
                String valueOf = String.valueOf(cls2.getMethod((String) objArr4[0], null).invoke(null, null));
                String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
                StringBuilder sb = new StringBuilder();
                sb.append("checkNotMainThread: current thread ");
                sb.append(valueOf);
                sb.append(" IS the main thread ");
                sb.append(valueOf2);
                sb.append("!");
                InstrumentInjector.log_e("Asserts", sb.toString());
                throw new IllegalStateException(str);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void checkNull(@Nullable Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    public static void checkNull(@Nullable Object obj, Object obj2) {
        if (obj != null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
