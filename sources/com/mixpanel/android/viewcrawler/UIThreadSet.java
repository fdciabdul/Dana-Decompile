package com.mixpanel.android.viewcrawler;

import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
class UIThreadSet<T> {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {59, -54, -26, -72, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int scheduleImpl = 168;
    private Set<T> getAuthRequestContext = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r0 = com.mixpanel.android.viewcrawler.UIThreadSet.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            int r7 = r7 + 1
            r1[r3] = r4
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.viewcrawler.UIThreadSet.b(int, short, short, java.lang.Object[]):void");
    }

    public void PlaceComponentResult(T t) {
        try {
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                throw new RuntimeException("Can't add an activity when not on the UI thread");
            }
            this.getAuthRequestContext.add(t);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        try {
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                throw new RuntimeException("Can't remove an activity when not on the UI thread");
            }
            this.getAuthRequestContext.remove(t);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final Set<T> MyBillsEntityDataFactory() {
        try {
            byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
            byte b4 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
            Object[] objArr2 = new Object[1];
            b(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                throw new RuntimeException("Can't remove an activity when not on the UI thread");
            }
            return Collections.unmodifiableSet(this.getAuthRequestContext);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
