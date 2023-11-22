package com.uc.crashsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes8.dex */
public final class e {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {114, -124, TarHeader.LF_CONTIG, 72, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 206;

    /* renamed from: a  reason: collision with root package name */
    public static String f7720a;
    private static Context b;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 5
            int r7 = r7 + 18
            byte[] r0 = com.uc.crashsdk.e.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 6
            int r6 = 103 - r6
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r6 = r6 + r8
            int r6 = r6 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.c(byte, byte, int, java.lang.Object[]):void");
    }

    public static void a(Context context) {
        if (b != null) {
            com.uc.crashsdk.a.c.b("mContext is existed");
        }
        b = context;
        try {
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[8] - 1);
            byte b3 = b2;
            Object[] objArr = new Object[1];
            c(b2, b3, (byte) (-b3), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr2 = new Object[1];
            c(b4, b4, BuiltInFictitiousFunctionClassFactory[4], objArr2);
            f7720a = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).dataDir;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static Context a() {
        return b;
    }

    public static Object a(String str) {
        return b.getSystemService(str);
    }
}
