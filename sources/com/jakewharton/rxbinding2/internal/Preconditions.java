package com.jakewharton.rxbinding2.internal;

import android.os.Looper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposables;

/* loaded from: classes3.dex */
public final class Preconditions {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {107, -40, -73, 40, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 148;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.jakewharton.rxbinding2.internal.Preconditions.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
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
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
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
        L37:
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
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxbinding2.internal.Preconditions.a(short, byte, short, java.lang.Object[]):void");
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static boolean checkMainThread(Observer<?> observer) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            observer.onSubscribe(Disposables.getAuthRequestContext());
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to be called on the main thread but was ");
            try {
                byte b = BuiltInFictitiousFunctionClassFactory[22];
                byte b2 = BuiltInFictitiousFunctionClassFactory[15];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 + 1), BuiltInFictitiousFunctionClassFactory[15], objArr2);
                sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
                observer.onError(new IllegalStateException(sb.toString()));
                return false;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return true;
    }

    private Preconditions() {
        throw new AssertionError("No instances.");
    }
}
