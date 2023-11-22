package com.google.android.gms.internal.measurement;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
final class zzjp {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {3, -83, -69, 19, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 130;
    private final Object zza;
    private final int zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjp(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 105
            byte[] r0 = com.google.android.gms.internal.measurement.zzjp.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r8 = r8 * 15
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
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = -r8
            int r9 = r9 + 1
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.a(byte, byte, byte, java.lang.Object[]):void");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzjp) {
            zzjp zzjpVar = (zzjp) obj;
            return this.zza == zzjpVar.zza && this.zzb == zzjpVar.zzb;
        }
        return false;
    }

    public final int hashCode() {
        try {
            Object[] objArr = {this.zza};
            byte b = BuiltInFictitiousFunctionClassFactory[5];
            Object[] objArr2 = new Object[1];
            a(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[5], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            byte b3 = b2;
            Object[] objArr3 = new Object[1];
            a(b2, b3, b3, objArr3);
            return (((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue() * 65535) + this.zzb;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
