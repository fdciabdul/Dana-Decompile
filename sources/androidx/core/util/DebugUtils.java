package androidx.core.util;

import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class DebugUtils {
    public static final byte[] getAuthRequestContext = {105, 42, 72, -81, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 190;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = androidx.core.util.DebugUtils.getAuthRequestContext
            int r9 = r9 + 105
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r7 = r7 * 3
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r9
            r4 = 0
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r7 = r7 + r3
            int r7 = r7 + 2
            int r9 = r9 + 1
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.util.DebugUtils.a(int, byte, int, java.lang.Object[]):void");
    }

    public static void BuiltInFictitiousFunctionClassFactory(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if ((simpleName == null || simpleName.length() <= 0) && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        try {
            Object[] objArr = {obj};
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (getAuthRequestContext[5] + 1);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private DebugUtils() {
    }
}
